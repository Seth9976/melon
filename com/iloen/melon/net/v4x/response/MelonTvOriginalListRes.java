package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.TvProgramBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvOriginalListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ENDPROGLIST extends TvProgramBase {
            private static final long serialVersionUID = 0x33D2BBD1F1C66D77L;

        }

        public static class MVLIST extends MvInfoBase {
            private static final long serialVersionUID = 0x33D3CF65DCAFDD67L;

        }

        public static class PROGLIST extends TvProgramBase {
            private static final long serialVersionUID = 0xC25F8DC0FBBA8CACL;

        }

        public static class RECMPROGLIST extends TvProgramBase {
            private static final long serialVersionUID = 0x33D3CE7CCC8E8E8BL;

        }

        @b("ENDPROGLIST")
        public ArrayList endProgramList;
        @b("HASMORE")
        public boolean hasMore;
        @b("MVLIST")
        public ArrayList mvList;
        @b("PROGLIST")
        public ArrayList programList;
        @b("RECMPROGLIST")
        public ArrayList recmProgramList;
        private static final long serialVersionUID = 0x1C93FEAE5AA1E9E4L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x23C839386FA84989L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE melonTvOriginalListRes$RESPONSE0 = this.response;
        return melonTvOriginalListRes$RESPONSE0 != null ? melonTvOriginalListRes$RESPONSE0.mvList : null;
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
}

