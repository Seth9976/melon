package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListArtistPlaylistRes;

public class MyMusicLikeUpdateListArtistPlaylistReq extends LikeListArtistPlaylistBaseReq {
    public MyMusicLikeUpdateListArtistPlaylistReq(Context context0, Params likeListArtistPlaylistBaseReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListArtistPlaylistRes.class);
        this.addMemberKey();
        this.addParams(likeListArtistPlaylistBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listArtistPlaylist.json";
    }
}

