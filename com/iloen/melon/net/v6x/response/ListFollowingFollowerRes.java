package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.common.UserInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class ListFollowingFollowerRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class USERLIST extends UserInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0x8B1BE92FE75EC083L;

        }

        @b("FRIENDCNT")
        public String friendCnt;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x580B9DA45BCA235EL;
        @b("USERLIST")
        public ArrayList userList;

        public RESPONSE() {
            this.hasMore = false;
            this.userList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE3A07B679E3BE4BDL;

    public ListFollowingFollowerRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE listFollowingFollowerRes$RESPONSE0 = this.response;
        return listFollowingFollowerRes$RESPONSE0 != null ? listFollowingFollowerRes$RESPONSE0.userList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

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

