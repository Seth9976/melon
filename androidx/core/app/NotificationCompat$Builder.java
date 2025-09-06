package androidx.core.app;

import N1.C;
import N1.E;
import N1.f;
import N1.m;
import N1.s;
import N1.t;
import N1.u;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.g;
import androidx.core.graphics.drawable.IconCompat;
import d5.i;
import java.util.ArrayList;

public class NotificationCompat.Builder {
    public int A;
    public String B;
    public int C;
    public int D;
    public int E;
    public final boolean F;
    public final Notification G;
    public final ArrayList H;
    public final Context a;
    public final ArrayList b;
    public final ArrayList c;
    public final ArrayList d;
    public CharSequence e;
    public CharSequence f;
    public PendingIntent g;
    public IconCompat h;
    public int i;
    public int j;
    public boolean k;
    public boolean l;
    public s m;
    public CharSequence n;
    public int o;
    public int p;
    public boolean q;
    public String r;
    public boolean s;
    public String t;
    public boolean u;
    public boolean v;
    public boolean w;
    public String x;
    public Bundle y;
    public int z;

    @Deprecated
    public NotificationCompat.Builder(Context context0) {
        this(context0, null);
    }

    public NotificationCompat.Builder(Context context0, String s) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.k = true;
        this.u = false;
        this.z = 0;
        this.A = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        Notification notification0 = new Notification();
        this.G = notification0;
        this.a = context0;
        this.B = s;
        notification0.when = System.currentTimeMillis();
        notification0.audioStreamType = -1;
        this.j = 0;
        this.H = new ArrayList();
        this.F = true;
    }

    public final Notification a() {
        Bundle[] arr_bundle;
        ArrayList arrayList2;
        i i0 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        new ArrayList();
        i0.d = new Bundle();
        i0.c = this;
        Context context0 = this.a;
        i0.a = context0;
        Notification.Builder notification$Builder0 = new Notification.Builder(context0, this.B);
        i0.b = notification$Builder0;
        Notification notification0 = this.G;
        boolean z = true;
        Notification.Builder notification$Builder1 = notification$Builder0.setWhen(notification0.when).setSmallIcon(notification0.icon, notification0.iconLevel).setContent(notification0.contentView).setTicker(notification0.tickerText, null).setVibrate(notification0.vibrate).setLights(notification0.ledARGB, notification0.ledOnMS, notification0.ledOffMS).setOngoing((notification0.flags & 2) != 0).setOnlyAlertOnce((notification0.flags & 8) != 0).setAutoCancel((notification0.flags & 16) != 0).setDefaults(notification0.defaults).setContentTitle(this.e).setContentText(this.f).setContentInfo(null).setContentIntent(this.g).setDeleteIntent(notification0.deleteIntent);
        if((notification0.flags & 0x80) == 0) {
            z = false;
        }
        notification$Builder1.setFullScreenIntent(null, z).setNumber(this.i).setProgress(this.o, this.p, this.q);
        notification$Builder0.setLargeIcon((this.h == null ? null : this.h.k(context0)));
        notification$Builder0.setSubText(this.n).setUsesChronometer(this.l).setPriority(this.j);
        for(Object object0: this.b) {
            m m0 = (m)object0;
            if(m0.b == null) {
                int v = m0.f;
                if(v != 0) {
                    m0.b = IconCompat.d(null, "", v);
                }
            }
            IconCompat iconCompat0 = m0.b;
            boolean z1 = m0.d;
            Bundle bundle0 = m0.a;
            Icon icon0 = iconCompat0 == null ? null : iconCompat0.k(null);
            Notification.Action.Builder notification$Action$Builder0 = new Notification.Action.Builder(icon0, m0.g, m0.h);
            E[] arr_e = m0.c;
            if(arr_e != null) {
                int v1 = arr_e.length;
                RemoteInput[] arr_remoteInput = new RemoteInput[v1];
                if(arr_e.length <= 0) {
                    for(int v2 = 0; v2 < v1; ++v2) {
                        notification$Action$Builder0.addRemoteInput(arr_remoteInput[v2]);
                    }
                    goto label_45;
                }
                E e0 = arr_e[0];
                throw null;
            }
        label_45:
            Bundle bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
            bundle1.putBoolean("android.support.allowGeneratedReplies", z1);
            int v3 = Build.VERSION.SDK_INT;
            notification$Action$Builder0.setAllowGeneratedReplies(z1);
            bundle1.putInt("android.support.action.semanticAction", 0);
            if(v3 >= 28) {
                t.b(notification$Action$Builder0);
            }
            if(v3 >= 29) {
                f.d(notification$Action$Builder0);
            }
            if(v3 >= 0x1F) {
                u.a(notification$Action$Builder0);
            }
            bundle1.putBoolean("android.support.action.showsUserInterface", m0.e);
            notification$Action$Builder0.addExtras(bundle1);
            ((Notification.Builder)i0.b).addAction(notification$Action$Builder0.build());
        }
        Bundle bundle2 = this.y;
        if(bundle2 != null) {
            ((Bundle)i0.d).putAll(bundle2);
        }
        int v4 = Build.VERSION.SDK_INT;
        ((Notification.Builder)i0.b).setShowWhen(this.k);
        ((Notification.Builder)i0.b).setLocalOnly(this.u);
        ((Notification.Builder)i0.b).setGroup(this.r);
        ((Notification.Builder)i0.b).setSortKey(this.t);
        ((Notification.Builder)i0.b).setGroupSummary(this.s);
        ((Notification.Builder)i0.b).setCategory(this.x);
        ((Notification.Builder)i0.b).setColor(this.z);
        ((Notification.Builder)i0.b).setVisibility(this.A);
        ((Notification.Builder)i0.b).setPublicVersion(null);
        ((Notification.Builder)i0.b).setSound(notification0.sound, notification0.audioAttributes);
        ArrayList arrayList0 = this.H;
        ArrayList arrayList1 = this.c;
        if(v4 < 28) {
            if(arrayList1 == null) {
                arrayList2 = null;
            }
            else {
                arrayList2 = new ArrayList(arrayList1.size());
                for(Object object1: arrayList1) {
                    CharSequence charSequence0 = ((C)object1).a;
                    String s = ((C)object1).c;
                    if(s == null) {
                        s = charSequence0 == null ? "" : "name:" + charSequence0;
                    }
                    arrayList2.add(s);
                }
            }
            if(arrayList2 != null) {
                if(arrayList0 == null) {
                    arrayList0 = arrayList2;
                }
                else {
                    g g0 = new g(arrayList0.size() + arrayList2.size());
                    g0.addAll(arrayList2);
                    g0.addAll(arrayList0);
                    arrayList0 = new ArrayList(g0);
                }
            }
        }
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            for(Object object2: arrayList0) {
                ((Notification.Builder)i0.b).addPerson(((String)object2));
            }
        }
        ArrayList arrayList3 = this.d;
        if(arrayList3.size() > 0) {
            if(this.y == null) {
                this.y = new Bundle();
            }
            Bundle bundle3 = this.y.getBundle("android.car.EXTENSIONS");
            if(bundle3 == null) {
                bundle3 = new Bundle();
            }
            Bundle bundle4 = new Bundle(bundle3);
            Bundle bundle5 = new Bundle();
            int v5 = 0;
            while(v5 < arrayList3.size()) {
                String s1 = Integer.toString(v5);
                m m1 = (m)arrayList3.get(v5);
                Bundle bundle6 = new Bundle();
                if(m1.b == null) {
                    int v6 = m1.f;
                    if(v6 != 0) {
                        m1.b = IconCompat.d(null, "", v6);
                    }
                }
                bundle6.putInt("icon", (m1.b == null ? 0 : m1.b.e()));
                bundle6.putCharSequence("title", m1.g);
                bundle6.putParcelable("actionIntent", m1.h);
                Bundle bundle7 = m1.a == null ? new Bundle() : new Bundle(m1.a);
                bundle7.putBoolean("android.support.allowGeneratedReplies", m1.d);
                bundle6.putBundle("extras", bundle7);
                E[] arr_e1 = m1.c;
                if(arr_e1 == null) {
                    arr_bundle = null;
                }
                else {
                    arr_bundle = new Bundle[arr_e1.length];
                    if(arr_e1.length <= 0) {
                        goto label_134;
                    }
                    goto label_140;
                }
            label_134:
                bundle6.putParcelableArray("remoteInputs", arr_bundle);
                bundle6.putBoolean("showsUserInterface", m1.e);
                bundle6.putInt("semanticAction", 0);
                bundle5.putBundle(s1, bundle6);
                ++v5;
                continue;
            label_140:
                E e1 = arr_e1[0];
                new Bundle();
                throw null;
            }
            bundle3.putBundle("invisible_actions", bundle5);
            bundle4.putBundle("invisible_actions", bundle5);
            if(this.y == null) {
                this.y = new Bundle();
            }
            this.y.putBundle("android.car.EXTENSIONS", bundle3);
            ((Bundle)i0.d).putBundle("android.car.EXTENSIONS", bundle4);
        }
        int v7 = Build.VERSION.SDK_INT;
        ((Notification.Builder)i0.b).setExtras(this.y);
        ((Notification.Builder)i0.b).setRemoteInputHistory(null);
        ((Notification.Builder)i0.b).setBadgeIconType(this.C);
        ((Notification.Builder)i0.b).setSettingsText(null);
        ((Notification.Builder)i0.b).setShortcutId(null);
        ((Notification.Builder)i0.b).setTimeoutAfter(0L);
        ((Notification.Builder)i0.b).setGroupAlertBehavior(this.D);
        if(this.w) {
            ((Notification.Builder)i0.b).setColorized(this.v);
        }
        if(!TextUtils.isEmpty(this.B)) {
            ((Notification.Builder)i0.b).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if(v7 >= 28) {
            for(Object object3: arrayList1) {
                Notification.Builder notification$Builder2 = (Notification.Builder)i0.b;
                ((C)object3).getClass();
                t.a(notification$Builder2, t.c(((C)object3)));
            }
        }
        int v8 = Build.VERSION.SDK_INT;
        if(v8 >= 29) {
            f.b(((Notification.Builder)i0.b), this.F);
            f.c(((Notification.Builder)i0.b));
        }
        if(v8 >= 0x1F) {
            int v9 = this.E;
            if(v9 != 0) {
                u.b(((Notification.Builder)i0.b), v9);
            }
        }
        NotificationCompat.Builder notificationCompat$Builder0 = (NotificationCompat.Builder)i0.c;
        s s2 = notificationCompat$Builder0.m;
        if(s2 != null) {
            s2.a(i0);
        }
        Notification notification1 = ((Notification.Builder)i0.b).build();
        if(s2 != null) {
            notificationCompat$Builder0.m.getClass();
        }
        if(s2 != null) {
            Bundle bundle8 = notification1.extras;
            if(bundle8 != null) {
                if(s2.c) {
                    bundle8.putCharSequence("android.summaryText", s2.b);
                }
                String s3 = s2.b();
                if(s3 != null) {
                    bundle8.putString("androidx.core.app.extra.COMPAT_TEMPLATE", s3);
                }
            }
        }
        return notification1;
    }

    public static CharSequence b(CharSequence charSequence0) [...] // Inlined contents

    public final void c(CharSequence charSequence0) {
        this.f = NotificationCompat.Builder.b(charSequence0);
    }

    public final void d(CharSequence charSequence0) {
        this.e = NotificationCompat.Builder.b(charSequence0);
    }

    public final void e(int v, boolean z) {
        Notification notification0 = this.G;
        if(z) {
            notification0.flags |= v;
            return;
        }
        notification0.flags &= ~v;
    }

    public final void f(Bitmap bitmap0) {
        IconCompat iconCompat0;
        if(bitmap0 == null) {
            iconCompat0 = null;
        }
        else {
            if(Build.VERSION.SDK_INT < 27) {
                Resources resources0 = this.a.getResources();
                int v = resources0.getDimensionPixelSize(0x7F0700AB);  // dimen:compat_notification_large_icon_max_width
                int v1 = resources0.getDimensionPixelSize(0x7F0700AA);  // dimen:compat_notification_large_icon_max_height
                if(bitmap0.getWidth() > v || bitmap0.getHeight() > v1) {
                    double f = Math.min(((double)v) / ((double)Math.max(1, bitmap0.getWidth())), ((double)v1) / ((double)Math.max(1, bitmap0.getHeight())));
                    bitmap0 = Bitmap.createScaledBitmap(bitmap0, ((int)Math.ceil(((double)bitmap0.getWidth()) * f)), ((int)Math.ceil(((double)bitmap0.getHeight()) * f)), true);
                }
            }
            bitmap0.getClass();
            IconCompat iconCompat1 = new IconCompat(1);
            iconCompat1.b = bitmap0;
            iconCompat0 = iconCompat1;
        }
        this.h = iconCompat0;
    }

    public final void g(s s0) {
        if(this.m != s0) {
            this.m = s0;
            if(s0 != null && s0.a != this) {
                s0.a = this;
                this.g(s0);
            }
        }
    }

    public final void h(CharSequence charSequence0) {
        this.G.tickerText = NotificationCompat.Builder.b(charSequence0);
    }
}

