package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicSeriesInformCntCheckRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicSeriesInformCntCheckReq extends RequestV5Req {
    public MyMusicSeriesInformCntCheckReq(Context context0) {
        super(context0, 0, MyMusicSeriesInformCntCheckRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstTypeCode", "M20005");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/series/informCntCheck.json";
    }
}

