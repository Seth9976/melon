package com.melon.playback.melon.analytics;

import Nb.z0;
import Ob.b;
import ac.f;
import ac.m;
import ac.w;
import android.content.Context;
import com.iloen.melon.constants.CType;
import com.iloen.melon.net.v5x.request.StreamingAnalysisReq.ParamInfo;
import com.iloen.melon.net.v5x.request.StreamingAnalysisReq;
import com.iloen.melon.task.ReportService;
import com.iloen.melon.utils.system.VolumeUtils.Companion;
import com.iloen.melon.utils.system.VolumeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/playback/melon/analytics/AnalysisAnalyticsTask;", "Lcom/melon/playback/melon/analytics/AnalyticsTask;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AnalysisAnalyticsTask extends AnalyticsTask {
    public AnalysisAnalyticsTask(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
    }

    @Override  // com.melon.playback.melon.analytics.AnalyticsTask
    public final long b(w w0, long v) {
        return AnalyticsTask.a(v);
    }

    @Override  // com.melon.playback.melon.analytics.AnalyticsTask
    public final void c(w w0, z0 z00) {
        String s;
        m m0 = w0.b;
        ParamInfo streamingAnalysisReq$ParamInfo0 = new ParamInfo();
        streamingAnalysisReq$ParamInfo0.cId = m0.b;
        streamingAnalysisReq$ParamInfo0.cType = m0.c.getValue();
        streamingAnalysisReq$ParamInfo0.menuId = m0.j;
        streamingAnalysisReq$ParamInfo0.orgMenuId = m0.k;
        streamingAnalysisReq$ParamInfo0.bitrate = m0.f;
        streamingAnalysisReq$ParamInfo0.metaType = m0.g;
        streamingAnalysisReq$ParamInfo0.loggingToken = w0.c.a;
        if(m0.m instanceof f) {
            s = "1";
        }
        else {
            s = b.b() ? "2" : "0";
        }
        streamingAnalysisReq$ParamInfo0.locPl = s;
        streamingAnalysisReq$ParamInfo0.initDate = m0.e;
        streamingAnalysisReq$ParamInfo0.freeYn = m0.i;
        streamingAnalysisReq$ParamInfo0.statsElement = m0.l;
        streamingAnalysisReq$ParamInfo0.networkType = "wifi";
        streamingAnalysisReq$ParamInfo0.currentVolume = Companion.getVolume$default(VolumeUtils.Companion, this.a, "OneSecAnalyticsTask", null, 4, null);
        ReportService.sendLogging(new StreamingAnalysisReq(this.a, streamingAnalysisReq$ParamInfo0));
    }

    // 去混淆评级： 低(30)
    @Override  // com.melon.playback.melon.analytics.AnalyticsTask
    public final boolean d(w w0) {
        return w0.b.b.length() != 0 && !w0.b.c.equals(CType.LIVE) && !w0.b.h && ((e0)o.a()).m();
    }
}

