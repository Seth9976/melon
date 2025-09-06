package e3;

import H6.e;
import I6.Q;
import I6.V;
import I6.p0;
import U4.x;
import android.media.MediaFormat;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public abstract class b {
    public static final Object a;

    static {
        b.a = new Object();
    }

    public static Uri A(String s, String s1) {
        return Uri.parse(b.z(s, s1));
    }

    public static void B(MediaFormat mediaFormat0, List list0) {
        for(int v = 0; v < list0.size(); ++v) {
            mediaFormat0.setByteBuffer("csd-" + v, ByteBuffer.wrap(((byte[])list0.get(v))));
        }
    }

    public static ArrayList C(Collection collection0, e e0) {
        ArrayList arrayList0 = new ArrayList(collection0.size());
        for(Object object0: collection0) {
            arrayList0.add(((Bundle)e0.apply(object0)));
        }
        return arrayList0;
    }

    public static void D(String s, String s1) {
        synchronized(b.a) {
            Log.w(s, b.a(s1, null));
        }
    }

    public static void E(String s, String s1, Throwable throwable0) {
        synchronized(b.a) {
            Log.w(s, b.a(s1, throwable0));
        }
    }

    public static String a(String s, Throwable throwable0) {
        CharSequence charSequence0;
        if(throwable0 == null) {
            charSequence0 = null;
        }
        else {
            Object object0 = b.a;
            __monitor_enter(object0);
            Throwable throwable1 = throwable0;
            try {
                while(true) {
                    if(throwable1 == null) {
                        charSequence0 = Log.getStackTraceString(throwable0).trim().replace("\t", "    ");
                        break;
                    }
                    if(throwable1 instanceof UnknownHostException) {
                        charSequence0 = "UnknownHostException (no network)";
                        break;
                    }
                    throwable1 = throwable1.getCause();
                }
            }
            finally {
                __monitor_exit(object0);
            }
        }
        if(!TextUtils.isEmpty(charSequence0)) {
            StringBuilder stringBuilder0 = x.p(s, "\n  ");
            stringBuilder0.append(((String)charSequence0).replace("\n", "\n  "));
            stringBuilder0.append('\n');
            return stringBuilder0.toString();
        }
        return s;
    }

    public static void b(int v, int v1) {
        GLES20.glBindTexture(v, v1);
        b.e();
        GLES20.glTexParameteri(v, 0x2800, 0x2601);
        b.e();
        GLES20.glTexParameteri(v, 0x2801, 0x2601);
        b.e();
        GLES20.glTexParameteri(v, 0x2802, 0x812F);
        b.e();
        GLES20.glTexParameteri(v, 0x2803, 0x812F);
        b.e();
    }

    public static void c(boolean z) {
        if(!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void d(boolean z, String s) {
        if(!z) {
            throw new IllegalArgumentException(String.valueOf(s));
        }
    }

    public static void e() {
        StringBuilder stringBuilder0 = new StringBuilder();
        boolean z = false;
        int v;
        while((v = GLES20.glGetError()) != 0) {
            if(z) {
                stringBuilder0.append('\n');
            }
            String s = GLU.gluErrorString(v);
            if(s == null) {
                s = "error code: 0x" + Integer.toHexString(v);
            }
            stringBuilder0.append("glError: ");
            stringBuilder0.append(s);
            z = true;
        }
        if(z) {
            throw new i(stringBuilder0.toString());  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
        }
    }

    public static void f(String s, boolean z) {
        if(!z) {
            throw new i(s);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
        }
    }

    public static void g(int v, int v1) {
        if(v < 0 || v >= v1) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void h(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s);
        }
    }

    public static void i(String s, boolean z) {
        if(!z) {
            throw new IllegalStateException(String.valueOf(s));
        }
    }

    public static void j(boolean z) {
        if(!z) {
            throw new IllegalStateException();
        }
    }

    public static void k(Object object0) {
        if(object0 == null) {
            throw new IllegalStateException();
        }
    }

    public static void l(Object object0, String s) {
        if(object0 == null) {
            throw new IllegalStateException(s);
        }
    }

    public static FloatBuffer m(float[] arr_f) {
        return (FloatBuffer)ByteBuffer.allocateDirect(arr_f.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(arr_f).flip();
    }

    public static void n(Exception exception0, String s, String s1) {
        synchronized(b.a) {
            Log.d(s, b.a(s1, exception0));
        }
    }

    public static void o(String s, String s1) {
        synchronized(b.a) {
            Log.d(s, b.a(s1, null));
        }
    }

    public static void p(String s, String s1) {
        synchronized(b.a) {
            Log.e(s, b.a(s1, null));
        }
    }

    public static void q(String s, String s1, Throwable throwable0) {
        synchronized(b.a) {
            Log.e(s, b.a(s1, throwable0));
        }
    }

    public static p0 r(e e0, List list0) {
        Q q0 = V.o();
        for(int v = 0; v < list0.size(); ++v) {
            Bundle bundle0 = (Bundle)list0.get(v);
            bundle0.getClass();
            q0.a(e0.apply(bundle0));
        }
        return q0.g();
    }

    public static String s(XmlPullParser xmlPullParser0, String s) {
        int v = xmlPullParser0.getAttributeCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(xmlPullParser0.getAttributeName(v1).equals(s)) {
                return xmlPullParser0.getAttributeValue(v1);
            }
        }
        return null;
    }

    public static int[] t(String s) {
        int v5;
        int[] arr_v = new int[4];
        if(TextUtils.isEmpty(s)) {
            arr_v[0] = -1;
            return arr_v;
        }
        int v = s.length();
        int v1 = s.indexOf(35);
        if(v1 != -1) {
            v = v1;
        }
        int v2 = s.indexOf(0x3F);
        v2 = v2 != -1 && v2 <= v ? s.indexOf(0x3F) : v;
        int v3 = s.indexOf(0x2F);
        int v4 = s.indexOf(58) <= (v3 != -1 && v3 <= v2 ? s.indexOf(0x2F) : v2) ? s.indexOf(58) : -1;
        if(v4 + 2 >= v2 || s.charAt(v4 + 1) != 0x2F || s.charAt(v4 + 2) != 0x2F) {
            v5 = v4 + 1;
        }
        else {
            v5 = s.indexOf(0x2F, v4 + 3);
            if(v5 == -1 || v5 > v2) {
                v5 = v2;
            }
        }
        arr_v[0] = v4;
        arr_v[1] = v5;
        arr_v[2] = v2;
        arr_v[3] = v;
        return arr_v;
    }

    public static void u(String s, String s1) {
        synchronized(b.a) {
            Log.i(s, b.a(s1, null));
        }
    }

    public static boolean v(XmlPullParser xmlPullParser0, String s) {
        return xmlPullParser0.getEventType() == 3 && xmlPullParser0.getName().equals(s);
    }

    public static boolean w(XmlPullParser xmlPullParser0, String s) {
        return xmlPullParser0.getEventType() == 2 && xmlPullParser0.getName().equals(s);
    }

    public static void x(MediaFormat mediaFormat0, String s, int v) {
        if(v != -1) {
            mediaFormat0.setInteger(s, v);
        }
    }

    public static String y(StringBuilder stringBuilder0, int v, int v1) {
        int v5;
        int v4;
        if(v >= v1) {
            return stringBuilder0.toString();
        }
        if(stringBuilder0.charAt(v) == 0x2F) {
            ++v;
        }
        int v2 = v;
        int v3 = v2;
        while(v2 <= v1) {
            if(v2 == v1) {
                v4 = v2;
            }
            else if(stringBuilder0.charAt(v2) == 0x2F) {
                v4 = v2 + 1;
            }
            else {
                goto label_26;
            }
            if(v2 != v3 + 1 || stringBuilder0.charAt(v3) != 46) {
                if(v2 != v3 + 2 || stringBuilder0.charAt(v3) != 46 || stringBuilder0.charAt(v3 + 1) != 46) {
                    v5 = v2 + 1;
                }
                else {
                    v5 = stringBuilder0.lastIndexOf("/", v3 - 2) + 1;
                    int v6 = v5 <= v ? v : v5;
                    stringBuilder0.delete(v6, v4);
                    v1 -= v4 - v6;
                }
                v3 = v5;
            }
            else {
                stringBuilder0.delete(v3, v4);
                v1 -= v4 - v3;
            }
            v2 = v3;
            continue;
        label_26:
            ++v2;
        }
        return stringBuilder0.toString();
    }

    public static String z(String s, String s1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(s == null) {
            s = "";
        }
        if(s1 == null) {
            s1 = "";
        }
        int[] arr_v = b.t(s1);
        if(arr_v[0] != -1) {
            stringBuilder0.append(s1);
            b.y(stringBuilder0, arr_v[1], arr_v[2]);
            return stringBuilder0.toString();
        }
        int[] arr_v1 = b.t(s);
        if(arr_v[3] == 0) {
            stringBuilder0.append(s, 0, arr_v1[3]);
            stringBuilder0.append(s1);
            return stringBuilder0.toString();
        }
        if(arr_v[2] == 0) {
            stringBuilder0.append(s, 0, arr_v1[2]);
            stringBuilder0.append(s1);
            return stringBuilder0.toString();
        }
        if(arr_v[1] != 0) {
            int v = arr_v1[0] + 1;
            stringBuilder0.append(s, 0, v);
            stringBuilder0.append(s1);
            return b.y(stringBuilder0, arr_v[1] + v, v + arr_v[2]);
        }
        if(s1.charAt(0) == 0x2F) {
            stringBuilder0.append(s, 0, arr_v1[1]);
            stringBuilder0.append(s1);
            int v1 = arr_v1[1];
            return b.y(stringBuilder0, v1, arr_v[2] + v1);
        }
        int v2 = arr_v1[0] + 2;
        int v3 = arr_v1[1];
        if(v2 < v3 && v3 == arr_v1[2]) {
            stringBuilder0.append(s, 0, v3);
            stringBuilder0.append('/');
            stringBuilder0.append(s1);
            int v4 = arr_v1[1];
            return b.y(stringBuilder0, v4, arr_v[2] + v4 + 1);
        }
        int v5 = s.lastIndexOf(0x2F, arr_v1[2] - 1);
        int v6 = v5 == -1 ? arr_v1[1] : v5 + 1;
        stringBuilder0.append(s, 0, v6);
        stringBuilder0.append(s1);
        return b.y(stringBuilder0, arr_v1[1], v6 + arr_v[2]);
    }
}

