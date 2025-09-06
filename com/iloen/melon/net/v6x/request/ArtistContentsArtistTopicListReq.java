package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes;

public class ArtistContentsArtistTopicListReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String orderBy;
        public int pageSize;
        public int startIndex;

        public Params() {
            this.artistId = "";
            this.orderBy = "";
        }
    }

    public ArtistContentsArtistTopicListReq(Context context0, Params artistContentsArtistTopicListReq$Params0) {
        super(context0, 0, ArtistContentsArtistTopicListRes.class);
        this.addParams(artistContentsArtistTopicListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/artistTopicList.json";
    }
}

