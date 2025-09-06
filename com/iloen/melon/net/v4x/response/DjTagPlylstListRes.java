package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjTagPlylstListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PLYLSTLIST extends DjPlayListInfoBase {
            private static final long serialVersionUID = 0x913848220F5592ECL;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("LASTINDEXKEY")
        public String lastIndexKey;
        @b("PLYLSTLIST")
        public ArrayList plylstList;
        private static final long serialVersionUID = 0x31C72757FFE17C60L;

        public RESPONSE() {
            this.hasMore = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79704B602A08D89BL;

    public DjTagPlylstListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djTagPlylstListRes$RESPONSE0 = this.response;
        return djTagPlylstListRes$RESPONSE0 != null ? djTagPlylstListRes$RESPONSE0.plylstList : null;
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

