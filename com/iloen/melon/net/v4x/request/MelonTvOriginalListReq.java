package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvOriginalListRes;

public class MelonTvOriginalListReq extends RequestV4Req {
    public static class ParamInfo {
        public int pageSize;
        public int startIndex;

    }

    public MelonTvOriginalListReq(Context context0, ParamInfo melonTvOriginalListReq$ParamInfo0) {
        super(context0, 0, MelonTvOriginalListRes.class);
        this.addParams(melonTvOriginalListReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/original/list.json";
    }
}

