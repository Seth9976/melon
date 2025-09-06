package DigiCAP.SKT.DRM;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.iloen.melon.utils.log.DcfLog;
import java.io.IOException;

public class DRMUCHInterface {
    private static final String TAG = "DRMUCHInterface";

    static {
        try {
            System.loadLibrary("SKTDRM_UCH_Update");
        }
        catch(UnsatisfiedLinkError | SecurityException exception0) {
            DcfLog.e("DRMUCHInterface", "failed to load SKTDRM_UCH_Update library - " + exception0.toString());
        }
    }

    public static native void DRMUchDestroy() {
    }

    public static native short DRMUchInit() {
    }

    public static short DRMUchUpdate(Context context0, Uri uri0, String s, String s1, String s2, int v) {
        try {
            ParcelFileDescriptor parcelFileDescriptor0 = context0.getContentResolver().openFileDescriptor(uri0, "rw");
            if(parcelFileDescriptor0 != null) {
                short v1 = DRMUCHInterface.DRMUchUpdatePfd(parcelFileDescriptor0.getFd(), s, s1, s2, v);
                parcelFileDescriptor0.close();
                return v1;
            }
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
        }
        return -1;
    }

    public static short DRMUchUpdate(byte[] arr_b, String s, String s1, String s2, int v) {
        return DRMUCHInterface.DRMUchUpdatePath(arr_b, s, s1, s2, v);
    }

    private static native short DRMUchUpdatePath(byte[] arg0, String arg1, String arg2, String arg3, int arg4) {
    }

    private static native short DRMUchUpdatePfd(int arg0, String arg1, String arg2, String arg3, int arg4) {
    }
}

