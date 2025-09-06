package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SongPersonalInfoRes;

public class SongPersonalInfoReq extends RequestV6_1Req {
    public SongPersonalInfoReq(Context context0, String s, String s1) {
        super(context0, 0, SongPersonalInfoRes.class);
        this.addMemberKey();
        this.addParam("songId", s);
        this.addParam("adultFlg", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/personal/info.json";
    }
}

