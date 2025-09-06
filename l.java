import De.w;
import com.iloen.melon.utils.datastore.MelonTiaraUserInfoPreferencesSerializer;
import com.iloen.melon.utils.datastore.common.DefaultFileCorruptionHandlerKt;
import d8.d;
import k2.c;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;
import m2.a;

public abstract class l {
    public static final w[] a;
    public static final c b;

    static {
        z z0 = new z(l.class, "melonTiaraUserInfoDataStore", "getMelonTiaraUserInfoDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        l.a = new w[]{I.a.g(z0)};
        a a0 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(MelonTiaraUserInfoPreferencesSerializer.INSTANCE);
        l.b = d.n("melon_tiara_user_info_pref.pb", MelonTiaraUserInfoPreferencesSerializer.INSTANCE.getSerializer(), a0, null, 24);
    }
}

