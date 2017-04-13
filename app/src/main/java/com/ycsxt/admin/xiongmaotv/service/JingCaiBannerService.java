package com.ycsxt.admin.xiongmaotv.service;

import com.ycsxt.admin.xiongmaotv.domain.JingCaiBaners;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 2017/2/14.
 */

public interface JingCaiBannerService {
    @GET("index.php?method=slider.index&__version=2.1.9.1720&__plat=android&__channel=guanwang")
    Call<JingCaiBaners> getBanners();
}
