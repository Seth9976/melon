package k9;

import E9.w;
import android.database.sqlite.SQLiteConstraintException;
import androidx.room.A;
import androidx.room.H;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.response.McachePathRes.RESPONSE.ContentsInfo;
import com.iloen.melon.net.v4x.response.McachePathRes.RESPONSE.GetPathInfo;
import com.iloen.melon.net.v4x.response.McachePathRes.RESPONSE;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.premium.PremiumDatabase;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.q;
import ld.j;
import o9.a;
import o9.b;

public final class c {
    public HashMap a;
    public PremiumDatabase b;

    public final void a(RESPONSE mcachePathRes$RESPONSE0, String s, String s1, String s2, String s3, String s4) {
        LogU.d("ContentsManager", "add()");
        PremiumContentsEntity premiumContentsEntity0 = new PremiumContentsEntity();
        GetPathInfo mcachePathRes$RESPONSE$GetPathInfo0 = mcachePathRes$RESPONSE0.getpathinfo;
        ContentsInfo mcachePathRes$RESPONSE$ContentsInfo0 = (ContentsInfo)mcachePathRes$RESPONSE0.contentsInfo.get(0);
        String s5 = mcachePathRes$RESPONSE$GetPathInfo0.cid;
        q.g(s5, "<set-?>");
        premiumContentsEntity0.b = s5;
        String s6 = mcachePathRes$RESPONSE$ContentsInfo0.ctype;
        q.g(s6, "<set-?>");
        premiumContentsEntity0.c = s6;
        String s7 = mcachePathRes$RESPONSE$GetPathInfo0.metatype;
        q.g(s7, "<set-?>");
        premiumContentsEntity0.d = s7;
        String s8 = mcachePathRes$RESPONSE$GetPathInfo0.bitrate;
        q.g(s8, "<set-?>");
        premiumContentsEntity0.e = s8;
        q.g(s, "<set-?>");
        premiumContentsEntity0.f = s;
        String s9 = mcachePathRes$RESPONSE$GetPathInfo0.c;
        q.g(s9, "<set-?>");
        premiumContentsEntity0.g = s9;
        String s10 = mcachePathRes$RESPONSE$GetPathInfo0.fileupdate;
        q.g(s10, "<set-?>");
        premiumContentsEntity0.h = s10;
        String s11 = mcachePathRes$RESPONSE$GetPathInfo0.filesize;
        q.g(s11, "<set-?>");
        premiumContentsEntity0.i = s11;
        q.g(s1, "<set-?>");
        premiumContentsEntity0.j = s1;
        premiumContentsEntity0.k = s2;
        premiumContentsEntity0.l = s3;
        premiumContentsEntity0.m = s4;
        premiumContentsEntity0.n = Boolean.valueOf(mcachePathRes$RESPONSE$ContentsInfo0.isFree);
        String s12 = premiumContentsEntity0.b;
        if("1".equals(premiumContentsEntity0.c)) {
            this.a.put(s12, premiumContentsEntity0);
            b b0 = this.f();
            b0.getClass();
            w.N(((H)b0.a), false, true, new a(b0, premiumContentsEntity0, 0));
        }
    }

