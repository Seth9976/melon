package Hf;

import P0.I;
import X0.p;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import e1.b;
import i.n.i.b.a.s.e.Hd;
import i.n.i.b.a.s.e.Md;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.q;
import we.k;
import x9.c;

public final class v implements Comparator {
    public final int a;
    public final Object b;

    public v(Md md0) {
        this.a = 4;
        super();
        ((c)md0).getClass();
        this.b = Arrays.asList(new UUID[0]);
    }

    public v(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    public v(Comparator comparator0) {
        this.a = 1;
        super();
        this.b = comparator0;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                q.d(((x)object0));
                String s = ((k)this.b).invoke(((x)object0)).toString();
                q.d(((x)object1));
                return b.r(s, ((k)this.b).invoke(((x)object1)).toString());
            }
            case 1: {
                int v1 = ((Comparator)this.b).compare(object0, object1);
                return v1 == 0 ? I.o0.compare(((p)object0).c, ((p)object1).c) : v1;
            }
            case 2: {
                int v2 = ((v)this.b).compare(object0, object1);
                return v2 == 0 ? b.r(((p)object0).g, ((p)object1).g) : v2;
            }
            case 3: {
                MaterialButtonToggleGroup materialButtonToggleGroup0 = (MaterialButtonToggleGroup)this.b;
                int v3 = Boolean.valueOf(((MaterialButton)object0).o).compareTo(Boolean.valueOf(((MaterialButton)object1).o));
                if(v3 == 0) {
                    v3 = Boolean.valueOf(((MaterialButton)object0).isPressed()).compareTo(Boolean.valueOf(((MaterialButton)object1).isPressed()));
                    return v3 == 0 ? materialButtonToggleGroup0.indexOfChild(((MaterialButton)object0)).compareTo(materialButtonToggleGroup0.indexOfChild(((MaterialButton)object1))) : v3;
                }
                return v3;
            }
            default: {
                UUID uUID0 = UUID.fromString(((Hd)object0).a);
                int v = ((List)this.b).indexOf(uUID0);
                UUID uUID1 = UUID.fromString(((Hd)object1).a);
                return v - ((List)this.b).indexOf(uUID1);
            }
        }
    }
}

