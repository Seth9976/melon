package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class GiftProhibitedWordsCheckRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 3110775049409358531L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 3830658571151768510L;

    public GiftProhibitedWordsCheckRes() {
        this.response = null;
    }
}

