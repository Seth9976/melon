package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes;
import com.iloen.melon.net.v5x.request.RequestV5Req;

public class MusicMessageListMusicMsgInboxContentsReq extends RequestV5Req {
    public static class Params {
        public String groupYn;
        public String inboxSeq;
        public String pageSize;
        public String startTimeStamp;

        public Params() {
            this.startTimeStamp = "";
            this.pageSize = "";
            this.groupYn = "";
        }
    }

    public MusicMessageListMusicMsgInboxContentsReq(Context context0, Params musicMessageListMusicMsgInboxContentsReq$Params0) {
        super(context0, 0, MusicMessageListMusicMsgInboxContentsRes.class);
        this.addMemberKey();
        this.addParams(musicMessageListMusicMsgInboxContentsReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/listMusicMsgInboxContents.json";
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5Req
    public String getApiVersionPath() {
        return "";
    }
}

