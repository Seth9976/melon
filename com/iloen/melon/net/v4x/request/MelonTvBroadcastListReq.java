package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes;

public class MelonTvBroadcastListReq extends RequestV4Req {
    public static class ParamInfo {
        public int pageSize;
        public int startIndex;

    }

    public MelonTvBroadcastListReq(Context context0, ParamInfo melonTvBroadcastListReq$ParamInfo0) {
        super(context0, 0, MelonTvBroadcastListRes.class);
        this.addParams(melonTvBroadcastListReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/broadcast/list.json";
    }
}

