package com.example.tugasakhir.api;

import com.example.tugasakhir.Model.ResponsModel;
import com.example.tugasakhir.Model.ResponsePetugas;
import com.example.tugasakhir.Model.ResponseResponden;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {

    @FormUrlEncoded
    @POST ("insert.php")
    Call<ResponsModel> sendSurvey (@Field("nosurvei") String nosurvei,
                                   @Field("nip")String nip,
                                   @Field("nama_ptgs")String nama_ptgs,
                                   @Field("norspnd")String norspnd,
                                   @Field("nama_rspnd") String nama_rspnd,
                                   @Field("triwulanI")String triwulanI,
                                   @Field("triwulanII")String triwulanII,
                                   @Field("triwulanIII")String triwulanIII,
                                   @Field("triwulanIV") String triwulanIV);

    @GET("read.php")
    Call<ResponsModel> getSurvey ();

    @FormUrlEncoded
    @POST ("update.php")
    Call <ResponsModel> updateSurvey (@Field("nosurvei") String nosurvei,
                                      @Field("nip")String nip,
                                      @Field("nama_ptgs")String nama_ptgs,
                                      @Field("norspnd")String norspnd,
                                      @Field("nama_rspnd") String nama_rspnd,
                                      @Field("triwulanI")String triwulanI,
                                      @Field("triwulanII")String triwulanII,
                                      @Field("triwulanIII")String triwulanIII,
                                      @Field("triwulanIV") String triwulanIV);

    @GET("readpetugas.php")
    Call<ResponsePetugas> getSurvei();

    @GET("readresponden.php")
    Call<ResponseResponden> getSur();


}
