package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistMusicSongListRes;

public class ArtistMusicSongListReq extends RequestV6_2Req {
    public static class Params {
        public String artistId;
        public String categoryCode;
        public String filterBy;
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public static final String FILTER_A = "A";
    public static final String FILTER_F = "F";
    public static final String FILTER_LC = "LC";
    public static final String FILTER_RS = "RS";
    public static final String FILTER_TR = "TR";

    public ArtistMusicSongListReq(Context context0, Params artistMusicSongListReq$Params0) {
        super(context0, 0, ArtistMusicSongListRes.class, false);
        this.addParams(artistMusicSongListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/music/songList.json";
    }
}

