package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MyMusicMyMusicListMymusicListenHistoryRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class LIKESONGINFO implements Serializable {
            public static class RESULT extends MyMusicListenHistoryInfoBase {
                @b("LIKECOVERIMG")
                public String likeCoverImg;
                private static final long serialVersionUID = 0x5195013B53F33231L;

                public RESULT() {
                    this.likeCoverImg = "";
                }
            }

            @b("RESULT")
            public RESULT result;
            private static final long serialVersionUID = 3991445550427057062L;
            @b("TYPE")
            public String type;

            public LIKESONGINFO() {
                this.type = "";
            }
        }

        public static class MYARTISTINFO implements Serializable {
            public static class com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.MYARTISTINFO.RESULT extends ArtistInfoBase {
                @b("ACTTYPENAME")
                public String actTypeName;
                @b("BIRTHDAY")
                public String birthDay;
                @b("DEBUTDAY")
                public String debutDay;
                @b("IMAGETYPE")
                public String imageType;
                private static final long serialVersionUID = 0x95066DFC20471C2L;

                public com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.MYARTISTINFO.RESULT() {
                    this.actTypeName = "";
                    this.debutDay = "";
                    this.birthDay = "";
                    this.imageType = "";
                }
            }

            @b("RESULT")
            public com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.MYARTISTINFO.RESULT result;
            private static final long serialVersionUID = -715471628596905059L;
            @b("TYPE")
            public String type;

            public MYARTISTINFO() {
                this.type = "";
            }
        }

        public static class MyMusicListenHistoryInfoBase implements Serializable {
            @b("ARTISTNAME")
            public String artistName;
            @b("MAINTITLE")
            public String mainTitle;
            private static final long serialVersionUID = 0xDFB09AA0C3DE5653L;
            @b("SONGIDS")
            public String songIds;

            public MyMusicListenHistoryInfoBase() {
                this.songIds = "";
                this.mainTitle = "";
                this.artistName = "";
            }
        }

        public static class RECENTSONGINFO implements Serializable {
            public static class com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.RECENTSONGINFO.RESULT extends MyMusicListenHistoryInfoBase {
                public static class CONTENTS extends SongInfoBase {
                    private static final long serialVersionUID = 0x85BDAFF97B5AAA89L;

                }

                @b("CONTENTS")
                public ArrayList contents;
                private static final long serialVersionUID = 0xAD43DA52E469B661L;

            }

            @b("RESULT")
            public com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.RECENTSONGINFO.RESULT result;
            private static final long serialVersionUID = 0xE6AF15313DCA0962L;
            @b("TYPE")
            public String type;

            public RECENTSONGINFO() {
                this.type = "";
            }
        }

        public static class SONGMANYINFO implements Serializable {
            public static class com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.SONGMANYINFO.RESULT extends MyMusicListenHistoryInfoBase {
                @b("DATETYPE")
                public String dateType;
                private static final long serialVersionUID = 0xAA677AE4815D126L;
                @b("SONGMANYCOVERIMG")
                public String songManyCoverImg;

                public com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.SONGMANYINFO.RESULT() {
                    this.songManyCoverImg = "";
                    this.dateType = "";
                }
            }

            @b("RESULT")
            public com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes.RESPONSE.SONGMANYINFO.RESULT result;
            private static final long serialVersionUID = 0x745535BC007DEB8BL;
            @b("TYPE")
            public String type;

            public SONGMANYINFO() {
                this.type = "";
            }
        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0x1702127C304BC8B7L;

        }

        @b("LIKESONGINFO")
        public LIKESONGINFO likeSongInfo;
        @b("MYARTISTINFO")
        public MYARTISTINFO myArtistInfo;
        @b("RECENTSONGINFO")
        public RECENTSONGINFO recentSongInfo;
        private static final long serialVersionUID = 0xE005857208C99641L;
        @b("SONGMANYINFO")
        public SONGMANYINFO songManyInfo;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;
        @b("TITLE")
        public String title;

        public RESPONSE() {
            this.title = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD7F3028C90905D38L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }
}

