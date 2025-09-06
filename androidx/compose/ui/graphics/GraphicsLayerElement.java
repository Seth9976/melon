package androidx.compose.ui.graphics;

import A7.d;
import P0.a0;
import P0.f;
import P0.j0;
import Q0.x0;
import androidx.appcompat.app.o;
import androidx.compose.foundation.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import y0.Q;
import y0.S;
import y0.U;
import y0.s;
import y0.x;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "LP0/a0;", "Ly0/S;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class GraphicsLayerElement extends a0 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final long f;
    public final Q g;
    public final boolean h;
    public final long i;
    public final long j;
    public final int k;

    public GraphicsLayerElement(float f, float f1, float f2, float f3, float f4, long v, Q q0, boolean z, long v1, long v2, int v3) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = v;
        this.g = q0;
        this.h = z;
        this.i = v1;
        this.j = v2;
        this.k = v3;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new S();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        p0.e = this.e;
        p0.f = 8.0f;
        p0.g = this.f;
        p0.h = this.g;
        p0.i = this.h;
        p0.j = this.i;
        p0.k = this.j;
        p0.l = this.k;
        p0.m = new w(p0, 27);
        return p0;
    }

    // 去混淆评级： 中等(90)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof GraphicsLayerElement && Float.compare(this.a, ((GraphicsLayerElement)object0).a) == 0 && Float.compare(this.b, ((GraphicsLayerElement)object0).b) == 0 && Float.compare(this.c, ((GraphicsLayerElement)object0).c) == 0 && Float.compare(this.d, ((GraphicsLayerElement)object0).d) == 0 && Float.compare(this.e, ((GraphicsLayerElement)object0).e) == 0 && U.a(this.f, ((GraphicsLayerElement)object0).f) && q.b(this.g, ((GraphicsLayerElement)object0).g) && this.h == ((GraphicsLayerElement)object0).h && s.d(this.i, ((GraphicsLayerElement)object0).i) && s.d(this.j, ((GraphicsLayerElement)object0).j) && this.k == ((GraphicsLayerElement)object0).k;
    }

    @Override
    public final int hashCode() {
        return this.k + d.c(d.c(d.e((this.g.hashCode() + d.c(d.a(8.0f, d.a(this.e, d.a(0.0f, d.a(0.0f, d.a(this.d, d.a(0.0f, d.a(0.0f, d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F, this.f)) * 0x1F, 961, this.h), 0x1F, this.i), 0x1F, this.j);
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "graphicsLayer";
        x00.c.b(this.a, "scaleX");
        x00.c.b(this.b, "scaleY");
        x00.c.b(this.c, "alpha");
        x00.c.b(0.0f, "translationX");
        x00.c.b(0.0f, "translationY");
        x00.c.b(this.d, "shadowElevation");
        x00.c.b(0.0f, "rotationX");
        x00.c.b(0.0f, "rotationY");
        x00.c.b(this.e, "rotationZ");
        x00.c.b(8.0f, "cameraDistance");
        U u0 = new U(this.f);
        x00.c.b(u0, "transformOrigin");
        x00.c.b(this.g, "shape");
        x00.c.b(Boolean.valueOf(this.h), "clip");
        x00.c.b(null, "renderEffect");
        s s0 = new s(this.i);
        x00.c.b(s0, "ambientShadowColor");
        s s1 = new s(this.j);
        x00.c.b(s1, "spotShadowColor");
        x x0 = new x(this.k);
        x00.c.b(x0, "compositingStrategy");
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GraphicsLayerElement(scaleX=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", scaleY=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", alpha=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", translationX=0.0, translationY=0.0, shadowElevation=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", rotationX=0.0, rotationY=0.0, rotationZ=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", cameraDistance=8.0, transformOrigin=");
        stringBuilder0.append(U.d(this.f));
        stringBuilder0.append(", shape=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", clip=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", renderEffect=null, ambientShadowColor=");
        o.x(this.i, ", spotShadowColor=", stringBuilder0);
        o.x(this.j, ", compositingStrategy=", stringBuilder0);
        stringBuilder0.append(x.a(this.k));
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((S)p0).a = this.a;
        ((S)p0).b = this.b;
        ((S)p0).c = this.c;
        ((S)p0).d = this.d;
        ((S)p0).e = this.e;
        ((S)p0).f = 8.0f;
        ((S)p0).g = this.f;
        ((S)p0).h = this.g;
        ((S)p0).i = this.h;
        ((S)p0).j = this.i;
        ((S)p0).k = this.j;
        ((S)p0).l = this.k;
        j0 j00 = f.t(((S)p0), 2).m;
        if(j00 != null) {
            j00.n1(((S)p0).m, true);
        }
    }
}

