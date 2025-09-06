package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class PowerDjListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class POWERDJLIST extends DjInfoBase {
            @b("DJTITLE")
            public String djTitle;
            private static final long serialVersionUID = 0x8EB20D1E89B35AE8L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("POWERDJCNT")
        public String powerDjCnt;
        @b("POWERDJLIST")
        public ArrayList powerDjList;
        @b("POWERDJLISTTOOLTIP")
        public String powerDjListToolTip;
        private static final long serialVersionUID = 0x580B9DA45BCA235EL;

        public RESPONSE() {
            this.hasMore = false;
            this.powerDjList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x35150362DAA0EDD2L;

    public PowerDjListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

