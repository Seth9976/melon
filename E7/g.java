package e7;

import E1.a;
import E5.b;
import android.util.Log;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.IOException;

public final class g {
    public final FileStore a;
    public String b;
    public String c;
    public static final b d;
    public static final a e;

    static {
        g.d = new b(4);
        g.e = new a(11);
    }

    public g(FileStore fileStore0) {
        this.b = null;
        this.c = null;
        this.a = fileStore0;
    }

    public static void a(FileStore fileStore0, String s, String s1) {
        if(s != null && s1 != null) {
            try {
                fileStore0.b(s, "aqs." + s1).createNewFile();
            }
            catch(IOException iOException0) {
                Log.w("FirebaseCrashlytics", "Failed to persist App Quality Sessions session id.", iOException0);
            }
        }
    }
}

