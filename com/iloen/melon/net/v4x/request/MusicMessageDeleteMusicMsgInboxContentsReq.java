package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MusicMessageDeleteMusicMsgInboxContentsRes;

public class MusicMessageDeleteMusicMsgInboxContentsReq extends RequestV4Req {
    public static class Params {
        public String groupYn;
        public String inboxSeq;
        public String musicMesgSeq;
        public String oldDataYn;
        public String timeStamp;
        public String trnsmTye;

        public Params() {
            this.groupYn = "";
        }
    }

    public MusicMessageDeleteMusicMsgInboxContentsReq(Context context0, Params musicMessageDeleteMusicMsgInboxContentsReq$Params0) {
        super(context0, 1, MusicMessageDeleteMusicMsgInboxContentsRes.class);
        this.addMemberKey();
        this.addParams(musicMessageDeleteMusicMsgInboxContentsReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/deleteMusicMsgInboxContents.json";
    }
}

