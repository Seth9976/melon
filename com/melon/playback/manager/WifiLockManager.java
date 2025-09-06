package com.melon.playback.manager;

import android.content.Context;
import android.net.wifi.WifiManager.WifiLock;
import android.net.wifi.WifiManager;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/playback/manager/WifiLockManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class WifiLockManager {
    public final LogU a;
    public final WifiManager.WifiLock b;
    public boolean c;

    public WifiLockManager(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        LogU logU0 = Companion.create$default(LogU.Companion, "WifiLockManager", false, Category.Playback, 2, null);
        this.a = logU0;
        Object object0 = context0.getApplicationContext().getSystemService("wifi");
        WifiManager wifiManager0 = object0 instanceof WifiManager ? ((WifiManager)object0) : null;
        if(this.b == null) {
            if(wifiManager0 == null) {
                LogU.warn$default(logU0, "WifiManager is null, cannot creating the WifiLock.", null, false, 6, null);
                return;
            }
            WifiManager.WifiLock wifiManager$WifiLock0 = wifiManager0.createWifiLock(3, "MelonPlayer:WifiLockManager");
            this.b = wifiManager$WifiLock0;
            q.d(wifiManager$WifiLock0);
            wifiManager$WifiLock0.setReferenceCounted(false);
        }
        this.a();
    }

    public final void a() {
        WifiManager.WifiLock wifiManager$WifiLock0 = this.b;
        if(wifiManager$WifiLock0 != null) {
            if(this.c) {
                LogU.debug$default(this.a, "WifiLock acquire.", null, false, 6, null);
                wifiManager$WifiLock0.acquire();
                return;
            }
            LogU.debug$default(this.a, "WifiLock release.", null, false, 6, null);
            wifiManager$WifiLock0.release();
            return;
        }
        LogU.debug$default(this.a, "WifiLock is null.", null, false, 6, null);
    }
}

