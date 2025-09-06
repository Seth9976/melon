package F8;

import android.content.res.Resources;
import com.iloen.melon.MelonAppBase;
import k8.t;
import p8.g;

public abstract class i {
    public static void a(int v) {
        MelonAppBase.Companion.getClass();
        Resources resources0 = t.a().getContext().getResources();
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = "1000002436";
        g0.a = "페이지이동";
        g0.b = "멜론홈탭";
        g0.c = "멜론홈_뮤직";
        g0.y = "GNB";
        g0.z = "페이지이동";
        g0.F = resources0.getString(v);
        g0.a().track();
    }
}

