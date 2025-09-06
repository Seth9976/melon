package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicRecentListMvRecntRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MVLIST extends MvInfoBase {
            @b("CONTSTYPECODE")
            public String contstypecode;
            private static final long serialVersionUID = 0x3976E393F8B53A08L;

            public MVLIST() {
                this.contstypecode = "";
            }
        }

        @b("GUIDETEXT")
        public String guidetext;
        @b("HASMORE")
        public boolean hasMore;
        @b("MVLIST")
        public ArrayList mvlist;
        private static final long serialVersionUID = 0x2B088818B94C0A0CL;

        public RESPONSE() {
            this.mvlist = null;
            this.guidetext = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3E5DCC350264CE93L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicRecentListMvRecntRes$RESPONSE0 = this.response;
        return myMusicRecentListMvRecntRes$RESPONSE0 != null ? myMusicRecentListMvRecntRes$RESPONSE0.mvlist : null;
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

