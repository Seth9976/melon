package com.facebook.appevents;

import A5.a;
import D5.b;
import Tf.o;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import je.I;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u001F\u0010\t\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0007\u00A2\u0006\u0004\b\r\u0010\u000EJ\u007F\u0010\r\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u00062\b\u0010\u0012\u001A\u0004\u0018\u00010\u00062\b\u0010\u0013\u001A\u0004\u0018\u00010\u00062\b\u0010\u0014\u001A\u0004\u0018\u00010\u00062\b\u0010\u0015\u001A\u0004\u0018\u00010\u00062\b\u0010\u0016\u001A\u0004\u0018\u00010\u00062\b\u0010\u0017\u001A\u0004\u0018\u00010\u00062\b\u0010\u0018\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b\r\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u0006H\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u001F\u0010\u001DJ\u000F\u0010 \u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b \u0010\u0003J\u0019\u0010!\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002\u00A2\u0006\u0004\b!\u0010\u000EJ#\u0010#\u001A\u00020\u00042\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"H\u0007\u00A2\u0006\u0004\b#\u0010$J\u001F\u0010\'\u001A\u00020\u00062\u0006\u0010%\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010*\u001A\u00020)2\u0006\u0010&\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b*\u0010+R\u001C\u0010-\u001A\n ,*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u0010.R\u0014\u00100\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00102\u001A\u0002018\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001A\u0002048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001A\u0002078\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b:\u0010.R$\u0010<\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060;8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b<\u0010=R$\u0010>\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060;8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b?\u0010.R\u0014\u0010@\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b@\u0010.R\u0014\u0010A\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bA\u0010.R\u0014\u0010B\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bB\u0010.R\u0014\u0010C\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bC\u0010.R\u0014\u0010D\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bD\u0010.R\u0014\u0010E\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bE\u0010.R\u0014\u0010F\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bF\u0010.R\u0014\u0010G\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bG\u0010.R\u0014\u0010H\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bH\u0010.R\u0014\u0010I\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bI\u0010.R$\u0010L\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\"8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bJ\u0010K\u00A8\u0006M"}, d2 = {"Lcom/facebook/appevents/UserDataStore;", "", "<init>", "()V", "Lie/H;", "initStore", "", "key", "value", "writeDataIntoCache", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "ud", "setUserDataAndHash", "(Landroid/os/Bundle;)V", "email", "firstName", "lastName", "phone", "dateOfBirth", "gender", "city", "state", "zip", "country", "externalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clear", "getHashedUserData$facebook_core_release", "()Ljava/lang/String;", "getHashedUserData", "getAllHashedUserData", "initAndWait", "updateHashUserData", "", "setInternalUd", "(Ljava/util/Map;)V", "type", "data", "normalizeData", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "maybeSHA256Hashed", "(Ljava/lang/String;)Z", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "USER_DATA_KEY", "INTERNAL_USER_DATA_KEY", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "MAX_NUM", "I", "DATA_SEPARATOR", "Ljava/util/concurrent/ConcurrentHashMap;", "externalHashedUserData", "Ljava/util/concurrent/ConcurrentHashMap;", "internalHashedUserData", "EMAIL", "FIRST_NAME", "LAST_NAME", "PHONE", "DATE_OF_BIRTH", "GENDER", "CITY", "STATE", "ZIP", "COUNTRY", "EXTERNAL_ID", "getEnabledInternalUserData", "()Ljava/util/Map;", "enabledInternalUserData", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UserDataStore {
    @NotNull
    public static final String CITY = "ct";
    @NotNull
    public static final String COUNTRY = "country";
    @NotNull
    private static final String DATA_SEPARATOR = ",";
    @NotNull
    public static final String DATE_OF_BIRTH = "db";
    @NotNull
    public static final String EMAIL = "em";
    @NotNull
    public static final String EXTERNAL_ID = "external_id";
    @NotNull
    public static final String FIRST_NAME = "fn";
    @NotNull
    public static final String GENDER = "ge";
    @NotNull
    public static final UserDataStore INSTANCE = null;
    @NotNull
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    @NotNull
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    @NotNull
    public static final String PHONE = "ph";
    @NotNull
    public static final String STATE = "st";
    private static final String TAG = null;
    @NotNull
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    @NotNull
    public static final String ZIP = "zp";
    @NotNull
    private static final ConcurrentHashMap externalHashedUserData;
    @NotNull
    private static final AtomicBoolean initialized;
    @NotNull
    private static final ConcurrentHashMap internalHashedUserData;
    private static SharedPreferences sharedPreferences;

    static {
        UserDataStore.INSTANCE = new UserDataStore();
        UserDataStore.TAG = "UserDataStore";
        UserDataStore.initialized = new AtomicBoolean(false);
        UserDataStore.externalHashedUserData = new ConcurrentHashMap();
        UserDataStore.internalHashedUserData = new ConcurrentHashMap();
    }

    public static final void clear() {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new a(13));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void clear$lambda$2() {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if(!UserDataStore.initialized.get()) {
                Log.w("UserDataStore", "initStore should have been called before calling setUserData");
                UserDataStore.INSTANCE.initAndWait();
            }
            UserDataStore.externalHashedUserData.clear();
            SharedPreferences sharedPreferences0 = UserDataStore.sharedPreferences;
            if(sharedPreferences0 != null) {
                sharedPreferences0.edit().putString("com.facebook.appevents.UserDataStore.userData", null).apply();
                return;
            }
            q.m("sharedPreferences");
            throw null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @NotNull
    public static final String getAllHashedUserData() [...] // 潜在的解密器

    private final Map getEnabledInternalUserData() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map map0 = new HashMap();
            Set set0 = MetadataRule.Companion.getEnabledRuleNames();
            for(Object object0: UserDataStore.internalHashedUserData.keySet()) {
                String s = (String)object0;
                if(set0.contains(s)) {
                    map0.put(s, UserDataStore.internalHashedUserData.get(s));
                }
            }
            return map0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @NotNull
    public static final String getHashedUserData$facebook_core_release() [...] // 潜在的解密器

    private final void initAndWait() {
        synchronized(this) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AtomicBoolean atomicBoolean0 = UserDataStore.initialized;
                if(!atomicBoolean0.get()) {
                    SharedPreferences sharedPreferences0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                    q.f(sharedPreferences0, "getDefaultSharedPreferen….getApplicationContext())");
                    UserDataStore.sharedPreferences = sharedPreferences0;
                    String s = sharedPreferences0.getString("com.facebook.appevents.UserDataStore.userData", "");
                    if(s == null) {
                        s = "";
                    }
                    SharedPreferences sharedPreferences1 = UserDataStore.sharedPreferences;
                    if(sharedPreferences1 != null) {
                        String s1 = sharedPreferences1.getString("com.facebook.appevents.UserDataStore.internalUserData", "");
                        if(s1 == null) {
                            s1 = "";
                        }
                        Map map0 = Utility.jsonStrToMap(s);
                        UserDataStore.externalHashedUserData.putAll(map0);
                        Map map1 = Utility.jsonStrToMap(s1);
                        UserDataStore.internalHashedUserData.putAll(map1);
                        atomicBoolean0.set(true);
                        return;
                    }
                    q.m("sharedPreferences");
                    throw null;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static final void initStore() {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(!UserDataStore.initialized.get()) {
                    UserDataStore.INSTANCE.initAndWait();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final boolean maybeSHA256Hashed(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Pattern pattern0 = Pattern.compile("[A-Fa-f0-9]{64}");
            q.f(pattern0, "compile(...)");
            q.g(s, "input");
            return pattern0.matcher(s).matches();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    private final String normalizeData(String s, String s1) {
        String s4;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int v = s1.length() - 1;
            int v1 = 0;
            boolean z = false;
            while(v1 <= v) {
                boolean z1 = q.h(s1.charAt((z ? v : v1)), 0x20) <= 0;
                if(z) {
                    if(!z1) {
                        break;
                    }
                    --v;
                }
                else if(z1) {
                    ++v1;
                }
                else {
                    z = true;
                }
            }
            String s2 = s1.subSequence(v1, v + 1).toString().toLowerCase();
            q.f(s2, "this as java.lang.String).toLowerCase()");
            if(!"em".equals(s)) {
                if("ph".equals(s)) {
                    Pattern pattern0 = Pattern.compile("[^0-9]");
                    q.f(pattern0, "compile(...)");
                    String s3 = pattern0.matcher(s2).replaceAll("");
                    q.f(s3, "replaceAll(...)");
                    return s3;
                }
                if("ge".equals(s)) {
                    if(s2.length() > 0) {
                        s4 = s2.substring(0, 1);
                        q.f(s4, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    else {
                        s4 = "";
                    }
                    if(!"f".equals(s4) && !"m".equals(s4)) {
                        Log.e("UserDataStore", "Setting gender failure: the supported value for gender is f or m");
                        return "";
                    }
                    return s4;
                }
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(s2).matches()) {
                Log.e("UserDataStore", "Setting email failure: this is not a valid email address");
                return "";
            }
            return s2;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    public static final void setInternalUd(@NotNull Map map0) {
        String[] arr_s1;
        List list0;
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(map0, "ud");
                if(!UserDataStore.initialized.get()) {
                    UserDataStore.INSTANCE.initAndWait();
                }
                Iterator iterator0 = map0.entrySet().iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        UserDataStore.INSTANCE.writeDataIntoCache("com.facebook.appevents.UserDataStore.internalUserData", "");
                        return;
                    }
                    Object object0 = iterator0.next();
                    String s = (String)((Map.Entry)object0).getKey();
                    String s1 = (String)((Map.Entry)object0).getValue();
                    UserDataStore userDataStore0 = UserDataStore.INSTANCE;
                    int v1 = s1.length() - 1;
                    int v2 = 0;
                    boolean z = false;
                    while(v2 <= v1) {
                        boolean z1 = q.h(s1.charAt((z ? v1 : v2)), 0x20) <= 0;
                        if(z) {
                            if(!z1) {
                                break;
                            }
                            --v1;
                        }
                        else if(z1) {
                            ++v2;
                        }
                        else {
                            z = true;
                        }
                    }
                    String s2 = Utility.sha256hash(userDataStore0.normalizeData(s, s1.subSequence(v2, v1 + 1).toString()));
                    ConcurrentHashMap concurrentHashMap0 = UserDataStore.internalHashedUserData;
                    if(concurrentHashMap0.containsKey(s)) {
                        String s3 = (String)concurrentHashMap0.get(s);
                        if(s3 == null) {
                            arr_s1 = new String[0];
                        }
                        else {
                            Pattern pattern0 = Pattern.compile(",");
                            q.f(pattern0, "compile(...)");
                            o.P0(0);
                            Matcher matcher0 = pattern0.matcher(s3);
                            if(matcher0.find()) {
                                ArrayList arrayList0 = new ArrayList(10);
                                int v3 = 0;
                                do {
                                    arrayList0.add(s3.subSequence(v3, matcher0.start()).toString());
                                    v3 = matcher0.end();
                                }
                                while(matcher0.find());
                                arrayList0.add(s3.subSequence(v3, s3.length()).toString());
                                list0 = arrayList0;
                            }
                            else {
                                list0 = k.z(s3.toString());
                            }
                            String[] arr_s = (String[])list0.toArray(new String[0]);
                            if(arr_s != null) {
                                arr_s1 = arr_s;
                            }
                        }
                        Set set0 = I.J(Arrays.copyOf(arr_s1, arr_s1.length));
                        if(set0.contains(s2)) {
                            break;
                        }
                        StringBuilder stringBuilder0 = new StringBuilder();
                        if(arr_s1.length == 0) {
                            stringBuilder0.append(s2);
                        }
                        else if(arr_s1.length >= 5) {
                            for(int v = 1; v < 5; ++v) {
                                stringBuilder0.append(arr_s1[v]);
                                stringBuilder0.append(",");
                            }
                            stringBuilder0.append(s2);
                            set0.remove(arr_s1[0]);
                        }
                        else {
                            stringBuilder0.append(s3);
                            stringBuilder0.append(",");
                            stringBuilder0.append(s2);
                        }
                        UserDataStore.internalHashedUserData.put(s, stringBuilder0.toString());
                    }
                    else {
                        concurrentHashMap0.put(s, s2);
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void setUserDataAndHash(@Nullable Bundle bundle0) {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new c(bundle0, 0));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void setUserDataAndHash(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10) {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            Bundle bundle0 = new Bundle();
            if(s != null) {
                bundle0.putString("em", s);
            }
            if(s1 != null) {
                bundle0.putString("fn", s1);
            }
            if(s2 != null) {
                bundle0.putString("ln", s2);
            }
            if(s3 != null) {
                bundle0.putString("ph", s3);
            }
            if(s4 != null) {
                bundle0.putString("db", s4);
            }
            if(s5 != null) {
                bundle0.putString("ge", s5);
            }
            if(s6 != null) {
                bundle0.putString("ct", s6);
            }
            if(s7 != null) {
                bundle0.putString("st", s7);
            }
            if(s8 != null) {
                bundle0.putString("zp", s8);
            }
            if(s9 != null) {
                bundle0.putString("country", s9);
            }
            if(s10 != null) {
                bundle0.putString("external_id", s10);
            }
            UserDataStore.setUserDataAndHash(bundle0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static void setUserDataAndHash$default(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, int v, Object object0) {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            UserDataStore.setUserDataAndHash(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, ((v & 0x400) == 0 ? s10 : null));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void setUserDataAndHash$lambda$1(Bundle bundle0) {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if(!UserDataStore.initialized.get()) {
                Log.w("UserDataStore", "initStore should have been called before calling setUserData");
                UserDataStore.INSTANCE.initAndWait();
            }
            UserDataStore.INSTANCE.updateHashUserData(bundle0);
            UserDataStore.INSTANCE.writeDataIntoCache("com.facebook.appevents.UserDataStore.userData", "");
            UserDataStore.INSTANCE.writeDataIntoCache("com.facebook.appevents.UserDataStore.internalUserData", "");
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void updateHashUserData(Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this) || bundle0 == null) {
            return;
        }
        else {
            try {
                for(Object object0: bundle0.keySet()) {
                    String s = (String)object0;
                    Object object1 = bundle0.get(s);
                    if(object1 != null) {
                        String s1 = object1.toString();
                        if(this.maybeSHA256Hashed(s1)) {
                            String s2 = s1.toLowerCase();
                            q.f(s2, "this as java.lang.String).toLowerCase()");
                            UserDataStore.externalHashedUserData.put(s, s2);
                        }
                        else {
                            q.f(s, "key");
                            String s3 = Utility.sha256hash(this.normalizeData(s, s1));
                            if(s3 != null) {
                                UserDataStore.externalHashedUserData.put(s, s3);
                            }
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void writeDataIntoCache(String s, String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new b(s, s1, 1));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void writeDataIntoCache$lambda$0(String s, String s1) {
        Class class0 = UserDataStore.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(s, "$key");
            q.g(s1, "$value");
            if(!UserDataStore.initialized.get()) {
                UserDataStore.INSTANCE.initAndWait();
            }
            SharedPreferences sharedPreferences0 = UserDataStore.sharedPreferences;
            if(sharedPreferences0 != null) {
                sharedPreferences0.edit().putString(s, s1).apply();
                return;
            }
            q.m("sharedPreferences");
            throw null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

