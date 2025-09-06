package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.List;

public class ChartHot100BannerRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class BANNERS extends LinkInfoBase {
            @b(alternate = {"adminTitle"}, value = "ADMINTITLE")
            public String adminTitle;
            @b(alternate = {"bannerSeq"}, value = "BANNERSEQ")
            public String bannerSeq;
            @b(alternate = {"bgColor"}, value = "BGCOLOR")
            public String bgColor;
            @b(alternate = {"contsId"}, value = "CONTSID")
            public String contsId;
            @b(alternate = {"contsTypeCode"}, value = "CONTSTYPECODE")
            public String contsTypeCode;
            @b(alternate = {"imgAltText"}, value = "IMGALTTEXT")
            public String imgAltText;
            @b(alternate = {"imgUrl"}, value = "IMGURL")
            public String imgUrl;
            private static final long serialVersionUID = 0x41418625850FE56L;
            @b(alternate = {"targetId"}, value = "TARGETID")
            public String targetId;
            @b(alternate = {"text1"}, value = "TEXT1")
            public String text1;
            @b(alternate = {"text2"}, value = "TEXT2")
            public String text2;

            public BANNERS() {
                this.bannerSeq = "";
                this.adminTitle = "";
                this.targetId = "";
                this.imgUrl = "";
                this.imgAltText = "";
                this.bgColor = "";
                this.text1 = "";
                this.text2 = "";
                this.contsTypeCode = "";
                this.contsId = "";
            }
        }

        @b(alternate = {"banners"}, value = "BANNERS")
        public List banners;
        private static final long serialVersionUID = 0x66B10560A29A5A71L;

    }

    @b("ERRORCODE")
    public String errorCode;
    @b("ERRORMESSAGE")
    public String errorMessage;
    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xE557726A0BFF32C5L;
    @b("SUCCESS")
    public boolean success;

    public ChartHot100BannerRes() {
        this.errorCode = "";
        this.errorMessage = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

