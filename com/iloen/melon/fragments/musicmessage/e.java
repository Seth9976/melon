package com.iloen.melon.fragments.musicmessage;

import B3.r;
import B3.u;
import H8.q;
import U4.C;
import U4.E;
import U4.d;
import U4.i;
import a1.g;
import android.util.Log;
import android.view.View;
import b7.c;
import c2.B0;
import c2.v;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.iloen.melon.custom.N0;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.a1;
import com.iloen.melon.custom.b1;
import com.iloen.melon.fragments.news.FeedLogsListFragment;
import com.iloen.melon.fragments.radio.StationFragment;
import com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddTabFragment;
import com.iloen.melon.fragments.settings.SettingBannedContentsFragment;
import com.iloen.melon.fragments.settings.SettingLoudnessNormalizationFragment;
import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.fragments.settings.SettingOfflinePlayback;
import com.iloen.melon.fragments.settings.SettingScreenFragment;
import com.iloen.melon.net.v5x.response.ResponseV5Res;
import com.iloen.melon.playback.EpPlayLogger;
import com.iloen.melon.utils.shortcut.ShortcutManager.OnRequestListener;
import com.iloen.melon.utils.system.ToastManager;
import d5.n;
import d5.p;
import f1.D;
import f1.F;
import f1.o;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import n.a;

public final class e implements u, v, ErrorListener, Listener, Continuation, N0, a1, b1, OnRequestListener, F, a {
    public final int a;

    public e(int v) {
        this.a = v;
        super();
    }

    public e(q q0) {
        this.a = 27;
        super();
    }

    @Override  // f1.F
    public D a(g g0) {
        return new D(g0, o.a);
    }

    @Override  // n.a
    public Object apply(Object object0) {
        long v8;
        d d2;
        Iterator iterator1;
        C c1;
        long v7;
        boolean z;
        int v6;
        int v5;
        C c0;
        UUID uUID1;
        if(((List)object0) != null) {
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((List)object0)));
            for(Iterator iterator0 = ((List)object0).iterator(); iterator0.hasNext(); iterator0 = iterator1) {
                Object object1 = iterator0.next();
                p p0 = (p)object1;
                U4.D d0 = p0.b;
                i i0 = p0.q.isEmpty() ? i.b : ((i)p0.q.get(0));
                UUID uUID0 = UUID.fromString(p0.a);
                kotlin.jvm.internal.q.f(uUID0, "fromString(id)");
                HashSet hashSet0 = new HashSet(p0.p);
                i i1 = p0.c;
                int v = p0.h;
                int v1 = p0.m;
                d d1 = p0.g;
                long v2 = p0.d;
                long v3 = p0.e;
                int v4 = Long.compare(v3, 0L);
                if(v4 == 0) {
                    uUID1 = uUID0;
                    c0 = null;
                }
                else {
                    uUID1 = uUID0;
                    c0 = new C(v3, p0.f);
                }
                if(d0 == U4.D.a) {
                    if(v > 0) {
                        v5 = v1;
                        v6 = v;
                        z = true;
                    }
                    else {
                        v5 = v1;
                        v6 = v;
                        z = false;
                    }
                    v7 = v2;
                    c1 = c0;
                    iterator1 = iterator0;
                    d2 = d1;
                    v8 = n.m(z, v6, p0.i, p0.j, p0.k, p0.l, v4 != 0, v7, p0.f, v3, p0.n);
                }
                else {
                    iterator1 = iterator0;
                    c1 = c0;
                    v5 = v1;
                    d2 = d1;
                    v7 = v2;
                    v6 = v;
                    v8 = 0x7FFFFFFFFFFFFFFFL;
                }
                arrayList0.add(new E(uUID1, d0, hashSet0, i1, i0, v6, v5, d2, v7, c1, v8, p0.o));
            }
            return arrayList0;
        }
        return null;
    }

    @Override  // B3.u
    public r[] createExtractors() {
        return new r[]{new h4.a()};
    }

    @Override  // com.iloen.melon.custom.a1
    public void onButtonClick() {
        SettingOfflinePlayback.K();
    }

    @Override  // com.iloen.melon.custom.N0
    public void onCheckedChanged(RadioGroup radioGroup0, int v) {
        if(this.a != 13) {
            SettingScreenFragment.K(radioGroup0, v);
            return;
        }
        SettingLoudnessNormalizationFragment.K(radioGroup0, v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        switch(this.a) {
            case 0: {
                MusicMessageEditorFragment.requestClean$lambda$32(volleyError0);
                return;
            }
            case 1: {
                MusicMessageListFragment.blockUser$lambda$20$lambda$19(volleyError0);
                return;
            }
            case 2: {
                MusicMessageListFragment.unblockUser$lambda$24$lambda$23(volleyError0);
                return;
            }
            case 3: {
                MusicMessageListFragment.deleteItem$lambda$14$lambda$13(volleyError0);
                return;
            }
            case 5: {
                FeedLogsListFragment.i0(volleyError0);
                return;
            }
            case 6: {
                FeedLogsListFragment.e0(volleyError0);
                return;
            }
            case 7: {
                StationFragment.d0(volleyError0);
                return;
            }
            case 8: {
                PlaylistSearchAndAddTabFragment.C(volleyError0);
                return;
            }
            case 9: {
                PlaylistSearchAndAddTabFragment.K(volleyError0);
                return;
            }
            case 10: {
                SettingBannedContentsFragment.T(volleyError0);
                return;
            }
            case 12: {
                return;
            }
            case 19: {
                EpPlayLogger.b(volleyError0);
                return;
            }
            case 20: {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return;
            }
            case 21: {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return;
            }
            case 24: {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return;
            }
            default: {
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
        }
    }

    @Override  // com.iloen.melon.custom.b1
    public void onRadioBtnClick(boolean z) {
        if(this.a != 14) {
            SettingOfflinePlayback.N(z);
            return;
        }
        SettingLoudnessNormalizationFragment.M(z);
    }

    @Override  // com.iloen.melon.utils.shortcut.ShortcutManager$OnRequestListener
    public void onRequestFinish(String s) {
        SettingMainFragment.u0(s);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        if(this.a != 4) {
            ResponseV5Res responseV5Res0 = (ResponseV5Res)object0;
        }
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        if(this.a != 22) {
            kotlin.jvm.internal.q.g(view0, "view");
            S1.d d0 = b00.a.g(647);
            kotlin.jvm.internal.q.f(d0, "getInsets(...)");
            view0.setPadding(d0.a, d0.b, d0.c, d0.d);
            return b00;
        }
        kotlin.jvm.internal.q.g(view0, "view");
        S1.d d1 = b00.a.g(0x80);
        kotlin.jvm.internal.q.f(d1, "getInsets(...)");
        view0.setPadding(d1.a, d1.b, d1.c, d1.d);
        return b00;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        if(task0.isSuccessful()) {
            e7.a a0 = (e7.a)task0.getResult();
            c c0 = c.a;
            c0.b("Crashlytics report successfully enqueued to DataTransport: " + a0.b);
            File file0 = a0.c;
            if(file0.delete()) {
                c0.b("Deleted report file: " + file0.getPath());
                return true;
            }
            c0.f("Crashlytics could not delete report file: " + file0.getPath(), null);
            return true;
        }
        Log.w("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", task0.getException());
        return false;
    }
}

