package k9;

import E9.w;
import androidx.room.H;
import com.iloen.melon.premium.PremiumContentsEntity;
import java.util.HashMap;
import java.util.List;
import ld.j;

public abstract class b {
    public static final c a;

    static {
        c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c0.a = new HashMap();
        List list0 = (List)w.N(((H)c0.f().a), true, false, new j(9));
        if(list0 != null && !list0.isEmpty()) {
            c0.a.clear();
            for(Object object0: list0) {
                PremiumContentsEntity premiumContentsEntity0 = (PremiumContentsEntity)object0;
                if("1".equals(premiumContentsEntity0.c)) {
                    c0.a.put(premiumContentsEntity0.b, premiumContentsEntity0);
                }
            }
        }
        b.a = c0;
    }
}

