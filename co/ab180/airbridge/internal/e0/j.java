package co.ab180.airbridge.internal.e0;

import Tf.a;
import co.ab180.airbridge.internal.b.b;
import d5.n;
import d5.w;
import d8.d;
import i.n.i.b.a.s.e.M3;
import ie.o;
import ie.p;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001A\u0013\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A#\u0010\u0002\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0002\u0010\u0007\u001A\u001B\u0010\u0002\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001A\u00020\bH\u0000¢\u0006\u0004\b\u0002\u0010\t\u001A#\u0010\u0002\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0000¢\u0006\u0004\b\u0002\u0010\r\u001A\u0013\u0010\u0002\u001A\u00020\u000E*\u00020\u0001H\u0000¢\u0006\u0004\b\u0002\u0010\u000F\u001A)\u0010\u0002\u001A\u00020\u000E*\u00020\u00012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001A\u00020\u0011H\u0000¢\u0006\u0004\b\u0002\u0010\u0013\u001A\u0013\u0010\u0014\u001A\u00020\b*\u00020\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001A\u0013\u0010\u0016\u001A\u00020\b*\u00020\u0001H\u0000¢\u0006\u0004\b\u0016\u0010\u0015\u001A\u001C\u0010\u0002\u001A\u00028\u0000\"\u0006\b\u0000\u0010\u0017\u0018\u0001*\u00020\u000EH\u0080\b¢\u0006\u0004\b\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Ljava/net/URLConnection;", "Ljava/net/HttpURLConnection;", "a", "(Ljava/net/URLConnection;)Ljava/net/HttpURLConnection;", "", "key", "value", "(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;)Ljava/net/HttpURLConnection;", "", "(Ljava/net/HttpURLConnection;Z)Ljava/net/HttpURLConnection;", "", "connectTimeout", "readTimeout", "(Ljava/net/HttpURLConnection;II)Ljava/net/HttpURLConnection;", "Lco/ab180/airbridge/internal/e0/d0;", "(Ljava/net/HttpURLConnection;)Lco/ab180/airbridge/internal/e0/d0;", "bodyString", "Ljava/nio/charset/Charset;", "charset", "(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/nio/charset/Charset;)Lco/ab180/airbridge/internal/e0/d0;", "c", "(Ljava/net/HttpURLConnection;)Z", "b", "T", "(Lco/ab180/airbridge/internal/e0/d0;)Ljava/lang/Object;", "airbridge_release"}, k = 2, mv = {1, 4, 3})
public final class j {
    @NotNull
    public static final d0 a(@NotNull HttpURLConnection httpURLConnection0) {
        try {
            httpURLConnection0.setRequestMethod("GET");
            b b$b0 = co.ab180.airbridge.internal.b.e;
            b$b0.e("Client request: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} header={" + httpURLConnection0.getRequestProperties() + '}', new Object[0]);
            g0 g00 = g0.a;
            long v = g00.a();
            if(j.b(httpURLConnection0)) {
                String s = new String(w.N(httpURLConnection0.getErrorStream()), Charset.defaultCharset());
                long v1 = g00.a();
                b$b0.e("Client is failed to receive response: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} error={" + s + "} deltaTime={" + (v1 - v) + "ms}", new Object[0]);
                throw new m(httpURLConnection0.getResponseCode(), s, null, 4, null);
            }
            String s1 = new String(w.N(httpURLConnection0.getInputStream()), Charset.defaultCharset());
            long v2 = g00.a();
            b$b0.e("Client receive response: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} code={" + httpURLConnection0.getResponseCode() + "} body={" + s1 + "} deltaTime={" + (v2 - v) + "ms}", new Object[0]);
            int v3 = httpURLConnection0.getResponseCode();
            String s2 = httpURLConnection0.getResponseMessage();
            if(s2 == null) {
                s2 = "";
            }
            return new d0(v3, s2, s1);
        }
        catch(Throwable throwable0) {
        }
        o o0 = n.t(throwable0);
        Throwable throwable1 = p.a(o0);
        if(throwable1 != null && !(throwable1 instanceof m)) {
            co.ab180.airbridge.internal.b.e.f("Client is failed to receive response: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} error={" + throwable1 + '}', new Object[0]);
        }
        n.D(o0);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public static final d0 a(@NotNull HttpURLConnection httpURLConnection0, @Nullable String s, @NotNull Charset charset0) {
        byte[] arr_b;
        try {
            httpURLConnection0.setRequestMethod("POST");
            if(s == null || s.length() == 0) {
                arr_b = null;
            }
            else {
                String s1 = httpURLConnection0.getRequestProperty("Content-Encoding");
                if(s1 == null) {
                    arr_b = s.getBytes(charset0);
                }
                else if(s1.hashCode() != 0x30A95A || !s1.equals("gzip")) {
                    arr_b = s.getBytes(charset0);
                }
                else {
                    ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                    BufferedWriter bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(byteArrayOutputStream0), charset0), 0x2000);
                    try {
                        bufferedWriter0.write(s);
                    }
                    catch(Throwable throwable1) {
                        d.l(bufferedWriter0, throwable1);
                        throw throwable1;
                    }
                    bufferedWriter0.close();
                    arr_b = byteArrayOutputStream0.toByteArray();
                    byteArrayOutputStream0.close();
                }
            }
            b b$b0 = co.ab180.airbridge.internal.b.e;
            b$b0.e("Client request: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} header={" + httpURLConnection0.getRequestProperties() + "} body={" + s + "} bodySize={" + (arr_b == null ? 0 : arr_b.length) + "-byte body}", new Object[0]);
            g0 g00 = g0.a;
            long v = g00.a();
            OutputStream outputStream0 = httpURLConnection0.getOutputStream();
            if(arr_b != null) {
                try {
                    outputStream0.write(arr_b);
                }
                catch(Throwable throwable2) {
                    d.l(outputStream0, throwable2);
                    throw throwable2;
                }
            }
            d.l(outputStream0, null);
            if(j.b(httpURLConnection0)) {
                String s2 = new String(w.N(httpURLConnection0.getErrorStream()), Charset.defaultCharset());
                long v1 = g00.a();
                b$b0.e("Client receive response: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} code={" + httpURLConnection0.getResponseCode() + "} body={" + s2 + "} deltaTime={" + (v1 - v) + "ms}", new Object[0]);
                throw new m(httpURLConnection0.getResponseCode(), s2, null, 4, null);
            }
            String s3 = new String(w.N(httpURLConnection0.getInputStream()), Charset.defaultCharset());
            long v2 = g00.a();
            b$b0.e("Client receive response: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} code={" + httpURLConnection0.getResponseCode() + "} body={" + s3 + "} deltaTime={" + (v2 - v) + "ms}", new Object[0]);
            int v3 = httpURLConnection0.getResponseCode();
            String s4 = httpURLConnection0.getResponseMessage();
            if(s4 == null) {
                s4 = "";
            }
            return new d0(v3, s4, s3);
        }
        catch(Throwable throwable0) {
            o o0 = n.t(throwable0);
            Throwable throwable3 = p.a(o0);
            if(throwable3 != null && !(throwable3 instanceof m)) {
                co.ab180.airbridge.internal.b.e.f("Client is failed to receive response: method={" + httpURLConnection0.getRequestMethod() + "} url={" + httpURLConnection0.getURL() + "} error={" + throwable3 + '}', new Object[0]);
            }
            n.D(o0);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
    }

