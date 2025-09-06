package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class MyMusicDjPickUpdatePlaylistRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("MEMBERKEY")
        public String memberKey;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        private static final long serialVersionUID = 0x660667DF4B76E276L;

        public RESPONSE() {
            this.memberKey = "";
            this.plylstSeq = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xFBA3446C2C12303L;

    public MyMusicDjPickUpdatePlaylistRes() {
        this.response = null;
    }
}

