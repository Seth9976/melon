package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class PinnedRes extends CmtBaseRes {
    public static class PinnedResult implements Serializable {
        @b("cmtSeq")
        public int cmtseq;
        private static final long serialVersionUID = 0x586CA9514E00CC1DL;
        @b("unpinnedFlag")
        public boolean unpinnedFlag;

        public PinnedResult() {
            this.cmtseq = -1;
            this.unpinnedFlag = false;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public PinnedResult result;
    private static final long serialVersionUID = 0xE9276312D8809DF4L;

    public PinnedRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

