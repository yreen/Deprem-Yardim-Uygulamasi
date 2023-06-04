package com.atifyaren.donemsonuprojesi;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.atifyaren.donemsonuprojesi.databinding.FragmentAcilYardimBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AcilYardimFragment extends Fragment {

    private FragmentAcilYardimBinding binding;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private SharedPreferences sharedPreferences;
    private final static int REQUEST_CODE = 100;
    private double latitude, longitude;
    private String address, city, country;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAcilYardimBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        loadUserInfo();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
//        getLastLocation(); // getLastLocation() metodunu önce çağırın
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = binding.editTextFullName.getText().toString();
                String address = binding.editTextAdres.getText().toString();
                String durum = binding.editTextDurum.getText().toString();
                String kisiSayisi = binding.editTextKisiSayisi.getText().toString();
                String phone = binding.editTextPhone.getText().toString();
                String yas = binding.editTextYas.getText().toString();

                String emailBody = "Kişinin Adı Soyadı: " + fullName + "\n" +
                        "Kişinin Telefonu: " + phone + "\n" +
                        "Kişinin Adresi: " + address + "\n" +
                        "Kişinin Durumu: " + durum + "\n" +
                        "Kişinin Yas: " + yas + "\n" +
                        "Kaç kişi olduğu: " + kisiSayisi + "\n" +
                        "Konum: Latitude: " + latitude + ", Longitude: " + longitude;

                sendEmail(emailBody);
            }
        });
    }

//    private void getLastLocation() {
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
//                @Override
//                public void onSuccess(Location location) {
//                    if (location != null) {
//                        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
//                        List<Address> addresses = null;
//                        try {
//                            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                        if (addresses != null && addresses.size() > 0) {
//                            latitude = addresses.get(0).getLatitude();
//                            longitude = addresses.get(0).getLongitude();
//                            address = addresses.get(0).getAddressLine(0);
//                            city = addresses.get(0).getLocality();
//                            country = addresses.get(0).getCountryName();
//                        }
//                    }
//                }
//            });
//        } else {
//            askPermission();
//        }
//    }
//
//    private void askPermission() {
//        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                getLastLocation();
//            } else {
//                Toast.makeText(getActivity(), "İzin Gerekli", Toast.LENGTH_SHORT).show();
//            }
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }

    private void loadUserInfo() {
        String address = sharedPreferences.getString("address", "");
        String age = sharedPreferences.getString("age", "");
        String phone = sharedPreferences.getString("phone", "");
        String fullName = sharedPreferences.getString("fullName", "");
        binding.editTextAdres.setText(address);
        binding.editTextYas.setText(age);
        binding.editTextPhone.setText(phone);
        binding.editTextFullName.setText(fullName);

    }

    private void sendEmail(String emailBody) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                final String username = "sender outlook mail";
                final String password = "sender password";

                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.outlook.com"); // E-posta sağlayıcınıza göre ayarlayın
                props.put("mail.smtp.port", "587"); // E-posta sağlayıcınıza göre ayarlayın

                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });

                try {
                    // E-posta oluşturma
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse("reciever mail"));
                    message.setSubject("Acil Yardım"); // E-posta konusunu buraya girin
                    message.setText(emailBody); // E-posta içeriğini buraya girin

                    // E-postayı gönderme
                    Transport.send(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Toast.makeText(getActivity(), "E-posta başarılı bir şekilde gönderildi.", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Başlık metnini güncelleyin
        MainActivity activity = (MainActivity) requireActivity();
        activity.setToolbarTitle("DEPREM YARDIM UYGULAMASI");
    }
}
