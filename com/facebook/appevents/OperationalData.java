package com.facebook.appevents;

import android.os.Bundle;
import ie.m;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.C;
import je.D;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u000E\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R,\u0010\u0014\u001A\u001A\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/OperationalData;", "", "<init>", "()V", "copy", "()Lcom/facebook/appevents/OperationalData;", "Lcom/facebook/appevents/OperationalDataEnum;", "type", "", "key", "value", "Lie/H;", "addParameter", "(Lcom/facebook/appevents/OperationalDataEnum;Ljava/lang/String;Ljava/lang/Object;)V", "getParameter", "(Lcom/facebook/appevents/OperationalDataEnum;Ljava/lang/String;)Ljava/lang/Object;", "Lorg/json/JSONObject;", "toJSON", "()Lorg/json/JSONObject;", "", "operationalData", "Ljava/util/Map;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class OperationalData {
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0012\u0010\u0013JI\u0010\u0015\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u00142\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0018\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u00062\b\u0010\u0017\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00060\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00060\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001CR8\u0010\u001F\u001A&\u0012\u0004\u0012\u00020\u0004\u0012\u001C\u0012\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001A0\u00140\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"Lcom/facebook/appevents/OperationalData$Companion;", "", "<init>", "()V", "Lcom/facebook/appevents/OperationalDataEnum;", "typeOfParameter", "", "parameter", "Lcom/facebook/appevents/ParameterClassification;", "getParameterClassification", "(Lcom/facebook/appevents/OperationalDataEnum;Ljava/lang/String;)Lcom/facebook/appevents/ParameterClassification;", "key", "value", "Landroid/os/Bundle;", "customEventsParams", "Lcom/facebook/appevents/OperationalData;", "operationalData", "Lie/H;", "addParameter", "(Lcom/facebook/appevents/OperationalDataEnum;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "Lie/m;", "addParameterAndReturn", "(Lcom/facebook/appevents/OperationalDataEnum;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)Lie/m;", "params", "getParameter", "(Lcom/facebook/appevents/OperationalDataEnum;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)Ljava/lang/Object;", "", "iapOperationalAndCustomParameters", "Ljava/util/Set;", "iapOperationalParameters", "", "parameterClassifications", "Ljava/util/Map;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
        public final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[ParameterClassification.values().length];
                try {
                    arr_v[ParameterClassification.CustomData.ordinal()] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[ParameterClassification.OperationalData.ordinal()] = 2;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                try {
                    arr_v[ParameterClassification.CustomAndOperationalData.ordinal()] = 3;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void addParameter(@NotNull OperationalDataEnum operationalDataEnum0, @NotNull String s, @NotNull String s1, @NotNull Bundle bundle0, @NotNull OperationalData operationalData0) {
            q.g(operationalDataEnum0, "typeOfParameter");
            q.g(s, "key");
            q.g(s1, "value");
            q.g(bundle0, "customEventsParams");
            q.g(operationalData0, "operationalData");
            switch(WhenMappings.$EnumSwitchMapping$0[this.getParameterClassification(operationalDataEnum0, s).ordinal()]) {
                case 1: {
                    bundle0.putCharSequence(s, s1);
                    return;
                }
                case 2: {
                    operationalData0.addParameter(operationalDataEnum0, s, s1);
                    return;
                }
                case 3: {
                    operationalData0.addParameter(operationalDataEnum0, s, s1);
                    bundle0.putCharSequence(s, s1);
                }
            }
        }

        @NotNull
        public final m addParameterAndReturn(@NotNull OperationalDataEnum operationalDataEnum0, @NotNull String s, @NotNull String s1, @Nullable Bundle bundle0, @Nullable OperationalData operationalData0) {
            q.g(operationalDataEnum0, "typeOfParameter");
            q.g(s, "key");
            q.g(s1, "value");
            switch(WhenMappings.$EnumSwitchMapping$0[this.getParameterClassification(operationalDataEnum0, s).ordinal()]) {
                case 1: {
                    if(bundle0 == null) {
                        bundle0 = new Bundle();
                    }
                    bundle0.putCharSequence(s, s1);
                    return new m(bundle0, operationalData0);
                }
                case 2: {
                    if(operationalData0 == null) {
                        operationalData0 = new OperationalData();
                    }
                    operationalData0.addParameter(operationalDataEnum0, s, s1);
                    return new m(bundle0, operationalData0);
                }
                case 3: {
                    if(operationalData0 == null) {
                        operationalData0 = new OperationalData();
                    }
                    if(bundle0 == null) {
                        bundle0 = new Bundle();
                    }
                    operationalData0.addParameter(operationalDataEnum0, s, s1);
                    bundle0.putCharSequence(s, s1);
                    return new m(bundle0, operationalData0);
                }
                default: {
                    return new m(bundle0, operationalData0);
                }
            }
        }

        @Nullable
        public final Object getParameter(@NotNull OperationalDataEnum operationalDataEnum0, @NotNull String s, @Nullable Bundle bundle0, @Nullable OperationalData operationalData0) {
            q.g(operationalDataEnum0, "typeOfParameter");
            q.g(s, "key");
            CharSequence charSequence0 = null;
            Object object0 = operationalData0 == null ? null : operationalData0.getParameter(operationalDataEnum0, s);
            if(bundle0 != null) {
                charSequence0 = bundle0.getCharSequence(s);
            }
            return object0 == null ? charSequence0 : object0;
        }

        @NotNull
        public final ParameterClassification getParameterClassification(@NotNull OperationalDataEnum operationalDataEnum0, @NotNull String s) {
            q.g(operationalDataEnum0, "typeOfParameter");
            q.g(s, "parameter");
            m m0 = (m)OperationalData.parameterClassifications.get(operationalDataEnum0);
            Set set0 = null;
            Set set1 = m0 == null ? null : ((Set)m0.a);
            m m1 = (m)OperationalData.parameterClassifications.get(operationalDataEnum0);
            if(m1 != null) {
                set0 = (Set)m1.b;
            }
            if(set1 != null && set1.contains(s)) {
                return ParameterClassification.OperationalData;
            }
            return set0 == null || !set0.contains(s) ? ParameterClassification.CustomData : ParameterClassification.CustomAndOperationalData;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Set iapOperationalAndCustomParameters;
    @NotNull
    private static final Set iapOperationalParameters;
    @NotNull
    private final Map operationalData;
    @NotNull
    private static final Map parameterClassifications;

    static {
        OperationalData.Companion = new Companion(null);
        Set set0 = n.A0(new String[]{"fb_iap_package_name", "fb_iap_subs_auto_renewing", "fb_free_trial_period", "fb_intro_price_amount_micros", "fb_intro_price_cycles", "fb_iap_base_plan", "is_implicit_purchase_logging_enabled", "fb_iap_sdk_supported_library_versions", "is_autolog_app_events_enabled", "fb_iap_client_library_version", "fb_iap_subs_period", "fb_iap_purchase_token", "fb_iap_non_deduped_event_time", "fb_iap_actual_dedup_result", "fb_iap_actual_dedup_key_used", "fb_iap_test_dedup_result", "fb_iap_test_dedup_key_used"});
        OperationalData.iapOperationalParameters = set0;
        Set set1 = n.A0(new String[]{"fb_iap_product_id", "fb_iap_product_type", "fb_iap_purchase_time"});
        OperationalData.iapOperationalAndCustomParameters = set1;
        m m0 = new m(set0, set1);
        OperationalData.parameterClassifications = D.O(new m(OperationalDataEnum.IAPParameters, m0));
    }

    public OperationalData() {
        this.operationalData = new LinkedHashMap();
    }

    public final void addParameter(@NotNull OperationalDataEnum operationalDataEnum0, @NotNull String s, @NotNull Object object0) {
        q.g(operationalDataEnum0, "type");
        q.g(s, "key");
        q.g(object0, "value");
        try {
            AppEvent.Companion.validateIdentifier(s);
            if(object0 instanceof String || object0 instanceof Number) {
                if(!this.operationalData.containsKey(operationalDataEnum0)) {
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    this.operationalData.put(operationalDataEnum0, linkedHashMap0);
                }
                Map map0 = (Map)this.operationalData.get(operationalDataEnum0);
                if(map0 != null) {
                    map0.put(s, object0);
                }
            }
        }
        catch(Exception unused_ex) {
        }
    }

    @NotNull
    public final OperationalData copy() {
        OperationalData operationalData0 = new OperationalData();
        for(Object object0: this.operationalData.keySet()) {
            OperationalDataEnum operationalDataEnum0 = (OperationalDataEnum)object0;
            Map map0 = (Map)this.operationalData.get(operationalDataEnum0);
            if(map0 != null) {
                for(Object object1: map0.keySet()) {
                    String s = (String)object1;
                    Object object2 = map0.get(s);
                    if(object2 != null) {
                        operationalData0.addParameter(operationalDataEnum0, s, object2);
                    }
                }
            }
        }
        return operationalData0;
    }

    @Nullable
    public final Object getParameter(@NotNull OperationalDataEnum operationalDataEnum0, @NotNull String s) {
        q.g(operationalDataEnum0, "type");
        q.g(s, "key");
        if(!this.operationalData.containsKey(operationalDataEnum0)) {
            return null;
        }
        Map map0 = (Map)this.operationalData.get(operationalDataEnum0);
        return map0 == null ? null : map0.get(s);
    }

    @NotNull
    public final JSONObject toJSON() {
        try {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(D.N(this.operationalData.size()));
            for(Object object0: this.operationalData.entrySet()) {
                linkedHashMap0.put(((OperationalDataEnum)((Map.Entry)object0).getKey()).getValue(), ((Map.Entry)object0).getValue());
            }
            JSONObject jSONObject0 = new JSONObject(C.Z(linkedHashMap0));
            return jSONObject0 == null ? new JSONObject() : jSONObject0;
        }
        catch(Exception unused_ex) {
            return new JSONObject();
        }
    }
}

