package com.Apptrics.MoviesGridView.API;

/**
* Created by ASUS on 9/20/2016.
*/
public interface RequestCallBack {

public void onResponse(String jsonObject);
public void onFailed(String message);

}