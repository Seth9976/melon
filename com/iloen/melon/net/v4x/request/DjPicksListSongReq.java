package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPicksListSongRes;

public class DjPicksListSongReq extends RequestV4Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public String pickId;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
        }
    }

    public DjPicksListSongReq(Context context0, Params djPicksListSongReq$Params0) {
        super(context0, 0, DjPicksListSongRes.class, false);
        this.addParams(djPicksListSongReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/picks/listSong.json";
    }
}

