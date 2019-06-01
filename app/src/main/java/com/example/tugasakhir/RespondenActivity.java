package com.example.tugasakhir;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tugasakhir.Model.RespondenModel;
import com.example.tugasakhir.Model.ResponseResponden;
import com.example.tugasakhir.R;
import com.example.tugasakhir.adapter.AdapterResponden;
import com.example.tugasakhir.adapter.PetugasAdapter;
import com.example.tugasakhir.api.ApiRequest;
import com.example.tugasakhir.api.RetroServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RespondenActivity extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<RespondenModel> rItems = new ArrayList<>();
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responden);

        pd          = new ProgressDialog(this);
        mRecycler   = (RecyclerView) findViewById(R.id.recyclerResponden);
        mManager    = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();

        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponseResponden> getdata = api.getSur();
        getdata.enqueue(new Callback<ResponseResponden>() {
            @Override
            public void onResponse(Call<ResponseResponden> call, Response<ResponseResponden> response) {
                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                rItems = response.body().getJadi();

                mAdapter    = new AdapterResponden(RespondenActivity.this,rItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseResponden> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");
            }
        });

    }
}
