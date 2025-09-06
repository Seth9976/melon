package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ForUWeatherRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class WEATHERLIST implements Serializable {
            @b("AREANAME")
            public String areaName;
            @b("DPCODE")
            public String dpCode;
            private static final long serialVersionUID = 0x75BA92A28288D2FCL;
            @b("TEMPERATURE")
            public String temperature;
            @b("WEATHER")
            public String weather;
            @b("WEATHERCODE")
            public String weatherCode;

        }

        @b("ANDROIDLOGMIN")
        public String androidLogMin;
        @b("DPKEYWORD")
        public String dpKeyword;
        @b("ISAGREE")
        public boolean isAgree;
        @b("ORIGIN")
        public String origin;
        @b("RECMKEYWORD")
        public String recmKeyword;
        private static final long serialVersionUID = -4196303086504438411L;
        @b("SPECIALWEATHER")
        public String specialWeather;
        @b("TITLE")
        public String title;
        @b("WEATHERLIST")
        public ArrayList weatherList;

        public Response() {
            this.weatherList = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = -1013750929623277021L;

}

