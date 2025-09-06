package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class SongLyricHighlightPostRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class POSTIMAGELIST implements Serializable {
            @b("LARGEIMAGEPATH")
            public String largeImagePath;
            private static final long serialVersionUID = 0x4749654106A92F28L;
            @b("THUMBIMAGEPATH")
            public String thumbImagePath;
            @b("VOICEOVERTEXT")
            public String voiceOverText;

            public POSTIMAGELIST() {
                this.largeImagePath = "";
                this.thumbImagePath = "";
                this.voiceOverText = "";
            }
        }

        public static class POSTINFO implements Serializable {
            @b("ALBUMIMG")
            public String albumImg;
            @b("ALBUMNAME")
            public String albumName;
            @b("ARTISTLIST")
            public ArrayList artistList;
            @b("CHICLYRIC")
            public String chicLyric;
            @b("MEMBERNICKNAME")
            public String memberNickName;
            @b("MEMBERKEY")
            public String memeberKey;
            @b("MENUID")
            public String menuId;
            @b("PAGE")
            public String page;
            @b("SECTION")
            public String section;
            private static final long serialVersionUID = 0x62B145064C96BF28L;
            @b("SONGID")
            public String songId;
            @b("SONGNAME")
            public String songName;

            public POSTINFO() {
                this.albumImg = "";
                this.albumName = "";
                this.artistList = null;
                this.chicLyric = "";
                this.memeberKey = "";
                this.memberNickName = "";
                this.songId = "";
                this.songName = "";
                this.menuId = "";
                this.section = "";
                this.page = "";
            }
        }

        @b("POSTIMAGELIST")
        public ArrayList postImageList;
        @b("POSTINFO")
        public POSTINFO postInfo;
        private static final long serialVersionUID = 0x6386736FA343DF28L;

        public RESPONSE() {
            this.postInfo = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1DDB12D7646A8B05L;

    public SongLyricHighlightPostRes() {
        this.response = null;
    }
}

