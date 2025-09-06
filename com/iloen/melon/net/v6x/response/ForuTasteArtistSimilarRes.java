package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ForuTasteArtistSimilarRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("ARTISTLIST")
        public ArrayList artistList;
        private static final long serialVersionUID = -6091030627590405474L;

        public RESPONSE() {
            this.artistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4E60D28A3E453913L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

