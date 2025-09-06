package androidx.car.app;

import B.a;
import U4.x;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.Objects;

public final class AppInfo {
    public static final String MIN_API_LEVEL_METADATA_KEY = "androidx.car.app.minCarApiLevel";
    private final int mLatestCarAppApiLevel;
    private final String mLibraryVersion;
    private final int mMinCarAppApiLevel;

    private AppInfo() {
        this.mMinCarAppApiLevel = 0;
        this.mLibraryVersion = null;
        this.mLatestCarAppApiLevel = 0;
    }

    public AppInfo(int v, int v1, String s) {
        this.mMinCarAppApiLevel = v;
        this.mLibraryVersion = s;
        this.mLatestCarAppApiLevel = v1;
    }

    public static AppInfo create(Context context0) {
        int v = AppInfo.retrieveMinCarAppApiLevel(context0);
        if(v >= 1 && v <= a.C()) {
            return new AppInfo(v, a.C(), "1.4.0");
        }
        StringBuilder stringBuilder0 = x.n(v, "Min API level (androidx.car.app.minCarApiLevel=", ") is out of range (1-");
        stringBuilder0.append(a.C());
        stringBuilder0.append(")");
        throw new IllegalArgumentException(stringBuilder0.toString());
    }

    public int getLatestCarAppApiLevel() {
        return this.mLatestCarAppApiLevel;
    }

    public String getLibraryDisplayVersion() {
        Objects.requireNonNull(this.mLibraryVersion);
        return this.mLibraryVersion;
    }

    public int getMinCarAppApiLevel() {
        return this.mMinCarAppApiLevel;
    }

    public static int retrieveMinCarAppApiLevel(Context context0) {
        try {
            Bundle bundle0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80).metaData;
            int v = bundle0 == null ? 0 : bundle0.getInt("androidx.car.app.minCarApiLevel", 0);
            if(v == 0) {
                throw new IllegalArgumentException("Min API level not declared in manifest (androidx.car.app.minCarApiLevel)");
            }
            return v;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            throw new IllegalArgumentException("Unable to read min API level from manifest");
        }
    }

    @Override
    public String toString() {
        return "Library version: [" + this.getLibraryDisplayVersion() + "] Min Car Api Level: [" + this.getMinCarAppApiLevel() + "] Latest Car App Api Level: [" + this.getLatestCarAppApiLevel() + "]";
    }
}

