package com.melon.ui.comment;

import android.content.Context;
import android.content.res.Resources;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.melon.ui.i3;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/ui/comment/CommentAttachPagerViewModel;", "Lcom/melon/ui/i3;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentAttachPagerViewModel extends i3 {
    public final Context e;

    @Inject
    public CommentAttachPagerViewModel(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.e = context0;
    }

    @Override  // com.melon.ui.i3
    public final List c() {
        Resources resources0 = this.e.getResources();
        if(resources0 != null) {
            String[] arr_s = resources0.getStringArray(0x7F030050);  // array:subtabs_detailattach
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

