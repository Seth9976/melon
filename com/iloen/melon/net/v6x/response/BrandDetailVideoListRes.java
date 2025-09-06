package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class BrandDetailVideoListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class VIDEOLIST extends MvInfoBase {
            public static class LINK extends LinkInfoBase {
                private static final long serialVersionUID = 0xD0F0209F6400240AL;

            }

            @b("CONTSTYPECODE")
            public String contstypecode;
            @b("LINK")
            public LINK link;
            private static final long serialVersionUID = 0x7688C47EBCBAD45CL;

            public VIDEOLIST() {
                this.contstypecode = "";
                this.link = null;
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xCD4F5FBDA4809FF8L;
        @b("TOPMEMBERNM")
        public String topMemberNm;
        @b("VIDEOLIST")
        public ArrayList videoList;

        public RESPONSE() {
            this.topMemberNm = "";
            this.videoList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDE219EE9C0A290F2L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE brandDetailVideoListRes$RESPONSE0 = this.response;
        return brandDetailVideoListRes$RESPONSE0 != null ? brandDetailVideoListRes$RESPONSE0.videoList : null;
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

