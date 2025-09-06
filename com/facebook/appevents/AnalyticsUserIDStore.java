package com.facebook.appevents;

import A5.a;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003R\u001C\u0010\u000E\u001A\n \r*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000FR\u0014\u0010\u0012\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u000FR\u0016\u0010\u0016\u001A\u00020\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/AnalyticsUserIDStore;", "", "<init>", "()V", "Lie/H;", "initStore", "", "id", "setUserID", "(Ljava/lang/String;)V", "getUserID", "()Ljava/lang/String;", "initAndWait", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "ANALYTICS_USER_ID_KEY", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "userID", "", "initialized", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AnalyticsUserIDStore {
    @NotNull
    private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
    @NotNull
    public static final AnalyticsUserIDStore INSTANCE;
    private static final String TAG;
    private static volatile boolean initialized;
    @NotNull
    private static final ReentrantReadWriteLock lock;
    @Nullable
    private static String userID;

    static {
        AnalyticsUserIDStore.INSTANCE = new AnalyticsUserIDStore();
        AnalyticsUserIDStore.TAG = "AnalyticsUserIDStore";
        AnalyticsUserIDStore.lock = new ReentrantReadWriteLock();
    }

    @Nullable
    public static final String getUserID() {
        if(!AnalyticsUserIDStore.initialized) {
            Log.w("AnalyticsUserIDStore", "initStore should have been called before calling setUserID");
            AnalyticsUserIDStore.INSTANCE.initAndWait();
        }
        AnalyticsUserIDStore.lock.readLock().lock();
        String s = AnalyticsUserIDStore.userID;
        AnalyticsUserIDStore.lock.readLock().unlock();
        return s;
    }

    private final void initAndWait() {
        if(AnalyticsUserIDStore.initialized) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock0 = AnalyticsUserIDStore.lock;
        reentrantReadWriteLock0.writeLock().lock();
        if(!AnalyticsUserIDStore.initialized) {
            try {
                AnalyticsUserIDStore.userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
                AnalyticsUserIDStore.initialized = true;
            }
            catch(Throwable throwable0) {
                AnalyticsUserIDStore.lock.writeLock().unlock();
                throw throwable0;
            }
        }
        reentrantReadWriteLock0.writeLock().unlock();
    }

    public static final void initStore() {
        if(AnalyticsUserIDStore.initialized) {
            return;
        }
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new a(9));
    }

    private static final void initStore$lambda$0() {
        AnalyticsUserIDStore.INSTANCE.initAndWait();
    }

    public static final void setUserID(@Nullable String s) {
        if(!AnalyticsUserIDStore.initialized) {
            Log.w("AnalyticsUserIDStore", "initStore should have been called before calling setUserID");
            AnalyticsUserIDStore.INSTANCE.initAndWait();
        }
        InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new com.facebook.appevents.a(s, 0));
    }

    private static final void setUserID$lambda$1(String s) {
        ReentrantReadWriteLock reentrantReadWriteLock0 = AnalyticsUserIDStore.lock;
        reentrantReadWriteLock0.writeLock().lock();
        try {
            AnalyticsUserIDStore.userID = s;
            SharedPreferences.Editor sharedPreferences$Editor0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            sharedPreferences$Editor0.putString("com.facebook.appevents.AnalyticsUserIDStore.userID", AnalyticsUserIDStore.userID);
            sharedPreferences$Editor0.apply();
        }
        catch(Throwable throwable0) {
            AnalyticsUserIDStore.lock.writeLock().unlock();
            throw throwable0;
        }
        reentrantReadWriteLock0.writeLock().unlock();
    }
}

