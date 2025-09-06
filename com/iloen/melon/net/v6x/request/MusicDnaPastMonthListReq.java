package com.iloen.melon.net.v6x.request;

import com.iloen.melon.net.v6x.response.MusicDnaMonthListRes;

public class MusicDnaPastMonthListReq extends RequestV6Req {
    public MusicDnaPastMonthListReq() {
        super(0, MusicDnaMonthListRes.class, false);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/musicdna/past/month_list.json";
    }
}

