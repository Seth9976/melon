package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MessageRecentListSongRecntRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicMessageRecentListSongRecntReq extends RequestV4Req {
    public static class Params {
        public String targetMemberKey;

    }

    public MyMusicMessageRecentListSongRecntReq(Context context0, Params myMusicMessageRecentListSongRecntReq$Params0) {
        super(context0, 0, MessageRecentListSongRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(myMusicMessageRecentListSongRecntReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/recent/listSongRecnt.json";
    }
}

