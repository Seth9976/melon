package com.iloen.melon.net.v5x.request;

import android.content.Context;

public class PlaylistListSongBaseReq extends RequestV5_1Req {
    public static class Params {
        public String mode;
        public int pageSize;
        public String plylstSeq;
        public int startIndex;

    }

    public static String MODE_DJ_ALL = "modify";
    public static String MODE_NORMAL_ALL = "all";

    public PlaylistListSongBaseReq(Context context0, int v, Params playlistListSongBaseReq$Params0, Class class0) {
        super(context0, v, class0);
        this.addMemberKey();
        this.addParams(playlistListSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/listSong.json";
    }
}

