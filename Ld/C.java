package ld;

import android.content.res.Resources;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.i3;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import je.w;
import k8.t;
import kotlin.Metadata;
import p8.s;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lld/c;", "Lcom/melon/ui/i3;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class c extends i3 {
    public final LogU e;
    public int f;
    public int g;
    public s h;

    @Inject
    public c() {
        LogU logU0 = new LogU("NewMusicPagerViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.e = logU0;
    }

    @Override  // com.melon.ui.i3
    public final List c() {
        LogU.info$default(this.e, "makeTabInfo()", null, false, 6, null);
        MelonAppBase.Companion.getClass();
        Resources resources0 = t.a().getContext().getResources();
        if(resources0 != null) {
            String[] arr_s = resources0.getStringArray(0x7F030053);  // array:subtabs_latest
            if(arr_s != null) {
                List list0 = new ArrayList();
                ArrayList arrayList0 = new ArrayList(arr_s.length);
                int v = 0;
                for(int v1 = 0; v < arr_s.length; ++v1) {
                    String s = arr_s[v];
                    TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
                    tabInfo0.a = 2;
                    tabInfo0.b = s;
                    tabInfo0.c = 0;
                    tabInfo0.d = null;
                    tabInfo0.e = v1;
                    tabInfo0.f = 0;
                    tabInfo0.g = 0;
                    tabInfo0.h = 0;
                    tabInfo0.i = -1;
                    tabInfo0.j = -1.0f;
                    tabInfo0.k = -1.0f;
                    tabInfo0.l = -1.0f;
                    tabInfo0.m = -1.0f;
                    tabInfo0.n = 1.0f;
                    tabInfo0.o = -1;
                    arrayList0.add(tabInfo0);
                    ++v;
                }
                ((ArrayList)list0).addAll(arrayList0);
                return list0;
            }
        }
        return w.a;
    }
}

