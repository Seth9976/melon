package p9;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.push.dto.RegDTO;
import com.iloen.melon.push.fcm.FcmHelper;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import e1.u;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;

public final class a {
    public static final RegDTO a;

    static {
        a.a = new RegDTO(null, null, null, null, null, null, null, null, 0xFF, null);
    }

    public static void a(Context context0, int v, String s) {
        q.g(context0, "context");
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("FcmManager", "register() callFrom:" + v);
        String s1 = u.v(((e0)o.a()).j());
        if(TextUtils.isEmpty(s1) || "0".equals(s1)) {
            s1 = "";
        }
        String s2 = AppUtils.getVersionName(context0);
        if(TextUtils.isEmpty(s2)) {
            s2 = "unKnown";
        }
        RegDTO regDTO0 = a.a;
        regDTO0.setMemberKey(s1);
        regDTO0.setAppVer(s2);
        String s3 = "N";
        regDTO0.setPushNotifyYn((MelonSettingInfo.getUsePushAlert() ? "Y" : "N"));
        regDTO0.setMannerModeYn((MelonSettingInfo.getPushAlertMannerMode() ? "Y" : "N"));
        if(MelonSettingInfo.getUseMarketingPushAlert()) {
            s3 = "Y";
        }
        regDTO0.setMktRecvAgreeYn(s3);
        regDTO0.setPushType(s);
        regDTO0.setMannerStartTime("21:00");
        regDTO0.setMannerEndTime("08:00");
        logU$Companion0.d("FcmManager", "register() regDTO: " + regDTO0);
        FcmHelper.INSTANCE.reqRegister(context0, regDTO0, v);
    }
}

