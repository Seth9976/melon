package com.iloen.melon.drm;

import Ba.j;
import DigiCAP.SKT.DRM.DrmInitException;
import Ma.l;
import R8.r;
import R8.v;
import android.content.Context;
import android.net.Uri;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.response.DcfExtensionExpireDateRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import k8.o;
import tg.Q;
import va.e0;

public abstract class AbsDcfController {
    public final Context a;
    public String b;

    public AbsDcfController(Context context0) {
        this.a = context0;
    }

    public abstract void a();

    public static DcfExtensionExpireDateRes b(List list0) {
        Q q0;
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        Iterator iterator0 = list0.iterator();
        while(true) {
            s = "";
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            stringBuilder0.append(((DcfFile)object0).a);
            stringBuilder0.append(",");
            stringBuilder1.append(((DcfFile)object0).b);
            stringBuilder1.append(",");
            stringBuilder2.append(((DcfFile)object0).c.getValue());
            stringBuilder2.append(",");
        }
        String s1 = stringBuilder0.length() <= 0 ? "" : l1.q(stringBuilder0, 1, 0);
        String s2 = stringBuilder1.length() <= 0 ? "" : l1.q(stringBuilder1, 1, 0);
        if(stringBuilder2.length() > 0) {
            s = l1.q(stringBuilder2, 1, 0);
        }
        j j0 = (j)((o)(((l)b.B(MelonAppBase.instance.getContext(), l.class)))).K.get();
        try {
            q0 = j0.c(s1, String.valueOf(list0.size()), s2, s, u.v(((e0)va.o.a()).j())).execute();
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
            q0 = null;
        }
        if(q0 != null) {
            return q0.b == null ? null : ((DcfExtensionExpireDateRes)q0.b);
        }
        return null;
    }

    public abstract ArrayList c(Playable arg1);

    public abstract DcfFile d(String arg1);

    public abstract LinkedList e();

    public void f(String s) {
        this.b = s;
    }

    public static boolean g(String s) {
        try {
            Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
            if(date0 != null && date0.before(new Date())) {
                return true;
            }
        }
        catch(Exception exception0) {
            LogU.e("AbsDcfController", exception0.toString());
        }
        return false;
    }

    public final DcfExtendResult h(DcfFile dcfFile0, String s) {
        DcfError dcfError1;
        int v3;
        v v2;
        String s2;
        StringBuilder stringBuilder0;
        String s1;
        v v1;
        long v;
        LogU.d("AbsDcfController", "updateDCFHeader() header = " + s + ", file: " + dcfFile0);
        DcfError dcfError0 = DcfError.c;
        try {
            v = dcfFile0.d();
            v1 = null;
            v1 = v.e(("updateDCFHeader:" + dcfFile0));
            goto label_12;
        }
        catch(DrmInitException drmInitException0) {
            v1 = null;
            goto label_51;
        }
        catch(Exception exception0) {
            v1 = null;
            goto label_55;
            try {
            label_12:
                s1 = r.a(this.b);
                stringBuilder0 = new StringBuilder("updateDcfHeader() file length = ");
                s2 = dcfFile0.c();
                v2 = v1;
                goto label_21;
            }
            catch(DrmInitException drmInitException0) {
            }
            catch(Exception exception0) {
                goto label_55;
            }
            catch(Throwable throwable0) {
                goto label_64;
            }
            goto label_51;
            try {
            label_21:
                Charset charset0 = StandardCharsets.UTF_8;
                stringBuilder0.append(s2.getBytes(charset0).length);
                LogU.d("AbsDcfController", stringBuilder0.toString());
                if(s.startsWith("<![CDATA")) {
                    String s3 = s.substring(9, s.length() - 3);
                    LogU.d("AbsDcfController", "headers = " + s3 + " = mMdn = " + s1);
                    v3 = StorageUtils.isScopedStorage() ? v.h(this.a, (dcfFile0.h == null ? Uri.EMPTY : dcfFile0.h), s1, s3, s3.length()) : v.g(s3.length(), s1, dcfFile0.c().getBytes(charset0), s3);
                }
                else {
                    v3 = StorageUtils.isScopedStorage() ? v.h(this.a, (dcfFile0.h == null ? Uri.EMPTY : dcfFile0.h), s1, s, s.length()) : v.g(s.length(), s1, dcfFile0.c().getBytes(charset0), s);
                }
                LogU.d("AbsDcfController", "updateDcfHeader() " + dcfFile0 + " | " + v3);
                File file0 = dcfFile0.f;
                if(file0 != null) {
                    file0.setLastModified(v);
                }
                if(v3 >= 0 || v3 == -2020) {
                    dcfError1 = dcfError0;
                }
                else {
                    DcfLog.i("AbsDcfController", "updateDcfHeader() failed = " + dcfFile0 + " | " + v3);
                    dcfError1 = new DcfError(v3);
                }
                goto label_67;
            }
            catch(DrmInitException drmInitException0) {
                v1 = v2;
            }
            catch(Exception exception0) {
                v1 = v2;
                goto label_55;
            }
            catch(Throwable throwable0) {
                v1 = v2;
                goto label_64;
            }
            try {
            label_51:
                dcfError1 = new DcfError(drmInitException0);
                DcfLog.d("AbsDcfController", "updateDcfHeader() DrmInitException:" + drmInitException0);
                if(v1 == null) {
                    return new DcfExtendResult(dcfFile0, dcfError1);
                }
                goto label_61;
            }
            catch(Throwable throwable0) {
                goto label_64;
            }
            return new DcfExtendResult(dcfFile0, dcfError1);
            try {
            label_55:
                dcfError1 = new DcfError(exception0);
                DcfLog.d("AbsDcfController", "updateDcfHeader() Exception:" + exception0);
                goto label_60;
            }
            catch(Throwable throwable0) {
            }
            goto label_64;
        }
        catch(Throwable throwable0) {
            goto label_64;
        }
    label_60:
        if(v1 != null) {
        label_61:
            v1.f();
            return new DcfExtendResult(dcfFile0, dcfError1);
        }
        return new DcfExtendResult(dcfFile0, dcfError1);
    label_64:
        if(v1 != null) {
            v1.f();
        }
        throw throwable0;
    label_67:
        v2.f();
        return new DcfExtendResult(dcfFile0, dcfError1);
    }
}

