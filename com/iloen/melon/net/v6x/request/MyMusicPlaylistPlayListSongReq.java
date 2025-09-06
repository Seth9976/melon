package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistPlayListSongRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicPlaylistPlayListSongReq extends RequestV6_1Req {
    public MyMusicPlaylistPlayListSongReq(Context context0, String s) {
        super(context0, 0, MyMusicPlaylistPlayListSongRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/play/listSong.json";
    }
}

