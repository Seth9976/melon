package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.GenreBaseRes;
import com.melon.net.res.common.ResponseBase;

public class SettingGnrBaseRes extends ResponseV4Res {
    public static class GNRCODELIST extends GenreBaseRes {
        private static final long serialVersionUID = 0x574AD7743205AE8FL;

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class Response extends ResponseBase {
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 0xB4AF91EB1DC92F3L;

        public Response() {
            this.message = "";
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xB26ECEE317276F72L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

