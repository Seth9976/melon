package mg;

import Tf.a;
import Tf.o;
import Tf.v;
import d5.w;
import e3.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.q;

public final class d implements jg.d {
    public final b a;
    public String b;
    public byte[] c;
    public final c d;
    public static final byte[] e;

    static {
        byte[] arr_b = {13, 10};
        q.f(arr_b, "(this as java.lang.String).getBytes(charset)");
        d.e = arr_b;
    }

    public d(c c0, d d0) {
        byte[] arr_b1;
        this.d = c0;
        if(d0 == null) {
            this.a = new b();
            return;
        }
        this.a = new b(d0.a);
        this.b = d0.b;
        byte[] arr_b = d0.c;
        if(arr_b == null) {
            arr_b1 = null;
        }
        else {
            arr_b1 = Arrays.copyOf(arr_b, arr_b.length);
            q.f(arr_b1, "java.util.Arrays.copyOf(this, size)");
        }
        this.c = arr_b1;
    }

    public final String a() {
        String s = this.b;
        if(s != null) {
            return s;
        }
        byte[] arr_b = this.c;
        if(arr_b != null) {
            String s1 = arr_b.length == 0 ? "" : new String(arr_b, a.a);
            if(s1 != null) {
                this.b = s1;
                return s1;
            }
        }
        return null;
    }

    public final StringBuilder b() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.d.b());
        stringBuilder0.append("\r\n");
        for(Object object0: this.a.a.values()) {
            stringBuilder0.append(((mg.a)object0).a);
            stringBuilder0.append(": ");
            stringBuilder0.append(((mg.a)object0).b);
            stringBuilder0.append("\r\n");
        }
        stringBuilder0.append("\r\n");
        return stringBuilder0;
    }

    // 去混淆评级： 低(30)
    public final boolean c() {
        return q.b(this.d.getVersion(), "HTTP/1.0") ? this.a.a("Connection", "keep-alive") : !this.a.a("Connection", "close");
    }

    @Override  // jg.d
    public final void d(OutputStream outputStream0) {
        byte[] arr_b2;
        byte[] arr_b;
        q.g(outputStream0, "outputStream");
        try {
            String s = this.b().toString();
            q.f(s, "getHeaderStringBuilder().toString()");
            arr_b = s.getBytes(a.a);
            q.f(arr_b, "(this as java.lang.String).getBytes(charset)");
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            d8.d.I(unsupportedEncodingException0);
            arr_b = new byte[0];
        }
        outputStream0.write(arr_b);
        byte[] arr_b1 = this.c;
        if(arr_b1 != null) {
            if(this.a.a("Transfer-Encoding", "chunked")) {
                for(int v = 0; true; v += v1) {
                    arr_b2 = d.e;
                    if(v >= arr_b1.length) {
                        break;
                    }
                    int v1 = Math.min(0x400, arr_b1.length - v);
                    String s1 = Integer.toHexString(v1);
                    q.f(s1, "Integer.toHexString(size)");
                    byte[] arr_b3 = s1.getBytes(a.a);
                    q.f(arr_b3, "(this as java.lang.String).getBytes(charset)");
                    outputStream0.write(arr_b3);
                    outputStream0.write(arr_b2);
                    outputStream0.write(arr_b1, v, v1);
                    outputStream0.write(arr_b2);
                }
                q.f("0", "Integer.toHexString(size)");
                byte[] arr_b4 = "0".getBytes(a.a);
                q.f(arr_b4, "(this as java.lang.String).getBytes(charset)");
                outputStream0.write(arr_b4);
                outputStream0.write(arr_b2);
                outputStream0.write(arr_b2);
            }
            else {
                outputStream0.write(arr_b1);
            }
        }
        outputStream0.flush();
    }

    public final void e(InputStream inputStream0) {
        byte[] arr_b;
        int v1;
        c c0 = this.d;
        q.g(inputStream0, "inputStream");
        String s = e1.b.I(inputStream0);
        if(s.length() == 0) {
            throw new IOException("Illegal start line:" + s);
        }
        try {
            c0.c(s);
        }
        catch(IllegalArgumentException unused_ex) {
            throw new IOException("Illegal start line:" + s);
        }
        while(true) {
            String s1 = e1.b.I(inputStream0);
            if(s1.length() == 0) {
                b b0 = this.a;
                if(b0.a("Transfer-Encoding", "chunked")) {
                    ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(Math.max(inputStream0.available(), 1500));
                    while(true) {
                        String s2 = e1.b.I(inputStream0);
                        if(s2.length() == 0) {
                            break;
                        }
                        String s3 = (String)o.R0(s2, new String[]{";"}, 2, 2).get(0);
                        Integer integer0 = v.s0(16, s3);
                        if(integer0 == null) {
                            throw new IOException("Chunk format error! " + s3);
                        }
                        int v = (int)integer0;
                        if(v == 0) {
                            e1.b.I(inputStream0);
                            this.c = byteArrayOutputStream0.toByteArray();
                            return;
                        }
                        e1.b.s(inputStream0, byteArrayOutputStream0, v);
                        e1.b.I(inputStream0);
                    }
                    throw new IOException("Can not read chunk size!");
                }
                String s4 = b0.b("Content-Length");
                if(s4 == null) {
                    v1 = -1;
                }
                else {
                    Integer integer1 = v.t0(s4);
                    v1 = integer1 == null ? -1 : ((int)integer1);
                }
                if(v1 < 0 && !this.c() && c0.a()) {
                    arr_b = w.N(inputStream0);
                }
                else if(v1 <= 0) {
                    arr_b = new byte[0];
                }
                else {
                    ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream(Math.max(inputStream0.available(), 1500));
                    e1.b.s(inputStream0, byteArrayOutputStream1, v1);
                    arr_b = byteArrayOutputStream1.toByteArray();
                    q.f(arr_b, "toOutputStream { copyTo(…, length) }.toByteArray()");
                }
                this.c = arr_b;
                return;
            }
            List list0 = o.R0(s1, new String[]{":"}, 2, 2);
            if(list0.size() >= 2) {
                String s5 = (String)list0.get(0);
                if(s5 != null) {
                    String s6 = o.e1(s5).toString();
                    String s7 = (String)list0.get(1);
                    if(s7 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    this.setHeader(s6, o.e1(s7).toString());
                    continue;
                }
                break;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override  // jg.d
    public final String f(String s) {
        return this.a.b(s);
    }

    @Override  // jg.d
    public final void setHeader(String s, String s1) {
        q.g(s, "name");
        q.g(s1, "value");
        this.a.getClass();
        String s2 = h.j(s);
        LinkedHashMap linkedHashMap0 = this.a.a;
        mg.a a0 = (mg.a)linkedHashMap0.get(s2);
        if(a0 != null) {
            if(!h.j(a0.a).equals(h.j(s))) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            a0.a = s;
            a0.b = s1;
            return;
        }
        linkedHashMap0.put(s2, new mg.a(s, s1));
    }

    @Override
    public final String toString() {
        String s = this.b;
        StringBuilder stringBuilder0 = this.b();
        if(s != null && s.length() != 0) {
            stringBuilder0.append(s);
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "getHeaderStringBuilder()…   }\n        }.toString()");
        return s1;
    }
}

