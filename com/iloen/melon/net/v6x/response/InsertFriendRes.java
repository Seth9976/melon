package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class InsertFriendRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x580B9DA45BCA235EL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE3A07B679E3BE4BDL;

    public InsertFriendRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

