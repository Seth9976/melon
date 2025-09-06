package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SongInfoRes;
import va.e0;
import va.o;

public class SongInfoReq extends RequestV6_5Req {
    public SongInfoReq(Context context0, String s) {
        super(context0, 0, SongInfoRes.class);
        this.addParam("songId", s);
        boolean z = !((e0)o.a()).m();
        this.addParam("adultFlg", "");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/info.json";
    }
}

