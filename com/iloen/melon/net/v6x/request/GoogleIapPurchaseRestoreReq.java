package com.iloen.melon.net.v6x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v6x.response.GoogleIapPurchaseRestoreRes;

public class GoogleIapPurchaseRestoreReq extends HttpRequest {
    public GoogleIapPurchaseRestoreReq(Context context0, String s) {
        super(context0, 1, GoogleIapPurchaseRestoreRes.class);
        this.setJsonString(s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.k;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/protocol/v1/google/inapp/purchase/restore";
    }
}

