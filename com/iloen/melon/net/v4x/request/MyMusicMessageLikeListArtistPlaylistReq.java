package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListArtistPlaylistRes;

public class MyMusicMessageLikeListArtistPlaylistReq extends LikeListArtistPlaylistBaseReq {
    public MyMusicMessageLikeListArtistPlaylistReq(Context context0, Params likeListArtistPlaylistBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListArtistPlaylistRes.class);
        this.addMemberKey();
        this.addParams(likeListArtistPlaylistBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/like/listArtistPlaylist.json";
    }
}

