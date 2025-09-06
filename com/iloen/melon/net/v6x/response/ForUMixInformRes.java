package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;

public class ForUMixInformRes extends ResponseV6Res {
    public static class RESPONSE extends ForUMixInfoBase {
        @b("ISDP")
        public boolean isDp;
        @b("MENUID")
        public String menuId;
        @b("PAGE")
        public String page;
        @b("RESPONSE")
        public String response;
        @b("RESULTCODE")
        public String resultCode;
        @b("SECTION")
        public String section;
        private static final long serialVersionUID = 0xA4683F1C3A21C668L;
        @b("SIZE")
        public int size;
        @b("WEATHER")
        public String weather;
        @b("WEATHERCODE")
        public String weatherCode;
        @b("WEATHERTITLE")
        public String weatherTitle;

        public RESPONSE() {
            this.weatherTitle = "";
            this.weather = "";
            this.weatherCode = "";
            this.isDp = false;
            this.response = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2D5D1A93AE936AE2L;

    public ForUMixInformRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

