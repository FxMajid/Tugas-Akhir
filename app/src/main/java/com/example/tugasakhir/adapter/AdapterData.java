package com.example.tugasakhir.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tugasakhir.InputSurvey;
import com.example.tugasakhir.Model.DataModel;
import com.example.tugasakhir.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private List<DataModel> mList;
    private Context ctx;

    public AdapterData (Context ctx, List<DataModel> mList){
        this.ctx    = ctx;
        this.mList  = mList;
    }

    @Override
    public HolderData onCreateViewHolder( ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.surveylist,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder( HolderData holder, int position) {
    DataModel dm = mList.get(position);
        holder.nomor.setText(dm.getNosurvei());
        holder.nip.setText(dm.getNip());
        holder.namapetugas.setText(dm.getNama_ptgs());
        holder.nomorresponden.setText(dm.getNorspnd());
        holder.namaresponden.setText(dm.getNama_rspnd());
        holder.twI.setText(dm.getTriwulanI());
        holder.twII.setText(dm.getTriwulanII());
        holder.twIII.setText(dm.getTriwulanIII());
        holder.twIV.setText(dm.getTriwulanIV());
        holder.dm = dm;

    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView nomor, nip, namapetugas, nomorresponden, namaresponden, twI, twII, twIII, twIV;
        DataModel dm;
        public HolderData (View v){
            super(v);

            nomor           = (TextView) v.findViewById(R.id.tvNomorsurvey);
            nip             = (TextView) v.findViewById(R.id.tvNip);
            namapetugas     = (TextView) v.findViewById(R.id.tvNamaPetugas);
            nomorresponden  = (TextView) v.findViewById(R.id.tvNoResp) ;
            namaresponden   = (TextView) v.findViewById(R.id.tvNamaResp);
            twI             = (TextView) v.findViewById(R.id.tvTwI);
            twII            = (TextView) v.findViewById(R.id.tvTwII);
            twIII           = (TextView) v.findViewById(R.id.tvTwIII);
            twIV            = (TextView) v.findViewById(R.id.tvTwIV);

            v.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent goInput  = new Intent(ctx, InputSurvey.class);
        goInput.putExtra("nosurvei", dm.getNosurvei());
        goInput.putExtra("nip", dm.getNip());
        goInput.putExtra("nama_ptgs", dm.getNama_ptgs());
        goInput.putExtra("norspnd", dm.getNorspnd());
        goInput.putExtra("nama_rspnd", dm.getNama_rspnd());
        goInput.putExtra("triwulanI", dm.getTriwulanI());
        goInput.putExtra("triwulanII", dm.getTriwulanII());
        goInput.putExtra("triwulanIII", dm.getTriwulanIII());
        goInput.putExtra("triwulanIV", dm.getTriwulanIV());

        ctx.startActivity(goInput);

    }
});
        }
    }

}
