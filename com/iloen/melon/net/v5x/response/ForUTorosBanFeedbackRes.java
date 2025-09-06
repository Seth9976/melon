package com.iloen.melon.net.v5x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class ForUTorosBanFeedbackRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 1643200697941379985L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xC314094AFAAEB51AL;

    public ForUTorosBanFeedbackRes() {
        this.response = null;
    }
}

