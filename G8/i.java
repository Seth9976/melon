package G8;

import Cc.h0;
import E9.w;
import H8.g;
import H8.k;
import H8.m;
import H8.q;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.room.A;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.database.core.LocalPlaylistDatabase;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.cipher.Base62UUID;
import com.iloen.melon.utils.player.MusicUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import k8.t;
import va.e;
import w7.d;

public final class i {
    public static final d a;
    public static i b;

    static {
        i.a = new d(14);
    }

    public static q a() {
        String s;
        d d0 = LocalPlaylistDatabase.a;
        if(StorageUtils.isScopedStorage()) {
            s = "local_playlist_db";
        }
        else {
            File file0 = new File(e.h(Environment.getExternalStorageDirectory().getPath(), "/melon/db"), "local_playlist_db");
            s = file0.canRead() ? Cb.i.i(file0) : "local_playlist_db";
        }
        LocalPlaylistDatabase localPlaylistDatabase0 = LocalPlaylistDatabase.b;
        if(localPlaylistDatabase0 == null) {
            synchronized(d0) {
                MelonAppBase.Companion.getClass();
                A a0 = w.o(t.a().getContext(), LocalPlaylistDatabase.class, s);
                a0.i = true;
                a0.d.add(LocalPlaylistDatabase.c);
                localPlaylistDatabase0 = (LocalPlaylistDatabase)a0.b();
                LocalPlaylistDatabase.b = localPlaylistDatabase0;
            }
            return localPlaylistDatabase0.b();
        }
        return localPlaylistDatabase0.b();
    }

    public static List b(long v) {
        return (List)w.N(((LocalPlaylistDatabase_Impl)i.a().a), true, false, new h0(v, 3));
    }

    public static List c() {
        return (List)w.N(((LocalPlaylistDatabase_Impl)i.a().a), true, false, new g(1));
    }

    public static ArrayList d(String s, List list0) {
        String s10;
        ArrayList arrayList0 = new ArrayList();
        if(list0 != null && !list0.isEmpty()) {
            for(Object object0: list0) {
                String s1 = ((H8.t)object0).d;
                String s2 = ((H8.t)object0).e;
                String s3 = ((H8.t)object0).g;
                if(FilenameUtils.isDcf(s3)) {
                    s3 = StringUtils.getTitleForDCF(s3);
                }
                String s4 = ((H8.t)object0).k;
                String s5 = ((H8.t)object0).j;
                String s6 = ((H8.t)object0).i;
                long v = (long)((H8.t)object0).n;
                long v1 = ProtocolUtils.parseLong(((H8.t)object0).h, -1L);
                CType cType0 = CType.SONG;
                if(!StorageUtils.isScopedStorage() || s2.length() <= 0) {
                    if(MusicUtils.isEducationContents(s1)) {
                        cType0 = CType.EDU;
                    }
                }
                else if(MusicUtils.isEducationContents(Uri.parse(s2))) {
                    cType0 = CType.EDU;
                }
                long v2 = ((H8.t)object0).a;
                Song song0 = !StorageUtils.isScopedStorage() || s2.length() <= 0 ? Song.f(s1, true) : Song.d(Uri.parse(s2), true);
                String s7 = song0 == null ? null : song0.b;
                String s8 = ((H8.t)object0).f;
                G8.g.a.m();
                Uri uri0 = Uri.parse(s2);
                kotlin.jvm.internal.q.f(uri0, "parse(...)");
                k k0 = G8.g.j(uri0);
                if(k0 == null) {
                    s10 = "";
                }
                else {
                    String s9 = k0.p;
                    if(s9 != null) {
                        s10 = s9;
                    }
                }
                Playable playable0 = Playable.newBuilder(1).isMelonSong(!TextUtils.isEmpty(s7)).data(s1).songIdTitle(s7, s3).artists(StringUtils.makeArtistMap(s4, s5)).albumName(s6).duration(v).cType(cType0).menuId(s).originMenuId(s).hasMv(0).isAdult(0).mediaStoreAlbumId(v1).uriString(s2).dbContentId(String.valueOf(v2)).displayName(s8).localAlbumKey(s10).trackId(Base62UUID.randomUUID()).build();
                kotlin.jvm.internal.q.f(playable0, "build(...)");
                arrayList0.add(playable0);
            }
        }
        return arrayList0;
    }

    public static int e() {
        return (int)(((Integer)w.N(((LocalPlaylistDatabase_Impl)i.a().a), true, false, new g(2))));
    }

    public static void f(List list0) {
        q q0 = i.a();
        q0.getClass();
        w.N(((LocalPlaylistDatabase_Impl)q0.a), false, true, new m(q0, list0, 0));
    }
}

