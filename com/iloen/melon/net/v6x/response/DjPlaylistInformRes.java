package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.AppBanerListRes;
import com.iloen.melon.net.v5x.response.DetailBaseRes.DetailResponseBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;
import com.iloen.melon.net.v5x.response.DetailBaseRes;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class DjPlaylistInformRes extends DetailBaseRes {
    public static class RESPONSE extends DetailResponseBase {
        public static class BANNER extends BannerBase {
            private static final long serialVersionUID = 0x8D000878078C352EL;

        }

        public static class EVENT implements Serializable {
            @b("BTNCOLORDARK")
            public String btnColorDark;
            @b("BTNCOLORLIGHT")
            public String btnColorLight;
            @b("EVENTCAUTION")
            public List eventCaution;
            @b("EVENTDATE")
            public String eventDate;
            @b("EVENTDESC")
            public String eventDesc;
            @b("EVENTSEQ")
            public String eventSeq;
            @b("EVENTTARGET")
            public String eventTarget;
            @b("EVENTTITLE")
            public String eventTitle;
            @b("GIFTNAME")
            public String giftName;
            @b("LANDINGCMT")
            public String landingCmt;
            @b("REFEVENTID")
            public String refeventId;
            private static final long serialVersionUID = 0xD8ED2E90903D79A3L;
            @b("WINNERDATE")
            public String winnerDate;

            public EVENT() {
                this.eventSeq = "";
                this.eventTitle = "";
                this.eventDesc = "";
                this.eventDate = "";
                this.winnerDate = "";
                this.eventTarget = "";
                this.giftName = "";
                this.eventCaution = null;
                this.btnColorLight = "";
                this.btnColorDark = "";
                this.landingCmt = "";
                this.refeventId = "";
            }
        }

        public static class OPTION implements Serializable {
            @b("ACTION")
            public String action;
            @b("LINKTYPE")
            public String linkType;
            @b("LINKURL")
            public String linkUrl;
            private static final long serialVersionUID = 0x1859C58B407DF9A6L;

            public OPTION() {
                this.action = "";
                this.linkType = "";
                this.linkUrl = "";
            }
        }

        public AppBanerListRes appBanerListRes;
        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("BRANDPLAYLISTS")
        public List brandPlaylists;
        @b("BRANDSTATIONS")
        public List brandStations;
        @b("DJPLAYLIST")
        public PLAYLIST djplaylist;
        @b("EVENT")
        @Nullable
        public EVENT event;
        @b("RELATIONCONTENTS")
        public List relationContentList;
        @b("RELATIONPLAYLISTS")
        public List relationPlaylists;
        private static final long serialVersionUID = 0x5946FFC98F038288L;
        @b("SERIESPLAYLISTS")
        public List seriesPlaylists;
        @b("TAGLIST")
        public List tagList;
        @b("TOPMEMBERNM")
        public String topMemberNm;

        public RESPONSE() {
            this.bbsChannelSeq = "";
            this.event = null;
            this.appBanerListRes = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 7451142295572300780L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override  // com.iloen.melon.net.v5x.response.DetailBaseRes
    public DetailResponseBase getResponseBase() {
        return this.response;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

