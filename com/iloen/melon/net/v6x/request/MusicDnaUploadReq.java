package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.MultipartHttpRequestV6;
import com.iloen.melon.net.v6x.response.MusicDnaUploadRes;

public class MusicDnaUploadReq extends MultipartHttpRequestV6 {
    public MusicDnaUploadReq(Context context0, String s, String s1, String s2) {
        super(context0, MusicDnaUploadRes.class);
        this.addMemberKey();
        this.addParam("type", s);
        this.addParam("contentsName", s1);
        this.addParam("logMonth", s2);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/musicdna/upload.json";
    }
}

