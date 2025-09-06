package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class MyMusicLikeListContentsLikeRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST implements Serializable {
            @b("CONTSID")
            public String contsid;
            @b("LIKEYN")
            public String likeyn;
            private static final long serialVersionUID = 0x63C412FFB74281E3L;
            @b("SUMMCNT")
            public String summcnt;

            public CONTENTSLIST() {
                this.contsid = "";
                this.likeyn = "";
                this.summcnt = "";
            }
        }

        @b("CONTENTSLIST")
        public ArrayList contentslist;
        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xC4F880E0F3A90B4AL;

        public RESPONSE() {
            this.contentslist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF1D33E3168CC046L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE myMusicLikeListContentsLikeRes$RESPONSE0 = this.response;
        return myMusicLikeListContentsLikeRes$RESPONSE0 != null ? myMusicLikeListContentsLikeRes$RESPONSE0.contentslist : null;
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

