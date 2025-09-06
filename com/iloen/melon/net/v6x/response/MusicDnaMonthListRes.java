package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class MusicDnaMonthListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("LOG_MONTH")
        public ArrayList logMonths;
        private static final long serialVersionUID = 0xA28B56A8DFE32659L;

        public RESPONSE() {
            this.logMonths = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1DB6E38A47650ABCL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

