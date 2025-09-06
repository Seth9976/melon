package w4;

import Jc.X;
import Jc.e0;
import Ud.d;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsPostListener;
import com.iloen.melon.utils.system.ToastManager;
import me.h;
import y0.D;
import y0.M;
import z0.q;

public final class f implements d, SnsPostListener, h {
    public static long a(float f, float f1, float f2) {
        q q0 = z0.d.e;
        if(Float.compare(0.0f, f) > 0 || f > 360.0f || 0.0f > f1 || f1 > 1.0f || 0.0f > f2 || f2 > 1.0f) {
            D.a(("HSL (" + f + ", " + f1 + ", " + f2 + ") must be in range (0..360, 0..1, 0..1)"));
        }
        return M.b(f.b(f, f1, f2, 0), f.b(f, f1, f2, 8), f.b(f, f1, f2, 4), 1.0f, q0);
    }

    public static float b(float f, float f1, float f2, int v) {
        float f3 = (f / 30.0f + ((float)v)) % 12.0f;
        return f2 - Math.max(-1.0f, Math.min(f3 - 3.0f, Math.min(9.0f - f3, 1.0f))) * (Math.min(f2, 1.0f - f2) * f1);
    }

    @Override  // Ud.d
    public Object onChange(Object object0, boolean z) {
        kotlin.jvm.internal.q.g(((e0)object0), "state");
        return ((e0)object0) instanceof X ? X.a(((X)(((e0)object0))), false, z, 0x7FFFFF) : ((e0)object0);
    }

    @Override  // com.iloen.melon.sns.target.SnsPostListener
    public void onError(String s, Sharable sharable0, Object object0) {
        kotlin.jvm.internal.q.g(sharable0, "s");
        kotlin.jvm.internal.q.g(object0, "e");
        ToastManager.show(0x7F13106F);  // string:toast_message_twitter_send_fail "X 공유에 실패하였습니다."
    }

    @Override  // com.iloen.melon.sns.target.SnsPostListener
    public void onSuccess(String s, Sharable sharable0) {
        kotlin.jvm.internal.q.g(sharable0, "s");
    }
}

