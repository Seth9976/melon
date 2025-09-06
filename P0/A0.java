package P0;

import Q0.x0;
import Sf.k;
import java.lang.reflect.Field;
import java.util.List;
import je.n;
import kotlin.jvm.internal.I;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.c;
import r0.o;
import r0.p;

public abstract class a0 implements o {
    public static final int $stable;
    @Nullable
    private x0 _inspectorValues;

    public final x0 c() {
        x0 x00 = this._inspectorValues;
        if(x00 == null) {
            x00 = new x0();
            Class class0 = this.getClass();
            x00.a = I.a.b(class0).m();
            this.inspectableProperties(x00);
            this._inspectorValues = x00;
        }
        return x00;
    }

    public abstract p create();

    @NotNull
    public final k getInspectableElements() {
        return this.c().c;
    }

    @Nullable
    public final String getNameFallback() {
        return this.c().a;
    }

    @Nullable
    public final Object getValueOverride() {
        return this.c().b;
    }

    public void inspectableProperties(@NotNull x0 x00) {
        List list0 = n.v0(this.getClass().getDeclaredFields(), new c());  // 初始化器: Ljava/lang/Object;-><init>()V
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Field field0 = (Field)list0.get(v1);
            if(!field0.getDeclaringClass().isAssignableFrom(a0.class)) {
                try {
                    field0.setAccessible(true);
                    String s = field0.getName();
                    Object object0 = field0.get(this);
                    x00.c.b(object0, s);
                }
                catch(SecurityException | IllegalAccessException unused_ex) {
                }
            }
        }
    }

    public abstract void update(p arg1);
}

