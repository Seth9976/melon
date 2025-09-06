package DigiCAP.SKT.DRM;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.iloen.melon.utils.log.DcfLog;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MelonDRMMetaInterface {
    private static final String TAG = "MelonDRMMetaInterface";

    static {
        try {
            System.loadLibrary("melonDrmMeta");
        }
        catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
            DcfLog.e("MelonDRMMetaInterface", "failed to load melonDrmMeta library - " + unsatisfiedLinkError0.toString());
        }
    }

    public static native short DRMMetaClose(short arg0) {
    }

    public static native void DRMMetaDestroy() {
    }

    public static native long DRMMetaExtractAlbumArt(short arg0, ByteBuffer arg1) {
    }

    public static native long DRMMetaGetBufferSizeForAlbumArt(short arg0) {
    }

    public static native long DRMMetaGetErrorCode(short arg0) {
    }

    public static native byte[] DRMMetaGetMetaTextValueFromID3UTF8(int arg0, String arg1) {
    }

    public static native byte[] DRMMetaGetUnsupportedValue(short arg0, String arg1) {
    }

    public static native String DRMMetaGetUnsupportedValueUTF8(int arg0, String arg1) {
    }

    public static native int DRMMetaInit() {
    }

    public static short DRMMetaOpen(Context context0, Uri uri0, int v, short v1) {
        try {
            ParcelFileDescriptor parcelFileDescriptor0 = context0.getContentResolver().openFileDescriptor(uri0, "r");
            if(parcelFileDescriptor0 != null) {
                short v2 = MelonDRMMetaInterface.DRMMetaPfdOpen(parcelFileDescriptor0.getFd(), v, v1);
                parcelFileDescriptor0.close();
                return v2;
            }
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
        }
        return -1;
    }

    public static short DRMMetaOpen(byte[] arr_b, int v, short v1) {
        return MelonDRMMetaInterface.DRMMetaPathOpen(arr_b, v, ((int)v1));
    }

    private static native short DRMMetaPathOpen(byte[] arg0, int arg1, int arg2) {
    }

    private static native short DRMMetaPfdOpen(int arg0, int arg1, int arg2) {
    }

    public static native long DRMMetaSetClientID(String arg0) {
    }
}

