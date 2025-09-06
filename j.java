import De.w;
import com.iloen.melon.utils.datastore.common.DefaultFileCorruptionHandlerKt;
import e1.x;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;
import p2.b;

public abstract class j {
    public static final w[] a;
    public static final b b;

    static {
        z z0 = new z(j.class, "genreDataStore", "getGenreDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        j.a = new w[]{I.a.g(z0)};
        j.b = x.M("GenrePreferences", DefaultFileCorruptionHandlerKt.getDefaultPreferenceFileCorruptionHandler(), null, 12);
    }
}

