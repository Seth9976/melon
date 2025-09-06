package com.facebook.login;

import Ae.f;
import Ce.c;
import Ce.g;
import Tf.a;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.regex.Pattern;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0007J\u0018\u0010\t\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000BH\u0007J\b\u0010\f\u001A\u00020\u0006H\u0007J\u0012\u0010\r\u001A\u00020\u000E2\b\u0010\b\u001A\u0004\u0018\u00010\u0006H\u0007¨\u0006\u000F"}, d2 = {"Lcom/facebook/login/PKCEUtil;", "", "()V", "createCodeExchangeRequest", "Lcom/facebook/GraphRequest;", "authorizationCode", "", "redirectUri", "codeVerifier", "generateCodeChallenge", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "generateCodeVerifier", "isValidCodeVerifier", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PKCEUtil {
    @NotNull
    public static final PKCEUtil INSTANCE;

    static {
        PKCEUtil.INSTANCE = new PKCEUtil();
    }

    @NotNull
    public static final GraphRequest createCodeExchangeRequest(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "authorizationCode");
        q.g(s1, "redirectUri");
        q.g(s2, "codeVerifier");
        Bundle bundle0 = new Bundle();
        bundle0.putString("code", s);
        bundle0.putString("client_id", FacebookSdk.getApplicationId());
        bundle0.putString("redirect_uri", s1);
        bundle0.putString("code_verifier", s2);
        GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(null, "oauth/access_token", null);
        graphRequest0.setHttpMethod(HttpMethod.GET);
        graphRequest0.setParameters(bundle0);
        return graphRequest0;
    }

    @NotNull
    public static final String generateCodeChallenge(@NotNull String s, @NotNull CodeChallengeMethod codeChallengeMethod0) {
        q.g(s, "codeVerifier");
        q.g(codeChallengeMethod0, "codeChallengeMethod");
        if(PKCEUtil.isValidCodeVerifier(s)) {
            if(codeChallengeMethod0 == CodeChallengeMethod.PLAIN) {
                return s;
            }
            try {
                byte[] arr_b = s.getBytes(a.b);
                q.f(arr_b, "this as java.lang.String).getBytes(charset)");
                MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
                messageDigest0.update(arr_b, 0, arr_b.length);
                String s1 = Base64.encodeToString(messageDigest0.digest(), 11);
                q.f(s1, "{\n      // try to genera… or Base64.NO_WRAP)\n    }");
                return s1;
            }
            catch(Exception exception0) {
                throw new FacebookException(exception0);
            }
        }
        throw new FacebookException("Invalid Code Verifier.");
    }

    @NotNull
    public static final String generateCodeVerifier() {
        int v = P4.a.y(new g(43, 0x80, 1));  // 初始化器: LCe/e;-><init>(III)V
        ArrayList arrayList0 = p.z0(Character.valueOf('~'), p.z0(Character.valueOf('_'), p.z0(Character.valueOf('.'), p.z0(Character.valueOf('-'), p.A0(p.x0(new c('a', 'z'), new c('A', 'Z')), new c('0', '9'))))));  // 初始化器: LCe/a;-><init>(CC)V / 初始化器: LCe/a;-><init>(CC)V / 初始化器: LCe/a;-><init>(CC)V
        ArrayList arrayList1 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            Character character0 = (Character)p.B0(arrayList0, f.a);
            character0.getClass();
            arrayList1.add(character0);
        }
        return p.q0(arrayList1, "", null, null, null, 62);
    }

    public static final boolean isValidCodeVerifier(@Nullable String s) {
        if(s != null && s.length() != 0 && s.length() >= 43 && s.length() <= 0x80) {
            Pattern pattern0 = Pattern.compile("^[-._~A-Za-z0-9]+$");
            q.f(pattern0, "compile(...)");
            return pattern0.matcher(s).matches();
        }
        return false;
    }
}

