package e9;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import x8.f;

public final class b extends f {
    public final Context a;
    public final a b;
    public final String c;
    public int d;
    public int e;
    public ArrayList f;
    public String[] g;
    public Object h;

    public b(Context context0, a a0) {
        q.g(context0, "context");
        q.g(a0, "listener");
        super();
        this.a = context0;
        this.b = a0;
        this.c = "NewDBRemover";
    }

    public final void a(String[] arr_s, Object object0) {
        this.g = arr_s;
        this.execute(arr_s);
        this.h = object0;
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        long v1;
        String[] arr_s = (String[])object0;
        Y.t("type=", this.d, LogU.Companion, this.c);
        if(arr_s != null) {
            if(this.d == 1) {
                MusicUtils.removeLocalPlayList(arr_s[0]);
            }
            int v = this.d;
            if(v == 6) {
                try {
                    String s = arr_s[0];
                    v1 = -1L;
                    if(s != null) {
                        v1 = Long.parseLong(s);
                    }
                }
                catch(NumberFormatException unused_ex) {
                }
                if(v1 != -1L) {
                    MusicUtils.deletePlaylistTracks(this.f, v1);
                    return new Integer(this.e);
                }
            }
            else {
                Context context0 = this.a;
                if(v == 2) {
                    try {
                        MusicUtils.deleteMV(context0, arr_s);
                        return new Integer(this.e);
                    }
                    catch(Exception unused_ex) {
                        return new Integer(this.e);
                    }
                }
                if(v == 7) {
                    this.e = MusicUtils.deleteTracks(context0, arr_s, true);
                    return new Integer(this.e);
                }
                this.e = MusicUtils.deleteTracks(context0, arr_s);
            }
        }
        return new Integer(this.e);
    }

    @Override  // x8.f
    public final void postTask(Object object0) {
        if(((Integer)object0) == null || ((int)(((Integer)object0))) != -10) {
            this.b.onRemoveComplete((((Integer)object0) == null ? 0 : ((int)(((Integer)object0)))), this.h);
            String[] arr_s = this.g;
            if(arr_s != null) {
                Collection collection0 = k.A(Arrays.copyOf(arr_s, arr_s.length));
                Context context0 = this.a;
                if(context0 != null && !collection0.isEmpty()) {
                    MediaScannerConnection.scanFile(context0, ((String[])collection0.toArray(new String[0])), null, null);
                    return;
                }
                LogU.w("MelonMediaScanner", "scanFile() invalid parameter");
            }
        }
    }
}

