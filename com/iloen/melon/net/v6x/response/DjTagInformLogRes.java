package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DjTagInformLogRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        private static final long serialVersionUID = 0x746D40BE9F40093DL;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xF424663266A6DA80L;

    public DjTagInformLogRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

