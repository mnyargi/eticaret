package com.example.melik.isbakdeneme;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.preference.PreferenceManager.*;

/**
 * Created by melik on 24.12.2016.
 */

public class AdsFragment extends Fragment {
    FragmentManager fragmentManager;
    ListView listView;
    private LayoutInflater mInflater;
    static ArrayList<String> items;
    public AdsFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.ads_fragment, container, false);
        final ListView listview=(ListView)rootView.findViewById(R.id.listview);
        /*final List<Ilan> ilanlar=new ArrayList<Ilan>();
        Adapter adaptorumuz=new Adapter(this.getActivity(), ilanlar);
        listview.setAdapter(adaptorumuz);

        ilanlar.add(new Ilan("Yazılım test Elemanı","User testi yapabilecek nitelikere sahip test elemanı aranıyor"
                ,"Başarsoft Bilgi Teknolojileri A.Ş","Yazılım"));
        ilanlar.add(new Ilan("Yazılım Geliştirme Uzmanı","-Firmamızın var olan yazılım ekibine dahil olarak, projelerde geliştirici " +
                "olarak rol almak, " +
                "Yazılım dokümantasyonu yapmak, Kullanıcı desteği vermek, Ekip bünyesine katılacak olan yazılımcıların eğitilmesine " +
                "yardımda bulunmak. "
                ,"LTB Jeans","Yazılım"));
        ilanlar.add(new Ilan("Satış Danışmanı ve Kasiyer","Zara, Massimo Dutti, Bershka, Stradivarius, Pull&Bear, Oysho, Zara Home ve " +
                "Uterqüe markalarını bünyesinde barındıran Inditex Group,  dünyada 93 ülkede, 7240'dan fazla mağazasıyla moda akımlarına " +
                "öncülük ediyor. 150.000'den fazla profesyonel çalışanımızlayarattığımız farkın tek bir hedefi var; dünyada milyonlarca " +
                "insanı giydirecek olan modayı yaratmak. Bu heyecan verici ve dinamik çalışma ortamında sizler gibi profesyoneller ile " +
                "çalışmak istiyoruz."
                ,"Zara Tekstil","Tekstil"));
        ilanlar.add(new Ilan("Senior PHP Developer","PHP ve MySQL ile minimum 3 yıl yazılım geliştirmiş,\n" +
                "OOP yaklaşımında ve MVC mimarisinde kod geliştirmiş,\n" +
                "PHP frameworkler üzerinde çalışmalar yapmış,\n" +
                "Ajax, XML, JSON gibi teknolojileri kullanabilen,\n" +
                "HTML, Javascript, CSS, konusunda bilgi sahibi,\n" +
                "Erkek adaylar için askerliğini tamamlamış veya en az 2 yıl tecilli"
                ,"ICM Yazılım Bilişim Danışmanlık ve Tic.Ltd.Şti.","Yazılım"));
        ilanlar.add(new Ilan("Mağaza Yöneticileri","Mağazanın tüm organizasyonundan sorumlu olmak,\n" +
                "Mağaza ekibinin işe alım ,performans yönetimi ve eğitimlerini organize etmek,\n" +
                "Mağazanın satış bütçelerine ulaşması için gerekli aksiyonları almak ve ekibi ile uygulamak,\n" +
                "Müşteri ilişkilerini şirketin çıkarları doğrultusunda yönetmek,\n" +
                "Mağaza imajının en iyi şekilde korunmasını sağlamak,\n" +
                "Operasyon standartlarının tam ve doğru uygulanmasını sağlamak,\n" +
                "Stokları ve satışları yakından takip etmek ve etkin sipariş yönetimi yapılmasını sağlamak."
                ,"Adil Işık Group","Tekstil"));

        ilanlar.add(new Ilan("Asansör Bakım Onarım Elemanı","Müşteri portföyümüzde bulunan asansörlerimizin; \n" +
                "Asansör sistemlerinin periyodik bakımını yapmak,\n" +
                "Asansör sistemlerinin arızasını tespit ederek gidermek,\n" +
                "Periyodik bakım ve arızalarla ilgili raporlamaların yapılması,\n" +
                "Plan doğrultusunda periyodik bakımların yapılmasının sağlanması,\n" +
                "Arızaların günlük olarak takip edilmesi ve giderilmesinin sağlanması,\n" +
                "Tekrar eden arızaların kök sebebini araştırarak, arıza sayılarını/duruş sürelerinin minimize edilmesi için iyileştirme " +
                "faaliyetlerinin yapılması."
                ,"BİRMAK Asansör A.Ş","Asansör"));
        ilanlar.add(new Ilan("CEO Ofis Asistanı","CFO'nun ajanda takibinin ve seyahat organizasyonlarının yapılması, toplantı " +
                "organizasyonlarının yürütülmesi,\n" +
                "CEO asistanının asiste edilmesi, \n" +
                "CEO ofisinin tüm işleyiş ve uygulamalarının yürütülmesinde aktif rol oynamak,\n" +
                "Misafirlerinin karşılanması, ağırlanması ve  gerekli durumlarda ilgili kişilere yönlendirilmesi,\n" +
                "Gerekli hallerde yazışmaların yapılması,\n" +
                "Dosyalama ve periyodik raporlama yapılması."
                ,"GroupM Medya Hizmetleri Ltd. Şti.","Medya"));
        ilanlar.add(new Ilan("Müşteri İlişkileri Sorumlusu","Garenta markalarının tüm çağrı merkezi ve şikayet süreçlerini takip ederek " +
                "ve raporlarının günlük, haftalık, aylık ve yıllık olarak raporlamasını sağlamak,\n" +
                "• Çağrı yanıtlama kalite standartlarını oluşturarak takibini gerçekleştirmek,\n" +
                "• Çağrı merkezi ziyaretlerini gerçekleştirerek ekiplerin ürün bilgilerinin güncelliğini sağlamak ve kontrol mekanizmaları " +
                "oluşturmak,\n" +
                "• Çağrı merkezi ekiplerinin motivasyonlarını ve marka bağlılıklarını arttırmak çalışmalar gerçekleştirmek,\n" +
                "• Çağrı merkezi takım liderlerini marka ihtiyaçları ve vizyonu doğrultusunda yönlendirmek,\n" +
                "• Şikayet rapor sonuçlarına göre aksiyonların alınması için ilgili birimlerle organizasyonu sağlamak, alınan aksiyonların " +
                "hayata geçirilmesinde etkin rol oynayarak sonuçlarını takip etmek,\n" +
                "• Garenta markalarının sosyal medyada verdiği hizmet kalitesini takip ederek markaların ihtiyaçları doğrultusunda sosyal" +
                " medya ekiplerinin yönlendirilmesini sağlamak,\n" +
                "• Garenta markalarının tüm müşteri temas noktalarında hizmet standartını oluşturmak ve bu standartın sağlanıp sağlanmadığının " +
                "kontrolünü gerçekleştirmek,\n" +
                "• Garenta markaları için müşteri memnuniyet çalışmalarının takibi, raporlanması ve sonuçlar üzerinde aksiyonların alınmasını " +
                "sağlamak."
                ,"Çelik Motor Ticaret A.Ş","Otomotiv"));
        ilanlar.add(new Ilan("Ticari Kredi Risk Analitiği Uzmanı","Bankanın tüzel nitelikli müşterilerine ait kredi tahsis, izleme, tahsilat ve " +
                "portföy yönetimi stratejilerinde kullanılacak olan istatistiki modellerin geliştirilmesi ve gelişmiş analitik yöntemlerle veri " +
                "analizlerinin yapılması\n" +
                "- Bankadaki ticari krediler izleme ve tahsilat stratejilerinde kullanılmak üzere istatistiksel ve analitik izleme ve tahsilat " +
                "modellerinin tasarlanması, geliştirilmesi ve uygulamaya alınması\n" +
                "- Bankadaki tüzel nitelikli müşteriler için tahsis, izleme, tahsilat ve portföy yönetimi faaliyetlerinde kullanılacak olan müşteri" +
                " bazlı gelir tahmin modelinin tasarımı, geliştirilmesi ve uygulamaya alınması için çalışmalarda bulunulması\n" +
                "- Banka yurtiçi ve yurtdışı iştiraklerine modelleme konusunda bilgi aktarımı yapılması, kullanılacak modellerin tasarlanması ve" +
                " geliştirilmesi\n" +
                "- Tüm bu modellerin performanslarının takip edilmesi ve gerekli raporların hazırlanması\n" +
                "- Veri sözlüğünün dizayn edilmesi aşamasında ilgili kredi ve satış pazarlama ekipleriyle birebir çalışılması, üretilen verinin" +
                " doğruluğunun kontrol edilmesi, kullanıcı kabul testlerinin ve canlıya geçişlerde performans takibinin yapılması"
                ,"Yapı Kredi","Bankacılık"));
        ilanlar.add(new Ilan("Bilgisayar Öğretmeni","Gelişime ve öğrenmeye açık,\n" +
                "Sürekli öğrenmeyi ilke edinmiş ve yeni teknolojileri takip eden,\n" +
                "Kodlama mantığına hakim ve Sctarch, Arduino, Tinkercad bilen,\n" +
                "Yazılım ve Programlama konusunda kendini yetiştirmiş,\n" +
                "Robotik ve 3D yazıcılar konularına meraklı,\n" +
                "Microsoft işletim sistemleri ve Office uygulamaları konusunda bilgi sahibi,\n" +
                "Bilişim ve Eğitim Teknolojilerine hakim ,\n" +
                "Photoshop, Illustrator vb. tasarım programlarını kullanabilen, görevlendirmek üzere  Bilgisayar Öğretmeni arayışımız bulunmaktadır."
                ,"Bil Okulları","Holding/ Şirketler Grubu"));*/

        final ArrayAdapter<String> adapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.ilan);

        listview.setAdapter(adapter);

        RequestQueue queue = Volley.newRequestQueue(getContext());


        StringRequest sr = new StringRequest(Request.Method.POST, "http://isbakk.tk/makale.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray Ilanlar;
                JSONObject ilan;


                try {

                    JSONObject obj = new JSONObject(response);
                    Ilanlar = obj.getJSONArray("Ilanlar");//json objesine vtden veri çekiyoruz

                    items = new ArrayList<String>();//her bir veriyi diziye atıyoruz
                    for(int i=0; i < Ilanlar.length() ; i++) {
                        ilan = Ilanlar.getJSONObject(i);
                        int id=ilan.getInt("ilan_id");
                        String name=ilan.getString("ilan_baslik");
                        items.add(name);//diziden adaptörle lwe çekilecek
                        Log.d(name,"Output");
                        listview.setAdapter(adapter);
                    }


                    Log.d("My App", obj.toString());

                } catch (Throwable t) {
                    Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Hata Response", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {//kullanmıyoruz ama duracak
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {//kullanmıyoruz ama duracak
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);


        return rootView;
    }


}
