package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class MusicWavePlayInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class CHANNELINFO implements Serializable {
            @b("CHANNELTITLE")
            public String channelTitle;
            @b("IMGTYPE")
            public String imgType;
            @b("IMGURL")
            public String imgUrl;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;

        }

        public static class LOG implements Serializable {
            public static class MINIPLAYER implements Serializable {
                @b("KEY")
                public String key;
                @b("MENUID")
                public String menuId;
                @b("TITLE")
                public String title;

            }

            @b("MINIPLAYER")
            public MINIPLAYER miniplayer;

        }

        public static class NEXTSONG implements Serializable {
            @b("ARTISTNAME")
            public String artistName;
            @b("CTYPE")
            public String cType;
            @b("IMGURL")
            public String imgUrl;
            @b("SONGID")
            public String songId;
            @b("SONGNAME")
            public String songName;

        }

        @b("ARTISTID")
        public String artistId;
        @b("ARTISTNAME")
        public String artistName;
        @b("CTYPE")
        public String cType;
        @b("CHANNELINFO")
        public CHANNELINFO channelInfo;
        @b("CURRENTTIME")
        public Float currentTimeMs;
        @b("INTERVAL")
        public long interval;
        @b("INTERVALCOUNT")
        public int intervalCount;
        @b("LOG")
        public LOG log;
        @b("NEXTSONG")
        public NEXTSONG nextSong;
        private static final long serialVersionUID = 0x3F5389317EC21563L;
        @b("SONGID")
        public String songId;
        @b("IMGURL")
        public String songImgUrl;
        @b("SONGNAME")
        public String songName;
        @b("STATSELEMENTS")
        public StatsElementsBase statsElements;
        @b("STATUS")
        public String status;

        public RESPONSE() {
            this.statsElements = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x97606511AA782143L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

