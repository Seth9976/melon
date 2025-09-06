package Ub;

import Cb.i;
import L8.s;
import L8.t;
import M8.a;
import M8.f;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.DevLog;
import com.melon.playback.manager.DlnaHelper;
import e.k;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;

public final class o implements t {
    public final DlnaHelper a;

    public o(DlnaHelper dlnaHelper0) {
        this.a = dlnaHelper0;
    }

    public final void a(String s, Exception exception0) {
        String s1;
        q.g(exception0, "error");
        q.g(s, "message");
        Reporter reportService$Reporter0 = Reporter.createReporter(Type.REMOTE, LogLevel.ERROR);
        StringBuilder stringBuilder0 = new StringBuilder();
        if(MelonSettingInfo.isUseErrorReport()) {
            DlnaHelper dlnaHelper0 = this.a;
            a a0 = dlnaHelper0.i();
            if(a0 == null) {
                s1 = "Not found selected device";
            }
            else {
                StringBuilder stringBuilder1 = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Device :: " + a0.a.l + " [" + a0.a.n + "]");
                i.m(stringBuilder2);
                stringBuilder2.append("Device description :: Start");
                i.m(stringBuilder2);
                stringBuilder2.append(a0.a.i);
                i.m(stringBuilder2);
                stringBuilder2.append("Device Spec :: End");
                i.m(stringBuilder2);
                stringBuilder2.append("AvTransport description :: Start");
                i.m(stringBuilder2);
                stringBuilder2.append(a0.b.g);
                i.m(stringBuilder2);
                stringBuilder2.append("AvTransport description :: End");
                stringBuilder1.append(stringBuilder2.toString());
                i.m(stringBuilder1);
                s s2 = dlnaHelper0.i;
                List list0 = s2 == null ? w.a : s2.b;
                int v = 0;
                for(Object object0: list0) {
                    if(v >= 0) {
                        stringBuilder1.append("[" + v + "] " + ((f)object0));
                        i.m(stringBuilder1);
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
                s1 = stringBuilder1.toString();
            }
            stringBuilder0.append(s1);
            i.m(stringBuilder0);
        }
        stringBuilder0.append("message :: " + s);
        i.m(stringBuilder0);
        stringBuilder0.append("Error[" + i.o(exception0) + "] :: " + exception0.getMessage());
        reportService$Reporter0.setMessage("Remote Error Info[v0]\n" + stringBuilder0.toString()).report();
        DevLog devLog0 = DevLog.Companion.get("Dlna");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Error message: " + s);
        i.m(stringBuilder3);
        stringBuilder3.append(i.o(exception0) + ": " + exception0.getMessage());
        devLog0.put(stringBuilder3.toString());
    }
}

