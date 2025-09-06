package com.iloen.melon.net.v3x;

import android.content.Context;
import p8.P;

public class SLLogReq extends ClickLogReq {
    private final P mInfo;

    public SLLogReq(Context context0, P p0) {
        super(context0);
    }

    @Override  // com.iloen.melon.net.v3x.ClickLogReq
    public String getApiPath() {
        return "";
    }

    private String getSLLogUrl(P p0) [...] // Inlined contents
}

