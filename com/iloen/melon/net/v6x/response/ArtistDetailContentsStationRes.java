package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class ArtistDetailContentsStationRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("ARTISTNAME")
        public String artistName;
        @b("CASTLIST")
        public List castList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x158A438857140FD1L;

        public RESPONSE() {
            this.artistName = "";
            this.hasMore = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 3764008738731977809L;

    public ArtistDetailContentsStationRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistDetailContentsStationRes$RESPONSE0 = this.response;
        return artistDetailContentsStationRes$RESPONSE0 != null ? artistDetailContentsStationRes$RESPONSE0.castList : null;
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

