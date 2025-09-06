package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000BJ)\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u000E0\rj\b\u0012\u0004\u0012\u00020\u000E`\u000F2\b\u0010\f\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001A\u00020\u00042\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\u001D\u001A\u00020\u00192\u0006\u0010\u0016\u001A\u00020\u000E2\u000E\u0010\u001C\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001D\u0010\u001BR\u0016\u0010\u001E\u001A\u00020\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR2\u0010!\u001A\u001E\u0012\u0004\u0012\u00020\u000E\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000E0\rj\b\u0012\u0004\u0012\u00020\u000E`\u000F0 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R2\u0010#\u001A\u001E\u0012\u0004\u0012\u00020\u000E\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000E0\rj\b\u0012\u0004\u0012\u00020\u000E`\u000F0 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lcom/facebook/appevents/integrity/StdParamsEnforcementManager;", "", "<init>", "()V", "Lie/H;", "enable", "disable", "loadConfigs", "Lorg/json/JSONArray;", "schema", "configureSchemaRestrictions", "(Lorg/json/JSONArray;)V", "paramValues", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "loadSet", "(Lorg/json/JSONArray;)Ljava/util/HashSet;", "Landroid/os/Bundle;", "parameters", "processFilterParamSchemaBlocking", "(Landroid/os/Bundle;)V", "value", "", "expressions", "", "isAnyRegexMatched", "(Ljava/lang/String;Ljava/util/Set;)Z", "enumValues", "isAnyEnumMatched", "enabled", "Z", "", "regexRestrictionsConfig", "Ljava/util/Map;", "enumRestrictionsConfig", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class StdParamsEnforcementManager {
    @NotNull
    public static final StdParamsEnforcementManager INSTANCE;
    private static boolean enabled;
    @NotNull
    private static Map enumRestrictionsConfig;
    @NotNull
    private static Map regexRestrictionsConfig;

    static {
        StdParamsEnforcementManager.INSTANCE = new StdParamsEnforcementManager();
        StdParamsEnforcementManager.regexRestrictionsConfig = new HashMap();
        StdParamsEnforcementManager.enumRestrictionsConfig = new HashMap();
    }

    private final void configureSchemaRestrictions(JSONArray jSONArray0) {
        int v3;
        JSONArray jSONArray1;
        int v1;
        if(!CrashShieldHandler.isObjectCrashing(this) && jSONArray0 != null && !StdParamsEnforcementManager.enabled) {
            try {
                int v = jSONArray0.length();
                for(v1 = 0; true; ++v1) {
                    if(v1 >= v) {
                        return;
                    }
                    JSONObject jSONObject0 = jSONArray0.getJSONObject(v1);
                    String s = jSONObject0.getString("key");
                    if(s != null && s.length() != 0) {
                        try {
                            jSONArray1 = jSONObject0.getJSONArray("value");
                            int v2 = jSONArray1.length();
                            v3 = 0;
                        }
                        catch(Exception unused_ex) {
                            StdParamsEnforcementManager.enumRestrictionsConfig.remove(s);
                            StdParamsEnforcementManager.regexRestrictionsConfig.remove(s);
                            break;
                        }
                        while(true) {
                            if(v3 >= v2) {
                                break;
                            }
                            try {
                                boolean z = jSONArray1.getJSONObject(v3).getBoolean("require_exact_match");
                                HashSet hashSet0 = this.loadSet(jSONArray1.getJSONObject(v3).getJSONArray("potential_matches"));
                                if(z) {
                                    Map map0 = StdParamsEnforcementManager.enumRestrictionsConfig;
                                    q.f(s, "key");
                                    HashSet hashSet1 = (HashSet)StdParamsEnforcementManager.enumRestrictionsConfig.get(s);
                                    if(hashSet1 != null) {
                                        hashSet1.addAll(hashSet0);
                                        hashSet0 = hashSet1;
                                    }
                                    map0.put(s, hashSet0);
                                }
                                else {
                                    Map map1 = StdParamsEnforcementManager.regexRestrictionsConfig;
                                    q.f(s, "key");
                                    HashSet hashSet2 = (HashSet)StdParamsEnforcementManager.regexRestrictionsConfig.get(s);
                                    if(hashSet2 != null) {
                                        hashSet2.addAll(hashSet0);
                                        hashSet0 = hashSet2;
                                    }
                                    map1.put(s, hashSet0);
                                }
                                ++v3;
                            }
                            catch(Exception unused_ex) {
                                StdParamsEnforcementManager.enumRestrictionsConfig.remove(s);
                                StdParamsEnforcementManager.regexRestrictionsConfig.remove(s);
                                break;
                            }
                        }
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static final void disable() {
        Class class0 = StdParamsEnforcementManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            StdParamsEnforcementManager.enabled = false;
            StdParamsEnforcementManager.regexRestrictionsConfig = new HashMap();
            StdParamsEnforcementManager.enumRestrictionsConfig = new HashMap();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void enable() {
        Class class0 = StdParamsEnforcementManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(!StdParamsEnforcementManager.enabled) {
                    StdParamsEnforcementManager.INSTANCE.loadConfigs();
                    StdParamsEnforcementManager.enabled = !StdParamsEnforcementManager.regexRestrictionsConfig.isEmpty() || !StdParamsEnforcementManager.enumRestrictionsConfig.isEmpty();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final boolean isAnyEnumMatched(String s, Set set0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        if(set0 != null) {
            try {
                if(set0 instanceof Collection && set0.isEmpty()) {
                    return false;
                }
                Iterator iterator0 = set0.iterator();
                do {
                    if(!iterator0.hasNext()) {
                        return false;
                    }
                    Object object0 = iterator0.next();
                    Locale locale0 = Locale.ROOT;
                    String s1 = ((String)object0).toLowerCase(locale0);
                    q.f(s1, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String s2 = s.toLowerCase(locale0);
                    q.f(s2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                }
                while(!s1.equals(s2));
                return true;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return false;
            }
        }
        return false;
    }

    private final boolean isAnyRegexMatched(String s, Set set0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        if(set0 != null) {
            try {
                if(set0 instanceof Collection && set0.isEmpty()) {
                    return false;
                }
                Iterator iterator0 = set0.iterator();
                do {
                    if(!iterator0.hasNext()) {
                        return false;
                    }
                    Object object0 = iterator0.next();
                    q.g(((String)object0), "pattern");
                    Pattern pattern0 = Pattern.compile(((String)object0));
                    q.f(pattern0, "compile(...)");
                    q.g(s, "input");
                }
                while(!pattern0.matcher(s).matches());
                return true;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return false;
            }
        }
        return false;
    }

    private final void loadConfigs() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    this.configureSchemaRestrictions(fetchedAppSettings0.getSchemaRestrictions());
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final HashSet loadSet(JSONArray jSONArray0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            try {
                HashSet hashSet0 = Utility.convertJSONArrayToHashSet(jSONArray0);
                return hashSet0 == null ? new HashSet() : hashSet0;
            }
            catch(Exception unused_ex) {
                return new HashSet();
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public static final void processFilterParamSchemaBlocking(@Nullable Bundle bundle0) {
        Class class0 = StdParamsEnforcementManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(StdParamsEnforcementManager.enabled && bundle0 != null) {
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object0: bundle0.keySet()) {
                        String s = (String)object0;
                        String s1 = String.valueOf(bundle0.get(s));
                        boolean z = false;
                        boolean z1 = StdParamsEnforcementManager.regexRestrictionsConfig.get(s) != null;
                        if(StdParamsEnforcementManager.enumRestrictionsConfig.get(s) != null) {
                            z = true;
                        }
                        if(z1 || z) {
                            Set set0 = (Set)StdParamsEnforcementManager.regexRestrictionsConfig.get(s);
                            boolean z2 = StdParamsEnforcementManager.INSTANCE.isAnyRegexMatched(s1, set0);
                            Set set1 = (Set)StdParamsEnforcementManager.enumRestrictionsConfig.get(s);
                            if(!z2 && !StdParamsEnforcementManager.INSTANCE.isAnyEnumMatched(s1, set1)) {
                                q.f(s, "key");
                                arrayList0.add(s);
                            }
                        }
                    }
                    for(Object object1: arrayList0) {
                        bundle0.remove(((String)object1));
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

