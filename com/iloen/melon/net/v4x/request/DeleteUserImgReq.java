package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DeleteUserImgRes;

public class DeleteUserImgReq extends RequestV4Req {
    public DeleteUserImgReq(Context context0) {
        super(context0, 1, DeleteUserImgRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/deleteUserImg.json";
    }
}

