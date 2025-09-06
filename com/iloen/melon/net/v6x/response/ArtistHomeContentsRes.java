package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ALBUM;
import com.iloen.melon.net.v5x.response.DetailBaseRes.DetailResponseBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes;
import com.iloen.melon.net.v6x.common.TopicInfoBase;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ArtistHomeContentsRes extends DetailBaseRes {
    public static class RESPONSE extends DetailResponseBase {
        public static class ALBUMLIST extends ALBUM {
            @b("ISMASTERPIECE")
            public Boolean isMasterPiece;
            private static final long serialVersionUID = 0xF806203CD3B0542CL;

        }

        public static class ARTISTPICK implements Serializable {
            @b("ALBUMID")
            public String albumId;
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTNAME")
            public String artistName;
            @b("ARTISTPICKSEQ")
            public String artistPickSeq;
            @b("ARTISTPICKTHUMBURL")
            public String artistPickThumbUrl;
            @b("ARTISTPICKTITLE")
            public String artistPickTitle;
            @b("ARTISTPICKVIDEOURL")
            public String artistPickVideoUrl;
            private static final long serialVersionUID = 0xD16DD4FA18D87A81L;

        }

        public static class CREDITINFO implements Serializable {
            @b("FEATSONGCOUNT")
            public int featSongCount;
            @b("LYRICCOMPOSONGCOUNT")
            public int lyricCompoSongCount;
            @b("RELEASESONGCOUNT")
            public int releaseSongCount;
            private static final long serialVersionUID = 0x247314FA36CEFCCFL;

        }

        public static class DETAILINFO implements Serializable {
            public static class AWARDLIST implements Serializable {
                @b("DATE")
                public String date;
                @b("NAME")
                public String name;
                @b("PRIOT")
                public String priot;
                private static final long serialVersionUID = 0xAC896F39B6D3608EL;

            }

            public static class DEBUTSONG extends SongInfoBase {
                private static final long serialVersionUID = 0xED6103F08D9004A7L;

            }

            public static class GROUPLIST extends RelatedArtistsInfoBase {
                private static final long serialVersionUID = 0xA68E17505FEC6F37L;

            }

            public static class MEMBERLIST extends RelatedArtistsInfoBase {
                private static final long serialVersionUID = 8324469443985709070L;

            }

            @b("ACTTYPE")
            public String actType;
            @b("ARTISTNAME")
            public String artistName;
            @b("ARTISTID")
            public String artistid;
            @b("AWARDLIST")
            public List awardList;
            @b("COMPNAME")
            public String compName;
            @b("DEBUTDATE")
            public String debutDate;
            @b("DEBUTSONG")
            public DEBUTSONG debutSong;
            @b("DEBUTSONGNAME")
            public String debutSongName;
            @b("GENDER")
            public String gender;
            @b("GROUPLIST")
            public List groupList;
            @b("INTRO")
            public String intro;
            @b("MEMBERLIST")
            public List memberList;
            @b("NATIONALITY")
            public String nationality;
            private static final long serialVersionUID = 0x6856FF1347390D5DL;

            public DETAILINFO() {
                this.debutSongName = "";
                this.awardList = null;
                this.intro = "";
            }
        }

        public static class HIGHLIGHTLIST implements Serializable {
            public static class LINK extends LinkInfoBase {
                private static final long serialVersionUID = 0x9A7B7CBCCB1D9981L;

            }

            @b("ALBUMIMG")
            public String albumImg;
            @b("ALBUMTYPE")
            public String albumType;
            @b("ARTISTNAME")
            public String artistName;
            @b("AWARDMONTH")
            public String awardMonth;
            @b("AWARDRANK")
            public String awardRank;
            @b("AWARDWEEK")
            public String awardWeek;
            @b("CONTSID")
            public String contsId;
            @b("CONTSNAME")
            public String contsName;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("HIGHLIGHTTITLE")
            public String highlightTitle;
            @b("HIGHLIGHTTYPE")
            public String highlightType;
            @b("IMAGEBGCOLOR")
            public String imageBgColor;
            @b("IMAGEURL")
            public String imageUrl;
            @b("ISSUEDATE")
            public String issueDate;
            @b("LINK")
            public LINK link;
            @b("LOGOIMAGEURL")
            public String logoImageUrl;
            private static final long serialVersionUID = 0xA97A7A8132D997DAL;

        }

        public static class HIRISINGLIST implements Serializable {
            public static class com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.HIRISINGLIST.LINK extends LinkInfoBase {
                private static final long serialVersionUID = 0x3AFCC466A4723F79L;

            }

            @b("HIRISINGSEQ")
            public String hiRisingSeq;
            @b("IMAGEBGCOLOR")
            public String imageBgColor;
            @b("IMAGEURL")
            public String imageUrl;
            @b("LINK")
            public com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.HIRISINGLIST.LINK link;
            @b("LOGOIMAGEURL")
            public String logoImageUrl;
            @b("REGDATE")
            public String regDate;
            private static final long serialVersionUID = 9100852046361175715L;
            @b("TITLE")
            public String title;

            public HIRISINGLIST() {
                this.hiRisingSeq = "";
                this.title = "";
                this.regDate = "";
                this.imageUrl = "";
                this.logoImageUrl = "";
                this.imageBgColor = "";
            }
        }

        public static class RECMTRACKLIST implements Serializable {
            public static class SONGINFO extends SongInfoBase {
                @b("ALBUMIMGPATH")
                public String albumImgPath;
                @b("COVERIMGPATH")
                public String coverImgPath;
                @b("MAINARTISTIMG")
                public String mainArtistImg;
                @b("MAINARTISTNAME")
                public String mainArtistName;
                private static final long serialVersionUID = 0xBE088E110F6FC847L;

            }

            @b("CATEGORYCODE")
            public String categoryCode;
            @b("CATEGORYNAME")
            public String categoryName;
            private static final long serialVersionUID = 0x1534150DCBB9C7C6L;
            @b("SONGINFO")
            public SONGINFO songInfo;

        }

        public static class SPOTLIGHTLIST implements Serializable {
            public static class com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.SPOTLIGHTLIST.LINK extends LinkInfoBase {
                private static final long serialVersionUID = 0xDAD40BB847F3ECF3L;

            }

            @b("IMAGEBGCOLOR")
            public String imageBgColor;
            @b("IMAGEURL")
            public String imageUrl;
            @b("LINK")
            public com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.SPOTLIGHTLIST.LINK link;
            @b("LOGOIMAGEURL")
            public String logoImageUrl;
            @b("REGDATE")
            public String regDate;
            private static final long serialVersionUID = 2440061045452327691L;
            @b("SPOTLIGHTSEQ")
            public String spotlightSeq;
            @b("TITLE")
            public String title;

            public SPOTLIGHTLIST() {
                this.regDate = "";
            }
        }

        public static class TOPICLIST extends TopicInfoBase {
            private static final long serialVersionUID = 0x3900A10BD8C4DDC3L;

        }

        @b("ALBUMLIST")
        public List albumList;
        @b("ARTISTID")
        public String artistId;
        @b("ARTISTNOTELIST")
        public List artistNoteList;
        @b("ARTISTPICK")
        public ARTISTPICK artistPick;
        @b("CREDITINFO")
        public CREDITINFO creditInfo;
        @b("DETAILINFO")
        public DETAILINFO detailinfo;
        @b("FANTALKCHNLSEQ")
        public String fanTalkChnlSeq;
        @b("HIRISINGLIST")
        public List hiRisingList;
        @b("HIGHLIGHTLIST")
        public List highlightList;
        @b("MAGAZINELIST")
        public List magazineList;
        @b("PHOTOLIST")
        public List photoList;
        @b("RECMTRACKLIST")
        public List recmTrackList;
        private static final long serialVersionUID = 0xA9A7A3B2E09FF2E7L;
        @b("SONGLIST")
        public List songList;
        @b("SPOTLIGHTLIST")
        public List spotlightList;
        @b("STATIONLIST")
        public List stationList;
        @b("TOPICCNT")
        public String topicCnt;
        @b("TOPICLIST")
        public List topicList;
        @b("VIDEOLIST")
        public List videoList;

        public RESPONSE() {
            this.topicCnt = "";
        }
    }

    public static class RelatedArtistsInfoBase extends ArtistsInfoBase {
        @b("ACTGENRE")
        public String actGenre;
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        @b("IMAGETYPE")
        public String imageType;
        private static final long serialVersionUID = 0x3323879E0AAD2FF6L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3B6FF4F8939FECF1L;

    public ArtistHomeContentsRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.v5x.response.DetailBaseRes
    public DetailResponseBase getResponseBase() {
        return this.response;
    }

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

