package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes;

public class DjTagSearchAutoCompleteReq extends RequestV6_1Req {
    public DjTagSearchAutoCompleteReq(Context context0, String s) {
        super(context0, 0, DjTagSearchAutoCompleteRes.class, false);
        this.addParam("keyword", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/tag/search/autocomplete.json";
    }
}

