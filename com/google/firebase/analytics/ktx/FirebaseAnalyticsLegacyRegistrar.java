package com.google.firebase.analytics.ktx;

import com.google.firebase.components.ComponentRegistrar;
import e.k;
import java.util.List;
import kotlin.Metadata;
import x1.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/firebase/analytics/ktx/FirebaseAnalyticsLegacyRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "java.com.google.android.libraries.firebase.firebase_analytics_ktx_granule"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class FirebaseAnalyticsLegacyRegistrar implements ComponentRegistrar {
    @Override  // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        return k.z(a.q("fire-analytics-ktx", "22.5.0"));
    }
}

