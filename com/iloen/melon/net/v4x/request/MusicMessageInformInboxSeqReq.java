package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MusicMessageInformInboxSeqRes;

public class MusicMessageInformInboxSeqReq extends RequestV4Req {
    public static class Params {
        public String targetMemberkeys;

        public Params() {
            this.targetMemberkeys = "";
        }
    }

    public MusicMessageInformInboxSeqReq(Context context0, Params musicMessageInformInboxSeqReq$Params0) {
        super(context0, 0, MusicMessageInformInboxSeqRes.class);
        this.addMemberKey();
        this.addParams(musicMessageInformInboxSeqReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/informInboxSeq.json";
    }
}

