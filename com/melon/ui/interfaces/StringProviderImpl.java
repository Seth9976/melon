package com.melon.ui.interfaces;

import Pc.d;
import android.content.Context;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/ui/interfaces/StringProviderImpl;", "LPc/d;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StringProviderImpl implements d {
    public final Context a;

    @Inject
    public StringProviderImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
    }

    public final String a(int v) {
        String s = this.a.getString(v);
        q.f(s, "getString(...)");
        return s;
    }

    public final String b(int v, Object[] arr_object) {
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
        String s = this.a.getString(v, arr_object1);
        q.f(s, "getString(...)");
        return s;
    }
}

