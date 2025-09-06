package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjTagInformV5Res extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class RELTAGLIST extends TagInfoBase {
            private static final long serialVersionUID = 1540979005017534157L;

        }

        @b("GNRCODE")
        public String genreCode;
        @b("IMGURL")
        public String imgUrl;
        @b("PLYLSTCNT")
        public String plylstCnt;
        @b("RELTAGLIST")
        public ArrayList relTagList;
        private static final long serialVersionUID = 0xDE4C14490424D6B6L;
        @b("TAGNAME")
        public String tagName;
        @b("TAGSEQ")
        public String tagSeq;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF8FF070439FF1EC3L;

    public DjTagInformV5Res() {
        this.response = null;
    }
}

