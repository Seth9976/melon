package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes;
import com.iloen.melon.net.v5x.request.RequestV5Req;

public class MelonTvLikedProgramReq extends RequestV5Req {
    public MelonTvLikedProgramReq(Context context0) {
        super(context0, 0, MelonTvLikedProgramRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/program/likeProgList.json";
    }
}

