package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class GenreDetailRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class GNRDETAILCONTENTS implements Serializable {
            public static class ARTISTTYPE implements Serializable {
                public static class ARTISTLIST extends ArtistInfoBase {
                    public static class ALBUM extends AlbumInfoBase {
                        private static final long serialVersionUID = 0xFBAEB5276558D2B6L;

                    }

                    @b("ALBUM")
                    public ALBUM album;
                    @b("ARTISTDESC")
                    public String artistDesc;
                    @b("GNRARTISTSEQ")
                    public String gnrArtistSeq;
                    private static final long serialVersionUID = 0x18ABFE7DF932D4AL;

                    public ARTISTLIST() {
                        this.gnrArtistSeq = "";
                        this.artistDesc = "";
                        this.album = null;
                    }
                }

                @b("ARTISTLIST")
                public ArrayList artistList;
                @b("DESC")
                public String desc;
                @b("GNRCONTSSEQ")
                public String gnrContsSeq;
                @b("GNRLIBSEQ")
                public String gnrLibSeq;
                private static final long serialVersionUID = 0xCA6C3DDDAB0C35FL;
                @b("TITLE")
                public String title;

                public ARTISTTYPE() {
                    this.title = "";
                    this.desc = "";
                    this.gnrLibSeq = "";
                    this.gnrContsSeq = "";
                    this.artistList = null;
                }
            }

            public static class GNRINFOTYPE implements Serializable {
                @b("DESC")
                public String desc;
                @b("GNRCODE")
                public String gnrCode;
                private static final long serialVersionUID = 0x4A43957F6D45E9FL;
                @b("TITLE")
                public String title;

                public GNRINFOTYPE() {
                    this.gnrCode = "";
                    this.title = "";
                    this.desc = "";
                }
            }

            public static class LABELTYPE implements Serializable {
                public static class LABELLIST implements Serializable {
                    @b("LABELIMG")
                    public String labelImg;
                    @b("LABELNAME")
                    public String labelName;
                    @b("LABELSEQ")
                    public String labelSeq;
                    private static final long serialVersionUID = 0xDC570550929954AL;

                    public LABELLIST() {
                        this.labelSeq = "";
                        this.labelName = "";
                        this.labelImg = "";
                    }
                }

                @b("LABELLIST")
                public ArrayList labelList;
                private static final long serialVersionUID = 0xCA6BAC321D83FA7L;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public LABELTYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.labelList = null;
                }
            }

            public static class LICENSE1TYPE implements Serializable {
                public static class com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.LICENSE1TYPE.ALBUM extends AlbumInfoBase {
                    private static final long serialVersionUID = 0x2A6F7A9EE88FD4AL;

                }

                @b("ALBUM")
                public com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.LICENSE1TYPE.ALBUM album;
                @b("BGCOLOR")
                public String bgColor;
                private static final long serialVersionUID = 0xCA6BC9545EB6E9FL;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public LICENSE1TYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.bgColor = "";
                    this.album = null;
                }
            }

            public static class LICENSE2TYPE implements Serializable {
                public static class ALBUMLIST extends AlbumInfoBase {
                    private static final long serialVersionUID = 0x2A6F7A9EE88FD4AL;

                }

                @b("ALBUMLIST")
                public ArrayList albumList;
                @b("DESC")
                public String desc;
                private static final long serialVersionUID = 0xCA6BAC33D433E9FL;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public LICENSE2TYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.desc = "";
                    this.albumList = null;
                }
            }

            public static class LICENSE3TYPE extends LinkInfoBase {
                @b("BADGE")
                public String badge;
                @b("CONTSIMGURL")
                public String contsImgUrl;
                @b("DESC")
                public String desc;
                private static final long serialVersionUID = 0x2EFD478AE7D3E9FL;
                @b("TITLE")
                public String title;

                public LICENSE3TYPE() {
                    this.title = "";
                    this.badge = "";
                    this.desc = "";
                    this.contsImgUrl = "";
                }
            }

            public static class MASTERPIECETYPE implements Serializable {
                public static class com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.MASTERPIECETYPE.ALBUMLIST extends AlbumInfoBase {
                    @b("CONTSTYPECODE")
                    public String contsTypeCode;
                    private static final long serialVersionUID = 0xDC4BA03CE121D4AL;

                    public com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.MASTERPIECETYPE.ALBUMLIST() {
                        this.contsTypeCode = "";
                    }
                }

                @b("ALBUMLIST")
                public ArrayList albumList;
                @b("DESC")
                public String desc;
                @b("GNRCONTSSEQ")
                public String gnrContsSeq;
                private static final long serialVersionUID = 0xCA6BAC3990DD3A7L;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public MASTERPIECETYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.desc = "";
                    this.gnrContsSeq = "";
                    this.albumList = null;
                }
            }

            public static class MEGAZINETYPE implements Serializable {
                public static class MEGAZINE extends LinkInfoBase {
                    @b("MEGAZINEIMG")
                    public String megazineImg;
                    @b("MEGAZINENAME")
                    public String megazineName;
                    @b("MEGAZINESEQ")
                    public String megazineSeq;
                    private static final long serialVersionUID = 7923288034203311210L;

                    public MEGAZINE() {
                        this.megazineSeq = "";
                        this.megazineName = "";
                        this.megazineImg = "";
                    }
                }

                public static class MEGAZINELIST extends LinkInfoBase {
                    @b("MEGAZINEIMG")
                    public String megazineImg;
                    @b("MEGAZINENAME")
                    public String megazineName;
                    @b("MEGAZINESEQ")
                    public String megazineSeq;
                    private static final long serialVersionUID = 7963383034303311210L;

                    public MEGAZINELIST() {
                        this.megazineSeq = "";
                        this.megazineName = "";
                        this.megazineImg = "";
                    }
                }

                @b("MEGAZINE")
                public MEGAZINE megazine;
                @b("MEGAZINELIST")
                public ArrayList megazineList;
                private static final long serialVersionUID = 0xCA6BB378C2B15C7L;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public MEGAZINETYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.megazine = null;
                    this.megazineList = null;
                }
            }

            public static class MVTYPE implements Serializable {
                public static class MV extends MvInfoBase {
                    @b("CONTSTYPECODE")
                    public String contsTypeCode;
                    private static final long serialVersionUID = 0x1AB0E4BB5B8EE7EDL;

                    public MV() {
                        this.contsTypeCode = "";
                    }
                }

                @b("MV")
                public MV mv;
                private static final long serialVersionUID = 0xC83352E2CB93207L;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public MVTYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.mv = null;
                }
            }

            public static class NEWMUSICTYPE implements Serializable {
                public static class com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.NEWMUSICTYPE.ALBUMLIST extends AlbumInfoBase {
                    @b("CONTSTYPECODE")
                    public String contsTypeCode;
                    private static final long serialVersionUID = 0x1AB0E4C003A6AC05L;

                    public com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.NEWMUSICTYPE.ALBUMLIST() {
                        this.contsTypeCode = "";
                    }
                }

                @b("ALBUMLIST")
                public ArrayList albumList;
                private static final long serialVersionUID = 0xDC2F3286A1B1C07L;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public NEWMUSICTYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.albumList = null;
                }
            }

            public static class PLYLSTTYPE implements Serializable {
                public static class PLYLSTLIST extends GenrePlayListInfoBase {
                    @b("PREFERGNRCODE")
                    public String preferGnrCode;
                    @b("PREFERGNRCODEINDEX")
                    public String preferGnrCodeIndex;
                    private static final long serialVersionUID = 0x1AB0B28BE705B205L;

                }

                @b("PLYLSTLIST")
                public ArrayList plyLstList;
                private static final long serialVersionUID = 0xF90CD7816E81C07L;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public PLYLSTTYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.plyLstList = null;
                }
            }

            public static class SONGCHARTTYPE implements Serializable {
                public static class SONGLIST extends SongInfoBase {
                    @b("CONTSTYPECODE")
                    public String contsTypeCode;
                    @b("CURRANK")
                    public String curRank;
                    @b("PASTRANK")
                    public String pastRank;
                    @b("RANKGAP")
                    public String rankGap;
                    @b("RANKTYPE")
                    public String rankType;
                    private static final long serialVersionUID = 0xDC575CA046F5D3AL;

                    public SONGLIST() {
                        this.contsTypeCode = "";
                    }
                }

                private static final long serialVersionUID = 0xCA6BAC321D83FA7L;
                @b("SONGLIST")
                public ArrayList songList;
                @b("STATSELEMENTS")
                public STATSELEMENTS statsElements;
                @b("TITLE")
                public String title;

                public SONGCHARTTYPE() {
                    this.statsElements = null;
                    this.title = "";
                    this.songList = null;
                }
            }

            public static class STATSELEMENTS extends StatsElementsBase {
                private static final long serialVersionUID = 0x115621F21FF4EC0FL;

            }

            @b("ARTISTTYPE")
            public ARTISTTYPE artistType;
            @b("GNRINFOTYPE")
            public GNRINFOTYPE gnrInfoType;
            @b("LABELTYPE")
            public LABELTYPE labelType;
            @b("LICENSE1TYPE")
            public LICENSE1TYPE license1Type;
            @b("LICENSE2TYPE")
            public LICENSE2TYPE license2Type;
            @b("LICENSE3TYPE")
            public LICENSE3TYPE license3Type;
            @b("MASTERPIECETYPE")
            public MASTERPIECETYPE masterPieceType;
            @b("MEGAZINETYPE")
            public MEGAZINETYPE megazineType;
            @b("MVTYPE")
            public MVTYPE mvType;
            @b("NEWMUSICTYPE")
            public NEWMUSICTYPE newMusicType;
            @b("PLYLSTTYPE")
            public PLYLSTTYPE plyLstType;
            private static final long serialVersionUID = 0xF90CD7816E7C1CBL;
            @b("SONGCHARTTYPE")
            public SONGCHARTTYPE songChartType;

            public GNRDETAILCONTENTS() {
                this.plyLstType = null;
                this.newMusicType = null;
                this.mvType = null;
                this.megazineType = null;
                this.songChartType = null;
                this.labelType = null;
                this.masterPieceType = null;
                this.license1Type = null;
                this.license2Type = null;
                this.license3Type = null;
                this.artistType = null;
                this.gnrInfoType = null;
            }
        }

        @b("GNRDETAILCONTENTS")
        public ArrayList gnrDetailContents;
        @b("ISPLYLSTONLY")
        public boolean isPlylstOnly;
        private static final long serialVersionUID = 0x101EE4107A75B34BL;

        public RESPONSE() {
            this.gnrDetailContents = null;
            this.isPlylstOnly = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x784BEDAA9CAABE4BL;

    public GenreDetailRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

