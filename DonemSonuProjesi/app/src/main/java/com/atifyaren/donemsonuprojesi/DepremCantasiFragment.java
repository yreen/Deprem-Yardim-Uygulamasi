package com.atifyaren.donemsonuprojesi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.atifyaren.donemsonuprojesi.databinding.FragmentDepremCantasiBinding;

public class DepremCantasiFragment extends Fragment {

    private FragmentDepremCantasiBinding binding;
    private ChecklistAdapter checklistAdapter;
    private List<CheckListItem> itemList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDepremCantasiBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.checklistRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Kontrol listesi öğelerini oluşturun
        itemList = new ArrayList<>();
        itemList.add(new CheckListItem("En az 72 saat yetebilecek miktarda su"));
        itemList.add(new CheckListItem("En az 72 saat yetebilecek bozulmayan yiyecekler (konserve, bisküvi vb.)"));
        itemList.add(new CheckListItem("İlk yardım çantası"));
        itemList.add(new CheckListItem("Çadır"));
        itemList.add(new CheckListItem("Battaniye"));
        itemList.add(new CheckListItem("Uyku tulumu"));
        itemList.add(new CheckListItem("Yedek pilleri ile beraber kullanışlı bir el feneri"));
        itemList.add(new CheckListItem("Telefonunuzun şarj aleti (taşınabilir ve kablolu)"));
        itemList.add(new CheckListItem("Mevsim şartlarına uygun giysiler (şapka, çorap, yağmurluk, kazak vb.)"));
        itemList.add(new CheckListItem("Bir miktar para"));
        itemList.add(new CheckListItem("Kullandığınız ilaçlar"));
        itemList.add(new CheckListItem("Kalem ve kağıt"));
        itemList.add(new CheckListItem("Çok amaçlı çakı"));
        itemList.add(new CheckListItem("Çakmak"));
        itemList.add(new CheckListItem("Önemli telefon numaralarının bulunduğu defter"));
        itemList.add(new CheckListItem("Hijyen ürünleri"));

        checklistAdapter = new ChecklistAdapter(itemList);
        binding.checklistRecyclerView.setAdapter(checklistAdapter);

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

