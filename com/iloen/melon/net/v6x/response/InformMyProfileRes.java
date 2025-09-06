package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class InformMyProfileRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("BNRSGMT")
        public String bnrSgmt;
        @b("CPLANCODE")
        public String cPlanCode;
        @b("GRADEIMGPATH")
        public String gradeImgPath;
        @b("HASFLACSTPROD")
        public boolean hasFlacStProd;
        @b("HIFIPROD")
        public String hifiProd;
        @b("ISDJ")
        public boolean isDj;
        @b("MEMBERNICKNAME")
        public String memberNickname;
        @b("MYLOGNEWYN")
        public String myLogNewYn;
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("PRODUCTINFO")
        public String productInfo;
        @b("REALNICKNAME")
        public String realNickname;
        private static final long serialVersionUID = 0x5A4D202F98AE1804L;

        public RESPONSE() {
            this.myPageImg = "";
            this.memberNickname = "";
            this.realNickname = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xED17358E1D8B5F85L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

