package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.TmpManageIsCallRes;

public class TmpManageIsCallReq extends MemberBaseReq {
    public TmpManageIsCallReq(Context context0) {
        super(context0, 1, TmpManageIsCallRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/muid/rest/api/tmpmanage_iscall.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

