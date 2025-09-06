package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MainNoticePopupRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class NoticePopup implements Serializable {
            public static class BANON implements Serializable {
                @b("DT")
                public String dt;
                @b("EXP")
                public String exp;
                @b("ID")
                public String id;
                private static final long serialVersionUID = 0x23FC7E0EBF2C48A4L;

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            public static class EXPIREDBANS implements Serializable {
                @b("ID")
                public String id;
                private static final long serialVersionUID = 0x3F1684FC8BFC0FEDL;

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("BANON")
            public BANON banon;
            @b("CONTENT")
            public String content;
            @b("DPTITLE")
            public String dpTitle;
            @b("DPTYPE")
            public String dpType;
            @b("EXPIREDBANS")
            public ArrayList expiredBans;
            @b("NOTICESEQ")
            public String noticeSeq;
            private static final long serialVersionUID = -8113049348735244005L;

            public NoticePopup() {
                this.expiredBans = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("NOTICEPOPUP")
        public NoticePopup noticePopup;
        private static final long serialVersionUID = 0x1F61BC3D0040D67BL;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x22962E51CA3F9B08L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

