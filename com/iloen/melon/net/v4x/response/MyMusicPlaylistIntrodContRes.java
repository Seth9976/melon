package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicPlaylistIntrodContRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("INTRODCONT")
        public String introdCont;
        @b("PLYLSTTITLE")
        public String plylstTitle;
        private static final long serialVersionUID = -6080944805533543461L;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDE20D69478D65986L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

