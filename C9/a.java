package c9;

import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import kotlin.jvm.internal.q;
import va.k1;
import va.l1;
import va.m1;
import va.n1;

public abstract class a {
    public static void a(String s, String s1, n1 n10) {
        String s2;
        StringBuilder stringBuilder0 = new StringBuilder("LoginAutoRequested");
        stringBuilder0.append("+reqMemberKey:" + s);
        stringBuilder0.append("+from:" + s1);
        if(n10 instanceof m1) {
            s2 = "Success";
        }
        else if(n10 instanceof k1) {
            s2 = "Failure";
        }
        else {
            s2 = n10 instanceof l1 ? "NetworkError" : "null";
        }
        stringBuilder0.append("+result:" + s2);
        String s3 = stringBuilder0.toString();
        q.f(s3, "toString(...)");
        Reporter.createReporter(Type.LOGIN, LogLevel.INFO).setMessage(s3).report();
    }

    public static void b(String s, String s1, Boolean boolean0) {
        String s2 = "Logout" + ("+memberKey:" + s) + ("+reason:" + s1) + ("+closeKakaoSession:" + boolean0);
        q.f(s2, "toString(...)");
        Reporter.createReporter(Type.LOGIN, LogLevel.INFO).setMessage(s2).report();
    }
}

