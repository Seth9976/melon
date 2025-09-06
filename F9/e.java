package f9;

import com.iloen.melon.mcache.MelonStreamCacheManager;
import com.iloen.melon.mcache.error.CodecErrorDebugLog;
import h9.f;

public abstract class e {
    public static final MelonStreamCacheManager a;

    static {
        MelonStreamCacheManager melonStreamCacheManager0 = new MelonStreamCacheManager();  // 初始化器: Ljava/lang/Object;-><init>()V
        melonStreamCacheManager0.a = "none_user_agent";
        melonStreamCacheManager0.codecErrorDebugLog = new CodecErrorDebugLog();
        melonStreamCacheManager0.b = new h();
        f.b("MelonStreamCacheManager", "============== MCACHE ====================\nGit Revision: 802c3c0\nBuild Date: 20250416.090702\nBuild Type: release\n==================================================");
        e.a = melonStreamCacheManager0;
    }
}

