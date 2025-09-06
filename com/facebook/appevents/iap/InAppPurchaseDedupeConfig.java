package com.facebook.appevents.iap;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import e.k;
import ie.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00070\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000B\u001A\u001C\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\nJ\u0013\u0010\f\u001A\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000E\u0010\rJ\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001A\u0004\u0018\u00010\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001A\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001AJ;\u0010\u001F\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u001D0\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u000F2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000F2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D¢\u0006\u0004\b\u001F\u0010 R\u001A\u0010!\u001A\b\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001A\u0010#\u001A\b\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001A\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R,\u0010&\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\"¨\u0006\'"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseDedupeConfig;", "", "<init>", "()V", "", "dedupingWithImplicitlyLoggedHistory", "", "Lie/m;", "", "getDedupeParameters", "(Z)Ljava/util/List;", "getTestDedupeParameters", "getCurrencyParameterEquivalents", "()Ljava/util/List;", "getValueParameterEquivalents", "Landroid/os/Bundle;", "parameters", "Ljava/util/Currency;", "getCurrencyOfManualEvent", "(Landroid/os/Bundle;)Ljava/util/Currency;", "", "valueToSum", "getValueOfManualEvent", "(Ljava/lang/Double;Landroid/os/Bundle;)Ljava/lang/Double;", "", "getDedupeWindow", "()J", "dedupeParameters", "originalParameters", "Lcom/facebook/appevents/OperationalData;", "originalOperationalData", "addDedupeParameters", "(Landroid/os/Bundle;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)Lie/m;", "defaultCurrencyParameterEquivalents", "Ljava/util/List;", "defaultValueParameterEquivalents", "defaultDedupeWindow", "J", "defaultDedupeParameters", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseDedupeConfig {
    @NotNull
    public static final InAppPurchaseDedupeConfig INSTANCE;
    @NotNull
    private static final List defaultCurrencyParameterEquivalents;
    @NotNull
    private static final List defaultDedupeParameters;
    private static final long defaultDedupeWindow;
    @NotNull
    private static final List defaultValueParameterEquivalents;

    static {
        InAppPurchaseDedupeConfig.INSTANCE = new InAppPurchaseDedupeConfig();
        InAppPurchaseDedupeConfig.defaultCurrencyParameterEquivalents = k.z("fb_currency");
        InAppPurchaseDedupeConfig.defaultValueParameterEquivalents = k.z("_valueToSum");
        InAppPurchaseDedupeConfig.defaultDedupeWindow = TimeUnit.MINUTES.toMillis(1L);
        InAppPurchaseDedupeConfig.defaultDedupeParameters = k.A(new m[]{new m("fb_iap_product_id", k.z("fb_iap_product_id")), new m("fb_iap_product_description", k.z("fb_iap_product_description")), new m("fb_iap_product_title", k.z("fb_iap_product_title")), new m("fb_iap_purchase_token", k.z("fb_iap_purchase_token"))});
    }

    @NotNull
    public final m addDedupeParameters(@Nullable Bundle bundle0, @Nullable Bundle bundle1, @Nullable OperationalData operationalData0) {
        OperationalData operationalData1;
        Bundle bundle2;
        if(bundle0 == null) {
            return new m(bundle1, operationalData0);
        }
        try {
            bundle2 = bundle1;
            operationalData1 = operationalData0;
            Iterator iterator0 = bundle0.keySet().iterator();
            while(true) {
                try {
                label_5:
                    if(!iterator0.hasNext()) {
                        return new m(bundle2, operationalData1);
                    }
                    Object object0 = iterator0.next();
                    String s = (String)object0;
                    String s1 = bundle0.getString(s);
                    if(s1 == null) {
                        goto label_5;
                    }
                    q.f(s, "key");
                    m m0 = OperationalData.Companion.addParameterAndReturn(OperationalDataEnum.IAPParameters, s, s1, bundle2, operationalData1);
                    operationalData1 = (OperationalData)m0.b;
                    bundle2 = (Bundle)m0.a;
                }
                catch(Exception unused_ex) {
                    bundle1 = bundle2;
                    operationalData0 = operationalData1;
                    break;
                }
            }
        }
        catch(Exception unused_ex) {
        }
        bundle2 = bundle1;
        operationalData1 = operationalData0;
        return new m(bundle2, operationalData1);
    }

    @Nullable
    public final Currency getCurrencyOfManualEvent(@Nullable Bundle bundle0) {
        Iterator iterator0 = this.getCurrencyParameterEquivalents().iterator();
        while(true) {
            String s = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            String s1 = (String)object0;
            try {
                if(bundle0 != null) {
                    s = bundle0.getString(s1);
                }
                if(s != null && s.length() != 0) {
                    return Currency.getInstance(s);
                }
            }
            catch(Exception unused_ex) {
            }
        }
        return null;
    }

    @NotNull
    public final List getCurrencyParameterEquivalents() {
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return (fetchedAppSettings0 == null ? null : fetchedAppSettings0.getCurrencyDedupeParameters()) == null || fetchedAppSettings0.getCurrencyDedupeParameters().isEmpty() ? InAppPurchaseDedupeConfig.defaultCurrencyParameterEquivalents : fetchedAppSettings0.getCurrencyDedupeParameters();
    }

    @NotNull
    public final List getDedupeParameters(boolean z) {
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if((fetchedAppSettings0 == null ? null : fetchedAppSettings0.getProdDedupeParameters()) != null && !fetchedAppSettings0.getProdDedupeParameters().isEmpty()) {
            if(!z) {
                return fetchedAppSettings0.getProdDedupeParameters();
            }
            List list0 = new ArrayList();
            for(Object object0: fetchedAppSettings0.getProdDedupeParameters()) {
                m m0 = (m)object0;
                for(Object object1: ((List)m0.b)) {
                    ((ArrayList)list0).add(new m(((String)object1), k.z(m0.a)));
                }
            }
            return list0;
        }
        return InAppPurchaseDedupeConfig.defaultDedupeParameters;
    }

    public final long getDedupeWindow() {
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if((fetchedAppSettings0 == null ? null : fetchedAppSettings0.getDedupeWindow()) != null) {
            Long long0 = fetchedAppSettings0.getDedupeWindow();
            return long0 != null && ((long)long0) == 0L ? InAppPurchaseDedupeConfig.defaultDedupeWindow : ((long)fetchedAppSettings0.getDedupeWindow());
        }
        return InAppPurchaseDedupeConfig.defaultDedupeWindow;
    }

    @Nullable
    public final List getTestDedupeParameters(boolean z) {
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if(fetchedAppSettings0 == null) {
            return null;
        }
        Collection collection0 = fetchedAppSettings0.getTestDedupeParameters();
        if(collection0 != null && !collection0.isEmpty()) {
            if(!z) {
                return fetchedAppSettings0.getTestDedupeParameters();
            }
            List list0 = new ArrayList();
            for(Object object0: fetchedAppSettings0.getTestDedupeParameters()) {
                m m0 = (m)object0;
                for(Object object1: ((List)m0.b)) {
                    ((ArrayList)list0).add(new m(((String)object1), k.z(m0.a)));
                }
            }
            return list0;
        }
        return null;
    }

    @Nullable
    public final Double getValueOfManualEvent(@Nullable Double double0, @Nullable Bundle bundle0) {
        if(double0 != null) {
            return double0;
        }
        for(Object object0: this.getValueParameterEquivalents()) {
            String s = (String)object0;
            if(bundle0 != null) {
                try {
                    return bundle0.getDouble(s);
                }
                catch(Exception unused_ex) {
                    continue;
                }
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @NotNull
    public final List getValueParameterEquivalents() {
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return (fetchedAppSettings0 == null ? null : fetchedAppSettings0.getPurchaseValueDedupeParameters()) == null || fetchedAppSettings0.getPurchaseValueDedupeParameters().isEmpty() ? InAppPurchaseDedupeConfig.defaultValueParameterEquivalents : fetchedAppSettings0.getPurchaseValueDedupeParameters();
    }
}

