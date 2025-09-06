package k9;

import E9.w;
import Nb.i;
import androidx.room.H;
import b3.Z;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPremiumCacheDelete;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import m9.l;

public abstract class e {
    public static void a(PremiumContentsEntity premiumContentsEntity0) {
        e.d(premiumContentsEntity0.b, premiumContentsEntity0.c);
        FileUtils.delete((d.b + premiumContentsEntity0.j));
        FileUtils.delete((d.a + premiumContentsEntity0.l));
        FileUtils.delete((d.a + premiumContentsEntity0.k));
    }

    public static PremiumContentsEntity b(String s, String s1) {
        b.a.getClass();
        PremiumContentsEntity premiumContentsEntity0 = "1".equals(s1) ? c.b(((PremiumContentsEntity)b.a.a.get(s))) : null;
        return premiumContentsEntity0 == null ? null : premiumContentsEntity0;
    }

    public static Boolean c(String s, String s1) {
        b.a.getClass();
        LogU.d("ContentsManager", "hasItem()");
        return "1".equals(s1) ? Boolean.valueOf(b.a.a.containsKey(s)) : false;
    }

    public static void d(String s, String s1) {
        LogU.d("OfflineContentsManager", "remove()");
        c c0 = b.a;
        c0.getClass();
        LogU.d("ContentsManager", "remove()");
        if("1".equals(s1)) {
            c0.a.remove(s);
            ((Integer)w.N(((H)c0.f().a), false, true, new i(s, s1, 5))).getClass();
        }
        EventBusHelper.post(new EventPremiumCacheDelete(s1));
    }

    public static void e(String s, List list0) {
        LogU.d("OfflineContentsManager", "removeList()");
        c c0 = b.a;
        c0.getClass();
        LogU.d("ContentsManager", "removeList()");
        if("1".equals(s)) {
            HashMap hashMap0 = c0.a;
            Objects.requireNonNull(hashMap0);
            list0.forEach(new a(hashMap0, 0));
        }
        o9.b b0 = c0.f();
        w.N(((H)b0.a), false, true, new com.iloen.melon.player.playlist.mixup.composables.c(b0, list0, s, 26));
        EventBusHelper.post(new EventPremiumCacheDelete(s));
    }

    public static boolean f(List list0) {
        c c0 = b.a;
        c0.getClass();
        if(list0 != null && !list0.isEmpty()) {
            o9.b b0 = c0.f();
            b0.getClass();
            int v = (int)(((Integer)w.N(((H)b0.a), false, true, new l(1, b0, list0))));
            Z.r(v, "updateList() - effectedRowCount : ", "ContentsManager");
            if(v > 0) {
                for(Object object0: list0) {
                    PremiumContentsEntity premiumContentsEntity0 = (PremiumContentsEntity)object0;
                    String s = premiumContentsEntity0.b;
                    if("1".equals(premiumContentsEntity0.c)) {
                        c0.a.put(s, premiumContentsEntity0);
                    }
                }
                return true;
            }
        }
        return false;
    }
}

