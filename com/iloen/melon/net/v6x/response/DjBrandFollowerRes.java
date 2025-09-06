package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjBrandFollowerRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("FRIENDCNT")
        public String friendCnt;
        @b("HASMORE")
        public Boolean hasMore;
        private static final long serialVersionUID = 0x723565EC01143612L;
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
    private static final long serialVersionUID = 0x78077512880C5929L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djBrandFollowerRes$RESPONSE0 = this.response;
        return djBrandFollowerRes$RESPONSE0 != null ? djBrandFollowerRes$RESPONSE0.userList : null;
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
        RESPONSE djBrandFollowerRes$RESPONSE0 = this.response;
        if(djBrandFollowerRes$RESPONSE0 != null) {
            return djBrandFollowerRes$RESPONSE0.hasMore == null ? false : djBrandFollowerRes$RESPONSE0.hasMore.booleanValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

