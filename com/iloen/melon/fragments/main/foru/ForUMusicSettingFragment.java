package com.iloen.melon.fragments.main.foru;

import B.a;
import Md.f;
import Md.l;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.flexbox.FlexboxLayout;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.ForUInsertWelcomePickCodeReq.Params;
import com.iloen.melon.net.v5x.request.ForUInsertWelcomePickCodeReq;
import com.iloen.melon.net.v5x.request.ForUListWelcomePickCodeReq;
import com.iloen.melon.net.v5x.response.ForUInsertWelcomePickCodeRes;
import com.iloen.melon.net.v5x.response.ForUListWelcomePickCodeRes.RESPONSE.CODELIST.SUBLIST;
import com.iloen.melon.net.v5x.response.ForUListWelcomePickCodeRes.RESPONSE.CODELIST;
import com.iloen.melon.net.v5x.response.ForUListWelcomePickCodeRes.RESPONSE;
import com.iloen.melon.net.v5x.response.ForUListWelcomePickCodeRes;
import com.iloen.melon.popup.ForUAnimationPopup;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.color.DrawableColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import ie.H;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import v9.h;
import v9.i;

public class ForUMusicSettingFragment extends MetaContentBaseFragment {
    public class MusicSettingAdapter extends p {
        class GenreViewHolder extends O0 {
            public View btnDetailGenre;
            public ImageView[] checkImageList;
            public FlexboxLayout flexboxTagListContainer;
            public ImageView[] genreDimmedImageList;
            public BorderImageView[] genreImageList;
            public View[] layoutColumnList;
            public View layoutTagExtension;
            public ImageView[] topArrowImageList;
            public TextView tvGenreName;
            public TextView[] tvGenreNameList;
            public View vNotFirstTopMargin;

            public GenreViewHolder(View view0) {
                super(view0);
                this.layoutColumnList = new View[3];
                this.tvGenreNameList = new TextView[3];
                this.genreImageList = new BorderImageView[3];
                this.genreDimmedImageList = new ImageView[3];
                this.checkImageList = new ImageView[3];
                this.topArrowImageList = new ImageView[3];
                View view1 = view0.findViewById(0x7F0A070B);  // id:layout_column1
                ViewUtils.hideWhen(view1, true);
                View view2 = view0.findViewById(0x7F0A070C);  // id:layout_column2
                ViewUtils.hideWhen(view2, true);
                View view3 = view0.findViewById(0x7F0A070D);  // id:layout_column3
                ViewUtils.hideWhen(view3, true);
                this.btnDetailGenre = view0.findViewById(0x7F0A0158);  // id:btn_detail_genre
                this.tvGenreName = (TextView)view0.findViewById(0x7F0A0C86);  // id:tv_genre_name
                this.vNotFirstTopMargin = view0.findViewById(0x7F0A0D9D);  // id:v_not_first_top_margin
                this.layoutTagExtension = view0.findViewById(0x7F0A0749);  // id:layout_tag_extension
                this.flexboxTagListContainer = (FlexboxLayout)view0.findViewById(0x7F0A04C4);  // id:flexbox_tag_list_container
                ImageView[] arr_imageView = this.topArrowImageList;
                arr_imageView[0] = (ImageView)view0.findViewById(0x7F0A06AD);  // id:iv_top_arrorw_column1
                ImageView[] arr_imageView1 = this.topArrowImageList;
                arr_imageView1[1] = (ImageView)view0.findViewById(0x7F0A06AE);  // id:iv_top_arrorw_column2
                ImageView[] arr_imageView2 = this.topArrowImageList;
                arr_imageView2[2] = (ImageView)view0.findViewById(0x7F0A06AF);  // id:iv_top_arrorw_column3
                View[] arr_view = this.layoutColumnList;
                arr_view[0] = view1;
                arr_view[1] = view2;
                arr_view[2] = view3;
                BorderImageView[] arr_borderImageView = this.genreImageList;
                arr_borderImageView[0] = (BorderImageView)view1.findViewById(0x7F0A04EC);  // id:genre_image
                BorderImageView[] arr_borderImageView1 = this.genreImageList;
                arr_borderImageView1[1] = (BorderImageView)view2.findViewById(0x7F0A04EC);  // id:genre_image
                BorderImageView[] arr_borderImageView2 = this.genreImageList;
                arr_borderImageView2[2] = (BorderImageView)view3.findViewById(0x7F0A04EC);  // id:genre_image
                ImageView[] arr_imageView3 = this.genreDimmedImageList;
                arr_imageView3[0] = (ImageView)view1.findViewById(0x7F0A0631);  // id:iv_genre_image_dimmed
                ImageView[] arr_imageView4 = this.genreDimmedImageList;
                arr_imageView4[1] = (ImageView)view2.findViewById(0x7F0A0631);  // id:iv_genre_image_dimmed
                ImageView[] arr_imageView5 = this.genreDimmedImageList;
                arr_imageView5[2] = (ImageView)view3.findViewById(0x7F0A0631);  // id:iv_genre_image_dimmed
                ImageView[] arr_imageView6 = this.checkImageList;
                arr_imageView6[0] = (ImageView)view1.findViewById(0x7F0A0610);  // id:iv_check
                ImageView[] arr_imageView7 = this.checkImageList;
                arr_imageView7[1] = (ImageView)view2.findViewById(0x7F0A0610);  // id:iv_check
                ImageView[] arr_imageView8 = this.checkImageList;
                arr_imageView8[2] = (ImageView)view3.findViewById(0x7F0A0610);  // id:iv_check
                TextView[] arr_textView = this.tvGenreNameList;
                arr_textView[0] = (TextView)view1.findViewById(0x7F0A0C86);  // id:tv_genre_name
                TextView[] arr_textView1 = this.tvGenreNameList;
                arr_textView1[1] = (TextView)view2.findViewById(0x7F0A0C86);  // id:tv_genre_name
                TextView[] arr_textView2 = this.tvGenreNameList;
                arr_textView2[2] = (TextView)view3.findViewById(0x7F0A0C86);  // id:tv_genre_name
            }
        }

