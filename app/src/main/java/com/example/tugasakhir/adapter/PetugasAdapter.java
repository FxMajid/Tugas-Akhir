package com.example.tugasakhir.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tugasakhir.Model.DataModel;
import com.example.tugasakhir.Model.PetugasModel;
import com.example.tugasakhir.R;

import java.util.List;

public class PetugasAdapter extends RecyclerView.Adapter<PetugasAdapter.PetugasHolder> {

    private List<PetugasModel> pList;
    private Context ctxt;

    public PetugasAdapter (Context ctxt, List<PetugasModel> pList){
        this.ctxt   = ctxt;
        this.pList  = pList;
    }

    @Override
    public PetugasHolder onCreateViewHolder(ViewGroup parent, int position) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.petugaslist,parent, false);
        PetugasHolder holder = new PetugasHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(PetugasHolder petugasHolder, int position) {
    PetugasModel pm = pList.get(position);
    petugasHolder.nip.setText(pm.getNip());
    petugasHolder.namapetugas.setText(pm.getNama_ptgs());
    petugasHolder.jk.setText(pm.getJk());
    petugasHolder.tempatlahir.setText(pm.getTempat_lahir());
    petugasHolder.tanggallahir.setText(pm.getTgl_lahir());
    petugasHolder.alamat.setText(pm.getAlamat());
    petugasHolder.jabatan.setText(pm.getJabatan());
    petugasHolder.pm = pm;
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }


    class PetugasHolder extends RecyclerView.ViewHolder{
        TextView nip, namapetugas, jk, tempatlahir, tanggallahir, alamat, jabatan ;
        PetugasModel pm ;
        public PetugasHolder (View v){
            super(v);

            nip             = (TextView) v.findViewById(R.id.tvNipetugas);
            namapetugas     = (TextView) v.findViewById(R.id.tvNaPetugas);
            jk              = (TextView) v.findViewById(R.id.tvGender) ;
            tempatlahir     = (TextView) v.findViewById(R.id.tvTempatLahir);
            tanggallahir    = (TextView) v.findViewById(R.id.tvTanggalLahir);
            alamat          = (TextView) v.findViewById(R.id.tvAlamat);
            jabatan         = (TextView) v.findViewById(R.id.tvJabatan);
        }
    }
}
