package f9;

import android.os.Environment;
import android.text.TextUtils;
import h9.f;

public abstract class q {
    public static long a = 0x40000000L;
    public static String b = null;
    public static boolean c = false;
    public static boolean d = false;
    public static int e = 1;

    static {
        String s;
        try {
            s = Environment.getExternalStorageDirectory().getCanonicalPath();
            q.b = s + "mcache";
        }
        catch(Exception exception0) {
            s = null;
            f.j("ServerOption", exception0.toString());
        }
        if(TextUtils.isEmpty(s)) {
            try {
                q.b = Environment.getExternalStorageDirectory().getPath() + "mcache";
            }
            catch(Exception exception1) {
                f.j("ServerOption", exception1.toString());
            }
        }
    }

    public static boolean a() [...] // 潜在的解密器
}

