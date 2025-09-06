package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import javax.annotation.Nullable;

public class InsertCmtRes extends CmtBaseRes {
    public static class result implements Serializable {
        @b("cmtSeq")
        public int cmtseq;
        @b("message")
        public String message;
        private static final long serialVersionUID = -2066565239717047368L;

        public result() {
            this.cmtseq = -1;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    @Nullable
    public result result;
    private static final long serialVersionUID = 0x2D05F9D748E267C2L;

    public InsertCmtRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

