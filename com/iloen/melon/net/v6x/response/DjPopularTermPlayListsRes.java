package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.common.DjPlayListRankingInfo;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class DjPopularTermPlayListsRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class DJPLAYLISTLIST extends DjPlayListRankingInfo {
            private static final long serialVersionUID = -7599033965959412930L;

        }

        @b("CHARTDATETEXT")
        public String chartDateText;
        @b("DJPLAYLISTLIST")
        public List djPlayListList;
        @b("POPDJPTOOLTIP")
        public String popDjpTooltip;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x775C7151FD66CDE2L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djPopularTermPlayListsRes$RESPONSE0 = this.response;
        return djPopularTermPlayListsRes$RESPONSE0 != null ? djPopularTermPlayListsRes$RESPONSE0.djPlayListList : null;
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
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

