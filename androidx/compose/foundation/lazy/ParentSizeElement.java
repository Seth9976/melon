package androidx.compose.foundation.lazy;

import O.J;
import P0.a0;
import Q0.x0;
import androidx.compose.runtime.b1;
import kotlin.Metadata;
import r0.p;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/ParentSizeElement;", "LP0/a0;", "LO/J;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class ParentSizeElement extends a0 {
    public final b1 a;

    public ParentSizeElement(b1 b10) {
        this.a = b10;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new J();  // 初始化器: Lr0/p;-><init>()V
        p0.a = 1.0f;
        p0.b = this.a;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof ParentSizeElement) {
                ((ParentSizeElement)object0).getClass();
                return this.a.equals(((ParentSizeElement)object0).a);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return 0x3F800000 + this.a.hashCode() * 961;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
        x00.a = "fillParentMaxWidth";
        x00.b = 1.0f;
    }

    @Override  // P0.a0
    public final void update(p p0) {
        ((J)p0).a = 1.0f;
        ((J)p0).b = this.a;
    }
}

