package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class DjPopularListCateBaseRes extends ResponseV4Res {
    public static class response extends ResponseBase {
        public static class CATELIST implements Serializable {
            @b("CATECODE")
            public String cateCode;
            @b("CATENAME")
            public String cateName;
            @b("CATENUM")
            public String cateNum;
            private static final long serialVersionUID = 0xE839ECAB507FB376L;

        }

        @b("CATEDEPTH")
        public String cateDepth;
        @b("CATELIST")
        public ArrayList cateList;
        @b("CATESELCODE")
        public String cateSelCode;
        @b("CATESELNUM")
        public String cateSelNum;
        private static final long serialVersionUID = 0x5457CF0E18308207L;

    }

    @b("response")
    public response response;
    private static final long serialVersionUID = 0xF2D6099683061586L;

    public DjPopularListCateBaseRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

