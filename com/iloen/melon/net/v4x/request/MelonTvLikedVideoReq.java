package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvLikedVideoRes;
import com.iloen.melon.net.v5x.request.RequestV5_1Req;

public class MelonTvLikedVideoReq extends RequestV5_1Req {
    public static class ParamInfo {
        public int pageSize;
        public int startIndex;

    }

    public MelonTvLikedVideoReq(Context context0, ParamInfo melonTvLikedVideoReq$ParamInfo0) {
        super(context0, 0, MelonTvLikedVideoRes.class);
        this.addParams(melonTvLikedVideoReq$ParamInfo0);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/program/likeProgMvList.json";
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5_1Req
    public String getApiVersionPath() {
        return "";
    }
}

