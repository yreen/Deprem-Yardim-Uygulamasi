package com.atifyaren.donemsonuprojesi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atifyaren.donemsonuprojesi.databinding.FragmentBilgilendirmeBinding;

public class BilgilendirmeFragment extends Fragment {

    private FragmentBilgilendirmeBinding binding;
    private String bilgiler1 = "ENKAZ ALTINDAYSAK NE YAPMALIYIZ?\n\n" +
            "1. Sakin Kalın: Derin nefes alın ve sakinliğinizi koruyun.\n\n" +
            "2. Hareket Edebiliyorsanız, Kendinizi Koruyun: Sıkışmışsanız veya hareket edemiyorsanız, mümkün olduğunca yerinizde kalmaya çalışın ve korunmak için mümkün olan en iyi pozisyonu alın.\n\n" +
            "3. Çevrenizi İnceleyin: Sarsıntıdan dolayı düşebilecek nesneler veya sizi daha fazla tehlikeye atabilecek başka riskler olup olmadığını gözlemleyin.\n\n" +
            "4. Sinyal Verin: BİP bölümü ile sesinizi duyurmaya çalışın.\n\n" +
            "5. Sesli İletişim Kurun: Yardım ekipleri veya diğer kurtarma ekipleri, sesinizi duyarak konumunuzu tespit edebilir.\n\n" +
            "6. Kıpırdamayın: Enkaz altındayken hareket etmeye çalışmak, yaralanmalara veya enkazın daha fazla çökmesine neden olabilir. Etrafınızdaki kurtarma ekipleri sizi bulup çıkarmadan önce sabırlı olun.\n\n";
    private String bilgiler2 = "!YAKINIZ ENKAZ ALTINDA İSE!\n\n" +
            "1. Yardım Çağırın: Hemen en yakın acil durum numarasını (genellikle 112 veya 911 gibi) arayın ve durumu bildirin.\n\n" +
            "2. Enkaz Altında Olan Kişiyle İletişim Kurun: Enkaz altında olan kişiyle mümkün olduğunca sesli veya diğer iletişim yollarıyla iletişim kurmaya çalışın. Onlara sakin olmalarını, yardımın geleceğini ve size ulaşmaya çalışacaklarını söyleyin.\n\n" +
            "3. Kurtarma Ekiplerine Bilgi Verin: Yardım ekipleri olay yerine ulaştığında, enkaz altındaki kişinin konumunu ve sağlık durumunu en iyi şekilde iletebilmek için kurtarma ekiplerine mümkün olduğunca fazla bilgi verin.\n\n" +
            "4. Güvenli Bir Alan Oluşturun: Yakınınızın enkaz altında olduğu bölgede güvenli bir alan oluşturun. Enkazın daha fazla çökmesini önlemek için etrafı güçlü ve stabil nesnelerle destekleyin.\n\n" +
            "5. Yakınınıza Moral Verin: Enkaz altında olan kişiye moral ve destek vermek önemlidir. Onlara sakin kalmalarını, yardımın geleceğini ve ellerinden gelenin yapıldığını söyleyin.\n\n";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBilgilendirmeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.textView.setText(bilgiler1+bilgiler2);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
