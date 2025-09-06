package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class DeleteCmtRes extends CmtBaseRes {
    public static class result implements Serializable {
        @b("cmtSeq")
        public int cmtseq;
        private static final long serialVersionUID = 0x90DF8D7BEA17EF5CL;

        public result() {
            this.cmtseq = -1;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x3966FBE1DA199640L;

    public DeleteCmtRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

