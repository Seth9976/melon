package k3;

import V3.o;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.PlaybackComponent;
import android.media.MediaDrm.ProvisionRequest;
import android.media.MediaDrm;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import androidx.media3.common.DrmInitData.SchemeData;
import b3.h;
import e3.b;
import e3.p;
import e3.x;
import h3.a;
import i3.d;
import i3.i;
import i3.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class v implements t {
    public final UUID a;
    public final MediaDrm b;
    public int c;
    public static final d d;

    static {
        v.d = new d(11);
    }

    public v(UUID uUID0) {
        uUID0.getClass();
        b.d(!h.b.equals(uUID0), "Use C.CLEARKEY_UUID instead");
        this.a = uUID0;
        MediaDrm mediaDrm0 = new MediaDrm(uUID0);
        this.b = mediaDrm0;
        this.c = 1;
        if(h.d.equals(uUID0) && "ASUS_Z00AD".equals(x.d)) {
            mediaDrm0.setPropertyString("securityLevel", "L3");
        }
    }

    @Override  // k3.t
    public final void a(c c0) {
        com.google.android.exoplayer2.drm.d d0 = new com.google.android.exoplayer2.drm.d(1, this, c0);
        this.b.setOnEventListener(d0);
    }

    @Override  // k3.t
    public final int b() {
        return 2;
    }

    @Override  // k3.t
    public final a c(byte[] arr_b) {
        return new u(this.a, arr_b);
    }

    @Override  // k3.t
    public final void closeSession(byte[] arr_b) {
        this.b.closeSession(arr_b);
    }

    @Override  // k3.t
    public final void d(byte[] arr_b, l l0) {
        try {
            MediaDrm mediaDrm0 = this.b;
            l0.b.getClass();
            LogSessionId logSessionId0 = l0.b.a;
            if(!i.z(logSessionId0)) {
                MediaDrm.PlaybackComponent mediaDrm$PlaybackComponent0 = mediaDrm0.getPlaybackComponent(arr_b);
                mediaDrm$PlaybackComponent0.getClass();
                mediaDrm$PlaybackComponent0.setLogSessionId(logSessionId0);
            }
        }
        catch(UnsupportedOperationException unused_ex) {
            b.D("FrameworkMediaDrm", "setLogSessionId failed.");
        }
    }

    @Override  // k3.t
    public final boolean e(String s, byte[] arr_b) {
        boolean z2;
        MediaCrypto mediaCrypto0;
        boolean z1;
        UUID uUID0 = this.a;
        boolean z = uUID0.equals(h.d);
        MediaDrm mediaDrm0 = this.b;
        if(z) {
            String s1 = mediaDrm0.getPropertyString("version");
            z1 = s1.startsWith("v5.") || s1.startsWith("14.") || s1.startsWith("15.") || s1.startsWith("16.0") ? false : true;
        }
        else {
            z1 = uUID0.equals(h.c);
        }
        if(z1) {
            return mediaDrm0.requiresSecureDecoder(s, com.iloen.melon.utils.system.a.b(mediaDrm0, arr_b));
        }
        try {
            mediaCrypto0 = null;
            mediaCrypto0 = new MediaCrypto(uUID0, arr_b);
            z2 = mediaCrypto0.requiresSecureDecoderComponent(s);
        }
        catch(MediaCryptoException unused_ex) {
            if(mediaCrypto0 != null) {
                mediaCrypto0.release();
            }
            return true;
        }
        catch(Throwable throwable0) {
            if(mediaCrypto0 != null) {
                mediaCrypto0.release();
            }
            throw throwable0;
        }
        mediaCrypto0.release();
        return z2;
    }

    @Override  // k3.t
    public final r getKeyRequest(byte[] arr_b, List list0, int v, HashMap hashMap0) {
        byte[] arr_b7;
        String s2;
        SchemeData drmInitData$SchemeData0;
        UUID uUID0 = this.a;
        if(list0 == null) {
            drmInitData$SchemeData0 = null;
            arr_b7 = null;
            s2 = null;
        }
        else {
            if(h.d.equals(uUID0)) {
                if(list0.size() > 1) {
                    SchemeData drmInitData$SchemeData1 = (SchemeData)list0.get(0);
                    int v1 = 0;
                    int v2 = 0;
                    while(v1 < list0.size()) {
                        SchemeData drmInitData$SchemeData2 = (SchemeData)list0.get(v1);
                        byte[] arr_b1 = drmInitData$SchemeData2.e;
                        arr_b1.getClass();
                        if(!Objects.equals(drmInitData$SchemeData2.d, drmInitData$SchemeData1.d) || !Objects.equals(drmInitData$SchemeData2.c, drmInitData$SchemeData1.c) || V3.r.c(arr_b1) == null) {
                            goto label_29;
                        }
                        v2 += arr_b1.length;
                        ++v1;
                    }
                    byte[] arr_b2 = new byte[v2];
                    int v4 = 0;
                    for(int v3 = 0; v3 < list0.size(); ++v3) {
                        byte[] arr_b3 = ((SchemeData)list0.get(v3)).e;
                        arr_b3.getClass();
                        System.arraycopy(arr_b3, 0, arr_b2, v4, arr_b3.length);
                        v4 += arr_b3.length;
                    }
                    drmInitData$SchemeData0 = new SchemeData(drmInitData$SchemeData1.b, drmInitData$SchemeData1.c, drmInitData$SchemeData1.d, arr_b2);
                    goto label_41;
                }
            label_29:
                for(int v5 = 0; true; ++v5) {
                    if(v5 >= list0.size()) {
                        drmInitData$SchemeData0 = (SchemeData)list0.get(0);
                        break;
                    }
                    SchemeData drmInitData$SchemeData3 = (SchemeData)list0.get(v5);
                    drmInitData$SchemeData3.e.getClass();
                    o o0 = V3.r.c(drmInitData$SchemeData3.e);
                    if((o0 == null ? -1 : o0.b) == 1) {
                        drmInitData$SchemeData0 = drmInitData$SchemeData3;
                        break;
                    }
                }
            }
            else {
                drmInitData$SchemeData0 = (SchemeData)list0.get(0);
            }
        label_41:
            byte[] arr_b4 = drmInitData$SchemeData0.e;
            arr_b4.getClass();
            UUID uUID1 = h.e;
            if(uUID1.equals(uUID0)) {
                byte[] arr_b5 = V3.r.d(arr_b4, uUID0);
                if(arr_b5 != null) {
                    arr_b4 = arr_b5;
                }
                p p0 = new p(arr_b4);
                int v6 = p0.i();
                if(p0.k() != 1 || p0.k() != 1) {
                    b.u("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
                }
                else {
                    int v7 = p0.k();
                    Charset charset0 = StandardCharsets.UTF_16LE;
                    String s = p0.s(v7, charset0);
                    if(!s.contains("<LA_URL>")) {
                        int v8 = s.indexOf("</DATA>");
                        if(v8 == -1) {
                            b.D("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
                        }
                        String s1 = s.substring(0, v8) + "<LA_URL>https://x</LA_URL>" + s.substring(v8);
                        ByteBuffer byteBuffer0 = ByteBuffer.allocate(v6 + 52);
                        byteBuffer0.order(ByteOrder.LITTLE_ENDIAN);
                        byteBuffer0.putInt(v6 + 52);
                        byteBuffer0.putShort(1);
                        byteBuffer0.putShort(1);
                        byteBuffer0.putShort(((short)(s1.length() * 2)));
                        byteBuffer0.put(s1.getBytes(charset0));
                        arr_b4 = byteBuffer0.array();
                    }
                }
                arr_b4 = V3.r.a(uUID1, arr_b4);
            }
            if(uUID1.equals(uUID0) && "Amazon".equals(x.c) && ("AFTB".equals(x.d) || "AFTS".equals(x.d) || "AFTM".equals(x.d) || "AFTT".equals(x.d))) {
                byte[] arr_b6 = V3.r.d(arr_b4, uUID0);
                if(arr_b6 != null) {
                    arr_b4 = arr_b6;
                }
            }
            s2 = drmInitData$SchemeData0.d;
            arr_b7 = arr_b4;
        }
        MediaDrm.KeyRequest mediaDrm$KeyRequest0 = this.b.getKeyRequest(arr_b, arr_b7, s2, v, hashMap0);
        byte[] arr_b8 = mediaDrm$KeyRequest0.getData();
        boolean z = !h.c.equals(uUID0);
        String s3 = mediaDrm$KeyRequest0.getDefaultUrl();
        if("<LA_URL>https://x</LA_URL>".equals(s3)) {
            s3 = "";
        }
        else if("https://default.url".equals(s3)) {
            String s4 = this.b.getPropertyString("version");
            if(Objects.equals(s4, "1.2") || Objects.equals(s4, "aidl-1")) {
                s3 = "";
            }
        }
        if(TextUtils.isEmpty(s3) && drmInitData$SchemeData0 != null) {
            String s5 = drmInitData$SchemeData0.c;
            if(!TextUtils.isEmpty(s5)) {
                s3 = s5;
            }
        }
        mediaDrm$KeyRequest0.getRequestType();
        return new r(arr_b8, s3);
    }

    @Override  // k3.t
    public final s getProvisionRequest() {
        MediaDrm.ProvisionRequest mediaDrm$ProvisionRequest0 = this.b.getProvisionRequest();
        return new s(mediaDrm$ProvisionRequest0.getData(), mediaDrm$ProvisionRequest0.getDefaultUrl());
    }

    @Override  // k3.t
    public final byte[] openSession() {
        return this.b.openSession();
    }

    @Override  // k3.t
    public final byte[] provideKeyResponse(byte[] arr_b, byte[] arr_b1) {
        boolean z = !h.c.equals(this.a);
        return this.b.provideKeyResponse(arr_b, arr_b1);
    }

    @Override  // k3.t
    public final void provideProvisionResponse(byte[] arr_b) {
        this.b.provideProvisionResponse(arr_b);
    }

    @Override  // k3.t
    public final Map queryKeyStatus(byte[] arr_b) {
        return this.b.queryKeyStatus(arr_b);
    }

    @Override  // k3.t
    public final void release() {
        synchronized(this) {
            int v1 = this.c - 1;
            this.c = v1;
            if(v1 == 0) {
                this.b.release();
            }
        }
    }

    @Override  // k3.t
    public final void restoreKeys(byte[] arr_b, byte[] arr_b1) {
        this.b.restoreKeys(arr_b, arr_b1);
    }
}

