package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MusicMessageInsertMusicMsgRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("ALLTARGETBANYN")
        public String alltargetbanyn;
        @b("INBOXSEQ")
        public String inboxseq;
        private static final long serialVersionUID = 0xA1CABC97DF2B4128L;

        public RESPONSE() {
            this.inboxseq = "";
            this.alltargetbanyn = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x50FD44634C7AA7E7L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

