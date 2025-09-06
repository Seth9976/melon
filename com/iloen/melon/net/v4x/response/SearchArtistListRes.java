package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class SearchArtistListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends ArtistInfoBase {
            private static final long serialVersionUID = 0x5FB9F33D8E60060EL;

        }

        @b("CONTENTSLIST")
        public ArrayList contentslist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xD5F3105764FD8F96L;

        public RESPONSE() {
            this.contentslist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD81A9E7C02E95C4L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE searchArtistListRes$RESPONSE0 = this.response;
        return searchArtistListRes$RESPONSE0 != null ? searchArtistListRes$RESPONSE0.contentslist : null;
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

