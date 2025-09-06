package com.kakao.sdk.common.util;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001A\u00020\u0001H\u0016J\b\u0010\n\u001A\u00020\u0001H\u0016J\u0018\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\fH\u0016J\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016J\u0018\u0010\u0011\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\fH\u0016J\u0018\u0010\u0013\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u000EH\u0016J\u0010\u0010\u0014\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000EH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/kakao/sdk/common/util/SharedPrefsWrapper;", "Lcom/kakao/sdk/common/util/PersistentKVStore;", "appCache", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getAppCache", "()Landroid/content/SharedPreferences;", "editor", "Landroid/content/SharedPreferences$Editor;", "apply", "commit", "getLong", "", "key", "", "fallbackValue", "getString", "putLong", "value", "putString", "remove", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SharedPrefsWrapper implements PersistentKVStore {
    @NotNull
    private final SharedPreferences appCache;
    @NotNull
    private final SharedPreferences.Editor editor;

    public SharedPrefsWrapper(@NotNull SharedPreferences sharedPreferences0) {
        q.g(sharedPreferences0, "appCache");
        super();
        this.appCache = sharedPreferences0;
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        q.f(sharedPreferences$Editor0, "appCache.edit()");
        this.editor = sharedPreferences$Editor0;
    }

    @Override  // com.kakao.sdk.common.util.PersistentKVStore
    @NotNull
    public PersistentKVStore apply() {
        this.editor.apply();
        return this;
    }

    @Override  // com.kakao.sdk.common.util.PersistentKVStore
    @NotNull
    public PersistentKVStore commit() {
        this.editor.commit();
        return this;
    }

    @NotNull
    public final SharedPreferences getAppCache() {
        return this.appCache;
    }

    @Override  // com.kakao.sdk.common.util.PersistentKVStore
    public long getLong(@NotNull String s, long v) {
        q.g(s, "key");
        return this.appCache.getLong(s, v);
    }

    @Override  // com.kakao.sdk.common.util.PersistentKVStore
    @Nullable
    public String getString(@NotNull String s, @Nullable String s1) {
        q.g(s, "key");
        return this.appCache.getString(s, s1);
    }

    @Override  // com.kakao.sdk.common.util.PersistentKVStore
    @NotNull
    public PersistentKVStore putLong(@NotNull String s, long v) {
        q.g(s, "key");
        this.editor.putLong(s, v);
        return this;
    }

    @Override  // com.kakao.sdk.common.util.PersistentKVStore
    @NotNull
    public PersistentKVStore putString(@NotNull String s, @NotNull String s1) {
        q.g(s, "key");
        q.g(s1, "value");
        this.editor.putString(s, s1);
        return this;
    }

    @Override  // com.kakao.sdk.common.util.PersistentKVStore
    @NotNull
    public PersistentKVStore remove(@NotNull String s) {
        q.g(s, "key");
        this.editor.remove(s);
        return this;
    }
}

