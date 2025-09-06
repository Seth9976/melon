package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvLikedVideoRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MVLIST extends MvInfoBase {
            private static final long serialVersionUID = 0x65E92F0B6252F2A1L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("MVLIST")
        public ArrayList mvList;
        private static final long serialVersionUID = 0x1C3B0F39F7F72BF7L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2E3EE63EF46798D5L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        if(this.response == null) {
            return null;
        }
        Collection collection0 = new ArrayList();
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

