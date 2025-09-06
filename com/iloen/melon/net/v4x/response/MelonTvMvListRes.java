package com.iloen.melon.net.v4x.response;

import S7.b;
import android.text.TextUtils;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvMvListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MVLIST extends MvInfoBase {
            @b("CURRANK")
            public String curRank;
            @b("PASTRANK")
            public String pastRank;
            @b("RANKGAP")
            public String rankGap;
            @b("RANKTYPE")
            public String rankType;
            private static final long serialVersionUID = 0x692442D7344D8DADL;

            public MVLIST() {
                this.curRank = "";
                this.pastRank = "";
                this.rankType = "";
                this.rankGap = "";
            }
        }

        public static class RECOMMENDATION extends MvInfoBase {
            private static final long serialVersionUID = 0x610E61CBEA7DC823L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("MVLIST")
        public ArrayList mvList;
        @b("RECOMMENDATION")
        public RECOMMENDATION recommendation;
        private static final long serialVersionUID = 2002153604668558418L;

        public RESPONSE() {
            this.recommendation = null;
            this.mvList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 3833063935090746597L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        if(this.response == null) {
            return null;
        }
        Collection collection0 = new ArrayList();
        RECOMMENDATION melonTvMvListRes$RESPONSE$RECOMMENDATION0 = this.response.recommendation;
        if(melonTvMvListRes$RESPONSE$RECOMMENDATION0 != null && !TextUtils.isEmpty(melonTvMvListRes$RESPONSE$RECOMMENDATION0.mvId)) {
            ((ArrayList)collection0).add(this.response.recommendation);
        }
        ArrayList arrayList0 = this.response.mvList;
        if(arrayList0 != null) {
            ((ArrayList)collection0).addAll(arrayList0);
        }
        return collection0;
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

