package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjThemeListPlylstForEdgeRes extends ResponseV4Res {
    public static class response extends ResponseBase {
        public static class PLYLSTLIST extends DjPlayListInfoBase {
            @b("CURRANK")
            public String curRank;
            @b("DJMAGREGYN")
            public String djMagRegYn;
            @b("ISLABEL")
            public String isLabel;
            private static final long serialVersionUID = 5000557254273537803L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLYLSTLIST")
        public ArrayList plylstList;
        private static final long serialVersionUID = 0x3866B052130D4DE0L;

    }

    @b("response")
    public response response;
    private static final long serialVersionUID = 0x3C88EAF65A243C71L;

    public DjThemeListPlylstForEdgeRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }
}

