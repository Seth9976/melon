package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistInsertLikeListSongRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicDjPlaylistInsertLikeListSongReq extends LikeListSongBaseReq {
    public MyMusicDjPlaylistInsertLikeListSongReq(Context context0, Params likeListSongBaseReq$Params0) {
        super(context0, 0, MyMusicDjPlaylistInsertLikeListSongRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(likeListSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/djplaylist/insert/like/listSong.json";
    }
}

