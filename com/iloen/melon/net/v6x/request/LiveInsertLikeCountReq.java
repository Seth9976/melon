package com.iloen.melon.net.v6x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveInsertLikeCountRes;

public class LiveInsertLikeCountReq extends RequestV6Req {
    public LiveInsertLikeCountReq(Context context0, String s, String s1) {
        super(context0, 0, LiveInsertLikeCountRes.class);
        this.addParam("mvId", s);
        this.addParam("sumCount", s1);
    }

    public LiveInsertLikeCountReq(String s, String s1) {
        super(0, LiveInsertLikeCountRes.class);
        this.addParam("liveSeq", s);
        this.addParam("sumCount", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.i;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/insertLikeCount.json";
    }
}

