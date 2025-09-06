package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.GenreBaseRes;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class SettingGnrListExcGnrRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class GNRCODELIST extends GenreBaseRes {
            private static final long serialVersionUID = 0x574AD7743205AE8FL;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("GNRCODELIST")
        public ArrayList gnrCodeList;
        private static final long serialVersionUID = 0xB4AF91EB1DC92F3L;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xB26ECEE317276F72L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

