package com.iloen.melon.utils.system;

import Gd.e;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\t\u001A\u0004\u0018\u0001H\n\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000B2\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u000E\b\u0001\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\n0\u0011H\u0007¢\u0006\u0002\u0010\u0012JC\u0010\u0013\u001A\u0004\u0018\u0001H\n\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000B2\n\b\u0001\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0001\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u000E\b\u0001\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\n0\u0011H\u0007¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001A\u0004\u0018\u0001H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000B*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\b¢\u0006\u0002\u0010\u0018J(\u0010\u0019\u001A\u0004\u0018\u0001H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000B*\u00020\u00152\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\b¢\u0006\u0002\u0010\u001AJ(\u0010\u001B\u001A\u0004\u0018\u0001H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u001C*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\b¢\u0006\u0002\u0010\u001DJ5\u0010\u001E\u001A\u0016\u0012\u0004\u0012\u0002H\n\u0018\u00010\u001Fj\n\u0012\u0004\u0012\u0002H\n\u0018\u0001` \"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u001C*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0086\bR\u001A\u0010\u0004\u001A\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lcom/iloen/melon/utils/system/CompatUtils;", "", "<init>", "()V", "version", "", "getVersion$annotations", "getVersion", "()I", "getSerializable", "T", "Ljava/io/Serializable;", "bundle", "Landroid/os/Bundle;", "key", "", "clazz", "Ljava/lang/Class;", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;", "getSerializableExtra", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Ljava/io/Serializable;", "getSerializableCompat", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "getSerializableExtraCompat", "(Landroid/content/Intent;Ljava/lang/String;)Ljava/io/Serializable;", "getParcelableCompat", "Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableArrayListCompat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CompatUtils {
    public static final int $stable;
    @NotNull
    public static final CompatUtils INSTANCE;

    static {
        CompatUtils.INSTANCE = new CompatUtils();
    }

    public final ArrayList getParcelableArrayListCompat(Bundle bundle0, String s) {
        q.g(bundle0, "<this>");
        q.g(s, "key");
        q.k();
        throw null;
    }

    public final Parcelable getParcelableCompat(Bundle bundle0, String s) {
        q.g(bundle0, "<this>");
        q.g(s, "key");
        q.k();
        throw null;
    }

    @Nullable
    public static final Serializable getSerializable(@Nullable Bundle bundle0, @Nullable String s, @NotNull Class class0) {
        q.g(class0, "clazz");
        return bundle0 == null ? null : e.q(bundle0, s, class0);
    }

    public final Serializable getSerializableCompat(Bundle bundle0, String s) {
        q.g(bundle0, "<this>");
        q.g(s, "key");
        q.k();
        throw null;
    }

    @Nullable
    public static final Serializable getSerializableExtra(@Nullable Intent intent0, @Nullable String s, @NotNull Class class0) {
        q.g(class0, "clazz");
        return intent0 == null ? null : e.p(intent0, s, class0);
    }

    public final Serializable getSerializableExtraCompat(Intent intent0, String s) {
        q.g(intent0, "<this>");
        q.g(s, "key");
        q.k();
        throw null;
    }

    public static final int getVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static void getVersion$annotations() {
    }
}

