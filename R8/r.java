package R8;

import T8.a;
import android.os.Build;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.DateUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.EnvironmentUtils;
import java.io.File;
import va.e;

public final class r {
    public int a;
    public static final int b;

    static {
    }

    public static String a(String s) {
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        int v = s.length();
        if(v == 10) {
            LogU.d("DrmHelper", "getDrmClientId() exactly : " + s);
            return s;
        }
        if(v > 10) {
            String s1 = s.substring(v - 10, v);
            Z.w("getDrmClientId() exceed : ", s1, "DrmHelper");
            return s1;
        }
        String s2 = StringUtils.lpad(s, 10, "0");
        Z.w("getDrmClientId() less : ", s2, "DrmHelper");
        return s2;
    }

    public final void b() {
        if(this.a == -1) {
            if("LGM-X600K".equals(Build.MODEL) || "LGM-X600L".equals(Build.MODEL)) {
                this.a = 1;
                LogU.i("DrmHelper", "initDeviceDrmType() LGM-X600K/L Downloadable");
                return;
            }
            try {
                String s = MelonAppBase.instance.getDeviceData().h();
                a.a.c(s);
                if(a.a.a) {
                    this.a = 0;
                    LogU.i("DrmHelper", "initDeviceDrmType() Embedded");
                    return;
                }
            }
            catch(Exception exception0) {
                Z.v(exception0, new StringBuilder("initDeviceDrmType() "), "DrmHelper");
            }
            this.a = 1;
            LogU.i("DrmHelper", "initDeviceDrmType() Downloadble");
        }
    }

    public final boolean c() {
        return this.a == 1;
    }

    public static void d(int v, String s, String s1) {
        String s4;
        if(v >= 1 && 3 >= v && !TextUtils.isEmpty(s)) {
            String s2 = MelonAppBase.instance.getDeviceData().h();
            if(TextUtils.isEmpty(s2)) {
                s2 = "0000";
            }
            else if(s2.length() > 6) {
                s2 = s2.substring(6);
            }
            String s3 = EnvironmentUtils.getEnvironmentInfo(MelonAppBase.instance.getContext(), new int[]{1004, 1001, 1002, 1003, 1005});
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(s3);
            stringBuilder0.append("DRM Value: ");
            stringBuilder0.append(s2);
            stringBuilder0.append("\r\nAction Type: ");
            if(v == 1) {
                s4 = "Playback";
            }
            else {
                s4 = v == 2 ? "Auto Update" : "All Update";
            }
            stringBuilder0.append(s4);
            stringBuilder0.append("\r\nFile Name: ");
            stringBuilder0.append(s);
            stringBuilder0.append("\r\n");
            File file0 = new File(s);
            if(file0.exists() && file0.isFile()) {
                stringBuilder0.append("File Date: ");
                stringBuilder0.append(DateUtils.convertDateFormat(file0.lastModified()));
                stringBuilder0.append("\r\n");
            }
            if(s1 != null) {
                e.g(stringBuilder0, "Message: ", s1, "\r\n");
            }
            Reporter.createReporter(Type.DRM, LogLevel.ERROR).setMessage(stringBuilder0.toString()).report();
        }
    }
}

