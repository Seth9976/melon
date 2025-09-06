package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstRes;

public class MyMusicMessageDjPopularListPlylstReq extends DjPopularListPlylstBaseReq {
    public MyMusicMessageDjPopularListPlylstReq(Context context0, String s) {
        super(context0, 0, DjPopularListPlylstRes.class);
        this.addParam("cateCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/popular/listDjPlylst.json";
    }
}

