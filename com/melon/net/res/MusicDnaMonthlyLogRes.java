package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MusicDnaMonthlyLogRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ArtistTopInfo implements Serializable {
            public static class ArtistMvInfo implements Serializable {
                @b("DETAILIMG")
                public String detailImg;
                @b("CONTENTS")
                public ArrayList mvList;
                @b("SUBTITLE1")
                public String subTitle1;
                @b("TITLE")
                public String title;

                public ArtistMvInfo() {
                    this.title = "";
                    this.subTitle1 = "";
                    this.detailImg = "";
                    this.mvList = null;
                }
            }

            public static class ArtistRcmTrackInfo implements Serializable {
                public static class ArtistRecmInfo implements Serializable {
                    public static class MusicDnaSongInfo extends SongInfoBase {
                        @b("COVERIMGPATH")
                        public String coverImgPath;
                        @b("MAINARTISTIMG")
                        public String mainArtistImg;
                        @b("MAINARTISTNAME")
                        public String mainArtistName;

                        public MusicDnaSongInfo() {
                            this.coverImgPath = "";
                            this.mainArtistImg = "";
                            this.mainArtistName = "";
                        }
                    }

                    @b("CATEGORYCODE")
                    public String categoryCode;
                    @b("CATEGORYNAME")
                    public String categoryName;
                    @b("SONGINFO")
                    public MusicDnaSongInfo songInfo;

                    public ArtistRecmInfo() {
                        this.categoryCode = "";
                        this.categoryName = "";
                        this.songInfo = null;
                    }
                }

                @b("ARTISTRECMINFO")
                public ArrayList artistRecmInfoList;
                @b("DETAILIMG")
                public String detailImg;
                @b("SUBTITLE1")
                public String subTitle1;
                @b("TITLE")
                public String title;

                public ArtistRcmTrackInfo() {
                    this.title = "";
                    this.subTitle1 = "";
                    this.detailImg = "";
                    this.artistRecmInfoList = null;
                }
            }

            public static class ArtistRecentAlbumInfo implements Serializable {
                @b("CONTENTS")
                public ArrayList albumList;
                @b("DETAILIMG")
                public String detailImg;
                @b("SUBTITLE1")
                public String subTitle1;
                @b("TITLE")
                public String title;

                public ArtistRecentAlbumInfo() {
                    this.title = "";
                    this.subTitle1 = "";
                    this.detailImg = "";
                    this.albumList = null;
                }
            }

            public static class ArtistTopDetail implements Serializable {
                @b("ARTISTID")
                public String artistId;
                @b("ARTISTIMG")
                public String artistImg;
                @b("ARTISTNAME")
                public String artistName;
                @b("BGCOLOR")
                public String bgColor;
                @b("BGIMG")
                public String bgImg;
                @b("LISTENCNT")
                public String listenCnt;
                @b("TITLE")
                public String title;

                public ArtistTopDetail() {
                    this.title = "";
                    this.artistId = "";
                    this.artistName = "";
                    this.bgImg = "";
                    this.bgColor = "";
                    this.artistImg = "";
                    this.listenCnt = "";
                }
            }

            public static class ArtistTopSong3Info implements Serializable {
                @b("DETAILIMG")
                public String detailImg;
                @b("CONTENTS")
                public ArrayList songList;
                @b("SUBTITLE1")
                public String subTitle1;
                @b("TITLE")
                public String title;

                public ArtistTopSong3Info() {
                    this.title = "";
                    this.subTitle1 = "";
                    this.detailImg = "";
                    this.songList = null;
                }
            }

            @b("ARTISTID")
            public String artistId;
            @b("ARTISTMVINFO")
            public ArtistMvInfo artistMvInfo;
            @b("ARTISTNAME")
            public String artistName;
            @b("ARTISTRCMTRACKINFO")
            public ArtistRcmTrackInfo artistRcmTrackInfo;
            @b("ARTISTRECENTALBUMINFO")
            public ArtistRecentAlbumInfo artistRecentAlbumInfo;
            @b("ARTISTTOPDETAIL")
            public ArtistTopDetail artistTopDetail;
            @b("ARTISTTOPSONG3INFO")
            public ArtistTopSong3Info artistTopSong3Info;
            @b("SUBTITLE1")
            public String subTitle1;
            @b("TITLE")
            public String title;

            public ArtistTopInfo() {
                this.title = "";
                this.subTitle1 = "";
                this.artistId = "";
                this.artistName = "";
                this.artistTopDetail = null;
                this.artistTopSong3Info = null;
                this.artistRecentAlbumInfo = null;
                this.artistRcmTrackInfo = null;
                this.artistMvInfo = null;
            }
        }

        public static class GnrTopInfo implements Serializable {
            public static class Contents implements Serializable {
                @b("BGCOLOR")
                public String bgColor;
                @b("BGIMG")
                public String bgImg;
                @b("GNRSONGTOPINFO")
                public ArrayList songList;
                @b("SUBTITLE1")
                public String subTitle1;
                @b("SUBTITLE2")
                public String subTitle2;
                @b("SUBTITLE3")
                public String subTitle3;
                @b("TITLE")
                public String title;

                public Contents() {
                    this.title = "";
                    this.subTitle1 = "";
                    this.subTitle2 = "";
                    this.subTitle3 = "";
                    this.bgImg = "";
                    this.bgColor = "";
                    this.songList = null;
                }
            }

            @b("CONTENTS")
            public Contents contents;
            @b("SUBTITLE1")
            public String subTitle1;
            @b("TITLE")
            public String title;

            public GnrTopInfo() {
                this.title = "";
                this.subTitle1 = "";
                this.contents = null;
            }
        }

        public static class KeywordInfo implements Serializable {
            public static class com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.KeywordInfo.Contents implements Serializable {
                public static class Keyword implements Serializable {
                    @b("KEYWORD")
                    public String keyword;

                    public Keyword() {
                        this.keyword = "";
                    }
                }

                @b("BGCOLOR")
                public String bgColor;
                @b("BGIMG")
                public String bgImg;
                @b("KEYWORDLIST")
                public ArrayList keywordList;
                @b("TITLE")
                public String title;

                public com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.KeywordInfo.Contents() {
                    this.title = "";
                    this.bgImg = "";
                    this.bgColor = "";
                    this.keywordList = null;
                }
            }

            @b("ADDTITLE")
            public String addTitle;
            @b("CONTENTS")
            public com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.KeywordInfo.Contents contents;
            @b("SUBTITLE1")
            public String subTitle1;
            @b("TITLE")
            public String title;

            public KeywordInfo() {
                this.title = "";
                this.addTitle = "";
                this.subTitle1 = "";
                this.contents = null;
            }
        }

        public static class LikeTopInfo implements Serializable {
            public static class LikeAlbumInfo implements Serializable {
                @b("LIKEALBUMLIST")
                public ArrayList albumList;
                @b("TITLE")
                public String title;

                public LikeAlbumInfo() {
                    this.title = "";
                    this.albumList = null;
                }
            }

            public static class LikePlaylistInfo implements Serializable {
                @b("LIKEPLYLSTLIST")
                public ArrayList playlistList;
                @b("TITLE")
                public String title;

                public LikePlaylistInfo() {
                    this.title = "";
                    this.playlistList = null;
                }
            }

            public static class LikeSongInfo implements Serializable {
                @b("LIKESONGLIST")
                public ArrayList songList;
                @b("TITLE")
                public String title;

                public LikeSongInfo() {
                    this.title = "";
                    this.songList = null;
                }
            }

            @b("LIKEALBUMINFO")
            public LikeAlbumInfo likeAlbumInfo;
            @b("LIKEPLYLSTINFO")
            public LikePlaylistInfo likePlaylistInfo;
            @b("LIKESONGINFO")
            public LikeSongInfo likeSongInfo;
            @b("SUBTITLE1")
            public String subTitle1;
            @b("SUBTITLE2")
            public String subTitle2;
            @b("TITLE")
            public String title;

            public LikeTopInfo() {
                this.title = "";
                this.subTitle1 = "";
                this.subTitle2 = "";
                this.likeSongInfo = null;
                this.likeAlbumInfo = null;
                this.likePlaylistInfo = null;
            }
        }

        public static class MonthlyInfo implements Serializable {
            public static class GraphInfo implements Serializable {
                public static class GraphDetailInfo implements Serializable {
                    @b("CNT")
                    public String cnt;
                    @b("GRAPH")
                    public String graph;
                    @b("GRAPHDPCNT")
                    public String graphDpCnt;

                    public GraphDetailInfo() {
                        this.graph = "";
                        this.graphDpCnt = "";
                        this.cnt = "";
                    }
                }

                @b("BGCOLOR")
                public String bgColor;
                @b("CURMONTH")
                public String curMonth;
                @b("GRAPHCOLOR1")
                public String graphColor1;
                @b("GRAPHCOLOR2")
                public String graphColor2;
                @b("GRAPHDETAILINFO")
                public ArrayList graphDetailInfoList;
                @b("SUBTITLE1")
                public String subTitle1;
                @b("SUBTITLE2")
                public String subTitle2;
                @b("TITLE")
                public String title;

                public GraphInfo() {
                    this.title = "";
                    this.subTitle1 = "";
                    this.subTitle2 = "";
                    this.bgColor = "";
                    this.graphColor1 = "";
                    this.graphColor2 = "";
                    this.curMonth = "";
                    this.graphDetailInfoList = null;
                }
            }

            @b("GRAPHINFO")
            public GraphInfo graphInfo;
            @b("SUBTITLE1")
            public String subTitle1;
            @b("SUBTITLE2")
            public String subTitle2;
            @b("TITLE")
            public String title;

            public MonthlyInfo() {
                this.title = "";
                this.subTitle1 = "";
                this.subTitle2 = "";
                this.graphInfo = null;
            }
        }

        public static class SongTop3Info implements Serializable {
            @b("CONTENTS")
            public ArrayList songList;
            @b("TITLE")
            public String title;

            public SongTop3Info() {
                this.title = "";
                this.songList = null;
            }
        }

        @b("ARTISTTOPINFO")
        public ArtistTopInfo artistTopInfo;
        @b("GNRTOPINFO")
        public GnrTopInfo gnrTopInfo;
        @b("ISEVEN")
        public boolean isEven;
        @b("KEYWORDINFO")
        public KeywordInfo keywordInfo;
        @b("LIKETOPINFO")
        public LikeTopInfo likeTopInfo;
        @b("MONTHLYINFO")
        public MonthlyInfo monthlyInfo;
        @b("SONGTOP3INFO")
        public SongTop3Info songTop3Info;

        public RESPONSE() {
            this.isEven = false;
            this.monthlyInfo = null;
            this.songTop3Info = null;
            this.artistTopInfo = null;
            this.gnrTopInfo = null;
            this.keywordInfo = null;
            this.likeTopInfo = null;
        }
    }

    @b("response")
    public RESPONSE response;

}

