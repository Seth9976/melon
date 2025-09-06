package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicInsertBanSongRes;

public class MyMusicInsertBanSongReq extends RequestV4Req {
    public static class Param {
        public String menuId;
        public String rcmdReasonContId;
        public String reasonContsTypeCode;
        public String reasonType;
        public String songId;

    }

    public MyMusicInsertBanSongReq(Context context0, Param myMusicInsertBanSongReq$Param0) {
        super(context0, 1, MyMusicInsertBanSongRes.class);
        this.addMemberKey();
        this.addParams(myMusicInsertBanSongReq$Param0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/insertBanSong.json";
    }
}

