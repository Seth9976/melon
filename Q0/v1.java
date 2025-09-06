package Q0;

import P0.F0;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.compose.runtime.s;
import androidx.compose.runtime.v;
import androidx.compose.ui.platform.AbstractComposeView;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import m0.b;
import me.i;
import p0.m;

public abstract class v1 {
    public static final ViewGroup.LayoutParams a;

    static {
        v1.a = new ViewGroup.LayoutParams(-2, -2);
    }

    public static final u1 a(AbstractComposeView abstractComposeView0, s s0, b b0) {
        u u0;
        u1 u10 = null;
        if(r0.a.compareAndSet(false, true)) {
            Channel channel0 = ChannelKt.Channel$default(1, null, null, 6, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(((i)Z.l.getValue())), null, null, new q0(channel0, null), 3, null);
            B0.b b1 = new B0.b(channel0, 18);
            synchronized(m.b) {
                m.h = p.z0(b1, ((Collection)m.h));
            }
            m.a();
        }
        if(abstractComposeView0.getChildCount() > 0) {
            View view0 = abstractComposeView0.getChildAt(0);
            u0 = view0 instanceof u ? ((u)view0) : null;
        }
        else {
            abstractComposeView0.removeAllViews();
            u0 = null;
        }
        if(u0 == null) {
            u0 = new u(abstractComposeView0.getContext(), s0.h());
            abstractComposeView0.addView(u0, v1.a);
        }
        Object object0 = u0.getTag(0x7F0A0DF4);  // id:wrapped_composition_tag
        if(object0 instanceof u1) {
            u10 = (u1)object0;
        }
        if(u10 == null) {
            u10 = new u1(u0, new v(s0, new F0(u0.getRoot())));  // 初始化器: LDf/u;-><init>(Ljava/lang/Object;)V
            u0.setTag(0x7F0A0DF4, u10);  // id:wrapped_composition_tag
        }
        u10.b(b0);
        if(!q.b(u0.getCoroutineContext(), s0.h())) {
            u0.setCoroutineContext(s0.h());
        }
        return u10;
    }
}

