package DigiCAP.SKT.DRM;

import com.iloen.melon.utils.log.DcfLog;
import java.nio.ByteBuffer;

public class DRMInterface {
    private static final String DRM_JNI_IFACE_SO_NAME = "SKTDRM_JNI_Interface_ver_14";
    private static final String TAG = "DRMInterface";
    private static boolean sSktDrmLibraryLoaded;

    static {
        try {
            System.loadLibrary("SKTDRM_JNI_Interface_ver_14");
            DRMInterface.sSktDrmLibraryLoaded = true;
        }
        catch(UnsatisfiedLinkError | SecurityException exception0) {
            DcfLog.e("DRMInterface", "failed to load SKTDRM_JNI_Interface_ver_14 library - " + exception0);
        }
    }

    public static native short DRMClose(short arg0) {
    }

    public static native void DRMDestroy() {
    }

    public static native String DRMGetClientID() {
    }

    public static native String DRMGetContentDescription(short arg0) {
    }

    public static native String DRMGetContentID(short arg0) {
    }

    public static native long DRMGetErrorCode(short arg0) {
    }

    public static native String DRMGetValidPeriod(short arg0) {
    }

    public static native short DRMInit() {
    }

    public static native short DRMIsEmbeddedDRM() {
    }

    public static native short DRMIsExpandedFilePath() {
    }

    public static native short DRMOpenPath(byte[] arg0, int arg1, short arg2) {
    }

    public static native long DRMRead(short arg0, ByteBuffer arg1, long arg2) {
    }

    public static native long DRMSeek(short arg0, long arg1, int arg2) {
    }

    public static native long DRMSetClientID(String arg0) {
    }

    public static boolean isSktDrmLibraryLoaded() [...] // 潜在的解密器
}

