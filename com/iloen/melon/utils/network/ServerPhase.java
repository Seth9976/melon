package com.iloen.melon.utils.network;

import A8.b;
import android.text.TextUtils;
import com.iloen.melon.utils.preference.MelonPrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u000B\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000B\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0016\u0010\r\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000E\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u0007R\u0014\u0010\u000F\u001A\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0007R\u0014\u0010\u0011\u001A\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001A\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0012\u001A\u0004\b\u0014\u0010\u0015R(\u0010\u001A\u001A\u0004\u0018\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00028F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/utils/network/ServerPhase;", "", "", "prefix", "getDomainPrefixFromPreferences", "(Ljava/lang/String;)Ljava/lang/String;", "PROD_REAL_PREFIX", "Ljava/lang/String;", "PROD_PREFIX", "REL_PREFIX", "CBT_PREFIX", "SANDBOX_PREFIX", "DEV_PREFIX", "DOMAIN_PREFIX", "IMAGE_DOMAIN_PREFIX", "DEV_SUBDOMAIN_PREFIX", "", "isSandBox", "Z", "a", "isCbt", "()Z", "getDomainPrefix", "()Ljava/lang/String;", "setDomainPrefix", "(Ljava/lang/String;)V", "domainPrefix", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ServerPhase {
    public static final int $stable = 0;
    @NotNull
    public static final String CBT_PREFIX = "cbt-";
    @NotNull
    public static final String DEV_PREFIX = ".dev";
    @NotNull
    public static final String DEV_SUBDOMAIN_PREFIX = null;
    @Nullable
    public static final String DOMAIN_PREFIX = null;
    @Nullable
    public static final String IMAGE_DOMAIN_PREFIX = null;
    @NotNull
    public static final ServerPhase INSTANCE = null;
    @NotNull
    public static final String PROD_PREFIX = "prod-";
    @NotNull
    public static final String PROD_REAL_PREFIX = "";
    @NotNull
    public static final String REL_PREFIX = "rel-";
    @NotNull
    public static final String SANDBOX_PREFIX = "sandbox-";
    public static final boolean a;
    public static final boolean isSandBox;

    static {
        ServerPhase serverPhase0 = new ServerPhase();  // 初始化器: Ljava/lang/Object;-><init>()V
        ServerPhase.INSTANCE = serverPhase0;
        ServerPhase.DOMAIN_PREFIX = serverPhase0.getDomainPrefix();
        String s = serverPhase0.getDomainPrefix();
        String s1 = "";
        if("cbt-".equals(s)) {
            s = "";
        }
        ServerPhase.IMAGE_DOMAIN_PREFIX = s;
        String s2 = serverPhase0.getDomainPrefix();
        if(!TextUtils.isEmpty(s2) && ("rel-".equals(s2) || "cbt-".equals(s2) || "sandbox-".equals(s2))) {
            s1 = ".dev";
        }
        ServerPhase.DEV_SUBDOMAIN_PREFIX = s1;
        boolean z = true;
        ServerPhase.isSandBox = "sandbox-".equals(serverPhase0.getDomainPrefix()) || b.f() || b.c().equalsIgnoreCase("BETA_PLAYSTORE") || b.c().equalsIgnoreCase("BETA_ONESTORE");
        if(!"cbt-".equals(serverPhase0.getDomainPrefix()) && !b.b().equalsIgnoreCase("CBT")) {
            z = false;
        }
        ServerPhase.a = z;
    }

    @Nullable
    public final String getDomainPrefix() {
        String s = MelonPrefs.getInstance().getString("domainPrefix", "");
        if(s == null) {
            s = "";
        }
        String s1 = this.getDomainPrefixFromPreferences(s);
        if(s1 == null) {
            if(!b.f() && !b.c().equalsIgnoreCase("BETA_PLAYSTORE") && !b.c().equalsIgnoreCase("BETA_ONESTORE")) {
                return b.b().equalsIgnoreCase("CBT") ? "cbt-" : "";
            }
            return "sandbox-";
        }
        return s1;
    }

    @Nullable
    public final String getDomainPrefixFromPreferences(@NotNull String s) {
        q.g(s, "prefix");
        if(!TextUtils.isEmpty(s)) {
            if(!"rel-".equals(s) && !"cbt-".equals(s) && !"sandbox-".equals(s)) {
                return "prod-".equals(s) ? "" : null;
            }
            return s;
        }
        return null;
    }

    public final boolean isCbt() [...] // 潜在的解密器

    public final void setDomainPrefix(@Nullable String s) {
        MelonPrefs.getInstance().setString("domainPrefix", s);
    }
}

