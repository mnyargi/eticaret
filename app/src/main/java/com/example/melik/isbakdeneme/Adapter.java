package com.example.melik.isbakdeneme;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.melik.isbakdeneme.R.id.ilanaciklama;
import static com.example.melik.isbakdeneme.R.id.textView;

/**
 * Created by melik on 31.12.2016.
 */

public class Adapter extends BaseAdapter {

    private LayoutInflater mInflater;
    final List<Ilan> ilanlar=new ArrayList<Ilan>();

    public Adapter(Activity activity, List<Ilan> ilanlar) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        ilanlar = ilanlar;
    }

    @Override
    public int getCount() {
        return ilanlar.size();
    }

    @Override
    public Object getItem(int position) {
        return ilanlar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ilanView;

        ilanView = mInflater.inflate(R.layout.ilan, null);
        TextView ilanAdi =
                (TextView) ilanView.findViewById(R.id.ilanadi);
        TextView ilanAciklama =
                (TextView) ilanView.findViewById(R.id.ilanaciklama);
        TextView isverenAdi =
                (TextView) ilanView.findViewById(R.id.isverenadi);
        TextView kategori =
                (TextView) ilanView.findViewById(R.id.kategori);


        Ilan kisi = ilanlar.get(position);

        isverenAdi.setText((Ilan.getIsverenAdi()));
        ilanAciklama.setText((Ilan.getIlanAciklama()));
        ilanAdi.setText((Ilan.getIlanAdi()));
        kategori.setText((Ilan.getKategori()));


        return ilanView;
    }
}
