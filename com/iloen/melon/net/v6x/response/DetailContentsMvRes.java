package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class DetailContentsMvRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("HASMORE")
        public boolean hasMore;
        @b("MVLIST")
        public List mvList;
        @b("PAGEMETANAME")
        public String pageMetaName;
        private static final long serialVersionUID = 0x674BACF6809D96A3L;

        public RESPONSE() {
            this.hasMore = false;
            this.pageMetaName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x75369A4B70D820CAL;

    public DetailContentsMvRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE detailContentsMvRes$RESPONSE0 = this.response;
        return detailContentsMvRes$RESPONSE0 != null ? detailContentsMvRes$RESPONSE0.mvList : null;
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

