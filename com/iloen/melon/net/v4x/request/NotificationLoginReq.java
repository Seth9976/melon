package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.NotificationLoginRes;

public class NotificationLoginReq extends CommerceBaseReq {
    public static final String REQ_PARAM_BANNINGS = "bannings";

    public NotificationLoginReq(Context context0, String s) {
        super(context0, 1, NotificationLoginRes.class);
        this.addMemberKey();
        this.addParam("bannings", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/protocol/m6/notification/promotion";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

