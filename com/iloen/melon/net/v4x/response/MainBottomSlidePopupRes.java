package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import java.util.List;

public class MainBottomSlidePopupRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class Banner extends BannerBase {
            @b("buttonBgColor")
            public String buttonBgColor;
            @b("buttonText")
            public String buttonText;
            @b("buttonTextColor")
            public String buttonTextColor;
            @b("dismissColor")
            public String dismissColor;
            @b("dpTitle")
            public String dpTitle;
            @b("dpType")
            public String dpType;
            private static final long serialVersionUID = 0x42CFAF1CAC18593AL;

            public Banner() {
                this.buttonText = null;
                this.dpType = null;
                this.dpTitle = null;
                this.dismissColor = null;
                this.buttonBgColor = null;
                this.buttonTextColor = null;
            }

            @Override  // com.iloen.melon.net.v4x.common.BannerBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("banners")
        public List banners;
        private static final long serialVersionUID = 7412360239307531064L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xD0959BDB08407BF6L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

