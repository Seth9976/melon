package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftBoxRecentListSongRecntRes;
import e1.u;
import va.e0;
import va.o;

public class GiftBoxRecentListSongRecntReq extends RequestV4Req {
    public GiftBoxRecentListSongRecntReq(Context context0, String s) {
        super(context0, 0, GiftBoxRecentListSongRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("targetMemberKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/giftbox/recent/listSongRecnt.json";
    }
}

