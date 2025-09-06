package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProgramMoreSongRes extends ResponseV6Res implements ResponseAdapter {
    public static class Response extends ResponseBase {
        public static class EpsdList implements Serializable {
            @b("CNPCKSEQ")
            public String cnpckSeq;
            @b("EPSDNAME")
            public String epsdName;

        }

        public static class SongList extends SongInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("ISTRACKZERO")
            public boolean isTrackzero;

        }

        public static class YearList implements Serializable {
            @b("EPSDLIST")
            public List epsdList;
            @b("YEAR")
            public String year;

        }

        @b("HASMORE")
        public Boolean hasMore;
        @b("SONGLIST")
        public List songList;
        @b("YEARLIST")
        public List yearLists;

    }

    @b("response")
    public Response response;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Response programMoreSongRes$Response0 = this.response;
        return programMoreSongRes$Response0 == null ? new ArrayList() : programMoreSongRes$Response0.songList;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        Response programMoreSongRes$Response0 = this.response;
        if(programMoreSongRes$Response0 != null) {
            return programMoreSongRes$Response0.hasMore == null ? false : programMoreSongRes$Response0.hasMore.booleanValue();
        }
        return false;
    }
}

