package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.AuthLocationRes;

public class AuthLocationReq extends RequestV4Req {
    public AuthLocationReq(Context context0) {
        super(context0, 0, AuthLocationRes.class, true);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/auth/location.json";
    }
}

