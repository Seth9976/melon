package T8;

import DigiCAP.SKT.DRM.DRMInterface;
import DigiCAP.SKT.DRM.DrmConstants;
import R8.r;
import b3.Z;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogU;
import u5.g;
import x5.i;

public final class b implements i {
    public boolean a;

    public b(boolean z) {
        this.a = z;
        super();
    }

    public short a(short v) {
        if(!this.a) {
            LogU.e("EmbeddedDrmWrapper", "close() failed lib not initialized");
            return -1;
        }
        return DRMInterface.DRMClose(v);
    }

    @Override  // x5.i
    public boolean b() {
        return this.a;
    }

    public void c(String s) {
        LogU.v("EmbeddedDrmWrapper", "initialize() start");
        synchronized(b.class) {
            if(!this.a) {
                try {
                    if(DRMInterface.DRMInit() == 0) {
                        LogU.v("EmbeddedDrmWrapper", "initialize() DRMInterface.DRMInit() success");
                        int v1 = DRMInterface.DRMIsEmbeddedDRM();
                        if(v1 != 1 && v1 != 2) {
                            DcfLog.e("EmbeddedDrmWrapper", "initialize() NOT isEmbeddedDRM");
                        }
                        else {
                            this.a = true;
                            DRMInterface.DRMSetClientID(r.a(s));
                            if(v1 == 1) {
                                LogU.v("EmbeddedDrmWrapper", "initialize() old library initialized with clientID : ");
                            }
                            else {
                                LogU.v("EmbeddedDrmWrapper", "initialize() new library initialized with clientID : ");
                            }
                        }
                    }
                    else {
                        LogU.v("EmbeddedDrmWrapper", "initialize() failed to DRMInterface.DRMInit()");
                    }
                    goto label_22;
                }
                catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                }
                DcfLog.e("EmbeddedDrmWrapper", "initialize failed - " + unsatisfiedLinkError0);
            }
        }
    label_22:
        LogU.v("EmbeddedDrmWrapper", "initialize() finish");
    }

    @Override  // x5.i
    public boolean d(g g0) {
        return this.a;
    }

    public short e(byte[] arr_b) {
        if(!this.a) {
            LogU.e("EmbeddedDrmWrapper", "filePath open failed lib not initialized");
            return -1;
        }
        StringBuilder stringBuilder0 = new StringBuilder("filePath open length : ");
        Z.s(arr_b.length, "EmbeddedDrmWrapper", stringBuilder0);
        if(arr_b.length > DrmConstants.EMBEDDED_DRM_API_MAX_PATH) {
            DcfLog.e("EmbeddedDrmWrapper", "filePath open failed length : " + arr_b.length);
            return 0xFFFFD8F1;
        }
        return DRMInterface.DRMOpenPath(arr_b, 3, 1);
    }

    public void f() {
        LogU.v("EmbeddedDrmWrapper", "release() start");
        Class class0 = b.class;
        __monitor_enter(class0);
        try {
            if(this.a) {
                try {
                    DRMInterface.DRMDestroy();
                }
                catch(UnsatisfiedLinkError | Exception unsatisfiedLinkError0) {
                    DcfLog.w("EmbeddedDrmWrapper", "release() failed : " + unsatisfiedLinkError0);
                }
                this.a = false;
            }
        }
        catch(Throwable throwable0) {
            try {
                this.a = false;
                throw throwable0;
            }
            catch(Throwable throwable1) {
            }
            __monitor_exit(class0);
            throw throwable1;
        }
        __monitor_exit(class0);
        LogU.v("EmbeddedDrmWrapper", "release() finish");
    }
}

