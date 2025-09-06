package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DeleteHiddenFriendRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x77D5B9EABFED1BDDL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xCD0649ADAE8F6843L;

    public DeleteHiddenFriendRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

