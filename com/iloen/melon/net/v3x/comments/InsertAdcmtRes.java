package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class InsertAdcmtRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class ADCMTLIST extends CmtInfoBase {
            private static final long serialVersionUID = 0xEA5040E5484D5DE0L;

        }

        public static class MEMBERINFO extends MemberInfoBase {
            private static final long serialVersionUID = 0xDA443572AF713301L;

        }

        @b("adcmtList")
        public ArrayList adcmtlist;
        @b("memberInfo")
        public MEMBERINFO memberinfo;
        @b("message")
        public String message;
        private static final long serialVersionUID = 0xD393E05C186FA144L;

        public result() {
            this.adcmtlist = null;
            this.memberinfo = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x3852ECA879440092L;

    public InsertAdcmtRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

