package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjBrandDetailDjplaylistListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class DJPLAYLISTLIST extends DjPlayListInfoBase {
            private static final long serialVersionUID = 0x2C9F895A4B860F53L;

        }

        @b("DJPLAYLISTLIST")
        public ArrayList djPlaylistList;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x2CA6A44035233E13L;
        @b("TOPMEMBERNM")
        public String topMemberNm;

        public RESPONSE() {
            this.topMemberNm = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3248987198A60FCBL;

    public DjBrandDetailDjplaylistListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Collection collection0 = this.response.djPlaylistList;
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

