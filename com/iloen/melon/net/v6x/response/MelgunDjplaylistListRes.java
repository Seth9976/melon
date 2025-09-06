package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelgunDjplaylistListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("HASMORE")
        public boolean hasMore;
        @b("DJPLAYLISTLIST")
        public ArrayList plylstListList;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;
        @b("TOPMEMBERNM")
        public String topMemberNm;

        public RESPONSE() {
            this.topMemberNm = "";
            this.plylstListList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79B255E5E90836ADL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE melgunDjplaylistListRes$RESPONSE0 = this.response;
        return melgunDjplaylistListRes$RESPONSE0 != null ? melgunDjplaylistListRes$RESPONSE0.plylstListList : null;
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

