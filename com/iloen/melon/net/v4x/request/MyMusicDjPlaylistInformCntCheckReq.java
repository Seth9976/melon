package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInformCntCheckRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicDjPlaylistInformCntCheckReq extends RequestV4Req {
    public MyMusicDjPlaylistInformCntCheckReq(Context context0) {
        super(context0, 0, MyMusicDjPlaylistInformCntCheckRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstTypeCode", "M20002");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/djplaylist/informCntCheck.json";
    }
}

