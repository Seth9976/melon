package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class CastProgramDetailRes extends ResponseV5Res {
    public static class Response extends ResponseBase {
        public static class Banner extends BannerBase {
            private static final long serialVersionUID = 0x6D6F26820B35BD3L;

        }

        public static class Program extends ProgramBase {
            private static final long serialVersionUID = 0x9282A5B8FA1628L;

        }

        @b("BANNER")
        public Banner banner;
        @b("PROGRAM")
        public Program program;
        private static final long serialVersionUID = 0x147A09550276493EL;

    }

    public Response response;
    private static final long serialVersionUID = 0x39C48B0FB448722BL;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

