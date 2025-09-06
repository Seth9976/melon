package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveTimedMetaNoticeRes;

public class LiveTimedMetaNoticeReq extends RequestV6Req {
    public LiveTimedMetaNoticeReq(Context context0, String s) {
        super(context0, 0, LiveTimedMetaNoticeRes.class);
        this.addParam("logSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/timedmeta/notice.json";
    }
}

