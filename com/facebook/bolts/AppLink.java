package com.facebook.bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000EB%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u000F"}, d2 = {"Lcom/facebook/bolts/AppLink;", "", "sourceUrl", "Landroid/net/Uri;", "targets", "", "Lcom/facebook/bolts/AppLink$Target;", "webUrl", "(Landroid/net/Uri;Ljava/util/List;Landroid/net/Uri;)V", "getSourceUrl", "()Landroid/net/Uri;", "getTargets", "()Ljava/util/List;", "getWebUrl", "Target", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppLink {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/facebook/bolts/AppLink$Target;", "", "packageName", "", "className", "url", "Landroid/net/Uri;", "appName", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getClassName", "getPackageName", "getUrl", "()Landroid/net/Uri;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Target {
        @NotNull
        private final String appName;
        @NotNull
        private final String className;
        @NotNull
        private final String packageName;
        @NotNull
        private final Uri url;

        public Target(@NotNull String s, @NotNull String s1, @NotNull Uri uri0, @NotNull String s2) {
            q.g(s, "packageName");
            q.g(s1, "className");
            q.g(uri0, "url");
            q.g(s2, "appName");
            super();
            this.packageName = s;
            this.className = s1;
            this.url = uri0;
            this.appName = s2;
        }

        @NotNull
        public final String getAppName() {
            return this.appName;
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        @NotNull
        public final String getPackageName() {
            return this.packageName;
        }

        @NotNull
        public final Uri getUrl() {
            return this.url;
        }
    }

    @NotNull
    private final Uri sourceUrl;
    @NotNull
    private final List targets;
    @NotNull
    private final Uri webUrl;

    public AppLink(@NotNull Uri uri0, @Nullable List list0, @NotNull Uri uri1) {
        q.g(uri0, "sourceUrl");
        q.g(uri1, "webUrl");
        super();
        this.sourceUrl = uri0;
        this.webUrl = uri1;
        if(list0 == null) {
            list0 = w.a;
        }
        this.targets = list0;
    }

    @NotNull
    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    @NotNull
    public final List getTargets() {
        List list0 = Collections.unmodifiableList(this.targets);
        q.f(list0, "unmodifiableList(field)");
        return list0;
    }

    @NotNull
    public final Uri getWebUrl() {
        return this.webUrl;
    }
}