    public static PremiumContentsEntity b(PremiumContentsEntity premiumContentsEntity0) {
        if(premiumContentsEntity0 == null) {
            return null;
        }
        PremiumContentsEntity premiumContentsEntity1 = new PremiumContentsEntity();
        premiumContentsEntity1.a = premiumContentsEntity0.a;
        String s = premiumContentsEntity0.b;
        q.g(s, "<set-?>");
        premiumContentsEntity1.b = s;
        String s1 = premiumContentsEntity0.c;
        q.g(s1, "<set-?>");
        premiumContentsEntity1.c = s1;
        String s2 = premiumContentsEntity0.d;
        q.g(s2, "<set-?>");
        premiumContentsEntity1.d = s2;
        String s3 = premiumContentsEntity0.e;
        q.g(s3, "<set-?>");
        premiumContentsEntity1.e = s3;
        String s4 = premiumContentsEntity0.f;
        q.g(s4, "<set-?>");
        premiumContentsEntity1.f = s4;
        String s5 = premiumContentsEntity0.g;
        q.g(s5, "<set-?>");
        premiumContentsEntity1.g = s5;
        String s6 = premiumContentsEntity0.h;
        q.g(s6, "<set-?>");
        premiumContentsEntity1.h = s6;
        String s7 = premiumContentsEntity0.i;
        q.g(s7, "<set-?>");
        premiumContentsEntity1.i = s7;
        String s8 = premiumContentsEntity0.j;
        q.g(s8, "<set-?>");
        premiumContentsEntity1.j = s8;
        premiumContentsEntity1.k = premiumContentsEntity0.k;
        premiumContentsEntity1.l = premiumContentsEntity0.l;
        premiumContentsEntity1.m = premiumContentsEntity0.m;
        premiumContentsEntity1.n = premiumContentsEntity0.n;
        return premiumContentsEntity1;
    }

    public static void c(File file0) {
        File[] arr_file = file0.listFiles();
        if(arr_file != null) {
            for(int v = 0; v < arr_file.length; ++v) {
                c.c(arr_file[v]);
            }
        }
        file0.delete();
    }

    public static String d(File file0, File file1, String s) {
        if(s == null || s.isEmpty()) {
            return null;
        }
        String[] arr_s = s.split("/");
        String[] arr_s1 = arr_s.length <= 2 ? null : ((String[])Arrays.copyOfRange(arr_s, arr_s.length - 2, arr_s.length));
        boolean z = false;
        if(arr_s1 != null && arr_s1.length > 1) {
            String s1 = arr_s1[0];
            String s2 = arr_s1[1];
            File file2 = new File(file1, s1);
            File file3 = new File(file2, s2);
            File file4 = new File(new File(file0, s1), s2);
            if(!file2.exists()) {
                file2.mkdirs();
            }
            if(file3.exists()) {
                z = true;
            }
            else {
                try {
                    z = file4.renameTo(file3);
                }
                catch(Exception exception0) {
                    H0.b.v(exception0, new StringBuilder("renameOfflineMigration error: "), "ContentsManager");
                }
            }
        }
        if(z) {
            LogU.d("ContentsManager", "execColumnMigration() rename success");
            return arr_s1[1];
        }
        LogU.d("ContentsManager", "execColumnMigration() rename fail");
        return null;
    }

    public static String e(String s) {
        String[] arr_s = s.split(File.separator);
        return arr_s.length <= 0 ? "" : arr_s[arr_s.length - 1];
    }

    public final b f() {
        synchronized(this) {
            if(this.b == null) {
                A a0 = w.o(MelonAppBase.instance.getContext(), PremiumDatabase.class, "premium");
                a0.d.add(PremiumDatabase.a);
                a0.a(PremiumDatabase.b);
                a0.i = true;
                this.b = (PremiumDatabase)a0.b();
            }
            return this.b.b();
        }
    }

    public final void g() {
        LogU.d("ContentsManager", "removeAll()");
        this.a.clear();
        ((Integer)w.N(((H)this.f().a), false, true, new j(8))).getClass();
    }

    public final boolean h(PremiumContentsEntity premiumContentsEntity0) {
        int v;
        try {
            b b0 = this.f();
            b0.getClass();
            v = (int)(((Integer)w.N(((H)b0.a), false, true, new a(b0, premiumContentsEntity0, 1))));
        }
        catch(SQLiteConstraintException sQLiteConstraintException0) {
            LogU.e("ContentsManager", "cacheKey is " + premiumContentsEntity0.j);
            LogU.e("ContentsManager", sQLiteConstraintException0.toString());
            v = 0;
        }
        if(v > 0) {
            String s = premiumContentsEntity0.b;
            if("1".equals(premiumContentsEntity0.c)) {
                this.a.put(s, premiumContentsEntity0);
                return true;
            }
            return true;
        }
        return false;
    }
}