        class HeaderViewHolder extends O0 {
            public TextView description;
            public TextView title;

            public HeaderViewHolder(View view0) {
                super(view0);
                this.title = (TextView)view0.findViewById(0x7F0A0B8D);  // id:title
                this.description = (TextView)view0.findViewById(0x7F0A03AF);  // id:description
            }
        }

        class ServerWrapperData {
            private ArrayList codeList;
            public int viewType;

            private ServerWrapperData() {
                this.codeList = new ArrayList();
            }

            public ServerWrapperData(int v) {
            }

            public static ArrayList a(ServerWrapperData forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0) {
                return forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0.codeList;
            }

            public void add(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
                this.codeList.add(forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
            }

            public CODELIST getCode(int v) {
                return (CODELIST)this.codeList.get(v);
            }

            public boolean hasWelcomMixCode(String s) {
                if(!TextUtils.isEmpty(s)) {
                    for(Object object0: this.codeList) {
                        if(s.equals(((CODELIST)object0).welcomeMixCode)) {
                            return true;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                return false;
            }
        }

        private static final int VIEW_TYPE_GENRE = 1;
        private static final int VIEW_TYPE_HEADER;
        private CODELIST extendedGenre;
        private int mGenreSeparatorHeight;
        private HashMap selectedGenreHashMap;
        private HashMap selectedSubTagMap;
        private ForUListWelcomePickCodeRes welcomePickCodeRes;

        public MusicSettingAdapter(Context context0, List list0) {
            super(context0, list0);
            this.selectedGenreHashMap = new HashMap();
            this.selectedSubTagMap = new HashMap();
            this.mGenreSeparatorHeight = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
        }

        public void clearAllSetting() {
            this.extendedGenre = null;
            this.selectedGenreHashMap.clear();
            this.selectedSubTagMap.clear();
        }

        public void clearSelectedSubTagList(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            for(Object object0: forUListWelcomePickCodeRes$RESPONSE$CODELIST0.subList) {
                this.selectedSubTagMap.remove(((SUBLIST)object0).welcomeMixSubCode);
            }
        }

        public CODELIST getExtendedGenre() {
            return this.extendedGenre;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v == this.getAvailableHeaderPosition() ? 0 : 1;
        }

        public CODELIST getSelectedGenre(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            return forUListWelcomePickCodeRes$RESPONSE$CODELIST0 == null || (this.selectedGenreHashMap == null || this.selectedGenreHashMap.size() < 1) ? null : ((CODELIST)this.selectedGenreHashMap.get(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode));
        }

        public int getSelectedGenreListCount() {
            return this.selectedGenreHashMap.size();
        }

        public int getSelectedSubTagCount(ArrayList arrayList0) {
            int v = 0;
            for(Object object0: arrayList0) {
                if(this.selectedSubTagMap.containsKey(((SUBLIST)object0).welcomeMixSubCode)) {
                    ++v;
                }
            }
            return v;
        }

        public ArrayList getWelcomePickCodeList() {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: this.selectedGenreHashMap.keySet()) {
                CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0 = (CODELIST)this.selectedGenreHashMap.get(((String)object0));
                StringBuilder stringBuilder0 = new StringBuilder(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode);
                for(Object object1: forUListWelcomePickCodeRes$RESPONSE$CODELIST0.subList) {
                    SUBLIST forUListWelcomePickCodeRes$RESPONSE$CODELIST$SUBLIST0 = (SUBLIST)object1;
                    if(this.selectedSubTagMap.containsKey(forUListWelcomePickCodeRes$RESPONSE$CODELIST$SUBLIST0.welcomeMixSubCode)) {
                        stringBuilder0.append(",");
                        stringBuilder0.append(forUListWelcomePickCodeRes$RESPONSE$CODELIST$SUBLIST0.welcomeMixSubCode);
                    }
                }
                arrayList0.add(stringBuilder0.toString());
            }
            return arrayList0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ForUListWelcomePickCodeRes) {
                this.welcomePickCodeRes = (ForUListWelcomePickCodeRes)httpResponse0;
                RESPONSE forUListWelcomePickCodeRes$RESPONSE0 = ((ForUListWelcomePickCodeRes)httpResponse0).response;
                this.setMenuId(forUListWelcomePickCodeRes$RESPONSE0.menuId);
                ArrayList arrayList0 = forUListWelcomePickCodeRes$RESPONSE0.codeList;
                if(arrayList0 != null) {
                    ServerWrapperData forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0 = null;
                    int v = 0;
                    for(Object object0: arrayList0) {
                        if(v % 3 == 0) {
                            forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0 = new ServerWrapperData(this, 0);
                            this.add(forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0);
                        }
                        forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0.add(((CODELIST)object0));
                        ++v;
                    }
                }
            }
            return true;
        }

        // 去混淆评级： 低(20)
        public boolean isExtendedGenre(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            return this.extendedGenre == null || TextUtils.isEmpty(this.extendedGenre.welcomeMixCode) || forUListWelcomePickCodeRes$RESPONSE$CODELIST0 == null || TextUtils.isEmpty(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode) ? false : this.extendedGenre.welcomeMixCode.equals(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode);
        }

        public boolean isSelectedGenre(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            return this.selectedGenreHashMap.get(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode) != null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            if(o00 instanceof GenreViewHolder) {
                this.updateGenreRowView(((GenreViewHolder)o00), ((ServerWrapperData)this.getItem(v1)), v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return v == 0 ? new HeaderViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D028A, viewGroup0, false)) : new GenreViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D0289, viewGroup0, false));  // layout:for_u_music_setting_header_item
        }

