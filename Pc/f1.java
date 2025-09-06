package pc;

import android.content.Context;
import com.iloen.melon.playback.playlist.add.DefaultMixUpRequestInfo;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class f1 extends w1 {
    public final ArrayList c;

    public f1(ArrayList arrayList0) {
        this.c = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof f1 && q.b(this.c, ((f1)object0).c);
    }

    @Override  // pc.w1
    public final Object h(String s, String s1, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO().plus(this.a), new e1(this, s1, null), continuation0);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override  // pc.w1
    public final Object j(d1 d10, Context context0, String s, Continuation continuation0) {
        return new DefaultMixUpRequestInfo("", "", "", "");
    }

    @Override
    public final String toString() {
        return "More(songIdList=" + this.c + ")";
    }
}

