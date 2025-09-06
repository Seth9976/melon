package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListArtistPlaylistRes;

public class MyMusicLikeListArtistPlaylistReq extends LikeListArtistPlaylistBaseReq {
    public MyMusicLikeListArtistPlaylistReq(Context context0, Params likeListArtistPlaylistBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListArtistPlaylistRes.class);
        this.addMemberKey();
        this.addParams(likeListArtistPlaylistBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listArtistPlaylist.json";
    }
}

