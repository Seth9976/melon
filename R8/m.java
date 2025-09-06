package R8;

import android.content.Context;
import android.util.SparseArray;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.downloadable.DownloadableDcfController;
import com.iloen.melon.drm.embedded.EmbeddedDcfController;
import com.iloen.melon.utils.log.LogU;

public abstract class m {
    public static int a = -1;
    public static volatile int b;
    public static final SparseArray c;

    static {
        m.c = new SparseArray();
    }

    public static AbsDcfController a(Context context0, int v) {
        synchronized(m.class) {
            if(m.a == -1) {
                m.a = q.a.c() ? 1 : 0;
                v = m.a;
            }
            SparseArray sparseArray0 = m.c;
            if(sparseArray0.size() == 0) {
                String s = MelonAppBase.instance.getDeviceData().h();
                EmbeddedDcfController embeddedDcfController0 = new EmbeddedDcfController(context0);
                embeddedDcfController0.f(s);
                sparseArray0.put(0, embeddedDcfController0);
                DownloadableDcfController downloadableDcfController0 = new DownloadableDcfController(context0);
                downloadableDcfController0.f(s);
                sparseArray0.put(1, downloadableDcfController0);
                LogU.d("DcfControllerManager", "obtain() initialized embedded: " + embeddedDcfController0);
                LogU.d("DcfControllerManager", "obtain() initialized downloadable: " + downloadableDcfController0);
            }
            ++m.b;
            LogU.v("DcfControllerManager", "++DcfController refCnt:" + m.b + ", ctx:" + context0);
            return (AbsDcfController)sparseArray0.get(v);
        }
    }

    public static void b(Context context0) {
        synchronized(m.class) {
            if(m.b <= 0) {
                LogU.w("DcfControllerManager", "recycle() invalid refCnt: " + m.b);
                return;
            }
            --m.b;
            LogU.v("DcfControllerManager", "--DcfController refCnt:" + m.b + ", ctx:" + context0);
            SparseArray sparseArray0 = m.c;
            if(sparseArray0.size() > 0 && m.b == 0) {
                ((AbsDcfController)sparseArray0.get(0)).a();
                ((AbsDcfController)sparseArray0.get(1)).a();
                sparseArray0.clear();
                m.a = -1;
                LogU.i("DcfControllerManager", "DcfController Destroyed");
            }
        }
    }

    public static void c(Context context0) {
        synchronized(m.class) {
            String s = MelonAppBase.instance.getDeviceData().h();
            AbsDcfController absDcfController0 = m.a(context0, 0);
            absDcfController0.a();
            absDcfController0.f(s);
            m.b(context0);
            AbsDcfController absDcfController1 = m.a(context0, 1);
            absDcfController1.a();
            absDcfController1.f(s);
            m.b(context0);
        }
    }
}

