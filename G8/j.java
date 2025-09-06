package G8;

import E9.w;
import H8.q;
import H8.s;
import H8.t;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.preference.MelonPrefs;
import ie.H;
import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import oe.i;
import w7.d;
import we.n;

public final class j extends i implements n {
    public final Context r;

    public j(Context context0, Continuation continuation0) {
        this.r = context0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        long v = System.currentTimeMillis();
        d d0 = G8.i.a;
        d0.f();
        int v1 = G8.i.e();
        H h0 = H.a;
        if(v1 > 0) {
            LogU.debug$default(l.a, "migrate() localplaylist table exists", null, false, 6, null);
            MelonPrefs.getInstance().setBoolean("LOCAL_PLAYLIST_MIGRATION", true);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new G8.d(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            return h0;
        }
        LogU.debug$default(l.a, "migrate() localplaylist table not exists", null, false, 6, null);
        ArrayList arrayList0 = new ArrayList();
        Cursor cursor0 = MusicUtils.query(this.r, i9.l.a, new String[]{"_id", "name", "sort_order", "date_added", "date_modified"}, null, null, null);
        Context context0 = this.r;
        if(cursor0 != null) {
            if(cursor0.moveToFirst()) {
                while(true) {
                    s s0 = new s();
                    s0.a = Cb.i.f(cursor0, "_id", 0L);
                    s0.b = Cb.i.j(cursor0, "name");
                    s0.e = Cb.i.e(cursor0, "sort_order");
                    s0.c = Cb.i.f(cursor0, "date_added", 0L);
                    s0.d = Cb.i.f(cursor0, "date_modified", 0L);
                    arrayList0.add(s0);
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                }
            }
            cursor0.close();
            d0.f();
            q q0 = G8.i.a();
            q0.getClass();
            w.N(((LocalPlaylistDatabase_Impl)q0.a), false, true, new H8.n(q0, arrayList0, 2));
        }
        ArrayList arrayList1 = new ArrayList();
        Cursor cursor1 = MusicUtils.query(context0, Uri.parse("content://com.iloen.melon.provider.melondcf/external/audio/playlists/members"), new String[]{"_id", "audio_id1", "mime_type", "title", "_data", "album", "album_id", "artist", "artist_id", "duration", "playlist_id", "play_order"}, null, null, null);
        if(cursor1 != null) {
            if(cursor1.moveToFirst()) {
                while(true) {
                    t t0 = new t();
                    String s1 = Cb.i.j(cursor1, "_data");
                    t0.a = Cb.i.f(cursor1, "_id", 0L);
                    t0.b = Cb.i.f(cursor1, "audio_id1", 0L);
                    t0.c = Cb.i.j(cursor1, "mime_type");
                    t0.g = Cb.i.j(cursor1, "title");
                    t0.d = s1;
                    t0.i = Cb.i.j(cursor1, "album");
                    t0.h = Cb.i.j(cursor1, "album_id");
                    t0.j = Cb.i.j(cursor1, "artist");
                    t0.k = Cb.i.j(cursor1, "artist_id");
                    t0.n = Cb.i.e(cursor1, "duration");
                    t0.l = Cb.i.f(cursor1, "playlist_id", 0L);
                    t0.m = Cb.i.e(cursor1, "play_order");
                    File file0 = new File(s1);
                    if(file0.exists()) {
                        String s2 = file0.getName();
                        kotlin.jvm.internal.q.f(s2, "getName(...)");
                        t0.f = s2;
                    }
                    arrayList1.add(t0);
                    if(!cursor1.moveToNext()) {
                        break;
                    }
                }
            }
            cursor1.close();
            d0.f();
            q q1 = G8.i.a();
            q1.getClass();
            w.N(((LocalPlaylistDatabase_Impl)q1.a), false, true, new H8.n(q1, arrayList1, 0));
        }
        MelonPrefs.getInstance().setBoolean("LOCAL_PLAYLIST_MIGRATION", true);
        LogConstantsKt.debug(l.a, "migrate() Complete", v);
        return h0;
    }
}

