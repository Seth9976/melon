package com.iloen.melon.slook.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v5x.request.ChartHitsEdgeSongChartListReq;

public class EdgeDailySongChartReqDelegate extends ListReqDelegateBase {
    public EdgeDailySongChartReqDelegate(Context context0) {
        super(context0);
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public HttpRequest createReq() {
        return new ChartHitsEdgeSongChartListReq(this.context);
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public String getCacheKeySubTag() {
        return "samsung_edge_hits_song_chart";
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public int getChartType() {
        return 0;
    }
}

