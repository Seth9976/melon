package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class PromotionContentsBannerRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class Banner extends LinkInfoBase {
            @b("adminTitle")
            public String adminTitle;
            @b("bannerSeq")
            public String bannerSeq;
            @b("bgColor")
            public String bgColor;
            @b("contsId")
            public String contsId;
            @b("contsTypeCode")
            public String contsTypeCode;
            @b("imgAltText")
            public String imgAltText;
            @b("imgUrl")
            public String imgUrl;
            private static final long serialVersionUID = 0x6387861A442B8E78L;
            @b("targetId")
            public String targetId;

            public Banner() {
                this.bannerSeq = null;
                this.adminTitle = "";
                this.targetId = "";
                this.imgUrl = "";
                this.imgAltText = "";
                this.bgColor = "";
                this.contsTypeCode = "";
                this.contsId = "";
            }
        }

        @b("banners")
        public ArrayList banners;
        @b("dummyText")
        public String dummyText;
        @b("errorCode")
        public String errorCode;
        @b("errorMessage")
        public String errorMessage;
        private static final long serialVersionUID = 0x6387861A442B8E78L;

        public RESPONSE() {
            this.banners = null;
            this.dummyText = "";
            this.errorCode = "";
            this.errorMessage = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1DDB31C862A18485L;

    public PromotionContentsBannerRes() {
        this.response = null;
    }
}

