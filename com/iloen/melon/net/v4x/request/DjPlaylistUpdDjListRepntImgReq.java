package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPlaylistUpdDjListRepntImgRes;

public class DjPlaylistUpdDjListRepntImgReq extends PlaylistUpdateRepntImageBaseReq {
    public DjPlaylistUpdDjListRepntImgReq(Context context0, Params playlistUpdateRepntImageBaseReq$Params0) {
        super(context0, playlistUpdateRepntImageBaseReq$Params0, DjPlaylistUpdDjListRepntImgRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistUpdateRepntImageBaseReq
    public String getApiPath() {
        return "/dj/playlist/updDjListRepntImg.json";
    }
}

