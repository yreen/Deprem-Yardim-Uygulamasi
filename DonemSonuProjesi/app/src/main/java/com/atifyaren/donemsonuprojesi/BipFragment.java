package com.atifyaren.donemsonuprojesi;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atifyaren.donemsonuprojesi.databinding.FragmentBipBinding;


public class BipFragment extends Fragment {

    private FragmentBipBinding binding;
    private MediaPlayer mediaPlayer;
    private boolean isSoundPlaying = false; // Sesin çalıp çalmadığını kontrol etmek için bir bayrak

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBipBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSound();
            }
        });

    }

    private void toggleSound() {
        if (isSoundPlaying) {
            stopSound();
        } else {
            playSound();
        }
    }

    private void playSound() {
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.bipsesi);
        mediaPlayer.start();
        isSoundPlaying = true;
    }

    private void stopSound() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        isSoundPlaying = false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        stopSound();
    }

    @Override
    public void onResume() {
        super.onResume();

        // Başlık metnini güncelleyin
        MainActivity activity = (MainActivity) requireActivity();
        activity.setToolbarTitle("DEPREM YARDIM UYGULAMASI");
    }
}
