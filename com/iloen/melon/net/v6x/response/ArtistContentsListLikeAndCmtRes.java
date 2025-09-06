package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;

public class ArtistContentsListLikeAndCmtRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class USERACTIONLIST implements Serializable {
            public static class CMTLIST extends com.iloen.melon.net.v6x.common.TopicInfoBase.CMTLIST {
                private static final long serialVersionUID = 0x3E619DAD6A6D307BL;

            }

            @b("CMTLIST")
            public List cmtList;
            @b("CONTSID")
            public String contsId;
            @b("LIKECNT")
            public String likeCnt;
            private static final long serialVersionUID = 0xF09AF4CED02B0B39L;
            @b("TOTALCMTCNT")
            public String totalCmtCnt;

            public USERACTIONLIST() {
                this.contsId = "";
                this.likeCnt = "";
                this.totalCmtCnt = "";
            }
        }

        private static final long serialVersionUID = 0x59A4D1E99E73F36EL;
        @b("USERACTIONLIST")
        public List userActionList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB5123F388AF20F6AL;

    public ArtistContentsListLikeAndCmtRes() {
        this.response = null;
    }
}

