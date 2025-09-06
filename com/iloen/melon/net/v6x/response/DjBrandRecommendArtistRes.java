package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjBrandRecommendArtistRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        @b("RECMARTISTLIST")
        public ArrayList contentsList;
        @b("HASMORE")
        public Boolean hasMore;
        private static final long serialVersionUID = 0x79053758D2D651FAL;
        @b("TOPMEMBERNM")
        public String topMemberNm;

        public RESPONSE() {
            this.topMemberNm = "";
            this.contentsList = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE2E04ADB5378B733L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djBrandRecommendArtistRes$RESPONSE0 = this.response;
        return djBrandRecommendArtistRes$RESPONSE0 != null ? djBrandRecommendArtistRes$RESPONSE0.contentsList : null;
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
        RESPONSE djBrandRecommendArtistRes$RESPONSE0 = this.response;
        if(djBrandRecommendArtistRes$RESPONSE0 != null) {
            return djBrandRecommendArtistRes$RESPONSE0.hasMore == null ? false : djBrandRecommendArtistRes$RESPONSE0.hasMore.booleanValue();
        }
        return false;
    }
}

