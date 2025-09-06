package com.iloen.melon.utils.log;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/utils/log/Category;", "", "UI", "Playback", "Analytics", "LocalSync", "Download", "Login", "None", "Http", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum Category {
    UI,
    Playback,
    Analytics,
    LocalSync,
    Download,
    Login,
    None,
    Http;

    public static final Category[] a;
    public static final b b;

    static {
        Category.a = arr_category;
        q.g(arr_category, "entries");
        Category.b = new b(arr_category);
    }

    @NotNull
    public static a getEntries() {
        return Category.b;
    }
}

