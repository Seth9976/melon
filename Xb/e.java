package Xb;

import Vb.i;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.melon.ui.popup.b;
import kotlin.jvm.internal.q;
import ob.z;
import pd.d;
import vd.E;

public final class e implements j {
    public static final e a;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // Xb.j
    public final void a(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
    }

    @Override  // Xb.j
    public final void b(d d0, z z0) {
        q.g(d0, "playbackUi");
        q.g(z0, "playerUseCase");
        Activity activity0 = d0.getActivity();
        q.e(activity0, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        b.x(((AppCompatActivity)activity0).getSupportFragmentManager(), "안내", "안정적인 스트리밍을 위해 최적화 설정 화면으로 이동합니다.\n안내에 따라 설정해 주세요.", false, true, null, null, new i(3), null, null, E.b, 0x6E8);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof e;
    }

    @Override
    public final int hashCode() {
        return -1013018202;
    }

    @Override
    public final String toString() {
        return "IgnoredSystemOptimizationEvent";
    }
}

