package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayUpdateOrderRes;

public class MyMusicPlaylistPlayUpdateSongOrderReq extends PlaylistUpdateSongOrderBaseReq {
    public static class Params extends ParamsBase {
        public String endDsplyOrder;
        public String moveDsplyOrder;
        public String moveSongId;
        public String plylstSeq;
        public String plylstTypeCode;

    }

    public MyMusicPlaylistPlayUpdateSongOrderReq(Context context0, ParamsBase playlistUpdateSongOrderBaseReq$ParamsBase0) {
        super(context0, playlistUpdateSongOrderBaseReq$ParamsBase0, MyMusicPlaylistPlayUpdateOrderRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistUpdateSongOrderBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/play/updateSongOrder.json";
    }
}

