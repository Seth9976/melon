package androidx.compose.foundation.gestures;

import A7.d;
import I.T;
import I.Y;
import I.e;
import I.u0;
import K.l;
import P0.a0;
import Q0.x0;
import b0.Q;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.o;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableElement;", "LP0/a0;", "LI/Y;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class DraggableElement extends a0 {
    public final Q a;
    public final boolean b;
    public final l c;
    public final boolean d;
    public final o e;
    public final o f;
    public final boolean g;

    public DraggableElement(Q q0, boolean z, l l0, boolean z1, T t0, o o0, boolean z2) {
        this.a = q0;
        this.b = z;
        this.c = l0;
        this.d = z1;
        this.e = t0;
        this.f = o0;
        this.g = z2;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new Y(e.h, this.b, this.c, u0.b);  // 初始化器: LI/S;-><init>(Lwe/k;ZLK/l;LI/u0;)V
        p0.k = this.a;
        p0.l = u0.b;
        p0.m = this.d;
        p0.n = this.e;
        p0.o = this.f;
        p0.r = this.g;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return DraggableElement.class == class0 && q.b(this.a, ((DraggableElement)object0).a) && this.b == ((DraggableElement)object0).b && q.b(this.c, ((DraggableElement)object0).c) && this.d == ((DraggableElement)object0).d && q.b(this.e, ((DraggableElement)object0).e) && q.b(this.f, ((DraggableElement)object0).f) && this.g == ((DraggableElement)object0).g;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = d.e((u0.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.b);
        return this.c == null ? Boolean.hashCode(this.g) + (this.f.hashCode() + (this.e.hashCode() + d.e(v * 0x1F, 0x1F, this.d)) * 0x1F) * 0x1F : Boolean.hashCode(this.g) + (this.f.hashCode() + (this.e.hashCode() + d.e((v + this.c.hashCode()) * 0x1F, 0x1F, this.d)) * 0x1F) * 0x1F;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "draggable";
        x00.c.b(u0.b, "orientation");
        x00.c.b(Boolean.valueOf(this.b), "enabled");
        x00.c.b(Boolean.valueOf(this.g), "reverseDirection");
        x00.c.b(this.c, "interactionSource");
        x00.c.b(Boolean.valueOf(this.d), "startDragImmediately");
        x00.c.b(this.e, "onDragStarted");
        x00.c.b(this.f, "onDragStopped");
        x00.c.b(this.a, "state");
    }

    @Override  // P0.a0
    public final void update(p p0) {
        boolean z2;
        boolean z;
        e e0 = e.h;
        u0 u00 = u0.b;
        Q q0 = this.a;
        if(q.b(((Y)p0).k, q0)) {
            z = false;
        }
        else {
            ((Y)p0).k = q0;
            z = true;
        }
        if(((Y)p0).l != u00) {
            ((Y)p0).l = u00;
            z = true;
        }
        boolean z1 = this.g;
        if(((Y)p0).r == z1) {
            z2 = z;
        }
        else {
            ((Y)p0).r = z1;
            z2 = true;
        }
        ((Y)p0).n = this.e;
        ((Y)p0).o = this.f;
        ((Y)p0).m = this.d;
        ((Y)p0).x0(e0, this.b, this.c, u00, z2);
    }
}

