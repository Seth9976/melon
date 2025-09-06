package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.PlaylistUploadRepntImgRes;

public class MyMusicPlaylistUploadRepntImgReq extends PlaylistUploadRepntImgBaseReq {
    public MyMusicPlaylistUploadRepntImgReq(Context context0, Params playlistUploadRepntImgBaseReq$Params0) {
        super(context0, playlistUploadRepntImgBaseReq$Params0, PlaylistUploadRepntImgRes.class);
        this.addMemberKey();
        this.addParams(playlistUploadRepntImgBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/uploadRepntImg.json";
    }
}

