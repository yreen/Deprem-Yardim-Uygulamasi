package com.atifyaren.donemsonuprojesi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.atifyaren.donemsonuprojesi.databinding.FragmentBagisBinding;


public class BagisFragment extends Fragment {

    private FragmentBagisBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBagisBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.webView.loadUrl("https://www.hayatadestek.org/");
        WebSettings webSettings = binding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        binding.webView.setWebViewClient(new WebViewClient());

        return view;
    }

    @Override
    public void onDestroyView() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack();
        } else {
            super.onDestroyView();
        }
        binding = null;
    }
    @Override
    public void onResume() {
        super.onResume();

        // Başlık metnini güncelleyin
        MainActivity activity = (MainActivity) requireActivity();
        activity.setToolbarTitle("DEPREM YARDIM UYGULAMASI");
    }
}
