package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicDjPlaylistListRes;

public class MyMusicMessageDjPlaylistListReq extends DjPlaylistListBaseReq {
    public MyMusicMessageDjPlaylistListReq(Context context0, Params djPlaylistListBaseReq$Params0) {
        super(context0, 0, MyMusicDjPlaylistListRes.class);
        this.addMemberKey();
        this.addParams(djPlaylistListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/djplaylist/list.json";
    }
}

