package jd;

import android.content.Context;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import com.kakao.tiara.data.Meta.Builder;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import we.k;

public final class i2 implements FlowCollector {
    public final a0 a;
    public final k b;
    public final Context c;
    public final q2 d;

    public i2(a0 a00, k k0, Context context0, q2 q20) {
        this.a = a00;
        this.b = k0;
        this.c = context0;
        this.d = q20;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        int v = ((Number)object0).intValue();
        K0 k00 = (K0)this.a;
        if(k00.m() != v) {
            k00.n(v);
            t2 t20 = new t2(null, "스와이프", "이미지뷰어", "뷰어스와이프", new Builder().id(((a)((List)this.d.b).get(v)).a).type("이미지").build());
            this.b.invoke(t20);
        }
        return H.a;
    }
}

