package co.ab180.airbridge.internal.u.c;

import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/internal/u/c/m;", "Lco/ab180/airbridge/internal/u/c/e;", "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "", "a", "(Lcom/google/firebase/messaging/RemoteMessage;)Z", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class m implements e {
    @Override  // co.ab180.airbridge.internal.u.c.e
    public boolean a(@NotNull RemoteMessage remoteMessage0) {
        return remoteMessage0.getData().containsKey("airbridge-uninstall-tracking");
    }
}

