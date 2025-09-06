package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class DetailContentsStationRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("HASMORE")
        public boolean hasMore;
        @b("PAGEMETANAME")
        public String pageMetaName;
        private static final long serialVersionUID = 0x6341F744F43990BEL;
        @b("STATIONLIST")
        public List stationList;

        public RESPONSE() {
            this.hasMore = false;
            this.pageMetaName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4D6E09EF365FE2E4L;

    public DetailContentsStationRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE detailContentsStationRes$RESPONSE0 = this.response;
        return detailContentsStationRes$RESPONSE0 != null ? detailContentsStationRes$RESPONSE0.stationList : null;
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

