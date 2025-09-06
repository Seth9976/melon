package B6;

import P8.d;
import Q8.a;
import Q8.b;
import Q8.c;
import Q8.g;
import Q8.h;
import Q8.i;
import Q8.j;
import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventAlertDialog;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPremiumDownload.EventType;
import com.iloen.melon.offline.OfflineDownloadService;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;

public final class e implements Handler.Callback {
    public final int a;
    public final Object b;

    public e(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        switch(this.a) {
            case 0: {
                if(message0.what != 0) {
                    return false;
                }
                f f0 = (f)this.b;
                if(message0.obj == null) {
                    Object object0 = f0.a;
                    synchronized(object0) {
                        throw null;
                    }
                }
                throw new ClassCastException();
            }
            case 1: {
                g g0 = (g)this.b;
                if(message0 != null) {
                    int v1 = message0.what;
                    if(v1 == 99) {
                        Object object1 = message0.obj;
                        if(object1 instanceof Q8.f) {
                            if(g0.f > ((Q8.f)object1).c) {
                                LogU.d("PremiumDownloadManager", "handleMessage() - ignore message");
                                return false;
                            }
                            LogU.i("PremiumDownloadManager", "validateRequestList()");
                            if(g0.d == null) {
                                Context context0 = MelonAppBase.instance.getContext();
                                try {
                                    PendingIntent.getForegroundService(context0, 0, new Intent(context0, OfflineDownloadService.class).setAction("com.iloen.melon.intent.action.offlinedownload.start"), 0x4000000).send();
                                }
                                catch(PendingIntent.CanceledException pendingIntent$CanceledException0) {
                                    LogU.e("PremiumDownloadManager", "onFinishDownloader()", pendingIntent$CanceledException0);
                                }
                            }
                            g0.d = (Q8.f)object1;
                            ((Q8.f)object1).c(new b(g0));
                            return true;
                        }
                    }
                    else if(v1 == 98) {
                        Object object2 = message0.obj;
                        if(object2 instanceof Q8.f) {
                            LogU.i("PremiumDownloadManager", "checkRequestList()");
                            if(((Q8.f)object2) != null) {
                                ((Q8.f)object2).c(new c());  // 初始化器: Ljava/lang/Object;-><init>()V
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            default: {
                j j0 = (j)this.b;
                if(message0 != null && message0.what == 99) {
                    if(!j0.c.a.a.a.isEmpty()) {
                        j0.c.getClass();
                        j0.g = true;
                        b b0 = j0.c;
                        LogU.i("PremiumDownloader", "processDownload()");
                        j0.f = true;
                        while(!b0.a.a.a.isEmpty()) {
                            try {
                                a a0 = new a(j0.e, b0.b());
                                j0.d = a0;
                                a0.d(new i(j0));
                                Thread.sleep(200L);
                            }
                            catch(Exception exception0) {
                                Playable playable0 = j0.d == null ? null : j0.d.a;
                                if(playable0 == null) {
                                    break;
                                }
                                if(!(exception0 instanceof P8.a)) {
                                    LogU.e("PremiumDownloader", "processDownload() - [] error : " + exception0.getMessage());
                                    j.a(EventType.ERROR, playable0, exception0);
                                    j.b(playable0, exception0);
                                }
                                if(exception0 instanceof d || exception0 instanceof P8.c || exception0 instanceof P8.b) {
                                    if(exception0 instanceof d) {
                                        EventBusHelper.post(new EventAlertDialog("안내", "디바이스의 저장공간이 부족하여 오프라인 재생 파일을 받을 수 없습니다.\n\n디바이스 설정에서 저장공간을 확보해주세요."));
                                    }
                                    h h0 = b0.a.a;
                                    synchronized(h0) {
                                        h0.a.clear();
                                    }
                                    break;
                                }
                            }
                            finally {
                                j0.d = null;
                            }
                        }
                        j0.g = false;
                        g.a(j0.c.a);
                        return true;
                    }
                    j0.g = false;
                    g.a(j0.c.a);
                }
                return false;
            }
        }
    }
}

