package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000B\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\t\u0010\nR\u001C\u0010\u000E\u001A\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000F¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore;", "", "<init>", "()V", "Lcom/facebook/appevents/PersistedEvents;", "readAndClearStore", "()Lcom/facebook/appevents/PersistedEvents;", "eventsToPersist", "Lie/H;", "saveEventsToDisk$facebook_core_release", "(Lcom/facebook/appevents/PersistedEvents;)V", "saveEventsToDisk", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "PERSISTED_EVENTS_FILENAME", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventDiskStore {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class MovedClassObjectInputStream extends ObjectInputStream {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream$Companion;", "", "()V", "ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME", "", "APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        @NotNull
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        @NotNull
        public static final Companion Companion;

        static {
            MovedClassObjectInputStream.Companion = new Companion(null);
        }

        public MovedClassObjectInputStream(@Nullable InputStream inputStream0) {
            super(inputStream0);
        }

        @Override
        @NotNull
        public ObjectStreamClass readClassDescriptor() {
            ObjectStreamClass objectStreamClass0 = super.readClassDescriptor();
            if(q.b(objectStreamClass0.getName(), "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                objectStreamClass0 = ObjectStreamClass.lookup(SerializationProxyV1.class);
            }
            else if(q.b(objectStreamClass0.getName(), "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2")) {
                objectStreamClass0 = ObjectStreamClass.lookup(SerializationProxyV2.class);
            }
            q.f(objectStreamClass0, "resultClassDescriptor");
            return objectStreamClass0;
        }
    }

    @NotNull
    public static final AppEventDiskStore INSTANCE = null;
    @NotNull
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG;

    static {
        AppEventDiskStore.INSTANCE = new AppEventDiskStore();
        AppEventDiskStore.TAG = "com.facebook.appevents.AppEventDiskStore";
    }

    @NotNull
    public static final PersistedEvents readAndClearStore() {
        PersistedEvents persistedEvents1;
        Throwable throwable1;
        MovedClassObjectInputStream appEventDiskStore$MovedClassObjectInputStream0;
        synchronized(AppEventDiskStore.class) {
            Context context0 = FacebookSdk.getApplicationContext();
            PersistedEvents persistedEvents0 = null;
            try {
                FileInputStream fileInputStream0 = context0.openFileInput("AppEventsLogger.persistedevents");
                q.f(fileInputStream0, "context.openFileInput(PERSISTED_EVENTS_FILENAME)");
                appEventDiskStore$MovedClassObjectInputStream0 = null;
                appEventDiskStore$MovedClassObjectInputStream0 = new MovedClassObjectInputStream(new BufferedInputStream(fileInputStream0));
            }
            catch(FileNotFoundException unused_ex) {
                appEventDiskStore$MovedClassObjectInputStream0 = null;
                Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream0);
                goto label_27;
            }
            catch(Exception exception0) {
                appEventDiskStore$MovedClassObjectInputStream0 = null;
                goto label_25;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                goto label_33;
            }
            try {
                Object object0 = appEventDiskStore$MovedClassObjectInputStream0.readObject();
                q.e(object0, "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents");
                persistedEvents1 = (PersistedEvents)object0;
                goto label_40;
            }
            catch(FileNotFoundException unused_ex) {
                Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream0);
                goto label_27;
            }
            catch(Exception exception0) {
                try {
                label_25:
                    Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception while reading events: ", exception0);
                }
                catch(Throwable throwable1) {
                    goto label_33;
                }
                Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream0);
                try {
                label_27:
                    context0.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                }
                catch(Exception exception1) {
                    Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception when removing events file: ", exception1);
                }
                goto label_46;
            }
            catch(Throwable throwable1) {
            }
        label_33:
            Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream0);
            try {
                context0.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            }
            catch(Exception exception2) {
                Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception when removing events file: ", exception2);
            }
            throw throwable1;
        label_40:
            Utility.closeQuietly(appEventDiskStore$MovedClassObjectInputStream0);
            try {
                context0.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            }
            catch(Exception exception3) {
                Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception when removing events file: ", exception3);
            }
            persistedEvents0 = persistedEvents1;
        label_46:
            if(persistedEvents0 == null) {
                persistedEvents0 = new PersistedEvents();
            }
            return persistedEvents0;
        }
    }

    public static final void saveEventsToDisk$facebook_core_release(@Nullable PersistedEvents persistedEvents0) {
        Context context0 = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream0 = null;
        try {
            objectOutputStream0 = new ObjectOutputStream(new BufferedOutputStream(context0.openFileOutput("AppEventsLogger.persistedevents", 0)));
            objectOutputStream0.writeObject(persistedEvents0);
        }
        catch(Throwable throwable0) {
            Log.w("com.facebook.appevents.AppEventDiskStore", "Got unexpected exception while persisting events: ", throwable0);
            try {
                context0.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            }
            catch(Exception unused_ex) {
            }
        }
        finally {
            Utility.closeQuietly(objectOutputStream0);
        }
    }
}

