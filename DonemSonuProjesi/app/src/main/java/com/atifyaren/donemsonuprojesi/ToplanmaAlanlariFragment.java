package com.atifyaren.donemsonuprojesi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.atifyaren.donemsonuprojesi.databinding.FragmentToplanmaAlanlariBinding;
public class ToplanmaAlanlariFragment extends Fragment {

    private FragmentToplanmaAlanlariBinding binding;
    private String[] helpAreas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentToplanmaAlanlariBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        helpAreas = new String[] {
                "Binbirdirek Parkı",
                "İMÇ Parkı",
                "Numune Parkı",
                "Kalburcu Mehmet Parkı",
                "Çemberlitaş Meydanı",
                "Yenicami Meydan Parkı",
                "Şenol Güneş Parkı",
                "Akşemsettin Parkı İ",
                "Koyunbaba Parkı",
                "Yavuz Selim Çocuk Parkı",
                "Ayvansaray Mahkemealtı Parkı",
                "Çarşamba Çukurbostan Parkı",
                "Fatih Anıt Parkı",
                "Fındıkzade Çukurbostan Şehir Parkı",
                "Mehmet Akif Ersoy Parkı",
                "Sultanahmet Meydanı",
                "Edirnekapı Meydanı",
                "Namık Sevik Stadı",
                "Kocamustafapaşa Meydanı",
                "Gülhane Parkı",
                "Karagümrük Stadı",
                "Aksaray Metro İstasyonu",
                "Beyazıt Meydanı",
                "Fatih Camii Avlusu"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, helpAreas);

        binding.helpAreasListview.setAdapter(adapter);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();

        // Başlık metnini güncelleyin
        MainActivity activity = (MainActivity) requireActivity();
        activity.setToolbarTitle("DEPREM YARDIM UYGULAMASI");
    }
}