    public static d0 a(HttpURLConnection httpURLConnection0, String s, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            charset0 = a.a;
        }
        return j.a(httpURLConnection0, s, charset0);
    }

    public static final Object a(d0 d00) {
        q.g(d00, "$this$transform");
        q.k();
        throw null;
    }

    @NotNull
    public static final HttpURLConnection a(@NotNull HttpURLConnection httpURLConnection0, int v, int v1) {
        httpURLConnection0.setConnectTimeout(v);
        httpURLConnection0.setReadTimeout(v1);
        return httpURLConnection0;
    }

    @NotNull
    public static final HttpURLConnection a(@NotNull HttpURLConnection httpURLConnection0, @NotNull String s, @NotNull String s1) {
        httpURLConnection0.setRequestProperty(s, s1);
        return httpURLConnection0;
    }

    @NotNull
    public static final HttpURLConnection a(@NotNull HttpURLConnection httpURLConnection0, boolean z) {
        httpURLConnection0.setDoOutput(z);
        return httpURLConnection0;
    }

    @NotNull
    public static final HttpURLConnection a(@NotNull URLConnection uRLConnection0) {
        return (HttpURLConnection)uRLConnection0;
    }

    public static final boolean b(@NotNull HttpURLConnection httpURLConnection0) {
        return !j.c(httpURLConnection0);
    }

    public static final boolean c(@NotNull HttpURLConnection httpURLConnection0) {
        int v = httpURLConnection0.getResponseCode();
        return 200 <= v && 299 >= v;
    }
}

