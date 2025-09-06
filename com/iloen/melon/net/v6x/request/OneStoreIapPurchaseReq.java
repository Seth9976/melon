package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v6x.response.OneStoreIapPurchaseRes;

public class OneStoreIapPurchaseReq extends HttpRequest {
    private String actionUrl;

    public OneStoreIapPurchaseReq(Context context0, String s) {
        super(context0, 1, OneStoreIapPurchaseRes.class);
        this.actionUrl = "";
        this.setJsonString(s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return "";
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return this.actionUrl;
    }

    public void setActionUrl(String s) {
        this.actionUrl = s;
    }
}

