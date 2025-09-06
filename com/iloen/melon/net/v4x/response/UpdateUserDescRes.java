package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class UpdateUserDescRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x96128B6CCAE3A012L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF424663266A6DA80L;

    public UpdateUserDescRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

