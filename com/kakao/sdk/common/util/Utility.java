package com.kakao.sdk.common.util;

import Tf.a;
import Tf.o;
import Tf.v;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Build;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.kakao.sdk.common.KakaoSdk.Type;
import com.kakao.sdk.common.model.SdkIdentifier;
import ie.m;
import java.io.File;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.regex.Pattern;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import te.j;
import va.e;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u001C\u0010\u0007\u001A\u00020\b2\u0014\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\nJ\u0016\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u000EJ\u000E\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\bJ\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\bJ\u000E\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\bJ.\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\bJ\u0010\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u0010\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u0018\u0010\u001A\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00020\bJ\u0016\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\bJ\u001C\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\b\u0010 \u001A\u0004\u0018\u00010\bJ\u000E\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\b¨\u0006#"}, d2 = {"Lcom/kakao/sdk/common/util/Utility;", "", "()V", "androidId", "", "context", "Landroid/content/Context;", "buildQuery", "", "params", "", "getExtras", "Lkotlinx/serialization/json/JsonObject;", "sdkType", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "getJson", "path", "getJsonArray", "Lkotlinx/serialization/json/JsonArray;", "getJsonObject", "getKAHeader", "sdkIdentifier", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "customPackageName", "getKeyHash", "getKeyHashDeprecated", "getMetadata", "key", "hasAndNotNull", "", "jsonObject", "parseQuery", "queries", "uriPathToFilePath", "uri", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Utility {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Type.values().length];
            try {
                arr_v[Type.RX_KOTLIN.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Utility INSTANCE;

    static {
        Utility.INSTANCE = new Utility();
    }

    @SuppressLint({"HardwareIds"})
    @NotNull
    public final byte[] androidId(@NotNull Context context0) {
        q.g(context0, "context");
        try {
            String s = Settings.Secure.getString(context0.getContentResolver(), "android_id");
            q.f(s, "androidId");
            Pattern pattern0 = Pattern.compile("[0\\s]");
            q.f(pattern0, "compile(...)");
            String s1 = pattern0.matcher(s).replaceAll("");
            q.f(s1, "replaceAll(...)");
            MessageDigest messageDigest0 = MessageDigest.getInstance("SHA-256");
            messageDigest0.reset();
            byte[] arr_b = ("SDK-" + s1).getBytes(a.a);
            q.f(arr_b, "getBytes(...)");
            messageDigest0.update(arr_b);
            byte[] arr_b1 = messageDigest0.digest();
            q.f(arr_b1, "{\n            val androi…    md.digest()\n        }");
            return arr_b1;
        }
        catch(Exception unused_ex) {
            byte[] arr_b2 = ("xxxx" + Build.PRODUCT + "a23456789012345bcdefg").getBytes(a.a);
            q.f(arr_b2, "getBytes(...)");
            return arr_b2;
        }
    }

    @NotNull
    public final String buildQuery(@Nullable Map map0) {
        if(map0 != null && !map0.isEmpty()) {
            ArrayList arrayList0 = new ArrayList(map0.size());
            for(Object object0: map0.entrySet()) {
                arrayList0.add(((String)((Map.Entry)object0).getKey()) + "=" + ((String)((Map.Entry)object0).getValue()));
            }
            Iterator iterator1 = arrayList0.iterator();
            if(!iterator1.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can\'t be reduced.");
            }
            String s;
            for(s = iterator1.next(); iterator1.hasNext(); s = e.c(s, "&", ((String)object1))) {
                Object object1 = iterator1.next();
            }
            return s;
        }
        return "";
    }

    @NotNull
    public final JsonObject getExtras(@NotNull Context context0, @NotNull Type kakaoSdk$Type0) {
        q.g(context0, "context");
        q.g(kakaoSdk$Type0, "sdkType");
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder0, "appPkg", "com.iloen.melon");
        JsonElementBuildersKt.put(jsonObjectBuilder0, "keyHash", Utility.INSTANCE.getKeyHash(context0));
        JsonElementBuildersKt.put(jsonObjectBuilder0, "KA", Utility.getKAHeader$default(Utility.INSTANCE, context0, kakaoSdk$Type0, null, null, 12, null));
        return jsonObjectBuilder0.build();
    }

    @NotNull
    public final String getJson(@NotNull String s) {
        q.g(s, "path");
        ClassLoader classLoader0 = Utility.class.getClassLoader();
        classLoader0.getClass();
        return new String(j.B(new File(classLoader0.getResource(s).getPath())), a.a);
    }

    @NotNull
    public final JsonArray getJsonArray(@NotNull String s) {
        q.g(s, "path");
        String s1 = this.getJson(s);
        Json json0 = KakaoJson.INSTANCE.getJson();
        json0.getSerializersModule();
        return (JsonArray)json0.decodeFromString(JsonArray.Companion.serializer(), s1);
    }

    @NotNull
    public final JsonObject getJsonObject(@NotNull String s) {
        q.g(s, "path");
        String s1 = this.getJson(s);
        Json json0 = KakaoJson.INSTANCE.getJson();
        json0.getSerializersModule();
        return (JsonObject)json0.decodeFromString(JsonObject.Companion.serializer(), s1);
    }

    @NotNull
    public final String getKAHeader(@NotNull Context context0, @NotNull Type kakaoSdk$Type0, @Nullable SdkIdentifier sdkIdentifier0, @Nullable String s) {
        q.g(context0, "context");
        q.g(kakaoSdk$Type0, "sdkType");
        int v = Build.VERSION.SDK_INT;
        String s1 = v < 33 ? context0.getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName : Gd.e.a(context0.getPackageManager(), "com.iloen.melon", Gd.e.b()).versionName;
        String s2 = WhenMappings.$EnumSwitchMapping$0[kakaoSdk$Type0.ordinal()] == 1 ? "rx-kotlin" : "kotlin";
        String s3 = Locale.getDefault().getLanguage();
        q.f(s3, "getDefault().language");
        Locale locale0 = Locale.ROOT;
        String s4 = s3.toLowerCase(locale0);
        q.f(s4, "toLowerCase(...)");
        String s5 = Locale.getDefault().getCountry();
        q.f(s5, "getDefault().country");
        String s6 = s5.toUpperCase(locale0);
        q.f(s6, "toUpperCase(...)");
        String s7 = this.getKeyHash(context0);
        String s8 = Build.MODEL;
        q.f(s8, "MODEL");
        Locale locale1 = Locale.US;
        q.f(locale1, "US");
        String s9 = s8.toUpperCase(locale1);
        q.f(s9, "toUpperCase(...)");
        Pattern pattern0 = Pattern.compile("[^\\p{ASCII}]");
        q.f(pattern0, "compile(...)");
        String s10 = pattern0.matcher(s9).replaceAll("*");
        q.f(s10, "replaceAll(...)");
        Pattern pattern1 = Pattern.compile("\\s");
        q.f(pattern1, "compile(...)");
        String s11 = pattern1.matcher(s10).replaceAll("-");
        q.f(s11, "replaceAll(...)");
        String s12 = String.format("%s/%s %s/%s %s/android-%s %s/%s-%s %s/%s %s/%s %s/%s %s/%s", Arrays.copyOf(new Object[]{"sdk", "2.21.4", "sdk_type", s2, "os", v, "lang", s4, s6, "origin", s7, "device", s11, "android_pkg", (s == null ? "com.iloen.melon" : s), "app_ver", s1}, 17));
        if(sdkIdentifier0 != null) {
            String s13 = sdkIdentifier0.getIdentifiers();
            if(s13 != null) {
                String s14 = s12 + s13;
                return s14 == null ? s12 : s14;
            }
        }
        return s12;
    }

    public static String getKAHeader$default(Utility utility0, Context context0, Type kakaoSdk$Type0, SdkIdentifier sdkIdentifier0, String s, int v, Object object0) {
        if((v & 4) != 0) {
            sdkIdentifier0 = null;
        }
        if((v & 8) != 0) {
            s = null;
        }
        return utility0.getKAHeader(context0, kakaoSdk$Type0, sdkIdentifier0, s);
    }

    @TargetApi(28)
    @NotNull
    public final String getKeyHash(@NotNull Context context0) {
        q.g(context0, "context");
        return this.getKeyHashDeprecated(context0);
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    @NotNull
    public final String getKeyHashDeprecated(@NotNull Context context0) {
        q.g(context0, "context");
        Signature[] arr_signature = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0x40).signatures;
        if(arr_signature == null) {
            arr_signature = new Signature[0];
        }
        if(arr_signature.length <= 0) {
            throw new IllegalStateException();
        }
        Signature signature0 = arr_signature[0];
        MessageDigest messageDigest0 = MessageDigest.getInstance("SHA");
        messageDigest0.update(signature0.toByteArray());
        String s = Base64.encodeToString(messageDigest0.digest(), 2);
        q.f(s, "encodeToString(md.digest(), Base64.NO_WRAP)");
        return s;
    }

    @Nullable
    public final String getMetadata(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "key");
        ApplicationInfo applicationInfo0 = Build.VERSION.SDK_INT < 33 ? context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80) : com.kakao.sdk.common.util.a.b(context0.getPackageManager(), "com.iloen.melon", com.kakao.sdk.common.util.a.c());
        q.f(applicationInfo0, "if (Build.VERSION.SDK_IN…A\n            )\n        }");
        return applicationInfo0.metaData.getString(s);
    }

    public final boolean hasAndNotNull(@NotNull JsonObject jsonObject0, @NotNull String s) {
        q.g(jsonObject0, "jsonObject");
        q.g(s, "key");
        return jsonObject0.containsKey(s) && !(jsonObject0.get(s) instanceof JsonNull);
    }

    @NotNull
    public final Map parseQuery(@Nullable String s) {
        if(s == null) {
            return x.a;
        }
        Iterable iterable0 = o.R0(s, new String[]{"&"}, 0, 6);
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(o.R0(((String)object0), new String[]{"="}, 0, 6));
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            if(((List)object1).size() > 1) {
                arrayList1.add(object1);
            }
        }
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
        for(Object object2: arrayList1) {
            arrayList2.add(new m(((List)object2).get(0), ((List)object2).get(1)));
        }
        Map map0 = new LinkedHashMap();
        for(Object object3: arrayList2) {
            String s1 = URLDecoder.decode(((String)((m)object3).b), "UTF-8");
            q.f(s1, "decode(pair.second, \"UTF-8\")");
            map0.put(((m)object3).a, s1);
        }
        return map0;
    }

    @NotNull
    public final String uriPathToFilePath(@NotNull String s) {
        q.g(s, "uri");
        return v.p0(o.N0(s, "/"), "/", "_");
    }
}

