package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;

public class DjSnsUseAgreeRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class OPTION extends LinkInfoBase {
            @b("ACTION")
            public String action;
            private static final long serialVersionUID = 0x4E808E818E13B79EL;

            public OPTION() {
                this.action = "";
            }
        }

        @b("ISAGREE")
        public boolean isAgree;
        @b("OPTION")
        public OPTION option;
        private static final long serialVersionUID = 0x4E7260FC4E2BFF9EL;

        public RESPONSE() {
            this.isAgree = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x76B7338957DB780L;

    public DjSnsUseAgreeRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

