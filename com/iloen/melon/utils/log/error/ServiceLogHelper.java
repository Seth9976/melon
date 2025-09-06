package com.iloen.melon.utils.log.error;

import android.text.TextUtils;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.MelonSettingInfo;

public class ServiceLogHelper {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public static final class Type extends Enum {
        public static final enum Type LIKE;
        public String a;
        public static final Type[] b;

        static {
            Type serviceLogHelper$Type0 = new Type("LIKE", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
            serviceLogHelper$Type0.a = "LIKE";
            Type.LIKE = serviceLogHelper$Type0;
            Type.b = new Type[]{serviceLogHelper$Type0};
        }

        public static Type valueOf(String s) {
            return (Type)Enum.valueOf(Type.class, s);
        }

        public static Type[] values() {
            return (Type[])Type.b.clone();
        }
    }

    public static void reportLog(Type serviceLogHelper$Type0, String s) {
        if(serviceLogHelper$Type0 != null && !TextUtils.isEmpty(s)) {
            StringBuilder stringBuilder0 = new StringBuilder("[");
            stringBuilder0.append(serviceLogHelper$Type0.a);
            stringBuilder0.append("] ");
            stringBuilder0.append(s);
            if(MelonSettingInfo.isUseErrorReport()) {
                Reporter.createReporter(com.iloen.melon.net.v4x.request.LogReportReq.Type.SERVICE, LogLevel.INFO).setMessage(stringBuilder0.toString()).report();
            }
        }
    }
}

