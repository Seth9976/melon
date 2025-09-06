package com.google.android.exoplayer2.offline;

import java.io.File;

public final class ActionFileUpgradeUtil {
    public interface DownloadIdProvider {
        String getId(DownloadRequest arg1);
    }

    public static void mergeRequest(DownloadRequest downloadRequest0, DefaultDownloadIndex defaultDownloadIndex0, boolean z, long v) {
        Download download0 = defaultDownloadIndex0.getDownload(downloadRequest0.id);
        defaultDownloadIndex0.putDownload((download0 == null ? new Download(downloadRequest0, (z ? 3 : 0), v, v, -1L, 0, 0) : DownloadManager.mergeRequest(download0, downloadRequest0, download0.stopReason, v)));
    }

    public static void upgradeAndDelete(File file0, DownloadIdProvider actionFileUpgradeUtil$DownloadIdProvider0, DefaultDownloadIndex defaultDownloadIndex0, boolean z, boolean z1) {
        ActionFile actionFile0 = new ActionFile(file0);
        if(actionFile0.exists()) {
            try {
                long v = System.currentTimeMillis();
                DownloadRequest[] arr_downloadRequest = actionFile0.load();
                int v1 = 0;
                while(true) {
                    if(v1 >= arr_downloadRequest.length) {
                        goto label_16;
                    }
                    DownloadRequest downloadRequest0 = arr_downloadRequest[v1];
                    if(actionFileUpgradeUtil$DownloadIdProvider0 != null) {
                        downloadRequest0 = downloadRequest0.copyWithId(actionFileUpgradeUtil$DownloadIdProvider0.getId(downloadRequest0));
                    }
                    ActionFileUpgradeUtil.mergeRequest(downloadRequest0, defaultDownloadIndex0, z1, v);
                    ++v1;
                    continue;
                label_13:
                    if(!z) {
                        throw throwable0;
                    }
                    break;
                }
            }
            catch(Throwable throwable0) {
                goto label_13;
            }
            actionFile0.delete();
            throw throwable0;
        label_16:
            actionFile0.delete();
        }
    }
}

