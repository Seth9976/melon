package DigiCAP.SKT.DRM;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.digicap.melon.exception.UnsatisfiedLinkErrorDrmException;
import com.digicap.melon.log.DigicapLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

public class MelonDRMInterface {
    private static final DigicapLog LOG;
    Map contentPathMap;
    private String errorMsg;
    private static MelonDRMInterface mSingleton;

    static {
        MelonDRMInterface.LOG = DigicapLog.getInstance();
        MelonDRMInterface.mSingleton = null;
    }

    private MelonDRMInterface() {
        this.contentPathMap = new HashMap();
        System.loadLibrary("melonDrm");
    }

    private static native String DRMCheckDCF(byte[] arg0) {
    }

    private static native String DRMCheckDCFFromPfd(int arg0) {
    }

    private static native long DRMCheckLyrics(byte[] arg0) {
    }

    private static native long DRMCheckLyricsFromPfd(int arg0) {
    }

    private static native int DRMClose(int arg0) {
    }

    private static native void DRMDestroy() {
    }

    private static native String DRMGetContentDescription(int arg0) {
    }

    private static native String DRMGetContentID(int arg0) {
    }

    private static native String DRMGetContentIDPfd(int arg0) {
    }

    private static native long DRMGetErrorCode(int arg0) {
    }

    private static native long DRMGetFileSize(int arg0) {
    }

    private static native int DRMGetMetaDataCharacterSet(int arg0) {
    }

    private static native long DRMGetOriginalFileSize(int arg0) {
    }

    private static native byte[] DRMGetUnsupportedValue(int arg0, String arg1) {
    }

    private static native String DRMGetUnsupportedValueUTF8(int arg0, String arg1) {
    }

    private static native String DRMGetValidPeriod(int arg0) {
    }

    private static native int DRMInit() {
    }

    private static native int DRMOpenPath(byte[] arg0, int arg1, int arg2) {
    }

    private static native int DRMOpenPfd(int arg0, int arg1, int arg2) {
    }

    private static native long DRMRead(int arg0, ByteBuffer arg1, long arg2) {
    }

    private static native long DRMSeek(int arg0, long arg1, int arg2) {
    }

    private static native long DRMSetClientID(String arg0) {
    }

    private static native long DRMSetStateInfoFilePath(byte[] arg0) {
    }

    private static native long DRMSetStateInfoPfd(int arg0) {
    }

    private static native int DRMVfIsReachedToEndOfFile(int arg0) {
    }

    private static native int DRMVfOpen(long arg0, byte[] arg1, long arg2) {
    }

    private static native int DRMVfSetBuffer(int arg0, byte[] arg1, long arg2, long arg3) {
    }

    private static native int DRMVfSetFileSize(int arg0, long arg1) {
    }

    private static native long DRMVfShouldUpdateBuffer(int arg0) {
    }

    public String checkDCF(int v) {
        this.useable();
        return MelonDRMInterface.DRMCheckDCFFromPfd(v);
    }

    public String checkDCF(byte[] arr_b) {
        this.useable();
        return MelonDRMInterface.DRMCheckDCF(arr_b);
    }

    public long checkLyrics(byte[] arr_b) {
        this.useable();
        return MelonDRMInterface.DRMCheckLyrics(arr_b);
    }

    public long checkLyrics_uri(Context context0, Uri uri0) {
        try {
            ParcelFileDescriptor parcelFileDescriptor0 = context0.getContentResolver().openFileDescriptor(uri0, "r");
            this.useable();
            long v = MelonDRMInterface.DRMCheckLyricsFromPfd(parcelFileDescriptor0.getFd());
            parcelFileDescriptor0.close();
            return v;
        }
        catch(FileNotFoundException fileNotFoundException0) {
            fileNotFoundException0.printStackTrace();
            return -3001L;
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
            return -3001L;
        }
    }

    public int close(int v) {
        this.useable();
        this.contentPathMap.remove(this.findKey(v));
        return MelonDRMInterface.DRMClose(v);
    }

    public void destroy() {
        this.useable();
        this.contentPathMap.clear();
        MelonDRMInterface.DRMDestroy();
    }

    public String findKey(int v) {
        for(Object object0: this.contentPathMap.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(v == ((int)(((Integer)map$Entry0.getValue())))) {
                return (String)map$Entry0.getKey();
            }
            if(false) {
                break;
            }
        }
        return "";
    }

    public String getContentDescription(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetContentDescription(v);
    }

    public String getContentID(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetContentID(v);
    }

    public String getContentID_Pfd(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetContentIDPfd(v);
    }

    public long getErrorCode(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetErrorCode(v);
    }

    public String getErrorMsg() {
        String s = this.errorMsg;
        this.errorMsg = null;
        return s;
    }

    public long getFileSize(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetFileSize(v);
    }

