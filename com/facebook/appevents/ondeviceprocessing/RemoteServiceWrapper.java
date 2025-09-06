package com.facebook.appevents.ondeviceprocessing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.ppml.receiver.IReceiverService.Stub;
import com.facebook.ppml.receiver.IReceiverService;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u001A\u001B\u001CB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0002J\b\u0010\t\u001A\u00020\nH\u0007J\u001E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007J&\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0012\u001A\u00020\u00042\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0004H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n \b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper;", "", "()V", "RECEIVER_SERVICE_ACTION", "", "RECEIVER_SERVICE_PACKAGE", "RECEIVER_SERVICE_PACKAGE_WAKIZASHI", "TAG", "kotlin.jvm.PlatformType", "isServiceAvailable", "", "Ljava/lang/Boolean;", "getVerifiedServiceIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "sendCustomEvents", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$ServiceResult;", "applicationId", "appEvents", "", "Lcom/facebook/appevents/AppEvent;", "sendEvents", "eventType", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "sendInstallEvent", "EventType", "RemoteServiceConnection", "ServiceResult", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RemoteServiceWrapper {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "", "eventType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "MOBILE_APP_INSTALL", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum EventType {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");

        @NotNull
        private final String eventType;

        private static final EventType[] $values() [...] // Inlined contents

        private EventType(String s1) {
            this.eventType = s1;
        }

        @Override
        @NotNull
        public String toString() {
            return this.eventType;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000F\u0010\u000E\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0011\u001A\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$RemoteServiceConnection;", "Landroid/content/ServiceConnection;", "<init>", "()V", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "serviceBinder", "Lie/H;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onNullBinding", "(Landroid/content/ComponentName;)V", "onServiceDisconnected", "getBinder", "()Landroid/os/IBinder;", "Ljava/util/concurrent/CountDownLatch;", "latch", "Ljava/util/concurrent/CountDownLatch;", "binder", "Landroid/os/IBinder;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class RemoteServiceConnection implements ServiceConnection {
        @Nullable
        private IBinder binder;
        @NotNull
        private final CountDownLatch latch;

        public RemoteServiceConnection() {
            this.latch = new CountDownLatch(1);
        }

        @Nullable
        public final IBinder getBinder() {
            this.latch.await(5L, TimeUnit.SECONDS);
            return this.binder;
        }

        @Override  // android.content.ServiceConnection
        public void onNullBinding(@NotNull ComponentName componentName0) {
            q.g(componentName0, "name");
            this.latch.countDown();
        }

        @Override  // android.content.ServiceConnection
        public void onServiceConnected(@NotNull ComponentName componentName0, @NotNull IBinder iBinder0) {
            q.g(componentName0, "name");
            q.g(iBinder0, "serviceBinder");
            this.binder = iBinder0;
            this.latch.countDown();
        }

        @Override  // android.content.ServiceConnection
        public void onServiceDisconnected(@NotNull ComponentName componentName0) {
            q.g(componentName0, "name");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$ServiceResult;", "", "(Ljava/lang/String;I)V", "OPERATION_SUCCESS", "SERVICE_NOT_AVAILABLE", "SERVICE_ERROR", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum ServiceResult {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR;

        private static final ServiceResult[] $values() [...] // Inlined contents
    }

    @NotNull
    public static final RemoteServiceWrapper INSTANCE = null;
    @NotNull
    public static final String RECEIVER_SERVICE_ACTION = "ReceiverService";
    @NotNull
    public static final String RECEIVER_SERVICE_PACKAGE = "com.facebook.katana";
    @NotNull
    public static final String RECEIVER_SERVICE_PACKAGE_WAKIZASHI = "com.facebook.wakizashi";
    private static final String TAG;
    @Nullable
    private static Boolean isServiceAvailable;

    static {
        RemoteServiceWrapper.INSTANCE = new RemoteServiceWrapper();
        RemoteServiceWrapper.TAG = "RemoteServiceWrapper";
    }

    private final Intent getVerifiedServiceIntent(Context context0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager0 = context0.getPackageManager();
            if(packageManager0 == null) {
                return null;
            }
            Intent intent0 = new Intent("ReceiverService");
            intent0.setPackage("com.facebook.katana");
            if(packageManager0.resolveService(intent0, 0) != null && FacebookSignatureValidator.validateSignature(context0, "com.facebook.katana")) {
                return intent0;
            }
            Intent intent1 = new Intent("ReceiverService");
            intent1.setPackage("com.facebook.wakizashi");
            return packageManager0.resolveService(intent1, 0) == null || !FacebookSignatureValidator.validateSignature(context0, "com.facebook.wakizashi") ? null : intent1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public static final boolean isServiceAvailable() {
        Class class0 = RemoteServiceWrapper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            if(RemoteServiceWrapper.isServiceAvailable == null) {
                Context context0 = FacebookSdk.getApplicationContext();
                RemoteServiceWrapper.isServiceAvailable = Boolean.valueOf(RemoteServiceWrapper.INSTANCE.getVerifiedServiceIntent(context0) != null);
            }
            return RemoteServiceWrapper.isServiceAvailable == null ? false : RemoteServiceWrapper.isServiceAvailable.booleanValue();
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return false;
    }

    @NotNull
    public static final ServiceResult sendCustomEvents(@NotNull String s, @NotNull List list0) {
        Class class0 = RemoteServiceWrapper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "applicationId");
            q.g(list0, "appEvents");
            return RemoteServiceWrapper.INSTANCE.sendEvents(EventType.CUSTOM_APP_EVENTS, s, list0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final ServiceResult sendEvents(EventType remoteServiceWrapper$EventType0, String s, List list0) {
        ServiceResult remoteServiceWrapper$ServiceResult1;
        RemoteServiceConnection remoteServiceWrapper$RemoteServiceConnection0;
        Context context0;
        ServiceResult remoteServiceWrapper$ServiceResult0;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            remoteServiceWrapper$ServiceResult0 = ServiceResult.SERVICE_NOT_AVAILABLE;
            context0 = FacebookSdk.getApplicationContext();
            Intent intent0 = this.getVerifiedServiceIntent(context0);
            if(intent0 == null) {
                return remoteServiceWrapper$ServiceResult0;
            }
            remoteServiceWrapper$RemoteServiceConnection0 = new RemoteServiceConnection();
            if(context0.bindService(intent0, remoteServiceWrapper$RemoteServiceConnection0, 1)) {
                goto label_9;
            }
            return ServiceResult.SERVICE_ERROR;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
        try {
            try {
            label_9:
                IBinder iBinder0 = remoteServiceWrapper$RemoteServiceConnection0.getBinder();
                if(iBinder0 != null) {
                    IReceiverService iReceiverService0 = Stub.asInterface(iBinder0);
                    Bundle bundle0 = RemoteServiceParametersHelper.buildEventsBundle(remoteServiceWrapper$EventType0, s, list0);
                    if(bundle0 != null) {
                        iReceiverService0.sendEvents(bundle0);
                        Utility.logd("RemoteServiceWrapper", "Successfully sent events to the remote service: " + bundle0);
                    }
                    remoteServiceWrapper$ServiceResult0 = ServiceResult.OPERATION_SUCCESS;
                }
                goto label_34;
            }
            catch(InterruptedException interruptedException0) {
            }
            catch(RemoteException remoteException0) {
                goto label_26;
            }
            remoteServiceWrapper$ServiceResult1 = ServiceResult.SERVICE_ERROR;
            Utility.logd("RemoteServiceWrapper", interruptedException0);
            goto label_28;
        label_26:
            remoteServiceWrapper$ServiceResult1 = ServiceResult.SERVICE_ERROR;
            Utility.logd("RemoteServiceWrapper", remoteException0);
        }
        catch(Throwable throwable1) {
            goto label_31;
        }
        try {
        label_28:
            context0.unbindService(remoteServiceWrapper$RemoteServiceConnection0);
            Utility.logd("RemoteServiceWrapper", "Unbound from the remote service");
            return remoteServiceWrapper$ServiceResult1;
        label_31:
            context0.unbindService(remoteServiceWrapper$RemoteServiceConnection0);
            Utility.logd("RemoteServiceWrapper", "Unbound from the remote service");
            throw throwable1;
        label_34:
            context0.unbindService(remoteServiceWrapper$RemoteServiceConnection0);
            Utility.logd("RemoteServiceWrapper", "Unbound from the remote service");
            return remoteServiceWrapper$ServiceResult0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @NotNull
    public static final ServiceResult sendInstallEvent(@NotNull String s) {
        Class class0 = RemoteServiceWrapper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "applicationId");
            return RemoteServiceWrapper.INSTANCE.sendEvents(EventType.MOBILE_APP_INSTALL, s, w.a);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }
}

