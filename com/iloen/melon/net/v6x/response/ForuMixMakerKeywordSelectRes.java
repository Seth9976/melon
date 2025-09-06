package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ForuMixMakerKeywordSelectRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class RELTAGLIST extends TAGLIST {
            private static final long serialVersionUID = 0x18311878BCD63F0BL;

        }

        @b("ARTISTIMGURLLIST")
        public ArrayList artistImgUrlList;
        @b("RELTAGLIST")
        public ArrayList relTagList;
        private static final long serialVersionUID = -2505756156223709550L;
        @b("SONGNAMELIST")
        public ArrayList songNameList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA752D87D0285E6D0L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

