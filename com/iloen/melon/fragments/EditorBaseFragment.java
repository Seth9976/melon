package com.iloen.melon.fragments;

import E9.w;
import F8.B;
import F8.m;
import F8.o;
import F8.p;
import H0.b;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.android.volley.Response.Listener;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.AlphaControlButton;
import com.iloen.melon.custom.FlowLayout;
import com.iloen.melon.custom.M;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v6x.request.DjTagSearchAutoCompleteReq;
import com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes.RESPONSE;
import com.iloen.melon.net.v6x.response.DjTagSearchAutoCompleteRes;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TagParser.OnParsedListener;
import com.iloen.melon.utils.TagParser.TagPos;
import com.iloen.melon.utils.TagParser;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import d5.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import v9.h;
import v9.i;

public abstract class EditorBaseFragment extends MetaContentBaseFragment implements View.OnClickListener {
    static class ItemViewHolder extends O0 {
        private TextView playlistCount;
        private TextView tagName;

        public ItemViewHolder(View view0) {
            super(view0);
            this.tagName = (TextView)view0.findViewById(0x7F0A0B29);  // id:tag_name
            this.playlistCount = (TextView)view0.findViewById(0x7F0A0934);  // id:playlist_count
        }
    }

    class TagHandler extends U0 {
        public TagHandler(EditorBaseFragment editorBaseFragment1) {
            super(editorBaseFragment1);
        }

        public void handleMessage(MelonBaseFragment melonBaseFragment0, Message message0) {
            if(message0.what == 5000) {
                if(EditorBaseFragment.this.mTagHandler.hasMessages(5000)) {
                    EditorBaseFragment.this.mTagHandler.removeMessages(5000);
                    Message message1 = EditorBaseFragment.this.mTagHandler.obtainMessage(message0.what, message0.arg1, message0.arg2, message0.obj);
                    EditorBaseFragment.this.mTagHandler.sendMessageDelayed(message1, 100L);
                    return;
                }
                String s = EditorBaseFragment.this.mEtTextContent.getText().toString();
                EditorBaseFragment.this.mTagParser.parse(s);
                Editable editable0 = EditorBaseFragment.this.mEtTextContent.getText();
                EditorBaseFragment.this.mTagParser.syncWithSpannable(editable0);
                EditorBaseFragment.this.resetTagUi();
                String s1 = (String)message0.obj;
                if("#".equals(s1)) {
                    int v = EditorBaseFragment.this.mEtTextContent.getSelectionEnd();
                    if(EditorBaseFragment.this.mTagParser.getTagInnerPos(v) != null) {
                        EditorBaseFragment.this.updateRecommendTagUi();
                        EditorBaseFragment.this.updateLatelyTagUi();
                    }
                }
                else if(!" ".equals(s1)) {
                    TagPos tagParser$TagPos0 = EditorBaseFragment.this.mTagParser.getTagInnerPos(message0.arg1);
                    if(tagParser$TagPos0 != null) {
                        EditorBaseFragment.this.showAutoCompleteTagList(tagParser$TagPos0.tagName);
                    }
                }
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((MelonBaseFragment)object0), message0);
        }
    }

    class TagListAdapter extends y {
        private String mCurrentTagName;

