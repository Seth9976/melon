package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class LikeListTagBaseRes extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class TAGLIST extends TagInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("PLYLSTCNT")
            public String plylstCnt;
            private static final long serialVersionUID = 0xC076EF81D43FE803L;
            @b("SUMMCNT")
            public String summcnt;
            @b("TAGIMG")
            public String tagImg;

            public TAGLIST() {
                this.summcnt = "";
                this.contsTypeCode = "";
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xD720537F7F5B5917L;
        @b("TAGLIST")
        public ArrayList taglistList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4E43C09CE98E3E5BL;

    public LikeListTagBaseRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE likeListTagBaseRes$RESPONSE0 = this.response;
        return likeListTagBaseRes$RESPONSE0 != null ? likeListTagBaseRes$RESPONSE0.taglistList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.hasMore;
    }
}

