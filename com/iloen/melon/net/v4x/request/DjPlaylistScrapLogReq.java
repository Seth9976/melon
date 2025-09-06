package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumInformBasicRes;

public class DjPlaylistScrapLogReq extends RequestV4Req {
    public static class ParamInfo {
        public String plylstSeq;
        public String plylstTypeCode;

    }

    public DjPlaylistScrapLogReq(Context context0, ParamInfo djPlaylistScrapLogReq$ParamInfo0) {
        super(context0, 0, AlbumInformBasicRes.class);
        this.addMemberKey();
        this.addParams(djPlaylistScrapLogReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/scrapLog.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

