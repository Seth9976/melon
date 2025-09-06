package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.CastInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicCastListRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CASTLIST extends CastInfoBase {
            private static final long serialVersionUID = 0x1A3D3269DE498699L;

        }

        @b("CASTLIST")
        public ArrayList castList;
        @b("GUIDETEXT")
        public String guidetext;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x2B088818B94C0A0CL;

        public RESPONSE() {
            this.castList = null;
            this.guidetext = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x9A1700F6BA5A178DL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicCastListRes$RESPONSE0 = this.response;
        return myMusicCastListRes$RESPONSE0 != null ? myMusicCastListRes$RESPONSE0.castList : null;
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

