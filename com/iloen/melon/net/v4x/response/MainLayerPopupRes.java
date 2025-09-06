package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MainLayerPopupRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class Banners extends BannerBase {
            public static class BANON implements Serializable {
                @b("expiration")
                public String expiration;
                @b("seq")
                public String seq;
                private static final long serialVersionUID = 0xEE7F3CE95F02596FL;

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("banOn")
            public BANON banon;
            @b("dpTitle")
            public String dpTitle;
            @b("dpType")
            public String dpType;
            @b("layerBnSeq")
            public String layerBnSeq;
            private static final long serialVersionUID = -8020205432559430590L;

            public Banners() {
                this.layerBnSeq = "";
                this.dpType = "-1";
                this.dpTitle = "";
                this.banon = null;
            }

            @Override  // com.iloen.melon.net.v4x.common.BannerBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class EXPIREDBANS implements Serializable {
            @b("ID")
            public String id;
            private static final long serialVersionUID = 0x11FBE59D80BAA8B2L;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("banners")
        public ArrayList banners;
        @b("expiredBans")
        public ArrayList expiredBans;
        private static final long serialVersionUID = 2103766785653104279L;

        public Response() {
            this.expiredBans = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 6679258823089779900L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

