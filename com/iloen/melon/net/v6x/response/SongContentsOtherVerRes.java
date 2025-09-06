package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes.DetailResponseBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes;
import java.util.Collection;
import java.util.List;

public class SongContentsOtherVerRes extends DetailBaseRes implements ResponseAdapter {
    public static class RESPONSE extends DetailResponseBase {
        @b("HASMORE")
        public boolean hasMore;
        @b("PAGEMETANAME")
        public String pageMetaName;
        private static final long serialVersionUID = 0xFC5446E06061057DL;
        @b("SONGLIST")
        public List songs;

        public RESPONSE() {
            this.pageMetaName = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x6BD457C5C0AFC781L;

    public SongContentsOtherVerRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE songContentsOtherVerRes$RESPONSE0 = this.response;
        return songContentsOtherVerRes$RESPONSE0 != null ? songContentsOtherVerRes$RESPONSE0.songs : null;
    }

    @Override  // com.iloen.melon.net.v5x.response.DetailBaseRes
    public DetailResponseBase getResponseBase() {
        return this.response;
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

