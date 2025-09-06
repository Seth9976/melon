package com.iloen.melon.types;

import E9.w;
import G8.g;
import H8.i;
import H8.k;
import U4.x;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.q;

public class Song {
    public final String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public Map f;
    public String g;
    public StringIds h;
    public String i;
    public final Uri j;

    static {
    }

    public Song(String s) {
        this(s, null, null, 0);
    }

    public Song(String s, Uri uri0, String s1, int v) {
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 0;
        new LinkedHashMap();
        this.g = "";
        this.h = StringIds.a;
        this.i = "";
        this.a = s;
        this.j = uri0;
        this.b = s1;
        this.e = v;
    }

    public static Song a(SongInfoBase songInfoBase0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        ArrayList arrayList0 = songInfoBase0.artistList;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                linkedHashMap0.put(((ArtistsInfoBase)object0).getArtistId(), ((ArtistsInfoBase)object0).getArtistName());
            }
        }
        Song song0 = new Song("");
        song0.b = songInfoBase0.songId;
        song0.c = songInfoBase0.songName;
        song0.g = songInfoBase0.albumId;
        try {
            Long.parseLong(songInfoBase0.playTime);
        }
        catch(Exception unused_ex) {
        }
        song0.e = 2;
        song0.h = ProtocolUtils.getArtistIds(songInfoBase0.artistList);
        song0.i = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
        return song0;
    }

    public static Song b(String s) {
        return new Song(null, null, s, 2);
    }

    public final boolean c() {
        return !TextUtils.isEmpty(this.b) && this.e == 2;
    }

    public static Song d(Uri uri0, boolean z) {
        k k0;
        g.a.m();
        Song song0 = null;
        if(z) {
            q.g(uri0, "uri");
            if(TextUtils.isEmpty(uri0.toString())) {
                k0 = null;
            }
            else {
                i i0 = g.g();
                String s = uri0.toString();
                q.f(s, "toString(...)");
                k0 = (k)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new Ac.g(s, 12));
            }
        }
        else {
            k0 = g.j(uri0);
        }
        if(k0 != null) {
            Song song1 = new Song(null, uri0, k0.e, k0.f);
            String s1 = k0.q;
            if(!TextUtils.isEmpty(s1)) {
                song1.g = s1;
            }
            String s2 = k0.n;
            if(!TextUtils.isEmpty(s2)) {
                song1.h = StringIds.e(s2);
            }
            String s3 = k0.m;
            if(!TextUtils.isEmpty(s3)) {
                song1.i = s3;
            }
            song0 = song1;
        }
        if(song0 != null) {
            song0.c();
        }
        return song0;
    }

    // 去混淆评级： 中等(60)
    public static Song e(Playable playable0, boolean z) {
        return StorageUtils.isScopedStorage() ? Song.d(Uri.parse(""), z) : Song.f("", z);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        if(this.getClass() != object0.getClass()) {
            return false;
        }
        String s = this.b;
        if(s == null) {
            return ((Song)object0).b == null ? this.e == ((Song)object0).e : false;
        }
        return s.equals(((Song)object0).b) ? this.e == ((Song)object0).e : false;
    }

    public static Song f(String s, boolean z) {
        k k0;
        g.a.m();
        if(z) {
            q.g(s, "data");
            k0 = (k)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 10));
        }
        else {
            k0 = g.k(s);
        }
        Song song0 = null;
        if(k0 != null) {
            Song song1 = new Song(s, null, k0.e, k0.f);
            String s1 = k0.q;
            if(!TextUtils.isEmpty(s1)) {
                song1.g = s1;
            }
            String s2 = k0.n;
            if(!TextUtils.isEmpty(s2)) {
                song1.h = StringIds.e(s2);
            }
            String s3 = k0.m;
            if(!TextUtils.isEmpty(s3)) {
                song1.i = s3;
            }
            song0 = song1;
        }
        if(song0 != null) {
            song0.c();
        }
        return song0;
    }

    public final void g(Map map0) {
        this.f = map0;
        Set set0 = map0.keySet();
        StringIds stringIds0 = new StringIds(set0.size());  // 初始化器: Ljava/util/ArrayList;-><init>(I)V
        for(Object object0: set0) {
            stringIds0.add(((String)object0));
        }
        this.h = stringIds0;
        this.i = StringUtils.parseToCsv(map0.values(), false, true);
    }

    @Override
    public final int hashCode() {
        return this.b == null ? this.e + 961 : (this.b.hashCode() + 0x1F) * 0x1F + this.e;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Song [path=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", uri=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", songId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", songName=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", matchState=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", albumId=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", artistIds=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", artistNames=");
        return x.m(stringBuilder0, this.i, "]");
    }
}