        public void removeSelectedGenre(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            if(forUListWelcomePickCodeRes$RESPONSE$CODELIST0 != null && !TextUtils.isEmpty(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode)) {
                this.selectedGenreHashMap.remove(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode);
            }
        }

        public void saveSelectedGenre(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            this.selectedGenreHashMap.put(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode, forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
        }

        public void setExtendedGenre(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            this.extendedGenre = forUListWelcomePickCodeRes$RESPONSE$CODELIST0;
        }

        public boolean toggleSelectedGenreState(CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0) {
            if(this.selectedGenreHashMap.containsKey(forUListWelcomePickCodeRes$RESPONSE$CODELIST0)) {
                this.selectedGenreHashMap.remove(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode);
                return false;
            }
            this.selectedGenreHashMap.put(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode, forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
            return true;
        }

        private void updateGenreRowView(GenreViewHolder forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0, ServerWrapperData forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0, int v) {
            ArrayList arrayList0 = ServerWrapperData.a(forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0);
            if(arrayList0 != null) {
                ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.vNotFirstTopMargin, v != 0);
                boolean z = this.extendedGenre == null || TextUtils.isEmpty(this.extendedGenre.welcomeMixCode) ? false : forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0.hasWelcomMixCode(this.extendedGenre.welcomeMixCode);
                ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.layoutTagExtension, z);
                if(z) {
                    ArrayList arrayList1 = this.extendedGenre.subList;
                    LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
                    if(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.flexboxTagListContainer.getChildCount() > 0) {
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.flexboxTagListContainer.removeAllViews();
                    }
                    for(Object object0: arrayList1) {
                        View view0 = layoutInflater0.inflate(0x7F0D0287, null);  // layout:for_u_music_setting_favorite_tag_item
                        ViewUtils.setOnClickListener(view0, new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                String s = ((SUBLIST)object0).welcomeMixSubCode;
                                if(MusicSettingAdapter.this.selectedSubTagMap.containsKey(s)) {
                                    MusicSettingAdapter.this.selectedSubTagMap.remove(s);
                                }
                                else if(MusicSettingAdapter.this.getSelectedSubTagCount(arrayList1) >= 3) {
                                    ForUMusicSettingFragment.this.showMaxSelectedPopup();
                                }
                                else {
                                    MusicSettingAdapter.this.selectedSubTagMap.put(s, ((SUBLIST)object0));
                                }
                                MusicSettingAdapter.this.notifyDataSetChanged();
                            }
                        });
                        TextView textView0 = (TextView)view0.findViewById(0x7F0A0D23);  // id:tv_tagname
                        ViewUtils.setText(textView0, ((SUBLIST)object0).tagName);
                        View view1 = view0.findViewById(0x7F0A0B27);  // id:tag_layout
                        if(this.selectedSubTagMap.containsKey(((SUBLIST)object0).welcomeMixSubCode)) {
                            DrawableColorUtils.changeDrawableInnerColor(view1, ColorUtils.getColor(this.getContext(), 0x7F06017F));  // color:green502s_support_high_contrast
                            textView0.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
                        }
                        else {
                            textView0.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060165));  // color:gray800s
                            DrawableColorUtils.changeDrawableInnerColor(view1, 0);
                        }
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.flexboxTagListContainer.addView(view0);
                    }
                    ForUMusicSettingFragment.this.getRecyclerView().smoothScrollToPosition(v + 1);
                }
                int v2 = arrayList0.size();
                for(int v1 = 0; v1 < v2; ++v1) {
                    ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.layoutColumnList[v1], true);
                    CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0 = (CODELIST)arrayList0.get(v1);
                    ViewUtils.setText(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.tvGenreNameList[v1], forUListWelcomePickCodeRes$RESPONSE$CODELIST0.gnrName);
                    forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.tvGenreNameList[v1].setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060169));  // color:gray850s
                    Glide.with(this.getContext()).load(forUListWelcomePickCodeRes$RESPONSE$CODELIST0.imgUrl).apply(RequestOptions.circleCropTransform()).into(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreImageList[v1]);
                    ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.checkImageList[v1], this.isSelectedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0));
                    ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.topArrowImageList[v1], this.isExtendedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0));
                    if(this.extendedGenre == null || TextUtils.isEmpty(this.extendedGenre.welcomeMixCode)) {
                        if(this.isSelectedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0)) {
                            ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], true);
                            forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1].setAlpha(0.8f);
                            forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreImageList[v1].setAlpha(1.0f);
                            int v5 = ColorUtils.getColor(this.getContext(), 0x7F06017A);  // color:green500e_support_high_contrast
                            DrawableColorUtils.changeDrawableInnerColor(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], v5);
                            forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.tvGenreNameList[v1].setTextColor(v5);
                        }
                        else {
                            ViewUtils.hideWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], true);
                            forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreImageList[v1].setAlpha(1.0f);
                        }
                    }
                    else if(this.extendedGenre.welcomeMixCode.equals(forUMusicSettingFragment$MusicSettingAdapter$ServerWrapperData0.getCode(v1).welcomeMixCode)) {
                        ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], true);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1].setAlpha(0.8f);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreImageList[v1].setAlpha(1.0f);
                        int v3 = ColorUtils.getColor(this.getContext(), 0x7F06017A);  // color:green500e_support_high_contrast
                        DrawableColorUtils.changeDrawableInnerColor(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], v3);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.tvGenreNameList[v1].setTextColor(v3);
                    }
                    else if(this.isSelectedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0)) {
                        ViewUtils.showWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], true);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1].setAlpha(0.4f);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreImageList[v1].setAlpha(0.4f);
                        int v4 = ColorUtils.getColor(this.getContext(), 0x7F06017A);  // color:green500e_support_high_contrast
                        DrawableColorUtils.changeDrawableInnerColor(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], v4);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.tvGenreNameList[v1].setTextColor(v4);
                    }
                    else {
                        ViewUtils.hideWhen(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1], true);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreDimmedImageList[v1].setAlpha(1.0f);
                        forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.genreImageList[v1].setAlpha(0.4f);
                    }
                    ViewUtils.setOnClickListener(forUMusicSettingFragment$MusicSettingAdapter$GenreViewHolder0.layoutColumnList[v1], new View.OnClickListener() {
                        @Override  // android.view.View$OnClickListener
                        public void onClick(View view0) {
                            int v1;
                            int v;
                            if(ForUMusicSettingFragment.this.uiHandler.hasMessages(0)) {
                                ForUMusicSettingFragment.this.uiHandler.removeMessages(0);
                                v = 5001;
                                v1 = 0;
                            }
                            else {
                                v = 5000;
                                v1 = 200;
                            }
                            Message message0 = ForUMusicSettingFragment.this.uiHandler.obtainMessage(0, v, -1, forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
                            ForUMusicSettingFragment.this.uiHandler.sendMessageDelayed(message0, ((long)v1));
                        }
                    });
                }
            }
        }
    }

    static class UiHandler extends U0 {
        public UiHandler(ForUMusicSettingFragment forUMusicSettingFragment0) {
            super(forUMusicSettingFragment0);
        }

        public void handleMessage(ForUMusicSettingFragment forUMusicSettingFragment0, Message message0) {
            if(message0.what == 0) {
                CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST0 = (CODELIST)message0.obj;
                MusicSettingAdapter forUMusicSettingFragment$MusicSettingAdapter0 = (MusicSettingAdapter)forUMusicSettingFragment0.getAdapter();
                if(message0.arg1 == 5000) {
                    String s = forUListWelcomePickCodeRes$RESPONSE$CODELIST0.welcomeMixCode;
                    CODELIST forUListWelcomePickCodeRes$RESPONSE$CODELIST1 = forUMusicSettingFragment$MusicSettingAdapter0.getExtendedGenre();
                    if(forUMusicSettingFragment$MusicSettingAdapter0.getSelectedGenreListCount() < 3 || forUMusicSettingFragment$MusicSettingAdapter0.isSelectedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0)) {
                        if(s == null || forUListWelcomePickCodeRes$RESPONSE$CODELIST1 == null || TextUtils.isEmpty(s) || !s.equals(forUListWelcomePickCodeRes$RESPONSE$CODELIST1.welcomeMixCode)) {
                            forUMusicSettingFragment$MusicSettingAdapter0.setExtendedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
                        }
                        else {
                            forUMusicSettingFragment$MusicSettingAdapter0.setExtendedGenre(null);
                        }
                        forUMusicSettingFragment$MusicSettingAdapter0.toggleSelectedGenreState(forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
                        forUMusicSettingFragment$MusicSettingAdapter0.notifyDataSetChanged();
                    }
                    else {
                        forUMusicSettingFragment0.showMaxSelectedPopup();
                    }
                }
                else if(forUMusicSettingFragment$MusicSettingAdapter0.getSelectedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0) != null) {
                    forUMusicSettingFragment$MusicSettingAdapter0.setExtendedGenre(null);
                    forUMusicSettingFragment$MusicSettingAdapter0.removeSelectedGenre(forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
                    forUMusicSettingFragment$MusicSettingAdapter0.clearSelectedSubTagList(forUListWelcomePickCodeRes$RESPONSE$CODELIST0);
                    forUMusicSettingFragment$MusicSettingAdapter0.notifyDataSetChanged();
                }
                forUMusicSettingFragment0.updateView();
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((ForUMusicSettingFragment)object0), message0);
        }
    }

    private static final int MAX_SELECTED_GENRE_COUNT = 3;
    private static final int MAX_SELECTED_SUB_TAG_COUNT = 3;
    private static final int MESSAGE_GENRE_TAB = 0;
    private static final int MESSAGE_TAB_CHECK_DELAY = 200;
    private static final int MESSAGE_TYPE_DOUBLE_TAB = 5001;
    private static final int MESSAGE_TYPE_SINGLE_TAB = 5000;
    private static final String TAG = "ForUMusicSettingFragment";
    private View btnComplete;
    private View btnReset;
    private View layoutBottomButton;
    private boolean mIsForceClose;
    private UiHandler uiHandler;

    public ForUMusicSettingFragment() {
        this.mIsForceClose = false;
        this.uiHandler = new UiHandler(this);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 1000);  // id:toolbar_layout
    }

    private void callSaveSetAll() {
        this.showProgress(true);
        ForUAnimationPopup forUAnimationPopup0 = new ForUAnimationPopup(MelonFragmentManager.getInstance().getCurrentActivity());
        forUAnimationPopup0.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override  // android.content.DialogInterface$OnDismissListener
            public void onDismiss(DialogInterface dialogInterface0) {
                if(ForUMusicSettingFragment.e0(ForUMusicSettingFragment.this)) {
                    ForUMusicSettingFragment.this.performBackPress();
                }
            }
        });
        forUAnimationPopup0.show();
        j0 j00 = this.mAdapter;
        if(j00 instanceof MusicSettingAdapter) {
            String s = "";
            ArrayList arrayList0 = ((MusicSettingAdapter)j00).getWelcomePickCodeList();
            Params forUInsertWelcomePickCodeReq$Params0 = new Params();
            if(arrayList0 != null && arrayList0.size() > 0) {
                forUInsertWelcomePickCodeReq$Params0.welcomePickCode1 = (String)arrayList0.get(0);
                forUInsertWelcomePickCodeReq$Params0.welcomePickCode2 = arrayList0.size() <= 1 ? "" : ((String)arrayList0.get(1));
                if(arrayList0.size() > 2) {
                    s = (String)arrayList0.get(2);
                }
                forUInsertWelcomePickCodeReq$Params0.welcomePickCode3 = s;
            }
            RequestBuilder.newInstance(new ForUInsertWelcomePickCodeReq(this.getContext(), forUInsertWelcomePickCodeReq$Params0)).tag("ForUMusicSettingFragment").listener(new Listener() {
                public void onResponse(ForUInsertWelcomePickCodeRes forUInsertWelcomePickCodeRes0) {
                    ForUMusicSettingFragment.this.showProgress(false);
                    if(ForUMusicSettingFragment.this.isFragmentValid() && forUInsertWelcomePickCodeRes0.isSuccessful()) {
                        ForUMusicSettingFragment.g0(ForUMusicSettingFragment.this);
                        l.a(f.i);
                        return;
                    }
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    forUAnimationPopup0.forceRepeateClose();
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((ForUInsertWelcomePickCodeRes)object0));
                }
            }).errorListener(new ErrorListener() {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    LogU.w("ForUMusicSettingFragment", "onErrorResponse() " + HttpResponse.getErrorMessage(volleyError0));
                    ForUMusicSettingFragment.this.showProgress(false);
                    ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
            }).request();
        }
    }

    // 检测为 Lambda 实现
    private void clearSettingAll() [...]

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return new MusicSettingAdapter(this, this.getContext(), null);
    }

    public static boolean e0(ForUMusicSettingFragment forUMusicSettingFragment0) {
        return forUMusicSettingFragment0.mIsForceClose;
    }

    private boolean existSelectedGenreList() {
        return this.mAdapter instanceof MusicSettingAdapter && ((MusicSettingAdapter)this.mAdapter).getSelectedGenreListCount() > 0;
    }

    public static void g0(ForUMusicSettingFragment forUMusicSettingFragment0) {
        forUMusicSettingFragment0.mIsForceClose = true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    private H lambda$showExitPopup$0() {
        this.mIsForceClose = true;
        this.performBackPress();
        return null;
    }

    public static ForUMusicSettingFragment newInstance() {
        ForUMusicSettingFragment forUMusicSettingFragment0 = new ForUMusicSettingFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("argIsLoginRequired", true);
        forUMusicSettingFragment0.setArguments(bundle0);
        return forUMusicSettingFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        boolean z = super.onBackPressed();
        if(this.mIsForceClose) {
            return z;
        }
        this.showExitPopup();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0286, viewGroup0, false);  // layout:for_u_music_setting
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        RequestBuilder.newInstance(new ForUListWelcomePickCodeReq(this.getContext())).tag("ForUMusicSettingFragment").listener(new Listener() {
            public void onResponse(ForUListWelcomePickCodeRes forUListWelcomePickCodeRes0) {
                if(!ForUMusicSettingFragment.this.prepareFetchComplete(forUListWelcomePickCodeRes0)) {
                    return;
                }
                ForUMusicSettingFragment.this.performFetchComplete(i0, forUListWelcomePickCodeRes0);
                ForUMusicSettingFragment.this.updateView();
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ForUListWelcomePickCodeRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        super.onToolBarClick(toolBar$ToolBarItem0, v);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getString(0x7F13057C));  // string:main_for_u_setting_welcomepick "웰컴 Pick"
            titleBar0.f(true);
        }
        this.layoutBottomButton = this.findViewById(0x7F0A0703);  // id:layout_bottom_button
        this.btnReset = this.findViewById(0x7F0A01A2);  // id:btn_reset
        View view1 = this.findViewById(0x7F0A014F);  // id:btn_complete
        this.btnComplete = view1;
        ViewUtils.setOnClickListener(view1, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(!(ForUMusicSettingFragment.this.mAdapter instanceof MusicSettingAdapter)) {
                    return;
                }
                ForUMusicSettingFragment.this.callSaveSetAll();
            }
        });
        this.updateView();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private void showExitPopup() {
        b.v(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F130570), false, null, null, new q(this, 0), null);  // string:alert_dlg_title_info "안내"
    }

    private void showMaxSelectedPopup() {
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        String s1 = this.getString(0x7F130571);  // string:main_for_u_max_selected_genre_popup_message "선택은 최대 3개까지 가능합니다.\n변경을 원하시면 
                                                 // 기존 선택을 취소하신 후, 다시 시도해 주세요."
        b.a.c(l00, s, s1);
    }

    private void updateView() {
        boolean z = this.existSelectedGenreList();
        ViewUtils.showWhen(this.layoutBottomButton, z);
        ViewUtils.setEnable(this.btnReset, z);
        if(z) {
            ViewUtils.setOnClickListener(this.btnReset, (/* 缺少LAMBDA参数 */) -> {
                j0 j00 = ForUMusicSettingFragment.this.mAdapter;
                if(j00 instanceof MusicSettingAdapter) {
                    ((MusicSettingAdapter)j00).clearAllSetting();
                    ((MusicSettingAdapter)j00).notifyDataSetChanged();
                    ForUMusicSettingFragment.this.updateView();
                }
            });
            return;
        }
        ViewUtils.setOnClickListener(this.btnReset, null);

        class com.iloen.melon.fragments.main.foru.ForUMusicSettingFragment.6 implements View.OnClickListener {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                ForUMusicSettingFragment.this.clearSettingAll();
            }
        }

    }
}

