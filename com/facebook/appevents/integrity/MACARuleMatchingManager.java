package com.facebook.appevents.integrity;

import Tf.o;
import Tf.v;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000BJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u00072\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0017\u001A\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00162\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001A\u001A\u00020\u00102\b\u0010\u0019\u001A\u0004\u0018\u00010\t2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001D\u001A\u00020\t2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0004\b\u001D\u0010\u001EJ!\u0010 \u001A\u00020\u00042\b\u0010\u001C\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u001F\u001A\u00020\tH\u0007¢\u0006\u0004\b \u0010!J\u001F\u0010\"\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\tH\u0007¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00020\u000EH\u0007¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\'\u001A\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(R\u001C\u0010*\u001A\b\u0012\u0004\u0012\u00020\t0)8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "<init>", "()V", "Lie/H;", "enable", "loadMACARules", "Lorg/json/JSONObject;", "logic", "", "getKey", "(Lorg/json/JSONObject;)Ljava/lang/String;", "variable", "values", "Landroid/os/Bundle;", "data", "", "stringComparison", "(Ljava/lang/String;Lorg/json/JSONObject;Landroid/os/Bundle;)Z", "Lorg/json/JSONArray;", "jsonArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getStringArrayList", "(Lorg/json/JSONArray;)Ljava/util/ArrayList;", "ruleString", "isMatchCCRule", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "params", "getMatchPropertyIDs", "(Landroid/os/Bundle;)Ljava/lang/String;", "event", "processParameters", "(Landroid/os/Bundle;Ljava/lang/String;)V", "generateInfo", "removeGeneratedInfo", "(Landroid/os/Bundle;)V", "enabled", "Z", "MACARules", "Lorg/json/JSONArray;", "", "keys", "[Ljava/lang/String;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MACARuleMatchingManager {
    @NotNull
    public static final MACARuleMatchingManager INSTANCE;
    @Nullable
    private static JSONArray MACARules;
    private static boolean enabled;
    @NotNull
    private static String[] keys;

    static {
        MACARuleMatchingManager.INSTANCE = new MACARuleMatchingManager();
        MACARuleMatchingManager.keys = new String[]{"event", "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};
    }

    public static final void enable() {
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                MACARuleMatchingManager.INSTANCE.loadMACARules();
                if(MACARuleMatchingManager.MACARules != null) {
                    MACARuleMatchingManager.enabled = true;
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void generateInfo(@NotNull Bundle bundle0, @NotNull String s) {
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(bundle0, "params");
            q.g(s, "event");
            bundle0.putString("event", s);
            StringBuilder stringBuilder0 = new StringBuilder();
            Utility utility0 = Utility.INSTANCE;
            Locale locale0 = utility0.getLocale();
            String s1 = null;
            String s2 = locale0 == null ? null : locale0.getLanguage();
            if(s2 == null) {
                s2 = "";
            }
            stringBuilder0.append(s2);
            stringBuilder0.append('_');
            Locale locale1 = utility0.getLocale();
            if(locale1 != null) {
                s1 = locale1.getCountry();
            }
            if(s1 == null) {
                s1 = "";
            }
            stringBuilder0.append(s1);
            bundle0.putString("_locale", stringBuilder0.toString());
            bundle0.putString("_appVersion", "");
            bundle0.putString("_deviceOS", "ANDROID");
            bundle0.putString("_platform", "mobile");
            bundle0.putString("_deviceModel", (Build.MODEL == null ? "" : Build.MODEL));
            bundle0.putString("_nativeAppID", FacebookSdk.getApplicationId());
            bundle0.putString("_nativeAppShortVersion", "");
            bundle0.putString("_timezone", "");
            bundle0.putString("_carrier", "NoCarrier");
            bundle0.putString("_deviceOSTypeName", "ANDROID");
            bundle0.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            bundle0.putLong("_remainingDiskGB", -1L);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @Nullable
    public static final String getKey(@NotNull JSONObject jSONObject0) {
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(jSONObject0, "logic");
            Iterator iterator0 = jSONObject0.keys();
            if(iterator0.hasNext()) {
                return iterator0.next();
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return null;
    }

    @NotNull
    public static final String getMatchPropertyIDs(@Nullable Bundle bundle0) {
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            if(MACARuleMatchingManager.MACARules == null || MACARuleMatchingManager.MACARules.length() == 0) {
                return "[]";
            }
            JSONArray jSONArray0 = MACARuleMatchingManager.MACARules;
            q.e(jSONArray0, "null cannot be cast to non-null type org.json.JSONArray");
            ArrayList arrayList0 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = jSONArray0.optString(v1);
                if(s != null) {
                    JSONObject jSONObject0 = new JSONObject(s);
                    long v2 = jSONObject0.optLong("id");
                    if(v2 != 0L) {
                        String s1 = jSONObject0.optString("rule");
                        if(s1 != null && MACARuleMatchingManager.isMatchCCRule(s1, bundle0)) {
                            arrayList0.add(v2);
                        }
                    }
                }
            }
            String s2 = new JSONArray(arrayList0).toString();
            q.f(s2, "JSONArray(res).toString()");
            return s2;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @Nullable
    public static final ArrayList getStringArrayList(@Nullable JSONArray jSONArray0) {
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(jSONArray0 == null) {
            return null;
        }
        try {
            ArrayList arrayList0 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                arrayList0.add(jSONArray0.get(v1).toString());
            }
            return arrayList0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final boolean isMatchCCRule(@Nullable String s, @Nullable Bundle bundle0) {
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        if(s != null && bundle0 != null) {
            try {
                JSONObject jSONObject0 = new JSONObject(s);
                String s1 = MACARuleMatchingManager.getKey(jSONObject0);
                if(s1 == null) {
                    return false;
                }
                Object object0 = jSONObject0.get(s1);
                switch(s1) {
                    case "and": {
                        if(((JSONArray)object0) == null) {
                            return false;
                        }
                        int v2 = ((JSONArray)object0).length();
                        for(int v3 = 0; v3 < v2; ++v3) {
                            if(!MACARuleMatchingManager.isMatchCCRule(((JSONArray)object0).get(v3).toString(), bundle0)) {
                                return false;
                            }
                        }
                        return true;
                    }
                    case "not": {
                        return !MACARuleMatchingManager.isMatchCCRule(object0.toString(), bundle0);
                    }
                    case "or": {
                        if(((JSONArray)object0) == null) {
                            return false;
                        }
                        int v = ((JSONArray)object0).length();
                        for(int v1 = 0; true; ++v1) {
                            if(v1 >= v) {
                                return false;
                            }
                            if(MACARuleMatchingManager.isMatchCCRule(((JSONArray)object0).get(v1).toString(), bundle0)) {
                                break;
                            }
                        }
                        return true;
                    }
                    default: {
                        return ((JSONObject)object0) == null ? false : MACARuleMatchingManager.stringComparison(s1, ((JSONObject)object0), bundle0);
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return false;
    }

    private final void loadMACARules() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    MACARuleMatchingManager.MACARules = fetchedAppSettings0.getMACARuleMatchingSetting();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static final void processParameters(@Nullable Bundle bundle0, @NotNull String s) {
        Class class0 = MACARuleMatchingManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(s, "event");
                if(MACARuleMatchingManager.enabled && bundle0 != null) {
                    try {
                        MACARuleMatchingManager.generateInfo(bundle0, s);
                        bundle0.putString("_audiencePropertyIds", MACARuleMatchingManager.getMatchPropertyIDs(bundle0));
                        bundle0.putString("cs_maca", "1");
                        MACARuleMatchingManager.removeGeneratedInfo(bundle0);
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    public static final void removeGeneratedInfo(@NotNull Bundle bundle0) {
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(bundle0, "params");
                String[] arr_s = MACARuleMatchingManager.keys;
                for(int v = 0; v < arr_s.length; ++v) {
                    bundle0.remove(arr_s[v]);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final boolean stringComparison(@NotNull String s, @NotNull JSONObject jSONObject0, @Nullable Bundle bundle0) {
        Object object0;
        Class class0 = MACARuleMatchingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        else {
            try {
                q.g(s, "variable");
                q.g(jSONObject0, "values");
                String s1 = MACARuleMatchingManager.getKey(jSONObject0);
                if(s1 != null) {
                    String s2 = jSONObject0.get(s1).toString();
                    ArrayList arrayList0 = MACARuleMatchingManager.getStringArrayList(jSONObject0.optJSONArray(s1));
                    if(s1.equals("exists")) {
                        return bundle0 != null && bundle0.containsKey(s) == Boolean.parseBoolean(s2);
                    }
                    if(bundle0 == null) {
                    label_15:
                        object0 = bundle0 == null ? null : bundle0.get(s);
                        if(object0 != null) {
                        label_17:
                            switch(s1.hashCode()) {
                                case 0x98EF9621: {
                                    if(s1.equals("i_not_contains")) {
                                        Locale locale0 = Locale.ROOT;
                                        String s4 = object0.toString().toLowerCase(locale0);
                                        q.f(s4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        String s5 = s2.toLowerCase(locale0);
                                        q.f(s5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        return !o.v0(s4, s5, false);
                                    }
                                    break;
                                }
                                case 0xB9AE1157: {
                                    if(s1.equals("is_any")) {
                                        return arrayList0 == null ? false : arrayList0.contains(object0.toString());
                                    }
                                    break;
                                }
                                case 0xC2077211: {
                                    if(s1.equals("not_in")) {
                                        return arrayList0 == null ? false : arrayList0.contains(object0.toString());
                                    }
                                    break;
                                }
                                case 0xC63A2BF4: {
                                    return s1.equals("starts_with") ? v.r0(object0.toString(), s2, false) : false;
                                }
                                case 0xC6669BCD: {
                                    if(s1.equals("regex_match")) {
                                        q.g(s2, "pattern");
                                        Pattern pattern0 = Pattern.compile(s2);
                                        q.f(pattern0, "compile(...)");
                                        String s6 = object0.toString();
                                        q.g(s6, "input");
                                        return pattern0.matcher(s6).matches();
                                    }
                                    break;
                                }
                                case -665609109: {
                                    if(!s1.equals("is_not_any")) {
                                        return false;
                                    }
                                    return arrayList0 == null ? false : arrayList0.contains(object0.toString());
                                }
                                case 0xDE2D761F: {
                                    return s1.equals("contains") ? o.v0(object0.toString(), s2, false) : false;
                                }
                                case -327990090: {
                                    if(s1.equals("i_str_neq")) {
                                        Locale locale1 = Locale.ROOT;
                                        String s7 = object0.toString().toLowerCase(locale1);
                                        q.f(s7, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        String s8 = s2.toLowerCase(locale1);
                                        q.f(s8, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        return !s7.equals(s8);
                                    }
                                    break;
                                }
                                case 0xF67975ED: {
                                    if(s1.equals("i_is_any")) {
                                        goto label_82;
                                    }
                                    break;
                                }
                                case 0xFA78B175: {
                                    if(s1.equals("i_str_not_in")) {
                                        goto label_102;
                                    }
                                    break;
                                }
                                case 60: {
                                    return s1.equals("<") ? Double.parseDouble(object0.toString()) < Double.parseDouble(s2) : false;
                                }
                                case 61: {
                                    return s1.equals("=") ? q.b(object0.toString(), s2) : false;
                                }
                                case 62: {
                                    return s1.equals(">") ? Double.parseDouble(object0.toString()) > Double.parseDouble(s2) : false;
                                }
                                case 1084: {
                                    return s1.equals("!=") ? !q.b(object0.toString(), s2) : false;
                                }
                                case 0x781: {
                                    return s1.equals("<=") ? Double.parseDouble(object0.toString()) <= Double.parseDouble(s2) : false;
                                }
                                case 0x7A0: {
                                    return s1.equals("==") ? q.b(object0.toString(), s2) : false;
                                }
                                case 0x7BF: {
                                    return s1.equals(">=") ? Double.parseDouble(object0.toString()) >= Double.parseDouble(s2) : false;
                                }
                                case 0xCAC: {
                                    return s1.equals("eq") ? q.b(object0.toString(), s2) : false;
                                }
                                case 0xCDE: {
                                    return s1.equals("ge") ? Double.parseDouble(object0.toString()) >= Double.parseDouble(s2) : false;
                                }
                                case 3309: {
                                    return s1.equals("gt") ? Double.parseDouble(object0.toString()) > Double.parseDouble(s2) : false;
                                }
                                case 0xD25: {
                                    if(!s1.equals("in")) {
                                        return false;
                                    }
                                    return arrayList0 == null ? false : arrayList0.contains(object0.toString());
                                }
                                case 0xD79: {
                                    return s1.equals("le") ? Double.parseDouble(object0.toString()) <= Double.parseDouble(s2) : false;
                                }
                                case 0xD88: {
                                    return s1.equals("lt") ? Double.parseDouble(object0.toString()) < Double.parseDouble(s2) : false;
                                }
                                case 0xDB7: {
                                    return s1.equals("ne") ? !q.b(object0.toString(), s2) : false;
                                }
                                case 102680: {
                                    return s1.equals("gte") ? Double.parseDouble(object0.toString()) >= Double.parseDouble(s2) : false;
                                }
                                case 107485: {
                                    return s1.equals("lte") ? Double.parseDouble(object0.toString()) <= Double.parseDouble(s2) : false;
                                }
                                case 108954: {
                                    return s1.equals("neq") ? !q.b(object0.toString(), s2) : false;
                                }
                                case 0x7A09E10: {
                                    if(s1.equals("i_str_eq")) {
                                        Locale locale2 = Locale.ROOT;
                                        String s9 = object0.toString().toLowerCase(locale2);
                                        q.f(s9, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        String s10 = s2.toLowerCase(locale2);
                                        q.f(s10, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        return s9.equals(s10);
                                    }
                                    break;
                                }
                                case 0x7A09E89: {
                                    if(!s1.equals("i_str_in")) {
                                        return false;
                                    }
                                label_82:
                                    if(arrayList0 != null && !arrayList0.isEmpty()) {
                                        Iterator iterator0 = arrayList0.iterator();
                                        while(true) {
                                            if(!iterator0.hasNext()) {
                                                break;
                                            }
                                            Object object1 = iterator0.next();
                                            Locale locale3 = Locale.ROOT;
                                            String s11 = ((String)object1).toLowerCase(locale3);
                                            q.f(s11, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                            String s12 = object0.toString().toLowerCase(locale3);
                                            q.f(s12, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                            if(!s11.equals(s12)) {
                                                continue;
                                            }
                                            return true;
                                        }
                                    }
                                    break;
                                }
                                case 0x15B20D35: {
                                    if(s1.equals("i_contains")) {
                                        Locale locale4 = Locale.ROOT;
                                        String s13 = object0.toString().toLowerCase(locale4);
                                        q.f(s13, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        String s14 = s2.toLowerCase(locale4);
                                        q.f(s14, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        return o.v0(s13, s14, false);
                                    }
                                    break;
                                }
                                case 0x410EC601: {
                                    if(!s1.equals("i_is_not_any")) {
                                        return false;
                                    }
                                label_102:
                                    if(arrayList0 != null) {
                                        if(!arrayList0.isEmpty()) {
                                            for(Object object2: arrayList0) {
                                                Locale locale5 = Locale.ROOT;
                                                String s15 = ((String)object2).toLowerCase(locale5);
                                                q.f(s15, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                                String s16 = object0.toString().toLowerCase(locale5);
                                                q.f(s16, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                                if(s15.equals(s16)) {
                                                    return false;
                                                }
                                                if(false) {
                                                    break;
                                                }
                                            }
                                        }
                                        return true;
                                    }
                                    break;
                                }
                                case 1918401035: {
                                    return s1.equals("not_contains") && !o.v0(object0.toString(), s2, false);
                                }
                                case 0x74E4351E: {
                                    if(s1.equals("i_starts_with")) {
                                        Locale locale6 = Locale.ROOT;
                                        String s17 = object0.toString().toLowerCase(locale6);
                                        q.f(s17, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        String s18 = s2.toLowerCase(locale6);
                                        q.f(s18, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                                        return v.r0(s17, s18, false);
                                    }
                                    break;
                                }
                                default: {
                                    return false;
                                }
                            }
                        }
                    }
                    else {
                        String s3 = s.toLowerCase(Locale.ROOT);
                        q.f(s3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        object0 = bundle0.get(s3);
                        if(object0 == null) {
                            goto label_15;
                        }
                        else {
                            goto label_17;
                        }
                    }
                }
                return false;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return false;
    }
}

