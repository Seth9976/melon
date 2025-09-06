package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class ArtistDetailContentsArtistNoteRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("ARTISTNOTELIST")
        public List artistNoteList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x5C1D85ADB04F0F93L;

        public RESPONSE() {
            this.hasMore = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1CE47A2F85030B61L;

    public ArtistDetailContentsArtistNoteRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE artistDetailContentsArtistNoteRes$RESPONSE0 = this.response;
        return artistDetailContentsArtistNoteRes$RESPONSE0 != null ? artistDetailContentsArtistNoteRes$RESPONSE0.artistNoteList : null;
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

