package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ForUListWelcomePickCodeRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CODELIST implements Serializable {
            public static class SUBLIST implements Serializable {
                @b("IMGURL")
                public String imgUrl;
                private static final long serialVersionUID = 7462401118909605923L;
                @b("TAGNAME")
                public String tagName;
                @b("WELCOMEMIXSUBCODE")
                public String welcomeMixSubCode;

            }

            @b("GNRCOLOR")
            public String gnrColor;
            @b("GNRNAME")
            public String gnrName;
            @b("IMGURL")
            public String imgUrl;
            private static final long serialVersionUID = 0x71C42903DDB8A79CL;
            @b("SUBLIST")
            public ArrayList subList;
            @b("TAGNAME")
            public String tagName;
            @b("WELCOMEMIXCODE")
            public String welcomeMixCode;

        }

        @b("CODELIST")
        public ArrayList codeList;
        private static final long serialVersionUID = 0x5640A50625266CF6L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xAB2B1F44999C4758L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

