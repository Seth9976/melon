package com.digicap.melon;

import android.content.Context;
import android.net.Uri;
import com.digicap.melon.exception.DrmNotInitializedDrmException;
import com.digicap.melon.service.melonDRMService;
import java.nio.ByteBuffer;

public class melonDrmLocalServerInterface {
    public static melonDRMService a = null;
    public static boolean b = false;

    public String checkDCF(String s) {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_checkDCF(s);
    }

    public boolean checkDrmServerState() {
        return melonDrmLocalServerInterface.a.drm_checkDrmSeverState();
    }

    public String getContentDescription(int v) {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_getContentDescription(v);
    }

    public String getContentID(int v) {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_getContentID(v);
    }

    public long getErrorCode(int v) {
        return melonDrmLocalServerInterface.a == null ? -3002L : melonDrmLocalServerInterface.a.drm_getErrorCode(v);
    }

    public String getErrorMsg() {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_getErrorMsg();
    }

    public long getFileSize(int v) {
        return melonDrmLocalServerInterface.a == null ? -3002L : melonDrmLocalServerInterface.a.drm_getFileSize(v);
    }

    public ByteBuffer getLyrics(int v) {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_getLyrics(v);
    }

    public int getMetaDataCharacterSet(int v) {
        return melonDrmLocalServerInterface.a == null ? -1 : melonDrmLocalServerInterface.a.drm_getMetaDataCharacterSet(v);
    }

    public long getOriginalFileSize(int v) {
        return melonDrmLocalServerInterface.a == null ? -3002L : melonDrmLocalServerInterface.a.drm_getOriginalFileSize(v);
    }

    public String getUnsupportedValue(int v, String s) {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_getUnsupportedValue(v, s);
    }

    public String getUnsupportedValueUTF8(int v, String s) {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_getUnsupportedValueUTF8(v, s);
    }

    public String getUrl() {
        melonDRMService melonDRMService0 = melonDrmLocalServerInterface.a;
        if(melonDRMService0 == null) {
            throw new DrmNotInitializedDrmException();
        }
        return melonDRMService0.getDrmUrl();
    }

    public String getValidPeriod(int v) {
        return melonDrmLocalServerInterface.a == null ? null : melonDrmLocalServerInterface.a.drm_getValidPeriod(v);
    }

    public boolean loadDRMLocalServer(Context context0) {
        if(!melonDrmLocalServerInterface.b) {
            melonDRMService melonDRMService0 = new melonDRMService(context0);
            melonDrmLocalServerInterface.a = melonDRMService0;
            melonDRMService0.onCreate();
            melonDrmLocalServerInterface.b = true;
        }
        return true;
    }

    public int loadFile(Uri uri0) {
        return melonDrmLocalServerInterface.a == null ? -3002 : melonDrmLocalServerInterface.a.drm_loadFile(uri0);
    }

    public int loadFile(String s) {
        return melonDrmLocalServerInterface.a == null ? -3002 : melonDrmLocalServerInterface.a.drm_loadFile(s);
    }

    public long setClientID(String s) {
        return melonDrmLocalServerInterface.a == null ? -3002L : melonDrmLocalServerInterface.a.drm_setClientID(s);
    }

    public void unloadDRMLocalServer() {
        if(melonDrmLocalServerInterface.b) {
            melonDrmLocalServerInterface.a.onDestroy();
            melonDrmLocalServerInterface.a = null;
            melonDrmLocalServerInterface.b = false;
        }
    }

    public void unloadFile(int v) {
        melonDRMService melonDRMService0 = melonDrmLocalServerInterface.a;
        if(melonDRMService0 == null) {
            return;
        }
        melonDRMService0.drm_unloadFile(v);
    }
}

