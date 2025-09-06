package Md;

import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import java.util.LinkedHashMap;

public abstract class l {
    public static final LinkedHashMap a;
    public static final LogU b;

    static {
        l.a = new LinkedHashMap();
        LogU logU0 = new LogU("TimeCacheHelper");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        l.b = logU0;
    }

    public static final void a(f f0) {
        l.a.put(f0, System.currentTimeMillis());
        Object object0 = l.a.get(f0);
        LogU.debug$default(l.b, "registerTime() - serviceType: " + f0 + ", updatedTime: " + object0, null, false, 6, null);
    }
}

