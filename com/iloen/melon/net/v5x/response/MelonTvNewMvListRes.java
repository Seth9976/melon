package com.iloen.melon.net.v5x.response;

import S7.b;
import android.text.TextUtils;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvNewMvListRes extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MVLIST extends MvInfoBase {
            private static final long serialVersionUID = 0x6DF3415C4CABE4CCL;

        }

        public static class RECOMMENDATION extends MvInfoBase {
            private static final long serialVersionUID = -2930624814290596005L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("MVLIST")
        public ArrayList mvList;
        @b("RECOMMENDATION")
        public RECOMMENDATION recommendation;
        private static final long serialVersionUID = 0x60AA5F1A0E1D5C8DL;

        public RESPONSE() {
            this.recommendation = null;
            this.mvList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3E3753F611B43043L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        if(this.response == null) {
            return null;
        }
        Collection collection0 = new ArrayList();
        RECOMMENDATION melonTvNewMvListRes$RESPONSE$RECOMMENDATION0 = this.response.recommendation;
        if(melonTvNewMvListRes$RESPONSE$RECOMMENDATION0 != null && !TextUtils.isEmpty(melonTvNewMvListRes$RESPONSE$RECOMMENDATION0.mvId)) {
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

