package com.example.datasiswa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterSiswa extends BaseAdapter {
    Context context;
    List<Siswa> siswaList;

    public AdapterSiswa(Context context, List<Siswa> siswaList) {
        this.context = context;
        this.siswaList = siswaList;
    }

    @Override
    public int getCount() {
        return siswaList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.activity_siswa_list_layout, null);

        TextView nama_TV = customView.findViewById(R.id.nama_TV);
        TextView nim_TV = customView.findViewById(R.id.nim_TV);
        TextView ipk_TV = customView.findViewById(R.id.ipk_TV);
        TextView fakultas_TV = customView.findViewById(R.id.fakultas_TV);

        nama_TV.setText(siswaList.get(position).getNamaSiswa());
        nim_TV.setText(siswaList.get(position).getNimSiswa());
        ipk_TV.setText(siswaList.get(position).getIpkSiswa());
        fakultas_TV.setText(siswaList.get(position).getFakultasSiswa());

        return customView;
    }
}
