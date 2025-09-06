package I8;

import Cb.i;
import G8.g;
import H8.k;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.TaskUpdateLocalPlaylists;
import com.iloen.melon.types.Song;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import d8.d;
import java.util.List;
import jeb.synthetic.FIN;
import k8.Y;
import kotlin.jvm.internal.q;
import z6.f;

public final class m extends j {
    public final int g;

    public m(int v) {
        this.g = v;
        super(1);
    }

    @Override  // I8.o
    public final void b(Song song0) {
        if(this.g != 0) {
            synchronized(this) {
                LogU.info$default(this.b, "insertOrUpdate() song : " + song0.b, null, false, 6, null);
                try {
                    this.l(song0);
                    LogConstantsKt.debug(this.b, "insertOrUpdate() Complete", System.currentTimeMillis());
                }
                catch(Exception exception0) {
                    LogU.error$default(this.b, "insertOrUpdate() Error", exception0, false, 4, null);
                }
            }
            return;
        }
        synchronized(this) {
            LogU.info$default(this.b, "insertOrUpdate() song : " + song0.b, null, false, 6, null);
            try {
                this.k(song0);
                LogConstantsKt.debug(this.b, "insertOrUpdate() Complete", System.currentTimeMillis());
            }
            catch(Exception exception1) {
                LogU.error$default(this.b, "insertOrUpdate() Error", exception1, false, 4, null);
            }
        }
    }

    @Override  // I8.j
    public final p e(Context context0, List list0) {
        p p1;
        int v1;
        synchronized(this) {
            if(this.g != 0) {
                q.g(context0, "context");
                return super.e(context0, list0);
            }
            v1 = FIN.finallyOpen$NT();
            q.g(context0, "context");
            p1 = super.e(context0, list0);
            FIN.finallyCodeBegin$NT(v1);
        }
        FIN.finallyCodeEnd$NT(v1);
        return p1;
    }

    @Override  // I8.j
    public final p f(Context context0, boolean z) {
        p p1;
        int v1;
        synchronized(this) {
            if(this.g != 0) {
                return super.f(context0, z);
            }
            v1 = FIN.finallyOpen$NT();
            p1 = super.f(context0, z);
            FIN.finallyCodeBegin$NT(v1);
        }
        FIN.finallyCodeEnd$NT(v1);
        return p1;
    }

    public void k(Song song0) {
        k k0;
        String s = song0.a;
        f f0 = g.a;
        f0.m();
        q.d(s);
        String s1 = null;
        if(!g.d(s)) {
            LogU.debug$default(this.b, "insertOrUpdate() insert item : " + song0.b, null, false, 6, null);
            Context context0 = Y.a(MelonAppBase.Companion);
            Uri uri0 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            q.f(uri0, "EXTERNAL_CONTENT_URI");
            Cursor cursor0 = i.n(context0, uri0, ((String[])l.c.getValue()), "_data = ?", new String[]{s}, 16);
            if(cursor0 != null) {
                try {
                    if(cursor0.moveToFirst()) {
                        k0 = this.g(cursor0, this.h(context0, e.k.z(i.f(cursor0, "_id", 0L))));
                        goto label_18;
                    }
                    else {
                        goto label_20;
                    }
                    goto label_26;
                }
                catch(Throwable throwable0) {
                    d.l(cursor0, throwable0);
                    throw throwable0;
                }
            label_18:
                cursor0.close();
                goto label_26;
            label_20:
                cursor0.close();
            }
            LogU.warn$default(this.b, "createContentEntityWithData() - Audio Meta not found.", null, false, 6, null);
            k0 = null;
        label_26:
            if(k0 != null) {
                f0.m();
                g.n(k0);
            }
        }
        f0.m();
        k k1 = g.k(s);
        if(k1 != null) {
            String s2 = song0.b;
            q.f(s2, "songId");
            k1.e = s2;
            k1.f = song0.e;
            String s3 = song0.g;
            q.f(s3, "albumId");
            k1.q = s3;
            if((StringIds.b(song0.h) ? null : song0.h) != null) {
                q.f("", "toString(...)");
                k1.n = "";
            }
            String s4 = song0.i;
            q.d(s4);
            if(s4.length() > 0) {
                s1 = s4;
            }
            if(s1 != null) {
                k1.m = s1;
            }
            f0.m();
            g.q(k1);
            new TaskUpdateLocalPlaylists().updateFromLocalContentEntityAsync(k1);
            o.a(("insertOrUpdate() id : " + k1.a + ", displayName : " + k1.d));
            return;
        }
        o.a(("insertOrUpdate() Not found local content, songId : " + song0.b));
        throw new IllegalStateException("Not found local content, songId : " + song0.b);
    }

    public void l(Song song0) {
        k k0;
        Uri uri0 = song0.j;
        f f0 = g.a;
        f0.m();
        q.d(uri0);
        String s = null;
        if(!g.c(uri0)) {
            LogU.debug$default(this.b, "insertOrUpdate() insert item : " + song0.b, null, false, 6, null);
            Context context0 = Y.a(MelonAppBase.Companion);
            Cursor cursor0 = i.n(context0, uri0, ((String[])l.c.getValue()), null, null, 28);
            if(cursor0 != null) {
                try {
                    if(cursor0.moveToFirst()) {
                        k0 = this.g(cursor0, this.h(context0, e.k.z(i.f(cursor0, "_id", 0L))));
                        goto label_16;
                    }
                    else {
                        goto label_18;
                    }
                    goto label_24;
                }
                catch(Throwable throwable0) {
                    d.l(cursor0, throwable0);
                    throw throwable0;
                }
            label_16:
                cursor0.close();
                goto label_24;
            label_18:
                cursor0.close();
            }
            LogU.warn$default(this.b, "createContentEntityWithUri() - Audio Meta not found.", null, false, 6, null);
            k0 = null;
        label_24:
            if(k0 != null) {
                f0.m();
                g.n(k0);
            }
        }
        f0.m();
        k k1 = g.j(uri0);
        if(k1 != null) {
            String s1 = song0.b;
            q.f(s1, "songId");
            k1.e = s1;
            k1.f = song0.e;
            String s2 = song0.g;
            q.f(s2, "albumId");
            k1.q = s2;
            if((StringIds.b(song0.h) ? null : song0.h) != null) {
                q.f("", "toString(...)");
                k1.n = "";
            }
            String s3 = song0.i;
            q.d(s3);
            if(s3.length() > 0) {
                s = s3;
            }
            if(s != null) {
                k1.m = s;
            }
            f0.m();
            g.q(k1);
            new TaskUpdateLocalPlaylists().updateFromLocalContentEntityAsync(k1);
            o.a(("insertOrUpdate() id : " + k1.a + ", displayName : " + k1.d));
            return;
        }
        o.a(("insertOrUpdate() Not found local content, songId : " + song0.b));
        throw new IllegalStateException("Not found local content, songId : " + song0.b);
    }
}

