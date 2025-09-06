package p8;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.iloen.melon.utils.log.AdIdManager.Callback;
import com.kakao.tiara.TiaraTracker;

public final class j implements Callback {
    @Override  // com.iloen.melon.utils.log.AdIdManager$Callback
    public final void onReceiveAdId(Info advertisingIdClient$Info0) {
        String s;
        if(advertisingIdClient$Info0 != null && !TextUtils.isEmpty(advertisingIdClient$Info0.getId())) {
            ApplicationInfo applicationInfo0 = q.d;
            TiaraTracker tiaraTracker0 = null;
            if(applicationInfo0 == null) {
                s = null;
            }
            else {
                Bundle bundle0 = applicationInfo0.metaData;
                s = bundle0 == null ? null : bundle0.getString("TIARA_MELON_SVC");
            }
            if(s != null) {
                tiaraTracker0 = TiaraTracker.get(s);
            }
            if(tiaraTracker0 != null) {
                tiaraTracker0.getSettings().setAdid(advertisingIdClient$Info0.getId(), advertisingIdClient$Info0.isLimitAdTrackingEnabled());
                return;
            }
            q.c().getSettings().setAdid(advertisingIdClient$Info0.getId(), advertisingIdClient$Info0.isLimitAdTrackingEnabled());
        }
    }
}

