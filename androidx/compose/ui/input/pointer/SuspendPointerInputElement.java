package androidx.compose.ui.input.pointer;

import J0.N;
import P0.a0;
import Q0.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendPointerInputElement;", "LP0/a0;", "LJ0/N;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SuspendPointerInputElement extends a0 {
    public final Object a;
    public final Object b;
    public final PointerInputEventHandler c;

    public SuspendPointerInputElement(Object object0, Object object1, PointerInputEventHandler pointerInputEventHandler0, int v) {
        if((v & 2) != 0) {
            object1 = null;
        }
        super();
        this.a = object0;
        this.b = object1;
        this.c = pointerInputEventHandler0;
    }

    @Override  // P0.a0
    public final p create() {
        return new N(this.a, this.b, this.c);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof SuspendPointerInputElement && q.b(this.a, ((SuspendPointerInputElement)object0).a) && q.b(this.b, ((SuspendPointerInputElement)object0).b) && this.c == ((SuspendPointerInputElement)object0).c;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Object object0 = this.b;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return this.c.hashCode() + (v1 * 0x1F + v) * 961;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "pointerInput";
        x00.c.b(this.a, "key1");
        x00.c.b(this.b, "key2");
        x00.c.b(null, "keys");
        x00.c.b(this.c, "pointerInputEventHandler");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        int v = 1;
        int v1 = !q.b(((N)p0).a, this.a);
        ((N)p0).a = this.a;
        Object object0 = this.b;
        if(!q.b(((N)p0).b, object0)) {
            v1 = 1;
        }
        ((N)p0).b = object0;
        Class class0 = ((N)p0).c.getClass();
        PointerInputEventHandler pointerInputEventHandler0 = this.c;
        if(class0 == pointerInputEventHandler0.getClass()) {
            v = v1;
        }
        if(v != 0) {
            ((N)p0).o0();
        }
        ((N)p0).c = pointerInputEventHandler0;
    }
}

