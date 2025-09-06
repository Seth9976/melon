package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsArtistNoteRes;

public class ArtistContentsArtistNoteListReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public int pageSize;
        public int startIndex;

    }

    public ArtistContentsArtistNoteListReq(Context context0, Params artistContentsArtistNoteListReq$Params0) {
        super(context0, 0, ArtistDetailContentsArtistNoteRes.class);
        this.addParams(artistContentsArtistNoteListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/artistNoteList.json";
    }
}

