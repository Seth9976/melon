package androidx.privacysandbox.ads.adservices.measurement;

import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import n4.b;
import org.jetbrains.annotations.NotNull;
import u4.c;

@SuppressLint({"NewApi", "ClassVerificationFailure"})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManagerApi33Ext5Impl;", "Lu4/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MeasurementManagerApi33Ext5Impl extends c {
    public MeasurementManagerApi33Ext5Impl(@NotNull Context context0) {
        q.g(context0, "context");
        Object object0 = context0.getSystemService(b.D());
        q.f(object0, "context.getSystemService…ementManager::class.java)");
        super(((MeasurementManager)object0));
    }
}