    public static MelonDRMInterface getInstance() {
        if(MelonDRMInterface.mSingleton == null) {
            try {
                MelonDRMInterface.mSingleton = new MelonDRMInterface();
                return MelonDRMInterface.mSingleton;
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
                MelonDRMInterface.mSingleton = null;
                throw new UnsatisfiedLinkErrorDrmException(unsatisfiedLinkError0.toString());
            }
        }
        return MelonDRMInterface.mSingleton;
    }

    public int getMetaDataCharacterSet(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetMetaDataCharacterSet(v);
    }

    public Integer getOpenFDByPath(byte[] arr_b) {
        return (Integer)this.contentPathMap.get(arr_b);
    }

    public Integer getOpenFDByUri(Uri uri0) {
        try {
            return (Integer)this.contentPathMap.get(URLDecoder.decode(uri0.toString(), "euc-kr").toString());
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            unsupportedEncodingException0.printStackTrace();
            return null;
        }
    }

    public long getOriginalFileSize(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetOriginalFileSize(v);
    }

    public byte[] getUnsupportedValue(int v, String s) {
        this.useable();
        return MelonDRMInterface.DRMGetUnsupportedValue(v, s);
    }

    public String getUnsupportedValueUTF8(int v, String s) {
        this.useable();
        return MelonDRMInterface.DRMGetUnsupportedValueUTF8(v, s);
    }

    public String getValidPeriod(int v) {
        this.useable();
        return MelonDRMInterface.DRMGetValidPeriod(v);
    }

    public int init() {
        if(MelonDRMInterface.mSingleton == null) {
            throw new UnsatisfiedLinkErrorDrmException();
        }
        return MelonDRMInterface.DRMInit();
    }

    public int open(Context context0, Uri uri0, int v, int v1) {
        int v3;
        synchronized(this) {
            try {
                ParcelFileDescriptor parcelFileDescriptor0 = context0.getContentResolver().openFileDescriptor(uri0, "r");
                this.useable();
                v3 = MelonDRMInterface.DRMOpenPfd(parcelFileDescriptor0.getFd(), v, v1);
                parcelFileDescriptor0.close();
                if(v3 >= 0) {
                    if(this.contentPathMap == null) {
                        this.contentPathMap = new HashMap();
                    }
                    this.contentPathMap.put(URLDecoder.decode(uri0.toString(), "euc-kr"), v3);
                    return v3;
                }
                return v3;
            }
            catch(FileNotFoundException fileNotFoundException0) {
            }
            catch(IOException iOException0) {
                iOException0.printStackTrace();
                return -3001;
            }
        }
        fileNotFoundException0.printStackTrace();
        return -3001;
    }

    public int open(byte[] arr_b, int v, int v1) {
        synchronized(this) {
            this.useable();
            int v3 = MelonDRMInterface.DRMOpenPath(arr_b, v, v1);
            if(v3 >= 0) {
                if(this.contentPathMap == null) {
                    this.contentPathMap = new HashMap();
                }
                this.contentPathMap.put(new String(arr_b), v3);
            }
            return v3;
        }
    }

    public long read(int v, ByteBuffer byteBuffer0, long v1) {
        this.useable();
        return MelonDRMInterface.DRMRead(v, byteBuffer0, v1);
    }

    public long seek(int v, long v1, int v2) {
        this.useable();
        return MelonDRMInterface.DRMSeek(v, v1, v2);
    }

    public long setClientID(String s) {
        this.useable();
        return MelonDRMInterface.DRMSetClientID(s);
    }

    public void setErrorMsg(String s) {
        this.errorMsg = s;
    }

    public long setStateInfoFilePath(byte[] arr_b) {
        this.useable();
        return MelonDRMInterface.DRMSetStateInfoFilePath(arr_b);
    }

    private void useable() {
        if(MelonDRMInterface.mSingleton == null) {
            throw new UnsatisfiedLinkErrorDrmException();
        }
    }

    public int vfIsReachedToEndOfFile(int v) {
        this.useable();
        return MelonDRMInterface.DRMVfIsReachedToEndOfFile(v);
    }

    public int vfOpen(long v, byte[] arr_b, long v1) {
        this.useable();
        return MelonDRMInterface.DRMVfOpen(v, arr_b, v1);
    }

    public int vfSetBuffer(int v, byte[] arr_b, long v1, long v2) {
        this.useable();
        return MelonDRMInterface.DRMVfSetBuffer(v, arr_b, v1, v2);
    }

    public int vfSetFileSize(int v, long v1) {
        this.useable();
        return MelonDRMInterface.DRMVfSetFileSize(v, v1);
    }

    public long vfShouldUpdateBuffer(int v) {
        this.useable();
        return MelonDRMInterface.DRMVfShouldUpdateBuffer(v);
    }
}

