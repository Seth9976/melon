package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;
import s9.a;

public class ForUMixmakerKeywordPredictiveRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class TAGLIST implements Serializable, a {
            @b("PLYLSTCNT")
            public String plyLstCnt;
            private static final long serialVersionUID = 0x12276D4F8FF2A222L;
            @b("TAGNAME")
            public String tagName;
            @b("TAGSEQ")
            public String tagSeq;

            public TAGLIST() {
                this.tagSeq = "";
                this.tagName = "";
                this.plyLstCnt = "";
            }

            @Override  // s9.a
            public int getContentType() {
                return 4;
            }
        }

        private static final long serialVersionUID = 0xF869154B0249BEB3L;
        @b("TAGLIST")
        public List tagList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 2610488501932364821L;

}

