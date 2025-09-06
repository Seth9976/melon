package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class DeleteAdcmtRes extends CmtBaseRes {
    public static class result implements Serializable {
        @b("cmtSeq")
        public int cmtseq;
        @b("parntCmtSeq")
        public int parntcmtseq;
        private static final long serialVersionUID = 0x80223FE7FB47B6B4L;

        public result() {
            this.cmtseq = -1;
            this.parntcmtseq = -1;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x313FE8CDD1ED5907L;

    public DeleteAdcmtRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

