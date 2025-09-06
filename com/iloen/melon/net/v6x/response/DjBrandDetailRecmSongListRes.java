package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjBrandDetailRecmSongListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class RECMSONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 3215430670872060387L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLAYTIME")
        public String playTime;
        @b("RECMSONGLIST")
        public ArrayList recmSongList;
        private static final long serialVersionUID = 3217439570470160387L;
        @b("SONGCNT")
        public String songCount;
        @b("TOPMEMBERNM")
        public String topMemberNm;

        public RESPONSE() {
            this.topMemberNm = "";
            this.playTime = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x324898717AE15D65L;

    public DjBrandDetailRecmSongListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Collection collection0 = this.response.recmSongList;
        return collection0 != null ? collection0 : new ArrayList();
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

