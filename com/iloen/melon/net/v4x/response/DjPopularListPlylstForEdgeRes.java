package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjPopularListPlylstForEdgeRes extends ResponseV4Res implements ResponseAdapter {
    public static class response extends ResponseBase {
        public static class PLYLSTLIST extends ArtistPlayListInfoBase {
            private static final long serialVersionUID = 7680260001587904491L;

        }

        @b("CATECODE")
        public String cateCode;
        @b("CATENAME")
        public String cateName;
        @b("PLYLSTLIST")
        public ArrayList plylstList;
        private static final long serialVersionUID = 0xF95DE6237EA43867L;

    }

    @b("response")
    public response response;
    private static final long serialVersionUID = -2831555021584029659L;

    public DjPopularListPlylstForEdgeRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        response djPopularListPlylstForEdgeRes$response0 = this.response;
        return djPopularListPlylstForEdgeRes$response0 != null ? djPopularListPlylstForEdgeRes$response0.plylstList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

