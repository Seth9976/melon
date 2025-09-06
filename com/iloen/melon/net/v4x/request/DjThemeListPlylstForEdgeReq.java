package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes;

public class DjThemeListPlylstForEdgeReq extends RequestV4Req {
    public DjThemeListPlylstForEdgeReq(Context context0) {
        super(context0, 0, DjThemeListPlylstForEdgeRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/theme/listPlylstForEdge.json";
    }
}

