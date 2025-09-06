package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;

public class MainForuBase extends ResponseBase {
    public static class CONTENT extends ForUMixInfoBase {
        private static final long serialVersionUID = 0xA0646A694292D5BAL;
        @b("SONGID")
        public String songId;
        @b("TEMPERATURE")
        public String temperature;

    }

    public static class MIX implements Serializable {
        @b("LIST")
        public List list;
        private static final long serialVersionUID = 0x1D1B8A0E76405E8L;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public MIX() {
            this.list = null;
        }
    }

    public static class STATSELEMENTS extends StatsElementsBase {
        private static final long serialVersionUID = -8805748098790750874L;

    }

    @b("ANDROIDLOGMIN")
    public String androidLogMin;
    @b("AREANAME")
    public String areaName;
    @b("CONTENTS")
    public List contentList;
    @b("GENRECODE")
    public String genreCode;
    @b("LIST")
    public List genreList;
    @b("GENRENAME")
    public String genreName;
    @b("ISAGREE")
    public boolean isAgree;
    @b("ISFIRST")
    public boolean isFirst;
    @b("ORIGIN")
    public String origin;
    @b("PERSONALMIX")
    public MIX personalMix;
    @b("PERSONALMIXREPLACE")
    public String personalMixReplace;
    @b("PERSONALMIXTITLE")
    public String personalMixTitle;
    @b("REPLACE")
    public String replace;
    private static final long serialVersionUID = 0x5D00BDD4FC2D826FL;
    @b("SPECIALWEATHER")
    public String specialWeather;
    @b("STATSELEMENTS")
    public STATSELEMENTS statsElements;
    @b("TEMPERATURE")
    public String temperature;
    @b("TITLE")
    public String title;
    @b("TOPMIX")
    public MIX topMix;
    @b("UPPERREPLACE")
    public String upperReplace;
    @b("UPPERTITLE")
    public String upperTitle;
    @b("WEATHER")
    public String weather;
    @b("WEATHERCODE")
    public String weatherCode;
    @b("WEATHERTITLE")
    public String weatherTitle;

    public MainForuBase() {
        this.isFirst = false;
        this.genreList = null;
        this.contentList = null;
        this.topMix = null;
        this.personalMix = null;
    }

    @Override  // com.melon.net.res.common.ResponseBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

