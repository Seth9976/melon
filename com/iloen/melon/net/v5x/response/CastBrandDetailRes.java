package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class CastBrandDetailRes extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PROGRAMLIST extends ProgramBase {
            @b("MOREDATA")
            public boolean moreData;
            private static final long serialVersionUID = 0xCDF75B25402F8DD3L;

            public PROGRAMLIST() {
                this.moreData = false;
            }
        }

        @b("HASMORE")
        public Boolean hasMore;
        @b("PROGRAMLIST")
        public ArrayList programList;
        private static final long serialVersionUID = 0xF698C8F0BDB639C2L;

        public RESPONSE() {
            this.programList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xAC2631F420FE6829L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE castBrandDetailRes$RESPONSE0 = this.response;
        return castBrandDetailRes$RESPONSE0 != null ? castBrandDetailRes$RESPONSE0.programList : null;
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
        RESPONSE castBrandDetailRes$RESPONSE0 = this.response;
        if(castBrandDetailRes$RESPONSE0 != null) {
            return castBrandDetailRes$RESPONSE0.hasMore == null ? false : castBrandDetailRes$RESPONSE0.hasMore.booleanValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

