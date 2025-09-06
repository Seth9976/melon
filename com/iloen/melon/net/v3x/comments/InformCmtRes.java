package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class InformCmtRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class ADCMTLIST extends AdCmtListBase {
            private static final long serialVersionUID = 0x47A84D1CD414EA4EL;

        }

        public static class ATACHLIST extends AtachListBase {
            private static final long serialVersionUID = 0x418984475696E090L;

        }

        public static class CMTINFO extends CmtInfoBase {
            private static final long serialVersionUID = 0x5910A4C00F03B135L;

        }

        public static class MEMBERINFO extends MemberInfoBase {
            private static final long serialVersionUID = 0xCF6D84A50D5546F8L;

        }

        @b("adcmtList")
        public ArrayList adcmtlist;
        @b("atachList")
        public ArrayList atachlist;
        @b("cmtInfo")
        public CMTINFO cmtinfo;
        @b("memberInfo")
        public MEMBERINFO memberinfo;
        @b("recommenderInfo")
        public MEMBERINFO recommenderInfo;
        private static final long serialVersionUID = 0x5B9BF22AF32F2B61L;

        public result() {
            this.cmtinfo = null;
            this.memberinfo = null;
            this.recommenderInfo = null;
            this.atachlist = null;
            this.adcmtlist = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x7BB2E8899AC0C159L;

    public InformCmtRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

