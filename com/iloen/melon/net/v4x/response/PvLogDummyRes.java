package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class PvLogDummyRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
    }

    @b("response")
    public RESPONSE response;

    public PvLogDummyRes() {
        this.response = null;
    }
}

