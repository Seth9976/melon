package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class InformOembedReq extends CmtBaseReq {
    public InformOembedReq(Context context0, String s) {
        super(context0, 0, InformOembedRes.class, null);
        this.addParam("youtubeUrl", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_informOembed.json";
    }
}

