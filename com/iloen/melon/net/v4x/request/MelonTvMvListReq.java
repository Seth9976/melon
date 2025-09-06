package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvMvListRes;

public class MelonTvMvListReq extends RequestV4Req {
    public static class ParamInfo {
        public String classCode;
        public int pageSize;
        public int startIndex;

    }

    public MelonTvMvListReq(Context context0, ParamInfo melonTvMvListReq$ParamInfo0) {
        super(context0, 0, MelonTvMvListRes.class);
        this.addParams(melonTvMvListReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/mv/class/list.json";
    }
}

