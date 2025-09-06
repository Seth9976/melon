package p8;

import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.ResponseBase;
import e1.u;
import java.util.HashMap;
import va.e0;
import va.o;

public abstract class r {
    public static final void a(ResponseBase responseBase0, String s, String s1) {
        if(responseBase0 != null && !TextUtils.isEmpty(s)) {
            String s2 = Z.m(MelonAppBase.Companion, 0x7F130FD3, "getString(...)");  // string:tiara_pv_log_action_name "페이지보기"
            HashMap hashMap0 = q.b();
            hashMap0.put("menuid", s);
            hashMap0.put("orgmenuid", s1);
            hashMap0.put("charged", (u.u(((e0)o.a()).j()).equals("4") ? "N" : "Y"));
            if(!TextUtils.isEmpty(responseBase0.section) && !TextUtils.isEmpty(responseBase0.page)) {
                q.c().trackPage((responseBase0.section == null ? "" : responseBase0.section) + s2).section(responseBase0.section).page(responseBase0.page).customProps(hashMap0).adTrackId("2875552754074864296").track();
                return;
            }
            q.c().trackPage(s2).page(s).customProps(hashMap0).adTrackId("2875552754074864296").track();
            return;
        }
        LogU.Companion.w("MelonTiaraLogHelper", "sendPvLog() - Invalid argument");
    }
}

