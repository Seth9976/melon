package Ac;

import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.v3.MediaAttachHelper.AttachPropertyData;
import com.melon.ui.K4;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import we.k;

public final class n4 implements k {
    public final int a;
    public final r4 b;

    public n4(r4 r40, int v) {
        this.a = v;
        this.b = r40;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        w w0;
        l4 l40 = null;
        r4 r40 = this.b;
        if(this.a != 0) {
            q.g(((V3)object0), "it");
            if(((V3)object0) instanceof Q3) {
                AttachPropertyData mediaAttachHelper$AttachPropertyData0 = ((Q3)(((V3)object0))).a;
                LogU.debug$default(r40.f, "deleteAttachedItem: " + mediaAttachHelper$AttachPropertyData0, null, false, 6, null);
                Object object1 = r40.getUiState().getValue();
                if(object1 instanceof l4) {
                    l40 = (l4)object1;
                }
                if(l40 == null) {
                    w0 = w.a;
                }
                else {
                    List list0 = l40.e;
                    if(list0 == null) {
                        w0 = w.a;
                    }
                    else {
                        w0 = new ArrayList();
                        for(Object object2: list0) {
                            if(!q.b(((AttachPropertyData)object2), mediaAttachHelper$AttachPropertyData0)) {
                                ((ArrayList)w0).add(object2);
                            }
                        }
                    }
                }
                r40.b.b(w0, "key_cmt_attach_contents");
                r40.updateUiState(new D(14, l40, w0));
            }
            return H.a;
        }
        q.g(((K4)object0), "it");
        l4 l41 = ((K4)object0) instanceof l4 ? ((l4)(((K4)object0))) : null;
        return l41 != null ? l4.a(l41, r40.h(), null, 30) : ((K4)object0);
    }
}