        public TagListAdapter(Context context0, ArrayList arrayList0) {
            super(context0, arrayList0);
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            if(!(o00 instanceof ItemViewHolder)) {
                return;
            }
            TagInfoBase tagInfoBase0 = (TagInfoBase)this.getItem(v1);
            String s = "#" + tagInfoBase0.tagName;
            SpannableString spannableString0 = new SpannableString(s);
            int v2 = s.indexOf(this.mCurrentTagName);
            if(v2 > 0) {
                int v3 = this.mCurrentTagName.length() + v2;
                LogU.d("EditorBaseFragment", "TagListAdapter >> onBindViewHolder() >> [Spann Pos] begin: " + v2 + ", end: " + v3);
                spannableString0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06017C)), v2, v3, 33);  // color:green500s_support_high_contrast
            }
            ((ItemViewHolder)o00).tagName.setText(spannableString0);
            if(tagInfoBase0 instanceof TAGLIST) {
                ((ItemViewHolder)o00).playlistCount.setText(StringUtils.getCountString(((TAGLIST)tagInfoBase0).plylstcnt, -1));
            }
            com.iloen.melon.fragments.EditorBaseFragment.TagListAdapter.1 editorBaseFragment$TagListAdapter$10 = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    TagInfoBase tagInfoBase0 = tagInfoBase0;
                    if(tagInfoBase0 != null) {
                        String s = tagInfoBase0.tagName;
                        if(s != null) {
                            LogU.d("EditorBaseFragment", "TagListAdapter >> Tag Clicked >> tagName: " + s);
                            EditorBaseFragment.this.replaceTagToCurrentTag(s);
                        }
                    }
                }
            };
            ViewUtils.setOnClickListener(((ItemViewHolder)o00).itemView, editorBaseFragment$TagListAdapter$10);
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return new ItemViewHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04E7, viewGroup0, false));  // layout:melondj_auto_complete_tag_list_item
        }

        public void setTagList(ArrayList arrayList0, String s) {
            if(!TextUtils.isEmpty(s)) {
                this.mCurrentTagName = s.replace("#", "");
                Z.x(new StringBuilder("TagListAdapter >> setTagList() >> mCurrentTagName: "), this.mCurrentTagName, "EditorBaseFragment");
            }
            this.clear();
            this.addAll(arrayList0);
            this.notifyDataSetChanged();
        }
    }

    public static final String ARG_CONTENT_TEXT = "argContentText";
    public static final String ARG_TAG_LIST = "argTagList";
    public static final String ARG_TITLE_TEXT = "argTitleText";
    private static final int DELAY_TIME_MSG_TAG_CHECK = 100;
    public static final int LATELY_TAG_LIST_MAX = 10;
    private static final int LINE_COUNT_LIMIT_DEFAULT = 1000;
    private static final int MSG_TAG_CHECK = 5000;
    private static final String TAG = "EditorBaseFragment";
    private static final int TEXT_COUNT_LIMIT_DEFAULT = 1000;
    private B completeButton;
    private boolean isBlock;
    private AlphaControlButton mAcbDeleteText;
    private RecyclerView mAutoCompTagList;
    private TagListAdapter mAutoCompTagListAdapter;
    private boolean mBoolTagEnable;
    private MelonEditText mEtTextContent;
    private FlowLayout mFlRecommendTag;
    protected int mLastY;
    private LinkedHashMap mLatelyTagHashMap;
    private ArrayList mLatelyTagItemViewArray;
    private FrameLayout mLayoutAutoCompleteTag;
    private ConstraintLayout mLayoutInput;
    private RelativeLayout mLayoutLatelyTag;
    private LinearLayout mLayoutLatelyTagListContainer;
    private RelativeLayout mLayoutRecommendTag;
    private LinearLayout mLayoutTag;
    private LinearLayout mLayoutTextCountingSub;
    private int mLineCountLimit;
    private ArrayList mRecommendTagArray;
    private ScrollView mSvTagLayout;
    private TagHandler mTagHandler;
    private TagParser mTagParser;
    private int mTextCountLimit;
    private TextWatcher mTextWatcher;
    protected TitleBar mTitleBarLayout;
    private TextView mTvGuideText;
    private TextView mTvTextCount;
    private TextView mTvTextCountLimit;
    private View mViewTagSplitLine;

    public EditorBaseFragment() {
        this.mTextCountLimit = 1000;
        this.mLineCountLimit = 1000;
        this.mTagHandler = new TagHandler(this, this);
        this.mBoolTagEnable = false;
        this.isBlock = false;
    }

    public void buildTitleLayout() {
        p p0 = new p(1);
        p0.c = (/* 缺少LAMBDA参数 */) -> {
            EditorBaseFragment.this.setInputMethodVisibility(false);
            EditorBaseFragment.this.performBackPress();
        };
        m m0 = new m(2, false);
        B b0 = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.completeButton = b0;
        b0.h(this.getString(0x7F130C1E));  // string:talkback_registration_btn "등록 버튼"
        B b1 = this.completeButton;
        b1.c = (/* 缺少LAMBDA参数 */) -> ;;
        TitleBar titleBar0 = this.mTitleBarLayout;
        o[] arr_o = {p0, m0, this.completeButton};
        o o0 = null;
        for(int v = 0; v < 3; ++v) {
            o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        titleBar0.a(o0);
        this.mTitleBarLayout.f(true);

        class com.iloen.melon.fragments.EditorBaseFragment.4 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                EditorBaseFragment.this.onLeftButtonCliked();
            }
        }


        class com.iloen.melon.fragments.EditorBaseFragment.5 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                EditorBaseFragment.this.onRightButtonClicked();
            }
        }

    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    public ConstraintLayout getLayoutInput() {
        return this.mLayoutInput;
    }

    public String getTextContent() {
        return this.mEtTextContent.getText().toString().trim();
    }

    private void insertTagToContent(String s) {
        int v = this.mEtTextContent.getSelectionEnd();
        if(this.mTagParser.getTagInnerPos(v) == null) {
            return;
        }
        int v1 = Math.max(this.mEtTextContent.getSelectionStart(), 0);
        int v2 = Math.max(this.mEtTextContent.getSelectionEnd(), 0);
        this.mEtTextContent.getText().replace(Math.min(v1, v2), Math.max(v1, v2), s, 0, s.length());
    }

    private boolean lambda$onViewCreated$0(View view0, int v, KeyEvent keyEvent0) {
        return v == 66 && this.isBlock;
    }

    private void lambda$onViewCreated$1() {
        this.setInputMethodVisibility(true);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        switch(view0.getId()) {
            case 0x7F0A0029: {  // id:acbDelete
                String s = (String)view0.getTag();
                this.mLatelyTagHashMap.remove(s);
                MelonDetailInfoUtils.removeDjPlaylistLatelyTag(s);
                this.updateLatelyTagUi();
                return;
            }
            case 0x7F0A06E1: {  // id:layoutItemContainer
                this.insertTagToContent(((String)view0.getTag()).replace("#", ""));
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02AB, viewGroup0, false);  // layout:fragment_editor_base
    }

    public abstract void onEditorUISettingProc();

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        return false;
    }

    // 检测为 Lambda 实现
    public void onLeftButtonCliked() [...]

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    // 检测为 Lambda 实现
    public abstract void onRightButtonClicked();

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        view0.setOnClickListener((/* 缺少LAMBDA参数 */) -> {
            try {
                if(false) {
                    if(EditorBaseFragment.this.mEtTextContent != null) {
                        InputMethodUtils.showInputMethod(EditorBaseFragment.this.getContext(), EditorBaseFragment.this.mEtTextContent);
                        return;
                    }
                    return;
                }
                InputMethodUtils.hideInputMethod(EditorBaseFragment.this.getContext(), EditorBaseFragment.this.mEtTextContent);
                return;
            }
            catch(Exception exception0) {
            }
            b.v(exception0, new StringBuilder("setInputMethodVisibility() >> "), "EditorBaseFragment");
        });
        this.mLayoutInput = (ConstraintLayout)view0.findViewById(0x7F0A06DF);  // id:layoutInput
        this.mLayoutTag = (LinearLayout)this.findViewById(0x7F0A06EF);  // id:layoutTag
        this.mLayoutRecommendTag = (RelativeLayout)this.findViewById(0x7F0A06E8);  // id:layoutRecommendTag
        this.mLayoutLatelyTag = (RelativeLayout)this.findViewById(0x7F0A06E2);  // id:layoutLatelyTag
        this.mSvTagLayout = (ScrollView)this.findViewById(0x7F0A0B0A);  // id:svTagLayout
        this.mLayoutAutoCompleteTag = (FrameLayout)this.findViewById(0x7F0A06D9);  // id:layoutAutoCompleteTag
        this.mLayoutLatelyTagListContainer = (LinearLayout)this.findViewById(0x7F0A06E3);  // id:layoutLatelyTagListContainer
        this.mFlRecommendTag = (FlowLayout)this.findViewById(0x7F0A04BB);  // id:flRecommendTag
        this.mViewTagSplitLine = this.findViewById(0x7F0A0D8F);  // id:vTagSplitLine
        this.mTitleBarLayout = (TitleBar)this.findViewById(0x7F0A0BAD);  // id:titlebar
        MelonEditText melonEditText0 = (MelonEditText)this.findViewById(0x7F0A0450);  // id:etTextContent
        this.mEtTextContent = melonEditText0;
        melonEditText0.setTextLimit(MelonLimits.TextLimit.b);
        this.mEtTextContent.setOnKeyListener(new k(this));
        com.iloen.melon.fragments.EditorBaseFragment.2 editorBaseFragment$20 = new TextWatcher() {
            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
                if(EditorBaseFragment.this.mBoolTagEnable) {
                    int v = EditorBaseFragment.this.mEtTextContent.getSelectionEnd();
                    if(v > 0) {
                        String s = editable0.subSequence(v - 1, v).toString();
                        Z.w("afterTextChanged() >> token: ", s, "EditorBaseFragment");
                        Message message0 = EditorBaseFragment.this.mTagHandler.obtainMessage(5000, v - 1, v, s);
                        EditorBaseFragment.this.mTagHandler.sendMessageDelayed(message0, 100L);
                    }
                }
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                EditorBaseFragment.this.updateLayout();
                EditorBaseFragment.this.updateCompleteBtn(charSequence0.toString());
            }
        };
        this.mTextWatcher = editorBaseFragment$20;
        this.mEtTextContent.setTextWatcher(editorBaseFragment$20);
        AlphaControlButton alphaControlButton0 = (AlphaControlButton)this.findViewById(0x7F0A002A);  // id:acbDeleteText
        this.mAcbDeleteText = alphaControlButton0;
        ViewUtils.setOnClickListener(alphaControlButton0, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                EditorBaseFragment.this.mEtTextContent.setText("");
                EditorBaseFragment.this.updateLayout();
            }
        });
        this.mLayoutTextCountingSub = (LinearLayout)this.findViewById(0x7F0A06F1);  // id:layoutTextCountingSub
        this.mTvTextCount = (TextView)this.findViewById(0x7F0A0C00);  // id:tvTextCount
        TextView textView0 = (TextView)this.findViewById(0x7F0A0C01);  // id:tvTextCountLimit
        this.mTvTextCountLimit = textView0;
        textView0.setText(String.valueOf(this.mTextCountLimit));
        TextView textView1 = (TextView)this.findViewById(0x7F0A0BF7);  // id:tvGuideText
        this.mTvGuideText = textView1;
        ViewUtils.showWhen(textView1, true);
        this.buildTitleLayout();
        this.onEditorUISettingProc();
        new Handler(Looper.getMainLooper()).postDelayed(new l(this, 2), 300L);

        class com.iloen.melon.fragments.EditorBaseFragment.1 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                EditorBaseFragment.this.setInputMethodVisibility(false);
            }
        }

    }

    private void replaceTagToCurrentTag(String s) {
        int v = this.mEtTextContent.getSelectionEnd();
        TagPos tagParser$TagPos0 = this.mTagParser.getTagInnerPos(v);
        if(tagParser$TagPos0 != null) {
            int v1 = Math.max(tagParser$TagPos0.begin + 1, 0);
            int v2 = Math.max(this.mEtTextContent.getSelectionEnd(), 0);
            if(v1 <= v2) {
                try {
                    this.mEtTextContent.getText().replace(Math.min(v1, v2), Math.max(v1, v2), s, 0, s.length());
                    this.mEtTextContent.setSelection(v1 + s.length());
                    this.mEtTextContent.clearComposingText();
                }
                catch(Exception exception0) {
                    b.v(exception0, new StringBuilder("replaceTagToCurrentTag() >> "), "EditorBaseFragment");
                }
            }
        }
    }

    private void resetTagUi() {
        ViewUtils.showWhen(this.mSvTagLayout, false);
        ViewUtils.showWhen(this.mLayoutRecommendTag, false);
        ViewUtils.showWhen(this.mLayoutLatelyTag, false);
        ViewUtils.showWhen(this.mViewTagSplitLine, false);
        ViewUtils.showWhen(this.mLayoutAutoCompleteTag, false);
    }

    public void setCountTextColor(int v) {
        this.mTvTextCount.setTextColor(v);
    }

    public void setDeleteButtonVisibility(boolean z) {
        ViewUtils.showWhen(this.mAcbDeleteText, z);
    }

    public void setEditTextSize(float f) {
        this.mEtTextContent.setTextSize(1, f);
    }

    public void setEnterBlock(boolean z) {
        this.isBlock = z;
    }

    public void setEtTextBold() {
        this.mEtTextContent.setTypeface(f.F(this.getContext()));
    }

    public void setGuideText(String s) {
        this.mTvGuideText.setText(s);
    }

    public void setGuideText(String s, int v) {
        this.mTvGuideText.setTextColor(v);
        this.mTvGuideText.setText(s);
    }

    // 检测为 Lambda 实现
    public void setInputMethodVisibility(boolean z) [...]

    public void setLatelyTagArray(ArrayList arrayList0) {
        if(arrayList0 != null) {
            if(this.mLatelyTagHashMap == null) {
                this.mLatelyTagHashMap = new LinkedHashMap();
            }
            for(Object object0: arrayList0) {
                this.mLatelyTagHashMap.put(((String)object0), ((String)object0));
            }
        }
    }

    public void setRecommendTagArray(ArrayList arrayList0) {
        this.mRecommendTagArray = arrayList0;
    }

    public void setTagEnable(boolean z) {
        if(z) {
            this.mBoolTagEnable = true;
            this.mLatelyTagItemViewArray = new ArrayList();
            LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
            for(int v = 0; v < 10; ++v) {
                View view0 = layoutInflater0.inflate(0x7F0D0451, null);  // layout:list_item_dj_playlist_lately_tag
                view0.findViewById(0x7F0A0029).setOnClickListener(this);  // id:acbDelete
                view0.findViewById(0x7F0A06E1).setOnClickListener(this);  // id:layoutItemContainer
                view0.setVisibility(8);
                this.mLayoutLatelyTagListContainer.addView(view0);
                this.mLatelyTagItemViewArray.add(view0);
            }
            if(this.mTagParser == null) {
                this.mTagParser = new TagParser(this.getContext(), new OnParsedListener() {
                    @Override  // com.iloen.melon.utils.TagParser$OnParsedListener
                    public void onParseFailed(int v, String s) {
                        Z.r(v, "onParseFailed() >> resultCode: ", "EditorBaseFragment");
                    }

                    @Override  // com.iloen.melon.utils.TagParser$OnParsedListener
                    public void onParseSuccess(ArrayList arrayList0, SpannableString spannableString0, int v) {
                    }
                });
            }
            this.mAutoCompTagListAdapter = new TagListAdapter(this, this.getContext(), null);
            RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A0957);  // id:popup_list
            this.mAutoCompTagList = recyclerView0;
            recyclerView0.setHasFixedSize(true);
            this.mAutoCompTagList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
            this.mAutoCompTagList.setAdapter(this.mAutoCompTagListAdapter);
            ViewUtils.showWhen(this.mLayoutTag, true);
            return;
        }
        ViewUtils.showWhen(this.mLayoutTag, false);
    }

    public void setTagLayoutEnable(boolean z) {
    }

    public void setTextContent(String s) {
        if(!TextUtils.isEmpty(s)) {
            this.mEtTextContent.setText(s);
            this.mEtTextContent.setSelection(s.length());
            this.updateLayout();
            if(this.mBoolTagEnable) {
                this.mTagHandler.sendEmptyMessage(5000);
            }
        }
    }

    public void setTextContentHint(String s) {
        this.mEtTextContent.setHint(s);
        this.updateLayout();
    }

    public void setTextCountLayoutEnable(boolean z) {
        ViewUtils.showWhen(this.mLayoutTextCountingSub, z);
    }

    public void setTextCountLimit(int v, int v1) {
        this.mTextCountLimit = v;
        MelonLimits.TextLimit melonLimits$TextLimit0 = w.I(v);
        this.mEtTextContent.setTextLimit(melonLimits$TextLimit0);
        this.mTvTextCountLimit.setText(String.valueOf(this.mTextCountLimit));
        this.mLineCountLimit = v1;
        this.mEtTextContent.setMaxLines(v1);
    }

    public void setTitle(String s) {
        this.mTitleBarLayout.setTitle(s);
    }

    private void showAutoCompleteTagList(String s) {
        if(!TextUtils.isEmpty(s)) {
            String s1 = s.replaceAll("#", "");
            if(!TextUtils.isEmpty(s1)) {
                LogU.d("EditorBaseFragment", "autoCompleteTagList() >> keyword: " + s1);
                RequestBuilder.newInstance(new DjTagSearchAutoCompleteReq(this.getContext(), s1)).tag("EditorBaseFragment").listener(new Listener() {
                    public void onResponse(DjTagSearchAutoCompleteRes djTagSearchAutoCompleteRes0) {
                        if(EditorBaseFragment.this.isFragmentValid() && djTagSearchAutoCompleteRes0.isSuccessful()) {
                            RESPONSE djTagSearchAutoCompleteRes$RESPONSE0 = djTagSearchAutoCompleteRes0.response;
                            if(djTagSearchAutoCompleteRes$RESPONSE0 != null && EditorBaseFragment.this.mAutoCompTagListAdapter != null) {
                                ArrayList arrayList0 = djTagSearchAutoCompleteRes$RESPONSE0.tagList;
                                if(arrayList0 != null && arrayList0.size() >= 1) {
                                    ViewUtils.showWhen(EditorBaseFragment.this.mLayoutAutoCompleteTag, true);
                                    EditorBaseFragment.this.mAutoCompTagListAdapter.setTagList(arrayList0, s);
                                }
                            }
                        }
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((DjTagSearchAutoCompleteRes)object0));
                    }
                }).errorListener(null).request();
            }
        }
    }

    public void updateCompleteBtn(String s) {
    }

    private void updateLatelyTagUi() {
        if(this.mLatelyTagHashMap != null && this.mLatelyTagHashMap.size() > 0) {
            ViewUtils.showWhen(this.mSvTagLayout, true);
            ViewUtils.showWhen(this.mLayoutLatelyTag, true);
            if(this.mRecommendTagArray != null && this.mRecommendTagArray.size() > 0) {
                ViewUtils.showWhen(this.mViewTagSplitLine, true);
            }
            for(Object object0: this.mLatelyTagItemViewArray) {
                ViewUtils.showWhen(((View)object0), false);
            }
            int v = 0;
            for(Object object1: this.mLatelyTagHashMap.keySet()) {
                View view0 = (View)this.mLatelyTagItemViewArray.get(v);
                ((TextView)view0.findViewById(0x7F0A0BFF)).setText(((String)object1));  // id:tvTagName
                ((AlphaControlButton)view0.findViewById(0x7F0A0029)).setTag(((String)object1));  // id:acbDelete
                ((LinearLayout)view0.findViewById(0x7F0A06E1)).setTag(((String)object1));  // id:layoutItemContainer
                view0.setVisibility(0);
                ++v;
            }
            return;
        }
        this.mViewTagSplitLine.setVisibility(8);
        this.mLayoutLatelyTag.setVisibility(8);
    }

    private void updateLayout() {
        Editable editable0 = this.mEtTextContent.getText();
        if(editable0 == null) {
            return;
        }
        int v = editable0.length();
        this.mTvTextCount.setText(String.valueOf(v));
        if(v > 0) {
            this.mAcbDeleteText.setVisibility(0);
            return;
        }
        this.mAcbDeleteText.setVisibility(4);
        ViewUtils.hideWhen(this.mLayoutAutoCompleteTag, true);
        ViewUtils.hideWhen(this.mLayoutLatelyTag, true);
    }

    private void updateRecommendTagUi() {
        if(this.mRecommendTagArray != null && this.mRecommendTagArray.size() > 0) {
            this.mSvTagLayout.setVisibility(0);
            this.mLayoutRecommendTag.setVisibility(0);
            this.mFlRecommendTag.removeAllViews();
            for(Object object0: this.mRecommendTagArray) {
                View view0 = LayoutInflater.from(this.getActivity()).inflate(0x7F0D023C, null, false);  // layout:dj_hash_tag
                ((TextView)view0.findViewById(0x7F0A0B34)).setText(((String)object0));  // id:tag_tv
                M m0 = new M(ScreenUtils.dipToPixel(this.getContext(), 10.0f), ScreenUtils.dipToPixel(this.getContext(), 10.0f));
                view0.setOnClickListener(new View.OnClickListener() {
                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        String s = ((TextView)view0.findViewById(0x7F0A0B34)).getText().toString().replace("#", "");  // id:tag_tv
                        Z.w("[Recm Tag] onItemClick() >> tagName: ", s, "EditorBaseFragment");
                        EditorBaseFragment.this.insertTagToContent(s);
                    }
                });
                this.mFlRecommendTag.addView(view0, m0);
            }
            return;
        }
        this.mLayoutRecommendTag.setVisibility(8);
    }
}

