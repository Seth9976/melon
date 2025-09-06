package ec;

import Ob.b;
import android.net.Uri;
import com.iloen.melon.mcache.CacheUrlBuilder;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import k9.d;
import kotlin.jvm.internal.q;

public final class g {
    public static final g a;
    public static final LogU b;

    static {
        g.a = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g.b = Companion.create$default(LogU.Companion, "OfflineModeHelper", false, Category.Playback, 2, null);
    }

    public static String a(PremiumContentsEntity premiumContentsEntity0) {
        String s3;
        String s = d.b;
        if(!new File(s, premiumContentsEntity0.j).exists()) {
            return "";
        }
        CacheUrlBuilder cacheUrlBuilder0 = new CacheUrlBuilder(Uri.fromFile(new File(s, premiumContentsEntity0.j)).toString(), premiumContentsEntity0.b);
        cacheUrlBuilder0.cacheEnable(b.b());
        cacheUrlBuilder0.bitrate(premiumContentsEntity0.e);
        cacheUrlBuilder0.metaType(premiumContentsEntity0.d);
        cacheUrlBuilder0.contentType(premiumContentsEntity0.f);
        cacheUrlBuilder0.isLocal(true);
        String s1 = cacheUrlBuilder0.build();
        q.f(s1, "build(...)");
        String s2 = premiumContentsEntity0.g;
        LogU.d("OfflineContentsManager", "makeC()");
        try {
            s3 = null;
            s3 = MelonCryptoManager.decrypt(s2);
        }
        catch(Exception unused_ex) {
        }
        q.f(s3, "makeC(...)");
        return b.c(s1, s3);
    }
}

