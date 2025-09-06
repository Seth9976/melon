package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.FeedLogInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.Collection;
import java.util.List;

public class FeedLogsListRes extends ResponseV6Res implements ResponseAdapter {
    public static class FEEDLOGLIST extends FeedLogInfoBase {
        private boolean isToday;
        private static final long serialVersionUID = 0x4D952E26F6037051L;

        public FEEDLOGLIST() {
            this.isToday = false;
        }

        public boolean isToday() {
            return this.isToday;
        }

        public void setToday(boolean z) {
            this.isToday = z;
        }
    }

    public static class RESPONSE extends ResponseBase {
        @b("BEFORELIST")
        public List beforeList;
        @b("HASMORE")
        public boolean hasMore;
        @b("LASTINDEXKEY")
        public String lastIndexKey;
        private static final long serialVersionUID = 0xA3A81DC104B0C54DL;
        @b("TODAYLIST")
        public List todayList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x73FB68DDE12CE5AL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        return null;
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

