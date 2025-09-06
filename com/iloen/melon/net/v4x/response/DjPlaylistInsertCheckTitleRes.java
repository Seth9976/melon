package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DjPlaylistInsertCheckTitleRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("PLYLSTTITLE")
        public String plylstTitle;
        private static final long serialVersionUID = 0x65E7606493A8AA6L;

        public RESPONSE() {
            this.plylstTitle = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x87FD049FFF0A7CA4L;

    public DjPlaylistInsertCheckTitleRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

