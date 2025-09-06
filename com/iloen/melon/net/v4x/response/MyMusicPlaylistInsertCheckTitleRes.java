package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicPlaylistInsertCheckTitleRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("PLYLSTTITLE")
        public String plylstTitle;
        private static final long serialVersionUID = 0x3B671DA971C8FAD5L;

        public RESPONSE() {
            this.plylstTitle = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1E10C421D273E1L;

    public MyMusicPlaylistInsertCheckTitleRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

