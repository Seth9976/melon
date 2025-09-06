package com.facebook.appevents.internal;

import android.os.AsyncTask;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0017B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\'\u0010\u000E\u001A\u00020\u00042\u0016\u0010\r\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\f\"\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "", "uriStr", "Ljava/io/File;", "destFile", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "onSuccess", "<init>", "(Ljava/lang/String;Ljava/io/File;Lcom/facebook/appevents/internal/FileDownloadTask$Callback;)V", "", "args", "doInBackground", "([Ljava/lang/String;)Ljava/lang/Boolean;", "isSuccess", "Lie/H;", "onPostExecute", "(Z)V", "Ljava/lang/String;", "Ljava/io/File;", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FileDownloadTask extends AsyncTask {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "", "Ljava/io/File;", "file", "Lie/H;", "onComplete", "(Ljava/io/File;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        void onComplete(@NotNull File arg1);
    }

    @NotNull
    private final File destFile;
    @NotNull
    private final Callback onSuccess;
    @NotNull
    private final String uriStr;

    public FileDownloadTask(@NotNull String s, @NotNull File file0, @NotNull Callback fileDownloadTask$Callback0) {
        q.g(s, "uriStr");
        q.g(file0, "destFile");
        q.g(fileDownloadTask$Callback0, "onSuccess");
        super();
        this.uriStr = s;
        this.destFile = file0;
        this.onSuccess = fileDownloadTask$Callback0;
    }

    @NotNull
    public Boolean doInBackground(@NotNull String[] arr_s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(arr_s, "args");
            try {
                URL uRL0 = new URL(this.uriStr);
                int v = uRL0.openConnection().getContentLength();
                DataInputStream dataInputStream0 = new DataInputStream(uRL0.openStream());
                byte[] arr_b = new byte[v];
                dataInputStream0.readFully(arr_b);
                dataInputStream0.close();
                DataOutputStream dataOutputStream0 = new DataOutputStream(new FileOutputStream(this.destFile));
                dataOutputStream0.write(arr_b);
                dataOutputStream0.flush();
                dataOutputStream0.close();
                return true;
            }
            catch(Exception unused_ex) {
                return false;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Override  // android.os.AsyncTask
    public Object doInBackground(Object[] arr_object) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.doInBackground(((String[])arr_object));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Override  // android.os.AsyncTask
    public void onPostExecute(Object object0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.onPostExecute(((Boolean)object0).booleanValue());
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public void onPostExecute(boolean z) {
        if(!CrashShieldHandler.isObjectCrashing(this) && z) {
            try {
                this.onSuccess.onComplete(this.destFile);
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }
}

