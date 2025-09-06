package com.iloen.melon.fragments.test;

import E9.w;
import Hd.T;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.lifecycle.f0;
import b3.Z;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.fragments.DcfExtensionNeededBrowserFragment;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment.ParamItem;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenWithBarFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.StreamGetSongInfoReq.ParamInfo;
import com.iloen.melon.net.v4x.request.StreamGetSongInfoReq;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddResult.Success;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.iloen.melon.player.playlist.PlaylistMainFragment;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.template.TemplateImageLoader;
import e1.G;
import i9.m;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pc.P0;
import r8.f;
import we.n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0002%$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u00122\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u001E\u001A\u00020\b2\f\u0010\u0019\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00182\u0006\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/test/TestFragment;", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "Landroid/widget/AdapterView$OnItemClickListener;", "<init>", "()V", "Landroid/widget/ListAdapter;", "createAdapterAndAddItems", "()Landroid/widget/ListAdapter;", "Lie/H;", "setupMenu", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/widget/AdapterView;", "parent", "", "position", "", "id", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "mCommands", "Ljava/util/List;", "Companion", "Command", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TestFragment extends MelonBaseFragment implements AdapterView.OnItemClickListener {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\bb\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078&X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/test/TestFragment$Command;", "", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    interface Command {
        void execute(@Nullable Context arg1);

        @Nullable
        String getTitle();
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/test/TestFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_CODE_SOUND_ALIVE", "", "newInstance", "Lcom/iloen/melon/fragments/test/TestFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TestFragment newInstance() {
            return new TestFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int REQUEST_CODE_SOUND_ALIVE = 100;
    @NotNull
    private static final String TAG = "TestFragment";
    @NotNull
    private final List mCommands;

    static {
        TestFragment.Companion = new Companion(null);
        TestFragment.$stable = 8;
    }

    public TestFragment() {
        this.mCommands = new ArrayList();
    }

    private final ListAdapter createAdapterAndAddItems() {
        ListAdapter listAdapter0 = new ArrayAdapter(this.requireActivity(), 0x7F0D0450);  // layout:list_item_debug_simple
        for(Object object0: this.mCommands) {
            ((ArrayAdapter)listAdapter0).add(((Command)object0).getTitle());
        }
        return listAdapter0;
    }

    @NotNull
    public static final TestFragment newInstance() {
        return TestFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setupMenu();
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02C4, viewGroup0, false);  // layout:fragment_test
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(@Nullable AdapterView adapterView0, @NotNull View view0, int v, long v1) {
        q.g(view0, "view");
        ((Command)this.mCommands.get(v)).execute(this.getActivity());
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = this.findViewById(0x7F0A0779);  // id:list
        q.e(view1, "null cannot be cast to non-null type android.widget.ListView");
        ((ListView)view1).setOnItemClickListener(this);
        ((ListView)view1).setAdapter(this.createAdapterAndAddItems());
    }

    private final void setupMenu() {
        com.iloen.melon.fragments.test.TestFragment.setupMenu.1 testFragment$setupMenu$10 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.1();
        this.mCommands.add(testFragment$setupMenu$10);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.2 testFragment$setupMenu$20 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.2();
        this.mCommands.add(testFragment$setupMenu$20);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.3 testFragment$setupMenu$30 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.3();
        this.mCommands.add(testFragment$setupMenu$30);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.4 testFragment$setupMenu$40 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.4();
        this.mCommands.add(testFragment$setupMenu$40);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.5 testFragment$setupMenu$50 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.5();
        this.mCommands.add(testFragment$setupMenu$50);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.6 testFragment$setupMenu$60 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.6();
        this.mCommands.add(testFragment$setupMenu$60);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.7 testFragment$setupMenu$70 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.7();
        this.mCommands.add(testFragment$setupMenu$70);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.8 testFragment$setupMenu$80 = new Command() {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                Uri uri0 = f.l.buildUpon().appendQueryParameter("message", "토근 만료 스키마 테스트").build();
                q.f(uri0, "build(...)");
                Intent intent0 = new Intent("android.intent.action.VIEW", uri0);
                TestFragment.this.startActivity(intent0);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() [...] // Inlined contents
        };
        this.mCommands.add(testFragment$setupMenu$80);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.9 testFragment$setupMenu$90 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.9();
        this.mCommands.add(testFragment$setupMenu$90);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.10 testFragment$setupMenu$100 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.10();
        this.mCommands.add(testFragment$setupMenu$100);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.11 testFragment$setupMenu$110 = new Command() {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                TestFragment.this.playArtistSongBasic("1", "1000000543", false, null);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "아티스트 대표곡 재생";
            }
        };
        this.mCommands.add(testFragment$setupMenu$110);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.12 testFragment$setupMenu$120 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.12();
        this.mCommands.add(testFragment$setupMenu$120);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.13 testFragment$setupMenu$130 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.13();
        this.mCommands.add(testFragment$setupMenu$130);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.14 testFragment$setupMenu$140 = new Command() {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(TestFragment.this, "40147045,40147046,40147047,40147048,40147049,40147050,40147051,40147052,40147053,40147054,40147055,40147056,40147057,40147058,40147059,40147060,40146940,40146941,40146942,40146943,40146944,40146945,40146946,40146947,40146948,40146949,40146950,40146951,40146952,40146953,40146954,40146955,40146956,40146957,40146958,40146959,40146960,40146961,40146962,40146963,40146964,40146965,40146966,40146967,40146968,40146969,40146970,40146971,40146972,40146973,40146974,40146975,40146976,40146977,40146978,40146979,40146980,40146981,40146982,40146983,40146984,40146985,40146986,40146987,40146988,40146989,40146990,40146991,40146992,40146993,40146994,40146995,40146996,40146997,40146998,40146999,40147000,40147001,40147002,40147003,40147004,40147005,40147006,40147007,40147008,40147009,40147010,40147011,40147012,40147013,40147014,40147015,40147016,40147017,40147018,40147019,40147020,40147021,40147022,40147023,40147024,40147025,40147026,40147027,40147028,40147029,40147030,40147031,40147032,40147033,40147034,40147035,40147036,40147037,40147038,40147039,40146860,40146861,40146862,40146863,40146864,40146865,40146866,40146867,40146868,40146869,40146870,40146871,40146872,40146873,40146874,40146875,40146876,40146877,40146878,40146879,40146880,40146881,40146882,40146883,40146884,40146885,40146886,40146887,40146888,40146889,40146890,40146891,40146892,40146893,40146894,40146895,40146896,40146897,40146898,40146899,40146900,40146901,40146902,40146903,40146904,40146905,40146906,40146907,40146908,40146909,40146910,40146911,40146912,40146913,40146914,40146915,40146916,40146917,40146918,40146919,40146920,40146921,40146922,40146923,40146924,40146925,40146926,40146927,40146928,40146929,40146930,40146931,40146932,40146933,40146934,40146935,40146936,40146937,40146938,40146939,40148152,40148171,40148190,40148216,40148217,40148241,40148260,40148279,40148298,40148324,40148325,40148349,40148368,40148387,40148406,40148432,40148433,40148457,40148481,40148497,40147696,40147697,40147721,40147740,40147759,40147798,40147799,40147800,40147829,40147848,40147883,40147901,40147902,40147918,40147937,40147956,40147975,40148001,40148002,40148026,40148045,40148064,40148083,40148109,40148110,40148133,40147216,40147242,40147243,40147267,40147286,40147305,40147360,40147361,40147362,40147363,40147397,40147416,40147435,40147469,40147470,40147486,40147505,40147524,40147543,40147569,40147570,40147594,40147613,40147632,40147651,40147678,40146511,40146530,40146549,40146568,40146594,40146595,40146619,40146638,40146657,40146676,40146715,40146716,40146717,40146746,40146765,40146784,40146810,40146811,40146835,40146854,40147074,40147093,40147134,40147135,40147167,40147178,40147197,40146054,40146055,40146079,40146098,40146117,40146136,40146162,40146163,40146187,40146206,40146225,40146244,40146270,40146271,40146295,40146314,40146333,40146352,40146378,40146379,40146403,40146422,40146441,40146460,40146494,40146495,40145545,40145564,40145607,40145608,40145609,40145638,40145657,40145676,40145806,40145807,40145823,40145834,40145845,40145856,40145886,40145887,40145903,40145914,40145925,40145939,40145957,40145958,40145974,40145985,40145996,40146015,40145075,40145094,40145126,40145127,40145158,40145159,40145183,40145202,40145221,40145240,40145264,40145265,40145291,40145318,40145329,40145356,40145374,40145375,40145399,40145418,40145437,40145456,40145482,40145483,40145507,40145534,40144614,40144615,40144639,40144658,40144677,40144696,40144722,40144723,40144747,40144766,40144785,40144804,40144834,40144835,40144859,40144878,40144897,40144916,40144942,40144943,40144967,40144986,40145005,40145024,40145048,40145049,40144098,40144117,40144168,40144182,40144183,40144203,40144219,40144220,40144244,40144306,40144307,40144323,40144334,40144345,40144356,40144382,40144383,40144407,40144426,40144445,40144464,40144490,40144491,40144515,40144534,40144553,40144572,40143679,40143680,40143704,40143730,40143731,40143755,40143774,40143793,40143812,40143838,40143839,40143863,40143882,40143901,40143920,40143946,40143947,40143971,40143990,40144009,40144028,401440,54,40144055,40144087,40143196,40143215,40143234,40143253,40143272,40143306,40143307,40143323,40143350,40143361,40143380,40143406,40143407,40143431,40143450,40143469,40143488,40143514,40143515,40143539,40143558,40143577,40143596,40143651,40143652,40143653,40142699,40142722,40142752,40142753,40142775,40142794,40142813,40142832,40142858,40142859,40142883,40142902,40142921,40142940,40142974,40142975,40142999,40143018,40143037,40143056,40143075,40143084,40143107,40143126,40143145,40143164,40143183,40142207,40142226,40142245,40142264,40142294,40142295,40142317,40142334,40142353,40142388,40142399,40142412,40142423,40142442,40142461,40142480,40142514,40142515,40142539,40142558,40142577,40142609,40142610,40142654,40142655,40142680,40141751,40141752,40141753,40141774,40141801,40141820,40141859,40141860,40141861,40141890,40141909,40141932,40141956,40141957,40141979,40141998,40142017,40142036,40142074,40142075,40142099,40142118,40142137,40142156,40142182,40142183,40141243,40141262,40141288,40141289,40141313,40141332,40141351,40141370,40141414,40141415,40141439,40141458,40141485,40141496,40141561,40141562,40141563,40141564,40141565,40141604,40141654,40141655,40141671,40141682,40141693,40141712,40140767,40140786,40140805,40140824,40140850,40140851,40140875,40140894,40140913,40140932,40140971,40140972,40140973,40141002,40141027,40141046,40141072,40141073,40141097,40141133,40141143,40141154,40141180,40141181,40141205,40141224,40140284,40140310,40140311,40140335,40140354,40140373,40140392,40140418,40140419,40140443,40140462,40140481,40140500,40140526,40140527,40140551,40140570,40140589,40140608,40140634,40140635,40140659,40140678,40140697,40140716,40140729,40140748,40139798,40139817,40139836,40139862,40139863,40139891,40139910,40139929,40139948,40139974,40139975,40139999,40140018,40140037,40140056,40140094,40140095,40140119,40140138,40140157,40140176,40140202,40140203,40140227,40140246,40140265,40139328,40139347,40139379,40139380,40139404,40139434,40139435,40139457,40139474,40139497,40139514,40139614,40139615,40139635,40139651,40139652,40139668,40139686,40139687,40139703,40139714,40139725,40139736,40139754,40139755,40139779,40138833,40138867,40138868,40138907,40138926,40138945,40138964,40138990,40138991,40139015,40139034,40139053,40139072,40139098,40139099,40139123,40139142,40139161,40139180,40139214,40139215,40139239,40139258,40139277,40139296,40139315,40138335,40138354,40138373,40138392,40138418,40138419,40138443,40138462,40138481,40138500,40138526,40138527,40138551,40138587,40138606,40138625,40138659,40138660,40138676,40138695,40138714,40138733,40138759,40138760,40138784,40138803,40138822,40137014,40137042,40137899,40137919,40137954,40137955,40137981,40138001,40138054,40138055,40138056,40138057,40138095,40138115,40138135,40138155,40138194,40138195,40138221,40138241,40138261,40138281,40138316,40138317,40136514,40136515,40136541,40136561,40136581,40136601,40136634,40136635,40136653,40136681,40136701,40136721,40136754,40136755,40136781,40136801,40136821,40136842,40136873,40136874,40136900,40136920,40136948,40136960,40136987,40136988,40136015,40136033,40136065,40136083,40136095,40136140,40136151,40136163,40136175,40136187,40136199,40136291,40136303,40136315,40136327,40136339,40136351,40136365,40136377,40136389,40136401,40136420,40136421,40136439,40136451,40136463,40136495,40135195,40135196,40135197,40135229,40135241,40135253,40135297,40135298,40135299,40135319,40135331,40135343,40135355,40135376,40135377,40135393,40135405,40135417,40135429,40135450,40135451,40135475,40135487,40135499,40135520,40135521,40135579,40134705,40134717,40134729,40134746,40134747,40134773,40134774,40134792,40134804,40134822,40134823,40134843,40134855,40134867,40134879,40134906,40134907,40134928,40134940,40134952,40134964,40134983,40134984,40135141,40135142,40135194,40134212,40134213,40134231,40134243,40134255,40134279,40134291,40134305,40134317,40134329,40134341,40134353,40134379,40134393,40134405,40134417,40134429,40134459,40134471,40134485,40134497,40134509,40134521,40134533,40134545,40134691,40133607,40133739,40133751,40133763,40133777,40133789,40133801,40133813,40133846,40133847,40133865,40133877,40133889,40133901,40133919,40133931,40133945,40133957,40133969,40133981,40133993,40134005,40134019,40134031,40134043,40134181,40134193,40133257,40133269,40133281,40133293,40133305,40133317,40133331,40133343,40133355,40133367,40133379,40133391,40133405,40133417,40133429,40133441,40133459,40133471,40133485,40133497,40133509,40133521,40133539,40133551,40133565,40133595,40132667,40132679,40132693,40132705,40132717,40132819,40132831,40132843,40132857,40132869,40132881,40132893,40132919,40132931,40132945,40132957,40132979,40132991,40133019,40133031,40133045,40133057,40133069,40133081,40133105,40133115,40132264,40132276,40132288,40132300,40132314,40132326,40132338,40132350,40132379,40132391,40132405,40132417,40132429,40132441,40132453,40132479,40132493,40132505,40132517,40132529,40132541,40132553,40132567,40132579,40132591,40132655", null) {
                    final Context $context;
                    final String $list;
                    int label;

                    {
                        this.$context = context0;
                        TestFragment.this = testFragment0;
                        this.$list = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.test.TestFragment.setupMenu.14.execute.1(this.$context, TestFragment.this, this.$list, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.test.TestFragment.setupMenu.14.execute.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        RequestFuture requestFuture0 = RequestFuture.newFuture();
                        ParamInfo streamGetSongInfoReq$ParamInfo0 = new ParamInfo();
                        streamGetSongInfoReq$ParamInfo0.cid = this.$list;
                        CType cType0 = CType.EDU;
                        streamGetSongInfoReq$ParamInfo0.cType = "4";
                        HttpResponse httpResponse0 = RequestBuilder.newInstance(new StreamGetSongInfoReq(this.$context, streamGetSongInfoReq$ParamInfo0)).tag("TestFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                        StreamGetSongInfoRes streamGetSongInfoRes0 = httpResponse0 instanceof StreamGetSongInfoRes ? ((StreamGetSongInfoRes)httpResponse0) : null;
                        if(streamGetSongInfoRes0 != null && streamGetSongInfoRes0.isSuccessful()) {
                            RESPONSE streamGetSongInfoRes$RESPONSE0 = streamGetSongInfoRes0.response;
                            if(streamGetSongInfoRes$RESPONSE0 != null) {
                                ArrayList arrayList0 = Playable.makeList(streamGetSongInfoRes$RESPONSE0.contentsInfo, "1000000562", null, null);
                                ((Playable)arrayList0.get(0)).setCtype(cType0);
                                AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(TestFragment.this.getActivity(), new AddPlayableList(null, Add.INSTANCE, false, false, false, null, arrayList0, 0x20, null), false, 2, null);
                            }
                        }
                        return H.a;
                    }
                }, 3, null);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "어학 1000곡 채우기";
            }
        };
        this.mCommands.add(testFragment$setupMenu$140);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.15 testFragment$setupMenu$150 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.15();
        this.mCommands.add(testFragment$setupMenu$150);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.16 testFragment$setupMenu$160 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.16();
        this.mCommands.add(testFragment$setupMenu$160);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.17 testFragment$setupMenu$170 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.17();
        this.mCommands.add(testFragment$setupMenu$170);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.18 testFragment$setupMenu$180 = new com.iloen.melon.fragments.test.TestFragment.setupMenu.18();
        this.mCommands.add(testFragment$setupMenu$180);
        com.iloen.melon.fragments.test.TestFragment.setupMenu.19 testFragment$setupMenu$190 = new Command() {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                BuildersKt__Builders_commonKt.launch$default(f0.f(TestFragment.this), null, null, new n(null) {
                    final Context $context;
                    Object L$0;
                    int label;

                    {
                        this.$context = context0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.test.TestFragment.setupMenu.19.execute.1(this.$context, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.test.TestFragment.setupMenu.19.execute.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                P0 p00 = new P0(false, "N", null, null, null, null, 0x7D);
                                AddServerContent addServerContent0 = new AddServerContent(new AddPlay(false), false, false, null, new MixUp(p00, "1000000543", null), 14, null);
                                this.L$0 = null;
                                this.label = 1;
                                object0 = addServerContent0.execute(this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                P0 p01 = (P0)this.L$0;
                                d5.n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        if(((AddResult)object0) instanceof Success) {
                            Toast.makeText(this.$context, "믹스업 심플모드 재생 성공!", 0).show();
                            return H.a;
                        }
                        Toast.makeText(this.$context, "믹스업 심플모드 재생 실패..", 0).show();
                        return H.a;
                    }
                }, 3, null);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "믹스업 심플모드 재생 테스트";
            }
        };
        this.mCommands.add(testFragment$setupMenu$190);

        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$10", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.10 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                T t0 = new T();
                Bundle bundle0 = new Bundle();
                bundle0.putString("argItemId", "8");
                t0.setArguments(bundle0);
                Navigator.INSTANCE.open(t0);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "프로그램 상세";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$12", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.12 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                Toast.makeText(context0, "믹스커버 디버깅 On", 0).show();
                TemplateImageLoader.MIX_COVER_DEBUG_ON = true;
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "믹스커버 디버깅 정보 On";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$13", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.13 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                throw new RuntimeException("Test Crash");
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "Force a crash to test";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$15", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.15 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                PlaylistMainFragment playlistMainFragment0 = new PlaylistMainFragment();
                Navigator.INSTANCE.open(playlistMainFragment0);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "스마트 플레이리스트 올리기";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$16", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.16 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                if(context0 != null) {
                    context0.startForegroundService(w.v("36713849", "Love Lee", "712452"));
                }
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "알람 믹스업 재생 TEST";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$17", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.17 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                Toast.makeText(context0, "Fragment Bundle 사이즈 로깅 On", 0).show();
                y5.a.c = true;
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "Fragment Bundle 사이즈 로깅 On";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$18", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.18 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                String s;
                int v = (G.f + 1) % 4;
                G.f = v;
                switch(v) {
                    case 0: {
                        s = "Parallax(타이틀 + 헤더 + 필터 + 리스트)";
                        break;
                    }
                    case 1: {
                        s = "Parallax(타이틀 + 헤더 + 필터 + 리스트 -> 가로화면 커스텀)";
                        break;
                    }
                    default: {
                        s = v == 2 ? "Parallax(타이틀 + 헤더 + 리스트)" : "Parallax(헤더 + 리스트)";
                    }
                }
                Toast.makeText(context0, s, 0).show();
                y5.a.c = true;
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "Compose Parallax 샘플(앨범상세) On";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$1", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.1 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                DcfExtensionNeededBrowserFragment.newInstance().open();
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "DCF 기간연장";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$2", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.2 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                ParamItem melonWebViewFullScreenFragment$ParamItem0 = new ParamItem("file:///android_asset/webviewtest.html");
                melonWebViewFullScreenFragment$ParamItem0.title = "웹뷰팝업";
                MelonWebViewFullScreenFragment.newInstance(melonWebViewFullScreenFragment$ParamItem0).open();
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() [...] // Inlined contents
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$3", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.3 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                MelonWebViewFullScreenWithBarFragment.newInstance("http://m.melon.com/SchemetestAndroid.html", true).open();
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "친밀도공유웹뷰테스트";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$4", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.4 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                Z.r(MelonAppBase.instance.getContext().getContentResolver().delete(m.a, null, null), "Deleted - count: ", "PlayStreaming");
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "로컬매핑DB삭제(PlayStremaing)";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$5", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.5 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                Intent intent0 = new Intent("android.intent.action.MEDIA_MOUNTED");
                intent0.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
                q.d(context0);
                context0.sendBroadcast(intent0);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "미디어스캔 (sdcard)";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$6", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.6 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                Uri.Builder uri$Builder0 = f.g.buildUpon();
                if(!TextUtils.isEmpty("서버에서 보낸 메세지를 보여주고 해당 App 종료")) {
                    uri$Builder0.appendQueryParameter("message", "서버에서 보낸 메세지를 보여주고 해당 App 종료");
                }
                Uri uri0 = uri$Builder0.build();
                q.f(uri0, "build(...)");
                f.a(uri0);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() [...] // Inlined contents
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$7", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.7 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
                Uri.Builder uri$Builder0 = f.g.buildUpon();
                if(!TextUtils.isEmpty(null)) {
                    uri$Builder0.appendQueryParameter("message", null);
                }
                Uri uri0 = uri$Builder0.build();
                q.f(uri0, "build(...)");
                f.a(uri0);
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "스트리밍 앱 바로 종료";
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"com/iloen/melon/fragments/test/TestFragment$setupMenu$9", "Lcom/iloen/melon/fragments/test/TestFragment$Command;", "Landroid/content/Context;", "context", "Lie/H;", "execute", "(Landroid/content/Context;)V", "", "getTitle", "()Ljava/lang/String;", "title", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.test.TestFragment.setupMenu.9 implements Command {
            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public void execute(Context context0) {
            }

            @Override  // com.iloen.melon.fragments.test.TestFragment$Command
            public String getTitle() {
                return "삼성 갤럭시 SoundAlive 테스트";
            }
        }

    }
}

