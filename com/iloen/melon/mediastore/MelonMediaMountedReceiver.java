package com.iloen.melon.mediastore;

import I8.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import b3.Z;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import java.io.IOException;

public class MelonMediaMountedReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s3;
        String s = intent0.getAction();
        Uri uri0 = intent0.getData();
        Z.w("onReceive - action: ", s, "MelonMediaMountedReceiver");
        if(uri0 != null && "file".equals(uri0.getScheme())) {
            String s1 = Environment.getExternalStorageDirectory().getPath();
            LogU.d("MelonMediaMountedReceiver", "     - uri: " + uri0);
            if("file".equals(uri0.getScheme())) {
                String s2 = uri0.getPath();
                try {
                    s3 = new File(s2).getCanonicalPath();
                }
                catch(IOException unused_ex) {
                    LogU.e("MelonMediaMountedReceiver", "couldn\'t canonicalize " + s2);
                    return;
                }
            }
            else {
                s3 = null;
            }
            StringBuilder stringBuilder0 = a.n("     - realPath: ", s3, ", inputPath:");
            stringBuilder0.append(uri0.getPath());
            LogU.d("MelonMediaMountedReceiver", stringBuilder0.toString());
            LogU.d("MelonMediaMountedReceiver", "     - externalStoragePath: " + s1);
            if("android.intent.action.MEDIA_MOUNTED".equals(s) && s3 != null && FileUtils.pathEquals(s3, s1)) {
                e.b(context0, "From mediaMountReceiver", false);
            }
        }
    }
}

