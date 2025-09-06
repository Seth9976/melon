package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;

public abstract class DownloadService extends Service {
    static final class DownloadManagerHelper implements Listener {
        private final Context context;
        private final DownloadManager downloadManager;
        private DownloadService downloadService;
        private final boolean foregroundAllowed;
        private final Scheduler scheduler;
        private final Class serviceClass;

        private DownloadManagerHelper(Context context0, DownloadManager downloadManager0, boolean z, Scheduler scheduler0, Class class0) {
            this.context = context0;
            this.downloadManager = downloadManager0;
            this.foregroundAllowed = z;
            this.scheduler = scheduler0;
            this.serviceClass = class0;
            downloadManager0.addListener(this);
            this.updateScheduler();
        }

        public DownloadManagerHelper(Context context0, DownloadManager downloadManager0, boolean z, Scheduler scheduler0, Class class0, com.google.android.exoplayer2.offline.DownloadService.1 downloadService$10) {
            this(context0, downloadManager0, z, scheduler0, class0);
        }

        public static DownloadManager access$100(DownloadManagerHelper downloadService$DownloadManagerHelper0) {
            return downloadService$DownloadManagerHelper0.downloadManager;
        }

        public void attachService(DownloadService downloadService0) {
            Assertions.checkState(this.downloadService == null);
            this.downloadService = downloadService0;
            if(this.downloadManager.isInitialized()) {
                new Handler().postAtFrontOfQueue(new e(0, this, downloadService0));
            }
        }

        public void detachService(DownloadService downloadService0) {
            Assertions.checkState(this.downloadService == downloadService0);
            this.downloadService = null;
            if(this.scheduler != null && !this.downloadManager.isWaitingForRequirements()) {
                this.scheduler.cancel();
            }
        }

