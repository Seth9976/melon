package pc;

import android.content.Context;
import androidx.appcompat.app.o;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.playlist.add.DefaultMixUpRequestInfo;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class n1 extends w1 {
    public final List c;
    public final StatsElementsBase d;
    public final boolean e;
    public boolean f;

    public n1(List list0, StatsElementsBase statsElementsBase0, boolean z) {
        q.g(list0, "seedPlayableList");
        super();
        this.c = list0;
        this.d = statsElementsBase0;
        this.e = z;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n1 && q.b(this.c, ((n1)object0).c) && q.b(this.d, ((n1)object0).d) && this.e == ((n1)object0).e;
    }

    @Override  // pc.w1
    public final Object h(String s, String s1, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO().plus(this.a), new m1(this, s1, null), continuation0);
    }

    @Override
    public final int hashCode() {
        int v = this.c.hashCode();
        return this.d == null ? Boolean.hashCode(this.e) + v * 961 : Boolean.hashCode(this.e) + (v * 0x1F + this.d.hashCode()) * 0x1F;
    }

    @Override  // pc.w1
    public final Object j(d1 d10, Context context0, String s, Continuation continuation0) {
        String s1 = this.f ? "곡 믹스업" : "복수곡 믹스업";
        q.d(s1);
        if(d10 instanceof c1) {
            String s2 = ((c1)d10).b;
            String s3 = ((c1)d10).a;
            if(s3 != null && s3.length() != 0 && s2 != null && s2.length() != 0) {
                q.d(s3);
                q.f("", "getSongidString(...)");
                return new DefaultMixUpRequestInfo(s3, s2, "", s1);
            }
        }
        q.f("재생 중인 곡", "getString(...)");
        q.f("", "getSongidString(...)");
        return new DefaultMixUpRequestInfo(s, "재생 중인 곡", "", s1);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Songs(seedPlayableList=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", statsElement=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", needToNew=");
        return o.s(stringBuilder0, this.e, ")");
    }
}

