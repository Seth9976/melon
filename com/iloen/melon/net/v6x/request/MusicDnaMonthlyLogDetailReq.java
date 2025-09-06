package com.iloen.melon.net.v6x.request;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes;
import com.iloen.melon.utils.system.AppUtils;

public class MusicDnaMonthlyLogDetailReq extends RequestV6Req {
    private final String KEY_LOG_MONTH;

    public MusicDnaMonthlyLogDetailReq(String s) {
        super(0, MusicDnaMonthlyLogDetailRes.class, false);
        this.KEY_LOG_MONTH = "logMonth";
        this.addMemberKey();
        this.addParam("logMonth", s);
        this.addParam("appVer", AppUtils.getVersionName(MelonAppBase.instance.getContext()));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/musicdna/monthly_log/detail.json";
    }
}

