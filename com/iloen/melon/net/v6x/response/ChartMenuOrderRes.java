package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class ChartMenuOrderRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class MENUORDER implements Serializable {
            @b("HOT100ORDER")
            public String hot100Order;
            private static final long serialVersionUID = 0x2C90F07DFD79F4DFL;
            @b("TOP100ORDER")
            public String top100Order;

        }

        @b("MENUORDER")
        public MENUORDER menuOrder;
        private static final long serialVersionUID = 649410170155932044L;

        public RESPONSE() {
            this.menuOrder = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x81B2442E0BAB2BA9L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

