package Y1;

import S1.b;
import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

public abstract class i {
    public static final long a;
    public static final Method b;

    static {
        Class class0 = String.class;
        Class class1 = Trace.class;
        if(Build.VERSION.SDK_INT < 29) {
            try {
                i.a = class1.getField("TRACE_TAG_APP").getLong(null);
                Class class2 = Long.TYPE;
                i.b = class1.getMethod("isTagEnabled", class2);
                Class class3 = Integer.TYPE;
                class1.getMethod("asyncTraceBegin", class2, class0, class3);
                class1.getMethod("asyncTraceEnd", class2, class0, class3);
                class1.getMethod("traceCounter", class2, class0, class3);
            }
            catch(Exception exception0) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", exception0);
            }
        }
    }

    public static boolean a() {
        if(Build.VERSION.SDK_INT >= 29) {
            return b.b();
        }
        try {
            return ((Boolean)i.b.invoke(null, i.a)).booleanValue();
        }
        catch(Exception unused_ex) {
            Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }
}

