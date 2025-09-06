package id;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class c extends Handler {
    public final f a;

    public c(f f0, Looper looper0) {
        this.a = f0;
        super(looper0);
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        q.g(message0, "msg");
        f f0 = this.a;
        switch(message0.what) {
            case 2001: {
                Object object0 = message0.obj;
                q.e(object0, "null cannot be cast to non-null type java.net.URL");
                int v = message0.arg1;
                f0.e = (URL)object0;
                if(v <= 1) {
                    v = 1;
                }
                f0.c = v;
                f0.d = ((long)v) * 10000L;
                F f1 = new F();
                f1.f = f0.d;
                f1.g = 0L;
                f1.h = new d(f0);
                f0.f = f1;
                x8.f.execute$default(f1, null, 1, null);
                return;
            }
            case 2002: {
                int v1 = message0.arg1;
                Object object1 = message0.obj;
                q.e(object1, "null cannot be cast to non-null type kotlin.ByteArray");
                byte[] arr_b = (byte[])object1;
                if(NetUtils.isConnected()) {
                    LogU.Companion.d("MusicSearchController", "searchMusicWithPianoforte() level : " + v1 + ", chunkData : " + arr_b.length);
                    if(v1 == 0) {
                        try {
                            URL uRL0 = f0.e;
                            if(uRL0 == null) {
                                q.m("pcmServerUrl");
                                throw null;
                            }
                            String s = uRL0.getPath();
                            URL uRL1 = f0.e;
                            if(uRL1 == null) {
                                q.m("pcmServerUrl");
                                throw null;
                            }
                            String s1 = String.format("%1s?%2s", Arrays.copyOf(new Object[]{s, uRL1.getQuery()}, 2));
                            URL uRL2 = f0.e;
                            if(uRL2 == null) {
                                q.m("pcmServerUrl");
                                throw null;
                            }
                            String s2 = uRL2.getHost();
                            q.f(s2, "getHost(...)");
                            URL uRL3 = f0.e;
                            if(uRL3 == null) {
                                q.m("pcmServerUrl");
                                throw null;
                            }
                            D d0 = new D(s2, s1, uRL3.getPort());
                            f0.h = d0;
                            d0.e = new e(f0);
                            goto label_59;
                        }
                        catch(Exception exception0) {
                        }
                        LogU.Companion.e("MusicSearchController", "searchMusicWithPianoforte() - Setting Error : " + exception0);
                    }
                label_59:
                    D d1 = f0.h;
                    if(d1 != null) {
                        try {
                            d1.b(v1, arr_b);
                        }
                        catch(Exception exception1) {
                            LogU.Companion.e("MusicSearchController", "searchMusicWithPianoforte() - Send Error : " + exception1);
                        }
                        return;
                    }
                }
                else {
                    LogU.Companion.d("MusicSearchController", "Network disconnected.");
                    F f2 = f0.f;
                    if(f2 != null) {
                        f2.cancel();
                        return;
                    }
                }
                break;
            }
            case 2003: {
                Object object2 = message0.obj;
                q.e(object2, "null cannot be cast to non-null type com.melon.ui.musicsearch.PcmSearchUnit");
                LogU.Companion.d("MusicSearchController", "finishSearchMusic()");
                LogU.Companion.d("MusicSearchController", "finishSearchMusic isMatched : " + (((B)object2).a == 2) + " tryCount : " + f0.c);
                if(((B)object2).a == 2 || f0.c <= 1) {
                    F f3 = f0.f;
                    if(f3 != null) {
                        f3.cancel();
                    }
                    f0.l.obtainMessage(1004, ((B)object2)).sendToTarget();
                    return;
                }
                break;
            }
            case 2004: {
                Companion logU$Companion0 = LogU.Companion;
                logU$Companion0.d("MusicSearchController", "MSG_ABORT_SEARCH_MUSIC pcmSender : " + f0.h);
                D d2 = f0.h;
                if(d2 != null) {
                    OutputStream outputStream0 = d2.b;
                    logU$Companion0.d("PcmSender", "sendEndOfFile()");
                    if(!d2.a.isClosed()) {
                        try {
                            logU$Companion0.d("PcmSender", "sendEndOfFile() : send end of file");
                            Charset charset0 = Charset.forName("utf-8");
                            q.f(charset0, "forName(...)");
                            byte[] arr_b1 = "0\r\n\r\n".getBytes(charset0);
                            q.f(arr_b1, "getBytes(...)");
                            outputStream0.write(arr_b1);
                            outputStream0.flush();
                        }
                        catch(IOException iOException0) {
                            iOException0.printStackTrace();
                        }
                        d2.a();
                        return;
                    }
                }
                break;
            }
            case 2005: {
                f0.a();
            }
        }
    }
}

