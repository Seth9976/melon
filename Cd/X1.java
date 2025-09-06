package cd;

import androidx.compose.runtime.b0;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import we.n;

public final class x1 implements n {
    public final int a;
    public final b0 b;

    public x1(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                q.g(((q1)object1), "itemUiState");
                return this.b.getValue() + "-" + ((int)(((Integer)object0))) + "-" + ((q1)object1).a.albumId;
            }
            case 1: {
                ((Float)object0).floatValue();
                ((Float)object1).floatValue();
                m m1 = new m(((Float)object0), ((Float)object1));
                this.b.setValue(m1);
                return H.a;
            }
            case 2: {
                ((Float)object0).floatValue();
                ((Float)object1).floatValue();
                m m2 = new m(((Float)object0), ((Float)object1));
                this.b.setValue(m2);
                return H.a;
            }
            default: {
                ((Boolean)object1).getClass();
                q.g(((ShortCutItem)object0), "item");
                b0 b00 = this.b;
                Iterable iterable0 = (List)b00.getValue();
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                for(Object object2: iterable0) {
                    m m0 = (m)object2;
                    if(q.b(m0.a, ((ShortCutItem)object0))) {
                        m0 = new m(m0.a, ((Boolean)object1));
                    }
                    arrayList0.add(m0);
                }
                b00.setValue(arrayList0);
                return H.a;
            }
        }
    }
}

