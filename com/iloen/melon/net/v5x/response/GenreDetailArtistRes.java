package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class GenreDetailArtistRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMLIST extends AlbumInfoBase {
            private static final long serialVersionUID = 0x75BA92A28288D2FCL;

        }

        public static class ARTIST extends ArtistInfoBase {
            @b("ARTISTCHNLYN")
            public String artistChnlYn;
            @b("ARTISTREVW")
            public String artistRevw;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0x4AAA1F1ABA2F307BL;

        }

        @b("ALBUMLIST")
        public ArrayList albumlists;
        @b("ARTIST")
        public ARTIST artist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;

        public RESPONSE() {
            this.artist = null;
            this.albumlists = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1BAB0935DB106L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Collection collection0 = new ArrayList();
        RESPONSE genreDetailArtistRes$RESPONSE0 = this.response;
        if(genreDetailArtistRes$RESPONSE0 != null) {
            ArrayList arrayList0 = genreDetailArtistRes$RESPONSE0.albumlists;
            if(arrayList0 != null) {
                ((ArrayList)collection0).addAll(arrayList0);
            }
        }
        return collection0;
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

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

