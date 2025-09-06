package co.ab180.airbridge.internal.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0010J\u0017\u0010\u0014\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0010J\u001F\u0010\u0016\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u000EJQ\u0010 \u001A\u0004\u0018\u00010\u001F2\u0006\u0010\u0018\u001A\u00020\u00172\u0010\u0010\u001B\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u001A\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001A2\u0010\u0010\u001D\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u001A\u0018\u00010\u00192\b\u0010\u001E\u001A\u0004\u0018\u00010\u001AH\u0016\u00A2\u0006\u0004\b \u0010!J\u0019\u0010\"\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0018\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\"\u0010#J#\u0010&\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001A\u00020\u00172\b\u0010%\u001A\u0004\u0018\u00010$H\u0016\u00A2\u0006\u0004\b&\u0010\'J3\u0010)\u001A\u00020(2\u0006\u0010\u0018\u001A\u00020\u00172\b\u0010\u001C\u001A\u0004\u0018\u00010\u001A2\u0010\u0010\u001D\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u001A\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b)\u0010*J=\u0010+\u001A\u00020(2\u0006\u0010\u0018\u001A\u00020\u00172\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001A2\u0010\u0010\u001D\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u001A\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b+\u0010,R\u0014\u00100\u001A\u00020-8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/\u00A8\u00061"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/LifecycleProvider;", "Landroid/content/ContentProvider;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "", "onCreate", "()Z", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityStarted", "onActivityStopped", "onActivityResumed", "onActivityPaused", "outState", "onActivitySaveInstanceState", "Landroid/net/Uri;", "uri", "", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Lco/ab180/airbridge/internal/lifecycle/d;", "a", "Lco/ab180/airbridge/internal/lifecycle/d;", "delegate", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class LifecycleProvider extends ContentProvider implements Application.ActivityLifecycleCallbacks {
    private final d a;

    public LifecycleProvider() {
        this.a = new d();
    }

    @Override  // android.content.ContentProvider
    public int delete(@NotNull Uri uri0, @Nullable String s, @Nullable String[] arr_s) {
        return 0;
    }

    @Override  // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri0) {
        return null;
    }

    @Override  // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri0, @Nullable ContentValues contentValues0) {
        return null;
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
        this.a.onActivityCreated(activity0, bundle0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity0) {
        this.a.onActivityDestroyed(activity0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity0) {
        this.a.onActivityResumed(activity0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity0, @NotNull Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity0) {
        this.a.onActivityStarted(activity0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity0) {
        this.a.onActivityStopped(activity0);
    }

    @Override  // android.content.ContentProvider
    public boolean onCreate() {
        Context context0 = this.getContext();
        Context context1 = context0 == null ? null : context0.getApplicationContext();
        if(context1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        ((Application)context1).unregisterActivityLifecycleCallbacks(this);
        ((Application)context1).registerActivityLifecycleCallbacks(this);
        return true;
    }

    @Override  // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri0, @Nullable String[] arr_s, @Nullable String s, @Nullable String[] arr_s1, @Nullable String s1) {
        Context context0 = this.getContext();
        Context context1 = context0 == null ? null : context0.getApplicationContext();
        if(context1 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        String s2 = uri0.getPath();
        if(s2 != null) {
            switch(s2) {
                case "/registerActivityLifecycle": {
                    ((Application)context1).unregisterActivityLifecycleCallbacks(this);
                    ((Application)context1).registerActivityLifecycleCallbacks(this);
                    return null;
                }
                case "/unregisterActivityLifecycle": {
                    ((Application)context1).unregisterActivityLifecycleCallbacks(this);
                    break;
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    @Override  // android.content.ContentProvider
    public int update(@NotNull Uri uri0, @Nullable ContentValues contentValues0, @Nullable String s, @Nullable String[] arr_s) {
        return 0;
    }
}

