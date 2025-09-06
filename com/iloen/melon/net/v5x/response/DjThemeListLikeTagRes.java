package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjThemeListLikeTagRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class LIKETAGLIST extends TagInfoBase {
            public int index;
            private static final long serialVersionUID = 0x75BA92A28288D2FCL;

            public LIKETAGLIST() {
                this.index = 0;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("LIKETAGLIST")
        public ArrayList likeList;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;

        public RESPONSE() {
            this.likeList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79B255E5E90836ADL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

