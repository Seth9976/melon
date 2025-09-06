package R8;

import DigiCAP.SKT.DRM.DRMUCHInterface;
import DigiCAP.SKT.DRM.DrmConstants;
import DigiCAP.SKT.DRM.DrmInitException;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import b3.Z;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogU;
import java.nio.charset.StandardCharsets;

public final class v {
    public boolean a;
    public static volatile boolean b = false;

    public v() {
        this.a = false;
        try {
            int v = DRMUCHInterface.DRMUchInit();
            if(v == 0) {
                DcfLog.v("DrmUchWrapper", "init success");
                this.a = true;
                v.b = true;
                return;
            }
            LogU.w("DrmUchWrapper", "init failed retVal : " + v);
            throw new DrmInitException("DRMUchInit error returned : " + v);
        }
        catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
            DcfLog.e("DrmUchWrapper", unsatisfiedLinkError0.toString());
            throw new DrmInitException("DrmUchWrapper.init():" + unsatisfiedLinkError0);
        }
    }

    public void a() {
        synchronized(this) {
            while(!this.a) {
                this.wait();
            }
        }
    }

    public boolean b(long v) {
        synchronized(this) {
            if(v <= 0L) {
                return this.a;
            }
            long v2 = SystemClock.elapsedRealtime();
            long v3 = v + v2;
            if(v3 < v2) {
                this.a();
            }
            else {
                while(!this.a && v2 < v3) {
                    this.wait(v3 - v2);
                    v2 = SystemClock.elapsedRealtime();
                }
            }
            return this.a;
        }
    }

    public void c() {
        synchronized(this) {
            this.a = false;
        }
    }

    public boolean d() {
        synchronized(this) {
            if(this.a) {
                return false;
            }
            this.a = true;
            this.notifyAll();
            return true;
        }
    }

    public static v e(String s) {
        synchronized(v.class) {
            LogU.d("DrmUchWrapper", "obtain request from " + s);
            if(!v.b) {
                return new v();
            }
        }
        throw new DrmInitException("DrmUchWrapper Currently in use in other place");
    }

    public void f() {
        synchronized(this) {
            if(this.a) {
                try {
                    DRMUCHInterface.DRMUchDestroy();
                }
                catch(UnsatisfiedLinkError | Exception unsatisfiedLinkError0) {
                    LogU.w("DrmUchWrapper", "destroy : " + unsatisfiedLinkError0);
                }
                DcfLog.v("DrmUchWrapper", "released");
            }
            v.b = false;
        }
    }

    public static short g(int v, String s, byte[] arr_b, String s1) {
        StringBuilder stringBuilder0 = new StringBuilder("path update : ");
        Z.s(arr_b.length, "DrmUchWrapper", stringBuilder0);
        short v1 = -1;
        if(arr_b.length > DrmConstants.EMBEDDED_DRM_API_MAX_PATH) {
            DcfLog.e("DrmUchWrapper", "path length error : " + arr_b.length);
            return -1;
        }
        try {
            DcfLog.d("DrmUchWrapper", "path update {file=" + new String(arr_b, StandardCharsets.UTF_8) + ", clientIdType=MIN, clientId=" + s + ", header=" + s1 + ", headerLen=" + v + "}");
        }
        catch(Exception exception0) {
            DcfLog.e("DrmUchWrapper", "path logging error : " + exception0);
        }
        try {
            v1 = DRMUCHInterface.DRMUchUpdate(arr_b, "MIN", s, s1, v);
        }
        catch(Exception exception1) {
            DcfLog.e("DrmUchWrapper", "path fatal update error DRMUchUpdate : " + exception1);
        }
        DcfLog.d("DrmUchWrapper", "path update result : " + ((int)v1));
        return v1;
    }

    public static short h(Context context0, Uri uri0, String s, String s1, int v) {
        short v1;
        LogU.d("DrmUchWrapper", "uri update " + uri0.toString());
        try {
            DcfLog.d("DrmUchWrapper", "uri update {uri=" + uri0 + ", clientIdType=MIN, clientId=" + s + ", header=" + s1 + ", headerLen=" + v + "}");
        }
        catch(Exception exception0) {
            DcfLog.e("DrmUchWrapper", "uri logging error : " + exception0);
        }
        try {
            v1 = DRMUCHInterface.DRMUchUpdate(context0, uri0, "MIN", s, s1, v);
        }
        catch(Exception exception1) {
            DcfLog.e("DrmUchWrapper", "uri update fatal error DRMUchUpdate : " + exception1);
            v1 = -1;
        }
        DcfLog.d("DrmUchWrapper", "uri update result : " + ((int)v1));
        return v1;
    }
}

