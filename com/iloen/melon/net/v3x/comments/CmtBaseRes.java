package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v3x.ResponseV3Res;
import com.iloen.melon.net.v4x.common.ToStringUtil;

public abstract class CmtBaseRes extends ResponseV3Res {
    @b("ERRORMESSAGE")
    public String errormessage;
    private static final long serialVersionUID = 0xEB1F7D6E7BDFCC72L;

    public CmtBaseRes() {
        this.errormessage = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

