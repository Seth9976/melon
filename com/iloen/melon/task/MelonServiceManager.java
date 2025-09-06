package com.iloen.melon.task;

import H0.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.log.LogU;
import java.util.HashSet;
import java.util.Hashtable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000FJ\u001F\u0010\u0006\u001A\u00020\u00052\u0010\u0010\u0004\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\b2\u0010\u0010\u0004\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0010\u0010\u0004\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/task/MelonServiceManager;", "", "Ljava/lang/Class;", "Landroid/app/Service;", "cls", "", "register", "(Ljava/lang/Class;)Z", "Landroid/content/Context;", "context", "bind", "(Landroid/content/Context;Ljava/lang/Class;)Z", "Lie/H;", "unbind", "(Landroid/content/Context;Ljava/lang/Class;)V", "ServiceBindingInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonServiceManager {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0013\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000E\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/task/MelonServiceManager$ServiceBindingInfo;", "", "Ljava/lang/Class;", "serviceClass", "<init>", "(Ljava/lang/Class;)V", "", "toString", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Lie/H;", "bind", "(Landroid/content/Context;)V", "unbind", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ServiceBindingInfo {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/task/MelonServiceManager$ServiceBindingInfo$Companion;", "", "", "LOGTAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final Companion Companion;
        public final Class a;
        public final com.iloen.melon.task.MelonServiceManager.ServiceBindingInfo.1 b;
        public Context c;
        public final HashSet d;
        public boolean e;

        static {
            ServiceBindingInfo.Companion = new Companion(null);
        }

        public ServiceBindingInfo(@NotNull Class class0) {
            q.g(class0, "serviceClass");
            super();
            this.a = class0;
            this.d = new HashSet();
            this.b = new ServiceConnection() {
                public final ServiceBindingInfo a;

                {
                    this.a = melonServiceManager$ServiceBindingInfo0;
                }

                @Override  // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName0, IBinder iBinder0) {
                    q.g(componentName0, "name");
                    q.g(iBinder0, "service");
                    String s = componentName0.getShortClassName();
                    LogU.Companion.i("ServiceBindingInfo", "onServiceConnected: " + s + ", binder:" + iBinder0);
                }

                @Override  // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName0) {
                    q.g(componentName0, "name");
                    LogU.Companion.e("ServiceBindingInfo", "onServiceDisconnected: " + componentName0);
                    this.a.e = false;
                    this.a.c = null;
                }
            };
        }

        public final void bind(@NotNull Context context0) {
            q.g(context0, "context");
            this.d.add(context0);
            com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
            Class class0 = this.a;
            logU$Companion0.d("ServiceBindingInfo", "bind " + ClassUtils.shortName(class0) + ", from:" + context0 + ", to:" + context0 + ", refCtxCnt:" + this.d.size());
            if(!this.e) {
                Context context1 = context0.getApplicationContext();
                boolean z = context1.bindService(new Intent(context1, class0), this.b, 1);
                this.e = z;
                if(z) {
                    this.c = context1;
                    logU$Companion0.i("ServiceBindingInfo", "BIND REAL " + ClassUtils.shortName(class0) + " to ctx:" + this.c);
                    return;
                }
                b.w("BIND ERROR ", ClassUtils.shortName(class0), logU$Companion0, "ServiceBindingInfo");
            }
        }

        @Override
        @NotNull
        public String toString() {
            return "ServiceBindingInfo {cls:" + ClassUtils.shortName(this.a) + ", isBound:" + this.e + "}";
        }

        public final void unbind(@NotNull Context context0) {
            q.g(context0, "context");
            this.d.remove(context0);
            com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
            Class class0 = this.a;
            logU$Companion0.d("ServiceBindingInfo", "unbind " + ClassUtils.shortName(class0) + ", from:" + context0 + ", refCtxCnt:" + this.d.size());
            if(this.d.isEmpty() && this.e && this.c != null) {
                logU$Companion0.i("ServiceBindingInfo", "UNBIND REAL " + ClassUtils.shortName(class0) + ", conn:" + this.b);
                Context context1 = this.c;
                q.d(context1);
                context1.unbindService(this.b);
                this.e = false;
                this.c = null;
            }
        }
    }

    public static final int $stable;
    @NotNull
    public static final MelonServiceManager INSTANCE;
    public static final Hashtable a;

    static {
        MelonServiceManager.INSTANCE = new MelonServiceManager();  // 初始化器: Ljava/lang/Object;-><init>()V
        MelonServiceManager.a = new Hashtable();
        MelonServiceManager.$stable = 8;
    }

    public final boolean bind(@NotNull Context context0, @NotNull Class class0) {
        q.g(context0, "context");
        q.g(class0, "cls");
        synchronized(this) {
            com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.d("MelonServiceManager", "bindServiceImpl - cls:" + ClassUtils.shortName(class0) + ", to:" + context0);
            ServiceBindingInfo melonServiceManager$ServiceBindingInfo0 = (ServiceBindingInfo)MelonServiceManager.a.get(class0);
            if(melonServiceManager$ServiceBindingInfo0 != null) {
                melonServiceManager$ServiceBindingInfo0.bind(context0);
                return true;
            }
            logU$Companion0.e("MelonServiceManager", "bindService - not registered service: " + ClassUtils.shortName(class0));
            return false;
        }
    }

    public final boolean register(@NotNull Class class0) {
        q.g(class0, "cls");
        synchronized(this) {
            com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.d("MelonServiceManager", "registerService - cls:" + ClassUtils.shortName(class0));
            Hashtable hashtable0 = MelonServiceManager.a;
            if(((ServiceBindingInfo)hashtable0.get(class0)) == null) {
                hashtable0.put(class0, new ServiceBindingInfo(class0));
                return true;
            }
            logU$Companion0.w("MelonServiceManager", "registerServiceImpl - already registered: " + ClassUtils.shortName(class0));
            return false;
        }
    }

    public final void unbind(@NotNull Context context0, @NotNull Class class0) {
        q.g(context0, "context");
        q.g(class0, "cls");
        synchronized(this) {
            ServiceBindingInfo melonServiceManager$ServiceBindingInfo0 = (ServiceBindingInfo)MelonServiceManager.a.get(class0);
            if(melonServiceManager$ServiceBindingInfo0 == null) {
                LogU.Companion.e("MelonServiceManager", "unbindService - not registered service: " + ClassUtils.shortName(class0));
            }
            else {
                melonServiceManager$ServiceBindingInfo0.unbind(context0);
            }
        }
    }
}

