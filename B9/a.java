package b9;

import Cb.i;
import ac.A;
import ac.B;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.w;
import androidx.fragment.app.I;
import androidx.lifecycle.f0;
import b3.Z;
import cd.G1;
import cd.H1;
import cd.K0;
import cd.K;
import cd.L0;
import cd.N;
import cd.R0;
import cd.R1;
import cd.T1;
import cd.U0;
import cd.X0;
import cd.Y0;
import cd.b1;
import cd.c0;
import cd.d1;
import cd.d2;
import cd.f2;
import cd.q0;
import cd.r;
import cd.s0;
import com.facebook.appevents.c;
import com.google.gson.E;
import com.google.gson.internal.bind.X;
import com.google.gson.internal.bind.t;
import com.google.gson.o;
import com.google.gson.reflect.TypeToken;
import com.iloen.melon.custom.TypeAnimationText;
import com.iloen.melon.custom.VideoOverlayView;
import com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogFragment;
import com.iloen.melon.fragments.present.PresentSongSendFragment;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFragment;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.melon.playback.melon.streaming.tracker.ConnectionInfo;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import com.melon.playback.melon.streaming.tracker.RequestInfo;
import com.melon.playback.melon.streaming.tracker.ResponseInfo;
import com.melon.ui.J0;
import com.melon.ui.N0;
import com.melon.ui.O0;
import d3.g;
import dd.W;
import e;
import gd.H3;
import ie.H;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import md.h;
import r8.f;
import we.k;

