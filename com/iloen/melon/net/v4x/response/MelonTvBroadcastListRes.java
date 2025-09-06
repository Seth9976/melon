package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.TvProgramBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvBroadcastListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class ENDPROGLIST extends TvProgramBase {
            private static final long serialVersionUID = 0x33CBA0D0B8E7E477L;

        }

        public static class MVLIST extends MvInfoBase {
            private static final long serialVersionUID = 0x33ACB83A85D3F767L;

        }

        public static class PROGLIST extends TvProgramBase {
            private static final long serialVersionUID = 0xC25F8DC69F6B348CL;

        }

        public static class RECMPROGLIST extends TvProgramBase {
            private static final long serialVersionUID = 0x33D2AB72F24ECC8BL;

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
        private static final long serialVersionUID = 0x4000ED86E1465976L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB22E14F8280AD655L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE melonTvBroadcastListRes$RESPONSE0 = this.response;
        return melonTvBroadcastListRes$RESPONSE0 != null ? melonTvBroadcastListRes$RESPONSE0.mvList : null;
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

