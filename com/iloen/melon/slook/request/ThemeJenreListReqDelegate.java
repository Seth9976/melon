package com.iloen.melon.slook.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.request.DjThemeListPlylstForEdgeReq;

public class ThemeJenreListReqDelegate extends ListReqDelegateBase {
    public ThemeJenreListReqDelegate(Context context0) {
        super(context0);
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public HttpRequest createReq() {
        return new DjThemeListPlylstForEdgeReq(this.context);
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public String getCacheKeySubTag() {
        return "samsung_edge_theme_genre_chart";
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public int getChartType() {
        return 2;
    }
}

