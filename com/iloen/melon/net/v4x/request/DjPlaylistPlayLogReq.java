package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumInformBasicRes;

public class DjPlaylistPlayLogReq extends RequestV4Req {
    public static class ParamInfo {
        public String plylstSeq;
        public String plylstTypeCode;

    }

    public DjPlaylistPlayLogReq(Context context0, ParamInfo djPlaylistPlayLogReq$ParamInfo0) {
        super(context0, 0, AlbumInformBasicRes.class);
        this.addMemberKey();
        this.addParams(djPlaylistPlayLogReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/playLog.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

