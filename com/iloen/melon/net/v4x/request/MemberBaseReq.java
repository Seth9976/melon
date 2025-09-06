package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import android.text.TextUtils;

public abstract class MemberBaseReq extends RequestV4Req {
    public MemberBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }

    public void addUKey(String s) {
        if(TextUtils.isEmpty(s)) {
            s = "0";
        }
        this.addParam("ukey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.j;
    }
}

