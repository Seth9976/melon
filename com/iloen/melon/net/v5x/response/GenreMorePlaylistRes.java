package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class GenreMorePlaylistRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PLYLSTLIST extends GenrePlayListInfoBase {
            private static final long serialVersionUID = 0x6D783BAED319393EL;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLYLSTLIST")
        public ArrayList playlstList;
        private static final long serialVersionUID = 0xD998B4CCA6C1531L;

        public RESPONSE() {
            this.playlstList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x447D9E1B413BD679L;

    public GenreMorePlaylistRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE genreMorePlaylistRes$RESPONSE0 = this.response;
        return genreMorePlaylistRes$RESPONSE0 != null ? genreMorePlaylistRes$RESPONSE0.playlstList : null;
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

