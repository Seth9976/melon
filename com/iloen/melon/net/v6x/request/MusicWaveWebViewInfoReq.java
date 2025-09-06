package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MusicWaveWebViewInfoRes;

public class MusicWaveWebViewInfoReq extends RequestV6Req {
    public MusicWaveWebViewInfoReq(Context context0, String s, String s1) {
        super(context0, 0, MusicWaveWebViewInfoRes.class);
        this.addParam("id", s);
        this.addParam("type", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/musicwave/api/webview_info.json";
    }
}

