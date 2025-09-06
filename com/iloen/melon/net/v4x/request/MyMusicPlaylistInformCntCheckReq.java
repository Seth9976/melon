package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInformCntCheckRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicPlaylistInformCntCheckReq extends RequestV4Req {
    public MyMusicPlaylistInformCntCheckReq(Context context0) {
        super(context0, 0, MyMusicPlaylistInformCntCheckRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstTypeCode", "M20001");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/informCntCheck.json";
    }
}

