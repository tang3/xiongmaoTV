package com.example.mypanda.service;

import java.io.IOException;

/**
 * Created by 红超 on 2017/3/17.
 */

public interface ResOrFail {
    public  String Respond(String string);
    public String Faile(IOException e);
}
