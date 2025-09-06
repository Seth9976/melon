package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;

public class SongMoreInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class TIKTOK extends LinkInfoBase {
            private static final long serialVersionUID = 0x72A8581F6DE25995L;

        }

        private static final long serialVersionUID = 0x746D40BE9F40093DL;
        @b("TIKTOK")
        public TIKTOK tiktok;

        public RESPONSE() {
            this.tiktok = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF424663266A6DA80L;

    public SongMoreInfoRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

