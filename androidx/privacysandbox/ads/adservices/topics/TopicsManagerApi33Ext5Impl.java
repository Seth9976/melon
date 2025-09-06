package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.TopicsManager;
import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import v4.f;

@SuppressLint({"NewApi", "ClassVerificationFailure"})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/TopicsManagerApi33Ext5Impl;", "Lv4/f;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TopicsManagerApi33Ext5Impl extends f {
    public TopicsManagerApi33Ext5Impl(@NotNull Context context0) {
        q.g(context0, "context");
        Object object0 = context0.getSystemService(TopicsManager.class);
        q.f(object0, "context.getSystemService…opicsManager::class.java)");
        super(((TopicsManager)object0));
    }

    @Override  // v4.f
    public final GetTopicsRequest a() {
        q.g(null, "request");
        throw null;
    }
}