public final class a implements we.a {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Buttons httpResponse$Notification$Buttons0;
        String s = null;
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                I i0 = ((d)object0).e;
                if(i0 != null) {
                    Context context0 = i0.getContext();
                    if(context0 != null) {
                        context0.startActivity(new Intent("android.intent.action.VIEW", f.m));
                    }
                }
                return h0;
            }
            case 1: {
                return P4.a.p(((B)object0));
            }
            case 2: {
                return PolymorphicSerializer.a(((PolymorphicSerializer)object0));
            }
            case 3: {
                return P4.a.p(((A)object0));
            }
            case 4: {
                return w.s(((r)object0).a.d);
            }
            case 5: {
                N n0 = new N(((K)object0));
                ((K)object0).c.invoke(n0);
                return h0;
            }
            case 6: {
                e e0 = ((c0)object0).b;
                k k0 = e0.c;
                if(k0 != null) {
                    k0.invoke(new f(e0));
                }
                return h0;
            }
            case 7: {
                s0 s00 = new s0(((q0)object0));
                ((q0)object0).b.invoke(s00);
                return h0;
            }
            case 8: {
                L0 l00 = new L0(((K0)object0));
                ((K0)object0).d.invoke(l00);
                return h0;
            }
            case 9: {
                U0 u00 = new U0(((R0)object0));
                ((R0)object0).c.invoke(u00);
                return h0;
            }
            case 10: {
                Y0 y00 = new Y0(((X0)object0));
                ((X0)object0).d.invoke(y00);
                return h0;
            }
            case 11: {
                d1 d10 = new d1(((b1)object0));
                ((b1)object0).b.invoke(d10);
                return h0;
            }
            case 12: {
                H1 h10 = new H1(((G1)object0));
                ((G1)object0).c.invoke(h10);
                return h0;
            }
            case 13: {
                T1 t10 = new T1(((R1)object0));
                ((R1)object0).b.invoke(t10);
                return h0;
            }
            case 14: {
                f2 f20 = new f2(((d2)object0));
                ((d2)object0).b.invoke(f20);
                return h0;
            }
            case 15: {
                return SerialDescriptorImpl.a(((SerialDescriptorImpl)object0));
            }
            case 16: {
                return new c(((TypeAnimationText)object0), 18);
            }
            case 17: {
                ((VideoOverlayView)object0).e0.start();
                return h0;
            }
            case 18: {
                return MonthlyDnaLogFragment.f0(((MonthlyDnaLogFragment)object0));
            }
            case 19: {
                return PresentSongSendFragment.q0(((PresentSongSendFragment)object0));
            }
            case 20: {
                return BottomTabBaseFragment.l(((BottomTabBaseFragment)object0));
            }
            case 21: {
                return MelonWebViewFragment.e0(((MelonWebViewFragment)object0));
            }
            case 22: {
                return new h(f0.f(((J0)object0)));
            }
            case 23: {
                ((N0)(((O0)object0))).d.a(false, false);
                return h0;
            }
            case 24: {
                if(((Notification)object0) == null) {
                label_64:
                    httpResponse$Notification$Buttons0 = null;
                }
                else {
                    ArrayList arrayList0 = ((Notification)object0).buttons;
                    if(arrayList0 != null && !arrayList0.isEmpty()) {
                        try {
                            httpResponse$Notification$Buttons0 = (Buttons)arrayList0.get(0);
                            goto label_65;
                        }
                        catch(IndexOutOfBoundsException unused_ex) {
                        }
                    }
                    goto label_64;
                }
            label_65:
                if(httpResponse$Notification$Buttons0 != null) {
                    s = httpResponse$Notification$Buttons0.linkUri;
                }
                if(s != null && s.length() != 0) {
                    MelonLinkExecutor.open(s);
                }
                return h0;
            }
            case 25: {
                q.g(((NetworkEvents)object0), "<this>");
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append("NetworkEvents");
                ConnectionInfo connectionInfo0 = ((NetworkEvents)object0).getConnection();
                if(connectionInfo0 != null) {
                    i.a(stringBuilder0, "Connection: " + connectionInfo0);
                }
                RequestInfo requestInfo0 = ((NetworkEvents)object0).getRequest();
                if(requestInfo0 != null) {
                    i.a(stringBuilder0, "Request: " + requestInfo0);
                }
                ResponseInfo responseInfo0 = ((NetworkEvents)object0).getResponse();
                if(responseInfo0 != null) {
                    i.a(stringBuilder0, "Response: " + responseInfo0);
                }
                Exception exception0 = ((NetworkEvents)object0).getError();
                if(exception0 != null) {
                    i.a(stringBuilder0, "Error: " + exception0);
                }
                if(!((NetworkEvents)object0).getEvents().isEmpty()) {
                    StringBuilder stringBuilder1 = Z.n(((NetworkEvents)object0).getEvents().size(), "Events (", ") / ", ((dc.a)p.s0(((NetworkEvents)object0).getEvents())).b - ((dc.a)p.k0(((NetworkEvents)object0).getEvents())).b);
                    stringBuilder1.append(" ms");
                    i.a(stringBuilder0, stringBuilder1.toString());
                    for(Object object1: ((NetworkEvents)object0).getEvents()) {
                        i.a(stringBuilder0, "  " + De.I.b0(((dc.a)object1).b) + "  " + ((dc.a)object1).a);
                    }
                }
                return stringBuilder0.toString();
            }
            case 26: {
                dd.H.o(((dd.d)object0), "", null, null, null, 0, 1950);
                H3 h30 = g.U("POWERDJ", null);
                Navigator.INSTANCE.open(h30);
                return h0;
            }
            case 27: {
                dd.H.o(((W)object0), "", null, null, null, 0, 0x7FE);
                H3 h31 = g.U("POWERDJ", null);
                Navigator.INSTANCE.open(h31);
                return h0;
            }
            case 28: {
                o o0 = new o();
                for(Object object2: ((Map)((d5.e)object0).b).entrySet()) {
                    Type type0 = (Type)((Map.Entry)object2).getKey();
                    Object object3 = ((Map.Entry)object2).getValue();
                    Objects.requireNonNull(type0);
                    T7.h.b(object3 instanceof com.google.gson.w || object3 instanceof E);
                    if(type0 == Object.class) {
                        throw new IllegalArgumentException("Cannot override built-in adapter for " + type0);
                    }
                    ArrayList arrayList1 = o0.e;
                    if(object3 instanceof com.google.gson.w) {
                        arrayList1.add(t.e(TypeToken.get(type0), ((com.google.gson.w)object3)));
                    }
                    if(object3 instanceof E) {
                        arrayList1.add(X.a(TypeToken.get(type0), ((E)object3)));
                    }
                }
                return o0.a();
            }
            default: {
                H0.e.w(((ed.Z.a)object0));
                return h0;
            }
        }
    }
}

