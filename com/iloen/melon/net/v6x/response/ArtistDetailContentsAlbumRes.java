package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ALBUM;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class ArtistDetailContentsAlbumRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMLIST extends ALBUM {
            @b("ISMASTERPIECE")
            public boolean isMasterPiece;
            private static final long serialVersionUID = 0x58F949B1230503A5L;

        }

        @b("ALBUMLIST")
        public List albumList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xE4C1375B95D71A0AL;

        public RESPONSE() {
            this.hasMore = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xC1F49385FAE386A7L;

    public ArtistDetailContentsAlbumRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistDetailContentsAlbumRes$RESPONSE0 = this.response;
        return artistDetailContentsAlbumRes$RESPONSE0 != null ? artistDetailContentsAlbumRes$RESPONSE0.albumList : null;
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

