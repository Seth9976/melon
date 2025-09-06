package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjBrandDetailRecmSongListRes;

public class DjBrandDetailRecmSongListReq extends RequestV6_1Req {
    public static class ParamInfo {
        public int pageSize;
        public int startIndex;

    }

    public DjBrandDetailRecmSongListReq(Context context0, ParamInfo djBrandDetailRecmSongListReq$ParamInfo0, String s) {
        super(context0, 0, DjBrandDetailRecmSongListRes.class, false);
        this.addParams(djBrandDetailRecmSongListReq$ParamInfo0);
        this.addParam("brandDjKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brandDetail/recmSong/list.json";
    }
}

