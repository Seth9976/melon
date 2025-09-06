package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.common.UserInfoBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class InformMyProfileMainRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class DJPLAYLIST implements Serializable {
            public static class PLAYLISTLIST extends DjPlayListInfoBase {
                @b("DSPLYORDER")
                public String dsplyOrder;
                private static final long serialVersionUID = 5051015180776796841L;

            }

            public boolean isBottom;
            public boolean isTop;
            @b("PLAYLISTLIST")
            public ArrayList playlistList;
            @b("SCHEMEURL")
            public String schemeUrl;
            private static final long serialVersionUID = 0xE75A424EB460A5FFL;

            public DJPLAYLIST() {
                this.isTop = false;
                this.isBottom = false;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class FANLIST implements Serializable {
            public static class ARTISTLIST extends ArtistsInfoBase {
                public static class TFType {
                    public static final String F = "F";
                    public static final String T = "T";

                }

                @b("ARTISTNEWS")
                public String artistNews;
                @b("DATE")
                public String date;
                @b("MESSAGE")
                public String message;
                @b("NEWICONYN")
                public String newIconYn;
                private static final long serialVersionUID = 0x1F6C3D80D124082FL;
                @b("TEMPERATURE")
                public String temperature;
                @b("TYPE")
                public String type;

            }

            @b("ARTISTLIST")
            public ArrayList artistList;
            private static final long serialVersionUID = 0xB0D1FAC6568B570EL;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class FRIENDLIST implements Serializable {
            public static class USERLIST extends UserInfoBase {
                @Override  // com.iloen.melon.net.v4x.common.UserInfoBase
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            private static final long serialVersionUID = 0xC06B559A14BFACBFL;
            @b("USERLIST")
            public ArrayList userList;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class LIKELIST implements Serializable {
            public static class ALBUMLIST extends AlbumInfoBase {
                private static final long serialVersionUID = 0x577A8D2546B7B62FL;

            }

            public static class DJPLAYLISTLIST extends ArtistPlayListInfoBase {
                private static final long serialVersionUID = 0x4D0745BAA7109C85L;

            }

            public static class MVLIST extends MvInfoBase {
                private static final long serialVersionUID = 0x85509918DE620964L;

            }

            public static class com.iloen.melon.net.v4x.response.InformMyProfileMainRes.RESPONSE.LIKELIST.PLAYLISTLIST extends ArtistPlayListInfoBase {
                private static final long serialVersionUID = 0x86D3942B353E7BE1L;

            }

            public static class SONGLIST extends SongInfoBase {
                private static final long serialVersionUID = 0x373440C4D011AD53L;

            }

            @b("ALBUMLIST")
            public ArrayList albumList;
            @b("DJPLAYLISTLIST")
            public ArrayList djPlaylistList;
            public boolean isBottom;
            public boolean isTop;
            @b("LIKEALBUMCOUNT")
            public String likeAlbumCount;
            @b("LIKEDJPLAYLISTCOUNT")
            public String likeDjPlayListCount;
            @b("LIKEMVCOUNT")
            public String likeMvCount;
            @b("LIKEPLAYLISTCOUNT")
            public String likePlayListCount;
            @b("LIKESONGCOUNT")
            public String likeSongCount;
            @b("MVLIST")
            public ArrayList mvList;
            @b("PLAYLISTLIST")
            public ArrayList playlistList;
            private static final long serialVersionUID = 0x4148A47EB0B8346BL;
            @b("SONGLIST")
            public ArrayList songList;

            public LIKELIST() {
                this.isTop = false;
                this.isBottom = false;
                this.songList = null;
                this.albumList = null;
                this.playlistList = null;
                this.djPlaylistList = null;
                this.mvList = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class LISTENLIST implements Serializable {
            public static class MANYLISTENSONGLIST extends SongInfoBase {
                private static final long serialVersionUID = 0x701E886D0C07CA41L;

            }

            public static class RECNTSONGLIST extends SongInfoBase {
                private static final long serialVersionUID = 0x3CE9F3C778719F9FL;

            }

            public boolean isBottom;
            public boolean isTop;
            @b("MANYLISTENSONGLIST")
            public ArrayList manyListenedSongList;
            @b("RECNTSONGLIST")
            public ArrayList recentSongList;
            private static final long serialVersionUID = 0x415870A494A608D9L;

            public LISTENLIST() {
                this.isTop = false;
                this.isBottom = false;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class MYPROFILE implements Serializable {
            @b("CPLANCODE")
            public String cPlanCode;
            @b("GRADEIMGPATH")
            public String gradeImgPath;
            @b("ISDJ")
            public boolean isDj;
            @b("MEMBERNICKNAME")
            public String memberNickname;
            @b("MYLOGNEWYN")
            public String myLogNewYn;
            @b("MYPAGEIMG")
            public String myPageImg;
            @b("REALNICKNAME")
            public String realNickname;
            private static final long serialVersionUID = 0xA258B8F4760A0842L;

            public MYPROFILE() {
                this.myPageImg = "";
                this.memberNickname = "";
                this.realNickname = "";
            }
        }

        public static class PLAYLIST implements Serializable {
            public static class com.iloen.melon.net.v4x.response.InformMyProfileMainRes.RESPONSE.PLAYLIST.PLAYLISTLIST implements Serializable {
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("DSPLYORDER")
                public String dsplyOrder;
                @b("ISDJ")
                public boolean isDj;
                @b("LIKECNT")
                public String likeCnt;
                @b("OPENYN")
                public String openYN;
                @b("OWNERMEMBERKEY")
                public String ownerMemberKey;
                @b("OWNERNICKNAME")
                public String ownerNickname;
                @b("PLYLSTSEQ")
                public String plylstSeq;
                @b("PLYLSTTITLE")
                public String plylstTitle;
                private static final long serialVersionUID = 0x25DCF339930F36B8L;
                @b("SONGCNT")
                public String songCnt;
                @b("THUMBIMG")
                public String thumbImg;
                @b("WITHDRAWYN")
                public String withDrawYn;

            }

            public boolean isBottom;
            public boolean isTop;
            @b("PLAYLISTLIST")
            public ArrayList playlistList;
            @b("SCHEMEURL")
            public String schemeUrl;
            private static final long serialVersionUID = 0x60837020E27D40B2L;

            public PLAYLIST() {
                this.isTop = false;
                this.isBottom = false;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("DJPLAYLIST")
        public DJPLAYLIST djPlayList;
        @b("FANLIST")
        public FANLIST fanList;
        @b("FRIENDLIST")
        public FRIENDLIST friendList;
        @b("ISALLEMPTY")
        public boolean isAllEmpty;
        @b("LIKELIST")
        public LIKELIST likeList;
        @b("LISTENLIST")
        public LISTENLIST listenList;
        @b("MYPROFILE")
        public MYPROFILE myProfile;
        @b("PLAYLIST")
        public PLAYLIST playList;
        private static final long serialVersionUID = 0x5A4D202F98AE1804L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xED17358E1D8B5F85L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

