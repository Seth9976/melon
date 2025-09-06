package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class AuthhsJsonReq extends CmtImgUpBaseReq {
    public AuthhsJsonReq(Context context0, String s) {
        super(context0, AuthhsJsonRes.class, s);
        this.addParam("VOD", "113133_964.jpg");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/auth/authhs_json.php";
    }

    private String makefileName() [...] // 潜在的解密器
}

