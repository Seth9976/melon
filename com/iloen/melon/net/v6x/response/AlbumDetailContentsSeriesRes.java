package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class AlbumDetailContentsSeriesRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("SERIESALBUMLIST")
        public List albums;
        @b("HASMORE")
        public boolean hasMore;
        @b("PAGEMETANAME")
        public String pageMetaName;
        private static final long serialVersionUID = 0xC877CFDC4AF005A1L;

        public RESPONSE() {
            this.hasMore = false;
            this.pageMetaName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 4200806424347785821L;

    public AlbumDetailContentsSeriesRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE albumDetailContentsSeriesRes$RESPONSE0 = this.response;
        return albumDetailContentsSeriesRes$RESPONSE0 != null ? albumDetailContentsSeriesRes$RESPONSE0.albums : null;
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

