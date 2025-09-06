package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class BrandDetailMagazineListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MAGAZINE implements Serializable {
            public static class LINK extends LinkInfoBase {
                private static final long serialVersionUID = 0x7688C47EBCBAD45CL;

            }

            @b("CATTENAME")
            public String catteName;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("LINK")
            public LINK link;
            @b("LISTIMG")
            public String listImg;
            @b("MSTORYSEQ")
            public String mStorySeq;
            @b("MSTORYTITLE")
            public String mStoryTitle;
            @b("RSRVDATE")
            public String rsrvDate;
            private static final long serialVersionUID = 0x7688C47EBCBAD45CL;

            public MAGAZINE() {
                this.mStorySeq = "";
                this.mStoryTitle = "";
                this.catteName = "";
                this.listImg = "";
                this.rsrvDate = "";
                this.contsTypeCode = "";
                this.link = null;
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        @b("MAGAZINELIST")
        public ArrayList magazineList;
        private static final long serialVersionUID = 0xCD4F5FBDA4809FF8L;
        @b("TOPMEMBERNM")
        public String topMemberNm;

        public RESPONSE() {
            this.topMemberNm = "";
            this.magazineList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDE219EE9C0A290F2L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE brandDetailMagazineListRes$RESPONSE0 = this.response;
        return brandDetailMagazineListRes$RESPONSE0 != null ? brandDetailMagazineListRes$RESPONSE0.magazineList : null;
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
        return this.response == null ? false : this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

