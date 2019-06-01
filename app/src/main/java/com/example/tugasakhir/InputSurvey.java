package com.example.tugasakhir;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugasakhir.Model.ResponsModel;
import com.example.tugasakhir.api.ApiRequest;
import com.example.tugasakhir.api.RetroServer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputSurvey extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private EditText btDatePicker;

    EditText enomor, enip, enamapetugas, enomorresp, enamaresp, etw1, etw2, etw3, etw4  ;
    Button btninput, btnupdate, btntampil;
    ProgressDialog pd;

    public void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tvDateResult.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_survey);

        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        tvDateResult    = (TextView) findViewById(R.id.edt_tw1);
        btDatePicker    = (EditText) findViewById(R.id.edt_tw1);

        enomor      = (EditText) findViewById(R.id.edt_nomorsurvey);
        enip        = (EditText) findViewById(R.id.edt_nip);
        enamapetugas= (EditText) findViewById(R.id.edt_namapetugas);
        enomorresp  = (EditText) findViewById(R.id.edt_nomoresponden);
        enamaresp   = (EditText) findViewById(R.id.edt_namaresponden);
        etw2        = (EditText) findViewById(R.id.edt_tw2);
        etw3        = (EditText) findViewById(R.id.edt_tw3);
        etw4        = (EditText) findViewById(R.id.edt_tw4);
        btninput    = (Button) findViewById(R.id.inputdata);
        btnupdate   = (Button) findViewById(R.id.updatedata);
        btntampil   = (Button) findViewById(R.id.tampildata);


        Intent data         = getIntent();
        final String iddata = data.getStringExtra("nosurvei");
        if (iddata != null){
        btninput.setVisibility(View.GONE);
        btnupdate.setVisibility(View.VISIBLE);
        btntampil.setVisibility(View.VISIBLE);
        enomor.setText(data.getStringExtra("nosurvei"));
        enip.setText(data.getStringExtra("nip"));
        enamapetugas.setText(data.getStringExtra("nama_ptgs"));
        enomorresp.setText(data.getStringExtra("norspnd"));
        enamaresp.setText(data.getStringExtra("nama_rspnd"));
        btDatePicker.setText(data.getStringExtra("triwulanI"));
        etw2.setText(data.getStringExtra("triwulanII"));
        etw3.setText(data.getStringExtra("triwulanIII"));
        etw4.setText(data.getStringExtra("triwulanIV"));
        }

        pd          = new ProgressDialog(this);


        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.edt_tw1);
        btDatePicker = (EditText) findViewById(R.id.edt_tw1);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("updating data...");
                pd.setCancelable(false);
                pd.show();

                ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
                Call<ResponsModel> update = api.updateSurvey(enomor.getText().toString(), enip.getText().toString(), enamapetugas.getText().toString(),
                        enomorresp.getText().toString(), enamaresp.getText().toString(), btDatePicker.getText().toString(), etw2.getText().toString(),
                        etw3.getText().toString(), etw4.getText().toString());
                update.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro", "Response");
                        Toast.makeText(InputSurvey.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                        pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "OnFailure");

                    }
                });
            }
        });

        btntampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent godata = new Intent(InputSurvey.this, LihatSurvei.class);
            startActivity(godata);
            }
        });


        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Sending Data...");
                pd.setCancelable(false);
                pd.show();

                String snosurvei = enomor.getText().toString();
                String snip = enip.getText().toString();
                String snamapetugas = enamapetugas.getText().toString();
                String snoresponden = enomorresp.getText().toString();
                String snamaresponden = enamaresp.getText().toString();
                String striwulanI = btDatePicker.getText().toString();
                String striwulanII = etw2.getText().toString();
                String striwulanIII = etw3.getText().toString();
                String striwulanIV = etw4.getText().toString();

                ApiRequest api = RetroServer.getClient().create(ApiRequest.class);

                Call<ResponsModel> sendsur = api.sendSurvey(snosurvei, snip, snamapetugas, snoresponden,
                        snamaresponden, striwulanI, striwulanII, striwulanIII, striwulanIV);
                sendsur.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        pd.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String kode = response.body().getKode();

                        if (kode.equals("1")) {
                            Toast.makeText(InputSurvey.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                            setResult(RESULT_OK);
                            finish();
                        } else {
                            Toast.makeText(InputSurvey.this, "Data gagal disimpan", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("RETRO", "FAILURE : " + "GAGAL MENGIRIM REQUEST");
                    }
                });
            }
        });
    }
}