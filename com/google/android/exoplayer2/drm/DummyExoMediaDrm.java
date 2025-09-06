package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DummyExoMediaDrm implements ExoMediaDrm {
    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void acquire() {
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void closeSession(byte[] arr_b) {
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ExoMediaCrypto createMediaCrypto(byte[] arr_b) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Class getExoMediaCryptoType() {
        return null;
    }

    public static DummyExoMediaDrm getInstance() {
        return new DummyExoMediaDrm();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public KeyRequest getKeyRequest(byte[] arr_b, List list0, int v, HashMap hashMap0) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public PersistableBundle getMetrics() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] getPropertyByteArray(String s) {
        return Util.EMPTY_BYTE_ARRAY;
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public String getPropertyString(String s) {
        return "";
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public ProvisionRequest getProvisionRequest() {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] openSession() {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public byte[] provideKeyResponse(byte[] arr_b, byte[] arr_b1) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void provideProvisionResponse(byte[] arr_b) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public Map queryKeyStatus(byte[] arr_b) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void restoreKeys(byte[] arr_b, byte[] arr_b1) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnEventListener(OnEventListener exoMediaDrm$OnEventListener0) {
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setOnKeyStatusChangeListener(OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener0) {
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyByteArray(String s, byte[] arr_b) {
    }

    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm
    public void setPropertyString(String s, String s1) {
    }
}

