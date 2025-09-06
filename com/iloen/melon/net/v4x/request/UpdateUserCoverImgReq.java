package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.MultipartHttpRequest;
import com.iloen.melon.net.v4x.response.UpdateUserCoverImgRes;

public class UpdateUserCoverImgReq extends MultipartHttpRequest {
    public UpdateUserCoverImgReq(Context context0) {
        super(context0, UpdateUserCoverImgRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/updateUserCoverImg.json";
    }
}

