package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicRecentListMvRecntRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicMessageRecentListMvRecntReq extends RecentListMvRecntBaseReq {
    public MyMusicMessageRecentListMvRecntReq(Context context0, Params recentListMvRecntBaseReq$Params0) {
        super(context0, 0, MyMusicRecentListMvRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(recentListMvRecntBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/recent/listMvRecnt.json";
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5_1Req
    public String getApiVersionPath() {
        return "";
    }
}

