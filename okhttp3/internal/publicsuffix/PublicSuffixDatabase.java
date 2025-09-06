package okhttp3.internal.publicsuffix;

import Sf.n;
import Tf.o;
import d8.d;
import e.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000F\u0010\u000E\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000E\u0010\u0003J\u0017\u0010\u000F\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u000F\u0010\u0010J\u001D\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001A\u001A\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\u0012\u001A\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u001CR\u0016\u0010\u0013\u001A\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u001C¨\u0006\u001E"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "<init>", "()V", "", "domain", "", "splitDomain", "(Ljava/lang/String;)Ljava/util/List;", "domainLabels", "findMatchingRule", "(Ljava/util/List;)Ljava/util/List;", "Lie/H;", "readTheListUninterruptibly", "readTheList", "getEffectiveTldPlusOne", "(Ljava/lang/String;)Ljava/lang/String;", "", "publicSuffixListBytes", "publicSuffixExceptionListBytes", "setListBytes", "([B[B)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "[B", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PublicSuffixDatabase {
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001A\u00020\fJ)\u0010\u000E\u001A\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // This method was un-flattened
        private final String binarySearch(byte[] arr_b, byte[][] arr2_b, int v) {
            int v6;
            int v1 = arr_b.length;
            int v2 = 0;
            while(v2 < v1) {
                int v3;
                for(v3 = (v2 + v1) / 2; v3 > -1 && arr_b[v3] != 10; --v3) {
                }
                int v4 = v3 + 1;
                for(int v5 = 1; true; ++v5) {
                    v6 = v4 + v5;
                    if(arr_b[v6] == 10) {
                        break;
                    }
                }
                int v7 = v6 - v4;
                int v8 = v;
                int v9 = 0;
                int v10 = 0;
            alab1:
                while(true) {
                    for(int v11 = Util.and(arr2_b[v8][v9], ((byte)0xFF)); true; v11 = 46) {
                        int v12 = v11 - Util.and(arr_b[v4 + v10], ((byte)0xFF));
                        if(v12 != 0) {
                            break alab1;
                        }
                        ++v10;
                        ++v9;
                        if(v10 == v7) {
                            break alab1;
                        }
                        if(arr2_b[v8].length != v9) {
                            break;
                        }
                        if(v8 == arr2_b.length - 1) {
                            break alab1;
                        }
                        ++v8;
                        v9 = -1;
                    }
                }
                if(v12 >= 0) {
                    if(v12 <= 0) {
                        int v13 = v7 - v10;
                        int v14 = arr2_b[v8].length - v9;
                        for(int v15 = v8 + 1; v15 < arr2_b.length; ++v15) {
                            v14 += arr2_b[v15].length;
                        }
                        if(v14 >= v13) {
                            if(v14 <= v13) {
                                Charset charset0 = StandardCharsets.UTF_8;
                                q.f(charset0, "UTF_8");
                                return new String(arr_b, v4, v7, charset0);
                            }
                            v2 = v6 + 1;
                            continue;
                        }
                    }
                    else {
                        v2 = v6 + 1;
                        continue;
                    }
                }
                v1 = v3;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final char EXCEPTION_MARKER = '!';
    @NotNull
    private static final List PREVAILING_RULE = null;
    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    @NotNull
    private static final byte[] WILDCARD_LABEL;
    @NotNull
    private static final PublicSuffixDatabase instance;
    @NotNull
    private final AtomicBoolean listRead;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    @NotNull
    private final CountDownLatch readCompleteLatch;

    static {
        PublicSuffixDatabase.Companion = new Companion(null);
        PublicSuffixDatabase.WILDCARD_LABEL = new byte[]{42};
        PublicSuffixDatabase.PREVAILING_RULE = k.z("*");
        PublicSuffixDatabase.instance = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        this.listRead = new AtomicBoolean(false);
        this.readCompleteLatch = new CountDownLatch(1);
    }

    private final List findMatchingRule(List list0) {
        String s2;
        if(this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            }
            catch(InterruptedException unused_ex) {
                Thread.currentThread().interrupt();
            }
        }
        else {
            this.readTheListUninterruptibly();
        }
        if(this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int v = list0.size();
        byte[][] arr2_b = new byte[v][];
        for(int v1 = 0; v1 < v; ++v1) {
            String s = (String)list0.get(v1);
            Charset charset0 = StandardCharsets.UTF_8;
            q.f(charset0, "UTF_8");
            byte[] arr_b = s.getBytes(charset0);
            q.f(arr_b, "this as java.lang.String).getBytes(charset)");
            arr2_b[v1] = arr_b;
        }
        String s1 = null;
        int v2 = 0;
        while(true) {
            s2 = null;
            if(v2 >= v) {
                break;
            }
            Companion publicSuffixDatabase$Companion0 = PublicSuffixDatabase.Companion;
            byte[] arr_b1 = this.publicSuffixListBytes;
            if(arr_b1 != null) {
                String s3 = publicSuffixDatabase$Companion0.binarySearch(arr_b1, arr2_b, v2);
                if(s3 != null) {
                    s1 = s3;
                    break;
                }
                ++v2;
                continue;
            }
            q.m("publicSuffixListBytes");
            throw null;
        }
        String s4 = null;
        if(v > 1) {
            byte[][] arr2_b1 = (byte[][])arr2_b.clone();
            int v3 = arr2_b1.length - 1;
            int v4 = 0;
            while(v4 < v3) {
                arr2_b1[v4] = PublicSuffixDatabase.WILDCARD_LABEL;
                Companion publicSuffixDatabase$Companion1 = PublicSuffixDatabase.Companion;
                byte[] arr_b2 = this.publicSuffixListBytes;
                if(arr_b2 != null) {
                    String s5 = publicSuffixDatabase$Companion1.binarySearch(arr_b2, arr2_b1, v4);
                    if(s5 != null) {
                        s4 = s5;
                        break;
                    }
                    ++v4;
                    continue;
                }
                q.m("publicSuffixListBytes");
                throw null;
            }
        }
        if(s4 != null) {
            int v5 = 0;
            while(v5 < v - 1) {
                Companion publicSuffixDatabase$Companion2 = PublicSuffixDatabase.Companion;
                byte[] arr_b3 = this.publicSuffixExceptionListBytes;
                if(arr_b3 != null) {
                    String s6 = publicSuffixDatabase$Companion2.binarySearch(arr_b3, arr2_b, v5);
                    if(s6 != null) {
                        s2 = s6;
                        break;
                    }
                    ++v5;
                    continue;
                }
                q.m("publicSuffixExceptionListBytes");
                throw null;
            }
        }
        if(s2 != null) {
            return o.S0(("!" + s2), new char[]{'.'});
        }
        if(s1 == null && s4 == null) {
            return PublicSuffixDatabase.PREVAILING_RULE;
        }
        List list1 = w.a;
        List list2 = s1 == null ? list1 : o.S0(s1, new char[]{'.'});
        if(s4 != null) {
            list1 = o.S0(s4, new char[]{'.'});
        }
        return list2.size() > list1.size() ? list2 : list1;
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String s) {
        q.g(s, "domain");
        String s1 = IDN.toUnicode(s);
        q.f(s1, "unicodeDomain");
        List list0 = this.splitDomain(s1);
        List list1 = this.findMatchingRule(list0);
        if(list0.size() == list1.size() && ((String)list1.get(0)).charAt(0) != 33) {
            return null;
        }
        return ((String)list1.get(0)).charAt(0) == 33 ? n.m0(n.h0(p.c0(this.splitDomain(s)), list0.size() - list1.size()), ".") : n.m0(n.h0(p.c0(this.splitDomain(s)), list0.size() - (list1.size() + 1)), ".");
    }

    private final void readTheList() {
        byte[] arr_b1;
        byte[] arr_b;
        try {
            InputStream inputStream0 = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if(inputStream0 != null) {
                BufferedSource bufferedSource0 = Okio.buffer(new GzipSource(Okio.source(inputStream0)));
                try {
                    arr_b = bufferedSource0.readByteArray(((long)bufferedSource0.readInt()));
                    arr_b1 = bufferedSource0.readByteArray(((long)bufferedSource0.readInt()));
                }
                catch(Throwable throwable0) {
                    d.l(bufferedSource0, throwable0);
                    throw throwable0;
                }
                d.l(bufferedSource0, null);
                synchronized(this) {
                    q.d(arr_b);
                    this.publicSuffixListBytes = arr_b;
                    q.d(arr_b1);
                    this.publicSuffixExceptionListBytes = arr_b1;
                }
            }
        }
        finally {
            this.readCompleteLatch.countDown();
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z = false;
        try {
            while(true) {
                try {
                    this.readTheList();
                    goto label_10;
                }
                catch(InterruptedIOException unused_ex) {
                }
                catch(IOException iOException0) {
                    break;
                }
                Thread.interrupted();
                z = true;
            }
            Platform.Companion.get().log("Failed to read public suffix list", 5, iOException0);
            if(z) {
                goto label_11;
            }
            return;
        }
        catch(Throwable throwable0) {
            goto label_15;
        }
        goto label_11;
    label_10:
        if(z) {
        label_11:
            Thread.currentThread().interrupt();
            return;
        }
        try {
        }
        catch(Throwable throwable0) {
        label_15:
            if(z) {
                Thread.currentThread().interrupt();
            }
            throw throwable0;
        }
    }

    public final void setListBytes(@NotNull byte[] arr_b, @NotNull byte[] arr_b1) {
        q.g(arr_b, "publicSuffixListBytes");
        q.g(arr_b1, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = arr_b;
        this.publicSuffixExceptionListBytes = arr_b1;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }

    private final List splitDomain(String s) {
        List list0 = o.S0(s, new char[]{'.'});
        return q.b(p.s0(list0), "") ? p.g0(1, list0) : list0;
    }
}

