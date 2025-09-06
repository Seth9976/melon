package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class ChartMenuStatusRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class MENUSTATUS implements Serializable {
            private static final long serialVersionUID = 0xA78E53DADC7F923CL;
            @b("MYCHARTMENU")
            public Boolean showMyTab;
            @b("REALTIMEMENU")
            public Boolean showRealtimeTab;
            @b("RECENTMENU")
            public Boolean showRecentTab;

            public MENUSTATUS() {
                this.showRealtimeTab = Boolean.FALSE;
                this.showRecentTab = Boolean.FALSE;
                this.showMyTab = Boolean.FALSE;
            }
        }

        @b("MENUSTATUS")
        public MENUSTATUS menuStatus;
        private static final long serialVersionUID = 0xC4A49F356F11ECFAL;

        public RESPONSE() {
            this.menuStatus = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDF72BA1172F0C19L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

