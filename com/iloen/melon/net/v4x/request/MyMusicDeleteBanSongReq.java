package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicDeleteBanSongRes;

public class MyMusicDeleteBanSongReq extends RequestV4Req {
    public static class Params {
        public String menuId;
        public String reasonContsTypeCode;
        public String songId;

    }

    public MyMusicDeleteBanSongReq(Context context0, Params myMusicDeleteBanSongReq$Params0) {
        super(context0, 1, MyMusicDeleteBanSongRes.class, false);
        this.addMemberKey();
        this.addParams(myMusicDeleteBanSongReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/deleteBanSong.json";
    }
}

