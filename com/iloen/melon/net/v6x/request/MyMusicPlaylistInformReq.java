package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistInformRes;

public class MyMusicPlaylistInformReq extends PlaylistInformBaseReq {
    public MyMusicPlaylistInformReq(Context context0, Params playlistInformBaseReq$Params0) {
        super(context0, MyMusicPlaylistInformRes.class);
        this.addMemberKey();
        this.addParams(playlistInformBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.v6x.request.PlaylistInformBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/inform.json";
    }
}

