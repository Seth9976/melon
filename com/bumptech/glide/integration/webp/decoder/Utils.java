package com.bumptech.glide.integration.webp.decoder;

import U4.x;
import android.util.Log;
import androidx.appcompat.app.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class Utils {
    private static final String TAG = "Utils";

    public static int getSampleSize(int v, int v1, int v2, int v3) {
        int v4 = Math.min(v1 / v3, v / v2);
        int v5 = Math.max(1, (v4 == 0 ? 0 : Integer.highestOneBit(v4)));
        if(Log.isLoggable("Utils", 2) && v5 > 1) {
            StringBuilder stringBuilder0 = o.t(v5, v2, "Downsampling WEBP, sampleSize: ", ", target dimens: [", "x");
            x.x(stringBuilder0, v3, "], actual dimens: [", v, "x");
            stringBuilder0.append(v1);
            stringBuilder0.append("]");
            Log.v("Utils", stringBuilder0.toString());
        }
        return v5;
    }

    public static byte[] inputStreamToBytes(InputStream inputStream0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x4000);
        try {
            byte[] arr_b = new byte[0x4000];
            int v;
            while((v = inputStream0.read(arr_b)) != -1) {
                byteArrayOutputStream0.write(arr_b, 0, v);
            }
            byteArrayOutputStream0.flush();
            return byteArrayOutputStream0.toByteArray();
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("Utils", 5)) {
                Log.w("Utils", "Error reading data from stream", iOException0);
            }
            return null;
        }
    }
}

