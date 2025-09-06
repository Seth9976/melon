package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class InsertHiddenFriendRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x4F877018D444C3ADL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB569E41627F8DAAAL;

    public InsertHiddenFriendRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

