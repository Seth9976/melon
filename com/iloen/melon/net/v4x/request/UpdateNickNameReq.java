package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.UpdateNickNameRes;

public class UpdateNickNameReq extends RequestV4Req {
    public UpdateNickNameReq(Context context0, String s) {
        super(context0, 1, UpdateNickNameRes.class);
        this.addMemberKey();
        this.addParam("memberNickName", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/updateNickName.json";
    }
}

