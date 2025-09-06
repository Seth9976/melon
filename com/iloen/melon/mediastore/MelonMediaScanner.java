package com.iloen.melon.mediastore;

import Bb.i;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;
import i9.f;
import i9.g;
import i9.j;
import i9.k;
import java.util.ArrayList;
import java.util.HashMap;
import jeb.synthetic.FIN;
import jeb.synthetic.TWR;

public class MelonMediaScanner {
    public HashMap a;
    public HashMap b;
    public final Context c;
    public Uri d;
    public Uri e;
    public boolean f;
    public boolean g;
    public final g h;
    public static final String[] i;
    public static final String[] j;

    static {
        MelonMediaScanner.i = new String[]{"_id", "_data", "date_modified"};
        MelonMediaScanner.j = new String[]{"_id", "name"};
    }

    public MelonMediaScanner(Context context0) {
        this.h = new g(this);
        this.c = context0;
    }

    public final void a() {
        this.d = k.a("external");
        this.f = true;
        this.b = new HashMap();
        this.e = j.a("external");
        this.g = true;
    }

    public final void b(String s) {
        int v;
        Cursor cursor0;
        HashMap hashMap0 = this.a;
        if(hashMap0 == null) {
            this.a = new HashMap();
        }
        else {
            hashMap0.clear();
        }
        try {
            cursor0 = this.c.getContentResolver().query(this.d, MelonMediaScanner.i, "_data=?", new String[]{s}, null);
            if(cursor0 != null) {
                v = FIN.finallyOpen$NT();
                while(true) {
                    if(!cursor0.moveToNext()) {
                        goto label_18;
                    }
                    long v1 = cursor0.getLong(0);
                    String s1 = cursor0.getString(1);
                    long v2 = cursor0.getLong(2);
                    if(s1.startsWith("/")) {
                        this.a.put((this.g ? s1.toLowerCase() : s1), new f(v1, s1, v2));
                    }
                }
            }
            return;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(null, throwable0);
            throw throwable0;
        }
        try {
        label_18:
            FIN.finallyCodeBegin$NT(v);
            cursor0.close();
            FIN.finallyCodeEnd$NT(v);
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    }

    public static void c(Context context0, String s, i i0) {
        if(context0 != null && !TextUtils.isEmpty(s)) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(s);
            MediaScannerConnection.scanFile(context0, ((String[])arrayList0.toArray(new String[0])), null, i0);
            return;
        }
        LogU.w("MelonMediaScanner", "scanFile() invalid parameter");
    }
}

