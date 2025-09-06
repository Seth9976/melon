package l4;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public final class u {
    public final Bundle a;

    public u(Bundle bundle0) {
        this.a = bundle0;
    }

    public final HashSet a() {
        return this.a.containsKey("allowedPackages") ? new HashSet(this.a.getStringArrayList("allowedPackages")) : new HashSet();
    }

    public final ArrayList b() {
        return this.a.containsKey("controlFilters") ? new ArrayList(this.a.getParcelableArrayList("controlFilters")) : new ArrayList();
    }

    public final int c() {
        return this.a.getInt("deviceType");
    }

    public final ArrayList d() {
        return this.a.containsKey("groupMemberIds") ? new ArrayList(this.a.getStringArrayList("groupMemberIds")) : new ArrayList();
    }

    public final Uri e() {
        String s = this.a.getString("iconUri");
        return s == null ? null : Uri.parse(s);
    }

    public final String f() {
        return this.a.getString("id");
    }

    public final String g() {
        return this.a.getString("name");
    }

    public final int h() {
        return this.a.getInt("volume");
    }

    public final int i() {
        return this.a.getInt("volumeHandling", 0);
    }

    public final int j() {
        return this.a.getInt("volumeMax");
    }

    // 去混淆评级： 低(30)
    public final boolean k() {
        return !TextUtils.isEmpty(this.f()) && !TextUtils.isEmpty(this.g()) && !this.b().contains(null);
    }

    @Override
    public final String toString() {
        return "MediaRouteDescriptor{ id=" + this.f() + ", groupMemberIds=" + this.d() + ", name=" + this.g() + ", description=" + this.a.getString("status") + ", iconUri=" + this.e() + ", isEnabled=" + this.a.getBoolean("enabled", true) + ", isSystemRoute=" + this.a.getBoolean("isSystemRoute", false) + ", connectionState=" + this.a.getInt("connectionState", 0) + ", controlFilters=" + Arrays.toString(this.b().toArray()) + ", playbackType=" + this.a.getInt("playbackType", 1) + ", playbackStream=" + this.a.getInt("playbackStream", -1) + ", deviceType=" + this.c() + ", volume=" + this.h() + ", volumeMax=" + this.j() + ", volumeHandling=" + this.i() + ", presentationDisplayId=" + this.a.getInt("presentationDisplayId", -1) + ", extras=" + this.a.getBundle("extras") + ", isValid=" + this.k() + ", minClientVersion=" + this.a.getInt("minClientVersion", 1) + ", maxClientVersion=" + this.a.getInt("maxClientVersion", 0x7FFFFFFF) + ", isVisibilityPublic=" + this.a.getBoolean("isVisibilityPublic", true) + ", allowedPackages=" + Arrays.toString(this.a().toArray()) + " }";
    }
}

