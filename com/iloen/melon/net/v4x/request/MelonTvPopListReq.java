package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvPopListRes;
import com.iloen.melon.net.v5x.request.RequestV5_1Req;

public class MelonTvPopListReq extends RequestV5_1Req {
    public static class ParamInfo {
        public int menuSeq;
        public int pageSize;
        public int startIndex;

    }

    public MelonTvPopListReq(Context context0, ParamInfo melonTvPopListReq$ParamInfo0) {
        super(context0, 0, MelonTvPopListRes.class);
        this.addParams(melonTvPopListReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/pop/list.json";
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5_1Req
    public String getApiVersionPath() {
        return "";
    }
}

