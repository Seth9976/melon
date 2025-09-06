package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class StationHomeRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class PROGRAMLIST implements Serializable {
            @b("BGCOLOR")
            public String bgColor;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            public boolean isFirst;
            public boolean isLast;
            @b("LATESTCASTSEQ")
            public String latestCastSeq;
            @b("NEWYN")
            public String newYn;
            @b("PROGIMGURL")
            public String progImgUrl;
            @b("PROGSEQ")
            public String progSeq;
            @b("PROGSUBTITLE")
            public String progSubTitle;
            @b("PROGTITLE")
            public String progTitle;
            private static final long serialVersionUID = 0xC7340A6822D94C6BL;
            public String subscribeYn;

            public PROGRAMLIST() {
                this.newYn = "N";
                this.isFirst = false;
                this.isLast = false;
                this.subscribeYn = "N";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class TOPOFFERLIST extends LinkInfoBase {
            @b("BGCOLOR")
            public String bgColor;
            @b("CONTSID")
            public String contsId;
            @b("CONTSTITLE")
            public String contsTitle;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("IMGURL")
            public String imgUrl;
            private static final long serialVersionUID = 0x5F6D790A29868FABL;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;
            @b("VIEWTYPE")
            public String viewType;

            @Override  // com.melon.net.res.common.LinkInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("PROGRAMLIST")
        public ArrayList programList;
        private static final long serialVersionUID = 0x34D36A804D163DF0L;
        @b("TOPOFFERLIST")
        public ArrayList topOfferList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 7391410000421085937L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

