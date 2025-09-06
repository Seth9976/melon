package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MusicMessageDeleteMusicMsgInboxContentsRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("GROUPYN")
        public String groupyn;
        @b("INBOXSEQ")
        public String inboxseq;
        @b("MUSICMESGSEQ")
        public String musicmesgseq;
        @b("OLDDATAYN")
        public String olddatayn;
        private static final long serialVersionUID = 0xCC17E1A94F28707AL;
        @b("TIMESTAMP")
        public String timestamp;
        @b("TRNSMTYE")
        public String trnsmtye;

        public RESPONSE() {
            this.groupyn = "";
            this.olddatayn = "";
            this.musicmesgseq = "";
            this.trnsmtye = "";
            this.timestamp = "";
            this.inboxseq = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 6522017972018257281L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

