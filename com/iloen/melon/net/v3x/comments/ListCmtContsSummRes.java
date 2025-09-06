package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class ListCmtContsSummRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class CMTCONTSSUMMLIST implements Serializable {
            @b("chnlSeq")
            public int chnlseq;
            @b("contsRefValue")
            public String contsrefvalue;
            private static final long serialVersionUID = 0x2A1A8551E10ABE2CL;
            @b("totalAdcmtCnt")
            public int totaladcmtcnt;
            @b("totalCmtCnt")
            public int totalcmtcnt;
            @b("totalCnt")
            public int totalcnt;
            @b("validAdcmtCnt")
            public int validadcmtcnt;
            @b("validCmtCnt")
            public int validcmtcnt;
            @b("validCnt")
            public int validcnt;

            public CMTCONTSSUMMLIST() {
                this.chnlseq = -1;
                this.contsrefvalue = "";
                this.totalcnt = -1;
                this.validcnt = -1;
                this.totalcmtcnt = -1;
                this.validcmtcnt = -1;
                this.totaladcmtcnt = -1;
                this.validadcmtcnt = -1;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("chnlSeq")
        public int chnlseq;
        @b("cmtContsSummList")
        public ArrayList cmtcontssummlist;
        private static final long serialVersionUID = 0x90B06D7F5E4388AFL;

        public result() {
            this.chnlseq = -1;
            this.cmtcontssummlist = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x6F5545ACEDAD546FL;

    public ListCmtContsSummRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

