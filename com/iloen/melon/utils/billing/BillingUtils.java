package com.iloen.melon.utils.billing;

import A8.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/billing/BillingUtils;", "", "", "getBillingType", "()Ljava/lang/String;", "BILLING_TYPE_PG", "Ljava/lang/String;", "BILLING_TYPE_GOOGLE", "BILLING_TYPE_ONE_STORE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BillingUtils {
    public static final int $stable = 0;
    @NotNull
    public static final String BILLING_TYPE_GOOGLE = "GOOGLE";
    @NotNull
    public static final String BILLING_TYPE_ONE_STORE = "ONE_STORE";
    @NotNull
    public static final String BILLING_TYPE_PG = "PG";
    @NotNull
    public static final BillingUtils INSTANCE;

    static {
        BillingUtils.INSTANCE = new BillingUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public static final String getBillingType() {
        if(!b.c().equalsIgnoreCase("ONESTORE") && !b.c().equalsIgnoreCase("BETA_ONESTORE")) {
            return b.c().equalsIgnoreCase("PLAYSTORE") || b.c().equalsIgnoreCase("BETA_PLAYSTORE") ? "GOOGLE" : "PG";
        }
        return "ONE_STORE";
    }
}

