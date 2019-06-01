package com.example.tugasakhir.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tugasakhir.Model.RespondenModel;
import com.example.tugasakhir.R;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterResponden extends RecyclerView.Adapter<AdapterResponden.RespondenHolder>  {

    private List<RespondenModel> rList;
    private Context ctx;

    public AdapterResponden(Context cntxt, List<RespondenModel> rList){
        this.ctx    = ctx;
        this.rList  = rList;
    }

    @Override
    public RespondenHolder onCreateViewHolder( ViewGroup parent, int position) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.respondenlist,parent, false);
        RespondenHolder holder = new RespondenHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(RespondenHolder respondenHolder, int position) {
        RespondenModel rm = rList.get(position);
        respondenHolder.NomorResponden.setText(rm.getNorspnd());
        respondenHolder.NamaResponden.setText(rm.getNama_rspnd());
        respondenHolder.JenisKelamin.setText(rm.getJenis_kelamin());
        respondenHolder.TempatLahir.setText(rm.getTempat_lahir());
        respondenHolder.TanggalLahir.setText(rm.getTgl_lahir());
        respondenHolder.Alamat.setText(rm.getAlamat());
    }

    @Override
    public int getItemCount() {
        return rList.size();
    }

    class RespondenHolder extends RecyclerView.ViewHolder{
        TextView NomorResponden, NamaResponden, JenisKelamin, TempatLahir, TanggalLahir, Alamat;
        RespondenModel rm;
        public RespondenHolder (View v){
            super(v);

            NomorResponden  = (TextView) v.findViewById(R.id.tvNomorResp);
            NamaResponden   = (TextView) v.findViewById(R.id.tvNamaResponden);
            JenisKelamin    = (TextView) v.findViewById(R.id.tvJeka);
            TempatLahir     = (TextView) v.findViewById(R.id.tvTempLahir);
            TanggalLahir    = (TextView) v.findViewById(R.id.tvTglahir);
            Alamat          = (TextView) v.findViewById(R.id.tvAddres);
        }
    }
}
