package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;

public class PlaylistInsertBaseRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("PLYLSTSEQ")
        public String plylstSeq;
        private static final long serialVersionUID = 8296907904744317486L;
        @b("SLEEPTIME")
        public int sleepTime;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xBB05A9BA6BE46E87L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

