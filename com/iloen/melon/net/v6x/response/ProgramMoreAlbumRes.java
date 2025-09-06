package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProgramMoreAlbumRes extends ResponseV6Res implements ResponseAdapter {
    public static class Response extends ResponseBase {
        public static class AlbumList extends AlbumInfoBase {
            @b("CTYPE")
            public String cType;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("ISTRACKZERO")
            public boolean isTrackzero;

        }

        @b("ALBUMLIST")
        public List albumList;
        @b("HASMORE")
        public Boolean hasMore;

    }

    @b("response")
    public Response response;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Response programMoreAlbumRes$Response0 = this.response;
        return programMoreAlbumRes$Response0 == null ? new ArrayList() : programMoreAlbumRes$Response0.albumList;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        Response programMoreAlbumRes$Response0 = this.response;
        if(programMoreAlbumRes$Response0 != null) {
            return programMoreAlbumRes$Response0.hasMore == null ? false : programMoreAlbumRes$Response0.hasMore.booleanValue();
        }
        return false;
    }
}

