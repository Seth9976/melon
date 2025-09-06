package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes;

public class ArtistPlylstSongListReq extends RequestV4_1Req {
    public static class Params {
        public int pageSize;
        public String plylstSeq;
        public int startIndex;

    }

    public ArtistPlylstSongListReq(Context context0, String s, Params artistPlylstSongListReq$Params0) {
        super(context0, 0, ArtistPlylstSongListRes.class, false);
        this.addMemberKey(s);
        this.addParams(artistPlylstSongListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artistplaylist/song/songList.json";
    }
}

