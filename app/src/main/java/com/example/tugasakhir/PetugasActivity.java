package com.example.tugasakhir;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tugasakhir.Model.DataModel;
import com.example.tugasakhir.Model.PetugasModel;
import com.example.tugasakhir.Model.ResponsePetugas;
import com.example.tugasakhir.R;
import com.example.tugasakhir.adapter.PetugasAdapter;
import com.example.tugasakhir.api.ApiRequest;
import com.example.tugasakhir.api.RetroServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetugasActivity extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<PetugasModel> pItems = new ArrayList<>();
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petugas);

        pd          = new ProgressDialog(this);
        mRecycler   = (RecyclerView) findViewById(R.id.recyclerPetugas);
        mManager    = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponsePetugas> getdata = api.getSurvei();
        getdata.enqueue(new Callback<ResponsePetugas>() {
            @Override
            public void onResponse(Call<ResponsePetugas> call, Response<ResponsePetugas> response) {
                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                pItems = response.body().getHasil();

                mAdapter    = new PetugasAdapter(PetugasActivity.this,pItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponsePetugas> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");
            }
        });
    }
}
