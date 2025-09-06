package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public class InformCmtContsSummRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class CMTCONTSSUMM implements Serializable {
            @b("chnlSeq")
            public int chnlSeq;
            @b("contsRefValue")
            public String contsRefValue;
            @b("hotFlag")
            public boolean hotFlag;
            @b("newFlag")
            public boolean newFlag;
            private static final long serialVersionUID = 0x999D9D3FDB5773A7L;
            @b("totalAdcmtCnt")
            public int totalAdcmtCnt;
            @b("totalCmtCnt")
            public int totalCmtCnt;
            @b("totalCnt")
            public int totalCnt;
            @b("validAdcmtCnt")
            public int validAdcmtCnt;
            @b("validCmtCnt")
            public int validCmtCnt;
            @b("validCnt")
            public int validCnt;

            public CMTCONTSSUMM() {
                this.contsRefValue = "";
            }
        }

        @b("cmtContsSumm")
        public CMTCONTSSUMM cmtContsSumm;
        private static final long serialVersionUID = 0x669C8F8495C001DCL;

        @Override
        @NotNull
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x642286EEFAED5E7DL;

    public InformCmtContsSummRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

