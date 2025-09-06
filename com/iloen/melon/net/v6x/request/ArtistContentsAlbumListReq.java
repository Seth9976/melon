package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsAlbumRes;

public class ArtistContentsAlbumListReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String filterBy;
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public ArtistContentsAlbumListReq(Context context0, Params artistContentsAlbumListReq$Params0) {
        super(context0, 0, ArtistDetailContentsAlbumRes.class);
        this.addParams(artistContentsAlbumListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/music/albumList.json";
    }
}

