package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes;

public class MelonTvVdoGetMvProgInfoReq extends RequestV4Req {
    public MelonTvVdoGetMvProgInfoReq(Context context0, String s) {
        super(context0, 0, MelonTvVdoGetMvProgInfoRes.class);
        this.addParam("mvId", s);
    }

    public MelonTvVdoGetMvProgInfoReq(String s) {
        super(0, MelonTvVdoGetMvProgInfoRes.class);
        this.addParam("mvId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/vdo/getMvProgInfo.json";
    }
}

