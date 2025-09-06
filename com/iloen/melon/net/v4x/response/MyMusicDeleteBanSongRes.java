package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicDeleteBanSongRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        private static final long serialVersionUID = 0x5576A2D5B6D4CEDDL;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x20CA9D53BE65684CL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

