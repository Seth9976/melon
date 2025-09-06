package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class ArtistContentsInfoLikeAndCmtRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class USERACTIONINFO implements Serializable {
            @b("CONTSID")
            public String contsId;
            @b("LIKECNT")
            public String likeCnt;
            private static final long serialVersionUID = 2572081912102504092L;
            @b("TOTALCMTCNT")
            public String totalCmtCnt;

            public USERACTIONINFO() {
                this.contsId = "";
                this.likeCnt = "";
                this.totalCmtCnt = "";
            }
        }

        private static final long serialVersionUID = 4360435063070454540L;
        @b("USERACTIONINFO")
        public USERACTIONINFO userActionInfo;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xFAC193F3EC210F6L;

    public ArtistContentsInfoLikeAndCmtRes() {
        this.response = null;
    }
}

