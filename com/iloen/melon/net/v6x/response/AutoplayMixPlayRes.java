package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.PlaylistSongInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class AutoplayMixPlayRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends PlaylistSongInfoBase {
            private static final long serialVersionUID = 0x66E33DA04FE7C0A5L;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0x6A5B12FBB9C1DE96L;

        }

        @b("MAINREPLACE")
        public String mainReplace;
        @b("MAINTITLE")
        public String mainTitle;
        private static final long serialVersionUID = 0x326FE5CAD8315000L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.songList = null;
            this.statsElements = null;
            this.mainTitle = null;
            this.mainReplace = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA898FA32347AD02FL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Collection collection0 = new ArrayList();
        RESPONSE autoplayMixPlayRes$RESPONSE0 = this.response;
        if(autoplayMixPlayRes$RESPONSE0 != null) {
            ArrayList arrayList0 = autoplayMixPlayRes$RESPONSE0.songList;
            if(arrayList0 != null) {
                ((ArrayList)collection0).addAll(arrayList0);
            }
        }
        return collection0;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        RESPONSE autoplayMixPlayRes$RESPONSE0 = this.response;
        return autoplayMixPlayRes$RESPONSE0 != null ? autoplayMixPlayRes$RESPONSE0.statsElements : null;
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

