package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class DjPicksListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PICKLIST implements Serializable {
            @b("NO")
            public String No;
            @b("IMGURL")
            public String imgUrl;
            @b("ISNOWYN")
            public String isNowYn;
            @b("PICKDESC")
            public String pickDesc;
            @b("PICKID")
            public String pickId;
            @b("PICKTITLE")
            public String pickTitle;
            private static final long serialVersionUID = 0x1012F0E79EDB5AA0L;
            @b("VALIDCMTCNT")
            public String validCmtCnt;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PICKLIST")
        public ArrayList pickList;
        private static final long serialVersionUID = -5012378803057083270L;

        public RESPONSE() {
            this.hasMore = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDF5238C46F2E8A19L;

    public DjPicksListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djPicksListRes$RESPONSE0 = this.response;
        return djPicksListRes$RESPONSE0 != null ? djPicksListRes$RESPONSE0.pickList : null;
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
}

