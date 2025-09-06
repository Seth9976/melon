package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class SearchMovieListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends MvInfoBase {
            private static final long serialVersionUID = 0xF60E1EBE104D8CD9L;

        }

        @b("CONTENTSLIST")
        public ArrayList contentslist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xE310D5C971F45C3EL;

        public RESPONSE() {
            this.contentslist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -921969867208636990L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE searchMovieListRes$RESPONSE0 = this.response;
        return searchMovieListRes$RESPONSE0 != null ? searchMovieListRes$RESPONSE0.contentslist : null;
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
}

