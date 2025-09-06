package hd;

import X0.u;
import X0.x;
import android.content.Context;
import androidx.appcompat.app.o;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYRECENTLIST.MYGNRLIST.GNRLIST;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYRECENTLIST.MYGNRLIST;
import ie.H;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;
import we.k;

public final class z implements k {
    public final Context a;
    public final MYGNRLIST b;

    public z(Context context0, MYGNRLIST musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0) {
        this.a = context0;
        this.b = musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f1;
        q.g(((x)object0), "$this$semantics");
        q.g(this.a, "context");
        MYGNRLIST musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0 = this.b;
        q.g(musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0, "item");
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0.gnrList;
        q.f(arrayList2, "gnrList");
        float f = 0.0f;
        for(Object object1: p.K0(5, arrayList2)) {
            GNRLIST musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST$GNRLIST0 = (GNRLIST)object1;
            try {
                String s = musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST$GNRLIST0.gnrPer;
                q.f(s, "gnrPer");
                f1 = 0.0f;
                f1 = Float.parseFloat(s);
            }
            catch(Exception unused_ex) {
            }
            f += f1;
            if(f > 100.0f) {
                arrayList0.add(musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST$GNRLIST0.gnrName);
                arrayList1.add(((float)(f1 - (f - 100.0f))));
            }
            else {
                arrayList0.add(musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST$GNRLIST0.gnrName);
                arrayList1.add(f1);
            }
        }
        if(f < 100.0f) {
            arrayList0.add("기타");
            arrayList1.add(((float)(100.0f - f)));
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(musicDnaMainRes$RESPONSE$MYRECENTLIST$MYGNRLIST0.title);
        stringBuilder0.append(",");
        int v = 0;
        for(Object object2: arrayList0) {
            if(v >= 0) {
                String[] arr_s = {((String)object2), o.i(((int)((Number)arrayList1.get(v)).floatValue()), "%")};
                for(int v1 = 0; v1 < 2; ++v1) {
                    stringBuilder0.append(arr_s[v1]);
                }
                stringBuilder0.append(",");
                ++v;
                continue;
            }
            e.k.O();
            throw null;
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        u.h(((x)object0), s1);
        return H.a;
    }
}

