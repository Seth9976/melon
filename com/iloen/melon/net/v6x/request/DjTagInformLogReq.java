package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjTagInformLogRes;

public class DjTagInformLogReq extends RequestV6Req {
    public DjTagInformLogReq(Context context0, String s, String s1) {
        super(context0, 0, DjTagInformLogRes.class, false);
        this.addMemberKeyAlwaysDeliver(s1);
        this.addParam("tagSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/tag/informLog.json";
    }
}

