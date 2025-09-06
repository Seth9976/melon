package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ListCommCodeInfoRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class CODELIST implements Serializable {
            @b("CODENAME")
            public String codeCode;
            @b("COMMCODE")
            public String commCode;
            @b("PRNTCODE")
            public String prntCode;
            private static final long serialVersionUID = 0x572D0EECF8B8318DL;
            @b("UPDTDATE")
            public String updtDate;

        }

        @b("CODELIST")
        public ArrayList codeList;
        private static final long serialVersionUID = 1588864995080029540L;
        @b("VERSION")
        public String version;

        public RESPONSE() {
            this.codeList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA7BF66DE8BD29176L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

