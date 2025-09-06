package pc;

import android.content.Context;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.playlist.add.DefaultMixUpRequestInfo;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class j1 extends w1 {
    public static final j1 c;

    static {
        j1.c = new j1();  // 初始化器: Lpc/w1;-><init>()V
    }

    @Override  // pc.w1
    public final Object h(String s, String s1, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO().plus(this.a), new i1(s1, null), continuation0);
    }

    @Override  // pc.w1
    public final Object j(d1 d10, Context context0, String s, Continuation continuation0) {
        if(d10 instanceof c1) {
            String s1 = ((c1)d10).b;
            String s2 = ((c1)d10).a;
            if(s2 != null && s2.length() != 0 && s1 != null && s1.length() != 0) {
                q.d(s2);
                q.f("플리 믹스업", "getString(...)");
                return new DefaultMixUpRequestInfo(s2, s1, "", "플리 믹스업");
            }
        }
        return new DefaultMixUpRequestInfo(s, "재생 중인 곡", "", l1.m("재생 중인 곡", "getString(...)", context0, 0x7F130F12, "getString(...)"));  // string:tiara_mixup_page_meta_type_playlist "플리 믹스업"
    }
}

