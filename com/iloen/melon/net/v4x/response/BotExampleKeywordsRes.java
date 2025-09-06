package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class BotExampleKeywordsRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public class KEYWORDLIST implements Serializable {
            @b("KEYWORD")
            public String keyword;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("KEYWORDLIST")
        public ArrayList keyList;

    }

    @b("response")
    public RESPONSE response;

    public ArrayList getItems() {
        ArrayList arrayList0 = this.response.keyList;
        return arrayList0 == null || arrayList0.isEmpty() ? null : this.response.keyList;
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

