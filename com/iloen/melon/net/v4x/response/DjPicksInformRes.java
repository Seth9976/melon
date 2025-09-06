package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjPicksInformRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTLIST extends ArtistsInfoBase {
            private static final long serialVersionUID = 2120503819286829091L;

        }

        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("IMGURL")
        public String imgUrl;
        @b("JOINPOSBLYN")
        public String joinPosblYn;
        @b("MESSAGE")
        public String message;
        @b("PICKDESC")
        public String pickDesc;
        @b("PICKID")
        public String pickId;
        @b("PICKINFO")
        public String pickInfo;
        @b("PICKTITLE")
        public String pickTitle;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        private static final long serialVersionUID = 0xC86DDF8941F2E77L;
        @b("VALIDCMTCNT")
        public String validCmtCnt;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x613364B2C5DCAF1L;

    public DjPicksInformRes() {
        this.response = null;
    }
}

