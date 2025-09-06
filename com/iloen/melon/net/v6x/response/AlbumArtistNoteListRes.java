package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class AlbumArtistNoteListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("ARTISTNOTELIST")
        public List artistNoteList;
        @b("CPLANCODE")
        public String cPlanCode;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x551E99663908CF93L;

        public RESPONSE() {
            this.hasMore = false;
            this.cPlanCode = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x210E4A989DA10B61L;

    public AlbumArtistNoteListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE albumArtistNoteListRes$RESPONSE0 = this.response;
        return albumArtistNoteListRes$RESPONSE0 != null ? albumArtistNoteListRes$RESPONSE0.artistNoteList : null;
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

