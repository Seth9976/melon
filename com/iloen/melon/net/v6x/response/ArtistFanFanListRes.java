package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class ArtistFanFanListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class RECENTLYLIKEFANLIST implements Serializable {
            @b("ALBUMIMG")
            public String albumImg;
            @b("ARTISTNAME")
            public String artistName;
            @b("CONTSID")
            public String contsId;
            @b("CONTSNAME")
            public String contsName;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            public String followYN;
            @b("MEMBERKEY")
            public String memberKey;
            @b("MEMBERNICKNAME")
            public String memberNickname;
            @b("MYPAGEIMG")
            public String myPageImg;
            @b("RECMDTEXT")
            public String recmdText;
            private static final long serialVersionUID = 0x5381D71F4F59C09CL;

            public RECENTLYLIKEFANLIST() {
                this.memberKey = "";
                this.memberNickname = "";
                this.myPageImg = "";
                this.recmdText = "";
                this.contsTypeCode = "";
                this.contsId = "";
                this.contsName = "";
                this.artistName = "";
                this.albumImg = "";
            }
        }

        public static class RISINGFANLIST implements Serializable {
            @b("MEMBERKEY")
            public String memberKey;
            @b("MEMBERNICKNAME")
            public String memberNickname;
            @b("MYPAGEIMG")
            public String myPageImg;
            private static final long serialVersionUID = 0xB6E2BB0F7AA3BC47L;
            @b("TEMPERATURE")
            public String temperature;
            @b("TEMPERATUREGAP")
            public String temperatureGap;

            public RISINGFANLIST() {
                this.memberKey = "";
                this.memberNickname = "";
                this.temperature = "";
                this.temperatureGap = "";
                this.myPageImg = "";
            }
        }

        @b("RECENTLYLIKEFANLIST")
        public ArrayList recentlyLikeFanList;
        @b("RISINGFANLIST")
        public ArrayList risingFanList;
        private static final long serialVersionUID = 0xA6F6D9A4DBE4C1AFL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 348300891794029137L;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

