package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjTodayListRecmSongRes;

public class DriveDjTodayListRecmSongReq extends RequestV4Req {
    public static class Param {
        public int pageSize;
        public int startIndex;

        public Param() {
            this.startIndex = 1;
            this.pageSize = 100;
        }
    }

    public DriveDjTodayListRecmSongReq(Context context0, Param driveDjTodayListRecmSongReq$Param0) {
        super(context0, 0, DjTodayListRecmSongRes.class);
        this.addParams(driveDjTodayListRecmSongReq$Param0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/drive/dj/today/listRecmSong.json";
    }
}

