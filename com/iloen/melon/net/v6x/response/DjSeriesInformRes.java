package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class DjSeriesInformRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class SERIESPLAYLIST implements Serializable {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("DJPLAYLISTLIST")
            public ArrayList djPlaylistList;
            @b("ISDELPOSBL")
            public String isDelposbl;
            @b("OWNERMEMBERKEY")
            public String ownerMemberKey;
            @b("OWNERNICKNAME")
            public String ownerNickName;
            @b("PLYLSTSEQ")
            public String plylstSeq;
            @b("PLYLSTTITLE")
            public String plylstTitle;
            @b("PLYLSTTYPECODE")
            public String plylstTypeCode;
            private static final long serialVersionUID = 0x2CD939B370424BF6L;
            @b("THUMBIMG")
            public String thumbImg;
            @b("THUMBIMGURL")
            public String thumbImgUrl;
            @b("UPDTDATE")
            public String updtDate;

            public SERIESPLAYLIST() {
                this.plylstSeq = "";
                this.contsTypeCode = "";
                this.plylstTypeCode = "";
                this.plylstTitle = "";
                this.thumbImgUrl = "";
                this.thumbImg = "";
                this.isDelposbl = "";
                this.ownerMemberKey = "";
                this.ownerNickName = "";
                this.updtDate = "";
                this.djPlaylistList = null;
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x10CFAAD3929A5BF6L;
        @b("SERIESPLAYLIST")
        public SERIESPLAYLIST seriesPlaylist;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x317A421A12119303L;

    public DjSeriesInformRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djSeriesInformRes$RESPONSE0 = this.response;
        if(djSeriesInformRes$RESPONSE0 != null) {
            SERIESPLAYLIST djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 = djSeriesInformRes$RESPONSE0.seriesPlaylist;
            if(djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 != null) {
                return djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.djPlaylistList;
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response != null && this.response.hasMore;
    }
}

