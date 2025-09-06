package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MusicMessageDeleteMusicMsgInboxRes;

public class MusicMessageDeleteMusicMsgInboxReq extends RequestV4Req {
    public static class Params {
        public String groupYn;
        public String inboxSeq;

        public Params() {
            this.groupYn = "";
        }
    }

    public MusicMessageDeleteMusicMsgInboxReq(Context context0, Params musicMessageDeleteMusicMsgInboxReq$Params0) {
        super(context0, 1, MusicMessageDeleteMusicMsgInboxRes.class);
        this.addMemberKey();
        this.addParams(musicMessageDeleteMusicMsgInboxReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/deleteMusicMsgInbox.json";
    }
}

