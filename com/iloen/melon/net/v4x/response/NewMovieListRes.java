package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class NewMovieListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MVLIST extends MvInfoBase {
            private static final long serialVersionUID = 0x6CE8F16B4586EDAAL;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("MVLIST")
        public ArrayList mvlists;
        private static final long serialVersionUID = 0xF32880943F3B6240L;

        public RESPONSE() {
            this.mvlists = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x727F4714C8DF4D8FL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE newMovieListRes$RESPONSE0 = this.response;
        return newMovieListRes$RESPONSE0 != null ? newMovieListRes$RESPONSE0.mvlists : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

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

