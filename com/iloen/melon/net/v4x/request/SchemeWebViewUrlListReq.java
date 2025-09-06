package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SchemeWebViewUrlListRes;

public class SchemeWebViewUrlListReq extends RequestV4Req {
    public SchemeWebViewUrlListReq(Context context0) {
        super(context0, 0, SchemeWebViewUrlListRes.class);
        this.addMemberKeyAlwaysDeliver();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/apppolicy/scheme/webviewurl/list.json";
    }
}

