package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class InsertRecmRes extends CmtBaseRes {
    public static class InsertResult implements Serializable {
        public static class RecmInfo implements Serializable {
            @b("cmtSeq")
            public int cmtseq;
            @b("message")
            public String message;
            @b("nonRecmChgCount")
            public int nonRecmChgCount;
            @b("nonRecmFlag")
            public boolean nonrecmflag;
            @b("recmChgCount")
            public int recmChgCount;
            @b("recmFlag")
            public boolean recmFlag;
            @b("recommenderInfo")
            public MEMBERINFO recommenderInfo;
            private static final long serialVersionUID = -6145998013053092423L;

            public RecmInfo() {
                this.cmtseq = -1;
                this.recmFlag = false;
                this.nonrecmflag = false;
                this.recmChgCount = 0;
                this.nonRecmChgCount = 0;
                this.recommenderInfo = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("recmInfo")
        public RecmInfo recmInfo;
        private static final long serialVersionUID = 0xAAB50761C092FF7DL;

        public InsertResult() {
            this.recmInfo = null;
        }
    }

    @b("result")
    public InsertResult result;
    private static final long serialVersionUID = 0xA753D7B1D22A9353L;

    public InsertRecmRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

