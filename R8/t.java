package R8;

import R6.c;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import ie.H;
import kotlin.coroutines.Continuation;
import x8.f;

public final class t extends f {
    public final int a;

    public t(int v) {
        this.a = v;
        super();
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        switch(this.a) {
            case 0: {
                Void void1 = (Void)object0;
                try {
                    m.c(MelonAppBase.instance.getContext());
                }
                catch(Exception unused_ex) {
                }
                return null;
            }
            case 1: {
                Void void2 = (Void)object0;
                try {
                    c.g().getClass();
                    l.d();
                }
                catch(VolleyError volleyError0) {
                    DcfLog.w("DcfExtendLoggerTask", volleyError0.toString());
                }
                return H.a;
            }
            default: {
                Void void0 = (Void)object0;
                Context context0 = MelonAppBase.instance.getContext();
                if(context0 == null) {
                    LogU.i("MelonMediaProvider", "Fail to update localplaylist DB because context is null!");
                    return null;
                }
                Uri uri0 = i9.l.a;
                ContentResolver contentResolver0 = context0.getContentResolver();
                Cursor cursor0 = MusicUtils.query(context0, uri0, null, null, null, "sort_order desc");
                if(cursor0 != null && cursor0.moveToFirst()) {
                    int v = 1;
                    while(true) {
                        String s = cursor0.getString(cursor0.getColumnIndexOrThrow("_id"));
                        ContentValues contentValues0 = new ContentValues();
                        contentValues0.put("sort_order", ((int)(cursor0.getCount() - v)));
                        contentResolver0.update(uri0, contentValues0, "_id = ?", new String[]{s});
                        ++v;
                        if(!cursor0.moveToNext()) {
                            break;
                        }
                    }
                }
                return null;
            }
        }
    }
}

