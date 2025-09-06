package com.facebook.appevents.iap;

import D5.a;
import Tf.l;
import Tf.n;
import android.content.Context;
import android.util.Log;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import je.p;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0010\b\u0007\u0018\u0000 U2\u00020\u0001:\u0002UVB\u0085\u0003\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0017\u001A\u00020\u0016\u0012\u0006\u0010\u0018\u001A\u00020\u0016\u0012\u0006\u0010\u0019\u001A\u00020\u0016\u0012\u0006\u0010\u001A\u001A\u00020\u0016\u0012\u0006\u0010\u001B\u001A\u00020\u0016\u0012\u0006\u0010\u001C\u001A\u00020\u0016\u0012\u0006\u0010\u001D\u001A\u00020\u0016\u0012\u0006\u0010\u001E\u001A\u00020\u0016\u0012\u0006\u0010\u001F\u001A\u00020\u0016\u0012\u0006\u0010 \u001A\u00020\u0016\u0012\u0006\u0010!\u001A\u00020\u0016\u0012\u0006\u0010\"\u001A\u00020\u0016\u0012\u0006\u0010#\u001A\u00020\u0016\u0012\u0006\u0010$\u001A\u00020\u0016\u0012\u0006\u0010%\u001A\u00020\u0016\u0012\u0006\u0010&\u001A\u00020\u0016\u0012\u0006\u0010\'\u001A\u00020\u0016\u0012\u0006\u0010(\u001A\u00020\u0016\u0012\u0006\u0010)\u001A\u00020\u0016\u0012\u0006\u0010*\u001A\u00020\u0016\u0012\u0006\u0010+\u001A\u00020\u0016\u00A2\u0006\u0004\b,\u0010-J\u001F\u00103\u001A\u0002022\u0006\u0010/\u001A\u00020.2\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b3\u00104J\u001F\u00105\u001A\u0002022\u0006\u0010/\u001A\u00020.2\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b5\u00104J\u0017\u00108\u001A\u0004\u0018\u0001062\u0006\u00107\u001A\u000206\u00A2\u0006\u0004\b8\u00109J\u0019\u0010:\u001A\u0004\u0018\u00010\u00022\u0006\u0010/\u001A\u00020.H\u0002\u00A2\u0006\u0004\b:\u0010;J\u0019\u0010<\u001A\u0004\u0018\u00010\u00022\u0006\u0010/\u001A\u00020.H\u0002\u00A2\u0006\u0004\b<\u0010;J)\u0010?\u001A\u0004\u0018\u00010\u00022\u0006\u0010/\u001A\u00020.2\u000E\u0010>\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001060=H\u0002\u00A2\u0006\u0004\b?\u0010@J-\u0010A\u001A\u0002022\u0006\u0010/\u001A\u00020.2\f\u0010>\u001A\b\u0012\u0004\u0012\u0002060=2\u0006\u00101\u001A\u000200H\u0002\u00A2\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001A\u0002022\u0006\u0010C\u001A\u000200H\u0002\u00A2\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001A\u0002022\u0006\u0010C\u001A\u000200H\u0002\u00A2\u0006\u0004\bF\u0010EJ/\u0010J\u001A\u0002022\u000E\u0010H\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010G2\u000E\u0010I\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010GH\u0002\u00A2\u0006\u0004\bJ\u0010KJ/\u0010L\u001A\u0002022\u000E\u0010H\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010G2\u000E\u0010I\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010GH\u0002\u00A2\u0006\u0004\bL\u0010KJ/\u0010M\u001A\u0002022\u000E\u0010H\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010G2\u000E\u0010I\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010GH\u0002\u00A2\u0006\u0004\bM\u0010KJ/\u0010N\u001A\u0002022\u000E\u0010H\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010G2\u000E\u0010I\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010GH\u0002\u00A2\u0006\u0004\bN\u0010KJ/\u0010O\u001A\u0002022\u000E\u0010H\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010G2\u000E\u0010I\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010GH\u0002\u00A2\u0006\u0004\bO\u0010KR\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010P\u001A\u0004\bQ\u0010RR\u0018\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010SR\u0018\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010SR\u0018\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010SR\u0018\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010SR\u0018\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010SR\u0018\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010SR\u0018\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010SR\u0018\u0010\f\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\f\u0010SR\u0018\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\r\u0010SR\u0018\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000E\u0010SR\u0018\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000F\u0010SR\u0018\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0010\u0010SR\u0018\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0011\u0010SR\u0018\u0010\u0012\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0012\u0010SR\u0018\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0013\u0010SR\u0018\u0010\u0014\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0014\u0010SR\u0018\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0015\u0010SR\u0014\u0010\u0017\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0017\u0010TR\u0014\u0010\u0018\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0018\u0010TR\u0014\u0010\u0019\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0019\u0010TR\u0014\u0010\u001A\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001A\u0010TR\u0014\u0010\u001B\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001B\u0010TR\u0014\u0010\u001C\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001C\u0010TR\u0014\u0010\u001D\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001D\u0010TR\u0014\u0010\u001E\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001E\u0010TR\u0014\u0010\u001F\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001F\u0010TR\u0014\u0010 \u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b \u0010TR\u0014\u0010!\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b!\u0010TR\u0014\u0010\"\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\"\u0010TR\u0014\u0010#\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010TR\u0014\u0010$\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b$\u0010TR\u0014\u0010%\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010TR\u0014\u0010&\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b&\u0010TR\u0014\u0010\'\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010TR\u0014\u0010(\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b(\u0010TR\u0014\u0010)\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010TR\u0014\u0010*\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010TR\u0014\u0010+\u001A\u00020\u00168\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010T\u00A8\u0006W"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "billingClient", "Ljava/lang/Class;", "billingClientClazz", "purchaseClazz", "productDetailsClazz", "purchaseHistoryRecordClazz", "queryProductDetailsParamsProductClazz", "billingResultClazz", "queryProductDetailsParamsClazz", "queryPurchaseHistoryParamsClazz", "queryPurchasesParamsClazz", "queryProductDetailsParamsBuilderClazz", "queryPurchaseHistoryParamsBuilderClazz", "queryPurchasesParamsBuilderClazz", "queryProductDetailsParamsProductBuilderClazz", "billingClientStateListenerClazz", "productDetailsResponseListenerClazz", "purchasesResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "Ljava/lang/reflect/Method;", "queryPurchasesAsyncMethod", "queryPurchasesParamsNewBuilderMethod", "queryPurchasesParamsBuilderBuildMethod", "queryPurchasesParamsBuilderSetProductTypeMethod", "purchaseGetOriginalJsonMethod", "queryPurchaseHistoryAsyncMethod", "queryPurchaseHistoryParamsNewBuilderMethod", "queryPurchaseHistoryParamsBuilderBuildMethod", "queryPurchaseHistoryParamsBuilderSetProductTypeMethod", "purchaseHistoryRecordGetOriginalJsonMethod", "queryProductDetailsAsyncMethod", "queryProductDetailsParamsNewBuilderMethod", "queryProductDetailsParamsBuilderBuildMethod", "queryProductDetailsParamsBuilderSetProductListMethod", "queryProductDetailsParamsProductNewBuilderMethod", "queryProductDetailsParamsProductBuilderBuildMethod", "queryProductDetailsParamsProductBuilderSetProductIdMethod", "queryProductDetailsParamsProductBuilderSetProductTypeMethod", "productDetailsToStringMethod", "billingClientStartConnectionMethod", "billingResultGetResponseCodeMethod", "<init>", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "productType", "Ljava/lang/Runnable;", "completionHandler", "Lie/H;", "queryPurchases", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/lang/Runnable;)V", "queryPurchaseHistory", "", "productDetailsString", "getOriginalJson", "(Ljava/lang/String;)Ljava/lang/String;", "getQueryPurchasesParams", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;)Ljava/lang/Object;", "getQueryPurchaseHistoryParams", "", "productIds", "getQueryProductDetailsParams", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/util/List;)Ljava/lang/Object;", "queryProductDetailsAsync", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/util/List;Ljava/lang/Runnable;)V", "runnable", "executeServiceRequest", "(Ljava/lang/Runnable;)V", "startConnection", "", "wrapperArgs", "listenerArgs", "onQueryPurchasesResponse", "([Ljava/lang/Object;[Ljava/lang/Object;)V", "onPurchaseHistoryResponse", "onProductDetailsResponse", "onBillingSetupFinished", "onBillingServiceDisconnected", "Ljava/lang/Object;", "getBillingClient", "()Ljava/lang/Object;", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "Companion", "ListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseBillingClientWrapperV5V7 implements InAppPurchaseBillingClientWrapper {
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001A\u00020\u00172\n\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u001B\u001A\u0006\u0012\u0002\b\u00030\u0019H\u0002J\u0012\u0010\u001C\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0012\u0010\u001D\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001A\u00020\u0017H\u0007J0\u0010\u001E\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u001F\u001A\u00020\u00152\u0006\u0010 \u001A\u00020!2\u000E\u0010\"\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010#H\u0096\u0002¢\u0006\u0002\u0010$R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000FR\u001D\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\nR\u001D\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\n¨\u0006%"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7$Companion;", "Ljava/lang/reflect/InvocationHandler;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "iapPurchaseDetailsMap", "", "Lorg/json/JSONObject;", "getIapPurchaseDetailsMap", "()Ljava/util/Map;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "isServiceConnected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "productDetailsMap", "getProductDetailsMap", "subsPurchaseDetailsMap", "getSubsPurchaseDetailsMap", "createBillingClient", "", "context", "Landroid/content/Context;", "billingClientClazz", "Ljava/lang/Class;", "billingClientBuilderClazz", "purchasesUpdatedListenerClazz", "createInstance", "getOrCreateInstance", "invoke", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion implements InvocationHandler {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final Object createBillingClient(Context context0, Class class0, Class class1, Class class2) {
            Method method0 = InAppPurchaseUtils.getMethod(class0, "newBuilder", new Class[]{Context.class});
            Method method1 = InAppPurchaseUtils.getMethod(class1, "setListener", new Class[]{class2});
            Method method2 = InAppPurchaseUtils.getMethod(class1, "enablePendingPurchases", new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(class1, "build", new Class[0]);
            if(method3 != null && method1 != null && method0 != null && method2 != null) {
                Object object0 = InAppPurchaseUtils.invokeMethod(class1, method1, InAppPurchaseUtils.invokeMethod(class0, method0, null, new Object[]{context0}), new Object[]{Proxy.newProxyInstance(class2.getClassLoader(), new Class[]{class2}, this)});
                return object0 == null ? null : InAppPurchaseUtils.invokeMethod(class1, method3, InAppPurchaseUtils.invokeMethod(class1, method2, object0, new Object[0]), new Object[0]);
            }
            return null;
        }

        private final InAppPurchaseBillingClientWrapperV5V7 createInstance(Context context0) {
            Class class0 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClient");
            Class class1 = InAppPurchaseUtils.getClass("com.android.billingclient.api.Purchase");
            Class class2 = InAppPurchaseUtils.getClass("com.android.billingclient.api.ProductDetails");
            Class class3 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchaseHistoryRecord");
            Class class4 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams$Product");
            Class class5 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingResult");
            Class class6 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams");
            Class class7 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchaseHistoryParams");
            Class class8 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchasesParams");
            Class class9 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams$Builder");
            Class class10 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchaseHistoryParams$Builder");
            Class class11 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchasesParams$Builder");
            Class class12 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams$Product$Builder");
            Class class13 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClient$Builder");
            Class class14 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesUpdatedListener");
            Class class15 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClientStateListener");
            Class class16 = InAppPurchaseUtils.getClass("com.android.billingclient.api.ProductDetailsResponseListener");
            Class class17 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesResponseListener");
            Class class18 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchaseHistoryResponseListener");
            if(class0 == null || class1 == null || class2 == null || class3 == null || class4 == null || class5 == null || class6 == null || class7 == null || class8 == null || class9 == null || class10 == null || class11 == null || class12 == null || class13 == null || class14 == null || class15 == null || class16 == null || class17 == null || class18 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Method method0 = InAppPurchaseUtils.getMethod(class0, "queryPurchasesAsync", new Class[]{class8, class17});
            Method method1 = InAppPurchaseUtils.getMethod(class8, "newBuilder", new Class[0]);
            Method method2 = InAppPurchaseUtils.getMethod(class11, "build", new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(class11, "setProductType", new Class[]{String.class});
            Method method4 = InAppPurchaseUtils.getMethod(class1, "getOriginalJson", new Class[0]);
            Method method5 = InAppPurchaseUtils.getMethod(class0, "queryPurchaseHistoryAsync", new Class[]{class7, class18});
            Method method6 = InAppPurchaseUtils.getMethod(class7, "newBuilder", new Class[0]);
            Method method7 = InAppPurchaseUtils.getMethod(class10, "build", new Class[0]);
            Method method8 = InAppPurchaseUtils.getMethod(class10, "setProductType", new Class[]{String.class});
            Method method9 = InAppPurchaseUtils.getMethod(class3, "getOriginalJson", new Class[0]);
            Method method10 = InAppPurchaseUtils.getMethod(class0, "queryProductDetailsAsync", new Class[]{class6, class16});
            Method method11 = InAppPurchaseUtils.getMethod(class6, "newBuilder", new Class[0]);
            Method method12 = InAppPurchaseUtils.getMethod(class9, "build", new Class[0]);
            Method method13 = InAppPurchaseUtils.getMethod(class9, "setProductList", new Class[]{List.class});
            Method method14 = InAppPurchaseUtils.getMethod(class4, "newBuilder", new Class[0]);
            Method method15 = InAppPurchaseUtils.getMethod(class12, "build", new Class[0]);
            Method method16 = InAppPurchaseUtils.getMethod(class12, "setProductId", new Class[]{String.class});
            Method method17 = InAppPurchaseUtils.getMethod(class12, "setProductType", new Class[]{String.class});
            Method method18 = InAppPurchaseUtils.getMethod(class2, "toString", new Class[0]);
            Method method19 = InAppPurchaseUtils.getMethod(class0, "startConnection", new Class[]{class15});
            Method method20 = InAppPurchaseUtils.getMethod(class5, "getResponseCode", new Class[0]);
            if(method0 != null && method1 != null && method2 != null && method3 != null && method4 != null && method5 != null && method6 != null && method7 != null && method8 != null && method9 != null && method10 != null && method11 != null && method12 != null && method13 != null && method14 != null && method15 != null && method16 != null && method17 != null && method18 != null && method19 != null && method20 != null) {
                Object object0 = this.createBillingClient(context0, class0, class13, class14);
                if(object0 == null) {
                    Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to build a Google Play billing library wrapper for in-app purchase auto-logging");
                    return null;
                }
                InAppPurchaseBillingClientWrapperV5V7.access$setInstance$cp(new InAppPurchaseBillingClientWrapperV5V7(object0, class0, class1, class2, class3, class4, class5, class6, class7, class8, class9, class10, class11, class12, class15, class16, class17, class18, method0, method1, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20, null));
                return InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
            }
            Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
            return null;
        }

        @NotNull
        public final Map getIapPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getIapPurchaseDetailsMap$cp();
        }

        @Nullable
        public final InAppPurchaseBillingClientWrapperV5V7 getOrCreateInstance(@NotNull Context context0) {
            synchronized(this) {
                q.g(context0, "context");
                InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70 = InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
                if(inAppPurchaseBillingClientWrapperV5V70 == null) {
                    inAppPurchaseBillingClientWrapperV5V70 = this.createInstance(context0);
                }
                return inAppPurchaseBillingClientWrapperV5V70;
            }
        }

        @NotNull
        public final Map getProductDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getProductDetailsMap$cp();
        }

        @NotNull
        public final Map getSubsPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getSubsPurchaseDetailsMap$cp();
        }

        @Override
        @Nullable
        public Object invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(object0, "proxy");
            q.g(method0, "m");
            return null;
        }

        @NotNull
        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapperV5V7.access$isServiceConnected$cp();
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000E\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\n2\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7$ListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "wrapperArgs", "", "", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "invoke", "proxy", "m", "Ljava/lang/reflect/Method;", "listenerArgs", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class ListenerWrapper implements InvocationHandler {
        @Nullable
        private Object[] wrapperArgs;

        public ListenerWrapper(@Nullable Object[] arr_object) {
            this.wrapperArgs = arr_object;
        }

        @Override
        @Nullable
        public Object invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            q.g(object0, "proxy");
            q.g(method0, "m");
            String s = method0.getName();
            if(s != null) {
                switch(s) {
                    case "onBillingServiceDisconnected": {
                        InAppPurchaseBillingClientWrapperV5V7.access$onBillingServiceDisconnected(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, arr_object);
                        return null;
                    }
                    case "onBillingSetupFinished": {
                        InAppPurchaseBillingClientWrapperV5V7.access$onBillingSetupFinished(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, arr_object);
                        return null;
                    }
                    case "onProductDetailsResponse": {
                        InAppPurchaseBillingClientWrapperV5V7.access$onProductDetailsResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, arr_object);
                        return null;
                    }
                    case "onPurchaseHistoryResponse": {
                        InAppPurchaseBillingClientWrapperV5V7.access$onPurchaseHistoryResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, arr_object);
                        break;
                    }
                    case "onQueryPurchasesResponse": {
                        InAppPurchaseBillingClientWrapperV5V7.access$onQueryPurchasesResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, arr_object);
                        return null;
                    }
                    default: {
                        return null;
                    }
                }
            }
            return null;
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final String TAG;
    @NotNull
    private final Object billingClient;
    @NotNull
    private final Class billingClientClazz;
    @NotNull
    private final Method billingClientStartConnectionMethod;
    @NotNull
    private final Class billingClientStateListenerClazz;
    @NotNull
    private final Class billingResultClazz;
    @NotNull
    private final Method billingResultGetResponseCodeMethod;
    @NotNull
    private static final Map iapPurchaseDetailsMap;
    @Nullable
    private static InAppPurchaseBillingClientWrapperV5V7 instance;
    @NotNull
    private static final AtomicBoolean isServiceConnected;
    @NotNull
    private final Class productDetailsClazz;
    @NotNull
    private static final Map productDetailsMap;
    @NotNull
    private final Class productDetailsResponseListenerClazz;
    @NotNull
    private final Method productDetailsToStringMethod;
    @NotNull
    private final Class purchaseClazz;
    @NotNull
    private final Method purchaseGetOriginalJsonMethod;
    @NotNull
    private final Class purchaseHistoryRecordClazz;
    @NotNull
    private final Method purchaseHistoryRecordGetOriginalJsonMethod;
    @NotNull
    private final Class purchaseHistoryResponseListenerClazz;
    @NotNull
    private final Class purchasesResponseListenerClazz;
    @NotNull
    private final Method queryProductDetailsAsyncMethod;
    @NotNull
    private final Method queryProductDetailsParamsBuilderBuildMethod;
    @NotNull
    private final Class queryProductDetailsParamsBuilderClazz;
    @NotNull
    private final Method queryProductDetailsParamsBuilderSetProductListMethod;
    @NotNull
    private final Class queryProductDetailsParamsClazz;
    @NotNull
    private final Method queryProductDetailsParamsNewBuilderMethod;
    @NotNull
    private final Method queryProductDetailsParamsProductBuilderBuildMethod;
    @NotNull
    private final Class queryProductDetailsParamsProductBuilderClazz;
    @NotNull
    private final Method queryProductDetailsParamsProductBuilderSetProductIdMethod;
    @NotNull
    private final Method queryProductDetailsParamsProductBuilderSetProductTypeMethod;
    @NotNull
    private final Class queryProductDetailsParamsProductClazz;
    @NotNull
    private final Method queryProductDetailsParamsProductNewBuilderMethod;
    @NotNull
    private final Method queryPurchaseHistoryAsyncMethod;
    @NotNull
    private final Method queryPurchaseHistoryParamsBuilderBuildMethod;
    @NotNull
    private final Class queryPurchaseHistoryParamsBuilderClazz;
    @NotNull
    private final Method queryPurchaseHistoryParamsBuilderSetProductTypeMethod;
    @NotNull
    private final Class queryPurchaseHistoryParamsClazz;
    @NotNull
    private final Method queryPurchaseHistoryParamsNewBuilderMethod;
    @NotNull
    private final Method queryPurchasesAsyncMethod;
    @NotNull
    private final Method queryPurchasesParamsBuilderBuildMethod;
    @NotNull
    private final Class queryPurchasesParamsBuilderClazz;
    @NotNull
    private final Method queryPurchasesParamsBuilderSetProductTypeMethod;
    @NotNull
    private final Class queryPurchasesParamsClazz;
    @NotNull
    private final Method queryPurchasesParamsNewBuilderMethod;
    @NotNull
    private static final Map subsPurchaseDetailsMap;

    static {
        InAppPurchaseBillingClientWrapperV5V7.Companion = new Companion(null);
        InAppPurchaseBillingClientWrapperV5V7.TAG = InAppPurchaseBillingClientWrapperV5V7.class.getCanonicalName();
        InAppPurchaseBillingClientWrapperV5V7.isServiceConnected = new AtomicBoolean(false);
        InAppPurchaseBillingClientWrapperV5V7.iapPurchaseDetailsMap = new ConcurrentHashMap();
        InAppPurchaseBillingClientWrapperV5V7.subsPurchaseDetailsMap = new ConcurrentHashMap();
        InAppPurchaseBillingClientWrapperV5V7.productDetailsMap = new ConcurrentHashMap();
    }

    private InAppPurchaseBillingClientWrapperV5V7(Object object0, Class class0, Class class1, Class class2, Class class3, Class class4, Class class5, Class class6, Class class7, Class class8, Class class9, Class class10, Class class11, Class class12, Class class13, Class class14, Class class15, Class class16, Method method0, Method method1, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20) {
        this.billingClient = object0;
        this.billingClientClazz = class0;
        this.purchaseClazz = class1;
        this.productDetailsClazz = class2;
        this.purchaseHistoryRecordClazz = class3;
        this.queryProductDetailsParamsProductClazz = class4;
        this.billingResultClazz = class5;
        this.queryProductDetailsParamsClazz = class6;
        this.queryPurchaseHistoryParamsClazz = class7;
        this.queryPurchasesParamsClazz = class8;
        this.queryProductDetailsParamsBuilderClazz = class9;
        this.queryPurchaseHistoryParamsBuilderClazz = class10;
        this.queryPurchasesParamsBuilderClazz = class11;
        this.queryProductDetailsParamsProductBuilderClazz = class12;
        this.billingClientStateListenerClazz = class13;
        this.productDetailsResponseListenerClazz = class14;
        this.purchasesResponseListenerClazz = class15;
        this.purchaseHistoryResponseListenerClazz = class16;
        this.queryPurchasesAsyncMethod = method0;
        this.queryPurchasesParamsNewBuilderMethod = method1;
        this.queryPurchasesParamsBuilderBuildMethod = method2;
        this.queryPurchasesParamsBuilderSetProductTypeMethod = method3;
        this.purchaseGetOriginalJsonMethod = method4;
        this.queryPurchaseHistoryAsyncMethod = method5;
        this.queryPurchaseHistoryParamsNewBuilderMethod = method6;
        this.queryPurchaseHistoryParamsBuilderBuildMethod = method7;
        this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod = method8;
        this.purchaseHistoryRecordGetOriginalJsonMethod = method9;
        this.queryProductDetailsAsyncMethod = method10;
        this.queryProductDetailsParamsNewBuilderMethod = method11;
        this.queryProductDetailsParamsBuilderBuildMethod = method12;
        this.queryProductDetailsParamsBuilderSetProductListMethod = method13;
        this.queryProductDetailsParamsProductNewBuilderMethod = method14;
        this.queryProductDetailsParamsProductBuilderBuildMethod = method15;
        this.queryProductDetailsParamsProductBuilderSetProductIdMethod = method16;
        this.queryProductDetailsParamsProductBuilderSetProductTypeMethod = method17;
        this.productDetailsToStringMethod = method18;
        this.billingClientStartConnectionMethod = method19;
        this.billingResultGetResponseCodeMethod = method20;
    }

    public InAppPurchaseBillingClientWrapperV5V7(Object object0, Class class0, Class class1, Class class2, Class class3, Class class4, Class class5, Class class6, Class class7, Class class8, Class class9, Class class10, Class class11, Class class12, Class class13, Class class14, Class class15, Class class16, Method method0, Method method1, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20, DefaultConstructorMarker defaultConstructorMarker0) {
        this(object0, class0, class1, class2, class3, class4, class5, class6, class7, class8, class9, class10, class11, class12, class13, class14, class15, class16, method0, method1, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20);
    }

    // 去混淆评级： 低(20)
    public static final Map access$getIapPurchaseDetailsMap$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class) ? null : InAppPurchaseBillingClientWrapperV5V7.iapPurchaseDetailsMap;
    }

    // 去混淆评级： 低(20)
    public static final InAppPurchaseBillingClientWrapperV5V7 access$getInstance$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class) ? null : InAppPurchaseBillingClientWrapperV5V7.instance;
    }

    // 去混淆评级： 低(20)
    public static final Map access$getProductDetailsMap$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class) ? null : InAppPurchaseBillingClientWrapperV5V7.productDetailsMap;
    }

    // 去混淆评级： 低(20)
    public static final Map access$getSubsPurchaseDetailsMap$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class) ? null : InAppPurchaseBillingClientWrapperV5V7.subsPurchaseDetailsMap;
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class) ? null : InAppPurchaseBillingClientWrapperV5V7.TAG;
    }

    // 去混淆评级： 低(20)
    public static final AtomicBoolean access$isServiceConnected$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class) ? null : InAppPurchaseBillingClientWrapperV5V7.isServiceConnected;
    }

    public static final void access$onBillingServiceDisconnected(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, Object[] arr_object, Object[] arr_object1) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V70.onBillingServiceDisconnected(arr_object, arr_object1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$onBillingSetupFinished(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, Object[] arr_object, Object[] arr_object1) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V70.onBillingSetupFinished(arr_object, arr_object1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$onProductDetailsResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, Object[] arr_object, Object[] arr_object1) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V70.onProductDetailsResponse(arr_object, arr_object1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$onPurchaseHistoryResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, Object[] arr_object, Object[] arr_object1) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V70.onPurchaseHistoryResponse(arr_object, arr_object1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$onQueryPurchasesResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, Object[] arr_object, Object[] arr_object1) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V70.onQueryPurchasesResponse(arr_object, arr_object1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$setInstance$cp(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70) {
        if(CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        InAppPurchaseBillingClientWrapperV5V7.instance = inAppPurchaseBillingClientWrapperV5V70;
    }

    private final void executeServiceRequest(Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if(InAppPurchaseBillingClientWrapperV5V7.isServiceConnected.get()) {
                runnable0.run();
                return;
            }
            this.startConnection(runnable0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    // 去混淆评级： 低(20)
    @Override  // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    @NotNull
    public Object getBillingClient() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.billingClient;
    }

    @Nullable
    public static final InAppPurchaseBillingClientWrapperV5V7 getOrCreateInstance(@NotNull Context context0) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        __monitor_enter(class0);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(class0);
            FIN.finallyCodeEnd$NT(v);
            return null;
        }
        try {
            InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70 = InAppPurchaseBillingClientWrapperV5V7.Companion.getOrCreateInstance(context0);
            FIN.finallyExec$NT(v);
            return inAppPurchaseBillingClientWrapperV5V70;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, InAppPurchaseBillingClientWrapperV5V7.class);
            FIN.finallyExec$NT(v);
            return null;
        }
    }

    @Nullable
    public final String getOriginalJson(@NotNull String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        else {
            try {
                q.g(s, "productDetailsString");
                l l0 = n.a(new n("jsonString=\'(.*?)\'"), s);
                return l0 == null ? null : ((String)p.n0(1, l0.a()));
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final Object getQueryProductDetailsParams(IAPProductType inAppPurchaseUtils$IAPProductType0, List list0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if(list0.isEmpty()) {
                return null;
            }
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                Object object1 = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductClazz, this.queryProductDetailsParamsProductNewBuilderMethod, null, new Object[0]);
                Object object2 = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductIdMethod, object1, new Object[]{((String)object0)});
                Object object3 = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductTypeMethod, object2, new Object[]{inAppPurchaseUtils$IAPProductType0.getType()});
                Object object4 = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderBuildMethod, object3, new Object[0]);
                if(object4 != null) {
                    arrayList0.add(object4);
                }
            }
            Object object5 = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsClazz, this.queryProductDetailsParamsNewBuilderMethod, null, new Object[0]);
            Object object6 = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderSetProductListMethod, object5, new Object[]{arrayList0});
            return InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderBuildMethod, object6, new Object[0]);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final Object getQueryPurchaseHistoryParams(IAPProductType inAppPurchaseUtils$IAPProductType0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object object0 = InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsClazz, this.queryPurchaseHistoryParamsNewBuilderMethod, null, new Object[0]);
            Object object1 = InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod, object0, new Object[]{inAppPurchaseUtils$IAPProductType0.getType()});
            return InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderBuildMethod, object1, new Object[0]);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final Object getQueryPurchasesParams(IAPProductType inAppPurchaseUtils$IAPProductType0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object object0 = InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsClazz, this.queryPurchasesParamsNewBuilderMethod, null, new Object[0]);
            if(object0 == null) {
                return null;
            }
            Object object1 = InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsBuilderClazz, this.queryPurchasesParamsBuilderSetProductTypeMethod, object0, new Object[]{inAppPurchaseUtils$IAPProductType0.getType()});
            return InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsBuilderClazz, this.queryPurchasesParamsBuilderBuildMethod, object1, new Object[0]);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final void onBillingServiceDisconnected(Object[] arr_object, Object[] arr_object1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseBillingClientWrapperV5V7.isServiceConnected.set(false);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void onBillingSetupFinished(Object[] arr_object, Object[] arr_object1) {
        if(CrashShieldHandler.isObjectCrashing(this) || arr_object1 == null) {
            return;
        }
        else {
            try {
                if(arr_object1.length != 0 && q.b(InAppPurchaseUtils.invokeMethod(this.billingResultClazz, this.billingResultGetResponseCodeMethod, arr_object1[0], new Object[0]), 0)) {
                    InAppPurchaseBillingClientWrapperV5V7.isServiceConnected.set(true);
                    if(arr_object != null && arr_object.length != 0) {
                        Object object0 = arr_object[0];
                        if(object0 instanceof Runnable && ((Runnable)object0) != null) {
                            ((Runnable)object0).run();
                            return;
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void onProductDetailsResponse(Object[] arr_object, Object[] arr_object1) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object object0 = arr_object == null ? null : je.n.n0(0, arr_object);
                Object object1 = arr_object1 == null ? null : je.n.n0(1, arr_object1);
                if(object1 != null && object1 instanceof List) {
                    for(Object object2: ((List)object1)) {
                        try {
                            Object object3 = InAppPurchaseUtils.invokeMethod(this.productDetailsClazz, this.productDetailsToStringMethod, object2, new Object[0]);
                            String s = object3 instanceof String ? ((String)object3) : null;
                            if(s == null) {
                                continue;
                            }
                            String s1 = this.getOriginalJson(s);
                            if(s1 == null) {
                                continue;
                            }
                            JSONObject jSONObject0 = new JSONObject(s1);
                            if(!jSONObject0.has("productId")) {
                                continue;
                            }
                            String s2 = jSONObject0.getString("productId");
                            q.f(s2, "productId");
                            InAppPurchaseBillingClientWrapperV5V7.productDetailsMap.put(s2, jSONObject0);
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                    if(object0 != null && object0 instanceof Runnable) {
                        ((Runnable)object0).run();
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void onPurchaseHistoryResponse(Object[] arr_object, Object[] arr_object1) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object object0 = arr_object == null ? null : je.n.n0(0, arr_object);
                if(object0 != null && object0 instanceof IAPProductType) {
                    Object object1 = je.n.n0(1, arr_object);
                    if(object1 instanceof Runnable) {
                        Object object2 = arr_object1 == null ? null : je.n.n0(1, arr_object1);
                        if(object2 != null && object2 instanceof List) {
                            ArrayList arrayList0 = new ArrayList();
                            Iterator iterator0 = ((List)object2).iterator();
                            while(true) {
                                if(!iterator0.hasNext()) {
                                    if(!arrayList0.isEmpty()) {
                                        this.queryProductDetailsAsync(((IAPProductType)object0), arrayList0, ((Runnable)object1));
                                        return;
                                    }
                                    ((Runnable)object1).run();
                                    return;
                                }
                                Object object3 = iterator0.next();
                                try {
                                    Object object4 = InAppPurchaseUtils.invokeMethod(this.purchaseHistoryRecordClazz, this.purchaseHistoryRecordGetOriginalJsonMethod, object3, new Object[0]);
                                    String s = object4 instanceof String ? ((String)object4) : null;
                                    if(s == null) {
                                        continue;
                                    }
                                    JSONObject jSONObject0 = new JSONObject(s);
                                    if(!jSONObject0.has("productId")) {
                                        continue;
                                    }
                                    String s1 = jSONObject0.getString("productId");
                                    if(!InAppPurchaseBillingClientWrapperV5V7.productDetailsMap.containsKey(s1)) {
                                        q.f(s1, "productId");
                                        arrayList0.add(s1);
                                    }
                                    if(object0 == IAPProductType.INAPP) {
                                        q.f(s1, "productId");
                                        InAppPurchaseBillingClientWrapperV5V7.iapPurchaseDetailsMap.put(s1, jSONObject0);
                                        continue;
                                    }
                                    q.f(s1, "productId");
                                    InAppPurchaseBillingClientWrapperV5V7.subsPurchaseDetailsMap.put(s1, jSONObject0);
                                }
                                catch(Exception unused_ex) {
                                }
                            }
                            goto label_33;
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        label_33:
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void onQueryPurchasesResponse(Object[] arr_object, Object[] arr_object1) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object object0 = arr_object == null ? null : je.n.n0(0, arr_object);
                if(object0 != null && object0 instanceof IAPProductType) {
                    Object object1 = je.n.n0(1, arr_object);
                    if(object1 instanceof Runnable) {
                        Object object2 = arr_object1 == null ? null : je.n.n0(1, arr_object1);
                        if(object2 != null && object2 instanceof List) {
                            ArrayList arrayList0 = new ArrayList();
                            for(Object object3: ((List)object2)) {
                                Object object4 = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.purchaseGetOriginalJsonMethod, object3, new Object[0]);
                                String s = object4 instanceof String ? ((String)object4) : null;
                                if(s != null) {
                                    JSONObject jSONObject0 = new JSONObject(s);
                                    if(jSONObject0.has("productId")) {
                                        String s1 = jSONObject0.getString("productId");
                                        if(!InAppPurchaseBillingClientWrapperV5V7.productDetailsMap.containsKey(s1)) {
                                            q.f(s1, "productId");
                                            arrayList0.add(s1);
                                        }
                                        if(object0 == IAPProductType.INAPP) {
                                            q.f(s1, "productId");
                                            InAppPurchaseBillingClientWrapperV5V7.iapPurchaseDetailsMap.put(s1, jSONObject0);
                                        }
                                        else {
                                            q.f(s1, "productId");
                                            InAppPurchaseBillingClientWrapperV5V7.subsPurchaseDetailsMap.put(s1, jSONObject0);
                                        }
                                    }
                                }
                            }
                            if(!arrayList0.isEmpty()) {
                                this.queryProductDetailsAsync(((IAPProductType)object0), arrayList0, ((Runnable)object1));
                                return;
                            }
                            ((Runnable)object1).run();
                            return;
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void queryProductDetailsAsync(IAPProductType inAppPurchaseUtils$IAPProductType0, List list0, Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.executeServiceRequest(new a(this, runnable0, inAppPurchaseUtils$IAPProductType0, list0, 18));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void queryProductDetailsAsync$lambda$2(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, Runnable runnable0, IAPProductType inAppPurchaseUtils$IAPProductType0, List list0) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(inAppPurchaseBillingClientWrapperV5V70, "this$0");
                q.g(runnable0, "$completionHandler");
                q.g(inAppPurchaseUtils$IAPProductType0, "$productType");
                q.g(list0, "$productIds");
                ListenerWrapper inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0 = new ListenerWrapper(inAppPurchaseBillingClientWrapperV5V70, new Object[]{runnable0});
                Object object0 = Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV5V70.productDetailsResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV5V70.productDetailsResponseListenerClazz}, inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0);
                Object object1 = inAppPurchaseBillingClientWrapperV5V70.getQueryProductDetailsParams(inAppPurchaseUtils$IAPProductType0, list0);
                if(object1 != null) {
                    Object object2 = inAppPurchaseBillingClientWrapperV5V70.getBillingClient();
                    InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV5V70.billingClientClazz, inAppPurchaseBillingClientWrapperV5V70.queryProductDetailsAsyncMethod, object2, new Object[]{object1, object0});
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @Override  // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchaseHistory(@NotNull IAPProductType inAppPurchaseUtils$IAPProductType0, @NotNull Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(inAppPurchaseUtils$IAPProductType0, "productType");
            q.g(runnable0, "completionHandler");
            this.executeServiceRequest(new c(this, inAppPurchaseUtils$IAPProductType0, runnable0, 1));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void queryPurchaseHistory$lambda$1(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, IAPProductType inAppPurchaseUtils$IAPProductType0, Runnable runnable0) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(inAppPurchaseBillingClientWrapperV5V70, "this$0");
            q.g(inAppPurchaseUtils$IAPProductType0, "$productType");
            q.g(runnable0, "$completionHandler");
            ListenerWrapper inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0 = new ListenerWrapper(inAppPurchaseBillingClientWrapperV5V70, new Object[]{inAppPurchaseUtils$IAPProductType0, runnable0});
            Object object0 = Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV5V70.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV5V70.purchaseHistoryResponseListenerClazz}, inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0);
            Object object1 = inAppPurchaseBillingClientWrapperV5V70.getBillingClient();
            Object[] arr_object = {inAppPurchaseBillingClientWrapperV5V70.getQueryPurchaseHistoryParams(inAppPurchaseUtils$IAPProductType0), object0};
            InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV5V70.billingClientClazz, inAppPurchaseBillingClientWrapperV5V70.queryPurchaseHistoryAsyncMethod, object1, arr_object);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @Override  // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchases(@NotNull IAPProductType inAppPurchaseUtils$IAPProductType0, @NotNull Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(inAppPurchaseUtils$IAPProductType0, "productType");
            q.g(runnable0, "completionHandler");
            this.executeServiceRequest(new c(this, inAppPurchaseUtils$IAPProductType0, runnable0, 0));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void queryPurchases$lambda$0(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, IAPProductType inAppPurchaseUtils$IAPProductType0, Runnable runnable0) {
        Class class0 = InAppPurchaseBillingClientWrapperV5V7.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(inAppPurchaseBillingClientWrapperV5V70, "this$0");
            q.g(inAppPurchaseUtils$IAPProductType0, "$productType");
            q.g(runnable0, "$completionHandler");
            ListenerWrapper inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0 = new ListenerWrapper(inAppPurchaseBillingClientWrapperV5V70, new Object[]{inAppPurchaseUtils$IAPProductType0, runnable0});
            Object object0 = Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV5V70.purchasesResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV5V70.purchasesResponseListenerClazz}, inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0);
            Object object1 = inAppPurchaseBillingClientWrapperV5V70.getBillingClient();
            Object[] arr_object = {inAppPurchaseBillingClientWrapperV5V70.getQueryPurchasesParams(inAppPurchaseUtils$IAPProductType0), object0};
            InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV5V70.billingClientClazz, inAppPurchaseBillingClientWrapperV5V70.queryPurchasesAsyncMethod, object1, arr_object);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void startConnection(Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ListenerWrapper inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0 = new ListenerWrapper(this, new Object[]{runnable0});
            Object object0 = Proxy.newProxyInstance(this.billingClientStateListenerClazz.getClassLoader(), new Class[]{this.billingClientStateListenerClazz}, inAppPurchaseBillingClientWrapperV5V7$ListenerWrapper0);
            Object object1 = this.getBillingClient();
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.billingClientStartConnectionMethod, object1, new Object[]{object0});
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }
}

