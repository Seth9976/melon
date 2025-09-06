package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistConnectedListSongRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicPlaylistConnectedListSongReq extends RequestV6_1Req {
    public MyMusicPlaylistConnectedListSongReq(Context context0, String s) {
        super(context0, 0, MyMusicPlaylistConnectedListSongRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/connected/listSong.json";
    }
}

