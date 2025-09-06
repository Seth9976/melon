package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.HttpResponse;

public class DeleteNowPlayingReq extends RequestV4Req {
    public static class ParamInfo {
        public String artistId;
        public String memberKey;
        public String nowPlaySeq;

    }

    public DeleteNowPlayingReq(Context context0, ParamInfo deleteNowPlayingReq$ParamInfo0) {
        super(context0, 0, HttpResponse.class);
        this.addMemberKey(deleteNowPlayingReq$ParamInfo0.memberKey);
        this.addParams(deleteNowPlayingReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/nowplaying/nowplaying/deleteNowPlaying.json";
    }
}

