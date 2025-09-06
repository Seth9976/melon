package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class GenreLabelAlbumlistRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMLIST extends AlbumInfoBase {
            private static final long serialVersionUID = 0x631F48D526EF7329L;

        }

        @b("ALBUMLIST")
        public ArrayList albumList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x2907565FF58F78FEL;

        public RESPONSE() {
            this.albumList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x89DE85ABF5A4CEF2L;

    public GenreLabelAlbumlistRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE genreLabelAlbumlistRes$RESPONSE0 = this.response;
        return genreLabelAlbumlistRes$RESPONSE0 != null ? genreLabelAlbumlistRes$RESPONSE0.albumList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

