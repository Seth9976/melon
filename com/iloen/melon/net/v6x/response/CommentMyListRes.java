package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class CommentMyListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CMTLIST implements Serializable {
            public static class LANDING implements Serializable {
                @b("CONTSID")
                public String contsId;
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("LIKETYPE")
                public String linkType;
                @b("LINKURL")
                public String linkUrl;
                private static final long serialVersionUID = 0xFE86652514E2FCF2L;
                @b("THUMBIMG")
                public String thumbImg;

                public LANDING() {
                    this.thumbImg = "";
                    this.contsTypeCode = "";
                    this.contsId = "";
                    this.linkType = "";
                    this.linkUrl = "";
                }
            }

            @b("CHNLNAME")
            public String chnlName;
            @b("CHNLSEQ")
            public String chnlSeq;
            @b("CMTCONT")
            public String cmtCont;
            @b("CMTSEQ")
            public String cmtSeq;
            @b("CONTSREFVALUE")
            public String contsRefValue;
            @b("CONTSTITLE")
            public String contsTitle;
            @b("LANDING")
            public LANDING landing;
            @b("REGDATE")
            public String regDate;
            private static final long serialVersionUID = 0xDEF6980CEF5142E0L;
            @b("VIEWCMTSEQ")
            public String viewCmtSeq;

            public CMTLIST() {
                this.chnlName = "";
                this.chnlSeq = "";
                this.cmtCont = "";
                this.cmtSeq = "";
                this.contsRefValue = "";
                this.contsTitle = "";
                this.landing = null;
                this.regDate = "";
                this.viewCmtSeq = "";
            }
        }

        @b("CMTLIST")
        public ArrayList cmtList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xBC8EAE6233EA313FL;

        public RESPONSE() {
            this.cmtList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 1580292437468104602L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        return this.response.cmtList;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

