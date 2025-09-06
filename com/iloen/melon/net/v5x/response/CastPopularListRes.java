package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.List;

public class CastPopularListRes extends ResponseV5Res {
    public static class Response extends ResponseBase {
        public static class CAST extends CastInfoBase {
            @b("PROGTITLE")
            public String progTitle;
            private static final long serialVersionUID = 0x6B9A6911CBA4575AL;

            public CAST() {
                this.progTitle = "";
            }
        }

        @b("CASTLIST")
        public List castList;
        private static final long serialVersionUID = -4100391853884857691L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xDB2925E77154C3AFL;

    public CastPopularListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }
}

