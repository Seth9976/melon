package com.iloen.melon.slook;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import android.widget.RemoteViewsService;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes.response.PLYLSTLIST;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes.response;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes;
import com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes;
import com.iloen.melon.net.v5x.response.ChartHitsEdgeSongChartListRes.RESPONSE.HITSSONGLIST;
import com.iloen.melon.net.v5x.response.ChartHitsEdgeSongChartListRes.RESPONSE;
import com.iloen.melon.net.v5x.response.ChartHitsEdgeSongChartListRes;
import com.iloen.melon.slook.request.DjPopularListReqDelegate;
import com.iloen.melon.slook.request.EdgeDailySongChartReqDelegate;
import com.iloen.melon.slook.request.SlookListReqDelegator;
import com.iloen.melon.slook.request.ThemeJenreListReqDelegate;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.SamsungEdgeUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class CocktailPlayerRemoteService extends RemoteViewsService {
    class ParamInfo {
        public String a;
        public String b;

    }

    class SampleRemoveViewFactory implements RemoteViewsService.RemoteViewsFactory {
        public ArrayList a;
        public SlookListReqDelegator b;
        public HttpResponse[] c;

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public int getCount() {
            return this.a.size() >= 1 ? this.a.size() : 1;
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public long getItemId(int v) {
            return (long)v;
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public RemoteViews getLoadingView() {
            return null;
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public RemoteViews getViewAt(int v) {
            ParamInfo cocktailPlayerRemoteService$ParamInfo0;
            int v2;
            synchronized(this) {
                if(this.a.size() < 1) {
                    v2 = 0x7F0D0805;  // layout:samsung_edge_panel_chart_list_error
                }
                else {
                    switch(SamsungEdgeUtils.getChartMode()) {
                        case 1: 
                        case 2: {
                            v2 = 0x7F0D0807;  // layout:samsung_edge_panel_playlist_list_item
                            break;
                        }
                        default: {
                            v2 = 0x7F0D0806;  // layout:samsung_edge_panel_chart_list_item
                        }
                    }
                }
                RemoteViews remoteViews0 = new RemoteViews("com.iloen.melon", v2);
                if(this.a.size() < 1) {
                    return remoteViews0;
                }
                synchronized(this) {
                    if(this.a.size() > v) {
                        cocktailPlayerRemoteService$ParamInfo0 = (ParamInfo)this.a.get(v);
                    }
                    else {
                        goto label_22;
                    }
                    goto label_26;
                }
            label_22:
                cocktailPlayerRemoteService$ParamInfo0 = null;
            label_26:
                remoteViews0.setTextViewText(0x7F0A0CA1, String.valueOf(v + 1));  // id:tv_list_no
                if(cocktailPlayerRemoteService$ParamInfo0 != null) {
                    remoteViews0.setTextViewText(0x7F0A0D34, cocktailPlayerRemoteService$ParamInfo0.a);  // id:tv_title
                    remoteViews0.setTextViewText(0x7F0A0C5E, cocktailPlayerRemoteService$ParamInfo0.b);  // id:tv_desc
                }
                Intent intent0 = new Intent();
                intent0.putExtra("chart_mode", SamsungEdgeUtils.getChartMode());
                intent0.putExtra("item_id", v);
                remoteViews0.setOnClickFillInIntent(0x7F0A05C8, intent0);  // id:item_root
                return remoteViews0;
            }
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public int getViewTypeCount() {
            return 3;
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public boolean hasStableIds() {
            return false;
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public void onCreate() {
            LogU.d("SampleRemoveViewFactory", "onCreate()");
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public void onDataSetChanged() {
            EdgeDailySongChartReqDelegate edgeDailySongChartReqDelegate0;
            LogU.d("SampleRemoveViewFactory", "onDataSetChanged()");
            Context context0 = MelonAppBase.instance.getContext();
            synchronized(this) {
                int v1 = SamsungEdgeUtils.getChartMode();
                LogU.d("SampleRemoveViewFactory", "updateListData() - chartMode: " + v1);
                this.a.clear();
                HttpResponse[] arr_httpResponse = this.c;
                switch(v1) {
                    case 0: {
                        edgeDailySongChartReqDelegate0 = new EdgeDailySongChartReqDelegate(context0);
                        break;
                    }
                    case 1: {
                        edgeDailySongChartReqDelegate0 = new DjPopularListReqDelegate(context0);
                        break;
                    }
                    case 2: {
                        edgeDailySongChartReqDelegate0 = new ThemeJenreListReqDelegate(context0);
                        break;
                    }
                    default: {
                        edgeDailySongChartReqDelegate0 = null;
                    }
                }
                arr_httpResponse[v1] = this.b.getCachedChartListResponse(edgeDailySongChartReqDelegate0);
            alab1:
                switch(v1) {
                    case 0: {
                        HttpResponse httpResponse0 = this.c[0];
                        if(httpResponse0 instanceof ChartHitsEdgeSongChartListRes) {
                            RESPONSE chartHitsEdgeSongChartListRes$RESPONSE0 = ((ChartHitsEdgeSongChartListRes)httpResponse0).response;
                            if(chartHitsEdgeSongChartListRes$RESPONSE0 != null) {
                                ArrayList arrayList0 = chartHitsEdgeSongChartListRes$RESPONSE0.hitsSongList;
                                if(arrayList0 != null) {
                                    Iterator iterator0 = arrayList0.iterator();
                                    while(true) {
                                        if(!iterator0.hasNext()) {
                                            break alab1;
                                        }
                                        Object object0 = iterator0.next();
                                        ParamInfo cocktailPlayerRemoteService$ParamInfo0 = new ParamInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                                        cocktailPlayerRemoteService$ParamInfo0.a = ((HITSSONGLIST)object0).songName;
                                        cocktailPlayerRemoteService$ParamInfo0.b = ProtocolUtils.getArtistNames(((HITSSONGLIST)object0).artistList);
                                        this.a.add(cocktailPlayerRemoteService$ParamInfo0);
                                        if(this.a.size() < 20) {
                                            continue;
                                        }
                                        break alab1;
                                    }
                                }
                            }
                            return;
                        }
                        break;
                    }
                    case 1: {
                        HttpResponse httpResponse1 = this.c[1];
                        if(httpResponse1 instanceof DjPopularListPlylstForEdgeRes) {
                            response djPopularListPlylstForEdgeRes$response0 = ((DjPopularListPlylstForEdgeRes)httpResponse1).response;
                            if(djPopularListPlylstForEdgeRes$response0 != null) {
                                ArrayList arrayList1 = djPopularListPlylstForEdgeRes$response0.plylstList;
                                if(arrayList1 != null) {
                                    for(Object object1: arrayList1) {
                                        ParamInfo cocktailPlayerRemoteService$ParamInfo1 = new ParamInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                                        cocktailPlayerRemoteService$ParamInfo1.a = ((PLYLSTLIST)object1).plylsttitle;
                                        cocktailPlayerRemoteService$ParamInfo1.b = ((PLYLSTLIST)object1).ownernickname;
                                        this.a.add(cocktailPlayerRemoteService$ParamInfo1);
                                    }
                                    break;
                                }
                            }
                            return;
                        }
                        break;
                    }
                    case 2: {
                        HttpResponse httpResponse2 = this.c[2];
                        if(httpResponse2 instanceof DjThemeListPlylstForEdgeRes) {
                            com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes.response djThemeListPlylstForEdgeRes$response0 = ((DjThemeListPlylstForEdgeRes)httpResponse2).response;
                            if(djThemeListPlylstForEdgeRes$response0 != null) {
                                ArrayList arrayList2 = djThemeListPlylstForEdgeRes$response0.plylstList;
                                if(arrayList2 != null) {
                                    for(Object object2: arrayList2) {
                                        ParamInfo cocktailPlayerRemoteService$ParamInfo2 = new ParamInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                                        cocktailPlayerRemoteService$ParamInfo2.a = ((com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes.response.PLYLSTLIST)object2).plylsttitle;
                                        cocktailPlayerRemoteService$ParamInfo2.b = ((com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes.response.PLYLSTLIST)object2).ownernickname;
                                        this.a.add(cocktailPlayerRemoteService$ParamInfo2);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
        public void onDestroy() {
            LogU.d("SampleRemoveViewFactory", "onDestroy()");
        }
    }

    @Override  // android.widget.RemoteViewsService
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent0) {
        RemoteViewsService.RemoteViewsFactory remoteViewsService$RemoteViewsFactory0 = new SampleRemoveViewFactory();  // 初始化器: Ljava/lang/Object;-><init>()V
        remoteViewsService$RemoteViewsFactory0.a = new ArrayList();
        remoteViewsService$RemoteViewsFactory0.b = new SlookListReqDelegator(MelonAppBase.instance.getContext());
        remoteViewsService$RemoteViewsFactory0.c = new HttpResponse[3];
        return remoteViewsService$RemoteViewsFactory0;
    }
}

