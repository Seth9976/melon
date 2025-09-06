package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class SearchAlbumListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends AlbumInfoBase {
            private static final long serialVersionUID = -8164714007903026455L;

        }

        @b("CONTENTSLIST")
        public ArrayList contentslist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x2B4BBBE0CE06ECA1L;

        public RESPONSE() {
            this.contentslist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -6501983056825035010L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE searchAlbumListRes$RESPONSE0 = this.response;
        return searchAlbumListRes$RESPONSE0 != null ? searchAlbumListRes$RESPONSE0.contentslist : null;
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

