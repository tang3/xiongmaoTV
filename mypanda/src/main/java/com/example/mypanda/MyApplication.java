package com.example.mypanda;

import android.app.Application;



import com.example.mypanda.entieny.AllTitle;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by 红超 on 2017/2/18.
 */

public class MyApplication extends Application {
    String enmae;


    public void setEname(String ename){
        this.enmae=ename;
    }
    public String getEname(){
        return enmae;
    }
     public  List<AllTitle.DataBean> allTitl= new ArrayList<>();

    public  List<AllTitle.DataBean> getAllTitle() {
        return allTitl;
    }

    public  void setAllTitle(List<AllTitle.DataBean> allTitle) {
        allTitl = allTitle;
    }

}
