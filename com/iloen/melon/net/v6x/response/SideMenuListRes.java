package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.List;

public class SideMenuListRes extends ResponseV6Res {
    public static class MENULISTBASE extends LinkInfoBase {
        @b("COPY")
        public String copy;
        @b("IMGURL")
        public String imgUrl;
        @b("REDDOT")
        public String redDot;
        private static final long serialVersionUID = 0x88043220F2E18761L;
        @b("SIDEYN")
        public String sideYn;
        @b("TITLE")
        public String title;

    }

    public static class Response extends ResponseBase {
        private static final long serialVersionUID = 0x2013602264DC72BCL;
        @b("SERVICEMENULIST")
        public List serviceMenuList;
        @b("SNSMENULIST")
        public List snsMenuList;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class SERVICEMENULIST extends MENULISTBASE {
        private static final long serialVersionUID = 0x6CFC0E9876FC42CAL;

    }

    public static class SNSMENULIST extends MENULISTBASE {
        private static final long serialVersionUID = 0x7E5FC69188FD3725L;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x7DD17ED75F8AC74DL;

}

