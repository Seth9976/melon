package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicRecentListMvRecntRes;
import com.iloen.melon.net.v5x.request.RequestV5_1Req;
import e1.u;
import va.e0;
import va.o;

public class MyMusicRecentListMvRecntReq extends RequestV5_1Req {
    public static class Params {
        public String targetMemberKey;

    }

    public MyMusicRecentListMvRecntReq(Context context0, Params myMusicRecentListMvRecntReq$Params0) {
        super(context0, 0, MyMusicRecentListMvRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(myMusicRecentListMvRecntReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/recent/listMvRecnt.json";
    }
}

