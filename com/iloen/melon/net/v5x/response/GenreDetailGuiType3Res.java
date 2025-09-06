package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class GenreDetailGuiType3Res extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMLIST extends AlbumInfoBase {
            private static final long serialVersionUID = 0xDC18531F524B8DC9L;

        }

        @b("ALBUMLIST")
        public ArrayList albumList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x922754CF7D87FABEL;
        @b("TITLE")
        public String title;

        public RESPONSE() {
            this.albumList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 4074058828465400673L;

    public GenreDetailGuiType3Res() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE genreDetailGuiType3Res$RESPONSE0 = this.response;
        return genreDetailGuiType3Res$RESPONSE0 != null ? genreDetailGuiType3Res$RESPONSE0.albumList : null;
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

