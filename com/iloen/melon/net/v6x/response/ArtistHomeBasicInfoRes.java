package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArtistHomeBasicInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTDAILYREPORT implements Serializable {
            public static class TOPSONGLIST extends SongInfoBase {
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("LIKECNTGAP")
                public int likeCntGap;
                private static final long serialVersionUID = 0xB5A4F1968EEDEF45L;
                @b("STREAMUSERCNT")
                public int streamUserCnt;
                @b("STREAMUSERCNTGAP")
                public int streamUserCntGap;

                public TOPSONGLIST() {
                    this.contsTypeCode = "";
                }
            }

            private static final long serialVersionUID = 0xC2B3588E02A94ABAL;
            @b("TOPSONGLIST")
            public List topSongList;

        }

        public static class BILLIONSCLUBINFO implements Serializable {
            public static enum BillionsClubGrade {
                @b("D")
                D,
                @b("G")
                G,
                @b("S")
                S,
                @b("B")
                B;

                private static BillionsClubGrade[] $values() [...] // Inlined contents
            }

            @b("BILLIONSCLUBGRADE")
            @Nullable
            public BillionsClubGrade billionsClubGrade;
            @b("LINK")
            @Nullable
            public LinkInfoBase linkInfo;
            private static final long serialVersionUID = -717020580276600107L;

        }

        public static class FANANNIVERSARYINFO implements Serializable {
            @b("DAY")
            public String day;
            private static final long serialVersionUID = 0x4B4191A4A0FB51C0L;
            @b("TEXT")
            public String text;

        }

        public static class FANLOUNGELINKINFO extends LinkInfoBase {
            @b("BUTTONTEXT")
            @Nullable
            public String buttonText;
            private static final long serialVersionUID = 2678070050296436999L;

            public FANLOUNGELINKINFO() {
                this.buttonText = "";
            }
        }

        public static class FORESTARTISTINFO implements Serializable {
            public static class LINK extends LinkInfoBase {
                private static final long serialVersionUID = 6767551784532200050L;

            }

            @b("ACHIEVEMENTRATE")
            public String achievementRate;
            @b("ACHIEVEMENTSCOUNT")
            public String achievementsCount;
            @b("ARTISTID")
            public String artistId;
            @b("ENROLLCOUNT")
            public String enrollCount;
            @b("FORESTIMAGEPATH")
            public String forestImagePath;
            @b("ISENROLL")
            public boolean isEnroll;
            @b("LINK")
            public LINK link;
            @b("PARTICIPATIONAMOUNT")
            public String participationAmount;
            private static final long serialVersionUID = 0x459F815CE796FFD4L;

            public FORESTARTISTINFO() {
                this.artistId = "";
                this.achievementsCount = "";
                this.achievementRate = "";
                this.enrollCount = "";
                this.participationAmount = "";
                this.forestImagePath = "";
            }
        }

        public static class MELONHALLLIST implements Serializable {
            @b("ALBUMID")
            @Nullable
            public String albumId;
            @b("ALBUMIMG")
            @Nullable
            public String albumImg;
            @b("ALBUMNAME")
            @Nullable
            public String albumName;
            @b("ISSERVICE")
            public boolean isService;
            @b("LINK")
            @Nullable
            public LinkInfoBase linkInfo;
            @b("MILLIONSALBUMBADGE")
            @Nullable
            public String millionsAlbumBadge;
            private static final long serialVersionUID = 0xA31A14B8834C1ED1L;
            @b("STREAMCNT")
            @Nullable
            public String streamCnt;
            @b("STREAMRANK")
            @Nullable
            public String streamRank;
            @b("STREAMUSERCNT")
            @Nullable
            public String streamUserCnt;

        }

        public static class PROFILE implements Serializable {
            @b("DESC")
            public String desc;
            private static final long serialVersionUID = 1000737489100289749L;

            public PROFILE() {
                this.desc = "";
            }
        }

        public static class TITLESONG extends SongInfoBase {
            private static final long serialVersionUID = 0x9AFBD0FDB703BB87L;

        }

        @b("ARTISTDAILYREPORT")
        public ARTISTDAILYREPORT artistDailyReport;
        @b("ARTISTID")
        public String artistId;
        @b("ARTISTIMG")
        public String artistImg;
        @b("ARTISTIMGLARGE")
        public String artistImgLarge;
        @b("ARTISTNAME")
        public String artistName;
        @b("ARTISTYN")
        public String artistYN;
        @b("BILLIONSCLUBINFO")
        @Nullable
        public BILLIONSCLUBINFO billionsClubInfo;
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        @b("FANANNIVERSARYINFO")
        public FANANNIVERSARYINFO fanAnniversaryInfo;
        @b("FANCNT")
        public String fanCnt;
        @b("FANLOUNGELINKINFO")
        @Nullable
        public FANLOUNGELINKINFO fanLoungeLinkInfo;
        public String fanYN;
        @b("FANTALKCNT")
        public String fantalkCnt;
        @b("FORESTARTISTINFO")
        public FORESTARTISTINFO forestArtistInfo;
        @b("MELONHALLLINKINFO")
        @Nullable
        public LinkInfoBase melonHallLinkInfo;
        @b("MELONHALLLIST")
        @Nullable
        public List melonHallList;
        @b("MIXUPBUTTON")
        public String mixUpButton;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("PROFILE")
        public PROFILE profile;
        @b("REPSONGBUTTON")
        public String repSongButton;
        private static final long serialVersionUID = -464955440969410941L;
        @b("TITLESONG")
        public TITLESONG titleSong;

        public RESPONSE() {
            this.artistYN = "N";
            this.contsTypeCode = "";
            this.artistId = "";
            this.artistName = "";
            this.artistImg = "";
            this.artistImgLarge = "";
            this.postImg = "";
            this.postEditImg = "";
            this.fanCnt = "";
            this.fantalkCnt = "";
            this.repSongButton = "N";
            this.mixUpButton = "N";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xEA0402D0FC53E14EL;

    public ArtistHomeBasicInfoRes() {
        this.response = null;
    }

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

