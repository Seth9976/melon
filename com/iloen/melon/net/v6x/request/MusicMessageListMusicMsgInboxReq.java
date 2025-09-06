package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes;

public class MusicMessageListMusicMsgInboxReq extends RequestV6Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

    }

    public MusicMessageListMusicMsgInboxReq(Context context0, Params musicMessageListMusicMsgInboxReq$Params0) {
        super(context0, 0, MusicMessageListMusicMsgInboxRes.class);
        this.addMemberKey();
        this.addParams(musicMessageListMusicMsgInboxReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/listMusicMsgInbox.json";
    }
}

