package com.iloen.melon.fragments.musicmessage;

import E9.w;
import F8.D;
import F8.E;
import F8.F;
import F8.l;
import Fd.k;
import Tf.v;
import Zc.N;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import androidx.media3.session.H0;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.SearchAndAddActivity;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.searchandadd.SearchAndAddBaseAdapter.MarkedContsInfo;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MusicMessageDeleteMusicMsgInboxContentsReq;
import com.iloen.melon.net.v4x.request.MusicMessageInformInboxSeqReq;
import com.iloen.melon.net.v4x.request.MusicMessageListMusicMsgInboxContentsReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.MusicMessageDeleteMusicMsgInboxContentsRes;
import com.iloen.melon.net.v4x.response.MusicMessageInformInboxSeqRes;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.TARGETMEMBERINFOLIST;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes;
import com.iloen.melon.net.v6x.request.CleanIsBlackReq;
import com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq;
import com.iloen.melon.net.v6x.request.MusicMessageInsertBanUserReq.Params;
import com.iloen.melon.net.v6x.request.MusicMessageInsertBanUserReq;
import com.iloen.melon.net.v6x.request.MusicMessageInsertMusicMsgReq;
import com.iloen.melon.net.v6x.response.CleanIsBlackRes;
import com.iloen.melon.net.v6x.response.MusicMessageDeleteBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertMusicMsgRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.b;
import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.e;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u00FC\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0004\u00C8\u0001\u00CB\u0001\b\u0007\u0018\u0000 \u00D3\u00012\u00020\u0001:\b\u00D3\u0001\u00D4\u0001\u00D5\u0001\u00D6\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\f\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000BJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u00132\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u001B\u0010\u001D\u001A\u0006\u0012\u0002\b\u00030\u001C2\u0006\u0010\u001B\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\"\u0010\u0003J\u000F\u0010#\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b#\u0010\u0003J\u000F\u0010%\u001A\u00020$H\u0016\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020$H\u0016\u00A2\u0006\u0004\b-\u0010&J\'\u00103\u001A\u00020$2\u0006\u0010/\u001A\u00020.2\u0006\u00101\u001A\u0002002\u0006\u00102\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b3\u00104J\r\u00105\u001A\u00020\t\u00A2\u0006\u0004\b5\u0010\u0003J\u001B\u00109\u001A\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u000106\u00A2\u0006\u0004\b9\u0010:J\u0015\u0010<\u001A\u00020$2\u0006\u0010;\u001A\u00020$\u00A2\u0006\u0004\b<\u0010=J\u0015\u0010?\u001A\u00020\t2\u0006\u0010>\u001A\u00020\'\u00A2\u0006\u0004\b?\u0010@J%\u0010E\u001A\u00020\t2\u0006\u0010B\u001A\u00020A2\u0006\u0010C\u001A\u00020A2\u0006\u0010D\u001A\u000207\u00A2\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001A\u00020\t2\u0006\u0010/\u001A\u00020.H\u0002\u00A2\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001A\u00020\t2\b\u0010/\u001A\u0004\u0018\u00010.H\u0002\u00A2\u0006\u0004\bI\u0010HJ\u000F\u0010J\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bJ\u0010\u0003J\u0017\u0010L\u001A\u00020\t2\u0006\u0010K\u001A\u00020$H\u0002\u00A2\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001A\u00020$2\u0006\u0010N\u001A\u00020$H\u0002\u00A2\u0006\u0004\bO\u0010=J\u0017\u0010Q\u001A\u00020\t2\u0006\u0010P\u001A\u00020$H\u0002\u00A2\u0006\u0004\bQ\u0010MJ!\u0010T\u001A\u00020\t2\u0006\u0010/\u001A\u00020\'2\b\u0010S\u001A\u0004\u0018\u00010RH\u0002\u00A2\u0006\u0004\bT\u0010UJ\u000F\u0010V\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bV\u0010\u0003J\u0019\u0010W\u001A\u00020\t2\b\u0010S\u001A\u0004\u0018\u00010RH\u0002\u00A2\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001A\u00020\t2\u0006\u0010Z\u001A\u00020YH\u0002\u00A2\u0006\u0004\b[\u0010\\J\u000F\u0010]\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b]\u0010\u0003J\u000F\u0010^\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b^\u0010\u0003R6\u0010b\u001A\u0016\u0012\u0004\u0012\u00020`\u0018\u00010_j\n\u0012\u0004\u0012\u00020`\u0018\u0001`a8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bb\u0010c\u001A\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010h\u001A\u0004\u0018\u00010\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bh\u0010i\u001A\u0004\bj\u0010)\"\u0004\bk\u0010@R\"\u0010l\u001A\u00020\'8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bl\u0010i\u001A\u0004\bm\u0010)\"\u0004\bn\u0010@R\"\u0010o\u001A\u00020$8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bo\u0010p\u001A\u0004\bq\u0010&\"\u0004\br\u0010MR\"\u0010s\u001A\u00020\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bs\u0010i\u001A\u0004\bt\u0010)\"\u0004\bu\u0010@R\"\u0010v\u001A\u00020\'8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\bv\u0010i\u001A\u0004\bw\u0010)\"\u0004\bx\u0010@R\"\u0010y\u001A\u00020$8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\by\u0010p\u001A\u0004\bz\u0010&\"\u0004\b{\u0010MR$\u0010|\u001A\u0004\u0018\u00010\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b|\u0010i\u001A\u0004\b}\u0010)\"\u0004\b~\u0010@R$\u0010\u007F\u001A\u00020$8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0014\n\u0004\b\u007F\u0010p\u001A\u0005\b\u0080\u0001\u0010&\"\u0005\b\u0081\u0001\u0010MR)\u0010\u0082\u0001\u001A\u00020A8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001A\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R&\u0010\u0088\u0001\u001A\u00020$8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0015\n\u0005\b\u0088\u0001\u0010p\u001A\u0005\b\u0089\u0001\u0010&\"\u0005\b\u008A\u0001\u0010MR\u0019\u0010\u008B\u0001\u001A\u00020\u00138\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u008B\u0001\u0010\u008C\u0001R\u0019\u0010\u008D\u0001\u001A\u00020\u00138\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008C\u0001R*\u0010\u008F\u0001\u001A\u00030\u008E\u00018\u0006@\u0006X\u0086.\u00A2\u0006\u0018\n\u0006\b\u008F\u0001\u0010\u0090\u0001\u001A\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R)\u0010\u0095\u0001\u001A\u00020\u00138\u0006@\u0006X\u0086.\u00A2\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u008C\u0001\u001A\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R*\u0010\u009B\u0001\u001A\u00030\u009A\u00018\u0006@\u0006X\u0086.\u00A2\u0006\u0018\n\u0006\b\u009B\u0001\u0010\u009C\u0001\u001A\u0006\b\u009D\u0001\u0010\u009E\u0001\"\u0006\b\u009F\u0001\u0010\u00A0\u0001R*\u0010\u00A2\u0001\u001A\u00030\u00A1\u00018\u0006@\u0006X\u0086.\u00A2\u0006\u0018\n\u0006\b\u00A2\u0001\u0010\u00A3\u0001\u001A\u0006\b\u00A4\u0001\u0010\u00A5\u0001\"\u0006\b\u00A6\u0001\u0010\u00A7\u0001R,\u0010\u00A9\u0001\u001A\u0005\u0018\u00010\u00A8\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00A9\u0001\u0010\u00AA\u0001\u001A\u0006\b\u00AB\u0001\u0010\u00AC\u0001\"\u0006\b\u00AD\u0001\u0010\u00AE\u0001R+\u0010\u00AF\u0001\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00AF\u0001\u0010\u008C\u0001\u001A\u0006\b\u00B0\u0001\u0010\u0097\u0001\"\u0006\b\u00B1\u0001\u0010\u0099\u0001R+\u0010\u00B2\u0001\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00B2\u0001\u0010\u008C\u0001\u001A\u0006\b\u00B3\u0001\u0010\u0097\u0001\"\u0006\b\u00B4\u0001\u0010\u0099\u0001R,\u0010\u00B6\u0001\u001A\u0005\u0018\u00010\u00B5\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00B6\u0001\u0010\u00B7\u0001\u001A\u0006\b\u00B8\u0001\u0010\u00B9\u0001\"\u0006\b\u00BA\u0001\u0010\u00BB\u0001R*\u0010\u00BD\u0001\u001A\u00030\u00BC\u00018\u0006@\u0006X\u0086.\u00A2\u0006\u0018\n\u0006\b\u00BD\u0001\u0010\u00BE\u0001\u001A\u0006\b\u00BF\u0001\u0010\u00C0\u0001\"\u0006\b\u00C1\u0001\u0010\u00C2\u0001R)\u0010\u00C6\u0001\u001A\u0014\u0012\u000F\u0012\r \u00C5\u0001*\u0005\u0018\u00010\u00C4\u00010\u00C4\u00010\u00C3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C6\u0001\u0010\u00C7\u0001R\u0018\u0010\u00C9\u0001\u001A\u00030\u00C8\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C9\u0001\u0010\u00CA\u0001R\u0018\u0010\u00CC\u0001\u001A\u00030\u00CB\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00CC\u0001\u0010\u00CD\u0001R\u001D\u0010\u00CF\u0001\u001A\u00030\u00CE\u00018\u0006\u00A2\u0006\u0010\n\u0006\b\u00CF\u0001\u0010\u00D0\u0001\u001A\u0006\b\u00D1\u0001\u0010\u00D2\u0001\u00A8\u0006\u00D7\u0001"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "onResume", "onPause", "", "onBackPressed", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "shouldShowMiniPlayer", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "clearData", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;", "Landroidx/recyclerview/widget/O0;", "getMelonArrayAdapter", "()Lcom/iloen/melon/adapters/common/p;", "isEditMode", "switchFooterEditMode", "(Z)Z", "seq", "reportServer", "(Ljava/lang/String;)V", "", "adapterposition", "dataposition", "item", "deleteItem", "(IILcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;)V", "executeMusicMessageListMusicMsgInboxContentsReq", "(Lv9/i;)V", "updateTopAndBottom", "setTitleBar", "show", "showUserInfoView", "(Z)V", "isAttachMode", "switchFooterAttachMode", "isBlockMode", "switchFooterBlockMode", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseAdapter$MarkedContsInfo;", "list", "requestClean", "(Ljava/lang/String;Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseAdapter$MarkedContsInfo;)V", "insertText", "insertContent", "(Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseAdapter$MarkedContsInfo;)V", "Lcom/iloen/melon/net/v6x/request/MusicMessageInsertMusicMsgBaseReq$Params;", "params", "executeMusicMessageInsertMusicMsgReq", "(Lcom/iloen/melon/net/v6x/request/MusicMessageInsertMusicMsgBaseReq$Params;)V", "blockUser", "unblockUser", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/ToReceiverView$Receiver;", "Lkotlin/collections/ArrayList;", "mReceiverList", "Ljava/util/ArrayList;", "getMReceiverList", "()Ljava/util/ArrayList;", "setMReceiverList", "(Ljava/util/ArrayList;)V", "mInboxSeq", "Ljava/lang/String;", "getMInboxSeq", "setMInboxSeq", "mGroupYn", "getMGroupYn", "setMGroupYn", "mHasMore", "Z", "getMHasMore", "setMHasMore", "mNextTimeStamp", "getMNextTimeStamp", "setMNextTimeStamp", "mListCacheKey", "getMListCacheKey", "setMListCacheKey", "mIsBlocked", "getMIsBlocked", "setMIsBlocked", "mTargetMemberkey", "getMTargetMemberkey", "setMTargetMemberkey", "mIsQuit", "getMIsQuit", "setMIsQuit", "mTextMaxLength", "I", "getMTextMaxLength", "()I", "setMTextMaxLength", "(I)V", "mIsClosing", "getMIsClosing", "setMIsClosing", "mHeaderContainer", "Landroid/view/View;", "mFooterContainer", "Landroid/widget/GridView;", "mGvMemberView", "Landroid/widget/GridView;", "getMGvMemberView", "()Landroid/widget/GridView;", "setMGvMemberView", "(Landroid/widget/GridView;)V", "mAttachBtnsContainer", "getMAttachBtnsContainer", "()Landroid/view/View;", "setMAttachBtnsContainer", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "mTitleNickname", "Landroid/widget/TextView;", "getMTitleNickname", "()Landroid/widget/TextView;", "setMTitleNickname", "(Landroid/widget/TextView;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMLinearLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setMLinearLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "Landroid/widget/EditText;", "mEdtMessage", "Landroid/widget/EditText;", "getMEdtMessage", "()Landroid/widget/EditText;", "setMEdtMessage", "(Landroid/widget/EditText;)V", "mBtnAttach", "getMBtnAttach", "setMBtnAttach", "mBtnSendText", "getMBtnSendText", "setMBtnSendText", "Landroid/widget/ToggleButton;", "mTitleBtnBlock", "Landroid/widget/ToggleButton;", "getMTitleBtnBlock", "()Landroid/widget/ToggleButton;", "setMTitleBtnBlock", "(Landroid/widget/ToggleButton;)V", "LF8/F;", "editButton", "LF8/F;", "getEditButton", "()LF8/F;", "setEditButton", "(LF8/F;)V", "Le/b;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "searchActivityResult", "Le/b;", "com/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$mBroadcastReceiver$1", "mBroadcastReceiver", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$mBroadcastReceiver$1;", "com/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$mTextEditorWatcher$1", "mTextEditorWatcher", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$mTextEditorWatcher$1;", "Landroidx/recyclerview/widget/A0;", "mOnScrollListener", "Landroidx/recyclerview/widget/A0;", "getMOnScrollListener", "()Landroidx/recyclerview/widget/A0;", "Companion", "MusicMessageEditorAdapter", "MemberGridAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicMessageEditorFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0014\u001A\u00020\u00152\u001A\u0010\u0016\u001A\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u00052\b\u0010\u001B\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$Companion;", "", "<init>", "()V", "TAG", "", "TYPE_SEND_MESSAGE", "TYPE_RECEIVE_MESSAGE", "NONE_INBOX_SEQ", "thumbCircleDiameter", "", "ARG_MUSIC_MESSAGE_RECEIVER_LIST", "ARG_MUSIC_MESSAGE_INBOX_SEQ", "ARG_MUSIC_MESSAGE_GROUPYN", "ROW_COUNT", "MAX_CONTENTS_COUNT", "REQUEST_CODE_FOR_SELECT_CONTENTS", "MAX_MESSAGE_STRING_LENGTH", "TYPE_TEXT", "TYPE_CONTENT", "newInstance", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;", "receivers", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/ToReceiverView$Receiver;", "Lkotlin/collections/ArrayList;", "inboxSeq", "groupYn", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MusicMessageEditorFragment newInstance(@Nullable ArrayList arrayList0, @Nullable String s, @Nullable String s1) {
            MusicMessageEditorFragment musicMessageEditorFragment0 = new MusicMessageEditorFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", u.v(((e0)o.a()).j()));
            bundle0.putParcelableArrayList("musicMessageReceiverList", arrayList0);
            bundle0.putString("musicMessageInBoxSeq", s);
            bundle0.putString("musicMessageGroupYn", s1);
            bundle0.putBoolean("argIsLoginRequired", true);
            musicMessageEditorFragment0.setArguments(bundle0);
            return musicMessageEditorFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0012\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0007\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0017\u001A\u00020\u00162\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$MemberGridAdapter;", "Landroid/widget/BaseAdapter;", "<init>", "(Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;)V", "", "getCount", "()I", "position", "", "getItem", "(I)Ljava/lang/Object;", "", "getItemId", "(I)J", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "viewGroup", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "newView", "()Landroid/view/View;", "Lie/H;", "bindView", "(Landroid/view/View;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MemberGridAdapter extends BaseAdapter {
        // 检测为 Lambda 实现
        public static void a(ArrayList arrayList0, int v, boolean z, View view0) [...]

        public final void bindView(@Nullable View view0, int v) {
            Object object0 = view0 == null ? null : view0.getTag();
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.ViewHolder");
            ArrayList arrayList0 = MusicMessageEditorFragment.this.getMReceiverList();
            if(arrayList0 != null) {
                boolean z = ProtocolUtils.parseBoolean(((Receiver)arrayList0.get(v)).e);
                Glide.with(((ViewHolder)object0).getIvThumbCircle().getContext()).load(((Receiver)arrayList0.get(v)).d).apply(RequestOptions.circleCropTransform()).into(((ViewHolder)object0).getIvThumbCircle());
                String s = MusicMessageEditorFragment.this.getString(0x7F130C7C);  // string:talkback_user_thumbnail "%s 회원 이미지"
                q.f(s, "getString(...)");
                String s1 = String.format(s, Arrays.copyOf(new Object[]{((Receiver)arrayList0.get(v)).c}, 1));
                if(s1.length() > 0) {
                    ((ViewHolder)object0).getIvThumbCircle().setContentDescription(s1);
                }
                ((ViewHolder)object0).getTvNickname().setText(((Receiver)arrayList0.get(v)).c);
                if(z) {
                    ((ViewHolder)object0).getTvNickname().setTextColor(ColorUtils.getColorStateList(((ViewHolder)object0).getTvNickname().getContext(), 0x7F06015D));  // color:gray500s_support_high_contrast
                }
                else {
                    ((ViewHolder)object0).getTvNickname().setTextColor(ColorUtils.getColorStateList(((ViewHolder)object0).getTvNickname().getContext(), 0x7F060169));  // color:gray850s
                }
                ViewUtils.setOnClickListener(((ViewHolder)object0).getMemberContainer(), (View view0) -> MemberGridAdapter.bindView$lambda$3$lambda$2(arrayList0, v, z, view0));
            }
        }

        private static final void bindView$lambda$3$lambda$2(ArrayList arrayList0, int v, boolean z, View view0) {
            Navigator.openUserMain(((Receiver)arrayList0.get(v)).a, z);
        }

        @Override  // android.widget.Adapter
        public int getCount() {
            ArrayList arrayList0 = MusicMessageEditorFragment.this.getMReceiverList();
            return arrayList0 == null ? 0 : arrayList0.size();
        }

        @Override  // android.widget.Adapter
        @Nullable
        public Object getItem(int v) {
            ArrayList arrayList0 = MusicMessageEditorFragment.this.getMReceiverList();
            return arrayList0 != null ? ((Receiver)arrayList0.get(v)) : null;
        }

        @Override  // android.widget.Adapter
        public long getItemId(int v) {
            return (long)v;
        }

        @Override  // android.widget.Adapter
        @Nullable
        public View getView(int v, @Nullable View view0, @NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "viewGroup");
            if(view0 == null) {
                view0 = this.newView();
            }
            if(view0 != null) {
                this.bindView(view0, v);
            }
            return view0;
        }

        @Nullable
        public final View newView() {
            View view0 = LayoutInflater.from(MusicMessageEditorFragment.this.getContext()).inflate(0x7F0D0554, null);  // layout:musicmessage_editor_header_item
            ViewHolder musicMessageEditorFragment$ViewHolder0 = new ViewHolder();
            View view1 = view0.findViewById(0x7F0A07F7);  // id:member_container
            q.f(view1, "findViewById(...)");
            musicMessageEditorFragment$ViewHolder0.setMemberContainer(view1);
            View view2 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
            q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
            musicMessageEditorFragment$ViewHolder0.setIvThumbCircleDefault(((ImageView)view2));
            View view3 = view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
            q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
            musicMessageEditorFragment$ViewHolder0.setIvThumbCircle(((ImageView)view3));
            View view4 = view0.findViewById(0x7F0A0CCD);  // id:tv_nickname
            q.e(view4, "null cannot be cast to non-null type android.widget.TextView");
            musicMessageEditorFragment$ViewHolder0.setTvNickname(((TextView)view4));
            ViewUtils.setDefaultImage(musicMessageEditorFragment$ViewHolder0.getIvThumbCircleDefault(), MusicMessageEditorFragment.thumbCircleDiameter, true);
            view0.setTag(musicMessageEditorFragment$ViewHolder0);
            return view0;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001A\u00020\u00172\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u000E\u001A\u00020\n¢\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u000E\u001A\u00020\n¢\u0006\u0004\b\u001D\u0010\u001CR\u001A\u0010\u001E\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010\fR\u001A\u0010!\u001A\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b!\u0010\u001F\u001A\u0004\b\"\u0010\f¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$MusicMessageEditorAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;II)V", "", "isSamePerson", "(I)Z", "isSameDate", "VIEW_TYPE_ME", "I", "getVIEW_TYPE_ME", "VIEW_TYPE_YOU", "getVIEW_TYPE_YOU", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class MusicMessageEditorAdapter extends p {
        private final int VIEW_TYPE_ME;
        private final int VIEW_TYPE_YOU;

        public MusicMessageEditorAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MusicMessageEditorFragment.this = musicMessageEditorFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ME = 1;
            this.VIEW_TYPE_YOU = 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            q.f(object0, "getItem(...)");
            return "S".equalsIgnoreCase(((CONTENTSLIST)object0).trnsmtye) ? this.VIEW_TYPE_ME : this.VIEW_TYPE_YOU;
        }

        public final int getVIEW_TYPE_ME() {
            return this.VIEW_TYPE_ME;
        }

        public final int getVIEW_TYPE_YOU() {
            return this.VIEW_TYPE_YOU;
        }

        public final boolean isSameDate(int v) {
            if(this.getItem(v) == null) {
                return false;
            }
            if(v > 0) {
                String s = ((CONTENTSLIST)this.getItem(v)).regdateformat;
                String s1 = ((CONTENTSLIST)this.getItem(v - 1)).regdateformat;
                return s != null && s1 != null && s.equalsIgnoreCase(s1);
            }
            return MusicMessageEditorFragment.this.getMHasMore();
        }

        // 去混淆评级： 低(20)
        public final boolean isSamePerson(int v) {
            return this.getItem(v) == null ? false : v > 0 && v.j0(((CONTENTSLIST)this.getItem(v)).trnsmtye, ((CONTENTSLIST)this.getItem(v - 1)).trnsmtye, true);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            this.onBindViewImpl(((MusicMessageBaseViewHolder)o00), v, v1);
        }

        public void onBindViewImpl(@NotNull MusicMessageBaseViewHolder musicMessageBaseViewHolder0, int v, int v1) {
            q.g(musicMessageBaseViewHolder0, "viewHolder");
            Object object0 = this.getItem(v1);
            q.f(object0, "getItem(...)");
            musicMessageBaseViewHolder0.bindView(((CONTENTSLIST)object0), v, v1);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolderImpl(viewGroup0, v);
        }

        @Nullable
        public MusicMessageBaseViewHolder onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_ME) {
                View view0 = this.mInflater.inflate(0x7F0D055D, viewGroup0, false);  // layout:musicmessage_editor_list_item_me
                q.f(view0, "inflate(...)");
                return new MusicMessageEditorMeViewHolder(view0, MusicMessageEditorFragment.this);
            }
            if(v == this.VIEW_TYPE_YOU) {
                View view1 = this.mInflater.inflate(0x7F0D055E, viewGroup0, false);  // layout:musicmessage_editor_list_item_you
                q.f(view1, "inflate(...)");
                return new MusicMessageEditorYouViewHolder(view1, MusicMessageEditorFragment.this);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u000BX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001A\u0010\u0013\u001A\u00020\u0014X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$ViewHolder;", "", "<init>", "()V", "memberContainer", "Landroid/view/View;", "getMemberContainer", "()Landroid/view/View;", "setMemberContainer", "(Landroid/view/View;)V", "ivThumbCircleDefault", "Landroid/widget/ImageView;", "getIvThumbCircleDefault", "()Landroid/widget/ImageView;", "setIvThumbCircleDefault", "(Landroid/widget/ImageView;)V", "ivThumbCircle", "getIvThumbCircle", "setIvThumbCircle", "tvNickname", "Landroid/widget/TextView;", "getTvNickname", "()Landroid/widget/TextView;", "setTvNickname", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ViewHolder {
        public static final int $stable = 8;
        public ImageView ivThumbCircle;
        public ImageView ivThumbCircleDefault;
        public View memberContainer;
        public TextView tvNickname;

        @NotNull
        public final ImageView getIvThumbCircle() {
            ImageView imageView0 = this.ivThumbCircle;
            if(imageView0 != null) {
                return imageView0;
            }
            q.m("ivThumbCircle");
            throw null;
        }

        @NotNull
        public final ImageView getIvThumbCircleDefault() {
            ImageView imageView0 = this.ivThumbCircleDefault;
            if(imageView0 != null) {
                return imageView0;
            }
            q.m("ivThumbCircleDefault");
            throw null;
        }

        @NotNull
        public final View getMemberContainer() {
            View view0 = this.memberContainer;
            if(view0 != null) {
                return view0;
            }
            q.m("memberContainer");
            throw null;
        }

        @NotNull
        public final TextView getTvNickname() {
            TextView textView0 = this.tvNickname;
            if(textView0 != null) {
                return textView0;
            }
            q.m("tvNickname");
            throw null;
        }

        public final void setIvThumbCircle(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.ivThumbCircle = imageView0;
        }

        public final void setIvThumbCircleDefault(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.ivThumbCircleDefault = imageView0;
        }

        public final void setMemberContainer(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.memberContainer = view0;
        }

        public final void setTvNickname(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.tvNickname = textView0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_MUSIC_MESSAGE_GROUPYN = "musicMessageGroupYn";
    @NotNull
    private static final String ARG_MUSIC_MESSAGE_INBOX_SEQ = "musicMessageInBoxSeq";
    @NotNull
    private static final String ARG_MUSIC_MESSAGE_RECEIVER_LIST = "musicMessageReceiverList";
    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_CONTENTS_COUNT = 10;
    private static final int MAX_MESSAGE_STRING_LENGTH = 1000;
    @NotNull
    public static final String NONE_INBOX_SEQ = "-1";
    private static final int REQUEST_CODE_FOR_SELECT_CONTENTS = 102;
    private static final int ROW_COUNT = 30;
    @NotNull
    public static final String TAG = "MusicMessageEditorFragment";
    @NotNull
    private static final String TYPE_CONTENT = "content";
    @NotNull
    public static final String TYPE_RECEIVE_MESSAGE = "R";
    @NotNull
    public static final String TYPE_SEND_MESSAGE = "S";
    @NotNull
    private static final String TYPE_TEXT = "text";
    public F editButton;
    public View mAttachBtnsContainer;
    @NotNull
    private final com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.mBroadcastReceiver.1 mBroadcastReceiver;
    @Nullable
    private View mBtnAttach;
    @Nullable
    private View mBtnSendText;
    @Nullable
    private EditText mEdtMessage;
    private View mFooterContainer;
    public String mGroupYn;
    public GridView mGvMemberView;
    private boolean mHasMore;
    private View mHeaderContainer;
    @Nullable
    private String mInboxSeq;
    private boolean mIsBlocked;
    private boolean mIsClosing;
    private boolean mIsQuit;
    public LinearLayoutManager mLinearLayoutManager;
    public String mListCacheKey;
    @NotNull
    private String mNextTimeStamp;
    @NotNull
    private final A0 mOnScrollListener;
    @Nullable
    private ArrayList mReceiverList;
    @Nullable
    private String mTargetMemberkey;
    @NotNull
    private final com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.mTextEditorWatcher.1 mTextEditorWatcher;
    private int mTextMaxLength;
    @Nullable
    private ToggleButton mTitleBtnBlock;
    public TextView mTitleNickname;
    @NotNull
    private final b searchActivityResult;
    private static final int thumbCircleDiameter;

    static {
        MusicMessageEditorFragment.Companion = new Companion(null);
        MusicMessageEditorFragment.$stable = 8;
        MelonAppBase.Companion.getClass();
        MusicMessageEditorFragment.thumbCircleDiameter = ScreenUtils.dipToPixel(t.a().getContext(), 35.0f);
    }

    public MusicMessageEditorFragment() {
        this.mNextTimeStamp = "0";
        b b0 = this.registerForActivityResult(new f0(2), new a(this, 0));
        q.f(b0, "registerForActivityResult(...)");
        this.searchActivityResult = b0;
        this.mBroadcastReceiver = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "intent");
                String s = intent0.getAction();
                Y.w("onReceive() action:", s, LogU.Companion, "MusicMessageEditorFragment");
                if("com.iloen.melon.intent.action.music_message".equals(s)) {
                    String s1 = intent0.getStringExtra("com.iloen.melon.intent.action.music_message.inbox_seq");
                    String s2 = intent0.getStringExtra("com.iloen.melon.intent.action.music_message.need_reload");
                    TimeExpiredCache.getInstance().remove(MusicMessageEditorFragment.this.getMListCacheKey());
                    if(ProtocolUtils.parseBoolean(s2) && (MusicMessageEditorFragment.this.getMInboxSeq() == null || !q.b(MusicMessageEditorFragment.this.getMInboxSeq(), s1))) {
                        MusicMessageEditorFragment.this.setMReceiverList(null);
                        MusicMessageEditorFragment.this.setMInboxSeq(s1);
                        MusicMessageEditorFragment.this.setMGroupYn("N");
                    }
                    MusicMessageEditorFragment.access$startFetch(MusicMessageEditorFragment.this);
                }
            }
        };
        this.mTextEditorWatcher = new TextWatcher() {
            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
                q.g(editable0, "s");
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                q.g(charSequence0, "s");
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                q.g(charSequence0, "s");
                View view0 = MusicMessageEditorFragment.this.getMBtnSendText();
                if(view0 != null) {
                    view0.setEnabled(charSequence0.length() > 0);
                }
                if(charSequence0.length() > MusicMessageEditorFragment.this.getMTextMaxLength()) {
                    l0 l00 = MusicMessageEditorFragment.this.getChildFragmentManager();
                    String s = MusicMessageEditorFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                    String s1 = MusicMessageEditorFragment.this.getString(0x7F1300C7);  // string:alert_dlg_music_message_enter_less_than_xxx_letters_confirm "메시지는 한 번에 최대 
                                                                                        // 1000자까지 보내실 수 있습니다."
                    d d0 = new d(MusicMessageEditorFragment.this, 4);
                    com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s, s1, false, false, false, null, null, null, d0, null, 0x5F8);
                }
            }

            private static final H onTextChanged$lambda$0(MusicMessageEditorFragment musicMessageEditorFragment0) {
                EditText editText0 = musicMessageEditorFragment0.getMEdtMessage();
                String s = String.valueOf((editText0 == null ? null : editText0.getText()));
                int v = 0;
                String s1 = s.substring(0, Math.min(s.length(), musicMessageEditorFragment0.getMTextMaxLength()));
                q.f(s1, "substring(...)");
                EditText editText1 = musicMessageEditorFragment0.getMEdtMessage();
                if(editText1 != null) {
                    editText1.setText(s1);
                }
                EditText editText2 = musicMessageEditorFragment0.getMEdtMessage();
                if(editText2 != null) {
                    EditText editText3 = musicMessageEditorFragment0.getMEdtMessage();
                    if(editText3 != null) {
                        Editable editable0 = editText3.getText();
                        if(editable0 != null) {
                            v = editable0.length();
                        }
                    }
                    editText2.setSelection(v);
                }
                return H.a;
            }
        };
        this.mOnScrollListener = new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                q.g(recyclerView0, "recyclerView");
                int v2 = MusicMessageEditorFragment.this.getMLinearLayoutManager().findFirstVisibleItemPosition();
                if(v1 < 0 && MusicMessageEditorFragment.this.getMLinearLayoutManager().getItemCount() > 0 && v2 == 0 && MusicMessageEditorFragment.this.getMHasMore()) {
                    MusicMessageEditorFragment.this.setMHasMore(false);
                    MusicMessageEditorFragment.access$startFetch(MusicMessageEditorFragment.this, i.c, h.b, false, "onLoadMore");
                }
            }
        };
    }

    public static void C0(VolleyError volleyError0) {
        MusicMessageEditorFragment.unblockUser$lambda$48$lambda$47(volleyError0);
    }

    public static final void access$startFetch(MusicMessageEditorFragment musicMessageEditorFragment0) {
        musicMessageEditorFragment0.startFetch();
    }

    public static final void access$startFetch(MusicMessageEditorFragment musicMessageEditorFragment0, i i0, h h0, boolean z, String s) {
        musicMessageEditorFragment0.startFetch(i0, h0, z, s);
    }

    private final void blockUser() {
        Y.w("blockUser mTargetMemberkey: ", this.mTargetMemberkey, LogU.Companion, "MusicMessageEditorFragment");
        if(this.mTargetMemberkey != null && this.mTitleBtnBlock != null) {
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s1 = this.getString(0x7F1300C8);  // string:alert_dlg_music_message_insert_block_user_confirm "%1$s님을 차단하시겠습니까?\n차단된 
                                                     // 사람에게는\n메시지를 보내거나 받을 수 없습니다.\n\n차단 해제는 [프로필> 프로필 설정> 메시지 차단 목록 관리] 및\n[메시지 리스트> 메시지 
                                                     // 레이어]에서 가능합니다."
            q.f(s1, "getString(...)");
            com.melon.ui.popup.b.x(l00, s, String.format(s1, Arrays.copyOf(new Object[]{this.getMTitleNickname().getText()}, 1)), false, false, null, null, new d(this, 0), new d(this, 1), null, null, 0xCF8);
            return;
        }
        ToggleButton toggleButton0 = this.mTitleBtnBlock;
        if(toggleButton0 != null) {
            toggleButton0.setChecked(this.mIsBlocked);
        }
    }

    private static final H blockUser$lambda$43(MusicMessageEditorFragment musicMessageEditorFragment0) {
        Params musicMessageInsertBanUserReq$Params0 = new Params();
        musicMessageInsertBanUserReq$Params0.memberKeyBan = musicMessageEditorFragment0.mTargetMemberkey;
        RequestBuilder.newInstance(new MusicMessageInsertBanUserReq(musicMessageEditorFragment0.getContext(), musicMessageInsertBanUserReq$Params0)).tag("MusicMessageEditorFragment").listener(new a(musicMessageEditorFragment0, 5)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(29)).request();
        return H.a;
    }

    private static final void blockUser$lambda$43$lambda$41(MusicMessageEditorFragment musicMessageEditorFragment0, MusicMessageInsertBanUserRes musicMessageInsertBanUserRes0) {
        if(musicMessageEditorFragment0.isFragmentValid()) {
            if(musicMessageInsertBanUserRes0.isSuccessful()) {
                musicMessageEditorFragment0.switchFooterBlockMode(true);
                return;
            }
            ToggleButton toggleButton0 = musicMessageEditorFragment0.mTitleBtnBlock;
            if(toggleButton0 != null) {
                toggleButton0.setChecked(musicMessageEditorFragment0.mIsBlocked);
            }
        }
    }

    private static final void blockUser$lambda$43$lambda$42(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private static final H blockUser$lambda$44(MusicMessageEditorFragment musicMessageEditorFragment0) {
        ToggleButton toggleButton0 = musicMessageEditorFragment0.mTitleBtnBlock;
        if(toggleButton0 != null) {
            toggleButton0.setChecked(musicMessageEditorFragment0.mIsBlocked);
        }
        return H.a;
    }

    public final void clearData() {
        this.mHasMore = false;
        this.mNextTimeStamp = "0";
        if(this.isAdded()) {
            this.switchFooterBlockMode(false);
        }
        p p0 = this.getMelonArrayAdapter();
        if(p0 != null) {
            p0.clear(false);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new MusicMessageEditorAdapter(this, context0, null);
        ((p)j00).setEmptyViewInfo(e.n);
        v9.o o0 = new v9.o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.c = -1;
        o0.e = -1;
        o0.h = -1;
        o0.i = -1;
        o0.b = 0x7F08093C;  // drawable:transparent
        ((p)j00).setErrorViewInfo(o0);
        return j00;
    }

    public final void deleteItem(int v, int v1, @NotNull CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        int v2;
        q.g(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, "item");
        LogU.Companion.d("MusicMessageEditorFragment", "deleteItem adapterposition: " + v + ", dataposition: " + v1);
        if(!ProtocolUtils.parseBoolean(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.olddatayn)) {
            v2 = 0x7F1300C0;  // string:alert_dlg_delete_music_message_item_confirm "1개의 메시지를 삭제하시겠습니까? 삭제한 메시지는 
                              // 다시 복구할 수 없습니다."
        }
        else if("S".equalsIgnoreCase(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.trnsmtye)) {
            v2 = 0x7F1300C2;  // string:alert_dlg_delete_music_message_item_send_confirm "함께 보낸 메시지를 삭제합니다. 삭제한 메시지는 
                              // 다시 복구할 수 없습니다."
        }
        else if("R".equalsIgnoreCase(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.trnsmtye)) {
            v2 = 0x7F1300C1;  // string:alert_dlg_delete_music_message_item_receive_confirm "함께 받은 메시지를 삭제합니다. 삭제한 
                              // 메시지는 다시 복구할 수 없습니다."
        }
        else {
            v2 = 0x7F1300C0;  // string:alert_dlg_delete_music_message_item_confirm "1개의 메시지를 삭제하시겠습니까? 삭제한 메시지는 
                              // 다시 복구할 수 없습니다."
        }
        com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(v2), false, false, null, null, new N(11, this, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
    }

    private static final H deleteItem$lambda$39(MusicMessageEditorFragment musicMessageEditorFragment0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        com.iloen.melon.net.v4x.request.MusicMessageDeleteMusicMsgInboxContentsReq.Params musicMessageDeleteMusicMsgInboxContentsReq$Params0 = new com.iloen.melon.net.v4x.request.MusicMessageDeleteMusicMsgInboxContentsReq.Params();
        musicMessageDeleteMusicMsgInboxContentsReq$Params0.groupYn = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.groupyn;
        musicMessageDeleteMusicMsgInboxContentsReq$Params0.oldDataYn = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.olddatayn;
        musicMessageDeleteMusicMsgInboxContentsReq$Params0.timeStamp = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.timestamp;
        musicMessageDeleteMusicMsgInboxContentsReq$Params0.trnsmTye = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.trnsmtye;
        musicMessageDeleteMusicMsgInboxContentsReq$Params0.musicMesgSeq = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.musicmesgseq;
        musicMessageDeleteMusicMsgInboxContentsReq$Params0.inboxSeq = musicMessageEditorFragment0.mInboxSeq;
        RequestBuilder.newInstance(new MusicMessageDeleteMusicMsgInboxContentsReq(musicMessageEditorFragment0.getContext(), musicMessageDeleteMusicMsgInboxContentsReq$Params0)).tag("MusicMessageEditorFragment").listener(new H0(11, musicMessageEditorFragment0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(28)).request();
        return H.a;
    }

    private static final void deleteItem$lambda$39$lambda$37(MusicMessageEditorFragment musicMessageEditorFragment0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, MusicMessageDeleteMusicMsgInboxContentsRes musicMessageDeleteMusicMsgInboxContentsRes0) {
        if(musicMessageDeleteMusicMsgInboxContentsRes0.isSuccessful() && musicMessageEditorFragment0.isFragmentValid()) {
            ToastManager.showShort(0x7F130716);  // string:music_message_is_deleted "메시지가 삭제되었습니다."
            ArrayList arrayList0 = new ArrayList();
            p p0 = musicMessageEditorFragment0.getMelonArrayAdapter();
            List list0 = p0 == null ? null : p0.getList();
            q.e(list0, "null cannot be cast to non-null type kotlin.collections.MutableList<com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST>");
            List list1 = kotlin.jvm.internal.N.b(list0);
            for(int v = list1.size() - 1; -1 < v; --v) {
                if(q.b(((CONTENTSLIST)list1.get(v)).musicmesgseq, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.musicmesgseq)) {
                    arrayList0.add(list1.get(v));
                }
            }
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST1 = (CONTENTSLIST)object0;
                p p1 = musicMessageEditorFragment0.getMelonArrayAdapter();
                if(p1 != null) {
                    int v1 = p1.getPosition(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST1);
                    p p2 = musicMessageEditorFragment0.getMelonArrayAdapter();
                    if(p2 != null) {
                        p2.remove(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST1);
                    }
                    p p3 = musicMessageEditorFragment0.getMelonArrayAdapter();
                    if(p3 != null) {
                        p3.notifyItemRemoved(v1);
                    }
                    p p4 = musicMessageEditorFragment0.getMelonArrayAdapter();
                    if(p4 != null) {
                        p p5 = musicMessageEditorFragment0.getMelonArrayAdapter();
                        p4.notifyItemRangeChanged(v1, (p5 == null ? 0 : p5.getCount()));
                    }
                }
            }
            TimeExpiredCache.getInstance().remove(musicMessageEditorFragment0.getMListCacheKey());
        }
    }

    private static final void deleteItem$lambda$39$lambda$38(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public static void e0(MusicMessageEditorFragment musicMessageEditorFragment0, String s, MarkedContsInfo searchAndAddBaseAdapter$MarkedContsInfo0, CleanIsBlackRes cleanIsBlackRes0) {
        MusicMessageEditorFragment.requestClean$lambda$31(musicMessageEditorFragment0, s, searchAndAddBaseAdapter$MarkedContsInfo0, cleanIsBlackRes0);
    }

    private final void executeMusicMessageInsertMusicMsgReq(com.iloen.melon.net.v6x.request.MusicMessageInsertMusicMsgBaseReq.Params musicMessageInsertMusicMsgBaseReq$Params0) {
        RequestBuilder.newInstance(new MusicMessageInsertMusicMsgReq(this.getContext(), musicMessageInsertMusicMsgBaseReq$Params0)).tag("MusicMessageEditorFragment").listener(new a(this, 3)).errorListener(new a(this, 4)).request();
    }

    private static final void executeMusicMessageInsertMusicMsgReq$lambda$33(MusicMessageEditorFragment musicMessageEditorFragment0, MusicMessageInsertMusicMsgRes musicMessageInsertMusicMsgRes0) {
        if(musicMessageInsertMusicMsgRes0.isSuccessful() && musicMessageEditorFragment0.isFragmentValid()) {
            musicMessageEditorFragment0.startFetch();
            EditText editText0 = musicMessageEditorFragment0.mEdtMessage;
            if(editText0 != null) {
                editText0.setText("");
            }
            TimeExpiredCache.getInstance().remove(musicMessageEditorFragment0.getMListCacheKey());
            return;
        }
        if(ProtocolUtils.parseBoolean(musicMessageInsertMusicMsgRes0.response.alltargetbanyn)) {
            musicMessageEditorFragment0.switchFooterBlockMode(true);
            return;
        }
        View view0 = musicMessageEditorFragment0.mBtnSendText;
        if(view0 != null) {
            view0.setEnabled(true);
        }
    }

    private static final void executeMusicMessageInsertMusicMsgReq$lambda$34(MusicMessageEditorFragment musicMessageEditorFragment0, VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        View view0 = musicMessageEditorFragment0.mBtnSendText;
        if(view0 != null) {
            view0.setEnabled(true);
        }
    }

    private final void executeMusicMessageListMusicMsgInboxContentsReq(i i0) {
        if(TextUtils.isEmpty(this.mInboxSeq)) {
            LogU.Companion.w("MusicMessageEditorFragment", "executeMusicMessageListMusicMsgInboxContentsReq() invalid inboxSeq");
            return;
        }
        if(i.b.equals(i0)) {
            this.clearData();
            MelonAppBase.Companion.getClass();
            t.a().setMusicMessageCurrentInboxSeq((this.mInboxSeq == null ? "" : this.mInboxSeq));
        }
        com.iloen.melon.net.v4x.request.MusicMessageListMusicMsgInboxContentsReq.Params musicMessageListMusicMsgInboxContentsReq$Params0 = new com.iloen.melon.net.v4x.request.MusicMessageListMusicMsgInboxContentsReq.Params();
        musicMessageListMusicMsgInboxContentsReq$Params0.inboxSeq = this.mInboxSeq;
        if(!TextUtils.isEmpty(this.getMGroupYn())) {
            musicMessageListMusicMsgInboxContentsReq$Params0.groupYn = this.getMGroupYn();
        }
        musicMessageListMusicMsgInboxContentsReq$Params0.startTimeStamp = this.mNextTimeStamp;
        musicMessageListMusicMsgInboxContentsReq$Params0.pageSize = "30";
        RequestBuilder.newInstance(new MusicMessageListMusicMsgInboxContentsReq(this.getContext(), musicMessageListMusicMsgInboxContentsReq$Params0)).tag("MusicMessageEditorFragment").listener(new com.iloen.melon.fragments.musicmessage.b(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void executeMusicMessageListMusicMsgInboxContentsReq$lambda$26(MusicMessageEditorFragment musicMessageEditorFragment0, i i0, MusicMessageListMusicMsgInboxContentsRes musicMessageListMusicMsgInboxContentsRes0) {
        if(!musicMessageEditorFragment0.prepareFetchComplete(musicMessageListMusicMsgInboxContentsRes0)) {
            return;
        }
        RESPONSE musicMessageListMusicMsgInboxContentsRes$RESPONSE0 = musicMessageListMusicMsgInboxContentsRes0.response;
        if(musicMessageListMusicMsgInboxContentsRes$RESPONSE0 != null && musicMessageListMusicMsgInboxContentsRes$RESPONSE0.contentslist != null) {
            musicMessageEditorFragment0.mHasMore = musicMessageListMusicMsgInboxContentsRes$RESPONSE0.hasMore;
            String s = musicMessageListMusicMsgInboxContentsRes$RESPONSE0.nexttimestamp;
            q.f(s, "nexttimestamp");
            musicMessageEditorFragment0.mNextTimeStamp = s;
            int v = musicMessageListMusicMsgInboxContentsRes0.response.contentslist.size();
            if(musicMessageEditorFragment0.getRecyclerView() != null) {
                musicMessageEditorFragment0.getMLinearLayoutManager().scrollToPositionWithOffset(v, 20);
            }
            if(musicMessageEditorFragment0.mReceiverList == null && v > 0) {
                musicMessageEditorFragment0.mReceiverList = Receiver.a(musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist);
            }
            if(ProtocolUtils.parseBoolean(musicMessageEditorFragment0.getMGroupYn())) {
                ArrayList arrayList0 = musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist;
                if(arrayList0 != null && arrayList0.size() > 0) {
                    Iterator iterator0 = musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist.iterator();
                    q.f(iterator0, "iterator(...)");
                    int v1 = 0;
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        q.f(object0, "next(...)");
                        if(ProtocolUtils.parseBoolean(((TARGETMEMBERINFOLIST)object0).targetbanyn)) {
                            ++v1;
                        }
                    }
                    musicMessageEditorFragment0.mIsBlocked = v1 == musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist.size();
                }
            }
            if(!ProtocolUtils.parseBoolean(musicMessageEditorFragment0.getMGroupYn())) {
                ArrayList arrayList1 = musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist;
                if(arrayList1 != null && arrayList1.size() == 1) {
                    musicMessageEditorFragment0.mIsBlocked = ProtocolUtils.parseBoolean(((TARGETMEMBERINFOLIST)musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist.get(0)).targetbanyn);
                    musicMessageEditorFragment0.mTargetMemberkey = ((TARGETMEMBERINFOLIST)musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist.get(0)).targetmemberkey;
                    musicMessageEditorFragment0.mIsQuit = ProtocolUtils.parseBoolean(((TARGETMEMBERINFOLIST)musicMessageListMusicMsgInboxContentsRes0.response.targetmemberinfolist.get(0)).targetmemberstatus);
                }
            }
            musicMessageEditorFragment0.updateTopAndBottom(i0);
            if(i.b.equals(i0)) {
                p p0 = musicMessageEditorFragment0.getMelonArrayAdapter();
                if(p0 != null) {
                    p0.clear(false);
                }
            }
            if(q.b(i0, i.c)) {
                p p1 = musicMessageEditorFragment0.getMelonArrayAdapter();
                if(p1 != null) {
                    p1.addAll(0, musicMessageListMusicMsgInboxContentsRes0.response.contentslist);
                }
            }
            else {
                p p2 = musicMessageEditorFragment0.getMelonArrayAdapter();
                if(p2 != null) {
                    p2.addAll(musicMessageListMusicMsgInboxContentsRes0.response.contentslist);
                }
            }
            p p3 = musicMessageEditorFragment0.getMelonArrayAdapter();
            if(p3 != null) {
                p3.updateModifiedTime(musicMessageEditorFragment0.getCacheKey());
            }
            musicMessageEditorFragment0.performFetchCompleteOnlyViews();
            return;
        }
        musicMessageEditorFragment0.showProgress(false);
    }

    public static void g0(MusicMessageEditorFragment musicMessageEditorFragment0, VolleyError volleyError0) {
        MusicMessageEditorFragment.executeMusicMessageInsertMusicMsgReq$lambda$34(musicMessageEditorFragment0, volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.G.buildUpon().appendPath("musicMessageDetail"), "userKey", this.mUserKey, "toString(...)");
    }

    @NotNull
    public final F getEditButton() {
        F f0 = this.editButton;
        if(f0 != null) {
            return f0;
        }
        q.m("editButton");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.c;
    }

    @NotNull
    public final View getMAttachBtnsContainer() {
        View view0 = this.mAttachBtnsContainer;
        if(view0 != null) {
            return view0;
        }
        q.m("mAttachBtnsContainer");
        throw null;
    }

    @Nullable
    public final View getMBtnAttach() {
        return this.mBtnAttach;
    }

    @Nullable
    public final View getMBtnSendText() {
        return this.mBtnSendText;
    }

    @Nullable
    public final EditText getMEdtMessage() {
        return this.mEdtMessage;
    }

    @NotNull
    public final String getMGroupYn() {
        String s = this.mGroupYn;
        if(s != null) {
            return s;
        }
        q.m("mGroupYn");
        throw null;
    }

    @NotNull
    public final GridView getMGvMemberView() {
        GridView gridView0 = this.mGvMemberView;
        if(gridView0 != null) {
            return gridView0;
        }
        q.m("mGvMemberView");
        throw null;
    }

    public final boolean getMHasMore() {
        return this.mHasMore;
    }

    @Nullable
    public final String getMInboxSeq() {
        return this.mInboxSeq;
    }

    public final boolean getMIsBlocked() {
        return this.mIsBlocked;
    }

    public final boolean getMIsClosing() {
        return this.mIsClosing;
    }

    public final boolean getMIsQuit() {
        return this.mIsQuit;
    }

    @NotNull
    public final LinearLayoutManager getMLinearLayoutManager() {
        LinearLayoutManager linearLayoutManager0 = this.mLinearLayoutManager;
        if(linearLayoutManager0 != null) {
            return linearLayoutManager0;
        }
        q.m("mLinearLayoutManager");
        throw null;
    }

    @NotNull
    public final String getMListCacheKey() {
        String s = this.mListCacheKey;
        if(s != null) {
            return s;
        }
        q.m("mListCacheKey");
        throw null;
    }

    @NotNull
    public final String getMNextTimeStamp() {
        return this.mNextTimeStamp;
    }

    @NotNull
    public final A0 getMOnScrollListener() {
        return this.mOnScrollListener;
    }

    @Nullable
    public final ArrayList getMReceiverList() {
        return this.mReceiverList;
    }

    @Nullable
    public final String getMTargetMemberkey() {
        return this.mTargetMemberkey;
    }

    public final int getMTextMaxLength() {
        return this.mTextMaxLength;
    }

    @Nullable
    public final ToggleButton getMTitleBtnBlock() {
        return this.mTitleBtnBlock;
    }

    @NotNull
    public final TextView getMTitleNickname() {
        TextView textView0 = this.mTitleNickname;
        if(textView0 != null) {
            return textView0;
        }
        q.m("mTitleNickname");
        throw null;
    }

    @Nullable
    public final p getMelonArrayAdapter() {
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MelonArrayAdapter<com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST, androidx.recyclerview.widget.RecyclerView.ViewHolder>");
        return (p)j00;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "mymusicMusicmessageUpdate");
    }

    public static void h0(MusicMessageEditorFragment musicMessageEditorFragment0, CleanIsBlackRes cleanIsBlackRes0) {
        MusicMessageEditorFragment.onViewCreated$lambda$10$lambda$8(musicMessageEditorFragment0, cleanIsBlackRes0);
    }

    private final void insertContent(MarkedContsInfo searchAndAddBaseAdapter$MarkedContsInfo0) {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("MusicMessageEditorFragment", "insertContent");
        ArrayList arrayList0 = this.mReceiverList;
        if(arrayList0 == null) {
            logU$Companion0.w("MusicMessageEditorFragment", "mReceiverList is null.");
            return;
        }
        if(searchAndAddBaseAdapter$MarkedContsInfo0 == null) {
            logU$Companion0.w("MusicMessageEditorFragment", "MarkedContsInfo is null.");
            return;
        }
        com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
        if(arrayList0.size() == 0) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13087E), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            return;
        }
        if(Receiver.e(this.mReceiverList)) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130472), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            return;
        }
        this.requestClean("content", searchAndAddBaseAdapter$MarkedContsInfo0);
    }

    private final void insertText() {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("MusicMessageEditorFragment", "insertText");
        if(this.mReceiverList == null) {
            logU$Companion0.w("MusicMessageEditorFragment", "mReceiverList is null.");
            return;
        }
        boolean z = ViewUtils.hasStringEditText(this.mEdtMessage);
        com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
        if(!z) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13078D), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            logU$Companion0.w("MusicMessageEditorFragment", "text is empty.");
            return;
        }
        if((this.mReceiverList == null ? 0 : this.mReceiverList.size()) == 0) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13087E), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            return;
        }
        if(Receiver.e(this.mReceiverList)) {
            com.melon.ui.popup.b.d(b0, this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130472), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
            return;
        }
        this.requestClean("text", null);
    }

    public static void j0(MusicMessageEditorFragment musicMessageEditorFragment0, MusicMessageDeleteBanUserRes musicMessageDeleteBanUserRes0) {
        MusicMessageEditorFragment.unblockUser$lambda$48$lambda$46(musicMessageEditorFragment0, musicMessageDeleteBanUserRes0);
    }

    public static void k0(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        MusicMessageEditorFragment.setTitleBar$lambda$27(musicMessageEditorFragment0, view0);
    }

    public static void l0(MusicMessageEditorFragment musicMessageEditorFragment0, i i0, MusicMessageListMusicMsgInboxContentsRes musicMessageListMusicMsgInboxContentsRes0) {
        MusicMessageEditorFragment.executeMusicMessageListMusicMsgInboxContentsReq$lambda$26(musicMessageEditorFragment0, i0, musicMessageListMusicMsgInboxContentsRes0);
    }

    public static void m0(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        MusicMessageEditorFragment.onViewCreated$lambda$18(musicMessageEditorFragment0, view0);
    }

    public static void n0(VolleyError volleyError0) {
        MusicMessageEditorFragment.blockUser$lambda$43$lambda$42(volleyError0);
    }

    @NotNull
    public static final MusicMessageEditorFragment newInstance(@Nullable ArrayList arrayList0, @Nullable String s, @Nullable String s1) {
        return MusicMessageEditorFragment.Companion.newInstance(arrayList0, s, s1);
    }

    public static void o0(VolleyError volleyError0) {
        MusicMessageEditorFragment.onViewCreated$lambda$10$lambda$9(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        if(!this.mIsClosing) {
            p p0 = this.getMelonArrayAdapter();
            if(p0 != null && p0.isInEditMode() && this.getTitleBar() != null) {
                ToggleButton toggleButton0 = this.getEditButton().g;
                if(toggleButton0 != null) {
                    toggleButton0.setChecked(false);
                    return true;
                }
                q.m("toggleEditButton");
                throw null;
            }
            return this.getMAttachBtnsContainer().getVisibility() == 0 ? this.switchFooterAttachMode(false) : super.onBackPressed();
        }
        return super.onBackPressed();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        LogU.Companion.d("MusicMessageEditorFragment", "onCreate()");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.setMLinearLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(this.getMLinearLayoutManager());
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).addOnScrollListener(this.mOnScrollListener);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02BA, viewGroup0, false);  // layout:fragment_musicmessage_editor_list
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        Y.a(MelonAppBase.Companion).unregisterReceiver(this.mBroadcastReceiver);
        t.a().setMusicMessageCurrentInboxSeq("");
        super.onDestroy();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        LogU.Companion.d("MusicMessageEditorFragment", "onFetchStart reason: " + s);
        if(!TextUtils.isEmpty(this.mInboxSeq) && !"-1".equals(this.mInboxSeq)) {
            this.executeMusicMessageListMusicMsgInboxContentsReq(i0);
            return true;
        }
        com.iloen.melon.net.v4x.request.MusicMessageInformInboxSeqReq.Params musicMessageInformInboxSeqReq$Params0 = new com.iloen.melon.net.v4x.request.MusicMessageInformInboxSeqReq.Params();
        musicMessageInformInboxSeqReq$Params0.targetMemberkeys = Receiver.b(this.mReceiverList);
        RequestBuilder.newInstance(new MusicMessageInformInboxSeqReq(this.getContext(), musicMessageInformInboxSeqReq$Params0)).tag("MusicMessageEditorFragment").listener(new com.iloen.melon.fragments.musicmessage.b(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$24(MusicMessageEditorFragment musicMessageEditorFragment0, i i0, MusicMessageInformInboxSeqRes musicMessageInformInboxSeqRes0) {
        if(musicMessageInformInboxSeqRes0.isSuccessful() && musicMessageEditorFragment0.isFragmentValid()) {
            musicMessageEditorFragment0.performLogging(musicMessageInformInboxSeqRes0);
            musicMessageEditorFragment0.mInboxSeq = musicMessageInformInboxSeqRes0.response.inboxseq;
            String s = musicMessageInformInboxSeqRes0.response.groupyn;
            q.f(s, "groupyn");
            musicMessageEditorFragment0.setMGroupYn(s);
            musicMessageEditorFragment0.mIsBlocked = ProtocolUtils.parseBoolean(musicMessageInformInboxSeqRes0.response.alltargetbanyn);
            String s1 = musicMessageEditorFragment0.mInboxSeq;
            String s2 = musicMessageEditorFragment0.getMGroupYn();
            boolean z = musicMessageEditorFragment0.mIsBlocked;
            StringBuilder stringBuilder0 = A7.d.o("Get prerequisite data! InboxSeq: ", s1, ", GroupYn: ", s2, ", mIsBlocked ");
            stringBuilder0.append(z);
            LogU.Companion.d("MusicMessageEditorFragment", stringBuilder0.toString());
            if(TextUtils.isEmpty(musicMessageEditorFragment0.mInboxSeq)) {
                musicMessageEditorFragment0.updateTopAndBottom(i0);
                musicMessageEditorFragment0.performFetchCompleteOnlyViews();
                return;
            }
            musicMessageEditorFragment0.executeMusicMessageListMusicMsgInboxContentsReq(i0);
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
        if(this.mEdtMessage != null) {
            InputMethodUtils.hideInputMethod(this.getContext(), this.mEdtMessage);
        }
        MelonAppBase.Companion.getClass();
        t.a().setMusicMsgFragmentVisualStatus(false, t.a().isMusicMessageTopStack());
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "savedInstanceState");
        this.mReceiverList = bundle0.getParcelableArrayList("musicMessageReceiverList");
        this.mInboxSeq = bundle0.getString("musicMessageInBoxSeq");
        String s = "";
        String s1 = bundle0.getString("musicMessageGroupYn", "");
        q.f(s1, "getString(...)");
        this.setMGroupYn(s1);
        MelonAppBase.Companion.getClass();
        MelonAppBase melonAppBase0 = t.a();
        String s2 = this.mInboxSeq;
        if(s2 != null) {
            s = s2;
        }
        melonAppBase0.setMusicMessageCurrentInboxSeq(s);
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.iloen.melon.intent.action.music_message");
        w.S(t.a().getContext(), this.mBroadcastReceiver, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION");
        this.mTextMaxLength = 1000;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        MelonAppBase.Companion.getClass();
        t.a().setMusicMsgFragmentVisualStatus(true, t.a().isMusicMessageTopStack());
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putParcelableArrayList("musicMessageReceiverList", this.mReceiverList);
        bundle0.putString("musicMessageInBoxSeq", this.mInboxSeq);
        bundle0.putString("musicMessageGroupYn", this.getMGroupYn());
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        if(this.getTitleBar() != null) {
            this.setEditButton(new F());  // 初始化器: Ljava/lang/Object;-><init>()V
            F f0 = this.getEditButton();
            com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.onViewCreated.1.1 musicMessageEditorFragment$onViewCreated$1$10 = (boolean z) -> {
                p p0 = MusicMessageEditorFragment.this.getMelonArrayAdapter();
                if(p0 != null) {
                    p0.setEditMode(z);
                }
                p p1 = MusicMessageEditorFragment.this.getMelonArrayAdapter();
                if(p1 != null) {
                    p1.notifyDataSetChanged();
                }
                if(z) {
                    View view0 = MusicMessageEditorFragment.this.mFooterContainer;
                    if(view0 != null) {
                        ViewUtils.showWhen(view0, false);
                        if(MusicMessageEditorFragment.this.mTitleBtnBlock != null) {
                            if(ProtocolUtils.parseBoolean(MusicMessageEditorFragment.this.getMGroupYn())) {
                                ViewUtils.showWhen(MusicMessageEditorFragment.this.mTitleBtnBlock, false);
                            }
                            else {
                                ViewUtils.showWhen(MusicMessageEditorFragment.this.mTitleBtnBlock, true);
                            }
                        }
                        MusicMessageEditorFragment.this.switchFooterAttachMode(false);
                        return false;
                    }
                    q.m("mFooterContainer");
                    throw null;
                }
                View view1 = MusicMessageEditorFragment.this.mFooterContainer;
                if(view1 != null) {
                    ViewUtils.showWhen(view1, true);
                    ViewUtils.showWhen(MusicMessageEditorFragment.this.mTitleBtnBlock, MusicMessageEditorFragment.this.mIsBlocked);
                    return true;
                }
                q.m("mFooterContainer");
                throw null;
            };
            f0.getClass();
            f0.h = musicMessageEditorFragment$onViewCreated$1$10;
            F8.p p0 = new F8.p(1);
            p0.c = new c(this, 0);
            TitleBar titleBar0 = this.getTitleBar();
            F f1 = this.getEditButton();
            f1.g(new l());  // 初始化器: Ljava/lang/Object;-><init>()V
            f1.g(p0);
            titleBar0.a(f1);
            this.getTitleBar().f(true);
        }
        String s = MelonContentUris.G.buildUpon().appendPath("musicMessage").appendQueryParameter("userKey", this.mUserKey).build().toString();
        q.f(s, "toString(...)");
        this.setMListCacheKey(s);
        View view1 = this.findViewById(0x7F0A0526);  // id:header_container
        q.f(view1, "findViewById(...)");
        this.mHeaderContainer = view1;
        ViewUtils.showWhen(view1, false);
        View view2 = this.findViewById(0x7F0A04D7);  // id:footer_container
        q.f(view2, "findViewById(...)");
        this.mFooterContainer = view2;
        ViewUtils.showWhen(view2, false);
        View view3 = this.findViewById(0x7F0A0522);  // id:gv_member
        q.e(view3, "null cannot be cast to non-null type android.widget.GridView");
        this.setMGvMemberView(((GridView)view3));
        View view4 = this.findViewById(0x7F0A0411);  // id:edt_message
        q.e(view4, "null cannot be cast to non-null type android.widget.EditText");
        this.mEdtMessage = (EditText)view4;
        ((EditText)view4).addTextChangedListener(this.mTextEditorWatcher);
        EditText editText0 = this.mEdtMessage;
        if(editText0 != null) {
            editText0.setOnFocusChangeListener(new k(this, 4));
        }
        View view5 = this.findViewById(0x7F0A01B2);  // id:btn_send_text
        this.mBtnSendText = view5;
        if(view5 != null) {
            view5.setEnabled(false);
        }
        ViewUtils.setOnClickListener(this.mBtnSendText, new c(this, 1));
        View view6 = this.findViewById(0x7F0A0140);  // id:btn_attach
        this.mBtnAttach = view6;
        ViewUtils.setOnClickListener(view6, new c(this, 2));
        View view7 = this.findViewById(0x7F0A00C8);  // id:attach_btns_container
        q.f(view7, "findViewById(...)");
        this.setMAttachBtnsContainer(view7);
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A01B1), new c(this, 3));  // id:btn_send_song
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A01B3), new c(this, 4));  // id:btn_send_video
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A01AD), new c(this, 5));  // id:btn_send_album
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A01AE), new c(this, 6));  // id:btn_send_artist
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A01AF), new c(this, 7));  // id:btn_send_playlist
        p p1 = this.getMelonArrayAdapter();
        if((p1 == null ? null : p1.getList()) != null) {
            this.updateTopAndBottom(null);
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$onViewCreated$1$1", "LF8/E;", "", "isChecked", "Lie/H;", "onCheckedStateChanged", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.onViewCreated.1.1 implements E {
            public com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.onViewCreated.1.1(MusicMessageEditorFragment musicMessageEditorFragment0) {
            }

            @Override  // F8.E
            public void onCheckedStateChanged(boolean z) {
                MusicMessageEditorFragment.this.switchFooterEditMode(z);
            }
        }

    }

    private static final void onViewCreated$lambda$10(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        RequestBuilder.newInstance(new CleanIsBlackReq(musicMessageEditorFragment0.getContext(), "MUSIC_MESSAGE", "")).tag(musicMessageEditorFragment0.getRequestTag()).listener(new a(musicMessageEditorFragment0, 1)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(26)).request();
    }

    private static final void onViewCreated$lambda$10$lambda$8(MusicMessageEditorFragment musicMessageEditorFragment0, CleanIsBlackRes cleanIsBlackRes0) {
        if(cleanIsBlackRes0.isSuccessful() && musicMessageEditorFragment0.isFragmentValid()) {
            if(musicMessageEditorFragment0.switchFooterAttachMode(musicMessageEditorFragment0.getMAttachBtnsContainer().getVisibility() != 0) && musicMessageEditorFragment0.mEdtMessage != null) {
                InputMethodUtils.showInputMethod(musicMessageEditorFragment0.getContext(), musicMessageEditorFragment0.mEdtMessage);
            }
            TimeExpiredCache.getInstance().remove(musicMessageEditorFragment0.getMListCacheKey());
        }
    }

    private static final void onViewCreated$lambda$10$lambda$9(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private static final void onViewCreated$lambda$12(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        Intent intent0 = new Intent(musicMessageEditorFragment0.getActivity(), SearchAndAddActivity.class);
        intent0.putExtra("argSearchViewType", 4);
        intent0.putExtra("argCallerType", 5);
        intent0.putExtra("argMaxContentCount", 10);
        musicMessageEditorFragment0.searchActivityResult.b(intent0);
    }

    private static final void onViewCreated$lambda$14(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        Intent intent0 = new Intent(musicMessageEditorFragment0.getActivity(), SearchAndAddActivity.class);
        intent0.putExtra("argSearchViewType", 5);
        intent0.putExtra("argCallerType", 6);
        intent0.putExtra("argMaxContentCount", 10);
        musicMessageEditorFragment0.searchActivityResult.b(intent0);
    }

    private static final void onViewCreated$lambda$16(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        Intent intent0 = new Intent(musicMessageEditorFragment0.getActivity(), SearchAndAddActivity.class);
        intent0.putExtra("argSearchViewType", 6);
        intent0.putExtra("argCallerType", 7);
        intent0.putExtra("argMaxContentCount", 10);
        musicMessageEditorFragment0.searchActivityResult.b(intent0);
    }

    private static final void onViewCreated$lambda$18(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        Intent intent0 = new Intent(musicMessageEditorFragment0.getActivity(), SearchAndAddActivity.class);
        intent0.putExtra("argSearchViewType", 7);
        intent0.putExtra("argCallerType", 8);
        intent0.putExtra("argMaxContentCount", 10);
        musicMessageEditorFragment0.searchActivityResult.b(intent0);
    }

    private static final void onViewCreated$lambda$20(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        Intent intent0 = new Intent(musicMessageEditorFragment0.getActivity(), SearchAndAddActivity.class);
        intent0.putExtra("argSearchViewType", 9);
        intent0.putExtra("argCallerType", 10);
        intent0.putExtra("argMaxContentCount", 10);
        musicMessageEditorFragment0.searchActivityResult.b(intent0);
    }

    private static final void onViewCreated$lambda$5$lambda$4(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        p p0 = musicMessageEditorFragment0.getMelonArrayAdapter();
        if(p0 != null) {
            p0.setEditMode(false);
        }
        musicMessageEditorFragment0.mIsClosing = true;
        musicMessageEditorFragment0.performBackPress();
    }

    private static final void onViewCreated$lambda$6(MusicMessageEditorFragment musicMessageEditorFragment0, View view0, boolean z) {
        if(z) {
            InputMethodUtils.showInputMethod(musicMessageEditorFragment0.getContext(), musicMessageEditorFragment0.mEdtMessage);
            ViewUtils.showWhen(musicMessageEditorFragment0.getMAttachBtnsContainer(), false);
            View view1 = musicMessageEditorFragment0.mBtnAttach;
            if(view1 != null) {
                view1.setBackgroundResource(0x7F080810);  // drawable:selector_btn_m_add
            }
            return;
        }
        InputMethodUtils.hideInputMethod(musicMessageEditorFragment0.getContext(), musicMessageEditorFragment0.mEdtMessage);
    }

    private static final void onViewCreated$lambda$7(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        musicMessageEditorFragment0.insertText();
        View view1 = musicMessageEditorFragment0.mBtnSendText;
        if(view1 != null) {
            view1.setEnabled(false);
        }
    }

    public static void p0(VolleyError volleyError0) {
        MusicMessageEditorFragment.deleteItem$lambda$39$lambda$38(volleyError0);
    }

    public static void q0(MusicMessageEditorFragment musicMessageEditorFragment0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, MusicMessageDeleteMusicMsgInboxContentsRes musicMessageDeleteMusicMsgInboxContentsRes0) {
        MusicMessageEditorFragment.deleteItem$lambda$39$lambda$37(musicMessageEditorFragment0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, musicMessageDeleteMusicMsgInboxContentsRes0);
    }

    public static void r0(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        MusicMessageEditorFragment.onViewCreated$lambda$20(musicMessageEditorFragment0, view0);
    }

    public final void reportServer(@NotNull String s) {
        q.g(s, "seq");
        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
        melonLinkInfo0.b = MelonLinkExecutor.getCleanReportUrl("MUSIC_MESSAGE", s);
        melonLinkInfo0.a = "PA";
        MelonLinkExecutor.open(melonLinkInfo0);
    }

    private final void requestClean(String s, MarkedContsInfo searchAndAddBaseAdapter$MarkedContsInfo0) {
        RequestBuilder.newInstance(new CleanIsBlackReq(this.getContext(), "MUSIC_MESSAGE", "")).tag(this.getRequestTag()).listener(new H7.c(this, s, searchAndAddBaseAdapter$MarkedContsInfo0, 17)).errorListener(new com.iloen.melon.fragments.musicmessage.e(0)).request();
    }

    private static final void requestClean$lambda$31(MusicMessageEditorFragment musicMessageEditorFragment0, String s, MarkedContsInfo searchAndAddBaseAdapter$MarkedContsInfo0, CleanIsBlackRes cleanIsBlackRes0) {
        String s2;
        if(cleanIsBlackRes0.isSuccessful() && musicMessageEditorFragment0.isFragmentValid()) {
            com.iloen.melon.net.v6x.request.MusicMessageInsertMusicMsgBaseReq.Params musicMessageInsertMusicMsgBaseReq$Params0 = new com.iloen.melon.net.v6x.request.MusicMessageInsertMusicMsgBaseReq.Params();
            musicMessageInsertMusicMsgBaseReq$Params0.targetMemberkeys = Receiver.b(musicMessageEditorFragment0.mReceiverList);
            if(q.b(s, "text")) {
                musicMessageInsertMusicMsgBaseReq$Params0.mesgCont = String.valueOf((musicMessageEditorFragment0.mEdtMessage == null ? null : musicMessageEditorFragment0.mEdtMessage.getText()));
            }
            String s1 = "";
            if(searchAndAddBaseAdapter$MarkedContsInfo0 == null) {
                s2 = "";
            }
            else {
                s2 = searchAndAddBaseAdapter$MarkedContsInfo0.getMarkedContsTypeCodes();
                if(s2 == null) {
                    s2 = "";
                }
            }
            musicMessageInsertMusicMsgBaseReq$Params0.contsTypeCodes = s2;
            if(searchAndAddBaseAdapter$MarkedContsInfo0 != null) {
                String s3 = searchAndAddBaseAdapter$MarkedContsInfo0.getMarkedContsIds();
                if(s3 != null) {
                    s1 = s3;
                }
            }
            musicMessageInsertMusicMsgBaseReq$Params0.contsIds = s1;
            if(ProtocolUtils.parseBoolean(musicMessageEditorFragment0.getMGroupYn())) {
                musicMessageInsertMusicMsgBaseReq$Params0.groupInboxSeq = musicMessageEditorFragment0.mInboxSeq;
            }
            musicMessageEditorFragment0.executeMusicMessageInsertMusicMsgReq(musicMessageInsertMusicMsgBaseReq$Params0);
        }
    }

    private static final void requestClean$lambda$32(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public static void s0(MusicMessageEditorFragment musicMessageEditorFragment0) {
        MusicMessageEditorFragment.switchFooterAttachMode$lambda$29(musicMessageEditorFragment0);
    }

    private static final void searchActivityResult$lambda$1(MusicMessageEditorFragment musicMessageEditorFragment0, ActivityResult activityResult0) {
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                MarkedContsInfo searchAndAddBaseAdapter$MarkedContsInfo0 = (MarkedContsInfo)intent0.getParcelableExtra("argSearchResultValues");
                if(searchAndAddBaseAdapter$MarkedContsInfo0 != null) {
                    LogU.Companion.d("MusicMessageEditorFragment", androidx.appcompat.app.o.o("MarkedContsInfo : ids = ", searchAndAddBaseAdapter$MarkedContsInfo0.getMarkedContsIds(), " , typecodes = ", searchAndAddBaseAdapter$MarkedContsInfo0.getMarkedContsTypeCodes()));
                    musicMessageEditorFragment0.insertContent(searchAndAddBaseAdapter$MarkedContsInfo0);
                }
            }
        }
    }

    public final void setEditButton(@NotNull F f0) {
        q.g(f0, "<set-?>");
        this.editButton = f0;
    }

    public final void setMAttachBtnsContainer(@NotNull View view0) {
        q.g(view0, "<set-?>");
        this.mAttachBtnsContainer = view0;
    }

    public final void setMBtnAttach(@Nullable View view0) {
        this.mBtnAttach = view0;
    }

    public final void setMBtnSendText(@Nullable View view0) {
        this.mBtnSendText = view0;
    }

    public final void setMEdtMessage(@Nullable EditText editText0) {
        this.mEdtMessage = editText0;
    }

    public final void setMGroupYn(@NotNull String s) {
        q.g(s, "<set-?>");
        this.mGroupYn = s;
    }

    public final void setMGvMemberView(@NotNull GridView gridView0) {
        q.g(gridView0, "<set-?>");
        this.mGvMemberView = gridView0;
    }

    public final void setMHasMore(boolean z) {
        this.mHasMore = z;
    }

    public final void setMInboxSeq(@Nullable String s) {
        this.mInboxSeq = s;
    }

    public final void setMIsBlocked(boolean z) {
        this.mIsBlocked = z;
    }

    public final void setMIsClosing(boolean z) {
        this.mIsClosing = z;
    }

    public final void setMIsQuit(boolean z) {
        this.mIsQuit = z;
    }

    public final void setMLinearLayoutManager(@NotNull LinearLayoutManager linearLayoutManager0) {
        q.g(linearLayoutManager0, "<set-?>");
        this.mLinearLayoutManager = linearLayoutManager0;
    }

    public final void setMListCacheKey(@NotNull String s) {
        q.g(s, "<set-?>");
        this.mListCacheKey = s;
    }

    public final void setMNextTimeStamp(@NotNull String s) {
        q.g(s, "<set-?>");
        this.mNextTimeStamp = s;
    }

    public final void setMReceiverList(@Nullable ArrayList arrayList0) {
        this.mReceiverList = arrayList0;
    }

    public final void setMTargetMemberkey(@Nullable String s) {
        this.mTargetMemberkey = s;
    }

    public final void setMTextMaxLength(int v) {
        this.mTextMaxLength = v;
    }

    public final void setMTitleBtnBlock(@Nullable ToggleButton toggleButton0) {
        this.mTitleBtnBlock = toggleButton0;
    }

    public final void setMTitleNickname(@NotNull TextView textView0) {
        q.g(textView0, "<set-?>");
        this.mTitleNickname = textView0;
    }

    private final void setTitleBar() {
        String s;
        View view0 = this.mHeaderContainer;
        if(view0 != null) {
            boolean z = false;
            ViewUtils.showWhen(view0, false);
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null && this.mReceiverList != null) {
                Context context0 = Y.a(MelonAppBase.Companion);
                ArrayList arrayList0 = this.mReceiverList;
                if(arrayList0 == null || arrayList0.size() <= 0) {
                    s = "메시지";
                }
                else {
                    boolean z1 = ScreenUtils.isDarkMode(context0);
                    StringBuilder stringBuilder0 = new StringBuilder();
                    if(((Receiver)arrayList0.get(0)).c.length() > 9) {
                        if(z1) {
                            stringBuilder0.append("<font color=\"#fafafa\">");
                        }
                        else {
                            stringBuilder0.append("<font color=\"#191919\">");
                        }
                        stringBuilder0.append(((Receiver)arrayList0.get(0)).c.substring(0, 9));
                        stringBuilder0.append("...</font>");
                    }
                    else {
                        if(z1) {
                            stringBuilder0.append("<font color=\"#fafafa\">");
                        }
                        else {
                            stringBuilder0.append("<font color=\"#191919\">");
                        }
                        stringBuilder0.append(((Receiver)arrayList0.get(0)).c);
                        stringBuilder0.append("</font>");
                    }
                    if(arrayList0.size() > 1) {
                        if(z1) {
                            stringBuilder0.append("<font color=\"#a6a6a6\">");
                        }
                        else {
                            stringBuilder0.append("<font color=\"#7f7f7f\">");
                        }
                        stringBuilder0.append(context0.getString(0x7F130717, new Object[]{((int)(arrayList0.size() - 1))}));  // string:music_message_member_count "님 외 %d명"
                        stringBuilder0.append("</font>");
                    }
                    s = stringBuilder0.toString();
                }
                View view1 = titleBar0.findViewById(0x7F0A0BB1);  // id:titlebar_tv_title
                q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
                this.setMTitleNickname(((TextView)view1));
                View view2 = titleBar0.findViewById(0x7F0A0BB0);  // id:titlebar_toggle_btn_block
                q.e(view2, "null cannot be cast to non-null type android.widget.ToggleButton");
                this.mTitleBtnBlock = (ToggleButton)view2;
                this.getMTitleNickname().setText(Html.fromHtml(s, 0));
                if((this.mReceiverList == null ? 0 : this.mReceiverList.size()) > 1) {
                    this.getMTitleNickname().setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7F080098, 0);  // drawable:arrow_list_open_s
                    ViewUtils.setOnClickListener(this.getMTitleNickname(), new c(this, 8));
                }
                else {
                    this.getMTitleNickname().setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    ViewUtils.setOnClickListener(this.getMTitleNickname(), null);
                    ToggleButton toggleButton0 = this.mTitleBtnBlock;
                    if(toggleButton0 != null) {
                        toggleButton0.setChecked(this.mIsBlocked);
                    }
                    ToggleButton toggleButton1 = this.mTitleBtnBlock;
                    if(toggleButton1 != null) {
                        toggleButton1.setOnCheckedChangeListener(new D(this, 1));
                    }
                }
                p p0 = this.getMelonArrayAdapter();
                if(p0 != null && p0.isInEditMode()) {
                    z = true;
                }
                this.switchFooterEditMode(z);
            }
            return;
        }
        q.m("mHeaderContainer");
        throw null;
    }

    private static final void setTitleBar$lambda$27(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        View view1 = musicMessageEditorFragment0.mHeaderContainer;
        if(view1 != null) {
            musicMessageEditorFragment0.showUserInfoView(view1.getVisibility() == 8);
            return;
        }
        q.m("mHeaderContainer");
        throw null;
    }

    private static final void setTitleBar$lambda$28(MusicMessageEditorFragment musicMessageEditorFragment0, CompoundButton compoundButton0, boolean z) {
        if(musicMessageEditorFragment0.mIsBlocked != z) {
            if(musicMessageEditorFragment0.mIsQuit) {
                l0 l00 = musicMessageEditorFragment0.getChildFragmentManager();
                String s = musicMessageEditorFragment0.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                String s1 = musicMessageEditorFragment0.getString(0x7F130472);  // string:friend_is_withidraw_member "탈퇴한 회원입니다."
                com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
                ToggleButton toggleButton0 = musicMessageEditorFragment0.mTitleBtnBlock;
                if(toggleButton0 != null) {
                    toggleButton0.setChecked(musicMessageEditorFragment0.mIsBlocked);
                }
            }
            else {
                if(z) {
                    musicMessageEditorFragment0.blockUser();
                    return;
                }
                musicMessageEditorFragment0.unblockUser();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private final void showUserInfoView(boolean z) {
        this.getTitleBar().f(!z);
        View view0 = this.mHeaderContainer;
        if(view0 != null) {
            ViewUtils.showWhen(view0, z);
            this.getMTitleNickname().setCompoundDrawablesWithIntrinsicBounds(0, 0, (z ? 0x7F080095 : 0x7F080098), 0);  // drawable:arrow_list_close_s
            return;
        }
        q.m("mHeaderContainer");
        throw null;
    }

    private final boolean switchFooterAttachMode(boolean z) {
        if(z) {
            EditText editText0 = this.mEdtMessage;
            if(editText0 != null) {
                editText0.clearFocus();
            }
            InputMethodUtils.hideInputMethod(this.getContext(), this.mEdtMessage);
            this.getMAttachBtnsContainer().postDelayed(new com.facebook.appevents.c(this, 20), 100L);
            return false;
        }
        ViewUtils.showWhen(this.getMAttachBtnsContainer(), false);
        View view0 = this.mBtnAttach;
        if(view0 != null) {
            view0.setBackgroundResource(0x7F080810);  // drawable:selector_btn_m_add
        }
        return true;
    }

    private static final void switchFooterAttachMode$lambda$29(MusicMessageEditorFragment musicMessageEditorFragment0) {
        ViewUtils.showWhen(musicMessageEditorFragment0.getMAttachBtnsContainer(), true);
        View view0 = musicMessageEditorFragment0.mBtnAttach;
        if(view0 != null) {
            view0.setBackgroundResource(0x7F080211);  // drawable:btn_m_keyboard
        }
    }

    private final void switchFooterBlockMode(boolean z) {
        this.mIsBlocked = z;
        EditText editText0 = this.mEdtMessage;
        if(editText0 != null) {
            if(editText0.isEnabled() == !z) {
                return;
            }
            EditText editText1 = this.mEdtMessage;
            if(editText1 != null) {
                editText1.setText("");
            }
            EditText editText2 = this.mEdtMessage;
            if(editText2 != null) {
                editText2.setEnabled(!z);
            }
            EditText editText3 = this.mEdtMessage;
            if(editText3 != null) {
                editText3.setHint(this.getResources().getString((z ? 0x7F13091B : 0x7F13091D)));  // string:send_message_block_input_text "차단 중입니다."
            }
        }
        View view0 = this.mBtnAttach;
        if(view0 != null) {
            view0.setEnabled(!z);
        }
        View view1 = this.mBtnSendText;
        if(view1 != null) {
            view1.setEnabled(!z);
        }
    }

    // 检测为 Lambda 实现
    public final boolean switchFooterEditMode(boolean z) [...]

    public static void t0(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        MusicMessageEditorFragment.onViewCreated$lambda$7(musicMessageEditorFragment0, view0);
    }

    public static void u0(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        MusicMessageEditorFragment.onViewCreated$lambda$10(musicMessageEditorFragment0, view0);
    }

    private final void unblockUser() {
        Y.w("unblockUser mTargetMemberkey: ", this.mTargetMemberkey, LogU.Companion, "MusicMessageEditorFragment");
        if(this.mTargetMemberkey != null && this.mTitleBtnBlock != null) {
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s1 = this.getString(0x7F1300C6);  // string:alert_dlg_music_message_delete_block_user_confirm "%1$s님을 차단해제하시겠습니까?"
            q.f(s1, "getString(...)");
            com.melon.ui.popup.b.x(l00, s, String.format(s1, Arrays.copyOf(new Object[]{this.getMTitleNickname().getText()}, 1)), false, false, null, null, new d(this, 2), new d(this, 3), null, null, 0xCF8);
            return;
        }
        ToggleButton toggleButton0 = this.mTitleBtnBlock;
        if(toggleButton0 != null) {
            toggleButton0.setChecked(this.mIsBlocked);
        }
    }

    private static final H unblockUser$lambda$48(MusicMessageEditorFragment musicMessageEditorFragment0) {
        com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq.Params musicMessageDeleteBanUserReq$Params0 = new com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq.Params();
        musicMessageDeleteBanUserReq$Params0.memberKeyBan = musicMessageEditorFragment0.mTargetMemberkey;
        RequestBuilder.newInstance(new MusicMessageDeleteBanUserReq(musicMessageEditorFragment0.getContext(), musicMessageDeleteBanUserReq$Params0)).tag("MusicMessageEditorFragment").listener(new a(musicMessageEditorFragment0, 2)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(27)).request();
        return H.a;
    }

    private static final void unblockUser$lambda$48$lambda$46(MusicMessageEditorFragment musicMessageEditorFragment0, MusicMessageDeleteBanUserRes musicMessageDeleteBanUserRes0) {
        if(musicMessageEditorFragment0.isFragmentValid()) {
            if(musicMessageDeleteBanUserRes0.isSuccessful()) {
                musicMessageEditorFragment0.switchFooterBlockMode(false);
                return;
            }
            ToggleButton toggleButton0 = musicMessageEditorFragment0.mTitleBtnBlock;
            if(toggleButton0 != null) {
                toggleButton0.setChecked(musicMessageEditorFragment0.mIsBlocked);
            }
        }
    }

    private static final void unblockUser$lambda$48$lambda$47(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private static final H unblockUser$lambda$49(MusicMessageEditorFragment musicMessageEditorFragment0) {
        ToggleButton toggleButton0 = musicMessageEditorFragment0.mTitleBtnBlock;
        if(toggleButton0 != null) {
            toggleButton0.setChecked(musicMessageEditorFragment0.mIsBlocked);
        }
        return H.a;
    }

    private final void updateTopAndBottom(i i0) {
        if(ProtocolUtils.parseBoolean(this.getMGroupYn())) {
            this.getMGvMemberView().setAdapter(new MemberGridAdapter(this));
        }
        this.setTitleBar();
        this.switchFooterBlockMode(this.mIsBlocked);
        if(i0 != null && i.b.equals(i0)) {
            View view0 = this.mBtnSendText;
            if(view0 != null) {
                view0.setEnabled(false);
            }
        }
    }

    public static void v0(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        MusicMessageEditorFragment.onViewCreated$lambda$5$lambda$4(musicMessageEditorFragment0, view0);
    }

    public static void w0(MusicMessageEditorFragment musicMessageEditorFragment0, View view0) {
        MusicMessageEditorFragment.onViewCreated$lambda$12(musicMessageEditorFragment0, view0);
    }

    public static void x0(MusicMessageEditorFragment musicMessageEditorFragment0, MusicMessageInsertMusicMsgRes musicMessageInsertMusicMsgRes0) {
        MusicMessageEditorFragment.executeMusicMessageInsertMusicMsgReq$lambda$33(musicMessageEditorFragment0, musicMessageInsertMusicMsgRes0);
    }

    public static void y0(MusicMessageEditorFragment musicMessageEditorFragment0, i i0, MusicMessageInformInboxSeqRes musicMessageInformInboxSeqRes0) {
        MusicMessageEditorFragment.onFetchStart$lambda$24(musicMessageEditorFragment0, i0, musicMessageInformInboxSeqRes0);
    }

    public static void z0(MusicMessageEditorFragment musicMessageEditorFragment0, CompoundButton compoundButton0, boolean z) {
        MusicMessageEditorFragment.setTitleBar$lambda$28(musicMessageEditorFragment0, compoundButton0, z);
    }
}

