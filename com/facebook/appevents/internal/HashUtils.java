package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.Checksum;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import d8.d;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001A\u00020\u00062\b\u0010\r\u001A\u0004\u0018\u00010\u0006H\u0007J!\u0010\u000E\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0016H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n \b*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000B¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/internal/HashUtils;", "", "()V", "BUFFER_SIZE", "", "MD5", "", "TAG", "kotlin.jvm.PlatformType", "TRUSTED_CERTS", "", "[Ljava/lang/String;", "computeChecksum", "path", "computeChecksumWithPackageManager", "context", "Landroid/content/Context;", "nanosTimeout", "", "(Landroid/content/Context;Ljava/lang/Long;)Ljava/lang/String;", "computeFileMd5", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class HashUtils {
    private static final int BUFFER_SIZE = 0x400;
    @NotNull
    public static final HashUtils INSTANCE = null;
    @NotNull
    private static final String MD5 = "MD5";
    private static final String TAG;
    @NotNull
    private static final String[] TRUSTED_CERTS;

    static {
        HashUtils.INSTANCE = new HashUtils();
        HashUtils.TAG = "HashUtils";
        HashUtils.TRUSTED_CERTS = new String[]{"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"};
    }

    public static final String access$getTAG$p() [...] // 潜在的解密器

    @NotNull
    public static final String computeChecksum(@Nullable String s) {
        File file0 = new File(s);
        return HashUtils.INSTANCE.computeFileMd5(file0);
    }

    @Nullable
    public static final String computeChecksumWithPackageManager(@NotNull Context context0, @Nullable Long long0) {
        q.g(context0, "context");
        CertificateFactory certificateFactory0 = CertificateFactory.getInstance("X.509");
        String[] arr_s = HashUtils.TRUSTED_CERTS;
        ArrayList arrayList0 = new ArrayList(arr_s.length);
        for(int v = 0; v < arr_s.length; ++v) {
            arrayList0.add(certificateFactory0.generateCertificate(new ByteArrayInputStream(Base64.decode(arr_s[v], 0))));
        }
        ArrayList arrayList1 = p.Q0(arrayList0);
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        ReentrantLock reentrantLock0 = new ReentrantLock();
        Condition condition0 = reentrantLock0.newCondition();
        reentrantLock0.lock();
        q.f(Checksum.class.getField("TYPE_WHOLE_MD5"), "checksumClass.getField(\"TYPE_WHOLE_MD5\")");
        Integer integer0 = Checksum.TYPE_WHOLE_MD5;
        Class class0 = Class.forName("android.content.pm.PackageManager$OnChecksumsReadyListener");
        com.facebook.appevents.internal.HashUtils.computeChecksumWithPackageManager.listener.1 hashUtils$computeChecksumWithPackageManager$listener$10 = new InvocationHandler() {
            @Override
            @Nullable
            public Object invoke(@Nullable Object object0, @NotNull Method method0, @NotNull Object[] arr_object) {
                q.g(method0, "method");
                q.g(arr_object, "objects");
                try {
                    if(q.b(method0.getName(), "onChecksumsReady") && arr_object.length == 1) {
                        Object object1 = arr_object[0];
                        if(object1 instanceof List) {
                            q.e(object1, "null cannot be cast to non-null type kotlin.collections.List<*>");
                            for(Object object2: ((List)object1)) {
                                if(object2 != null) {
                                    Method method1 = object2.getClass().getMethod("getSplitName", null);
                                    q.f(method1, "c.javaClass.getMethod(\"getSplitName\")");
                                    Method method2 = object2.getClass().getMethod("getType", null);
                                    q.f(method2, "c.javaClass.getMethod(\"getType\")");
                                    if(method1.invoke(object2, null) == null && q.b(method2.invoke(object2, null), integer0)) {
                                        Method method3 = object2.getClass().getMethod("getValue", null);
                                        q.f(method3, "c.javaClass.getMethod(\"getValue\")");
                                        Object object3 = method3.invoke(object2, null);
                                        q.e(object3, "null cannot be cast to non-null type kotlin.ByteArray");
                                        h0.a = new BigInteger(1, ((byte[])object3)).toString(16);
                                        reentrantLock0.lock();
                                        try {
                                            condition0.signalAll();
                                            return null;
                                        }
                                        finally {
                                            reentrantLock0.unlock();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                catch(Throwable throwable0) {
                    Log.d("HashUtils", "Can\'t fetch checksum.", throwable0);
                }
                return null;
            }
        };
        Object object0 = Proxy.newProxyInstance(HashUtils.class.getClassLoader(), new Class[]{class0}, hashUtils$computeChecksumWithPackageManager$listener$10);
        q.f(object0, "resultChecksum: String? …       }\n              })");
        Method method0 = PackageManager.class.getMethod("requestChecksums", String.class, Boolean.TYPE, Integer.TYPE, List.class, class0);
        q.f(method0, "PackageManager::class\n  …ecksumReadyListenerClass)");
        PackageManager packageManager0 = context0.getPackageManager();
        ArrayList arrayList2 = p.Q0(arrayList1);
        method0.invoke(packageManager0, "com.iloen.melon", Boolean.FALSE, integer0, arrayList2, object0);
        if(long0 == null) {
            condition0.await();
        }
        else {
            condition0.awaitNanos(((long)long0));
        }
        String s = (String)h0.a;
        reentrantLock0.unlock();
        return s;
    }

    private final String computeFileMd5(File file0) {
        String s;
        BufferedInputStream bufferedInputStream0 = new BufferedInputStream(new FileInputStream(file0), 0x400);
        try {
            MessageDigest messageDigest0 = MessageDigest.getInstance("MD5");
            byte[] arr_b = new byte[0x400];
            do {
                int v = bufferedInputStream0.read(arr_b);
                if(v > 0) {
                    messageDigest0.update(arr_b, 0, v);
                }
            }
            while(v != -1);
            s = new BigInteger(1, messageDigest0.digest()).toString(16);
            q.f(s, "BigInteger(1, md.digest()).toString(16)");
            goto label_15;
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            d.l(bufferedInputStream0, throwable0);
            throw throwable1;
        }
    label_15:
        bufferedInputStream0.close();
        return s;
    }
}

