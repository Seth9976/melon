package com.facebook;

import W2.b;
import android.content.Intent;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0010\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001A\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u0018\u001A\u0004\u0018\u00010\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\r\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/facebook/ProfileManager;", "", "LW2/b;", "localBroadcastManager", "Lcom/facebook/ProfileCache;", "profileCache", "<init>", "(LW2/b;Lcom/facebook/ProfileCache;)V", "Lcom/facebook/Profile;", "currentProfile", "", "writeToCache", "Lie/H;", "setCurrentProfile", "(Lcom/facebook/Profile;Z)V", "oldProfile", "sendCurrentProfileChangedBroadcast", "(Lcom/facebook/Profile;Lcom/facebook/Profile;)V", "loadCurrentProfile", "()Z", "LW2/b;", "Lcom/facebook/ProfileCache;", "currentProfileField", "Lcom/facebook/Profile;", "value", "getCurrentProfile", "()Lcom/facebook/Profile;", "(Lcom/facebook/Profile;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ProfileManager {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001A\u00020\bH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/ProfileManager$Companion;", "", "()V", "ACTION_CURRENT_PROFILE_CHANGED", "", "EXTRA_NEW_PROFILE", "EXTRA_OLD_PROFILE", "instance", "Lcom/facebook/ProfileManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ProfileManager getInstance() {
            synchronized(this) {
                if(ProfileManager.instance == null) {
                    b b0 = b.a(FacebookSdk.getApplicationContext());
                    q.f(b0, "getInstance(applicationContext)");
                    ProfileManager.instance = new ProfileManager(b0, new ProfileCache());
                }
                ProfileManager profileManager0 = ProfileManager.instance;
                if(profileManager0 != null) {
                    return profileManager0;
                }
                q.m("instance");
            }
            throw null;
        }
    }

    @NotNull
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    @NotNull
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    @Nullable
    private Profile currentProfileField;
    private static volatile ProfileManager instance;
    @NotNull
    private final b localBroadcastManager;
    @NotNull
    private final ProfileCache profileCache;

    static {
        ProfileManager.Companion = new Companion(null);
    }

    public ProfileManager(@NotNull b b0, @NotNull ProfileCache profileCache0) {
        q.g(b0, "localBroadcastManager");
        q.g(profileCache0, "profileCache");
        super();
        this.localBroadcastManager = b0;
        this.profileCache = profileCache0;
    }

    @Nullable
    public final Profile getCurrentProfile() {
        return this.currentProfileField;
    }

    @NotNull
    public static final ProfileManager getInstance() {
        synchronized(ProfileManager.class) {
            return ProfileManager.Companion.getInstance();
        }
    }

    public final boolean loadCurrentProfile() {
        Profile profile0 = this.profileCache.load();
        if(profile0 != null) {
            this.setCurrentProfile(profile0, false);
            return true;
        }
        return false;
    }

    private final void sendCurrentProfileChangedBroadcast(Profile profile0, Profile profile1) {
        Intent intent0 = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent0.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile0);
        intent0.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile1);
        this.localBroadcastManager.c(intent0);
    }

    private final void setCurrentProfile(Profile profile0, boolean z) {
        Profile profile1 = this.currentProfileField;
        this.currentProfileField = profile0;
        if(z) {
            if(profile0 == null) {
                this.profileCache.clear();
            }
            else {
                this.profileCache.save(profile0);
            }
        }
        if(!Utility.areObjectsEqual(profile1, profile0)) {
            this.sendCurrentProfileChangedBroadcast(profile1, profile0);
        }
    }

    public final void setCurrentProfile(@Nullable Profile profile0) {
        this.setCurrentProfile(profile0, true);
    }
}

