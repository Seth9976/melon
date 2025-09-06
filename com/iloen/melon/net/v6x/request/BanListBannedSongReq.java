package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.BanListBannedSongRes;

public class BanListBannedSongReq extends RequestV6Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public BanListBannedSongReq(Context context0, Params banListBannedSongReq$Params0) {
        super(context0, 0, BanListBannedSongRes.class, false);
        this.addMemberKey();
        this.addParams(banListBannedSongReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/ban/listBannedSong.json";
    }
}

