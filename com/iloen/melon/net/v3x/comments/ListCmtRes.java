package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class ListCmtRes extends CmtBaseRes {
    public static class result implements Serializable {
        public static class CMTLIST extends CmtListBase {
            private static final long serialVersionUID = 0x2252D7790776F4DBL;

        }

        public static class PAGEINFO extends PageInfoBase {
            private static final long serialVersionUID = 0x4F1B1916AE68C3EFL;

        }

        public static class PAGINGINFO extends PagingInfoBase {
            private static final long serialVersionUID = 0x4F99BEF408434D51L;

        }

        public static class TOPLIST extends CmtListBase {
            private static final long serialVersionUID = 0x2654305F25BEC30EL;

        }

        @b("cmtList")
        public ArrayList cmtlist;
        @b("pageInfo")
        public PAGEINFO pageinfo;
        @b("pagingInfo")
        public PAGINGINFO paginginfo;
        private static final long serialVersionUID = 0x439AEE3459161927L;
        @b("topList")
        public ArrayList toplist;

        public result() {
            this.pageinfo = null;
            this.paginginfo = null;
            this.cmtlist = null;
            this.toplist = null;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x572A678F221B4532L;

    public ListCmtRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

