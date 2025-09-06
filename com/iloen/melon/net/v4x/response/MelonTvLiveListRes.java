package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvLiveListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class LIVELIST extends PASTLIVELIST {
            @b("COMMENTCNT")
            public String commentCnt;
            @b("LIVEDESC")
            public String liveDesc;
            @b("LIVESTATUS")
            public String liveStatus;
            private static final long serialVersionUID = 0x7B3DFEAA3D873924L;

            public LIVELIST() {
                this.liveStatus = "";
                this.liveDesc = "";
                this.commentCnt = "";
            }
        }

        public static class PASTLIVELIST implements Serializable {
            public static class LINK extends BannerBase {
                private static final long serialVersionUID = 0xAC821FA1D2EB59B9L;

            }

            @b("LINK")
            public LINK link;
            @b("LIVEDATE")
            public String liveDate;
            @b("LIVEIMG")
            public String liveImg;
            @b("LIVESEQ")
            public String liveSeq;
            @b("LIVETITLE")
            public String liveTitle;
            private static final long serialVersionUID = -1621141420480089323L;
            @b("VIEWCNT")
            public String viewCnt;

            public PASTLIVELIST() {
                this.liveSeq = "";
                this.liveImg = "";
                this.liveTitle = "";
                this.liveDate = "";
                this.viewCnt = "";
                this.link = null;
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        @b("LIVELIST")
        public ArrayList liveList;
        @b("PASTLIVELIST")
        public ArrayList pastLiveList;
        private static final long serialVersionUID = 0x5887A1C5739D3B28L;

        public RESPONSE() {
            this.liveList = null;
            this.pastLiveList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -7041033305753028578L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE melonTvLiveListRes$RESPONSE0 = this.response;
        return melonTvLiveListRes$RESPONSE0 == null ? null : melonTvLiveListRes$RESPONSE0.pastLiveList;
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

