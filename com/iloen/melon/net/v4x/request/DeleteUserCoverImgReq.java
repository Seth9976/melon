package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DeleteUserCoverImgRes;

public class DeleteUserCoverImgReq extends RequestV4Req {
    public DeleteUserCoverImgReq(Context context0) {
        super(context0, 1, DeleteUserCoverImgRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/deleteUserCoverImg.json";
    }
}

