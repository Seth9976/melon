package com.facebook.internal.security;

import I5.a;
import Tf.v;
import android.util.Base64;
import android.util.Log;
import com.facebook.FacebookSdk;
import df.d;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0004H\u0007J\u0012\u0010\r\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000E\u001A\u00020\u0004H\u0007J \u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0004H\u0007R\u0014\u0010\u0003\u001A\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/security/OidcSecurityUtil;", "", "()V", "OPENID_KEYS_PATH", "", "getOPENID_KEYS_PATH", "()Ljava/lang/String;", "SIGNATURE_ALGORITHM_SHA256", "TIMEOUT_IN_MILLISECONDS", "", "getPublicKeyFromString", "Ljava/security/PublicKey;", "key", "getRawKeyFromEndPoint", "kid", "verify", "", "publicKey", "data", "signature", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class OidcSecurityUtil {
    @NotNull
    public static final OidcSecurityUtil INSTANCE = null;
    @NotNull
    private static final String OPENID_KEYS_PATH = null;
    @NotNull
    public static final String SIGNATURE_ALGORITHM_SHA256 = "SHA256withRSA";
    public static final long TIMEOUT_IN_MILLISECONDS = 5000L;

    static {
        OidcSecurityUtil.INSTANCE = new OidcSecurityUtil();
        OidcSecurityUtil.OPENID_KEYS_PATH = "/.well-known/oauth/openid/keys/";
    }

    public static void a(URL uRL0, H h0, String s, ReentrantLock reentrantLock0, Condition condition0) {
        OidcSecurityUtil.getRawKeyFromEndPoint$lambda$1(uRL0, h0, s, reentrantLock0, condition0);
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String getOPENID_KEYS_PATH() {
        return "/.well-known/oauth/openid/keys/";
    }

    @NotNull
    public static final PublicKey getPublicKeyFromString(@NotNull String s) {
        q.g(s, "key");
        byte[] arr_b = Base64.decode(v.p0(v.p0(v.p0(s, "\n", ""), "-----BEGIN PUBLIC KEY-----", ""), "-----END PUBLIC KEY-----", ""), 0);
        q.f(arr_b, "decode(pubKeyString, Base64.DEFAULT)");
        X509EncodedKeySpec x509EncodedKeySpec0 = new X509EncodedKeySpec(arr_b);
        PublicKey publicKey0 = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec0);
        q.f(publicKey0, "kf.generatePublic(x509publicKey)");
        return publicKey0;
    }

    @Nullable
    public static final String getRawKeyFromEndPoint(@NotNull String s) {
        q.g(s, "kid");
        URL uRL0 = new URL("https", "www." + FacebookSdk.getFacebookDomain(), "/.well-known/oauth/openid/keys/");
        ReentrantLock reentrantLock0 = new ReentrantLock();
        Condition condition0 = reentrantLock0.newCondition();
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        FacebookSdk.getExecutor().execute(new a(uRL0, h0, s, reentrantLock0, condition0, 0));
        reentrantLock0.lock();
        try {
            condition0.await(5000L, TimeUnit.MILLISECONDS);
        }
        finally {
            reentrantLock0.unlock();
        }
        return (String)h0.a;
    }

    private static final void getRawKeyFromEndPoint$lambda$1(URL uRL0, H h0, String s, ReentrantLock reentrantLock0, Condition condition0) {
        q.g(uRL0, "$openIdKeyUrl");
        q.g(h0, "$result");
        q.g(s, "$kid");
        q.g(reentrantLock0, "$lock");
        URLConnection uRLConnection0 = uRL0.openConnection();
        q.e(uRLConnection0, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection0 = (HttpURLConnection)uRLConnection0;
        try {
            try {
                InputStream inputStream0 = httpURLConnection0.getInputStream();
                q.f(inputStream0, "connection.inputStream");
                String s1 = d.F(new BufferedReader(new InputStreamReader(inputStream0, Tf.a.a), 0x2000));
                httpURLConnection0.getInputStream().close();
                h0.a = new JSONObject(s1).optString(s);
                goto label_37;
            }
            catch(Exception exception0) {
            }
            String s2 = exception0.getMessage();
            if(s2 == null) {
                s2 = "Error getting public key";
            }
            Log.d("com.facebook.internal.security.OidcSecurityUtil", s2);
        }
        catch(Throwable throwable0) {
            goto label_28;
        }
        httpURLConnection0.disconnect();
        reentrantLock0.lock();
        try {
            condition0.signal();
        }
        catch(Throwable throwable1) {
            reentrantLock0.unlock();
            throw throwable1;
        }
        reentrantLock0.unlock();
        return;
    label_28:
        httpURLConnection0.disconnect();
        reentrantLock0.lock();
        try {
            condition0.signal();
        }
        catch(Throwable throwable2) {
            reentrantLock0.unlock();
            throw throwable2;
        }
        reentrantLock0.unlock();
        throw throwable0;
    label_37:
        httpURLConnection0.disconnect();
        reentrantLock0.lock();
        try {
            condition0.signal();
        }
        catch(Throwable throwable3) {
            reentrantLock0.unlock();
            throw throwable3;
        }
        reentrantLock0.unlock();
    }

    public static final boolean verify(@NotNull PublicKey publicKey0, @NotNull String s, @NotNull String s1) {
        q.g(publicKey0, "publicKey");
        q.g(s, "data");
        q.g(s1, "signature");
        try {
            Signature signature0 = Signature.getInstance("SHA256withRSA");
            signature0.initVerify(publicKey0);
            byte[] arr_b = s.getBytes(Tf.a.a);
            q.f(arr_b, "this as java.lang.String).getBytes(charset)");
            signature0.update(arr_b);
            byte[] arr_b1 = Base64.decode(s1, 8);
            q.f(arr_b1, "decode(signature, Base64.URL_SAFE)");
            return signature0.verify(arr_b1);
        }
        catch(Exception unused_ex) {
            return false;
        }
    }
}

