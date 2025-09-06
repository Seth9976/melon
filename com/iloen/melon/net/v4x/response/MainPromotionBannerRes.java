package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class MainPromotionBannerRes extends ResponseV4Res {
    public static class MenuGubunCode {
        public static final String FOR_U_MID = "FOUMID";
        public static final String MUSIC_BOTTOM = "MUSBOT";
        public static final String MUSIC_MID = "MUSMID";
        public static final String MUSIC_UP = "MUSUP";
        public static final String STAR_MID = "STAMID";
        public static final String TICKET_MID = "MTKMID";
        public static final String TICKET_UP = "MTKUP";
        public static final String VIDEO_MID = "VDOMID";
        public static final String VIDEO_UP = "VDOUP";

    }

    public static class Response extends ResponseBase {
        public static class GuideBanner extends BannerBase {
            @b("BANERDTLSEQ")
            public String BanerDtlSeq;
            public static final String GUIDE_TYPE_EVENT = "E";
            public static final String GUIDE_TYPE_NOTIFICATION = "A";
            @b("BANERSETGUBUN")
            public String banerSetGubun;
            @b("COLORTYPE")
            public String colorType;
            @b("GUIDETYPE")
            public String guideType;
            private static final long serialVersionUID = 0x4AAE5C0B6F2C12E2L;
            @b("TEXT1")
            public String text1;
            @b("TEXT2")
            public String text2;
            @b("TEXT3")
            public String text3;

            @Override  // com.iloen.melon.net.v4x.common.BannerBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class PromoBannerList extends BannerBase {
            @b("BANERDTLSEQ")
            public String banerDtlSeq;
            @b("MENUGUBUNCODE")
            public String menuGubunCode;
            private static final long serialVersionUID = 0x4AAE5C0B71BC33ACL;

        }

        @b("GUIDEBANNER")
        public GuideBanner guideBanner;
        @b("GUIDEBANNER2")
        public GuideBanner guideBanner2;
        @b("PROMOBANNERLIST")
        public ArrayList promoBannerList;
        private static final long serialVersionUID = 0x497E9753B03DCD00L;
        @b("SERVICEBANNER")
        public PromoBannerList serviceBanner;

        public Response() {
            this.promoBannerList = null;
            this.guideBanner = null;
            this.guideBanner2 = null;
            this.serviceBanner = null;
        }

        public PromoBannerList getBanner(String s) {
            for(Object object0: this.promoBannerList) {
                PromoBannerList mainPromotionBannerRes$Response$PromoBannerList0 = (PromoBannerList)object0;
                if(mainPromotionBannerRes$Response$PromoBannerList0.menuGubunCode.equals(s)) {
                    return mainPromotionBannerRes$Response$PromoBannerList0;
                }
                if(false) {
                    break;
                }
            }
            return null;
        }

        public boolean hasBanner(String s) {
            for(Object object0: this.promoBannerList) {
                if(((PromoBannerList)object0).menuGubunCode.equals(s)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            return false;
        }

        public void margePromotionBanner(PromoBannerList mainPromotionBannerRes$Response$PromoBannerList0) {
            PromoBannerList mainPromotionBannerRes$Response$PromoBannerList1 = this.getBanner(mainPromotionBannerRes$Response$PromoBannerList0.menuGubunCode);
            if(mainPromotionBannerRes$Response$PromoBannerList1 == null) {
                this.promoBannerList.add(mainPromotionBannerRes$Response$PromoBannerList0);
                return;
            }
            int v = this.promoBannerList.indexOf(mainPromotionBannerRes$Response$PromoBannerList1);
            this.promoBannerList.set(v, mainPromotionBannerRes$Response$PromoBannerList0);
        }

        public void mergePromotionBannerList(ArrayList arrayList0) {
            for(Object object0: arrayList0) {
                this.margePromotionBanner(((PromoBannerList)object0));
            }
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xB65C7903B21D054BL;

}

