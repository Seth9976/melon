package N4;

import android.view.ViewGroup;
import androidx.collection.f;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class W {
    public static final AutoTransition a;
    public static final ThreadLocal b;
    public static final ArrayList c;

    static {
        W.a = new AutoTransition();
        W.b = new ThreadLocal();
        W.c = new ArrayList();
    }

    public static void a(ViewGroup viewGroup0, Transition transition0) {
        ArrayList arrayList0 = W.c;
        if(!arrayList0.contains(viewGroup0) && viewGroup0.isLaidOut()) {
            arrayList0.add(viewGroup0);
            if(transition0 == null) {
                transition0 = W.a;
            }
            Transition transition1 = transition0.j();
            W.c(viewGroup0, transition1);
            viewGroup0.setTag(0x7F0A0BDF, null);  // id:transition_current_scene
            V v0 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
            v0.a = transition1;
            v0.b = viewGroup0;
            viewGroup0.addOnAttachStateChangeListener(v0);
            viewGroup0.getViewTreeObserver().addOnPreDrawListener(v0);
        }
    }

    public static f b() {
        ThreadLocal threadLocal0 = W.b;
        WeakReference weakReference0 = (WeakReference)threadLocal0.get();
        if(weakReference0 != null) {
            f f0 = (f)weakReference0.get();
            if(f0 != null) {
                return f0;
            }
        }
        f f1 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        threadLocal0.set(new WeakReference(f1));
        return f1;
    }

    public static void c(ViewGroup viewGroup0, Transition transition0) {
        ArrayList arrayList0 = (ArrayList)W.b().get(viewGroup0);
        if(arrayList0 != null && arrayList0.size() > 0) {
            for(Object object0: arrayList0) {
                ((Transition)object0).y(viewGroup0);
            }
        }
        if(transition0 != null) {
            transition0.h(viewGroup0, true);
        }
        if(viewGroup0.getTag(0x7F0A0BDF) != null) {  // id:transition_current_scene
            throw new ClassCastException();
        }
    }
}

