package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MusicMessageInformInboxSeqRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ALLTARGETBANYN")
        public String alltargetbanyn;
        @b("GROUPYN")
        public String groupyn;
        @b("INBOXSEQ")
        public String inboxseq;
        private static final long serialVersionUID = 0x6FB97317F17CD0B9L;

        public RESPONSE() {
            this.inboxseq = "";
            this.groupyn = "";
            this.alltargetbanyn = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x7FEFBAD6695B4D78L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

