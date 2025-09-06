package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicInsertBanSongRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("STATUS")
        public String status;

        public RESPONSE() {
            this.status = "";
        }
    }

    @b("response")
    public RESPONSE response;

    public MyMusicInsertBanSongRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

