package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ChartMyHitsSongsIdRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        private static final long serialVersionUID = 0x2C8CDB4A28D3B627L;
        @b("SONGIDLIST")
        public ArrayList songIdList;

        public Response() {
            this.songIdList = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x82E4B31EE2C1FE6L;

    public ChartMyHitsSongsIdRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

