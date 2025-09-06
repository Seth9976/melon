package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ArtistPickUserActionCntRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class USERACTIONCNTLIST implements Serializable {
            @b("ARTISTPICKSEQ")
            public String artistPickSeq;
            @b("CMTCNT")
            public String cmtCnt;
            @b("LIKECNT")
            public String likeCnt;
            private static final long serialVersionUID = -4423609927157520195L;

            public USERACTIONCNTLIST() {
                this.artistPickSeq = "";
                this.likeCnt = "";
                this.cmtCnt = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        private static final long serialVersionUID = 0x8C59BF6FC96A9827L;
        @b("USERACTIONCNTLIST")
        public ArrayList userActionCntList;

        public RESPONSE() {
            this.userActionCntList = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE9028EF30154A8BEL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

