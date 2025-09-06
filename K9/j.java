package k9;

import Q8.a;
import Q8.d;
import Q8.g;
import Q8.h;
import android.os.Handler;
import android.os.Looper;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import java.util.List;

public abstract class j {
    public static final int a;

    static {
        LogU.create("OfflineServiceManager", true, Category.None);
    }

    public static int a() {
        byte[] arr_b = i.a();
        if(arr_b != null) {
            try {
                int v = MelonCryptoManager.getProductState(arr_b);
                switch(v) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        return 2;
                    }
                    default: {
                        return v != 3 && v != 4 && v != 5 ? 1 : 2;
                    }
                }
            }
            catch(Exception unused_ex) {
            }
        }
        return 1;
    }

    public static boolean b() {
        return !NetUtils.isConnected() && 1 != j.a();
    }

    public static boolean c() {
        return j.a() != 1;
    }

    public static void d() {
        g g0 = d.a;
        synchronized(g0) {
            LogU.i("PremiumDownloadManager", "releaseResource()");
            g0.d();
            Handler handler0 = g0.c;
            if(handler0 != null) {
                handler0.removeCallbacksAndMessages(null);
                g0.c = null;
            }
            Looper looper0 = g0.b;
            if(looper0 != null) {
                looper0.quit();
                g0.b = null;
            }
            Q8.j j0 = g0.e;
            if(j0 != null) {
                LogU.i("PremiumDownloader", "releaseResource()");
                a a0 = j0.d;
                if(a0 != null) {
                    a0.b = true;
                    j0.d = null;
                }
                Handler handler1 = j0.b;
                if(handler1 != null) {
                    handler1.removeCallbacksAndMessages(null);
                    j0.b = null;
                }
                Looper looper1 = j0.a;
                if(looper1 != null) {
                    looper1.quit();
                    j0.a = null;
                }
                j0.e = null;
                g0.e = null;
            }
        }
    }

    public static void e() {
        g g0 = d.a;
        g0.getClass();
        LogU.i("PremiumDownloadManager", "removeMusicType()");
        h h0 = g0.a;
        synchronized(h0) {
            for(int v1 = h0.a.size() - 1; v1 >= 0; --v1) {
                h0.a.remove(v1);
            }
        }
        a a0 = g0.e == null ? null : g0.e.d;
        if(a0 != null) {
            a0.b = true;
        }
    }

    // 去混淆评级： 低(20)
    public static void f(List list0) {
        if(list0 != null && !list0.isEmpty() && j.a() == 5) {
            d.a.getClass();
            d.a.g.clear();
            d.a.c(list0);
        }
    }
}

