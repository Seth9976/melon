package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistUpdateRepntImgRes;

public class MyMusicPlaylistUpdateRepntImgReq extends PlaylistUpdateRepntImageBaseReq {
    public MyMusicPlaylistUpdateRepntImgReq(Context context0, Params playlistUpdateRepntImageBaseReq$Params0) {
        super(context0, playlistUpdateRepntImageBaseReq$Params0, MyMusicPlaylistUpdateRepntImgRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/updateRepntImg.json";
    }
}

