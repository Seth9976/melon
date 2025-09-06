package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicUpdateMyProfileOpenYnRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("OPENFLAG")
        public String openFlag;
        @b("OPENFLAGTYPE")
        public String openFlagType;
        private static final long serialVersionUID = 4875813670032599964L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x780719DB0CF5832EL;

    public MyMusicUpdateMyProfileOpenYnRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

