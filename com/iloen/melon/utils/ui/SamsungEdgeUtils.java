package com.iloen.melon.utils.ui;

import android.content.Context;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.slook.request.DjPopularListReqDelegate;
import com.iloen.melon.slook.request.DjTodayReqDelegate;
import com.iloen.melon.slook.request.EdgeDailySongChartReqDelegate;
import com.iloen.melon.slook.request.ThemeJenreListReqDelegate;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;

public class SamsungEdgeUtils {
    public static void checkLastReqDateAndClearCache(Context context0) {
        String s = MelonPrefs.getInstance().getString("SamsungEdgeReqLastTime", "");
        LogU.d("SamsungEdgeUtils", "checkLastReqDateAndClearCache() - latestDate : " + s + ", currentDate : " + "20250906");
        if(!s.equals("20250906")) {
            a.c(context0, new DjTodayReqDelegate(context0).getCacheKey(), true);
            a.c(context0, new EdgeDailySongChartReqDelegate(context0).getCacheKey(), true);
            a.c(context0, new DjPopularListReqDelegate(context0).getCacheKey(), true);
            a.c(context0, new ThemeJenreListReqDelegate(context0).getCacheKey(), true);
            MelonPrefs.getInstance().setString("SamsungEdgeReqLastTime", "20250906");
            LogU.d("SamsungEdgeUtils", "checkLastReqDateAndClearCache() - All cache cleared.");
        }
    }

    public static void clearResponseCache(Context context0) {
        LogU.d("SamsungEdgeUtils", "clearResponseCache()");
        MelonPrefs.getInstance().setString("SamsungEdgeReqLastTime", "");
        SamsungEdgeUtils.checkLastReqDateAndClearCache(context0);
    }

    public static String convertChartModeToClickLogArea(int v) {
        if(v == 0) {
            return "R01";
        }
        return v == 1 ? "S04" : "D09";
    }

    public static int getChartMode() {
        return MelonPrefs.getInstance().getInt("SamsungEdgeChartMode", 0);
    }

    public static void setChartMode(int v) {
        MelonPrefs.getInstance().setInt("SamsungEdgeChartMode", v);
    }
}

