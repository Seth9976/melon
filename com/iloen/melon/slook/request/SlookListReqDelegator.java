package com.iloen.melon.slook.request;

import android.content.Context;
import android.database.Cursor;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes;
import com.iloen.melon.net.v4x.response.DjThemeListPlylstForEdgeRes;
import com.iloen.melon.net.v4x.response.DjTodayListForEdgeRes;
import com.iloen.melon.net.v5x.response.ChartHitsEdgeSongChartListRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.SamsungEdgeUtils;

public class SlookListReqDelegator {
    public interface DelegateEventListener {
        void onFailed();

        void onSuccess(HttpResponse arg1);
    }

    public final Context a;

    public SlookListReqDelegator(Context context0) {
        this.a = context0;
    }

    public static HttpResponse a(Context context0, ReqDelegateBase reqDelegateBase0) {
        Cursor cursor0 = a.f(context0, reqDelegateBase0.getCacheKey());
        HttpResponse httpResponse0 = null;
        if(cursor0 == null) {
            LogU.w("SlookListReqDelegator", "fetchReqCache() invalid cursor");
            return null;
        }
        if(reqDelegateBase0 instanceof DjTodayReqDelegate) {
            httpResponse0 = (HttpResponse)a.d(cursor0, DjTodayListForEdgeRes.class);
            if(httpResponse0 == null) {
                LogU.d("SlookListReqDelegator", "fetchReqCache() DjTodayListForEdgeRes load Fail!");
            }
            else {
                LogU.d("SlookListReqDelegator", "fetchReqCache() DjTodayListForEdgeRes load Success!");
            }
        }
        else if(reqDelegateBase0 instanceof EdgeDailySongChartReqDelegate) {
            httpResponse0 = (HttpResponse)a.d(cursor0, ChartHitsEdgeSongChartListRes.class);
            if(httpResponse0 == null) {
                LogU.d("SlookListReqDelegator", "fetchReqCache() EdgeDailySongChartReqDelegate load Fail!");
            }
            else {
                LogU.d("SlookListReqDelegator", "fetchReqCache() EdgeDailySongChartReqDelegate load Success!");
            }
        }
        else if(reqDelegateBase0 instanceof DjPopularListReqDelegate) {
            httpResponse0 = (HttpResponse)a.d(cursor0, DjPopularListPlylstForEdgeRes.class);
            if(httpResponse0 == null) {
                LogU.d("SlookListReqDelegator", "fetchReqCache() DjPopularListPlylstForEdgeRes load Fail!");
            }
            else {
                LogU.d("SlookListReqDelegator", "fetchReqCache() DjPopularListPlylstForEdgeRes load Success!");
            }
        }
        else if(reqDelegateBase0 instanceof ThemeJenreListReqDelegate) {
            httpResponse0 = (HttpResponse)a.d(cursor0, DjThemeListPlylstForEdgeRes.class);
            if(httpResponse0 == null) {
                LogU.d("SlookListReqDelegator", "fetchReqCache() DjThemeListPlylstForEdgeRes load Fail!");
            }
            else {
                LogU.d("SlookListReqDelegator", "fetchReqCache() DjThemeListPlylstForEdgeRes load Success!");
            }
        }
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(httpResponse0 == null) {
            LogU.w("SlookListReqDelegator", "fetchReqCache() Failed to extract contents");
        }
        return httpResponse0;
    }

    public HttpResponse getCachedChartListResponse(ReqDelegateBase reqDelegateBase0) {
        return SlookListReqDelegator.a(this.a, reqDelegateBase0);
    }

    public void request(ReqDelegateBase reqDelegateBase0, DelegateEventListener slookListReqDelegator$DelegateEventListener0) {
        if(reqDelegateBase0 != null && slookListReqDelegator$DelegateEventListener0 != null) {
            Context context0 = this.a;
            SamsungEdgeUtils.checkLastReqDateAndClearCache(context0);
            String s = reqDelegateBase0.getCacheKey();
            long v = reqDelegateBase0 instanceof EdgeDailySongChartReqDelegate ? 300000L : 86400000L;
            LogU.d("SlookListReqDelegator", "request() expireTime: " + v);
            if(a.e(v, s, context0)) {
                LogU.d("SlookListReqDelegator", "request() New Request created - cacheKey: " + s);
                RequestBuilder.newInstance(reqDelegateBase0.createReq()).tag("SlookListReqDelegator").listener(new Listener() {
                    public final String a;
                    public final DelegateEventListener b;
                    public final SlookListReqDelegator c;

                    {
                        String s = s;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        DelegateEventListener slookListReqDelegator$DelegateEventListener0 = slookListReqDelegator$DelegateEventListener0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.c = slookListReqDelegator0;
                        this.a = s;
                        this.b = slookListReqDelegator$DelegateEventListener0;
                    }

                    public void onResponse(HttpResponse httpResponse0) {
                        boolean z = httpResponse0.isSuccessful();
                        DelegateEventListener slookListReqDelegator$DelegateEventListener0 = this.b;
                        if(z) {
                            a.a(this.c.a, httpResponse0, this.a);
                            slookListReqDelegator$DelegateEventListener0.onSuccess(httpResponse0);
                            return;
                        }
                        slookListReqDelegator$DelegateEventListener0.onFailed();
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((HttpResponse)object0));
                    }
                }).errorListener(new ErrorListener() {
                    public final DelegateEventListener a;

                    {
                        this.a = slookListReqDelegator$DelegateEventListener0;
                    }

                    @Override  // com.android.volley.Response$ErrorListener
                    public void onErrorResponse(VolleyError volleyError0) {
                        this.a.onFailed();
                    }
                }).request();
                return;
            }
            LogU.d("SlookListReqDelegator", "request() Cached Request Return - cacheKey: " + s);
            slookListReqDelegator$DelegateEventListener0.onSuccess(SlookListReqDelegator.a(context0, reqDelegateBase0));
        }
    }
}

