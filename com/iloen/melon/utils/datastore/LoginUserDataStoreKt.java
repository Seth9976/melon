package com.iloen.melon.utils.datastore;

import De.w;
import android.content.Context;
import com.iloen.melon.utils.datastore.common.DefaultFileCorruptionHandlerKt;
import d8.d;
import k2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import l2.i;
import m2.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"%\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/content/Context;", "Ll2/i;", "Lcom/iloen/melon/LoginUser;", "b", "Lze/b;", "getLoginUserDataStore", "(Landroid/content/Context;)Ll2/i;", "loginUserDataStore", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class LoginUserDataStoreKt {
    public static final w[] a;
    public static final c b;

    static {
        z z0 = new z(LoginUserDataStoreKt.class, "loginUserDataStore", "getLoginUserDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        LoginUserDataStoreKt.a = new w[]{I.a.g(z0)};
        a a0 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(LoginUserPreferencesSerializer.INSTANCE);
        com.iloen.melon.utils.datastore.a a1 = new com.iloen.melon.utils.datastore.a(3);
        LoginUserDataStoreKt.b = d.n("login_user_prefs.pb", LoginUserPreferencesSerializer.INSTANCE.getSerializer(), a0, a1, 16);
    }

    @NotNull
    public static final i getLoginUserDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)LoginUserDataStoreKt.b.getValue(context0, LoginUserDataStoreKt.a[0]);
    }
}

