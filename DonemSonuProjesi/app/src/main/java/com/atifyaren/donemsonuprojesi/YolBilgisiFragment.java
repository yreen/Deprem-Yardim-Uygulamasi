package com.atifyaren.donemsonuprojesi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.atifyaren.donemsonuprojesi.databinding.FragmentYolBilgisiBinding;
public class YolBilgisiFragment extends Fragment {

    private FragmentYolBilgisiBinding binding;
    private String[] helpAreas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentYolBilgisiBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        helpAreas = new String[] {
                "Karaman-Mut Yolu (Sertavul Geçidi)",
                "Kayseri-Pınarbaşı-Sarız Yolu",
                "Divriği-Arapgir Yolu",
                "Siirt-Eruh Yolu",
                "Hatay-Kırıkhan-Reyhanlı Yolu"
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
