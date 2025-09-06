package W5;

import I6.V;
import I6.p0;
import M6.B;
import M6.s;
import M6.u;
import Q5.j;
import Y5.b;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.session.M0;
import androidx.media3.session.N0;
import androidx.media3.session.O;
import androidx.media3.session.Q;
import androidx.media3.session.c0;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.m;
import androidx.media3.session.q;
import androidx.media3.session.w0;
import androidx.media3.session.y1;
import b3.E;
import b3.g;
import com.android.volley.Response.Listener;
import com.facebook.CallbackManager;
import com.facebook.internal.DialogPresenter;
import com.iloen.melon.adapters.PopupTextListAdapter.OnAddPositionSetListener;
import com.iloen.melon.adapters.PopupTextListAdapter;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.fragments.musicmessage.MusicMessageBlockListFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageListFragment;
import com.iloen.melon.fragments.news.FeedLogsListFragment;
import com.iloen.melon.net.v4x.response.MusicMessageDeleteMusicMsgInboxRes;
import com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v6x.response.FeedLogsListRes.FEEDLOGLIST;
import com.iloen.melon.net.v6x.response.FeedLogsListRes;
import com.iloen.melon.net.v6x.response.MusicMessageDeleteBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST;
import com.iloen.melon.utils.MelonSettingInfo;
import e.a;
import java.util.List;
import kotlin.jvm.internal.H;
import n8.o;

public final class e implements b, M0, O, Listener, OnAddPositionSetListener, a {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;

    public e(Object object0, int v, Object object1, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        this.d = object1;
        super();
    }

    public e(Object object0, Object object1, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        super();
    }

    @Override  // androidx.media3.session.O
    public void d(m m0, int v) {
        if(this.a != 1) {
            E e0 = (E)this.d;
            c0 c00 = ((Q)this.c).c;
            y1 y10 = ((Q)this.c).k;
            y10.getClass();
            int v1 = y10.a.c();
            int v2 = this.b;
            if(v1 >= 2) {
                m0.I(c00, v, v2, e0.d(true));
                return;
            }
            m0.M(c00, v, v2 + 1, e0.d(true));
            m0.A(c00, v, v2);
            return;
        }
        List list0 = (List)this.d;
        c0 c01 = ((Q)this.c).c;
        I6.Q q0 = V.o();
        for(int v3 = 0; v3 < list0.size(); ++v3) {
            q0.a(((E)list0.get(v3)).d(true));
        }
        g g0 = new g(q0.g());
        m0.a0(c01, v, this.b, g0);
    }

    @Override  // Y5.b
    public Object execute() {
        ((h)this.c).d.a(((j)this.d), this.b + 1, false);
        return null;
    }

    @Override  // androidx.media3.session.M0
    public void f(w0 w00) {
        N0 n00 = (N0)this.c;
        MediaDescriptionCompat mediaDescriptionCompat0 = (MediaDescriptionCompat)this.d;
        if(TextUtils.isEmpty(mediaDescriptionCompat0.a)) {
            e3.b.D("MediaSessionLegacyStub", "onAddQueueItem(): Media ID shouldn\'t be empty");
            return;
        }
        p0 p00 = V.t(q.k(mediaDescriptionCompat0));
        B b0 = n00.g.o(w00, p00);
        B7.b b1 = new B7.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b1.c = n00;
        b1.b = w00;
        b1.a = this.b;
        b0.addListener(new u(0, b0, b1), s.a);
    }

    @Override  // com.iloen.melon.adapters.PopupTextListAdapter$OnAddPositionSetListener
    public void g() {
        PopupTextListAdapter popupTextListAdapter0 = (PopupTextListAdapter)this.c;
        o o0 = (o)this.d;
        popupTextListAdapter0.getClass();
        AddPosition addPosition0 = this.b == 8 ? MelonSettingInfo.getNormalPlayListAddPosition() : MelonSettingInfo.getDjPlayListAddPosition();
        if(AddPosition.d == addPosition0) {
            o0.i.setText(0x7F130929);  // string:setting_addposition_after "재생 곡 뒤"
        }
        else if(AddPosition.c == addPosition0) {
            o0.i.setText(0x7F13092A);  // string:setting_addposition_end "맨 끝"
        }
        else {
            o0.i.setText(0x7F13092B);  // string:setting_addposition_first "맨 처음"
        }
        popupTextListAdapter0.notifyDataSetChanged();
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        DialogPresenter.startActivityForResultWithAndroidX$lambda$2(((CallbackManager)this.c), this.b, ((H)this.d), ((Pair)object0));
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 6: {
                MusicMessageBlockListFragment.d0(((MusicMessageBlockListFragment)this.c), ((USERLIST)this.d), this.b, ((MusicMessageDeleteBanUserRes)object0));
                return;
            }
            case 7: {
                MusicMessageListFragment.i0(((MusicMessageListFragment)this.c), ((INBOXLIST)this.d), this.b, ((MusicMessageDeleteMusicMsgInboxRes)object0));
                return;
            }
            default: {
                FeedLogsListFragment.f0(((FeedLogsListFragment)this.c), ((FEEDLOGLIST)this.d), this.b, ((FeedLogsListRes)object0));
            }
        }
    }
}

