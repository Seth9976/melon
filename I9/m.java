package i9;

import H8.k;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.types.Song;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.Map;

public abstract class m {
    public static final Uri a;

    static {
        m.a = Uri.parse("content://com.iloen.melon.provider.melondcf/external/audio/playstreaming");
    }

    public static void a(k k0, String s) {
        if(k0 == null) {
            LogU.d("PlayStreaming", "addOrUpdate() entity is null");
            return;
        }
        Map map0 = StringUtils.makeArtistMap(k0.n, k0.m);
        Song song0 = new Song(k0.b, null, k0.e, 2);
        song0.c = k0.k;
        song0.g = k0.q;
        song0.f = map0;
        song0.g(map0);
        m.b(song0, null, s);
    }

    public static boolean b(Song song0, String s, String s1) {
        int v1;
        boolean z2;
        Uri uri1;
        boolean z;
        String s2 = song0.a;
        String s3 = song0.b;
        int v = song0.e;
        StringBuilder stringBuilder0 = new StringBuilder("addOrUpdate - song:");
        stringBuilder0.append(song0);
        stringBuilder0.append(", bitRate:");
        stringBuilder0.append(s);
        stringBuilder0.append(", caller:");
        Z.x(stringBuilder0, s1, "PlayStreaming");
        ContentResolver contentResolver0 = MelonAppBase.instance.getContext().getContentResolver();
        Uri uri0 = m.a;
        Cursor cursor0 = contentResolver0.query(uri0, new String[]{"_id"}, "_data=?", new String[]{s2}, null);
        if(cursor0 == null) {
            z = false;
        }
        else {
            z = cursor0.getCount() > 0;
            cursor0.close();
        }
        if(!z) {
            boolean z1 = FilenameUtils.isMp3(s2);
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("songid", s3);
            contentValues0.put("_data", s2);
            contentValues0.put("bitrate", s);
            contentValues0.put("ismp3", (z1 ? "1" : "0"));
            String s4 = song0.g;
            if(s4 != null) {
                contentValues0.put("albumid", s4);
            }
            if(song0.h != null) {
                contentValues0.put("artistids", "");
            }
            String s5 = song0.i;
            if(s5 != null) {
                contentValues0.put("artistnames", s5);
            }
            contentValues0.put("match_stat", v);
            try {
                uri1 = contentResolver0.insert(uri0, contentValues0);
            }
            catch(Exception exception0) {
                Z.v(exception0, new StringBuilder("addOrUpdate() "), "PlayStreaming");
                uri1 = null;
            }
            LogU.d("PlayStreaming", "Inserted uri: " + uri1 + ", song:" + song0);
            return uri1 != null;
        }
        if(TextUtils.isEmpty(s3)) {
            z2 = false;
        }
        else {
            Cursor cursor1 = contentResolver0.query(uri0, new String[]{"_id"}, "_data=? AND match_stat <= ?", new String[]{s2, String.valueOf(v)}, null);
            if(cursor1 == null) {
                z2 = false;
            }
            else {
                z2 = cursor1.getCount() > 0;
                cursor1.close();
            }
        }
        if(z2) {
            ContentValues contentValues1 = new ContentValues();
            if(v == 2) {
                contentValues1.put("songid", s3);
                if(!TextUtils.isEmpty(song0.g)) {
                    contentValues1.put("albumid", song0.g);
                }
                if(!StringIds.b(song0.h)) {
                    contentValues1.put("artistids", "");
                }
                if(!TextUtils.isEmpty(song0.i)) {
                    contentValues1.put("artistnames", song0.i);
                }
            }
            contentValues1.put("match_stat", v);
            try {
                v1 = contentResolver0.update(uri0, contentValues1, "_data=?", new String[]{s2});
            }
            catch(Exception exception1) {
                Z.v(exception1, new StringBuilder("addOrUpdate() "), "PlayStreaming");
                v1 = 0;
            }
            LogU.d("PlayStreaming", "Updated " + v1 + "rows! - song:" + song0);
            return v1 > 0;
        }
        LogU.d("PlayStreaming", "Nothing need to be updated! - song:" + song0);
        return false;
    }
}

