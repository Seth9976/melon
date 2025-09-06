package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.MultipartHttpRequest;
import com.iloen.melon.net.v4x.response.UpdateUserImgRes;

public class UpdateUserImgReq extends MultipartHttpRequest {
    public UpdateUserImgReq(Context context0) {
        super(context0, UpdateUserImgRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/updateUserImg.json";
    }
}

