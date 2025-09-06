package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes;

public class StreamGetSongInfoReq extends PlayBaseReq {
    public static class ParamInfo {
        public String cType;
        public String cid;
        public boolean isLive;

        public ParamInfo() {
            this.isLive = false;
        }
    }

    private boolean isLive;

    public StreamGetSongInfoReq(Context context0, ParamInfo streamGetSongInfoReq$ParamInfo0) {
        super(context0, 1, StreamGetSongInfoRes.class);
        this.isLive = false;
        this.addParam("cType", streamGetSongInfoReq$ParamInfo0.cType);
        this.addParam("cId", streamGetSongInfoReq$ParamInfo0.cid);
        this.isLive = streamGetSongInfoReq$ParamInfo0.isLive;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return this.isLive ? "/cds/delivery/audio/contents_info.json" : "/cds/delivery/android/song_info.json";
    }
}

