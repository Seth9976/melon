package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaDrm.KeyRequest;
import android.media.MediaDrm.KeyStatus;
import android.media.MediaDrm.ProvisionRequest;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(23)
public final class FrameworkMediaDrm implements ExoMediaDrm {
    private static final String CENC_SCHEME_MIME_TYPE = "cenc";
    public static final Provider DEFAULT_PROVIDER = null;
    private static final String MOCK_LA_URL = "<LA_URL>https://x</LA_URL>";
    private static final String MOCK_LA_URL_VALUE = "https://x";
    private static final String TAG = "FrameworkMediaDrm";
    private static final int UTF_16_BYTES_PER_CHARACTER = 2;
    private final MediaDrm mediaDrm;
    private int referenceCount;
    private final UUID uuid;

    static {
        FrameworkMediaDrm.DEFAULT_PROVIDER = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    private FrameworkMediaDrm(UUID uUID0) {
        Assertions.checkNotNull(uUID0);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uUID0), "Use C.CLEARKEY_UUID instead");
        this.uuid = uUID0;
        MediaDrm mediaDrm0 = new MediaDrm(FrameworkMediaDrm.adjustUuid(uUID0));
        this.mediaDrm = mediaDrm0;
        this.referenceCount = 1;
        if(C.WIDEVINE_UUID.equals(uUID0) && FrameworkMediaDrm.needsForceWidevineL3Workaround()) {
            FrameworkMediaDrm.forceWidevineL3(mediaDrm0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void acquire() {
        synchronized(this) {
            Assertions.checkState(this.referenceCount > 0);
            ++this.referenceCount;
        }
    }

    private static byte[] addLaUrlAttributeIfMissing(byte[] arr_b) {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b);
        int v = parsableByteArray0.readLittleEndianInt();
        if(parsableByteArray0.readLittleEndianShort() == 1 && parsableByteArray0.readLittleEndianShort() == 1) {
            String s = parsableByteArray0.readString(parsableByteArray0.readLittleEndianShort(), Charset.forName("UTF-16LE"));
            if(s.contains("<LA_URL>")) {
                return arr_b;
            }
            int v1 = s.indexOf("</DATA>");
            if(v1 == -1) {
                Log.w("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String s1 = s.substring(0, v1) + "<LA_URL>https://x</LA_URL>" + s.substring(v1);
            ByteBuffer byteBuffer0 = ByteBuffer.allocate(v + 52);
            byteBuffer0.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer0.putInt(v + 52);
            byteBuffer0.putShort(1);
            byteBuffer0.putShort(1);
            byteBuffer0.putShort(((short)(s1.length() * 2)));
            byteBuffer0.put(s1.getBytes(Charset.forName("UTF-16LE")));
            return byteBuffer0.array();
        }
        Log.i("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
        return arr_b;
    }

    // 去混淆评级： 低(20)
    private static byte[] adjustRequestData(UUID uUID0, byte[] arr_b) {
        return C.CLEARKEY_UUID.equals(uUID0) ? ClearKeyUtil.adjustRequestData(arr_b) : arr_b;
    }

    private static byte[] adjustRequestInitData(UUID uUID0, byte[] arr_b) {
        UUID uUID1 = C.PLAYREADY_UUID;
        if(uUID1.equals(uUID0)) {
            byte[] arr_b1 = PsshAtomUtil.parseSchemeSpecificData(arr_b, uUID0);
            if(arr_b1 != null) {
                arr_b = arr_b1;
            }
            arr_b = PsshAtomUtil.buildPsshAtom(uUID1, FrameworkMediaDrm.addLaUrlAttributeIfMissing(arr_b));
        }
        if(Util.SDK_INT < 23 && C.WIDEVINE_UUID.equals(uUID0) || uUID1.equals(uUID0) && "Amazon".equals(Util.MANUFACTURER) && ("AFTB".equals(Util.MODEL) || "AFTS".equals(Util.MODEL) || "AFTM".equals(Util.MODEL) || "AFTT".equals(Util.MODEL))) {
            byte[] arr_b2 = PsshAtomUtil.parseSchemeSpecificData(arr_b, uUID0);
            return arr_b2 == null ? arr_b : arr_b2;
        }
        return arr_b;
    }

    // 去混淆评级： 低(30)
    private static String adjustRequestMimeType(UUID uUID0, String s) {
        return Util.SDK_INT >= 26 || !C.CLEARKEY_UUID.equals(uUID0) || !"video/mp4".equals(s) && !"audio/mp4".equals(s) ? s : "cenc";
    }

    private static UUID adjustUuid(UUID uUID0) {
        return Util.SDK_INT >= 27 || !C.CLEARKEY_UUID.equals(uUID0) ? uUID0 : C.COMMON_PSSH_UUID;
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] arr_b) {
        this.mediaDrm.closeSession(arr_b);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaCrypto createMediaCrypto(byte[] arr_b) {
        return this.createMediaCrypto(arr_b);
    }

    // 去混淆评级： 低(20)
    public FrameworkMediaCrypto createMediaCrypto(byte[] arr_b) {
        return Util.SDK_INT >= 21 || !C.WIDEVINE_UUID.equals(this.uuid) || !"L3".equals(this.getPropertyString("securityLevel")) ? new FrameworkMediaCrypto(FrameworkMediaDrm.adjustUuid(this.uuid), arr_b, false) : new FrameworkMediaCrypto(FrameworkMediaDrm.adjustUuid(this.uuid), arr_b, true);
    }

    @SuppressLint({"WrongConstant"})
    private static void forceWidevineL3(MediaDrm mediaDrm0) {
        mediaDrm0.setPropertyString("securityLevel", "L3");
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Class getExoMediaCryptoType() {
        return FrameworkMediaCrypto.class;
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public KeyRequest getKeyRequest(byte[] arr_b, List list0, int v, HashMap hashMap0) {
        String s;
        byte[] arr_b2;
        SchemeData drmInitData$SchemeData0;
        if(list0 == null) {
            drmInitData$SchemeData0 = null;
            arr_b2 = null;
            s = null;
        }
        else {
            drmInitData$SchemeData0 = FrameworkMediaDrm.getSchemeData(this.uuid, list0);
            byte[] arr_b1 = (byte[])Assertions.checkNotNull(drmInitData$SchemeData0.data);
            arr_b2 = FrameworkMediaDrm.adjustRequestInitData(this.uuid, arr_b1);
            s = FrameworkMediaDrm.adjustRequestMimeType(this.uuid, drmInitData$SchemeData0.mimeType);
        }
        MediaDrm.KeyRequest mediaDrm$KeyRequest0 = this.mediaDrm.getKeyRequest(arr_b, arr_b2, s, v, hashMap0);
        byte[] arr_b3 = mediaDrm$KeyRequest0.getData();
        byte[] arr_b4 = FrameworkMediaDrm.adjustRequestData(this.uuid, arr_b3);
        String s1 = mediaDrm$KeyRequest0.getDefaultUrl();
        if("https://x".equals(s1)) {
            s1 = "";
        }
        if(TextUtils.isEmpty(s1) && drmInitData$SchemeData0 != null && !TextUtils.isEmpty(drmInitData$SchemeData0.licenseServerUrl)) {
            s1 = drmInitData$SchemeData0.licenseServerUrl;
        }
        return new KeyRequest(arr_b4, s1);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    @TargetApi(28)
    public PersistableBundle getMetrics() {
        return Util.SDK_INT >= 28 ? this.mediaDrm.getMetrics() : null;
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String s) {
        return this.mediaDrm.getPropertyByteArray(s);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String s) {
        return this.mediaDrm.getPropertyString(s);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest mediaDrm$ProvisionRequest0 = this.mediaDrm.getProvisionRequest();
        return new ProvisionRequest(mediaDrm$ProvisionRequest0.getData(), mediaDrm$ProvisionRequest0.getDefaultUrl());
    }

    private static SchemeData getSchemeData(UUID uUID0, List list0) {
        if(!C.WIDEVINE_UUID.equals(uUID0)) {
            return (SchemeData)list0.get(0);
        }
        if(Util.SDK_INT >= 28 && list0.size() > 1) {
            SchemeData drmInitData$SchemeData0 = (SchemeData)list0.get(0);
            int v = 0;
            int v1 = 0;
            while(v < list0.size()) {
                SchemeData drmInitData$SchemeData1 = (SchemeData)list0.get(v);
                byte[] arr_b = drmInitData$SchemeData1.data;
                if(!Util.areEqual(drmInitData$SchemeData1.mimeType, drmInitData$SchemeData0.mimeType) || !Util.areEqual(drmInitData$SchemeData1.licenseServerUrl, drmInitData$SchemeData0.licenseServerUrl) || !PsshAtomUtil.isPsshAtom(arr_b)) {
                    goto label_23;
                }
                v1 += arr_b.length;
                ++v;
            }
            byte[] arr_b1 = new byte[v1];
            int v3 = 0;
            for(int v2 = 0; v2 < list0.size(); ++v2) {
                byte[] arr_b2 = (byte[])Util.castNonNull(((SchemeData)list0.get(v2)).data);
                System.arraycopy(arr_b2, 0, arr_b1, v3, arr_b2.length);
                v3 += arr_b2.length;
            }
            return drmInitData$SchemeData0.copyWithData(arr_b1);
        }
    label_23:
        for(int v4 = 0; v4 < list0.size(); ++v4) {
            SchemeData drmInitData$SchemeData2 = (SchemeData)list0.get(v4);
            int v5 = PsshAtomUtil.parseVersion(drmInitData$SchemeData2.data);
            if(Util.SDK_INT < 23 && v5 == 0 || Util.SDK_INT >= 23 && v5 == 1) {
                return drmInitData$SchemeData2;
            }
        }
        return (SchemeData)list0.get(0);
    }

    private void lambda$setOnEventListener$1(OnEventListener exoMediaDrm$OnEventListener0, MediaDrm mediaDrm0, byte[] arr_b, int v, int v1, byte[] arr_b1) {
        exoMediaDrm$OnEventListener0.onEvent(this, arr_b, v, v1, arr_b1);
    }

    private void lambda$setOnKeyStatusChangeListener$2(OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener0, MediaDrm mediaDrm0, byte[] arr_b, List list0, boolean z) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            arrayList0.add(new KeyStatus(((MediaDrm.KeyStatus)object0).getStatusCode(), ((MediaDrm.KeyStatus)object0).getKeyId()));
        }
        exoMediaDrm$OnKeyStatusChangeListener0.onKeyStatusChange(this, arr_b, arrayList0, z);
    }

    private static ExoMediaDrm lambda$static$0(UUID uUID0) {
        try {
            return FrameworkMediaDrm.newInstance(uUID0);
        }
        catch(UnsupportedDrmException unused_ex) {
            Log.e("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uUID0 + ".");
            return new DummyExoMediaDrm();
        }
    }

    private static boolean needsForceWidevineL3Workaround() [...] // 潜在的解密器

    public static FrameworkMediaDrm newInstance(UUID uUID0) {
        try {
            return new FrameworkMediaDrm(uUID0);
        }
        catch(UnsupportedSchemeException unsupportedSchemeException0) {
            throw new UnsupportedDrmException(1, unsupportedSchemeException0);
        }
        catch(Exception exception0) {
            throw new UnsupportedDrmException(2, exception0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() {
        return this.mediaDrm.openSession();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] provideKeyResponse(byte[] arr_b, byte[] arr_b1) {
        if(C.CLEARKEY_UUID.equals(this.uuid)) {
            arr_b1 = ClearKeyUtil.adjustResponseData(arr_b1);
        }
        return this.mediaDrm.provideKeyResponse(arr_b, arr_b1);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] arr_b) {
        this.mediaDrm.provideProvisionResponse(arr_b);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Map queryKeyStatus(byte[] arr_b) {
        return this.mediaDrm.queryKeyStatus(arr_b);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void release() {
        synchronized(this) {
            int v1 = this.referenceCount - 1;
            this.referenceCount = v1;
            if(v1 == 0) {
                this.mediaDrm.release();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] arr_b, byte[] arr_b1) {
        this.mediaDrm.restoreKeys(arr_b, arr_b1);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(OnEventListener exoMediaDrm$OnEventListener0) {
        d d0 = exoMediaDrm$OnEventListener0 == null ? null : new d(0, this, exoMediaDrm$OnEventListener0);
        this.mediaDrm.setOnEventListener(d0);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnKeyStatusChangeListener(OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener0) {
        if(Util.SDK_INT < 23) {
            throw new UnsupportedOperationException();
        }
        b b0 = exoMediaDrm$OnKeyStatusChangeListener0 == null ? null : new b(this, exoMediaDrm$OnKeyStatusChangeListener0);
        this.mediaDrm.setOnKeyStatusChangeListener(b0, null);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String s, byte[] arr_b) {
        this.mediaDrm.setPropertyByteArray(s, arr_b);
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String s, String s1) {
        this.mediaDrm.setPropertyString(s, s1);
    }
}

