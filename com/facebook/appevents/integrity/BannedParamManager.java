package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J)\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0011\u001A\u00020\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/integrity/BannedParamManager;", "", "<init>", "()V", "Lie/H;", "enable", "disable", "loadConfigs", "Lorg/json/JSONArray;", "paramValues", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "loadSet", "(Lorg/json/JSONArray;)Ljava/util/HashSet;", "Landroid/os/Bundle;", "parameters", "processFilterBannedParams", "(Landroid/os/Bundle;)V", "", "enabled", "Z", "bannedParamsConfig", "Ljava/util/HashSet;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BannedParamManager {
    @NotNull
    public static final BannedParamManager INSTANCE;
    @NotNull
    private static HashSet bannedParamsConfig;
    private static boolean enabled;

    static {
        BannedParamManager.INSTANCE = new BannedParamManager();
        BannedParamManager.bannedParamsConfig = new HashSet();
    }

    public static final void disable() {
        Class class0 = BannedParamManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            BannedParamManager.enabled = false;
            BannedParamManager.bannedParamsConfig = new HashSet();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void enable() {
        Class class0 = BannedParamManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(!BannedParamManager.enabled) {
                    BannedParamManager.INSTANCE.loadConfigs();
                    BannedParamManager.enabled = !BannedParamManager.bannedParamsConfig.isEmpty();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void loadConfigs() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    BannedParamManager.bannedParamsConfig = this.loadSet(fetchedAppSettings0.getBannedParams());
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

    public static final void processFilterBannedParams(@Nullable Bundle bundle0) {
        Class class0 = BannedParamManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(BannedParamManager.enabled && bundle0 != null) {
                    for(Object object0: BannedParamManager.bannedParamsConfig) {
                        bundle0.remove(((String)object0));
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

