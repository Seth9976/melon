package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MusicMessageDeleteMusicMsgInboxRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("GROUPYN")
        public String groupyn;
        @b("INBOXSEQ")
        public String inboxseq;
        private static final long serialVersionUID = 0x3404F788B0673424L;

        public RESPONSE() {
            this.groupyn = "";
            this.inboxseq = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x8376E95AF80273F3L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

