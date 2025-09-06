package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.UpdateUserDescRes;

public class UpdateUserDescReq extends RequestV4Req {
    public UpdateUserDescReq(Context context0, String s, String s1) {
        super(context0, 1, UpdateUserDescRes.class);
        this.addMemberKey(s);
        this.addParam("userDesc", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/updateUserDesc.json";
    }
}

