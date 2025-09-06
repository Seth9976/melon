package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0010\u000B\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\t\u001A\u0004\u0018\u00010\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0004@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0006R\"\u0010\u000B\u001A\u0004\u0018\u00010\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0004@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u0006R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\u000F@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers;", "", "()V", "androidAdvertiserId", "", "getAndroidAdvertiserId", "()Ljava/lang/String;", "androidAdvertiserIdValue", "<set-?>", "androidInstallerPackage", "getAndroidInstallerPackage", "attributionId", "getAttributionId", "fetchTime", "", "", "isTrackingLimited", "()Z", "Companion", "GoogleAdInfo", "GoogleAdServiceConnection", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AttributionIdentifiers {
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0011H\u0002J\u0010\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001A\u00020\u0017H\u0007J\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0010\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\u0010\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0016\u001A\u00020\u0017H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000E\u001A\n \u000F*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0000@\u0000X\u0081\u000E¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002¨\u0006\u001F"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$Companion;", "", "()V", "ANDROID_ID_COLUMN_NAME", "", "ATTRIBUTION_ID_COLUMN_NAME", "ATTRIBUTION_ID_CONTENT_PROVIDER", "getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations", "ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI", "CONNECTION_RESULT_SUCCESS", "", "IDENTIFIER_REFRESH_INTERVAL_MILLIS", "", "LIMIT_TRACKING_COLUMN_NAME", "TAG", "kotlin.jvm.PlatformType", "cachedIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "getCachedIdentifiers$facebook_core_release$annotations", "cacheAndReturnIdentifiers", "identifiers", "getAndroidId", "context", "Landroid/content/Context;", "getAndroidIdViaReflection", "getAndroidIdViaService", "getAttributionIdentifiers", "getInstallerPackageName", "isGooglePlayServicesAvailable", "", "isTrackingLimited", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers0) {
            attributionIdentifiers0.fetchTime = System.currentTimeMillis();
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers0;
            return attributionIdentifiers0;
        }

        public static void getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations() {
        }

        private final AttributionIdentifiers getAndroidId(Context context0) {
            AttributionIdentifiers attributionIdentifiers0 = this.getAndroidIdViaReflection(context0);
            if(attributionIdentifiers0 == null) {
                AttributionIdentifiers attributionIdentifiers1 = this.getAndroidIdViaService(context0);
                return attributionIdentifiers1 == null ? new AttributionIdentifiers() : attributionIdentifiers1;
            }
            return attributionIdentifiers0;
        }

        private final AttributionIdentifiers getAndroidIdViaReflection(Context context0) {
            try {
                if(!this.isGooglePlayServicesAvailable(context0)) {
                    return null;
                }
                Method method0 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class});
                if(method0 == null) {
                    return null;
                }
                Object object0 = Utility.invokeMethodQuietly(null, method0, new Object[]{context0});
                if(object0 == null) {
                    return null;
                }
                boolean z = false;
                Method method1 = Utility.getMethodQuietly(object0.getClass(), "getId", new Class[0]);
                Method method2 = Utility.getMethodQuietly(object0.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                if(method1 != null && method2 != null) {
                    AttributionIdentifiers attributionIdentifiers0 = new AttributionIdentifiers();
                    attributionIdentifiers0.androidAdvertiserIdValue = (String)Utility.invokeMethodQuietly(object0, method1, new Object[0]);
                    Boolean boolean0 = (Boolean)Utility.invokeMethodQuietly(object0, method2, new Object[0]);
                    if(boolean0 != null) {
                        z = boolean0.booleanValue();
                    }
                    attributionIdentifiers0.isTrackingLimited = z;
                    return attributionIdentifiers0;
                }
                return null;
            }
            catch(Exception exception0) {
            }
            Utility.logd("android_id", exception0);
            return null;
        }

        private final AttributionIdentifiers getAndroidIdViaService(Context context0) {
            AttributionIdentifiers attributionIdentifiers0;
            if(this.isGooglePlayServicesAvailable(context0)) {
                GoogleAdServiceConnection attributionIdentifiers$GoogleAdServiceConnection0 = new GoogleAdServiceConnection();
                Intent intent0 = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent0.setPackage("com.google.android.gms");
                try {
                    if(context0.bindService(intent0, attributionIdentifiers$GoogleAdServiceConnection0, 1)) {
                        goto label_5;
                    }
                }
                catch(SecurityException unused_ex) {
                }
                return null;
                try {
                label_5:
                    GoogleAdInfo attributionIdentifiers$GoogleAdInfo0 = new GoogleAdInfo(attributionIdentifiers$GoogleAdServiceConnection0.getBinder());
                    attributionIdentifiers0 = new AttributionIdentifiers();
                    attributionIdentifiers0.androidAdvertiserIdValue = attributionIdentifiers$GoogleAdInfo0.getAdvertiserId();
                    attributionIdentifiers0.isTrackingLimited = attributionIdentifiers$GoogleAdInfo0.isTrackingLimited();
                    return attributionIdentifiers0;
                }
                catch(Exception exception0) {
                    Utility.logd("android_id", exception0);
                    return null;
                }
                finally {
                    context0.unbindService(attributionIdentifiers$GoogleAdServiceConnection0);
                }
            }
            return null;
        }

        @Nullable
        public final AttributionIdentifiers getAttributionIdentifiers(@NotNull Context context0) {
            Throwable throwable1;
            Exception exception2;
            Cursor cursor2;
            AttributionIdentifiers attributionIdentifiers2;
            Cursor cursor1;
            Uri uri0;
            q.g(context0, "context");
            AttributionIdentifiers attributionIdentifiers0 = this.getAndroidId(context0);
            Cursor cursor0 = null;
            try {
                if(q.b(Looper.myLooper(), Looper.getMainLooper())) {
                    throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
                }
                AttributionIdentifiers attributionIdentifiers1 = AttributionIdentifiers.cachedIdentifiers;
                if(attributionIdentifiers1 != null && System.currentTimeMillis() - attributionIdentifiers1.fetchTime < 3600000L) {
                    return attributionIdentifiers1;
                }
                ProviderInfo providerInfo0 = context0.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
                ProviderInfo providerInfo1 = context0.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0);
                if(providerInfo0 == null) {
                label_16:
                    if(providerInfo1 == null) {
                        uri0 = null;
                    }
                    else {
                        String s1 = providerInfo1.packageName;
                        q.f(s1, "wakizashiProviderInfo.packageName");
                        uri0 = FacebookSignatureValidator.validateSignature(context0, s1) ? Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider") : null;
                    }
                }
                else {
                    String s = providerInfo0.packageName;
                    q.f(s, "contentProviderInfo.packageName");
                    if(FacebookSignatureValidator.validateSignature(context0, s)) {
                        uri0 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                        goto label_25;
                    }
                    goto label_16;
                }
            label_25:
                String s2 = this.getInstallerPackageName(context0);
                if(s2 != null) {
                    attributionIdentifiers0.androidInstallerPackage = s2;
                }
                if(uri0 == null) {
                    return this.cacheAndReturnIdentifiers(attributionIdentifiers0);
                }
                cursor1 = context0.getContentResolver().query(uri0, new String[]{"aid", "androidid", "limit_tracking"}, null, null, null);
                if(cursor1 != null) {
                    goto label_32;
                }
                attributionIdentifiers2 = this.cacheAndReturnIdentifiers(attributionIdentifiers0);
                goto label_69;
            }
            catch(Exception exception0) {
                goto label_55;
            }
            catch(Throwable throwable0) {
                goto label_53;
            }
            try {
            label_32:
                if(cursor1.moveToFirst()) {
                    int v = cursor1.getColumnIndex("aid");
                    int v1 = cursor1.getColumnIndex("androidid");
                    int v2 = cursor1.getColumnIndex("limit_tracking");
                    attributionIdentifiers0.attributionId = cursor1.getString(v);
                    if(v1 > 0 && v2 > 0 && attributionIdentifiers0.getAndroidAdvertiserId() == null) {
                        attributionIdentifiers0.androidAdvertiserIdValue = cursor1.getString(v1);
                        attributionIdentifiers0.isTrackingLimited = Boolean.parseBoolean(cursor1.getString(v2));
                    }
                    goto label_40;
                }
                attributionIdentifiers2 = this.cacheAndReturnIdentifiers(attributionIdentifiers0);
                goto label_69;
            }
            catch(Exception exception1) {
                goto label_45;
            }
            catch(Throwable throwable0) {
                goto label_49;
            }
        label_40:
            cursor1.close();
            return this.cacheAndReturnIdentifiers(attributionIdentifiers0);
            try {
                attributionIdentifiers2 = this.cacheAndReturnIdentifiers(attributionIdentifiers0);
                goto label_69;
            }
            catch(Exception exception1) {
            label_45:
                cursor2 = cursor1;
                exception2 = exception1;
            }
            catch(Throwable throwable0) {
            label_49:
                cursor0 = cursor1;
                try {
                    while(true) {
                        throwable1 = throwable0;
                        goto label_66;
                    label_53:
                    }
                label_55:
                    exception2 = exception0;
                    cursor2 = null;
                }
                catch(Exception exception0) {
                    goto label_55;
                }
                catch(Throwable throwable0) {
                    goto label_53;
                }
            }
            try {
                Utility.logd(AttributionIdentifiers.TAG, "Caught unexpected exception in getAttributionId(): " + exception2);
            }
            catch(Throwable throwable2) {
                throwable1 = throwable2;
                cursor0 = cursor2;
                goto label_66;
            }
            if(cursor2 != null) {
                cursor2.close();
            }
            return null;
        label_66:
            if(cursor0 != null) {
                cursor0.close();
            }
            throw throwable1;
        label_69:
            if(cursor1 != null) {
                cursor1.close();
            }
            return attributionIdentifiers2;
        }

        public static void getCachedIdentifiers$facebook_core_release$annotations() {
        }

        private final String getInstallerPackageName(Context context0) {
            PackageManager packageManager0 = context0.getPackageManager();
            return packageManager0 == null ? null : packageManager0.getInstallerPackageName("com.iloen.melon");
        }

        private final boolean isGooglePlayServicesAvailable(Context context0) {
            Method method0 = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class});
            if(method0 == null) {
                return false;
            }
            Object object0 = Utility.invokeMethodQuietly(null, method0, new Object[]{context0});
            return object0 instanceof Integer && q.b(object0, 0);
        }

        public final boolean isTrackingLimited(@NotNull Context context0) {
            q.g(context0, "context");
            AttributionIdentifiers attributionIdentifiers0 = this.getAttributionIdentifiers(context0);
            return attributionIdentifiers0 != null && attributionIdentifiers0.isTrackingLimited();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001A\u00020\u0003H\u0016R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\t\u0010\u000B¨\u0006\u000E"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdInfo;", "Landroid/os/IInterface;", "binder", "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "advertiserId", "", "getAdvertiserId", "()Ljava/lang/String;", "isTrackingLimited", "", "()Z", "asBinder", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class GoogleAdInfo implements IInterface {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdInfo$Companion;", "", "()V", "FIRST_TRANSACTION_CODE", "", "SECOND_TRANSACTION_CODE", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.internal.AttributionIdentifiers.GoogleAdInfo.Companion {
            private com.facebook.internal.AttributionIdentifiers.GoogleAdInfo.Companion() {
            }

            public com.facebook.internal.AttributionIdentifiers.GoogleAdInfo.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final com.facebook.internal.AttributionIdentifiers.GoogleAdInfo.Companion Companion = null;
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        @NotNull
        private final IBinder binder;

        static {
            GoogleAdInfo.Companion = new com.facebook.internal.AttributionIdentifiers.GoogleAdInfo.Companion(null);
        }

        public GoogleAdInfo(@NotNull IBinder iBinder0) {
            q.g(iBinder0, "binder");
            super();
            this.binder = iBinder0;
        }

        @Override  // android.os.IInterface
        @NotNull
        public IBinder asBinder() {
            return this.binder;
        }

        @Nullable
        public final String getAdvertiserId() {
            Parcel parcel0 = Parcel.obtain();
            q.f(parcel0, "obtain()");
            Parcel parcel1 = Parcel.obtain();
            q.f(parcel1, "obtain()");
            try {
                parcel0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, parcel0, parcel1, 0);
                parcel1.readException();
                return parcel1.readString();
            }
            finally {
                parcel1.recycle();
                parcel0.recycle();
            }
        }

        public final boolean isTrackingLimited() {
            Parcel parcel0 = Parcel.obtain();
            q.f(parcel0, "obtain()");
            Parcel parcel1 = Parcel.obtain();
            q.f(parcel1, "obtain()");
            try {
                parcel0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                parcel0.writeInt(1);
                this.binder.transact(2, parcel0, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) {
                    z = false;
                }
                return z;
            }
            finally {
                parcel1.recycle();
                parcel0.recycle();
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000B\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001A\u00020\u00068F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdServiceConnection;", "Landroid/content/ServiceConnection;", "<init>", "()V", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "Lie/H;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "consumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/BlockingQueue;", "queue", "Ljava/util/concurrent/BlockingQueue;", "getBinder", "()Landroid/os/IBinder;", "binder", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class GoogleAdServiceConnection implements ServiceConnection {
        @NotNull
        private final AtomicBoolean consumed;
        @NotNull
        private final BlockingQueue queue;

        public GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        @NotNull
        public final IBinder getBinder() {
            if(this.consumed.compareAndSet(true, true)) {
                throw new IllegalStateException("Binder already consumed");
            }
            Object object0 = this.queue.take();
            q.f(object0, "queue.take()");
            return (IBinder)object0;
        }

        @Override  // android.content.ServiceConnection
        public void onServiceConnected(@Nullable ComponentName componentName0, @Nullable IBinder iBinder0) {
            if(iBinder0 != null) {
                try {
                    this.queue.put(iBinder0);
                }
                catch(InterruptedException unused_ex) {
                }
            }
        }

        @Override  // android.content.ServiceConnection
        public void onServiceDisconnected(@Nullable ComponentName componentName0) {
        }
    }

    @NotNull
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    @NotNull
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    @NotNull
    public static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    @NotNull
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
    @NotNull
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG;
    @Nullable
    private String androidAdvertiserIdValue;
    @Nullable
    private String androidInstallerPackage;
    @Nullable
    private String attributionId;
    @Nullable
    public static AttributionIdentifiers cachedIdentifiers;
    private long fetchTime;
    private boolean isTrackingLimited;

    static {
        AttributionIdentifiers.Companion = new Companion(null);
        AttributionIdentifiers.TAG = AttributionIdentifiers.class.getCanonicalName();
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final String getAndroidAdvertiserId() {
        return !FacebookSdk.isInitialized() || !FacebookSdk.getAdvertiserIDCollectionEnabled() ? null : this.androidAdvertiserIdValue;
    }

    @Nullable
    public final String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    @Nullable
    public final String getAttributionId() {
        return this.attributionId;
    }

    @Nullable
    public static final AttributionIdentifiers getAttributionIdentifiers(@NotNull Context context0) {
        return AttributionIdentifiers.Companion.getAttributionIdentifiers(context0);
    }

    public static final boolean isTrackingLimited(@NotNull Context context0) {
        return AttributionIdentifiers.Companion.isTrackingLimited(context0);
    }

    public final boolean isTrackingLimited() {
        return this.isTrackingLimited;
    }
}

