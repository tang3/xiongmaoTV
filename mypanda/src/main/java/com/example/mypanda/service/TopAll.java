package com.example.mypanda.service;

import com.example.mypanda.entieny.AllTitle;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 红超 on 2017/2/18.
 */

public interface  TopAll  {
    @GET ("index.php?method=category.list&type=game&__version=2.1.9.1736&__plat=android")
    Call <AllTitle> getAll();
}
