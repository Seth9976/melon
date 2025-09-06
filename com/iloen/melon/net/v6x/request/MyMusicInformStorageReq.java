package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicInformStorageRes;

public class MyMusicInformStorageReq extends RequestV6_2Req {
    public MyMusicInformStorageReq(Context context0) {
        super(context0, 0, MyMusicInformStorageRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/informStorage.json";
    }
}

