package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.common.UserInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class SearchMemberListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends UserInfoBase {
            private static final long serialVersionUID = 0x8B1BE92FE75EC083L;

        }

        @b("CONTENTSLIST")
        public ArrayList contentslist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x580B9DA45BCA235EL;

        public RESPONSE() {
            this.hasMore = false;
            this.contentslist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE3A07B679E3BE4BDL;

    public SearchMemberListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE searchMemberListRes$RESPONSE0 = this.response;
        return searchMemberListRes$RESPONSE0 != null ? searchMemberListRes$RESPONSE0.contentslist : null;
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

