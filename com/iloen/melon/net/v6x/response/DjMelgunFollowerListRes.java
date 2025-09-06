package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjMelgunFollowerListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("FRIENDCNT")
        public String friendCount;
        @b("HASMORE")
        public boolean hasMore;
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
        RESPONSE djMelgunFollowerListRes$RESPONSE0 = this.response;
        return djMelgunFollowerListRes$RESPONSE0 != null ? djMelgunFollowerListRes$RESPONSE0.userList : null;
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

