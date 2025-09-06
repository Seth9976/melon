package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;

public class TvProgramBannerRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class Banner extends LinkInfoBase implements Serializable {
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
            @b(alternate = {"targetId"}, value = "TARGETID")
            public String targetId;

        }

        public List banners;

    }

    public String errorCode;
    public String errorMessage;
    public Response response;
    public boolean success;

}

