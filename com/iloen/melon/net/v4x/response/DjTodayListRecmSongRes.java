package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjTodayListRecmSongRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SongList extends SongInfoBase {
            private static final long serialVersionUID = 0xF1A9A836FB8AEA10L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        private static final long serialVersionUID = 0xFE816B9C682F08D5L;
        @b("SONGLIST")
        public ArrayList songList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE8701F2B7BCDA33BL;

    public DjTodayListRecmSongRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djTodayListRecmSongRes$RESPONSE0 = this.response;
        return djTodayListRecmSongRes$RESPONSE0 != null ? djTodayListRecmSongRes$RESPONSE0.songList : null;
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

