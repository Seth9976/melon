package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsDJPlaylistRes;

public class SongContentsDJPlaylistReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public String songId;
        public int startIndex;

    }

    public SongContentsDJPlaylistReq(Context context0, Params songContentsDJPlaylistReq$Params0) {
        super(context0, 0, DetailContentsDJPlaylistRes.class);
        this.addParams(songContentsDJPlaylistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/contents/djplaylist.json";
    }
}