        private void lambda$attachService$0(DownloadService downloadService0) {
            downloadService0.notifyDownloads(this.downloadManager.getCurrentDownloads());
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadManager$Listener
        public void onDownloadChanged(DownloadManager downloadManager0, Download download0) {
            DownloadService downloadService0 = this.downloadService;
            if(downloadService0 != null) {
                downloadService0.notifyDownloadChanged(download0);
            }
            if(this.serviceMayNeedRestart() && DownloadService.needsStartedService(download0.state)) {
                Log.w("DownloadService", "DownloadService wasn\'t running. Restarting.");
                this.restartService();
            }
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadManager$Listener
        public void onDownloadRemoved(DownloadManager downloadManager0, Download download0) {
            DownloadService downloadService0 = this.downloadService;
            if(downloadService0 != null) {
                downloadService0.notifyDownloadRemoved(download0);
            }
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadManager$Listener
        public final void onIdle(DownloadManager downloadManager0) {
            DownloadService downloadService0 = this.downloadService;
            if(downloadService0 != null) {
                downloadService0.stop();
            }
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadManager$Listener
        public void onInitialized(DownloadManager downloadManager0) {
            DownloadService downloadService0 = this.downloadService;
            if(downloadService0 != null) {
                downloadService0.notifyDownloads(downloadManager0.getCurrentDownloads());
            }
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadManager$Listener
        public void onWaitingForRequirementsChanged(DownloadManager downloadManager0, boolean z) {
            if(!z && !downloadManager0.getDownloadsPaused() && this.serviceMayNeedRestart()) {
                List list0 = downloadManager0.getCurrentDownloads();
                for(int v = 0; v < list0.size(); ++v) {
                    if(((Download)list0.get(v)).state == 0) {
                        this.restartService();
                        break;
                    }
                }
            }
            this.updateScheduler();
        }

        private void restartService() {
            if(this.foregroundAllowed) {
                Intent intent0 = DownloadService.getIntent(this.context, this.serviceClass, "com.google.android.exoplayer.downloadService.action.RESTART");
                Util.startForegroundService(this.context, intent0);
                return;
            }
            try {
                Intent intent1 = DownloadService.getIntent(this.context, this.serviceClass, "com.google.android.exoplayer.downloadService.action.INIT");
                this.context.startService(intent1);
            }
            catch(IllegalStateException unused_ex) {
                Log.w("DownloadService", "Failed to restart DownloadService (process is idle).");
            }
        }

        private boolean serviceMayNeedRestart() {
            return this.downloadService == null || this.downloadService.isStopped();
        }

        private void updateScheduler() {
            if(this.scheduler != null) {
                if(!this.downloadManager.isWaitingForRequirements()) {
                    this.scheduler.cancel();
                    return;
                }
                Requirements requirements0 = this.downloadManager.getRequirements();
                if(!this.scheduler.schedule(requirements0, "com.iloen.melon", "com.google.android.exoplayer.downloadService.action.RESTART")) {
                    Log.e("DownloadService", "Scheduling downloads failed.");
                }
            }
        }
    }

    final class ForegroundNotificationUpdater {
        private final Handler handler;
        private boolean notificationDisplayed;
        private final int notificationId;
        private boolean periodicUpdatesStarted;
        private final long updateInterval;

        public ForegroundNotificationUpdater(int v, long v1) {
            this.notificationId = v;
            this.updateInterval = v1;
            this.handler = new Handler(Looper.getMainLooper());
        }

        public static void a(ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater0) {
            downloadService$ForegroundNotificationUpdater0.update();
        }

        public void invalidate() {
            if(this.notificationDisplayed) {
                this.update();
            }
        }

        public void showNotificationIfNotAlready() {
            if(!this.notificationDisplayed) {
                this.update();
            }
        }

        public void startPeriodicUpdates() {
            this.periodicUpdatesStarted = true;
            this.update();
        }

        public void stopPeriodicUpdates() {
            this.periodicUpdatesStarted = false;
            this.handler.removeCallbacksAndMessages(null);
        }

        private void update() {
            List list0 = ((DownloadManager)Assertions.checkNotNull(DownloadService.this.downloadManager)).getCurrentDownloads();
            Notification notification0 = DownloadService.this.getForegroundNotification(list0);
            DownloadService.this.startForeground(this.notificationId, notification0);
            this.notificationDisplayed = true;
            if(this.periodicUpdatesStarted) {
                this.handler.removeCallbacksAndMessages(null);
                f f0 = new f(this, 0);
                this.handler.postDelayed(f0, this.updateInterval);
            }
        }
    }

    public static final String ACTION_ADD_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String ACTION_PAUSE_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String ACTION_REMOVE_ALL_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String ACTION_REMOVE_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    private static final String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    public static final String ACTION_RESUME_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String ACTION_SET_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String ACTION_SET_STOP_REASON = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000L;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_DOWNLOAD_REQUEST = "download_request";
    public static final String KEY_FOREGROUND = "foreground";
    public static final String KEY_REQUIREMENTS = "requirements";
    public static final String KEY_STOP_REASON = "stop_reason";
    private static final String TAG = "DownloadService";
    private final int channelDescriptionResourceId;
    private final String channelId;
    private final int channelNameResourceId;
    private DownloadManager downloadManager;
    private static final HashMap downloadManagerHelpers;
    private final ForegroundNotificationUpdater foregroundNotificationUpdater;
    private boolean isDestroyed;
    private boolean isStopped;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;

    static {
        DownloadService.downloadManagerHelpers = new HashMap();
    }

    public DownloadService(int v) {
        this(v, 1000L);
    }

    public DownloadService(int v, long v1) {
        this(v, v1, null, 0, 0);
    }

    @Deprecated
    public DownloadService(int v, long v1, String s, int v2) {
        this(v, v1, s, v2, 0);
    }

    public DownloadService(int v, long v1, String s, int v2, int v3) {
        if(v == 0) {
            this.foregroundNotificationUpdater = null;
            this.channelId = null;
            this.channelNameResourceId = 0;
            this.channelDescriptionResourceId = 0;
            return;
        }
        this.foregroundNotificationUpdater = new ForegroundNotificationUpdater(this, v, v1);
        this.channelId = s;
        this.channelNameResourceId = v2;
        this.channelDescriptionResourceId = v3;
    }

    public static Intent buildAddDownloadIntent(Context context0, Class class0, DownloadRequest downloadRequest0, int v, boolean z) {
        return DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD", z).putExtra("download_request", downloadRequest0).putExtra("stop_reason", v);
    }

    public static Intent buildAddDownloadIntent(Context context0, Class class0, DownloadRequest downloadRequest0, boolean z) {
        return DownloadService.buildAddDownloadIntent(context0, class0, downloadRequest0, 0, z);
    }

    public static Intent buildPauseDownloadsIntent(Context context0, Class class0, boolean z) {
        return DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS", z);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context0, Class class0, boolean z) {
        return DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS", z);
    }

    public static Intent buildRemoveDownloadIntent(Context context0, Class class0, String s, boolean z) {
        return DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD", z).putExtra("content_id", s);
    }

    public static Intent buildResumeDownloadsIntent(Context context0, Class class0, boolean z) {
        return DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS", z);
    }

    public static Intent buildSetRequirementsIntent(Context context0, Class class0, Requirements requirements0, boolean z) {
        return DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS", z).putExtra("requirements", requirements0);
    }

    public static Intent buildSetStopReasonIntent(Context context0, Class class0, String s, int v, boolean z) {
        return DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON", z).putExtra("content_id", s).putExtra("stop_reason", v);
    }

    public abstract DownloadManager getDownloadManager();

    public abstract Notification getForegroundNotification(List arg1);

    private static Intent getIntent(Context context0, Class class0, String s) {
        return new Intent(context0, class0).setAction(s);
    }

    private static Intent getIntent(Context context0, Class class0, String s, boolean z) {
        return DownloadService.getIntent(context0, class0, s).putExtra("foreground", z);
    }

    public abstract Scheduler getScheduler();

    public final void invalidateForegroundNotification() {
        ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater0 = this.foregroundNotificationUpdater;
        if(downloadService$ForegroundNotificationUpdater0 != null && !this.isDestroyed) {
            downloadService$ForegroundNotificationUpdater0.invalidate();
        }
    }

    private boolean isStopped() {
        return this.isStopped;
    }

    private static boolean needsStartedService(int v) {
        return v == 2 || v == 5 || v == 7;
    }

    private void notifyDownloadChanged(Download download0) {
        if(this.foregroundNotificationUpdater != null) {
            if(DownloadService.needsStartedService(download0.state)) {
                this.foregroundNotificationUpdater.startPeriodicUpdates();
                return;
            }
            this.foregroundNotificationUpdater.invalidate();
        }
    }

    private void notifyDownloadRemoved(Download download0) {
        ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater0 = this.foregroundNotificationUpdater;
        if(downloadService$ForegroundNotificationUpdater0 != null) {
            downloadService$ForegroundNotificationUpdater0.invalidate();
        }
    }

    private void notifyDownloads(List list0) {
        if(this.foregroundNotificationUpdater != null) {
            for(int v = 0; v < list0.size(); ++v) {
                if(DownloadService.needsStartedService(((Download)list0.get(v)).state)) {
                    this.foregroundNotificationUpdater.startPeriodicUpdates();
                    return;
                }
            }
        }
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        throw new UnsupportedOperationException();
    }

    @Override  // android.app.Service
    public void onCreate() {
        String s = this.channelId;
        if(s != null) {
            NotificationUtil.createNotificationChannel(this, s, this.channelNameResourceId, this.channelDescriptionResourceId, 2);
        }
        Class class0 = this.getClass();
        HashMap hashMap0 = DownloadService.downloadManagerHelpers;
        DownloadManagerHelper downloadService$DownloadManagerHelper0 = (DownloadManagerHelper)hashMap0.get(class0);
        if(downloadService$DownloadManagerHelper0 == null) {
            Scheduler scheduler0 = this.foregroundNotificationUpdater == null ? this.getScheduler() : null;
            DownloadManager downloadManager0 = this.getDownloadManager();
            this.downloadManager = downloadManager0;
            downloadManager0.resumeDownloads();
            DownloadManagerHelper downloadService$DownloadManagerHelper1 = new DownloadManagerHelper(this.getApplicationContext(), this.downloadManager, this.foregroundNotificationUpdater != null, scheduler0, class0, null);
            hashMap0.put(class0, downloadService$DownloadManagerHelper1);
            downloadService$DownloadManagerHelper0 = downloadService$DownloadManagerHelper1;
        }
        else {
            this.downloadManager = DownloadManagerHelper.access$100(downloadService$DownloadManagerHelper0);
        }
        downloadService$DownloadManagerHelper0.attachService(this);
    }

    @Override  // android.app.Service
    public void onDestroy() {
        this.isDestroyed = true;
        Class class0 = this.getClass();
        ((DownloadManagerHelper)Assertions.checkNotNull(((DownloadManagerHelper)DownloadService.downloadManagerHelpers.get(class0)))).detachService(this);
        ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater0 = this.foregroundNotificationUpdater;
        if(downloadService$ForegroundNotificationUpdater0 != null) {
            downloadService$ForegroundNotificationUpdater0.stopPeriodicUpdates();
        }
    }

    @Deprecated
    public void onDownloadChanged(Download download0) {
    }

    @Deprecated
    public void onDownloadRemoved(Download download0) {
    }

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        String s1;
        String s;
        this.lastStartId = v1;
        this.taskRemoved = false;
        if(intent0 == null) {
            s = null;
            s1 = null;
        }
        else {
            s = intent0.getAction();
            s1 = intent0.getStringExtra("content_id");
            this.startedInForeground |= intent0.getBooleanExtra("foreground", false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(s);
        }
        if(s == null) {
            s = "com.google.android.exoplayer.downloadService.action.INIT";
        }
        DownloadManager downloadManager0 = (DownloadManager)Assertions.checkNotNull(this.downloadManager);
        switch(s) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD": {
                DownloadRequest downloadRequest0 = (DownloadRequest)((Intent)Assertions.checkNotNull(intent0)).getParcelableExtra("download_request");
                if(downloadRequest0 == null) {
                    Log.e("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                }
                else {
                    downloadManager0.addDownload(downloadRequest0, intent0.getIntExtra("stop_reason", 0));
                }
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.INIT": {
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS": {
                downloadManager0.pauseDownloads();
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS": {
                downloadManager0.removeAllDownloads();
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD": {
                if(s1 == null) {
                    Log.e("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                }
                else {
                    downloadManager0.removeDownload(s1);
                }
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.RESTART": {
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS": {
                downloadManager0.resumeDownloads();
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS": {
                Requirements requirements0 = (Requirements)((Intent)Assertions.checkNotNull(intent0)).getParcelableExtra("requirements");
                if(requirements0 == null) {
                    Log.e("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                }
                else {
                    downloadManager0.setRequirements(requirements0);
                }
                break;
            }
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON": {
                if(((Intent)Assertions.checkNotNull(intent0)).hasExtra("stop_reason")) {
                    downloadManager0.setStopReason(s1, intent0.getIntExtra("stop_reason", 0));
                }
                else {
                    Log.e("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                }
                break;
            }
            default: {
                Log.e("DownloadService", (s.length() == 0 ? new String("Ignored unrecognized action: ") : "Ignored unrecognized action: " + s));
            }
        }
        if(Util.SDK_INT >= 26 && this.startedInForeground) {
            ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater0 = this.foregroundNotificationUpdater;
            if(downloadService$ForegroundNotificationUpdater0 != null) {
                downloadService$ForegroundNotificationUpdater0.showNotificationIfNotAlready();
            }
        }
        this.isStopped = false;
        if(downloadManager0.isIdle()) {
            this.stop();
        }
        return 1;
    }

    @Override  // android.app.Service
    public void onTaskRemoved(Intent intent0) {
        this.taskRemoved = true;
    }

    public static void sendAddDownload(Context context0, Class class0, DownloadRequest downloadRequest0, int v, boolean z) {
        DownloadService.startService(context0, DownloadService.buildAddDownloadIntent(context0, class0, downloadRequest0, v, z), z);
    }

    public static void sendAddDownload(Context context0, Class class0, DownloadRequest downloadRequest0, boolean z) {
        DownloadService.startService(context0, DownloadService.buildAddDownloadIntent(context0, class0, downloadRequest0, z), z);
    }

    public static void sendPauseDownloads(Context context0, Class class0, boolean z) {
        DownloadService.startService(context0, DownloadService.buildPauseDownloadsIntent(context0, class0, z), z);
    }

    public static void sendRemoveAllDownloads(Context context0, Class class0, boolean z) {
        DownloadService.startService(context0, DownloadService.buildRemoveAllDownloadsIntent(context0, class0, z), z);
    }

    public static void sendRemoveDownload(Context context0, Class class0, String s, boolean z) {
        DownloadService.startService(context0, DownloadService.buildRemoveDownloadIntent(context0, class0, s, z), z);
    }

    public static void sendResumeDownloads(Context context0, Class class0, boolean z) {
        DownloadService.startService(context0, DownloadService.buildResumeDownloadsIntent(context0, class0, z), z);
    }

    public static void sendSetRequirements(Context context0, Class class0, Requirements requirements0, boolean z) {
        DownloadService.startService(context0, DownloadService.buildSetRequirementsIntent(context0, class0, requirements0, z), z);
    }

    public static void sendSetStopReason(Context context0, Class class0, String s, int v, boolean z) {
        DownloadService.startService(context0, DownloadService.buildSetStopReasonIntent(context0, class0, s, v, z), z);
    }

    public static void start(Context context0, Class class0) {
        context0.startService(DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.INIT"));
    }

    public static void startForeground(Context context0, Class class0) {
        Util.startForegroundService(context0, DownloadService.getIntent(context0, class0, "com.google.android.exoplayer.downloadService.action.INIT", true));
    }

    private static void startService(Context context0, Intent intent0, boolean z) {
        if(z) {
            Util.startForegroundService(context0, intent0);
            return;
        }
        context0.startService(intent0);
    }

    private void stop() {
        ForegroundNotificationUpdater downloadService$ForegroundNotificationUpdater0 = this.foregroundNotificationUpdater;
        if(downloadService$ForegroundNotificationUpdater0 != null) {
            downloadService$ForegroundNotificationUpdater0.stopPeriodicUpdates();
        }
        if(Util.SDK_INT < 28 && this.taskRemoved) {
            this.stopSelf();
            this.isStopped = true;
            return;
        }
        this.isStopped |= this.stopSelfResult(this.lastStartId);
    }

    class com.google.android.exoplayer2.offline.DownloadService.1 {
    }

}

