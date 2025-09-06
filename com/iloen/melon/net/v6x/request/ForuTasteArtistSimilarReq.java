package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuTasteArtistSimilarRes;

public class ForuTasteArtistSimilarReq extends RequestV6Req {
    public static class Params {
        public String artistId;
        public String exArtistIds;

    }

    public ForuTasteArtistSimilarReq(Context context0, Params foruTasteArtistSimilarReq$Params0) {
        super(context0, 0, ForuTasteArtistSimilarRes.class, false);
        this.addParams(foruTasteArtistSimilarReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/foru/taste/artist/similar.json";
    }
}

