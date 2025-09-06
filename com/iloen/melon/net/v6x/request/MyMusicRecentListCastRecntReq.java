package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicRecentListCastRecntReq extends RequestV6Req {
    public MyMusicRecentListCastRecntReq(Context context0) {
        super(context0, 0, MyMusicCastListRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/recent/listCastRecnt.json";
    }
}

