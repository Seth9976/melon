package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjSnsUseAgreeRes;
import e1.u;
import va.e0;
import va.o;

public class DjSnsUseAgreeReq extends RequestV6_1Req {
    public DjSnsUseAgreeReq(Context context0) {
        super(context0, 0, DjSnsUseAgreeRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/sns/useAgree.json";
    }
}

