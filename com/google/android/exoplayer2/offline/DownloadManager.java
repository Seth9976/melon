package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public final class DownloadManager {
    static final class DownloadUpdate {
        public final Download download;
        public final List downloads;
        public final boolean isRemove;

        public DownloadUpdate(Download download0, boolean z, List list0) {
            this.download = download0;
            this.isRemove = z;
            this.downloads = list0;
        }
    }

    static final class InternalHandler extends Handler {
        private static final int UPDATE_PROGRESS_INTERVAL_MS = 5000;
        private int activeDownloadTaskCount;
        private final HashMap activeTasks;
        private final WritableDownloadIndex downloadIndex;
        private final DownloaderFactory downloaderFactory;
        private final ArrayList downloads;
        private boolean downloadsPaused;
        private final Handler mainHandler;
        private int maxParallelDownloads;
        private int minRetryCount;
        private int notMetRequirements;
        public boolean released;
        private final HandlerThread thread;

        public InternalHandler(HandlerThread handlerThread0, WritableDownloadIndex writableDownloadIndex0, DownloaderFactory downloaderFactory0, Handler handler0, int v, int v1, boolean z) {
            super(handlerThread0.getLooper());
            this.thread = handlerThread0;
            this.downloadIndex = writableDownloadIndex0;
            this.downloaderFactory = downloaderFactory0;
            this.mainHandler = handler0;
            this.maxParallelDownloads = v;
            this.minRetryCount = v1;
            this.downloadsPaused = z;
            this.downloads = new ArrayList();
            this.activeTasks = new HashMap();
        }

        private void addDownload(DownloadRequest downloadRequest0, int v) {
            int v1 = 1;
            Download download0 = this.getDownload(downloadRequest0.id, true);
            long v2 = System.currentTimeMillis();
            if(download0 == null) {
                if(v == 0) {
                    v1 = 0;
                }
                this.putDownload(new Download(downloadRequest0, v1, v2, v2, -1L, v, 0));
            }
            else {
                this.putDownload(DownloadManager.mergeRequest(download0, downloadRequest0, v, v2));
            }
            this.syncTasks();
        }

        private boolean canDownloadsRun() {
            return !this.downloadsPaused && this.notMetRequirements == 0;
        }

        // 检测为 Lambda 实现
        private static int compareStartTimes(Download download0, Download download1) [...]

        private static Download copyDownloadWithState(Download download0, int v) {
            return new Download(download0.request, v, download0.startTimeMs, System.currentTimeMillis(), download0.contentLength, 0, 0, download0.progress);
        }

        private Download getDownload(String s, boolean z) {
            int v = this.getDownloadIndex(s);
            if(v != -1) {
                return (Download)this.downloads.get(v);
            }
            if(z) {
                try {
                    return this.downloadIndex.getDownload(s);
                }
                catch(IOException iOException0) {
                    String s1 = String.valueOf(s);
                    Log.e("DownloadManager", (s1.length() == 0 ? new String("Failed to load download: ") : "Failed to load download: " + s1), iOException0);
                }
            }
            return null;
        }

        private int getDownloadIndex(String s) {
            for(int v = 0; v < this.downloads.size(); ++v) {
                if(((Download)this.downloads.get(v)).request.id.equals(s)) {
                    return v;
                }
            }
            return -1;
        }

        @Override  // android.os.Handler
        public void handleMessage(Message message0) {
            boolean z = false;
            switch(message0.what) {
                case 0: {
                    this.initialize(message0.arg1);
                    z = true;
                    break;
                }
                case 1: {
                    if(message0.arg1 != 0) {
                        z = true;
                    }
                    this.setDownloadsPaused(z);
                    z = true;
                    break;
                }
                case 2: {
                    this.setNotMetRequirements(message0.arg1);
                    z = true;
                    break;
                }
                case 3: {
                    this.setStopReason(((String)message0.obj), message0.arg1);
                    z = true;
                    break;
                }
                case 4: {
                    this.setMaxParallelDownloads(message0.arg1);
                    z = true;
                    break;
                }
                case 5: {
                    this.setMinRetryCount(message0.arg1);
                    z = true;
                    break;
                }
                case 6: {
                    this.addDownload(((DownloadRequest)message0.obj), message0.arg1);
                    z = true;
                    break;
                }
                case 7: {
                    this.removeDownload(((String)message0.obj));
                    z = true;
                    break;
                }
                case 8: {
                    this.removeAllDownloads();
                    z = true;
                    break;
                }
                case 9: {
                    this.onTaskStopped(((Task)message0.obj));
                    break;
                }
                case 10: {
                    this.onContentLengthChanged(((Task)message0.obj));
                    return;
                }
                case 11: {
                    this.updateProgress();
                    return;
                }
                case 12: {
                    this.release();
                    return;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            this.mainHandler.obtainMessage(1, ((int)z), this.activeTasks.size()).sendToTarget();
        }

        private void initialize(int v) {
            DownloadCursor downloadCursor0;
            try {
                this.notMetRequirements = v;
                downloadCursor0 = null;
                this.downloadIndex.setDownloadingStatesToQueued();
                downloadCursor0 = this.downloadIndex.getDownloads(new int[]{0, 1, 2, 5, 7});
                while(downloadCursor0.moveToNext()) {
                    Download download0 = downloadCursor0.getDownload();
                    this.downloads.add(download0);
                }
            }
            catch(IOException iOException0) {
                Log.e("DownloadManager", "Failed to load index.", iOException0);
                this.downloads.clear();
            }
            finally {
                Util.closeQuietly(downloadCursor0);
            }
            ArrayList arrayList0 = new ArrayList(this.downloads);
            this.mainHandler.obtainMessage(0, arrayList0).sendToTarget();
            this.syncTasks();
        }

        private void onContentLengthChanged(Task downloadManager$Task0) {
            long v = Task.access$300(downloadManager$Task0);
            Download download0 = (Download)Assertions.checkNotNull(this.getDownload(Task.access$200(downloadManager$Task0).id, false));
            if(v != download0.contentLength && v != -1L) {
                this.putDownload(new Download(download0.request, download0.state, download0.startTimeMs, System.currentTimeMillis(), v, download0.stopReason, download0.failureReason, download0.progress));
            }
        }

        private void onDownloadTaskStopped(Download download0, Throwable throwable0) {
            Download download1 = new Download(download0.request, (throwable0 == null ? 3 : 4), download0.startTimeMs, System.currentTimeMillis(), download0.contentLength, download0.stopReason, (throwable0 == null ? 0 : 1), download0.progress);
            int v = this.getDownloadIndex(download1.request.id);
            this.downloads.remove(v);
            try {
                this.downloadIndex.putDownload(download1);
            }
            catch(IOException iOException0) {
                Log.e("DownloadManager", "Failed to update index.", iOException0);
            }
            DownloadUpdate downloadManager$DownloadUpdate0 = new DownloadUpdate(download1, false, new ArrayList(this.downloads));
            this.mainHandler.obtainMessage(2, downloadManager$DownloadUpdate0).sendToTarget();
        }

        private void onRemoveTaskStopped(Download download0) {
            int v = 1;
            if(download0.state == 7) {
                if(download0.stopReason == 0) {
                    v = 0;
                }
                this.putDownloadWithState(download0, v);
                this.syncTasks();
                return;
            }
            int v1 = this.getDownloadIndex(download0.request.id);
            this.downloads.remove(v1);
            try {
                this.downloadIndex.removeDownload(download0.request.id);
            }
            catch(IOException unused_ex) {
                Log.e("DownloadManager", "Failed to remove from database");
            }
            DownloadUpdate downloadManager$DownloadUpdate0 = new DownloadUpdate(download0, true, new ArrayList(this.downloads));
            this.mainHandler.obtainMessage(2, downloadManager$DownloadUpdate0).sendToTarget();
        }

        private void onTaskStopped(Task downloadManager$Task0) {
            String s = Task.access$200(downloadManager$Task0).id;
            this.activeTasks.remove(s);
            boolean z = Task.access$000(downloadManager$Task0);
            if(!z) {
                int v = this.activeDownloadTaskCount - 1;
                this.activeDownloadTaskCount = v;
                if(v == 0) {
                    this.removeMessages(11);
                }
            }
            if(Task.access$400(downloadManager$Task0)) {
                this.syncTasks();
                return;
            }
            Throwable throwable0 = Task.access$500(downloadManager$Task0);
            if(throwable0 != null) {
                Log.e("DownloadManager", "Task failed: " + Task.access$200(downloadManager$Task0) + ", " + z, throwable0);
            }
            Download download0 = (Download)Assertions.checkNotNull(this.getDownload(s, false));
            switch(download0.state) {
                case 2: {
                    Assertions.checkState(!z);
                    this.onDownloadTaskStopped(download0, throwable0);
                    break;
                }
                case 5: 
                case 7: {
                    Assertions.checkState(z);
                    this.onRemoveTaskStopped(download0);
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            this.syncTasks();
        }

        private Download putDownload(Download download0) {
            boolean z = true;
            Assertions.checkState(download0.state != 3 && download0.state != 4);
            int v = this.getDownloadIndex(download0.request.id);
            if(v == -1) {
                this.downloads.add(download0);
                d d0 = (Download download0, Download download1) -> Util.compareLong(download0.startTimeMs, download1.startTimeMs);
                Collections.sort(this.downloads, d0);
            }
            else {
                long v1 = ((Download)this.downloads.get(v)).startTimeMs;
                if(download0.startTimeMs == v1) {
                    z = false;
                }
                this.downloads.set(v, download0);
                if(z) {
                    d d1 = (Download download0, Download download1) -> Util.compareLong(download0.startTimeMs, download1.startTimeMs);
                    Collections.sort(this.downloads, d1);
                }
            }
            try {
                this.downloadIndex.putDownload(download0);
            }
            catch(IOException iOException0) {
                Log.e("DownloadManager", "Failed to update index.", iOException0);
            }
            DownloadUpdate downloadManager$DownloadUpdate0 = new DownloadUpdate(download0, false, new ArrayList(this.downloads));
            this.mainHandler.obtainMessage(2, downloadManager$DownloadUpdate0).sendToTarget();
            return download0;
        }

        private Download putDownloadWithState(Download download0, int v) {
            Assertions.checkState(v != 3 && (v != 1 && v != 4));
            return this.putDownload(InternalHandler.copyDownloadWithState(download0, v));
        }

        private void release() {
            for(Object object0: this.activeTasks.values()) {
                ((Task)object0).cancel(true);
            }
            try {
                this.downloadIndex.setDownloadingStatesToQueued();
            }
            catch(IOException iOException0) {
                Log.e("DownloadManager", "Failed to update index.", iOException0);
            }
            this.downloads.clear();
            this.thread.quit();
            synchronized(this) {
                this.released = true;
                this.notifyAll();
            }
        }

        private void removeAllDownloads() {
            ArrayList arrayList0 = new ArrayList();
            try(DownloadCursor downloadCursor0 = this.downloadIndex.getDownloads(new int[]{3, 4})) {
                while(true) {
                    if(!downloadCursor0.moveToNext()) {
                        break;
                    }
                    arrayList0.add(downloadCursor0.getDownload());
                }
            }
            catch(IOException unused_ex) {
                Log.e("DownloadManager", "Failed to load downloads.");
            }
            for(int v = 0; v < this.downloads.size(); ++v) {
                Download download0 = InternalHandler.copyDownloadWithState(((Download)this.downloads.get(v)), 5);
                this.downloads.set(v, download0);
            }
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                Download download1 = InternalHandler.copyDownloadWithState(((Download)arrayList0.get(v1)), 5);
                this.downloads.add(download1);
            }
            d d0 = (Download download0, Download download1) -> Util.compareLong(download0.startTimeMs, download1.startTimeMs);
            Collections.sort(this.downloads, d0);
            try {
                this.downloadIndex.setStatesToRemoving();
            }
            catch(IOException iOException0) {
                Log.e("DownloadManager", "Failed to update index.", iOException0);
            }
            ArrayList arrayList1 = new ArrayList(this.downloads);
            for(int v2 = 0; v2 < this.downloads.size(); ++v2) {
                DownloadUpdate downloadManager$DownloadUpdate0 = new DownloadUpdate(((Download)this.downloads.get(v2)), false, arrayList1);
                this.mainHandler.obtainMessage(2, downloadManager$DownloadUpdate0).sendToTarget();
            }
            this.syncTasks();
        }

        private void removeDownload(String s) {
            Download download0 = this.getDownload(s, true);
            if(download0 == null) {
                String s1 = String.valueOf(s);
                Log.e("DownloadManager", (s1.length() == 0 ? new String("Failed to remove nonexistent download: ") : "Failed to remove nonexistent download: " + s1));
                return;
            }
            this.putDownloadWithState(download0, 5);
            this.syncTasks();
        }

        private void setDownloadsPaused(boolean z) {
            this.downloadsPaused = z;
            this.syncTasks();
        }

        private void setMaxParallelDownloads(int v) {
            this.maxParallelDownloads = v;
            this.syncTasks();
        }

        private void setMinRetryCount(int v) {
            this.minRetryCount = v;
        }

        private void setNotMetRequirements(int v) {
            this.notMetRequirements = v;
            this.syncTasks();
        }

        private void setStopReason(Download download0, int v) {
            if(v == 0) {
                if(download0.state == 1) {
                    this.putDownloadWithState(download0, 0);
                }
            }
            else if(v != download0.stopReason) {
                this.putDownload(new Download(download0.request, (download0.state != 0 && download0.state != 2 ? download0.state : 1), download0.startTimeMs, System.currentTimeMillis(), download0.contentLength, v, 0, download0.progress));
            }
        }

        private void setStopReason(String s, int v) {
            if(s == null) {
                for(int v1 = 0; v1 < this.downloads.size(); ++v1) {
                    this.setStopReason(((Download)this.downloads.get(v1)), v);
                }
                try {
                    this.downloadIndex.setStopReason(v);
                }
                catch(IOException iOException0) {
                    Log.e("DownloadManager", "Failed to set manual stop reason", iOException0);
                }
            }
            else {
                Download download0 = this.getDownload(s, false);
                if(download0 == null) {
                    try {
                        this.downloadIndex.setStopReason(s, v);
                    }
                    catch(IOException iOException1) {
                        Log.e("DownloadManager", (s.length() == 0 ? new String("Failed to set manual stop reason: ") : "Failed to set manual stop reason: " + s), iOException1);
                    }
                }
                else {
                    this.setStopReason(download0, v);
                }
            }
            this.syncTasks();
        }

        private void syncDownloadingDownload(Task downloadManager$Task0, Download download0, int v) {
            Assertions.checkState(!Task.access$000(downloadManager$Task0));
            if(this.canDownloadsRun() && v < this.maxParallelDownloads) {
                return;
            }
            this.putDownloadWithState(download0, 0);
            downloadManager$Task0.cancel(false);
        }

        private Task syncQueuedDownload(Task downloadManager$Task0, Download download0) {
            if(downloadManager$Task0 != null) {
                Assertions.checkState(!Task.access$000(downloadManager$Task0));
                downloadManager$Task0.cancel(false);
                return downloadManager$Task0;
            }
            if(!this.canDownloadsRun() || this.activeDownloadTaskCount >= this.maxParallelDownloads) {
                return null;
            }
            Download download1 = this.putDownloadWithState(download0, 2);
            Downloader downloader0 = this.downloaderFactory.createDownloader(download1.request);
            Task downloadManager$Task1 = new Task(download1.request, downloader0, download1.progress, false, this.minRetryCount, this, null);
            this.activeTasks.put(download1.request.id, downloadManager$Task1);
            int v = this.activeDownloadTaskCount;
            this.activeDownloadTaskCount = v + 1;
            if(v == 0) {
                this.sendEmptyMessageDelayed(11, 5000L);
            }
            downloadManager$Task1.start();
            return downloadManager$Task1;
        }

        private void syncRemovingDownload(Task downloadManager$Task0, Download download0) {
            if(downloadManager$Task0 != null) {
                if(!Task.access$000(downloadManager$Task0)) {
                    downloadManager$Task0.cancel(false);
                }
                return;
            }
            Downloader downloader0 = this.downloaderFactory.createDownloader(download0.request);
            Task downloadManager$Task1 = new Task(download0.request, downloader0, download0.progress, true, this.minRetryCount, this, null);
            this.activeTasks.put(download0.request.id, downloadManager$Task1);
            downloadManager$Task1.start();
        }

        private void syncStoppedDownload(Task downloadManager$Task0) {
            if(downloadManager$Task0 != null) {
                Assertions.checkState(!Task.access$000(downloadManager$Task0));
                downloadManager$Task0.cancel(false);
            }
        }

        private void syncTasks() {
            int v1 = 0;
            for(int v = 0; v < this.downloads.size(); ++v) {
                Download download0 = (Download)this.downloads.get(v);
                Task downloadManager$Task0 = (Task)this.activeTasks.get(download0.request.id);
                switch(download0.state) {
                    case 0: {
                        downloadManager$Task0 = this.syncQueuedDownload(downloadManager$Task0, download0);
                        break;
                    }
                    case 1: {
                        this.syncStoppedDownload(downloadManager$Task0);
                        break;
                    }
                    case 2: {
                        Assertions.checkNotNull(downloadManager$Task0);
                        this.syncDownloadingDownload(downloadManager$Task0, download0, v1);
                        break;
                    }
                    case 5: 
                    case 7: {
                        this.syncRemovingDownload(downloadManager$Task0, download0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
                if(downloadManager$Task0 != null && !Task.access$000(downloadManager$Task0)) {
                    ++v1;
                }
            }
        }

        private void updateProgress() {
            for(int v = 0; v < this.downloads.size(); ++v) {
                Download download0 = (Download)this.downloads.get(v);
                if(download0.state == 2) {
                    try {
                        this.downloadIndex.putDownload(download0);
                    }
                    catch(IOException iOException0) {
                        Log.e("DownloadManager", "Failed to update index.", iOException0);
                    }
                }
            }
            this.sendEmptyMessageDelayed(11, 5000L);
        }
    }

    public interface Listener {
        default void onDownloadChanged(DownloadManager downloadManager0, Download download0) {
        }

        default void onDownloadRemoved(DownloadManager downloadManager0, Download download0) {
        }

        default void onDownloadsPausedChanged(DownloadManager downloadManager0, boolean z) {
        }

        default void onIdle(DownloadManager downloadManager0) {
        }

        default void onInitialized(DownloadManager downloadManager0) {
        }

        default void onRequirementsStateChanged(DownloadManager downloadManager0, Requirements requirements0, int v) {
        }

        default void onWaitingForRequirementsChanged(DownloadManager downloadManager0, boolean z) {
        }
    }

    static class Task extends Thread implements ProgressListener {
        private long contentLength;
        private final DownloadProgress downloadProgress;
        private final Downloader downloader;
        private Throwable finalError;
        private volatile InternalHandler internalHandler;
        private volatile boolean isCanceled;
        private final boolean isRemove;
        private final int minRetryCount;
        private final DownloadRequest request;

        private Task(DownloadRequest downloadRequest0, Downloader downloader0, DownloadProgress downloadProgress0, boolean z, int v, InternalHandler downloadManager$InternalHandler0) {
            this.request = downloadRequest0;
            this.downloader = downloader0;
            this.downloadProgress = downloadProgress0;
            this.isRemove = z;
            this.minRetryCount = v;
            this.internalHandler = downloadManager$InternalHandler0;
            this.contentLength = -1L;
        }

        public Task(DownloadRequest downloadRequest0, Downloader downloader0, DownloadProgress downloadProgress0, boolean z, int v, InternalHandler downloadManager$InternalHandler0, com.google.android.exoplayer2.offline.DownloadManager.1 downloadManager$10) {
            this(downloadRequest0, downloader0, downloadProgress0, z, v, downloadManager$InternalHandler0);
        }

        public static boolean access$000(Task downloadManager$Task0) {
            return downloadManager$Task0.isRemove;
        }

        public static DownloadRequest access$200(Task downloadManager$Task0) {
            return downloadManager$Task0.request;
        }

        public static long access$300(Task downloadManager$Task0) {
            return downloadManager$Task0.contentLength;
        }

        public static boolean access$400(Task downloadManager$Task0) {
            return downloadManager$Task0.isCanceled;
        }

        public static Throwable access$500(Task downloadManager$Task0) {
            return downloadManager$Task0.finalError;
        }

        public void cancel(boolean z) {
            if(z) {
                this.internalHandler = null;
            }
            if(!this.isCanceled) {
                this.isCanceled = true;
                this.downloader.cancel();
                this.interrupt();
            }
        }

        private static int getRetryDelayMillis(int v) {
            return Math.min((v - 1) * 1000, 5000);
        }

        @Override  // com.google.android.exoplayer2.offline.Downloader$ProgressListener
        public void onProgress(long v, long v1, float f) {
            this.downloadProgress.bytesDownloaded = v1;
            this.downloadProgress.percentDownloaded = f;
            if(v != this.contentLength) {
                this.contentLength = v;
                InternalHandler downloadManager$InternalHandler0 = this.internalHandler;
                if(downloadManager$InternalHandler0 != null) {
                    downloadManager$InternalHandler0.obtainMessage(10, this).sendToTarget();
                }
            }
        }

        @Override
        public void run() {
            try {
                if(this.isRemove) {
                    this.downloader.remove();
                }
                else {
                    long v = -1L;
                    int v1 = 0;
                label_5:
                    while(!this.isCanceled) {
                        try {
                            this.downloader.download(this);
                            break;
                        }
                        catch(IOException iOException0) {
                            if(this.isCanceled) {
                                continue;
                            }
                            long v2 = this.downloadProgress.bytesDownloaded;
                            if(v2 != v) {
                                v1 = 0;
                                v = v2;
                            }
                            ++v1;
                            if(v1 > this.minRetryCount) {
                                throw iOException0;
                            }
                            Thread.sleep(Task.getRetryDelayMillis(v1));
                        }
                    }
                }
            }
            catch(Throwable throwable0) {
                this.finalError = throwable0;
                if(true) {
                    goto label_22;
                }
                goto label_5;
            }
        label_22:
            InternalHandler downloadManager$InternalHandler0 = this.internalHandler;
            if(downloadManager$InternalHandler0 != null) {
                downloadManager$InternalHandler0.obtainMessage(9, this).sendToTarget();
            }
        }
    }

    public static final int DEFAULT_MAX_PARALLEL_DOWNLOADS = 3;
    public static final int DEFAULT_MIN_RETRY_COUNT = 5;
    public static final Requirements DEFAULT_REQUIREMENTS = null;
    private static final int MSG_ADD_DOWNLOAD = 6;
    private static final int MSG_CONTENT_LENGTH_CHANGED = 10;
    private static final int MSG_DOWNLOAD_UPDATE = 2;
    private static final int MSG_INITIALIZE = 0;
    private static final int MSG_INITIALIZED = 0;
    private static final int MSG_PROCESSED = 1;
    private static final int MSG_RELEASE = 12;
    private static final int MSG_REMOVE_ALL_DOWNLOADS = 8;
    private static final int MSG_REMOVE_DOWNLOAD = 7;
    private static final int MSG_SET_DOWNLOADS_PAUSED = 1;
    private static final int MSG_SET_MAX_PARALLEL_DOWNLOADS = 4;
    private static final int MSG_SET_MIN_RETRY_COUNT = 5;
    private static final int MSG_SET_NOT_MET_REQUIREMENTS = 2;
    private static final int MSG_SET_STOP_REASON = 3;
    private static final int MSG_TASK_STOPPED = 9;
    private static final int MSG_UPDATE_PROGRESS = 11;
    private static final String TAG = "DownloadManager";
    private int activeTaskCount;
    private final Context context;
    private final WritableDownloadIndex downloadIndex;
    private List downloads;
    private boolean downloadsPaused;
    private boolean initialized;
    private final InternalHandler internalHandler;
    private final CopyOnWriteArraySet listeners;
    private final Handler mainHandler;
    private int maxParallelDownloads;
    private int minRetryCount;
    private int notMetRequirements;
    private int pendingMessages;
    private final com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener requirementsListener;
    private RequirementsWatcher requirementsWatcher;
    private boolean waitingForRequirements;

    static {
        DownloadManager.DEFAULT_REQUIREMENTS = new Requirements(1);
    }

    public DownloadManager(Context context0, DatabaseProvider databaseProvider0, Cache cache0, Factory dataSource$Factory0) {
        this(context0, new DefaultDownloadIndex(databaseProvider0), new DefaultDownloaderFactory(new DownloaderConstructorHelper(cache0, dataSource$Factory0)));
    }

    public DownloadManager(Context context0, WritableDownloadIndex writableDownloadIndex0, DownloaderFactory downloaderFactory0) {
        this.context = context0.getApplicationContext();
        this.downloadIndex = writableDownloadIndex0;
        this.maxParallelDownloads = 3;
        this.minRetryCount = 5;
        this.downloadsPaused = true;
        this.downloads = Collections.EMPTY_LIST;
        this.listeners = new CopyOnWriteArraySet();
        Handler handler0 = Util.createHandler(new b(this, 1));
        this.mainHandler = handler0;
        HandlerThread handlerThread0 = new HandlerThread("DownloadManager file i/o");
        handlerThread0.start();
        InternalHandler downloadManager$InternalHandler0 = new InternalHandler(handlerThread0, writableDownloadIndex0, downloaderFactory0, handler0, 3, 5, true);
        this.internalHandler = downloadManager$InternalHandler0;
        c c0 = (RequirementsWatcher requirementsWatcher0, int v) -> {
            if(this.notMetRequirements != v) {
                this.notMetRequirements = v;
                ++this.pendingMessages;
                this.internalHandler.obtainMessage(2, v, 0).sendToTarget();
            }
            boolean z = this.updateWaitingForRequirements();
            Iterator iterator0 = this.listeners.iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
            }
            if(z) {
                this.notifyWaitingForRequirementsChanged();
            }
        };
        this.requirementsListener = c0;
        RequirementsWatcher requirementsWatcher0 = new RequirementsWatcher(context0, c0, DownloadManager.DEFAULT_REQUIREMENTS);
        this.requirementsWatcher = requirementsWatcher0;
        int v = requirementsWatcher0.start();
        this.notMetRequirements = v;
        this.pendingMessages = 1;
        downloadManager$InternalHandler0.obtainMessage(0, v, 0).sendToTarget();
    }

    public void addDownload(DownloadRequest downloadRequest0) {
        this.addDownload(downloadRequest0, 0);
    }

    public void addDownload(DownloadRequest downloadRequest0, int v) {
        ++this.pendingMessages;
        this.internalHandler.obtainMessage(6, v, 0, downloadRequest0).sendToTarget();
    }

    public void addListener(Listener downloadManager$Listener0) {
        this.listeners.add(downloadManager$Listener0);
    }

    public List getCurrentDownloads() {
        return this.downloads;
    }

    public DownloadIndex getDownloadIndex() {
        return this.downloadIndex;
    }

    public boolean getDownloadsPaused() {
        return this.downloadsPaused;
    }

    public int getMaxParallelDownloads() {
        return this.maxParallelDownloads;
    }

    public int getMinRetryCount() {
        return this.minRetryCount;
    }

    public int getNotMetRequirements() {
        return this.notMetRequirements;
    }

    public Requirements getRequirements() {
        return this.requirementsWatcher.getRequirements();
    }

    private boolean handleMainMessage(Message message0) {
        int v = message0.what;
        switch(v) {
            case 0: {
                this.onInitialized(((List)message0.obj));
                return true;
            }
            case 1: {
                this.onMessageProcessed(message0.arg1, message0.arg2);
                return true;
            }
            default: {
                if(v != 2) {
                    throw new IllegalStateException();
                }
                this.onDownloadUpdate(((DownloadUpdate)message0.obj));
                return true;
            }
        }
    }

    public boolean isIdle() {
        return this.activeTaskCount == 0 && this.pendingMessages == 0;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public boolean isWaitingForRequirements() {
        return this.waitingForRequirements;
    }

    public static Download mergeRequest(Download download0, DownloadRequest downloadRequest0, int v, long v1) {
        long v2 = download0.state == 5 || download0.isTerminalState() ? v1 : download0.startTimeMs;
        if(download0.state != 5 && download0.state != 7) {
            return v == 0 ? new Download(download0.request.copyWithMergedRequest(downloadRequest0), 0, v2, v1, -1L, 0, 0) : new Download(download0.request.copyWithMergedRequest(downloadRequest0), 1, v2, v1, -1L, v, 0);
        }
        return new Download(download0.request.copyWithMergedRequest(downloadRequest0), 7, v2, v1, -1L, v, 0);
    }

    private void notifyWaitingForRequirementsChanged() {
        for(Object object0: this.listeners) {
            ((Listener)object0).onWaitingForRequirementsChanged(this, this.waitingForRequirements);
        }
    }

    private void onDownloadUpdate(DownloadUpdate downloadManager$DownloadUpdate0) {
        this.downloads = Collections.unmodifiableList(downloadManager$DownloadUpdate0.downloads);
        Download download0 = downloadManager$DownloadUpdate0.download;
        boolean z = this.updateWaitingForRequirements();
        if(downloadManager$DownloadUpdate0.isRemove) {
            for(Object object0: this.listeners) {
                ((Listener)object0).onDownloadRemoved(this, download0);
            }
        }
        else {
            for(Object object1: this.listeners) {
                ((Listener)object1).onDownloadChanged(this, download0);
            }
        }
        if(z) {
            this.notifyWaitingForRequirementsChanged();
        }
    }

    private void onInitialized(List list0) {
        this.initialized = true;
        this.downloads = Collections.unmodifiableList(list0);
        boolean z = this.updateWaitingForRequirements();
        for(Object object0: this.listeners) {
            ((Listener)object0).onInitialized(this);
        }
        if(z) {
            this.notifyWaitingForRequirementsChanged();
        }
    }

    private void onMessageProcessed(int v, int v1) {
        this.pendingMessages -= v;
        this.activeTaskCount = v1;
        if(this.isIdle()) {
            for(Object object0: this.listeners) {
                ((Listener)object0).onIdle(this);
            }
        }
    }

    // 检测为 Lambda 实现
    private void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher0, int v) [...]

    public void pauseDownloads() {
        this.setDownloadsPaused(true);
    }

    public void release() {
        synchronized(this.internalHandler) {
            InternalHandler downloadManager$InternalHandler1 = this.internalHandler;
            if(downloadManager$InternalHandler1.released) {
                return;
            }
            downloadManager$InternalHandler1.sendEmptyMessage(12);
            boolean z = false;
            while(true) {
                InternalHandler downloadManager$InternalHandler2 = this.internalHandler;
                if(downloadManager$InternalHandler2.released) {
                    break;
                }
                try {
                    downloadManager$InternalHandler2.wait();
                }
                catch(InterruptedException unused_ex) {
                    z = true;
                }
            }
            if(z) {
                Thread.currentThread().interrupt();
            }
            this.mainHandler.removeCallbacksAndMessages(null);
            this.downloads = Collections.EMPTY_LIST;
            this.pendingMessages = 0;
            this.activeTaskCount = 0;
            this.initialized = false;
            this.notMetRequirements = 0;
            this.waitingForRequirements = false;
        }
    }

    public void removeAllDownloads() {
        ++this.pendingMessages;
        this.internalHandler.obtainMessage(8).sendToTarget();
    }

    public void removeDownload(String s) {
        ++this.pendingMessages;
        this.internalHandler.obtainMessage(7, s).sendToTarget();
    }

    public void removeListener(Listener downloadManager$Listener0) {
        this.listeners.remove(downloadManager$Listener0);
    }

    public void resumeDownloads() {
        this.setDownloadsPaused(false);
    }

    private void setDownloadsPaused(boolean z) {
        if(this.downloadsPaused != z) {
            this.downloadsPaused = z;
            ++this.pendingMessages;
            this.internalHandler.obtainMessage(1, ((int)z), 0).sendToTarget();
            boolean z1 = this.updateWaitingForRequirements();
            Iterator iterator0 = this.listeners.iterator();
            while(iterator0.hasNext()) {
                iterator0.next();
            }
            if(z1) {
                this.notifyWaitingForRequirementsChanged();
            }
        }
    }

    public void setMaxParallelDownloads(int v) {
        Assertions.checkArgument(v > 0);
        if(this.maxParallelDownloads == v) {
            return;
        }
        this.maxParallelDownloads = v;
        ++this.pendingMessages;
        this.internalHandler.obtainMessage(4, v, 0).sendToTarget();
    }

    public void setMinRetryCount(int v) {
        Assertions.checkArgument(v >= 0);
        if(this.minRetryCount == v) {
            return;
        }
        this.minRetryCount = v;
        ++this.pendingMessages;
        this.internalHandler.obtainMessage(5, v, 0).sendToTarget();
    }

    public void setRequirements(Requirements requirements0) {
        if(requirements0.equals(this.requirementsWatcher.getRequirements())) {
            return;
        }
        this.requirementsWatcher.stop();
        RequirementsWatcher requirementsWatcher0 = new RequirementsWatcher(this.context, this.requirementsListener, requirements0);
        this.requirementsWatcher = requirementsWatcher0;
        int v = requirementsWatcher0.start();
        this.onRequirementsStateChanged(this.requirementsWatcher, v);
    }

    public void setStopReason(String s, int v) {
        ++this.pendingMessages;
        this.internalHandler.obtainMessage(3, v, 0, s).sendToTarget();
    }

    private boolean updateWaitingForRequirements() {
        boolean z = false;
        boolean z1 = true;
        if(!this.downloadsPaused && this.notMetRequirements != 0) {
            for(int v = 0; v < this.downloads.size(); ++v) {
                if(((Download)this.downloads.get(v)).state == 0) {
                    z = true;
                    break;
                }
            }
        }
        if(this.waitingForRequirements == z) {
            z1 = false;
        }
        this.waitingForRequirements = z;
        return z1;
    }

    class com.google.android.exoplayer2.offline.DownloadManager.1 {
    }

}

