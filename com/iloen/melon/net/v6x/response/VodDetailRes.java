package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.sns.model.ShareLinkData;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class VodDetailRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class Artist implements Serializable {
            @b("ARTISTLIST")
            public ArrayList artistList;
            @b("TITLE")
            public String title;

            public Artist() {
                this.title = "";
                this.artistList = null;
            }
        }

        public static class Cmt implements Serializable {
            @b("BBSCHANNELSEQ")
            public String bbsChannelSeq;
            @b("CONTSID")
            public String contsId;
            @b("CONTSTYPECODE")
            public String contsTypeCode;

            public Cmt() {
                this.bbsChannelSeq = "-1";
                this.contsTypeCode = "";
                this.contsId = "";
            }
        }

        public static class Concert implements Serializable {
            public static class Ticket extends BannerBase {
                @b("APPSCHEMAURL")
                public String appSchemaUrl;
                @b("ARTISTLIST")
                public ArrayList artistList;
                @b("ENDDATE")
                public String endDt;
                @b("PLACENAME")
                public String placeName;
                @b("POSTERIMG")
                public String posterImg;
                @b("PRODID")
                public String prodId;
                @b("STARTDATE")
                public String startDt;

                public Ticket() {
                    this.prodId = "";
                    this.posterImg = "";
                    this.artistList = null;
                    this.startDt = "";
                    this.endDt = "";
                    this.placeName = "";
                    this.appSchemaUrl = "";
                }
            }

            @b("TICKET")
            public Ticket ticket;
            @b("TITLE")
            public String title;

            public Concert() {
                this.title = "";
                this.ticket = null;
            }
        }

        public static class Dj implements Serializable {
            @b("DJPLYLSTLIST")
            public ArrayList djPlaylistList;
            @b("TITLE")
            public String title;

            public Dj() {
                this.title = "";
                this.djPlaylistList = null;
            }
        }

        public static class Magazine implements Serializable {
            public static class MagazineList implements Serializable {
                @b("CATTENAME")
                public String catteName;
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("LIKECNT")
                public String likeCnt;
                @b("LINK")
                public LinkInfoBase link;
                @b("LISTIMG")
                public String listImg;
                @b("MSTORYSEQ")
                public String mStorySeq;
                @b("MSTORYTITLE")
                public String mStoryTitle;
                @b("READCNT")
                public String readCnt;
                @b("RSRVDATE")
                public String rsrvDate;
                private static final long serialVersionUID = 0x97AEFA183A1AA604L;

                public MagazineList() {
                    this.mStorySeq = "";
                    this.mStoryTitle = "";
                    this.catteName = "";
                    this.listImg = "";
                    this.rsrvDate = "";
                    this.link = null;
                    this.likeCnt = "";
                    this.readCnt = "";
                    this.contsTypeCode = "";
                }
            }

            @b("MAGAZINELIST")
            public ArrayList magazineList;
            @b("TITLE")
            public String title;

            public Magazine() {
                this.title = "";
                this.magazineList = null;
            }
        }

        public static class Mv extends MvInfoBase {
            public static class Program implements Serializable {
                @b("PROGNAME")
                public String progName;
                @b("PROGSEQ")
                public String progSeq;
                @b("PROGTHUMBIMAGEURL")
                public String progThumbImageUrl;

                public Program() {
                    this.progSeq = "";
                    this.progName = "";
                    this.progThumbImageUrl = "";
                }
            }

            @b("CHEERFULCNT")
            public String cheerfulCnt;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            public boolean isOpen;
            @b("PROG")
            public Program program;

            public Mv() {
                this.cheerfulCnt = "";
                this.contsTypeCode = "";
                this.program = null;
                this.isOpen = false;
            }
        }

        public static class RecmMv implements Serializable {
            public static class com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv extends MvInfoBase {
                public static class com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv.Program implements Serializable {
                    @b("PROGNAME")
                    public String progName;
                    @b("PROGSEQ")
                    public String progSeq;
                    @b("PROGTHUMBIMAGEURL")
                    public String progThumbImageUrl;

                    public com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv.Program() {
                        this.progSeq = "";
                        this.progName = "";
                        this.progThumbImageUrl = "";
                    }
                }

                public int index;
                @b("PROG")
                public com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv.Program program;

                public com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv() {
                    this.program = null;
                    this.index = 0;
                }
            }

            @b("LIST1")
            public ArrayList list1;
            @b("LIST2")
            public ArrayList list2;
            @b("LIST3")
            public ArrayList list3;
            @b("LIST4")
            public ArrayList list4;
            @b("LIST5")
            public ArrayList list5;

            public RecmMv() {
                this.list1 = null;
                this.list2 = null;
                this.list3 = null;
                this.list4 = null;
                this.list5 = null;
            }
        }

        public static class Song implements Serializable {
            @b("HASMORE")
            public boolean hasMore;
            @b("SONGLIST")
            public ArrayList songList;
            @b("TITLE")
            public String title;

            public Song() {
                this.title = "";
                this.songList = null;
                this.hasMore = false;
            }
        }

        @b("ARTIST")
        public Artist artist;
        @b("CMT")
        public Cmt cmt;
        @b("CONCERT")
        public Concert concert;
        @b("DJ")
        public Dj dj;
        @b("MAGAZINE")
        public Magazine magazine;
        @b("MV")
        public Mv mv;
        @b("RECMMV")
        public RecmMv recmMv;
        @b("SNSINFO")
        public ShareLinkData snsInfo;
        @b("SONG")
        public Song song;

        public Response() {
            this.mv = null;
            this.recmMv = null;
            this.song = null;
            this.dj = null;
            this.artist = null;
            this.magazine = null;
            this.concert = null;
            this.cmt = null;
            this.snsInfo = null;
        }
    }

    @b("response")
    public Response response;

    public VodDetailRes() {
        this.response = null;
    }
}

