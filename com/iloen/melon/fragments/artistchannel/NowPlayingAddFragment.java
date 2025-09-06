package com.iloen.melon.fragments.artistchannel;

import F8.B;
import F8.m;
import F8.p;
import T3.e;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.f0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.activity.EditIntroductionActivity;
import com.iloen.melon.activity.SearchAndAddActivity;
import com.iloen.melon.activity.SelectLyricActivity;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.InformNowPlayingReq;
import com.iloen.melon.net.v4x.request.InsertNowPlayingReq.ParamInfo;
import com.iloen.melon.net.v4x.request.InsertNowPlayingReq;
import com.iloen.melon.net.v4x.request.NowplayingInformSongInfoReq;
import com.iloen.melon.net.v4x.request.UpdateNowPlayingReq;
import com.iloen.melon.net.v4x.response.InformNowPlayingRes.RESPONSE;
import com.iloen.melon.net.v4x.response.InformNowPlayingRes;
import com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE.SONGINFO;
import com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.b;
import e1.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import v9.h;
import v9.i;
import va.e0;
import va.o;

public class NowPlayingAddFragment extends MetaContentBaseFragment {
    public static class NowPlayingEditFragment extends NowPlayingAddFragment {
        @Override  // com.iloen.melon.fragments.artistchannel.NowPlayingAddFragment
        public static NowPlayingAddFragment newInstance(String s) {
            NowPlayingAddFragment nowPlayingAddFragment0 = new NowPlayingAddFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argNowPlaySeq", s);
            nowPlayingAddFragment0.setArguments(bundle0);
            return nowPlayingAddFragment0;
        }
    }

    private static final String ARG_IS_EDIT_FIELD = "argIsEditField";
    private static final String ARG_NOWPLAYING_INFORM_RES = "argNowplayingInformRes";
    private static final String ARG_NOW_PLAY_SEQ = "argNowPlaySeq";
    private static final String ARG_ORG_SONG_ID = "argOrgSongId";
    private static final String ARG_SONG_ID = "argSongId";
    private static final String CAPTURE_DIR_PATH = null;
    private static final String CAPTURE_FILE_NAME = null;
    private static final String TAG = "NowPlayingAddFragment";
    private B completeButton;
    private b editIntroActivityResult;
    private View.OnClickListener mAddSongListener;
    private ImageView mAlbumImage;
    private int mAlbumImageWidth;
    private TextView mArtistName;
    private View mBtnSelectSong;
    private ImageView mCoverImage;
    private View mDefaultContainer;
    private boolean mExistLyric;
    private RESPONSE mInformRes;
    private TextView mIntroduce;
    private boolean mIsEditField;
    private TextView mLyricView1;
    private TextView mLyricView2;
    private String mNowPlaySeq;
    private String mOrgSongId;
    private TextView mSelectedLyric;
    private View mSeparator;
    private String mSongId;
    private View mSongInfoContainer;
    private TextView mSongName;
    private View mThumbnailContainer;
    private b searchSongActivityResult;
    private b selectLyricActivityResult;
    private b sharedNowplayingActivityResult;

    static {
        String s = Environment.getExternalStorageDirectory().getPath() + "/melon/nowplaying";
        NowPlayingAddFragment.CAPTURE_DIR_PATH = s;
        NowPlayingAddFragment.CAPTURE_FILE_NAME = s + "/nowplaying.jpeg";
    }

