package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.DetailBaseRes.DetailResponseBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes;

public class PlaylistInformBaseRes extends DetailBaseRes {
    public static class RESPONSE extends DetailResponseBase {
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 7140602929154007221L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.v5x.response.DetailBaseRes
    public DetailResponseBase getResponseBase() {
        return this.response;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

