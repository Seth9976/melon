package m8;

import Bf.a;
import androidx.activity.ComponentActivity;
import com.iloen.melon.popup.FullscreenProgressDialog;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

public class o extends a {
    public FullscreenProgressDialog b;
    public final int c;

    public o(int v) {
        this.c = v;
        super();
    }

    @Override  // Bf.a
    public final String W0() {
        return "kakao";
    }

    @Override  // Bf.a
    public String Z0() {
        switch(this.c) {
            case 0: {
                return "/connect";
            }
            case 1: {
                return "/login";
            }
            default: {
                return "/sdklogin";
            }
        }
    }

    public final void r1() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new N(this, null), 3, null);
    }

    public final void s1(ComponentActivity componentActivity0) {
        q.g(componentActivity0, "activity");
        if(this.b != null && this.b.isShowing()) {
            FullscreenProgressDialog fullscreenProgressDialog0 = this.b;
            if(fullscreenProgressDialog0 != null) {
                fullscreenProgressDialog0.setText("");
            }
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new O(componentActivity0, this, null), 3, null);
    }
}

