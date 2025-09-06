package i.n.i.b.a.s.e;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;

public final class x3 {
    public final CronetEngine a;
    public final int b;

    public x3(Context context0) {
        this(context0, 0);
    }

    public x3(Context context0, int v) {
        ArrayList arrayList0 = new ArrayList(CronetProvider.getAllProviders(context0));
        for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
            if(!((CronetProvider)arrayList0.get(v1)).isEnabled() || "Fallback-Cronet-Provider".equals(((CronetProvider)arrayList0.get(v1)).getName())) {
                arrayList0.remove(v1);
            }
        }
        qd qd0 = new qd();
        Collections.sort(arrayList0, qd0);
        CronetEngine cronetEngine0 = null;
        int v2 = 4;
        for(int v3 = 0; v3 < arrayList0.size() && cronetEngine0 == null; ++v3) {
            String s = ((CronetProvider)arrayList0.get(v3)).getName();
            try {
                cronetEngine0 = ((CronetProvider)arrayList0.get(v3)).createBuilder().build();
                if("App-Packaged-Cronet-Provider".equals(s)) {
                    v2 = 0;
                }
                else {
                    v2 = qd0.a == null || !qd0.a.equals(s) ? 2 : 1;
                }
                Log.d("CronetEngineWrapper", "CronetEngine built using " + s);
            }
            catch(SecurityException unused_ex) {
                Log.w("CronetEngineWrapper", "Failed to build CronetEngine. Please check if current process has android.permission.ACCESS_NETWORK_STATE.");
            }
            catch(UnsatisfiedLinkError unused_ex) {
                Log.w("CronetEngineWrapper", "Failed to link Cronet binaries. Please check if native Cronet binaries are bundled into your app.");
            }
        }
        if(cronetEngine0 == null) {
            Log.w("CronetEngineWrapper", "Cronet not available. Using fallback provider.");
        }
        this.a = cronetEngine0;
        this.b = v2;
    }
}

