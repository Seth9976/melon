package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MelonTvVdoInformRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class MV extends MvInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("EPSDYN")
            public String epsdYn;
            @b("ISDOWNLOAD")
            public boolean isDownload;
            @b("PROGSEQ")
            public String progSeq;
            @b("PROGTHUMBIMAGEURL")
            public String progThumbImageUrl;

            public MV() {
                this.contsTypeCode = "";
                this.isDownload = false;
                this.progSeq = "";
                this.progThumbImageUrl = "";
                this.epsdYn = "";
            }
        }

        public static class STORYLIST implements Serializable {
            private static final long serialVersionUID = 0x708F232EBDFDD0FDL;
            @b("STORYSEQ")
            public String storySeg;
            @b("STORYTITLE")
            public String storyTitle;

        }

        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("MV")
        public MV mv;
        private static final long serialVersionUID = 0xF8855368D4DE6C83L;
        @b("STORYLIST")
        public ArrayList storyList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3B87229618FDD0BCL;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

