package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjBrandLikeMemberRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("HASMORE")
        public Boolean hasMore;
        @b("LIKESUMMCNT")
        public String likeSumMCnt;
        private static final long serialVersionUID = 0xC7AA3C4CA2F28EB8L;
        @b("TOPMEMBERNM")
        public String topMemberNm;
        @b("USERLIST")
        public ArrayList userList;

        public RESPONSE() {
            this.userList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA09B90D6AC6908AAL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djBrandLikeMemberRes$RESPONSE0 = this.response;
        return djBrandLikeMemberRes$RESPONSE0 != null ? djBrandLikeMemberRes$RESPONSE0.userList : null;
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
        RESPONSE djBrandLikeMemberRes$RESPONSE0 = this.response;
        if(djBrandLikeMemberRes$RESPONSE0 != null) {
            return djBrandLikeMemberRes$RESPONSE0.hasMore == null ? false : djBrandLikeMemberRes$RESPONSE0.hasMore.booleanValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

