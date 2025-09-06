package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicPlaylistInformTypeRes;

public class MyMusicPlaylistInformTypeReq extends RequestV5Req {
    public static class Params {
        public String targetMemberKey;

    }

    public MyMusicPlaylistInformTypeReq(Context context0, String s) {
        super(context0, 0, MyMusicPlaylistInformTypeRes.class);
        this.addMemberKey();
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/informType.json";
    }
}

