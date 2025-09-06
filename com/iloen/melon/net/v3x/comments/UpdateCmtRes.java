package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class UpdateCmtRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class ATACHLIST extends AtachListBase {
            private static final long serialVersionUID = 0x2EF83A22AA379220L;

        }

        public static class CMTINFO extends CmtInfoBase {
            private static final long serialVersionUID = -6890680416044880181L;

        }

        public static class MEMBERINFO extends MemberInfoBase {
            private static final long serialVersionUID = 0x71A67A2DA5760429L;

        }

        @b("atachList")
        public ArrayList atachlist;
        @b("cmtInfo")
        public CMTINFO cmtinfo;
        @b("memberInfo")
        public MEMBERINFO memberinfo;
        @b("message")
        public String message;
        private static final long serialVersionUID = 0x5A8B1DDFFE43E451L;

        public result() {
            this.cmtinfo = null;
            this.memberinfo = null;
            this.atachlist = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0xE59096E761718D80L;

    public UpdateCmtRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

