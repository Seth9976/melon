package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MelonTvNewMvListRes;

public class MelonTvNewMvListReq extends RequestV5_1Req {
    public static class ParamInfo {
        public int pageSize;
        public int startIndex;

    }

    public MelonTvNewMvListReq(Context context0, ParamInfo melonTvNewMvListReq$ParamInfo0) {
        super(context0, 0, MelonTvNewMvListRes.class);
        this.addParams(melonTvNewMvListReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/new/mv/list.json";
    }
}

