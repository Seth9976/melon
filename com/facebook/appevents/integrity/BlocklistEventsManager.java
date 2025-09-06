package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\r\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u001C\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\b0\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/integrity/BlocklistEventsManager;", "", "<init>", "()V", "Lie/H;", "enable", "disable", "loadBlocklistEvents", "", "eventName", "", "isInBlocklist", "(Ljava/lang/String;)Z", "enabled", "Z", "", "blocklist", "Ljava/util/Set;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class BlocklistEventsManager {
    @NotNull
    public static final BlocklistEventsManager INSTANCE;
    @NotNull
    private static Set blocklist;
    private static boolean enabled;

    static {
        BlocklistEventsManager.INSTANCE = new BlocklistEventsManager();
        BlocklistEventsManager.blocklist = new HashSet();
    }

    public static final void disable() {
        Class class0 = BlocklistEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            BlocklistEventsManager.enabled = false;
            BlocklistEventsManager.blocklist = new HashSet();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void enable() {
        Class class0 = BlocklistEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            BlocklistEventsManager.INSTANCE.loadBlocklistEvents();
            if(BlocklistEventsManager.blocklist != null && !BlocklistEventsManager.blocklist.isEmpty()) {
                BlocklistEventsManager.enabled = true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final boolean isInBlocklist(@NotNull String s) {
        Class class0 = BlocklistEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            q.g(s, "eventName");
            return BlocklistEventsManager.enabled ? BlocklistEventsManager.blocklist.contains(s) : false;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    private final void loadBlocklistEvents() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    HashSet hashSet0 = Utility.convertJSONArrayToHashSet(fetchedAppSettings0.getBlocklistEvents());
                    if(hashSet0 != null) {
                        BlocklistEventsManager.blocklist = hashSet0;
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

