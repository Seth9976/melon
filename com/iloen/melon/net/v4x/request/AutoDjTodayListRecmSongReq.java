package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class AutoDjTodayListRecmSongReq extends DriveDjTodayListRecmSongReq {
    public AutoDjTodayListRecmSongReq(Context context0, Param driveDjTodayListRecmSongReq$Param0) {
        super(context0, driveDjTodayListRecmSongReq$Param0);
        this.addParams(driveDjTodayListRecmSongReq$Param0);
    }

    @Override  // com.iloen.melon.net.v4x.request.DriveDjTodayListRecmSongReq
    public String getApiPath() {
        return "/auto/dj/today/listRecmSong.json";
    }
}

