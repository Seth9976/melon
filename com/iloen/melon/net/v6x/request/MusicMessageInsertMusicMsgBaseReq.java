package com.iloen.melon.net.v6x.request;

import android.content.Context;

public abstract class MusicMessageInsertMusicMsgBaseReq extends RequestV6Req {
    public static class Params {
        public String contsIds;
        public String contsTypeCodes;
        public String giftNo;
        public String groupInboxSeq;
        public String mesgCont;
        public String targetMemberkeys;

        public Params() {
            this.targetMemberkeys = "";
            this.contsTypeCodes = "";
            this.contsIds = "";
            this.mesgCont = "";
            this.giftNo = null;
            this.groupInboxSeq = "";
        }
    }

    public MusicMessageInsertMusicMsgBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

