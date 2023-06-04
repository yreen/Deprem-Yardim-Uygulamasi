package com.atifyaren.donemsonuprojesi;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.atifyaren.donemsonuprojesi.databinding.FragmentBilgilerimBinding;
public class BilgilerimFragment extends Fragment {

    private FragmentBilgilerimBinding binding ;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBilgilerimBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInfo();
            }
        });
        loadUserInfo();

        return view;
    }

    private void saveUserInfo() {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fullName", binding.editTextFullName.getText().toString());
        editor.putString("age", binding.editTextYas.getText().toString());
        editor.putString("address", binding.editTextAdres.getText().toString());
        editor.putString("phone", binding.editTextPhone.getText().toString());
        editor.apply();

        Toast.makeText(getContext(), "Bilgiler kaydedildi.", Toast.LENGTH_SHORT).show();
    }

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

    @Override
    public void onResume() {
        super.onResume();

        // Başlık metnini güncelleyin
        MainActivity activity = (MainActivity) requireActivity();
        activity.setToolbarTitle("DEPREM YARDIM UYGULAMASI");
    }
}