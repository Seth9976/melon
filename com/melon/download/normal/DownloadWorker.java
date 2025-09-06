package com.melon.download.normal;

import Ba.L;
import Bb.b;
import Bb.c;
import Bb.g;
import Bb.l;
import Bb.o;
import E9.h;
import O8.d;
import P8.a;
import U4.i;
import U4.r;
import U4.u;
import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventDownloadFailed;
import com.iloen.melon.net.v4x.response.DownloadPathRes.Response.ContentsInfo;
import com.iloen.melon.net.v4x.response.DownloadPathRes.Response;
import com.iloen.melon.net.v4x.response.DownloadPathRes;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.error.ErrorReportManager;
import com.iloen.melon.utils.network.CookieHelper;
import com.iloen.melon.utils.system.ToastManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import je.p;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tg.Q;
import va.e;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/melon/download/normal/DownloadWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DownloadWorker extends CoroutineWorker {
    public final Context g;
    public final LogU h;
    public final DownloadNotificationManager i;

    public DownloadWorker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0) {
        q.g(context0, "context");
        q.g(workerParameters0, "workerParams");
        super(context0, workerParameters0);
        this.g = context0;
        LogU logU0 = new LogU("DownloadWorker");
        logU0.setCategory(Category.Download);
        logU0.setUseThreadInfo(true);
        this.h = logU0;
        this.i = new DownloadNotificationManager(context0);
    }

    @Override  // androidx.work.CoroutineWorker
    public final Object c(Continuation continuation0) {
        c c0;
        String s2;
        Exception exception1;
        o o0;
        LogU.debug$default(this.h, "doWork() start.", null, false, 6, null);
        i i0 = this.b.b;
        i0.getClass();
        Boolean boolean0 = Boolean.FALSE;
        Object object0 = i0.a.get("KEY_TOAST");
        if(object0 instanceof Boolean) {
            boolean0 = object0;
        }
        if(boolean0.booleanValue()) {
            ToastManager.show("다운로드를 시작합니다.");
        }
        synchronized(g.a) {
            c0 = (c)p.m0(g.b);
        }
        if(c0 == null) {
            LogU.debug$default(this.h, "doWork() download item is null.", null, false, 6, null);
            c c1 = new c();
            this.i.a(3, c1);
            return new r(DownloadWorker.g("doWork() download item is null."));
        }
        if(this.c.get() != 0xFFFFFF00) {
            LogU.debug$default(this.h, "doWork() worker is stopped.", null, false, 6, null);
            this.i.a(3, c0);
        }
        try {
            g.d = c0;
            this.f(c0);
            LogU.debug$default(this.h, "processDownload url : " + c0.i + ", filename : " + c0.j + ", lyricPath : " + c0.k, null, false, 6, null);
            A0.c c2 = new A0.c(this, 6);
            if(StorageUtils.isScopedStorage()) {
                o0 = new o(c0, c2);  // 初始化器: LBb/h;-><init>(LBb/c;LA0/c;)V
                LogU.info$default(o0.c, "DownloaderForScopedStorage.init()", null, false, 6, null);
            }
            else {
                o0 = new l(c0, c2);  // 初始化器: LBb/h;-><init>(LBb/c;LA0/c;)V
                LogU.info$default(o0.c, "DownloaderForLegacy.int()", null, false, 6, null);
            }
            o0.b();
            exception1 = null;
        }
        catch(Exception exception0) {
            exception1 = exception0;
        }
        g.d = null;
        if(exception1 != null) {
            LogU.debug$default(this.h, androidx.appcompat.app.o.o("doWork() error [", c0.l, "] ", exception1.getMessage()), null, false, 6, null);
            String s = "";
            if(!(exception1 instanceof a)) {
                StringBuilder stringBuilder0 = new StringBuilder("id: ");
                stringBuilder0.append(c0.b);
                stringBuilder0.append("\r\ntype: ");
                stringBuilder0.append(c0.c);
                stringBuilder0.append("\r\ntitle: ");
                stringBuilder0.append(c0.l);
                stringBuilder0.append("\r\nartist: ");
                stringBuilder0.append(c0.m);
                stringBuilder0.append("\r\n");
                String s1 = c0.i;
                if(s1.length() > 0) {
                    try {
                        s2 = new URL(s1).getHost();
                        q.f(s2, "getHost(...)");
                    }
                    catch(MalformedURLException malformedURLException0) {
                        malformedURLException0.printStackTrace();
                        s2 = "";
                    }
                }
                else {
                    s2 = "";
                }
                if(s2.length() > 0) {
                    e.g(stringBuilder0, "domain: ", s2, "\r\n");
                }
                Map map0 = CookieHelper.getInstance().getCookieMap(Y.a(MelonAppBase.Companion));
                if(map0.containsKey("keyCookie")) {
                    Object object1 = map0.get("keyCookie");
                    q.d(object1);
                    s = (String)object1;
                }
                if(s.length() > 0) {
                    e.g(stringBuilder0, "keyCookie: ", s, "\r\n");
                }
                stringBuilder0.append("download log: start\r\n");
                StringBuilder stringBuilder1 = new StringBuilder();
                for(Object object2: c0.s) {
                    stringBuilder1.append(((String)object2));
                }
                String s3 = stringBuilder1.toString();
                q.f(s3, "toString(...)");
                stringBuilder0.append(s3);
                stringBuilder0.append("\r\ndownload log: end\r\n");
                stringBuilder0.append(ErrorReportManager.getStackTraceInfoFrom(exception1));
                d.g(stringBuilder0.toString());
            }
            if(exception1 instanceof a) {
                this.i.a(3, c0);
                return new r(DownloadWorker.g("doWork() download cancelled."));
            }
            if(exception1 instanceof P8.d) {
                synchronized(g.a) {
                    g.c.addAll(g.b);
                    g.b.clear();
                }
                this.i.a(4, c0);
                return new r(DownloadWorker.g("doWork() not enough storage."));
            }
            g g0 = g.a;
            synchronized(g0) {
                if(g.b.contains(c0) && g0.a(c0)) {
                    g.c.add(c0);
                }
            }
            this.i.a(4, c0);
            this.e();
        }
        if(g.b.isEmpty() && !c0.c()) {
            if(g.c.isEmpty()) {
                MelonAppBase.Companion.getClass();
                if(t.a().isAppForeground()) {
                    ToastManager.show("다운로드가 완료 되었습니다. 다운로드 파일은 음악서랍에서 확인 가능합니다.");
                }
            }
            else {
                MelonAppBase.Companion.getClass();
                if(t.a().isAppForeground()) {
                    EventBusHelper.post(new EventDownloadFailed());
                }
                else {
                    ToastManager.show("다운로드에 실패한 곡이 있습니다. 다운로드 관리자에서 다시 시도해 주세요.");
                }
            }
        }
        LogU.debug$default(this.h, "doWork() end.", null, false, 6, null);
        return u.a();
    }

    public final void e() {
        if(!g.b.isEmpty()) {
            LogU.debug$default(this.h, "downloadNextItem", null, false, 6, null);
            b.c("downloadNextItem", false);
        }
    }

    public final void f(c c0) {
        MelonAppBase.Companion.getClass();
        L l0 = ((k8.o)(((Ma.l)com.google.firebase.b.B(t.a().getContext(), Ma.l.class)))).n();
        try {
            Q q0 = L.f(l0, c0.b, (c0.c == null ? null : c0.c.getValue()), c0.d, c0.e, c0.f, c0.g, c0.h).execute();
            if(q0 == null) {
                throw new Exception("getDownloadPath : response is null");
            }
            if(!q0.a.isSuccessful()) {
                throw new Exception("getDownloadPath : response is not successful");
            }
            Object object0 = q0.b;
            if(object0 == null) {
                throw new Exception("getDownloadPath : response body is null");
            }
            q.d(object0);
            Response downloadPathRes$Response0 = ((DownloadPathRes)object0).response;
            if(downloadPathRes$Response0 == null) {
                throw new Exception("getDownloadPath : responseBody response is null");
            }
            if(!q.b(downloadPathRes$Response0.result, "0")) {
                throw new Exception("getDownloadPath : responseBody response result is not 0");
            }
            ArrayList arrayList0 = ((DownloadPathRes)object0).response.contentsInfo;
            if(arrayList0 == null || arrayList0.isEmpty()) {
                throw new Exception("getDownloadPath : infoList is null or empty");
            }
            String s = "";
            ContentsInfo downloadPathRes$Response$ContentsInfo0 = (ContentsInfo)p.k0(arrayList0);
            c0.i = downloadPathRes$Response$ContentsInfo0.path == null ? "" : downloadPathRes$Response$ContentsInfo0.path;
            String s1 = downloadPathRes$Response$ContentsInfo0.filename;
            c0.j = s1 == null ? "" : s1;
            c0.k = downloadPathRes$Response$ContentsInfo0.lyricPath == null ? "" : downloadPathRes$Response$ContentsInfo0.lyricPath;
            if(s1 != null) {
                s = s1;
            }
            c0.l = s;
            c0.n = downloadPathRes$Response$ContentsInfo0.solTypeCode;
            c0.o = downloadPathRes$Response$ContentsInfo0.sol;
            c0.p = downloadPathRes$Response$ContentsInfo0.solFileUpdtDate;
            LogU.debug$default(this.h, "getDownloadPath contentInfo : " + downloadPathRes$Response$ContentsInfo0, null, false, 6, null);
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            throw new Exception("getDownloadPath : Exception occurs");
        }
    }

    public static i g(String s) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        linkedHashMap0.put("FAIL_MESSAGE", s);
        i i0 = new i(linkedHashMap0);
        h.X(i0);
        return i0;
    }
}

