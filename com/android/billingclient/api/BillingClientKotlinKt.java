package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import ie.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001A\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001A\u001A\u0010\u0006\u001A\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\bH\u0086@¢\u0006\u0002\u0010\t\u001A\u0012\u0010\n\u001A\u00020\u000B*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001A\u0012\u0010\r\u001A\u00020\u000E*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001A\u0012\u0010\u000F\u001A\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001A\u0012\u0010\u0010\u001A\u00020\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\f\u001A\u001A\u0010\u0011\u001A\u00020\u0012*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014\u001A\u001A\u0010\u0015\u001A\u00020\u0016*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018\u001A\u001A\u0010\u0015\u001A\u00020\u0016*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u001AH\u0087@¢\u0006\u0002\u0010\u001B\u001A\u001A\u0010\u001C\u001A\u00020\u001D*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u001EH\u0086@¢\u0006\u0002\u0010\u001F\u001A\u001A\u0010\u001C\u001A\u00020\u001D*\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u001AH\u0087@¢\u0006\u0002\u0010\u001B\u001A\u001A\u0010 \u001A\u00020!*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\"H\u0087@¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"acknowledgePurchase", "Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/BillingClient;", "params", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePurchase", "Lcom/android/billingclient/api/ConsumeResult;", "Lcom/android/billingclient/api/ConsumeParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/ConsumeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAlternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "(Lcom/android/billingclient/api/BillingClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createExternalOfferReportingDetails", "Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "isAlternativeBillingOnlyAvailable", "isExternalOfferAvailable", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetailsResult;", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryProductDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchaseHistory", "Lcom/android/billingclient/api/PurchaseHistoryResult;", "Lcom/android/billingclient/api/QueryPurchaseHistoryParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skuType", "", "(Lcom/android/billingclient/api/BillingClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchasesAsync", "Lcom/android/billingclient/api/PurchasesResult;", "Lcom/android/billingclient/api/QueryPurchasesParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchasesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySkuDetails", "Lcom/android/billingclient/api/SkuDetailsResult;", "Lcom/android/billingclient/api/SkuDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/SkuDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class BillingClientKotlinKt {
    // 检测为 Lambda 实现
    public static void $r8$lambda$1JhcD_0Y_gWWNKF2aNTk2toOOyY(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$BC2cAL2vk_I3dV-pkSAsSywRIek(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull String s) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$Bt5YvFTOU7XGqhy1u2vanp4Jc20(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull ExternalOfferReportingDetails externalOfferReportingDetails0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$Iy_vpeZ_JH-NmajeE6ZBdUlqJKA(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$Jmx2bDJUe-jQbQfqNR-Rv-qVuz0(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$NdU5wcJ8m2M9H_puX2oHpjb25-w(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$OmYoMPMU8NG-G-TTJRupXijq_ag(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$ZzkEujuP9GqFND2FbZB_kuqycGM(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$_HjOTKlijnqR-5v_YY-SPcvW1bw(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$wzezm1LgRtzooDMmMf2vgdwDzEw(@RecentlyNonNull CompletableDeferred completableDeferred0, @RecentlyNonNull BillingResult billingResult0, @RecentlyNonNull List list0) [...]

    @RecentlyNullable
    public static final Object acknowledgePurchase(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull AcknowledgePurchaseParams acknowledgePurchaseParams0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.acknowledgePurchase(acknowledgePurchaseParams0, (BillingResult billingResult0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(billingResult0);
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object consumePurchase(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull ConsumeParams consumeParams0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.consumeAsync(consumeParams0, (BillingResult billingResult0, String s) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(new ConsumeResult(billingResult0, s));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object createAlternativeBillingOnlyReportingDetails(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.createAlternativeBillingOnlyReportingDetailsAsync((BillingResult billingResult0, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult0, alternativeBillingOnlyReportingDetails0));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object createExternalOfferReportingDetails(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.createExternalOfferReportingDetailsAsync((BillingResult billingResult0, ExternalOfferReportingDetails externalOfferReportingDetails0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(new CreateExternalOfferReportingDetailsResult(billingResult0, externalOfferReportingDetails0));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object isAlternativeBillingOnlyAvailable(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.isAlternativeBillingOnlyAvailableAsync((BillingResult billingResult0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(billingResult0);
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object isExternalOfferAvailable(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.isExternalOfferAvailableAsync((BillingResult billingResult0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(billingResult0);
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object queryProductDetails(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull QueryProductDetailsParams queryProductDetailsParams0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.queryProductDetailsAsync(queryProductDetailsParams0, (BillingResult billingResult0, List list0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(new ProductDetailsResult(billingResult0, list0));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object queryPurchaseHistory(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull QueryPurchaseHistoryParams queryPurchaseHistoryParams0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.queryPurchaseHistoryAsync(queryPurchaseHistoryParams0, (BillingResult billingResult0, List list0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(new PurchaseHistoryResult(billingResult0, list0));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    @d
    public static final Object queryPurchaseHistory(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull String s, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.queryPurchaseHistoryAsync(s, (BillingResult billingResult0, List list0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(new PurchaseHistoryResult(billingResult0, list0));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    public static final Object queryPurchasesAsync(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull QueryPurchasesParams queryPurchasesParams0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.queryPurchasesAsync(queryPurchasesParams0, (BillingResult billingResult0, List list0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            q.d(list0);
            completableDeferred0.complete(new PurchasesResult(billingResult0, list0));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    @d
    public static final Object queryPurchasesAsync(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull String s, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.queryPurchasesAsync(s, (BillingResult billingResult0, List list0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            q.d(list0);
            completableDeferred0.complete(new PurchasesResult(billingResult0, list0));
        });
        return completableDeferred0.await(continuation0);
    }

    @RecentlyNullable
    @d
    public static final Object querySkuDetails(@RecentlyNonNull BillingClient billingClient0, @RecentlyNonNull SkuDetailsParams skuDetailsParams0, @RecentlyNonNull Continuation continuation0) {
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient0.querySkuDetailsAsync(skuDetailsParams0, (BillingResult billingResult0, List list0) -> {
            q.g(completableDeferred0, "$deferred");
            q.d(billingResult0);
            completableDeferred0.complete(new SkuDetailsResult(billingResult0, list0));
        });
        return completableDeferred0.await(continuation0);
    }
}

