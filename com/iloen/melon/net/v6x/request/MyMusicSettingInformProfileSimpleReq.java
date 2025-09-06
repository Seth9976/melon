package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicSettingInformProfileSimpleRes;

public class MyMusicSettingInformProfileSimpleReq extends RequestV6_4Req {
    public MyMusicSettingInformProfileSimpleReq(Context context0) {
        super(context0, 0, MyMusicSettingInformProfileSimpleRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/setting/informProfileSimple.json";
    }
}

