package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ForUWeatherRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTS implements Serializable {
            public static class STATSELEMENTS extends StatsElementsBase {
                private static final long serialVersionUID = 0xAFAAA81777584DFAL;

            }

            public static class TAGS extends TagInfoBase {
                private static final long serialVersionUID = 0x43263E3EA0ED8979L;

            }

            @b("CONTSID")
            public String contsId;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("DETAILIMGURLS")
            public ArrayList detailImgUrls;
            @b("DETAILMAKER")
            public String detailMaker;
            @b("DETAILTEXT")
            public String detailText;
            @b("DETAILTITLE")
            public String detailTitle;
            @b("DETAILTYPECODE")
            public String detailTypeCode;
            @b("DETAILUPDATEDATE")
            public String detailUpdateDate;
            @b("FORUDATATYPE")
            public String foruDataType;
            @b("MAINARTIST")
            public String mainArtist;
            @b("MAINIMGURLS")
            public ArrayList mainImgUrls;
            @b("MAINLIKECOUNT")
            public String mainLikeCount;
            @b("MAINTEXT")
            public String mainText;
            @b("MAINTITLE")
            public String mainTitle;
            @b("MAINTYPECODE")
            public String mainTypeCode;
            private static final long serialVersionUID = 0x4DD7CC9199FA550BL;
            @b("SONGIDS")
            public String songIds;
            @b("STATSELEMENTS")
            public STATSELEMENTS statsElements;
            @b("TAGS")
            public ArrayList tags;

            public CONTENTS() {
                this.statsElements = null;
            }
        }

        @b("ANDROIDLOGMIN")
        public String androidLogMin;
        @b("AREANAME")
        public String areaName;
        @b("CONTENTS")
        public ArrayList contents;
        @b("ISAGREE")
        public boolean isAgree;
        @b("ISFIRSTOFALL")
        public boolean isFirstOfAll;
        @b("ORIGIN")
        public String origin;
        private static final long serialVersionUID = 0xAE417A5376A0E064L;
        @b("SPECIALWEATHER")
        public String specialWeather;
        @b("TEMPERATURE")
        public String temperature;
        @b("WEATHER")
        public String weather;
        @b("WEATHERCODE")
        public String weatherCode;
        @b("WEATHERTITLE")
        public String weatherTitle;

        public RESPONSE() {
            this.contents = null;
            this.isFirstOfAll = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 7926100181506668404L;

}

