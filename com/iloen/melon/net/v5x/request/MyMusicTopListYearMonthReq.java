package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicTopListYearMonthRes;

public class MyMusicTopListYearMonthReq extends RequestV5Req {
    public MyMusicTopListYearMonthReq(Context context0) {
        super(context0, 0, MyMusicTopListYearMonthRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/top/listYearMonth.json";
    }
}

