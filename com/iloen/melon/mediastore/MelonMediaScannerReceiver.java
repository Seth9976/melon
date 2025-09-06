package com.iloen.melon.mediastore;

import I8.d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import b3.Z;
import com.iloen.melon.playback.TaskUpdateLocalPlaylists;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

public class MelonMediaScannerReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s4;
        String s = intent0.getAction();
        Uri uri0 = intent0.getData();
        Z.w("onReceive - action: ", s, "MelonMediaScannerReceiver");
        if(uri0 != null && "file".equals(uri0.getScheme())) {
            String s1 = Environment.getExternalStorageDirectory().getPath();
            String s2 = new File(System.getenv("EXTERNAL_STORAGE")).getPath();
            LogU.d("MelonMediaScannerReceiver", "     - uri: " + uri0);
            if("file".equals(uri0.getScheme())) {
                String s3 = uri0.getPath();
                try {
                    s4 = new File(s3).getCanonicalPath();
                }
                catch(IOException unused_ex) {
                    LogU.e("MelonMediaScannerReceiver", "couldn\'t canonicalize " + s3);
                    return;
                }
                if(s4.startsWith(s2)) {
                    s4.substring(s2.length());
                }
            }
            else {
                s4 = null;
            }
            StringBuilder stringBuilder0 = a.n("     - realPath: ", s4, ", inputPath:");
            stringBuilder0.append(uri0.getPath());
            LogU.d("MelonMediaScannerReceiver", stringBuilder0.toString());
            LogU.d("MelonMediaScannerReceiver", "     - externalStoragePath: " + s1);
            LogU.d("MelonMediaScannerReceiver", "     - legacyExternalStoragePath: " + s2);
            if("android.intent.action.MEDIA_SCANNER_FINISHED".equals(s)) {
                int v = intent0.getIntExtra("songId", -1);
                if(s4 != null) {
                    Song song0 = new Song(s4);
                    song0.b = String.valueOf(v);
                    new TaskUpdateLocalPlaylists().updateFromSongAsync(song0);
                }
                MusicUtils.cleanupJunkDataSafety(context0);
                return;
            }
            if("android.intent.action.MEDIA_SCANNER_SCAN_FILE".equals(s) && s4 != null && s4.startsWith(s1 + "/")) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(new File(s4));
                q.g(context0, "context");
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new d(context0, arrayList0, null), 3, null);
            }
        }
    }
}

