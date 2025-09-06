package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class SongPlayerInfoPostContentRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        private static final long serialVersionUID = 0x2D6353E04FBA6C6BL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -3584023050244870990L;

    public SongPlayerInfoPostContentRes() {
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

