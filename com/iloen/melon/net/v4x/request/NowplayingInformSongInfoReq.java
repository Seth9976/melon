package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes;

public class NowplayingInformSongInfoReq extends RequestV4Req {
    public NowplayingInformSongInfoReq(Context context0, String s) {
        super(context0, 0, NowplayingInformSongInfoRes.class, false);
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/nowplaying/nowplaying/informSongInfo.json";
    }
}

