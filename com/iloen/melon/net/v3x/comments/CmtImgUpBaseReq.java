package com.iloen.melon.net.v3x.comments;

import A8.M;
import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.MultipartHttpRequest;

public abstract class CmtImgUpBaseReq extends MultipartHttpRequest {
    private String domainFromServer;

    public CmtImgUpBaseReq(Context context0, Class class0, String s) {
        super(context0, class0, false);
        this.domainFromServer = s;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return TextUtils.isEmpty(this.domainFromServer) ? M.n : this.domainFromServer;
    }
}

