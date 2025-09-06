package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveDetailRes;

public class LiveDetailReq extends RequestV6Req {
    public LiveDetailReq(Context context0, String s) {
        super(context0, 0, LiveDetailRes.class);
        this.addMemberKey();
        this.addParam("liveSeq", s);
    }

    public LiveDetailReq(String s) {
        super(0, LiveDetailRes.class);
        this.addMemberKey();
        this.addParam("liveSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/detail.json";
    }
}

