package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameArtistPlaylistRes;

public class MyMusicLikeListSameArtistPlaylistReq extends RequestV4Req {
    public static class Params {
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public MyMusicLikeListSameArtistPlaylistReq(Context context0, Params myMusicLikeListSameArtistPlaylistReq$Params0) {
        super(context0, 0, MyMusicLikeListSameArtistPlaylistRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListSameArtistPlaylistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listSameArtistPlaylist.json";
    }
}

