package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicArtistFanListRes;

public class MyMusicMessageArtistFanListReq extends ArtistFanListBaseReq {
    public MyMusicMessageArtistFanListReq(Context context0, Params artistFanListBaseReq$Params0) {
        super(context0, 0, MyMusicArtistFanListRes.class);
        this.addMemberKey();
        this.addParams(artistFanListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/artistfan/listArtistMyFan.json";
    }
}