    public NowPlayingAddFragment() {
        this.mIsEditField = false;
        this.mExistLyric = false;
        this.searchSongActivityResult = this.registerForActivityResult(new f0(2), new M(this, 0));
        this.selectLyricActivityResult = this.registerForActivityResult(new f0(2), new M(this, 1));
        this.editIntroActivityResult = this.registerForActivityResult(new f0(2), new M(this, 2));
        this.sharedNowplayingActivityResult = this.registerForActivityResult(new f0(2), new M(this, 3));
        this.mAddSongListener = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                Intent intent0 = new Intent(NowPlayingAddFragment.this.getActivity(), SearchAndAddActivity.class);
                intent0.putExtra("argSearchViewType", 10);
                intent0.putExtra("argCallerType", (TextUtils.isEmpty(NowPlayingAddFragment.this.mNowPlaySeq) ? 12 : 13));
                NowPlayingAddFragment.this.searchSongActivityResult.b(intent0);
            }
        };
    }

    private void addNowPlaying() {
        ParamInfo insertNowPlayingReq$ParamInfo0 = new ParamInfo();
        insertNowPlayingReq$ParamInfo0.memberKey = u.v(((e0)o.a()).j());
        insertNowPlayingReq$ParamInfo0.artistId = "";
        insertNowPlayingReq$ParamInfo0.songId = this.mSongId;
        insertNowPlayingReq$ParamInfo0.introCont = this.mIntroduce.getText().toString();
        insertNowPlayingReq$ParamInfo0.selLyricsFirst = this.mLyricView1.getText().toString();
        insertNowPlayingReq$ParamInfo0.selLyricsSecond = this.mLyricView2.getText().toString();
        this.showProgress(true);
        RequestBuilder.newInstance(new InsertNowPlayingReq(this.getContext(), insertNowPlayingReq$ParamInfo0)).tag("NowPlayingAddFragment").listener(new Listener() {
            public void onResponse(HttpResponse httpResponse0) {
                NowPlayingAddFragment.this.showProgress(false);
                if(httpResponse0.isSuccessful()) {
                    NowPlayingAddFragment.q0(NowPlayingAddFragment.this);
                    NowPlayingAddFragment.y0(NowPlayingAddFragment.this);
                    NowPlayingAddFragment.z0(NowPlayingAddFragment.this);
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((HttpResponse)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                NowPlayingAddFragment.this.performFetchCompleteOnlyViews();
            }
        }).request();
    }

    private boolean captureNowplayingImage() {
        FileOutputStream fileOutputStream0;
        Bitmap bitmap0 = ViewUtils.getViewCapture(this.mThumbnailContainer);
        if(bitmap0 == null) {
            LogU.e("NowPlayingAddFragment", "Invalid bitmap");
            this.performBackPress();
            return false;
        }
        File file0 = new File(NowPlayingAddFragment.CAPTURE_DIR_PATH);
        if(!file0.exists()) {
            file0.mkdirs();
        }
        File file1 = new File(NowPlayingAddFragment.CAPTURE_FILE_NAME);
        try {
            if(file1.exists()) {
                file1.delete();
            }
            file1.createNewFile();
            fileOutputStream0 = null;
        }
        catch(IOException unused_ex) {
            LogU.e("NowPlayingAddFragment", "Invalid file path");
            return false;
        }
        try {
            fileOutputStream0 = new FileOutputStream(file1);
            bitmap0.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream0);
        }
        catch(Exception unused_ex) {
            if(fileOutputStream0 != null) {
                try {
                    fileOutputStream0.close();
                    return false;
                }
                catch(IOException unused_ex) {
                }
            }
            return false;
        }
        catch(Throwable throwable0) {
            if(fileOutputStream0 != null) {
                try {
                    fileOutputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            throw throwable0;
        }
        try {
            fileOutputStream0.close();
            return true;
        }
        catch(IOException unused_ex) {
            return false;
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    public static void d0(NowPlayingAddFragment nowPlayingAddFragment0, ActivityResult activityResult0) {
        nowPlayingAddFragment0.lambda$new$3(activityResult0);
    }

    public static void e0(NowPlayingAddFragment nowPlayingAddFragment0, ActivityResult activityResult0) {
        nowPlayingAddFragment0.lambda$new$1(activityResult0);
    }

    public static void f0(NowPlayingAddFragment nowPlayingAddFragment0, ActivityResult activityResult0) {
        nowPlayingAddFragment0.lambda$new$0(activityResult0);
    }

    private boolean fetchNowPlayingInform() {
        Context context0 = this.getContext();
        boolean z = a.e(300000L, this.getCacheKey(), context0);
        if(this.mInformRes == null && !z) {
            RESPONSE informNowPlayingRes$RESPONSE0 = this.fetchNowPlayingInformData();
            this.mInformRes = informNowPlayingRes$RESPONSE0;
            if(informNowPlayingRes$RESPONSE0 != null) {
                this.mOrgSongId = informNowPlayingRes$RESPONSE0.songId;
            }
        }
        RESPONSE informNowPlayingRes$RESPONSE1 = this.mInformRes;
        if(informNowPlayingRes$RESPONSE1 != null) {
            this.mSongId = informNowPlayingRes$RESPONSE1.songId;
            this.fetchSongInfo(true, false);
            return false;
        }
        RequestBuilder.newInstance(new InformNowPlayingReq(this.getContext(), this.mNowPlaySeq)).tag("NowPlayingAddFragment").listener(new Listener() {
            public void onResponse(InformNowPlayingRes informNowPlayingRes0) {
                if(!NowPlayingAddFragment.this.prepareFetchComplete(informNowPlayingRes0, true)) {
                    return;
                }
                String s = NowPlayingAddFragment.this.getCacheKey();
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(com.iloen.melon.responsecache.b.a(s, informNowPlayingRes0.response, false, System.currentTimeMillis()));
                a.b(NowPlayingAddFragment.this.getContext(), NowPlayingAddFragment.this.getCacheKey(), arrayList0, true);
                NowPlayingAddFragment.p0(NowPlayingAddFragment.this, informNowPlayingRes0.response);
                NowPlayingAddFragment.r0(NowPlayingAddFragment.this, NowPlayingAddFragment.j0(NowPlayingAddFragment.this).songId);
                NowPlayingAddFragment.s0(NowPlayingAddFragment.this, NowPlayingAddFragment.j0(NowPlayingAddFragment.this).songId);
                NowPlayingAddFragment.v0(NowPlayingAddFragment.this);
                NowPlayingAddFragment.this.performFetchCompleteOnlyViews();
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((InformNowPlayingRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private RESPONSE fetchNowPlayingInformData() {
        Cursor cursor0 = a.f(this.getContext(), this.getCacheKey());
        if(cursor0 == null) {
            LogU.w("NowPlayingAddFragment", "Invalid cursor");
            return null;
        }
        InformNowPlayingRes informNowPlayingRes0 = (InformNowPlayingRes)a.d(cursor0, InformNowPlayingRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(informNowPlayingRes0 == null) {
            LogU.w("NowPlayingAddFragment", "Failed to extract contents");
            return null;
        }
        return informNowPlayingRes0.response;
    }

    private boolean fetchSongInfo(boolean z, boolean z1) {
        this.mOrgSongId = this.mSongId;
        Context context0 = this.getContext();
        if(!a.e(300000L, this.getSongInfoCacheKey(), context0)) {
            com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE nowplayingInformSongInfoRes$RESPONSE0 = this.fetchSongInfoData();
            if(nowplayingInformSongInfoRes$RESPONSE0 != null) {
                this.updateHeaderView(nowplayingInformSongInfoRes$RESPONSE0, z1);
                return false;
            }
        }
        RequestBuilder.newInstance(new NowplayingInformSongInfoReq(this.getContext(), this.mSongId)).tag("NowPlayingAddFragment").listener(new Listener() {
            public void onResponse(NowplayingInformSongInfoRes nowplayingInformSongInfoRes0) {
                if(!z || NowPlayingAddFragment.this.prepareFetchComplete(nowplayingInformSongInfoRes0, true)) {
                    if(nowplayingInformSongInfoRes0.isSuccessful(false)) {
                        String s = NowPlayingAddFragment.w0(NowPlayingAddFragment.this);
                        ArrayList arrayList0 = new ArrayList();
                        arrayList0.add(com.iloen.melon.responsecache.b.a(s, nowplayingInformSongInfoRes0, false, System.currentTimeMillis()));
                        a.b(NowPlayingAddFragment.this.getContext(), s, arrayList0, true);
                        NowPlayingAddFragment.this.updateHeaderView(nowplayingInformSongInfoRes0.response, z1);
                    }
                    if(z) {
                        NowPlayingAddFragment.this.performFetchCompleteOnlyViews();
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((NowplayingInformSongInfoRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                if(z) {
                    NowPlayingAddFragment.this.performFetchError(volleyError0);
                }
            }
        }).request();
        return true;
    }

    private com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE fetchSongInfoData() {
        Cursor cursor0 = a.f(this.getContext(), this.getSongInfoCacheKey());
        if(cursor0 != null && cursor0.getCount() != 0) {
            com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE nowplayingInformSongInfoRes$RESPONSE0 = (com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE)a.d(cursor0, com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE.class);
            if(!cursor0.isClosed()) {
                cursor0.close();
            }
            if(nowplayingInformSongInfoRes$RESPONSE0 == null) {
                LogU.w("NowPlayingAddFragment", "Failed to extract contents");
                return null;
            }
            return nowplayingInformSongInfoRes$RESPONSE0;
        }
        LogU.w("NowPlayingAddFragment", "Invalid cursor");
        return null;
    }

    public static void g0(NowPlayingAddFragment nowPlayingAddFragment0, ActivityResult activityResult0) {
        nowPlayingAddFragment0.lambda$new$2(activityResult0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.b.buildUpon().appendPath("nowPlayingInform").appendQueryParameter("nowPlayingSeq", this.mNowPlaySeq).build().toString();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public int getItemCount() {
        return 1;
    }

    private String getSongInfoCacheKey() {
        return Uri.withAppendedPath(MelonContentUris.b, "editNowplayingSongId" + this.mSongId).toString();
    }

    private boolean isInputCompleted() {
        String s = this.mIntroduce.getText().toString();
        String s1 = this.mLyricView1.getText().toString();
        String s2 = this.mLyricView2.getText().toString();
        return this.mInformRes != null && !TextUtils.isEmpty(this.mSongId) && !s.isEmpty() && s1.trim().length() > 0 && s2.trim().length() > 0;
    }

    public static RESPONSE j0(NowPlayingAddFragment nowPlayingAddFragment0) {
        return nowPlayingAddFragment0.mInformRes;
    }

    private void lambda$new$0(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                ArrayList arrayList0 = intent0.getParcelableArrayListExtra("argSearchResultValues");
                if(arrayList0 != null && arrayList0.size() > 0) {
                    this.mSongId = ((Playable)arrayList0.get(0)).getSongidString();
                    if(this.mInformRes == null) {
                        this.mInformRes = new RESPONSE();
                    }
                    this.mInformRes.songId = this.mSongId;
                    this.mInformRes.selLyricsSecond = null;
                    this.mInformRes.selLyricsFirst = null;
                    this.mLyricView1.setText(null);
                    this.mLyricView2.setText(null);
                    this.mSelectedLyric.setText(null);
                    this.fetchSongInfo(false, true);
                }
            }
        }
    }

    private void lambda$new$1(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                String s = intent0.getStringExtra("argFirstSelectedLyric");
                String s1 = intent0.getStringExtra("argSecondSelectedLyric");
                if(this.mInformRes == null) {
                    this.mInformRes = new RESPONSE();
                }
                this.mInformRes.selLyricsFirst = s;
                this.mInformRes.selLyricsSecond = s1;
                this.mLyricView1.setText(s);
                this.mLyricView2.setText(s1);
                this.mSelectedLyric.setText(s);
                this.mIsEditField = true;
                this.updateTitleButton();
            }
        }
    }

    private void lambda$new$2(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                String s = intent0.getStringExtra("arg_text_result_values");
                if(this.mInformRes == null) {
                    this.mInformRes = new RESPONSE();
                }
                this.mInformRes.introCont = s;
                this.mIntroduce.setText(s);
                this.mIsEditField = true;
                this.updateTitleButton();
            }
        }
    }

    private void lambda$new$3(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            this.mIsEditField = false;
            this.performBackPress();
        }
    }

    public static NowPlayingAddFragment newInstance() {
        NowPlayingAddFragment nowPlayingAddFragment0 = new NowPlayingAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("argIsEditField", false);
        nowPlayingAddFragment0.setArguments(bundle0);
        return nowPlayingAddFragment0;
    }

    public static NowPlayingAddFragment newInstance(String s) {
        NowPlayingAddFragment nowPlayingAddFragment0 = new NowPlayingAddFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argSongId", s);
        nowPlayingAddFragment0.setArguments(bundle0);
        return nowPlayingAddFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        if(!this.mIsEditField) {
            return false;
        }
        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(this.getActivity(), 1, "안내", "작성을 취소 하시겠습니까?\n\n지금 돌아가면 입력하신 내용이 삭제됩니다.", new DialogInterface.OnClickListener() {
            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface dialogInterface0, int v) {
                if(v == -1) {
                    NowPlayingAddFragment.q0(NowPlayingAddFragment.this);
                    NowPlayingAddFragment.this.performBackPress();
                }
            }
        });
        melonTextPopup0.setOnDismissListener(this.mDialogDismissListener);
        this.mRetainDialog = melonTextPopup0;
        melonTextPopup0.show();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.mAlbumImageWidth = ScreenUtils.dipToPixel(this.getContext(), 189.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0586, viewGroup0, false);  // layout:nowplaying_edit
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(!TextUtils.isEmpty(this.mNowPlaySeq)) {
            return this.fetchNowPlayingInform();
        }
        return TextUtils.isEmpty(this.mSongId) || this.mSongId.equals(this.mOrgSongId) ? false : this.fetchSongInfo(true, true);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mNowPlaySeq = bundle0.getString("argNowPlaySeq");
        this.mSongId = bundle0.getString("argSongId");
        this.mOrgSongId = bundle0.getString("argOrgSongId");
        this.mIsEditField = bundle0.getBoolean("argIsEditField");
        this.mInformRes = (RESPONSE)CompatUtils.getSerializable(bundle0, "argNowplayingInformRes", RESPONSE.class);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argSongId", this.mSongId);
            bundle0.putString("argOrgSongId", this.mOrgSongId);
            bundle0.putString("argNowPlaySeq", this.mNowPlaySeq);
            bundle0.putBoolean("argIsEditField", this.mIsEditField);
            RESPONSE informNowPlayingRes$RESPONSE0 = this.mInformRes;
            if(informNowPlayingRes$RESPONSE0 != null) {
                bundle0.putSerializable("argNowplayingInformRes", informNowPlayingRes$RESPONSE0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            p p0 = new p(1);
            m m0 = new m(2, false);
            B b0 = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.completeButton = b0;
            b0.c = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    if(NowPlayingAddFragment.this.isInputCompleted()) {
                        if(!TextUtils.isEmpty(NowPlayingAddFragment.this.mNowPlaySeq)) {
                            NowPlayingAddFragment.this.updateNowPlaying();
                            return;
                        }
                        NowPlayingAddFragment.this.addNowPlaying();
                    }
                }
            };
            F8.o[] arr_o = {p0, m0, this.completeButton};
            F8.o o0 = null;
            for(int v = 0; v < 3; ++v) {
                F8.o o1 = arr_o[v];
                if(o0 == null) {
                    o0 = o1;
                }
                else {
                    o0.g(o1);
                }
            }
            titleBar0.a(o0);
            titleBar0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
            titleBar0.setTitle(this.getString(0x7F13014B));  // string:artist_info_now_playing_edit_title "#NOWPLAYING 만들기"
            titleBar0.f(true);
            B b1 = this.completeButton;
            Context context0 = this.getContext();
            b1.getClass();
            q.g(context0, "context");
            b1.j(context0, 3);
        }
        View view1 = this.findViewById(0x7F0A08A5);  // id:network_error_layout
        this.mEmptyView = view1;
        if(view1 != null) {
            view1.setVisibility(8);
        }
        this.mThumbnailContainer = this.findViewById(0x7F0A0B84);  // id:thumbnail_container
        this.mDefaultContainer = this.findViewById(0x7F0A0397);  // id:default_container
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A013B), this.mAddSongListener);  // id:btn_add
        this.mSongInfoContainer = this.findViewById(0x7F0A0AAA);  // id:song_info_container
        this.mCoverImage = (ImageView)this.findViewById(0x7F0A0351);  // id:cover_image
        this.mSongName = (TextView)this.findViewById(0x7F0A0AAF);  // id:song_name
        this.mArtistName = (TextView)this.findViewById(0x7F0A00B8);  // id:artist_name
        this.mAlbumImage = (ImageView)this.findViewById(0x7F0A0085);  // id:album_image
        this.mLyricView1 = (TextView)this.findViewById(0x7F0A07B8);  // id:lyric1
        this.mLyricView2 = (TextView)this.findViewById(0x7F0A07B9);  // id:lyric2
        View view2 = this.findViewById(0x7F0A01AB);  // id:btn_select_song
        this.mBtnSelectSong = view2;
        ViewUtils.setOnClickListener(view2, this.mAddSongListener);
        this.mSeparator = this.findViewById(0x7F0A0A6A);  // id:separator1
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A01AA), new View.OnClickListener() {  // id:btn_select_lyric
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(TextUtils.isEmpty(NowPlayingAddFragment.this.mSongId)) {
                    return;
                }
                if(!NowPlayingAddFragment.this.mExistLyric) {
                    MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(NowPlayingAddFragment.this.getActivity(), 0, "안내", "선택하신 곡은 가사 선택을\n지원하지 않습니다.", null);
                    melonTextPopup0.setOnDismissListener(NowPlayingAddFragment.this.mDialogDismissListener);
                    NowPlayingAddFragment.this.mRetainDialog = melonTextPopup0;
                    melonTextPopup0.show();
                    return;
                }
                Intent intent0 = new Intent(NowPlayingAddFragment.this.getActivity(), SelectLyricActivity.class);
                intent0.putExtra("argSongId", NowPlayingAddFragment.this.mSongId);
                NowPlayingAddFragment.this.selectLyricActivityResult.b(intent0);
            }
        });
        this.mSelectedLyric = (TextView)this.findViewById(0x7F0A0A5F);  // id:selected_lyric
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A016A), new View.OnClickListener() {  // id:btn_intro
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                Intent intent0 = new Intent(NowPlayingAddFragment.this.getActivity(), EditIntroductionActivity.class);
                intent0.putExtra("arg_text_value", NowPlayingAddFragment.this.mIntroduce.getText().toString());
                NowPlayingAddFragment.this.editIntroActivityResult.b(intent0);
            }
        });
        this.mIntroduce = (TextView)this.findViewById(0x7F0A058F);  // id:introduce
    }

    public static void p0(NowPlayingAddFragment nowPlayingAddFragment0, RESPONSE informNowPlayingRes$RESPONSE0) {
        nowPlayingAddFragment0.mInformRes = informNowPlayingRes$RESPONSE0;
    }

    public static void q0(NowPlayingAddFragment nowPlayingAddFragment0) {
        nowPlayingAddFragment0.mIsEditField = false;
    }

    public static void r0(NowPlayingAddFragment nowPlayingAddFragment0, String s) {
        nowPlayingAddFragment0.mOrgSongId = s;
    }

    private void removeChannelCacheKey() {
        TimeExpiredCache.getInstance().removeLike(MelonContentUris.b.buildUpon().appendPath("").build().toString());
    }

    public static void s0(NowPlayingAddFragment nowPlayingAddFragment0, String s) {
        nowPlayingAddFragment0.mSongId = s;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private void showCompletePopup() {
        if(this.mRetainDialog != null && this.mRetainDialog.isShowing()) {
            this.mRetainDialog.setOnDismissListener(null);
            this.mRetainDialog.dismiss();
        }
        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(this.getActivity(), 0, "안내", "작성이 완료 되었습니다.\n\n다른 SNS에도 #NOWPLAYING해 보세요.", null);
        melonTextPopup0.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                if(dialogInterface0.equals(NowPlayingAddFragment.this.mRetainDialog)) {
                    NowPlayingAddFragment.this.mRetainDialog = null;
                }
                if(NowPlayingAddFragment.u0(NowPlayingAddFragment.this)) {
                    NowPlayingAddFragment.this.showShareNowplaying();
                }
            }
        });
        this.mRetainDialog = melonTextPopup0;
        melonTextPopup0.show();
    }

    private void showShareNowplaying() {
        File file0 = new File(NowPlayingAddFragment.CAPTURE_FILE_NAME);
        if(file0.exists()) {
            Intent intent0 = new Intent("android.intent.action.SEND");
            intent0.setType("image/*");
            intent0.putExtra("android.intent.extra.STREAM", FileUtils.getFileUri(this.getContext(), file0));
            this.sharedNowplayingActivityResult.b(Intent.createChooser(intent0, this.getString(0x7F130151)));  // string:artist_info_share "공유"
        }
    }

    public static boolean u0(NowPlayingAddFragment nowPlayingAddFragment0) {
        return nowPlayingAddFragment0.captureNowplayingImage();
    }

    private void updateHeaderView(com.iloen.melon.net.v4x.response.NowplayingInformSongInfoRes.RESPONSE nowplayingInformSongInfoRes$RESPONSE0, boolean z) {
        if(nowplayingInformSongInfoRes$RESPONSE0 != null && nowplayingInformSongInfoRes$RESPONSE0.songinfo != null) {
            this.mIsEditField = true;
            this.mExistLyric = !TextUtils.isEmpty(nowplayingInformSongInfoRes$RESPONSE0.lyric);
            SONGINFO nowplayingInformSongInfoRes$RESPONSE$SONGINFO0 = nowplayingInformSongInfoRes$RESPONSE0.songinfo;
            ViewUtils.showWhen(this.mThumbnailContainer, true);
            ViewUtils.showWhen(this.mDefaultContainer, false);
            ViewUtils.showWhen(this.mSongInfoContainer, true);
            ViewUtils.showWhen(this.mBtnSelectSong, true);
            ViewUtils.showWhen(this.mSeparator, true);
            if(this.mInformRes == null) {
                this.mInformRes = new RESPONSE();
            }
            this.mInformRes.songId = nowplayingInformSongInfoRes$RESPONSE$SONGINFO0.songId;
            this.mInformRes.albumImg = nowplayingInformSongInfoRes$RESPONSE$SONGINFO0.albumImg;
            this.mInformRes.albumImgLarge = nowplayingInformSongInfoRes$RESPONSE$SONGINFO0.albumImgLarge;
            this.mInformRes.songName = nowplayingInformSongInfoRes$RESPONSE$SONGINFO0.songName;
            if(z && this.mExistLyric && !TextUtils.isEmpty(nowplayingInformSongInfoRes$RESPONSE0.lyric)) {
                new ArrayList();
                String[] arr_s = nowplayingInformSongInfoRes$RESPONSE0.lyric.split("\\n");
                if(arr_s.length > 0) {
                    this.mInformRes.selLyricsFirst = arr_s[0];
                }
                if(arr_s.length > 1) {
                    this.mInformRes.selLyricsSecond = arr_s[1];
                }
            }
            RESPONSE informNowPlayingRes$RESPONSE0 = this.mInformRes;
            if(informNowPlayingRes$RESPONSE0.artistList == null) {
                informNowPlayingRes$RESPONSE0.artistList = new ArrayList();
            }
            this.mInformRes.artistList.clear();
            if(nowplayingInformSongInfoRes$RESPONSE$SONGINFO0.artistList != null && !nowplayingInformSongInfoRes$RESPONSE$SONGINFO0.artistList.isEmpty()) {
                this.mInformRes.artistList.addAll(nowplayingInformSongInfoRes$RESPONSE$SONGINFO0.artistList);
            }
            this.mSongId = this.mInformRes.songId;
            Context context0 = this.getContext();
            if(context0 != null) {
                ImageView imageView0 = this.mCoverImage;
                if(imageView0 != null) {
                    imageView0.setImageDrawable(null);
                    Glide.with(context0).load(this.mInformRes.albumImgLarge).into(this.mCoverImage);
                }
            }
            this.mSongName.setText(this.mInformRes.songName);
            this.mArtistName.setText(ProtocolUtils.getArtistNames(this.mInformRes.artistList));
            if(context0 != null && this.mAlbumImage != null) {
                Glide.with(context0).load(this.mInformRes.albumImgLarge).apply(RequestOptions.circleCropTransform()).into(this.mAlbumImage);
            }
            this.mLyricView1.setText(this.mInformRes.selLyricsFirst);
            this.mLyricView2.setText(this.mInformRes.selLyricsSecond);
            this.mSelectedLyric.setText(this.mInformRes.selLyricsFirst);
            this.mIntroduce.setText(this.mInformRes.introCont);
            this.updateTitleButton();
        }
    }

    private void updateNowPlaying() {
        com.iloen.melon.net.v4x.request.UpdateNowPlayingReq.ParamInfo updateNowPlayingReq$ParamInfo0 = new com.iloen.melon.net.v4x.request.UpdateNowPlayingReq.ParamInfo();
        updateNowPlayingReq$ParamInfo0.memberKey = u.v(((e0)o.a()).j());
        updateNowPlayingReq$ParamInfo0.artistId = "";
        updateNowPlayingReq$ParamInfo0.nowPlaySeq = this.mNowPlaySeq;
        updateNowPlayingReq$ParamInfo0.songId = this.mSongId;
        updateNowPlayingReq$ParamInfo0.introCont = this.mIntroduce.getText().toString();
        updateNowPlayingReq$ParamInfo0.selLyricsFirst = this.mLyricView1.getText().toString();
        updateNowPlayingReq$ParamInfo0.selLyricsSecond = this.mLyricView2.getText().toString();
        updateNowPlayingReq$ParamInfo0.songIdModYn = TextUtils.isEmpty(this.mSongId) || this.mSongId.equals(this.mOrgSongId) ? "N" : "Y";
        RequestBuilder.newInstance(new UpdateNowPlayingReq(this.getContext(), updateNowPlayingReq$ParamInfo0)).tag("NowPlayingAddFragment").listener(new Listener() {
            public void onResponse(HttpResponse httpResponse0) {
                NowPlayingAddFragment.q0(NowPlayingAddFragment.this);
                if(httpResponse0.isSuccessful()) {
                    a.c(NowPlayingAddFragment.this.getContext(), NowPlayingAddFragment.this.getCacheKey(), true);
                    Context context0 = NowPlayingAddFragment.this.getContext();
                    String s = MelonContentUris.R0.toString();
                    if(context0 == null) {
                        LogU.w("ResponseCacheHelper", "deleteLikeKey() invalid context");
                    }
                    else {
                        e e0 = w9.a.a;
                        MelonDb melonDb0 = e0.h();
                        if(melonDb0 != null) {
                            melonDb0.deleteLikeKeyResponseCache(s);
                            e0.d();
                        }
                    }
                }
                NowPlayingAddFragment.y0(NowPlayingAddFragment.this);
                NowPlayingAddFragment.z0(NowPlayingAddFragment.this);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((HttpResponse)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private void updateTitleButton() {
        if(this.getTitleBar() == null) {
            return;
        }
        if(this.isInputCompleted()) {
            B b0 = this.completeButton;
            Context context0 = this.getContext();
            b0.getClass();
            q.g(context0, "context");
            b0.j(context0, 0);
            return;
        }
        B b1 = this.completeButton;
        Context context1 = this.getContext();
        b1.getClass();
        q.g(context1, "context");
        b1.j(context1, 3);
    }

    public static void v0(NowPlayingAddFragment nowPlayingAddFragment0) {
        nowPlayingAddFragment0.fetchSongInfo(true, false);
    }

    public static String w0(NowPlayingAddFragment nowPlayingAddFragment0) {
        return nowPlayingAddFragment0.getSongInfoCacheKey();
    }

    public static void y0(NowPlayingAddFragment nowPlayingAddFragment0) {
        nowPlayingAddFragment0.removeChannelCacheKey();
    }

    public static void z0(NowPlayingAddFragment nowPlayingAddFragment0) {
        nowPlayingAddFragment0.showCompletePopup();
    }
}

