package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjTagSearchRecommendsRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class TAGLIST extends TagInfoBase {
            private static final long serialVersionUID = 0xDA2B34B471E18EA0L;

        }

        private static final long serialVersionUID = 4101430080929191969L;
        @b("TAGLIST")
        public ArrayList tagList;

        public RESPONSE() {
            this.tagList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5F8FDFD74329D6CCL;

    public DjTagSearchRecommendsRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

