package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v6x.common.MemorialCardInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class ArtistTemperatureDetailRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class GUIDE implements Serializable {
            @b("LINKTYPE")
            public String linkType;
            @b("LINKURL")
            public String linkUrl;
            private static final long serialVersionUID = 0x4E724DD1EF1AE2E7L;

            public GUIDE() {
                this.linkUrl = "";
                this.linkType = "";
            }
        }

        public static class INFO extends MemorialCardInfoBase {
            private static final long serialVersionUID = 0xE7071AD1734A53BBL;

        }

        public static class MEMORIALLIST implements Serializable {
            @b("ACTIVE")
            public String active;
            @b("DEFAULTMSG")
            public String defaultMsg;
            @b("INFO")
            public INFO info;
            private static final long serialVersionUID = -340032621804010703L;
            @b("TYPE")
            public String type;

            public MEMORIALLIST() {
                this.type = "";
                this.defaultMsg = "";
                this.active = "N";
            }
        }

        public static class TOPSTREAMINGSONG implements Serializable {
            @b("ALBUMIMG")
            public String albumImg;
            @b("ARTISTNAME")
            public String artistName;
            private static final long serialVersionUID = 0xCB644EA50E165ABAL;
            @b("SONGID")
            public String songId;
            @b("SONGNAME")
            public String songName;
            @b("STREAMINGCNT")
            public int streamingCnt;

            public TOPSTREAMINGSONG() {
                this.artistName = "";
                this.songId = "";
                this.songName = "";
                this.albumImg = "";
            }
        }

        public static class USERTEMPERCARD implements Serializable {
            public static class USERRANKINFO implements Serializable {
                private static final long serialVersionUID = 0x5D325A0BE4A31BACL;
                @b("TOTALUSERRANK")
                public String totalUserRank;
                @b("USERRANK")
                public String userRank;
                @b("USERRANKCMPPRVDAY")
                public String userRankCmpPrvDay;

                public USERRANKINFO() {
                    this.userRank = "";
                    this.totalUserRank = "";
                    this.userRankCmpPrvDay = "";
                }
            }

            @b("ARTISTIMG")
            public String artistImg;
            @b("ARTISTNAME")
            public String artistName;
            @b("LIKECNT")
            public String likeCnt;
            @b("SEARCHCNT")
            @Deprecated
            public String searchCnt;
            private static final long serialVersionUID = 0x8E9FB0F5769B9114L;
            @b("SHARECNT")
            public String shareCnt;
            @b("STREAMINGCNT")
            public String streamingCnt;
            @b("USERRANKINFO")
            public USERRANKINFO userRankInfo;
            @b("USERTEMPER")
            public String userTemper;

            public USERTEMPERCARD() {
                this.artistName = "";
                this.artistImg = "";
                this.userTemper = "";
                this.streamingCnt = "";
                this.likeCnt = "";
                this.searchCnt = "";
                this.shareCnt = "";
            }
        }

        @b("GUIDE")
        public GUIDE guide;
        @b("MEMORIALLIST")
        public ArrayList memorialList;
        private static final long serialVersionUID = 0xF35FF623D6A970FDL;
        @b("TOPSTREAMINGSONG")
        public ArrayList topStreamingSong;
        @b("USERTEMPERCARD")
        public USERTEMPERCARD userTemperCard;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x203BF1466317F93EL;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

