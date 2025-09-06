package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.List;

public class NowChartBannerRes extends ResponseV4Res {
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
            private static final long serialVersionUID = 0x52B9D414DB45BEA0L;
            @b(alternate = {"targetId"}, value = "TARGETID")
            public String targetId;

            public BANNERS() {
                this.bannerSeq = "";
                this.adminTitle = "";
                this.targetId = "";
                this.imgUrl = "";
                this.imgAltText = "";
                this.bgColor = "";
                this.contsTypeCode = "";
                this.contsId = "";
            }
        }

        @b(alternate = {"banners"}, value = "BANNERS")
        public List banners;
        private static final long serialVersionUID = 0xA415108A7E2E2004L;

    }

    @b("ERRORCODE")
    public String errorCode;
    @b("ERRORMESSAGE")
    public String errorMessage;
    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x19A66F7E51B0F9ACL;
    @b("SUCCESS")
    public boolean success;

    public NowChartBannerRes() {
        this.errorCode = "";
        this.errorMessage = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

