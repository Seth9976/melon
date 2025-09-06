package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq.Params;
import com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq;
import com.iloen.melon.net.v4x.response.PlaylistUploadRepntImgRes;

public class DjPlaylistUploadDjRepntImgReq extends PlaylistUploadRepntImgBaseReq {
    public DjPlaylistUploadDjRepntImgReq(Context context0, Params playlistUploadRepntImgBaseReq$Params0) {
        super(context0, playlistUploadRepntImgBaseReq$Params0, PlaylistUploadRepntImgRes.class);
        this.addMemberKey();
        this.addParams(playlistUploadRepntImgBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq
    public String getApiPath() {
        return "/dj/playlist/repntImg/upload.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiVersionPath() {
        return "/m6";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getServerVersionPath() {
        return "/v1";
    }
}

