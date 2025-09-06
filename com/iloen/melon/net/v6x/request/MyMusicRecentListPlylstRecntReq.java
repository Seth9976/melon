package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicRecentListPlylstRecntRes;
import com.iloen.melon.utils.system.AppUtils;
import e1.u;
import va.e0;
import va.o;

public class MyMusicRecentListPlylstRecntReq extends RequestV6Req {
    public MyMusicRecentListPlylstRecntReq(Context context0, String s) {
        super(context0, 0, MyMusicRecentListPlylstRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParam("targetMemberKey", s);
        this.addParam("appVer", AppUtils.getVersionName(context0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/recent/listPlylstRecnt.json";
    }
}

