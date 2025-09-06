package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class DjPlaylistAddDjSongRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("PLYLSTSEQ")
        public String plylstSeq;
        private static final long serialVersionUID = 0xD4E244CD054C008CL;

        public RESPONSE() {
            this.plylstSeq = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD4882B440060A147L;

    public DjPlaylistAddDjSongRes() {
        this.response = null;
    }
}

