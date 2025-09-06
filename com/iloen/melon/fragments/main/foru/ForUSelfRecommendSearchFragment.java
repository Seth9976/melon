package com.iloen.melon.fragments.main.foru;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.z0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.ForUInformRelateSongRecmReq;
import com.iloen.melon.net.v4x.request.ForUSearchAutoComplListForUReq;
import com.iloen.melon.net.v4x.request.ForUSearchRecommListReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.ForUInformRelateSongRecmRes;
import com.iloen.melon.net.v4x.response.ForUSearchAutoComplListForURes.Response;
import com.iloen.melon.net.v4x.response.ForUSearchAutoComplListForURes;
import com.iloen.melon.net.v4x.response.ForUSearchRecommListRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.List;
import v9.e;
import v9.h;
import v9.i;

public class ForUSelfRecommendSearchFragment extends MetaContentBaseFragment {
    class PredictiveAdapter extends p {
        class ItemViewHolder extends O0 {
            private View artistThumbnailContainer;
            private View btnRecommend;
            private TextView contentName;
            private View separator;
            private View songThumbnailContainer;
            private BorderImageView thumbnail;

            public ItemViewHolder(Context context0, View view0) {
                super(view0);
                this.separator = view0.findViewById(0x7F0A0A69);  // id:separator
                this.artistThumbnailContainer = view0.findViewById(0x7F0A00C1);  // id:artist_thumbnail_container
                this.songThumbnailContainer = view0.findViewById(0x7F0A0AB3);  // id:song_thumbnail_container
                BorderImageView borderImageView0 = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.thumbnail = borderImageView0;
                borderImageView0.setBorderColor(ColorUtils.getColor(context0, 0x7F060034));  // color:black_08
                ViewUtils.setDefaultImage(((ImageView)view0.findViewById(0x7F0A069C)), ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 40.0f), true);  // id:iv_thumb_circle_default
                this.contentName = (TextView)view0.findViewById(0x7F0A033A);  // id:content_name
                this.btnRecommend = view0.findViewById(0x7F0A019D);  // id:btn_recommend
            }

            public static View a(ItemViewHolder forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0) {
                return forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0.artistThumbnailContainer;
            }

            public static View b(ItemViewHolder forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0) {
                return forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0.btnRecommend;
            }

            public static TextView c(ItemViewHolder forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0) {
                return forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0.contentName;
            }

            public static View d(ItemViewHolder forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0) {
                return forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0.separator;
            }

            public static View e(ItemViewHolder forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0) {
                return forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0.songThumbnailContainer;
            }

            public static BorderImageView f(ItemViewHolder forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0) {
                return forUSelfRecommendSearchFragment$PredictiveAdapter$ItemViewHolder0.thumbnail;
            }
        }

        private ForegroundColorSpan mColorSpan;

        public PredictiveAdapter(Context context0, ArrayList arrayList0) {
            super(context0, arrayList0);
            this.mColorSpan = new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06044E));  // color:primary_green
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ForUSearchAutoComplListForURes) {
                Response forUSearchAutoComplListForURes$Response0 = ((ForUSearchAutoComplListForURes)httpResponse0).response;
                if(forUSearchAutoComplListForURes$Response0 != null) {
                    this.setMenuId(forUSearchAutoComplListForURes$Response0.menuId);
                    if(forUSearchAutoComplListForURes$Response0.artistList != null && forUSearchAutoComplListForURes$Response0.artistList.size() > 0) {
                        this.addAll(forUSearchAutoComplListForURes$Response0.artistList);
                    }
                    if(forUSearchAutoComplListForURes$Response0.songList != null && forUSearchAutoComplListForURes$Response0.songList.size() > 0) {
                        this.addAll(forUSearchAutoComplListForURes$Response0.songList);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            String s2;
            String s;
            if(!(o00 instanceof ItemViewHolder)) {
                return;
            }
            Object object0 = this.getItem(v1);
            ViewUtils.showWhen(ItemViewHolder.d(((ItemViewHolder)o00)), v1 == 0);
            if(object0 instanceof SongInfoBase) {
                ViewUtils.showWhen(ItemViewHolder.a(((ItemViewHolder)o00)), false);
                ViewUtils.showWhen(ItemViewHolder.e(((ItemViewHolder)o00)), true);
                s = ((SongInfoBase)object0).songId;
                StringBuilder stringBuilder0 = new StringBuilder(((SongInfoBase)object0).songName);
                String s1 = ProtocolUtils.getArtistNames(((SongInfoBase)object0).artistList);
                if(stringBuilder0.length() > 0 && !TextUtils.isEmpty(s1)) {
                    stringBuilder0.append("-");
                }
                stringBuilder0.append(s1);
                s2 = stringBuilder0.toString();
            }
            else if(object0 instanceof ArtistInfoBase) {
                ViewUtils.showWhen(ItemViewHolder.a(((ItemViewHolder)o00)), true);
                ViewUtils.showWhen(ItemViewHolder.e(((ItemViewHolder)o00)), false);
                s = ((ArtistInfoBase)object0).getArtistId();
                if(this.getContext() != null && ItemViewHolder.f(((ItemViewHolder)o00)) != null) {
                    Glide.with(this.getContext()).load(((ArtistInfoBase)object0).getArtistImg()).apply(RequestOptions.circleCropTransform()).into(ItemViewHolder.f(((ItemViewHolder)o00)));
                }
                s2 = ((ArtistInfoBase)object0).getArtistName();
            }
            else {
                s = null;
                s2 = null;
            }
            if(!TextUtils.isEmpty(s2)) {
                if(ForUSelfRecommendSearchFragment.this.mKeyword == null) {
                    ItemViewHolder.c(((ItemViewHolder)o00)).setText(s2);
                }
                else {
                    SpannableString spannableString0 = new SpannableString(s2);
                    int v2 = s2.indexOf(ForUSelfRecommendSearchFragment.this.mKeyword);
                    if(v2 >= 0) {
                        spannableString0.setSpan(this.mColorSpan, v2, ForUSelfRecommendSearchFragment.this.mKeyword.length() + v2, 33);
                    }
                    ItemViewHolder.c(((ItemViewHolder)o00)).setText(spannableString0);
                }
            }
            ViewUtils.setOnClickListener(ItemViewHolder.b(((ItemViewHolder)o00)), new View.OnClickListener() {
                // 去混淆评级： 低(30)
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.openSimilarSongList(s, (object0 instanceof SongInfoBase ? "N10001" : "N10006"));
                }
            });
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return new ItemViewHolder(this, this.getContext(), LayoutInflater.from(this.getContext()).inflate(0x7F0D028F, viewGroup0, false));  // layout:for_u_self_recommend_search_list_item
        }
    }

    public class SearchAdapter extends p {
        public class ArtistViewHolder extends O0 {
            private View artistThumbnailContainer;
            private View btnRecommend;
            private TextView contentName;
            private BorderImageView thumbnail;

            public ArtistViewHolder(Context context0, View view0) {
                super(view0);
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0A69), true);  // id:separator
                this.artistThumbnailContainer = view0.findViewById(0x7F0A00C1);  // id:artist_thumbnail_container
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0AB3), true);  // id:song_thumbnail_container
                BorderImageView borderImageView0 = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.thumbnail = borderImageView0;
                borderImageView0.setBorderColor(ColorUtils.getColor(context0, 0x7F060034));  // color:black_08
                ViewUtils.setDefaultImage(((ImageView)view0.findViewById(0x7F0A069C)), ScreenUtils.dipToPixel(context0, 40.0f), true);  // id:iv_thumb_circle_default
                this.contentName = (TextView)view0.findViewById(0x7F0A033A);  // id:content_name
                this.btnRecommend = view0.findViewById(0x7F0A019D);  // id:btn_recommend
            }

            public static View a(ArtistViewHolder forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0.artistThumbnailContainer;
            }

            public static View b(ArtistViewHolder forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0.btnRecommend;
            }

            public static TextView c(ArtistViewHolder forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0.contentName;
            }

            public static BorderImageView d(ArtistViewHolder forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0.thumbnail;
            }
        }

        public class Category {
            String count;
            boolean hasMore;
            boolean isArtist;

        }

        public class CategoryViewHolder extends O0 {
            private View arrowIcon;
            private TextView recomCount;
            private TextView recomDescription;
            private TextView recomName;

            public CategoryViewHolder(View view0) {
                super(view0);
                this.recomName = (TextView)view0.findViewById(0x7F0A09C5);  // id:recom_name
                this.recomCount = (TextView)view0.findViewById(0x7F0A0338);  // id:content_count
                this.arrowIcon = view0.findViewById(0x7F0A00AF);  // id:arrow_icon
                this.recomDescription = (TextView)view0.findViewById(0x7F0A09C4);  // id:recom_description
            }

            public static View a(CategoryViewHolder forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0.arrowIcon;
            }

            public static TextView b(CategoryViewHolder forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0.recomCount;
            }

            public static TextView c(CategoryViewHolder forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0.recomDescription;
            }

            public static TextView d(CategoryViewHolder forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0.recomName;
            }
        }

        public class SongViewHolder extends O0 {
            private ImageView adultIcon;
            private TextView artistName;
            private View btnRecommend;
            private ImageView freeIcon;
            private ImageView holdbackIcon;
            private ImageView ivThumb;
            private ImageView ivThumbDefault;
            private TextView title;

            public SongViewHolder(View view0) {
                super(view0);
                this.ivThumbDefault = (ImageView)view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
                this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                this.adultIcon = (ImageView)view0.findViewById(0x7F0A063B);  // id:iv_list_19
                this.holdbackIcon = (ImageView)view0.findViewById(0x7F0A0641);  // id:iv_list_holdback
                this.freeIcon = (ImageView)view0.findViewById(0x7F0A0640);  // id:iv_list_free
                this.title = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.artistName = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
                View view1 = view0.findViewById(0x7F0A0C81);  // id:tv_foru_recom
                this.btnRecommend = view1;
                ViewUtils.showWhen(view1, true);
                ViewUtils.setDefaultImage(this.ivThumbDefault, ScreenUtils.dipToPixel(MelonAppBase.instance.getContext(), 48.0f), false);
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0182), true);  // id:btn_play
                ViewUtils.hideWhen(view0.findViewById(0x7F0A0169), true);  // id:btn_info
                ViewUtils.showWhen(this.itemView, false);
            }

            public static ImageView a(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.adultIcon;
            }

            public static TextView b(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.artistName;
            }

            public static View c(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.btnRecommend;
            }

            public static ImageView d(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.freeIcon;
            }

            public static ImageView e(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.holdbackIcon;
            }

            public static ImageView f(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.ivThumb;
            }

            public static TextView g(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.title;
            }
        }

        public class TitleViewHolder extends O0 {
            private TextView tvTitle;

            public TitleViewHolder(View view0) {
                super(view0);
                this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            }

            public static TextView a(TitleViewHolder forUSelfRecommendSearchFragment$SearchAdapter$TitleViewHolder0) {
                return forUSelfRecommendSearchFragment$SearchAdapter$TitleViewHolder0.tvTitle;
            }
        }

        private static final int VIEW_TYPE_ARTIST = 3;
        private static final int VIEW_TYPE_CATEGORY = 1;
        private static final int VIEW_TYPE_SONG = 2;
        private static final int VIEW_TYPE_TITLE = 4;
        private static final int VIEW_TYPE_UNKNOWN = -1;
        private ForegroundColorSpan mColorSpan;

        public SearchAdapter(Context context0, List list0) {
            super(context0, list0);
            this.mColorSpan = new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06044E));  // color:primary_green
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof Category) {
                return 1;
            }
            if(object0 instanceof SongInfoBase) {
                return 2;
            }
            if(object0 instanceof ArtistInfoBase) {
                return 3;
            }
            return object0 instanceof String ? 4 : -1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ForUInformRelateSongRecmRes) {
                if(((ForUInformRelateSongRecmRes)httpResponse0) != null) {
                    com.iloen.melon.net.v4x.response.ForUInformRelateSongRecmRes.Response forUInformRelateSongRecmRes$Response0 = ((ForUInformRelateSongRecmRes)httpResponse0).response;
                    if(forUInformRelateSongRecmRes$Response0 != null) {
                        if(forUInformRelateSongRecmRes$Response0.likeSongTitle != null && (forUInformRelateSongRecmRes$Response0.likeSongList != null && forUInformRelateSongRecmRes$Response0.likeSongList.size() > 0)) {
                            this.add(forUInformRelateSongRecmRes$Response0.likeSongTitle);
                            this.addAll(forUInformRelateSongRecmRes$Response0.likeSongList);
                        }
                        if(forUInformRelateSongRecmRes$Response0.recentSongTitle != null && (forUInformRelateSongRecmRes$Response0.recentSongList != null && forUInformRelateSongRecmRes$Response0.recentSongList.size() > 0)) {
                            this.add(forUInformRelateSongRecmRes$Response0.recentSongTitle);
                            this.addAll(forUInformRelateSongRecmRes$Response0.recentSongList);
                        }
                        if(forUInformRelateSongRecmRes$Response0.fanArtistTitle != null && (forUInformRelateSongRecmRes$Response0.fanArtistList != null && forUInformRelateSongRecmRes$Response0.fanArtistList.size() > 0)) {
                            this.add(forUInformRelateSongRecmRes$Response0.fanArtistTitle);
                            this.addAll(forUInformRelateSongRecmRes$Response0.fanArtistList);
                            return true;
                        }
                    }
                }
            }
            else if(httpResponse0 instanceof ForUSearchRecommListRes && ((ForUSearchRecommListRes)httpResponse0) != null) {
                com.iloen.melon.net.v4x.response.ForUSearchRecommListRes.Response forUSearchRecommListRes$Response0 = ((ForUSearchRecommListRes)httpResponse0).response;
                if(forUSearchRecommListRes$Response0 != null) {
                    this.setMenuId(forUSearchRecommListRes$Response0.menuId);
                    Category forUSelfRecommendSearchFragment$SearchAdapter$Category0 = new Category(this);
                    forUSelfRecommendSearchFragment$SearchAdapter$Category0.isArtist = true;
                    forUSelfRecommendSearchFragment$SearchAdapter$Category0.hasMore = ProtocolUtils.parseBoolean(forUSearchRecommListRes$Response0.artistHasMore);
                    forUSelfRecommendSearchFragment$SearchAdapter$Category0.count = forUSearchRecommListRes$Response0.artistCount;
                    if(forUSearchRecommListRes$Response0.artistCount != null && !"0".equals(forUSearchRecommListRes$Response0.artistCount)) {
                        this.add(forUSelfRecommendSearchFragment$SearchAdapter$Category0);
                    }
                    if(forUSearchRecommListRes$Response0.artistList != null && forUSearchRecommListRes$Response0.artistList.size() > 0) {
                        this.addAll(forUSearchRecommListRes$Response0.artistList);
                    }
                    Category forUSelfRecommendSearchFragment$SearchAdapter$Category1 = new Category(this);
                    forUSelfRecommendSearchFragment$SearchAdapter$Category1.isArtist = false;
                    forUSelfRecommendSearchFragment$SearchAdapter$Category1.hasMore = ProtocolUtils.parseBoolean(forUSearchRecommListRes$Response0.songHasMore);
                    forUSelfRecommendSearchFragment$SearchAdapter$Category1.count = forUSearchRecommListRes$Response0.songCount;
                    this.add(forUSelfRecommendSearchFragment$SearchAdapter$Category1);
                    ArrayList arrayList0 = forUSearchRecommListRes$Response0.songList;
                    if(arrayList0 != null) {
                        this.addAll(arrayList0);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            int v2 = o00.getItemViewType();
            Object object0 = this.getItem(v1);
            if(v2 == 1) {
                this.updateCategoryView(((CategoryViewHolder)o00), ((Category)object0));
                return;
            }
            switch(v2) {
                case 2: {
                    this.updateSongView(((SongViewHolder)o00), ((SongInfoBase)object0));
                    return;
                }
                case 3: {
                    this.updateArtistView(((ArtistViewHolder)o00), ((ArtistInfoBase)object0));
                    return;
                }
                case 4: {
                    this.updateTitleView(((TitleViewHolder)o00), ((String)object0));
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    return new CategoryViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D028E, viewGroup0, false));  // layout:for_u_self_recommend_category_list_item
                }
                case 2: {
                    return new SongViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
                }
                case 3: {
                    return new ArtistViewHolder(this, this.getContext(), LayoutInflater.from(this.getContext()).inflate(0x7F0D028F, viewGroup0, false));  // layout:for_u_self_recommend_search_list_item
                }
                case 4: {
                    return new TitleViewHolder(this, LayoutInflater.from(this.getContext()).inflate(0x7F0D0290, viewGroup0, false));  // layout:for_u_self_recommend_title_list_item
                }
                default: {
                    return null;
                }
            }
        }

        private void updateArtistView(ArtistViewHolder forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0, ArtistInfoBase artistInfoBase0) {
            if(artistInfoBase0 == null) {
                return;
            }
            ViewUtils.showWhen(ArtistViewHolder.a(forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0), true);
            if(this.getContext() != null && ArtistViewHolder.d(forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0) != null) {
                Glide.with(this.getContext()).load(artistInfoBase0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(ArtistViewHolder.d(forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0));
            }
            if(!TextUtils.isEmpty(artistInfoBase0.getArtistName())) {
                if(ForUSelfRecommendSearchFragment.this.mKeyword == null) {
                    ArtistViewHolder.c(forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0).setText(artistInfoBase0.getArtistName());
                }
                else {
                    SpannableString spannableString0 = new SpannableString(artistInfoBase0.getArtistName());
                    int v = artistInfoBase0.getArtistName().indexOf(ForUSelfRecommendSearchFragment.this.mKeyword);
                    if(v >= 0) {
                        spannableString0.setSpan(this.mColorSpan, v, ForUSelfRecommendSearchFragment.this.mKeyword.length() + v, 33);
                    }
                    ArtistViewHolder.c(forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0).setText(spannableString0);
                }
            }
            ViewUtils.setOnClickListener(ArtistViewHolder.b(forUSelfRecommendSearchFragment$SearchAdapter$ArtistViewHolder0), new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.openSimilarSongList(artistInfoBase0.getArtistId(), "N10006");
                }
            });
        }

        private void updateCategoryView(CategoryViewHolder forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0, Category forUSelfRecommendSearchFragment$SearchAdapter$Category0) {
            if(forUSelfRecommendSearchFragment$SearchAdapter$Category0 == null) {
                return;
            }
            CategoryViewHolder.d(forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0).setText((forUSelfRecommendSearchFragment$SearchAdapter$Category0.isArtist ? 0x7F1300FC : 0x7F13105E));  // string:artist "아티스트"
            CategoryViewHolder.b(forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0).setText(forUSelfRecommendSearchFragment$SearchAdapter$Category0.count);
            ViewUtils.showWhen(CategoryViewHolder.a(forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0), forUSelfRecommendSearchFragment$SearchAdapter$Category0.hasMore);
            CategoryViewHolder.c(forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0).setText((forUSelfRecommendSearchFragment$SearchAdapter$Category0.isArtist ? 0x7F130574 : 0x7F130577));  // string:main_for_u_search_artist_description "선택한 아티스트를 기반으로 추천"
            if(!forUSelfRecommendSearchFragment$SearchAdapter$Category0.hasMore) {
                ViewUtils.setOnClickListener(forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0.itemView, null);
                return;
            }
            com.iloen.melon.fragments.main.foru.ForUSelfRecommendSearchFragment.SearchAdapter.1 forUSelfRecommendSearchFragment$SearchAdapter$10 = new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.open(ForUSelfRecommendSearchMoreFragment.newInstance(ForUSelfRecommendSearchFragment.this.mKeyword, forUSelfRecommendSearchFragment$SearchAdapter$Category0.isArtist));
                }
            };
            ViewUtils.setOnClickListener(forUSelfRecommendSearchFragment$SearchAdapter$CategoryViewHolder0.itemView, forUSelfRecommendSearchFragment$SearchAdapter$10);
        }

        private void updateSongView(SongViewHolder forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0, SongInfoBase songInfoBase0) {
            if(songInfoBase0 == null) {
                return;
            }
            if(this.getContext() != null && SongViewHolder.f(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0) != null) {
                Glide.with(this.getContext()).load(songInfoBase0.albumImg).into(SongViewHolder.f(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0));
            }
            ViewUtils.showWhen(SongViewHolder.a(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0), songInfoBase0.isAdult);
            ViewUtils.showWhen(SongViewHolder.e(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0), songInfoBase0.isHoldback);
            ViewUtils.showWhen(SongViewHolder.d(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0), songInfoBase0.isFree);
            if(!TextUtils.isEmpty(songInfoBase0.songName)) {
                if(ForUSelfRecommendSearchFragment.this.mKeyword == null) {
                    SongViewHolder.g(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0).setText(songInfoBase0.songName);
                }
                else {
                    SpannableString spannableString0 = new SpannableString(songInfoBase0.songName);
                    int v = songInfoBase0.songName.indexOf(ForUSelfRecommendSearchFragment.this.mKeyword);
                    if(v >= 0) {
                        spannableString0.setSpan(this.mColorSpan, v, ForUSelfRecommendSearchFragment.this.mKeyword.length() + v, 33);
                    }
                    SongViewHolder.g(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0).setText(spannableString0);
                }
            }
            String s = ProtocolUtils.getArtistNames(songInfoBase0.artistList);
            if(!TextUtils.isEmpty(s)) {
                if(ForUSelfRecommendSearchFragment.this.mKeyword == null) {
                    SongViewHolder.b(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0).setText(s);
                }
                else {
                    SpannableString spannableString1 = new SpannableString(s);
                    int v1 = s.indexOf(ForUSelfRecommendSearchFragment.this.mKeyword);
                    if(v1 >= 0) {
                        spannableString1.setSpan(this.mColorSpan, v1, ForUSelfRecommendSearchFragment.this.mKeyword.length() + v1, 33);
                    }
                    SongViewHolder.b(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0).setText(spannableString1);
                }
            }
            SongViewHolder.c(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0).setOnClickListener(new View.OnClickListener() {
                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.openSimilarSongList(songInfoBase0.songId, "N10001");
                }
            });
            ViewUtils.showWhen(forUSelfRecommendSearchFragment$SearchAdapter$SongViewHolder0.itemView, true);
        }

        private void updateTitleView(TitleViewHolder forUSelfRecommendSearchFragment$SearchAdapter$TitleViewHolder0, String s) {
            if(s == null) {
                return;
            }
            ViewUtils.setText(TitleViewHolder.a(forUSelfRecommendSearchFragment$SearchAdapter$TitleViewHolder0), s);
        }
    }

    static class UiHandler extends U0 {
        public UiHandler(ForUSelfRecommendSearchFragment forUSelfRecommendSearchFragment0) {
            super(forUSelfRecommendSearchFragment0);
        }

        public void handleMessage(ForUSelfRecommendSearchFragment forUSelfRecommendSearchFragment0, Message message0) {
            if(message0 != null && message0.what == 0) {
                forUSelfRecommendSearchFragment0.autoCompleteSearchList(((String)message0.obj));
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((ForUSelfRecommendSearchFragment)object0), message0);
        }
    }

    private static final String ARG_KEYWORD = "argKeyword";
    private static final String ARG_SHOW_PREDICTIVE_LIST = "argShowPredictiveList";
    private static final int FETCH_SEARCH_LIST = 0;
    private static final String TAG = "ForUSelfRecommnedFragment";
    private View mBtnRemove;
    private View mDefaultText;
    private EditText mEditText;
    private ForUInformRelateSongRecmRes mForUInformRelateSongRecmRes;
    private UiHandler mHandler;
    private boolean mIsFirstLoading;
    private boolean mIsShowPredictiveList;
    private String mKeyword;
    private PredictiveAdapter mPredictiveAdapter;
    private RecyclerView mPredictiveList;
    private View mRemoveIcon;
    private z0 mSearchItemTouchListener;
    private TextWatcher mTextWatcher;

    public ForUSelfRecommendSearchFragment() {
        this.mKeyword = "";
        this.mIsShowPredictiveList = true;
        this.mIsFirstLoading = true;
        this.mHandler = new UiHandler(this);
        this.mTextWatcher = new TextWatcher() {
            @Override  // android.text.TextWatcher
            public void afterTextChanged(Editable editable0) {
            }

            @Override  // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
            }

            @Override  // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                String s = ForUSelfRecommendSearchFragment.this.mEditText.getText().toString();
                ForUSelfRecommendSearchFragment.this.mKeyword = s;
                int v3 = ForUSelfRecommendSearchFragment.this.mKeyword.length();
                boolean z = true;
                ViewUtils.showWhen(ForUSelfRecommendSearchFragment.this.mRemoveIcon, v3 > 0);
                View view0 = ForUSelfRecommendSearchFragment.this.mDefaultText;
                if(v3 <= 0) {
                    z = false;
                }
                ViewUtils.hideWhen(view0, z);
                if(v3 == 0) {
                    if(ForUSelfRecommendSearchFragment.this.mForUInformRelateSongRecmRes == null) {
                        ForUSelfRecommendSearchFragment.n0(ForUSelfRecommendSearchFragment.this);
                    }
                    else {
                        ForUSelfRecommendSearchFragment.this.performFetchComplete(ForUSelfRecommendSearchFragment.this.mForUInformRelateSongRecmRes);
                    }
                }
                if(ForUSelfRecommendSearchFragment.this.mHandler != null) {
                    if(ForUSelfRecommendSearchFragment.this.mHandler.hasMessages(0)) {
                        ForUSelfRecommendSearchFragment.this.mHandler.removeMessages(0);
                    }
                    Message message0 = ForUSelfRecommendSearchFragment.this.mHandler.obtainMessage(0, ForUSelfRecommendSearchFragment.this.mKeyword);
                    ForUSelfRecommendSearchFragment.this.mHandler.sendMessage(message0);
                }
            }
        };
        this.mSearchItemTouchListener = new z0() {
            @Override  // androidx.recyclerview.widget.z0
            public boolean onInterceptTouchEvent(RecyclerView recyclerView0, MotionEvent motionEvent0) {
                if(motionEvent0.getAction() == 0 && ForUSelfRecommendSearchFragment.this.mEditText != null) {
                    InputMethodUtils.hideInputMethod(ForUSelfRecommendSearchFragment.this.getContext(), ForUSelfRecommendSearchFragment.this.mEditText);
                }
                return false;
            }

            @Override  // androidx.recyclerview.widget.z0
            public void onRequestDisallowInterceptTouchEvent(boolean z) {
            }

            @Override  // androidx.recyclerview.widget.z0
            public void onTouchEvent(RecyclerView recyclerView0, MotionEvent motionEvent0) {
            }
        };
    }

    private void autoCompleteSearchList(String s) {
        if(!this.isFragmentValid()) {
            return;
        }
        if(TextUtils.isEmpty(s)) {
            this.mIsShowPredictiveList = false;
            ViewUtils.hideWhen(this.mPredictiveList, true);
            return;
        }
        this.mIsShowPredictiveList = true;
        ViewUtils.showWhen(this.mPredictiveList, true);
        RequestBuilder.newInstance(new ForUSearchAutoComplListForUReq(this.getContext(), s)).tag("ForUSelfRecommnedFragment").listener(new Listener() {
            public void onResponse(ForUSearchAutoComplListForURes forUSearchAutoComplListForURes0) {
                if(!TextUtils.isEmpty(ForUSelfRecommendSearchFragment.h0(ForUSelfRecommendSearchFragment.this)) && ForUSelfRecommendSearchFragment.h0(ForUSelfRecommendSearchFragment.this).equals(s)) {
                    ForUSelfRecommendSearchFragment.i0(ForUSelfRecommendSearchFragment.this).clear();
                    ForUSelfRecommendSearchFragment.i0(ForUSelfRecommendSearchFragment.this).addResponse(null, i.b, forUSearchAutoComplListForURes0);
                    ForUSelfRecommendSearchFragment.i0(ForUSelfRecommendSearchFragment.this).showEmptyView(ForUSelfRecommendSearchFragment.i0(ForUSelfRecommendSearchFragment.this).getCount() == 0);
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ForUSearchAutoComplListForURes)object0));
            }
        }).errorListener(null).request();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new SearchAdapter(this, context0, null);
        ((p)j00).setEmptyViewInfo(e.n);
        return j00;
    }

    private void fetchInformRelateSongRecmList(boolean z) {
        this.mIsShowPredictiveList = false;
        ViewUtils.hideWhen(this.mPredictiveList, true);
        j0 j00 = this.mAdapter;
        if(j00 instanceof SearchAdapter) {
            ((SearchAdapter)j00).showEmptyView(false);
            ((SearchAdapter)j00).showErrorView(false);
            ((SearchAdapter)j00).clear();
        }
        this.showProgress(z);
        RequestBuilder.newInstance(new ForUInformRelateSongRecmReq(this.getContext())).tag("ForUSelfRecommnedFragment").listener(new Listener() {
            public void onResponse(ForUInformRelateSongRecmRes forUInformRelateSongRecmRes0) {
                ForUSelfRecommendSearchFragment.this.showProgress(false);
                if(!ForUSelfRecommendSearchFragment.this.prepareFetchComplete(forUInformRelateSongRecmRes0)) {
                    return;
                }
                ForUSelfRecommendSearchFragment.k0(ForUSelfRecommendSearchFragment.this, forUInformRelateSongRecmRes0);
                ForUSelfRecommendSearchFragment.this.performFetchComplete(forUInformRelateSongRecmRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((ForUInformRelateSongRecmRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
                ForUSelfRecommendSearchFragment.this.showProgress(false);
                ForUSelfRecommendSearchFragment.this.performFetchError(volleyError0);
            }
        }).request();
    }

    private void fetchRecommendSearchList(String s) {
        if(s != null && !s.trim().equals("")) {
            this.mIsShowPredictiveList = false;
            ViewUtils.hideWhen(this.mPredictiveList, true);
            j0 j00 = this.mAdapter;
            if(j00 instanceof SearchAdapter) {
                ((SearchAdapter)j00).showEmptyView(false);
                ((SearchAdapter)j00).showErrorView(false);
                ((SearchAdapter)j00).clear();
            }
            this.showProgress(true);
            RequestBuilder.newInstance(new ForUSearchRecommListReq(this.getContext(), s)).tag("ForUSelfRecommnedFragment").listener(new Listener() {
                public void onResponse(ForUSearchRecommListRes forUSearchRecommListRes0) {
                    ForUSelfRecommendSearchFragment.this.showProgress(false);
                    if(!ForUSelfRecommendSearchFragment.this.prepareFetchComplete(forUSearchRecommListRes0)) {
                        return;
                    }
                    ForUSelfRecommendSearchFragment.this.performFetchComplete(i.b, forUSearchRecommListRes0);
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((ForUSearchRecommListRes)object0));
                }
            }).errorListener(new ErrorListener() {
                @Override  // com.android.volley.Response$ErrorListener
                public void onErrorResponse(VolleyError volleyError0) {
                    ForUSelfRecommendSearchFragment.this.showProgress(false);
                    ForUSelfRecommendSearchFragment.this.performFetchError(volleyError0);
                }
            }).request();
            return;
        }
        LogU.d("ForUSelfRecommnedFragment", "onFetchStart : Invalid keyword.");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "searchForuRecommend");
    }

    public static PredictiveAdapter i0(ForUSelfRecommendSearchFragment forUSelfRecommendSearchFragment0) {
        return forUSelfRecommendSearchFragment0.mPredictiveAdapter;
    }

    public static void k0(ForUSelfRecommendSearchFragment forUSelfRecommendSearchFragment0, ForUInformRelateSongRecmRes forUInformRelateSongRecmRes0) {
        forUSelfRecommendSearchFragment0.mForUInformRelateSongRecmRes = forUInformRelateSongRecmRes0;
    }

    public static void n0(ForUSelfRecommendSearchFragment forUSelfRecommendSearchFragment0) {
        forUSelfRecommendSearchFragment0.fetchInformRelateSongRecmList(true);
    }

    public static ForUSelfRecommendSearchFragment newInstance(String s) {
        ForUSelfRecommendSearchFragment forUSelfRecommendSearchFragment0 = new ForUSelfRecommendSearchFragment();
        Bundle bundle0 = new Bundle();
        bundle0.putString("argKeyword", s);
        bundle0.putBoolean("argShowPredictiveList", true);
        bundle0.putBoolean("argIsLoginRequired", true);
        forUSelfRecommendSearchFragment0.setArguments(bundle0);
        return forUSelfRecommendSearchFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        recyclerView0.addOnScrollListener(new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                if(ForUSelfRecommendSearchFragment.this.mEditText != null) {
                    InputMethodUtils.hideInputMethod(ForUSelfRecommendSearchFragment.this.getContext(), ForUSelfRecommendSearchFragment.this.mEditText);
                }
            }

            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
            }
        });
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D028C, viewGroup0, false);  // layout:for_u_self_recommend
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        if(this.mIsFirstLoading && TextUtils.isEmpty(this.mKeyword)) {
            this.mIsFirstLoading = false;
            this.fetchInformRelateSongRecmList(false);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
        RecyclerView recyclerView0 = this.mPredictiveList;
        if(recyclerView0 != null) {
            recyclerView0.removeOnItemTouchListener(this.mSearchItemTouchListener);
        }
        if(this.mEditText != null) {
            InputMethodUtils.hideInputMethod(this.getContext(), this.mEditText);
            this.mEditText.removeTextChangedListener(this.mTextWatcher);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mKeyword = bundle0.getString("argKeyword");
        this.mIsShowPredictiveList = bundle0.getBoolean("argShowPredictiveList");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        RecyclerView recyclerView0 = this.mPredictiveList;
        if(recyclerView0 != null) {
            recyclerView0.addOnItemTouchListener(this.mSearchItemTouchListener);
        }
        EditText editText0 = this.mEditText;
        if(editText0 != null) {
            editText0.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argKeyword", this.mKeyword);
            bundle0.putBoolean("argShowPredictiveList", this.mIsShowPredictiveList);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle("유사곡 추천");
            titleBar0.f(true);
        }
        this.mDefaultText = view0.findViewById(0x7F0A0399);  // id:default_text
        this.mEditText = (EditText)view0.findViewById(0x7F0A0A42);  // id:search_keyword
        this.mBtnRemove = view0.findViewById(0x7F0A0157);  // id:btn_delete
        this.mRemoveIcon = view0.findViewById(0x7F0A039D);  // id:delete_icon
        ViewUtils.setOnClickListener(view0.findViewById(0x7F0A0A40), new View.OnClickListener() {  // id:search_icon
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(ViewUtils.hasStringEditText(ForUSelfRecommendSearchFragment.this.mEditText)) {
                    InputMethodUtils.hideInputMethod(ForUSelfRecommendSearchFragment.this.getContext(), ForUSelfRecommendSearchFragment.this.mEditText);
                    String s = ForUSelfRecommendSearchFragment.this.mEditText.getText().toString();
                    ForUSelfRecommendSearchFragment.this.fetchRecommendSearchList(s);
                    return;
                }
                ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
            }
        });
        this.mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override  // android.widget.TextView$OnEditorActionListener
            public boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
                if(v != 3 && v != 6) {
                    return true;
                }
                if(!ViewUtils.hasStringEditText(ForUSelfRecommendSearchFragment.this.mEditText)) {
                    ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
                    return false;
                }
                InputMethodUtils.hideInputMethod(ForUSelfRecommendSearchFragment.this.getContext(), ForUSelfRecommendSearchFragment.this.mEditText);
                String s = ForUSelfRecommendSearchFragment.this.mEditText.getText().toString();
                ForUSelfRecommendSearchFragment.this.fetchRecommendSearchList(s);
                return true;
            }
        });
        ViewUtils.setOnClickListener(this.mBtnRemove, new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(ForUSelfRecommendSearchFragment.this.mEditText != null) {
                    ForUSelfRecommendSearchFragment.this.mEditText.setText(null);
                    InputMethodUtils.hideInputMethod(ForUSelfRecommendSearchFragment.this.getContext(), ForUSelfRecommendSearchFragment.this.mEditText);
                }
            }
        });
        if(this.mPredictiveList == null) {
            PredictiveAdapter forUSelfRecommendSearchFragment$PredictiveAdapter0 = new PredictiveAdapter(this, this.getContext(), null);
            this.mPredictiveAdapter = forUSelfRecommendSearchFragment$PredictiveAdapter0;
            forUSelfRecommendSearchFragment$PredictiveAdapter0.setEmptyViewInfo(e.n);
        }
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A0957);  // id:popup_list
        this.mPredictiveList = recyclerView0;
        recyclerView0.setHasFixedSize(true);
        this.mPredictiveList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        this.mPredictiveList.setAdapter(this.mPredictiveAdapter);
        EditText editText0 = this.mEditText;
        if(editText0 != null) {
            editText0.setText(this.mKeyword);
            if(TextUtils.isEmpty(this.mKeyword)) {
                InputMethodUtils.showInputMethod(this.getActivity(), this.mEditText);
            }
            else {
                InputMethodUtils.hideInputMethod(this.getActivity(), this.mEditText);
                this.fetchRecommendSearchList(this.mEditText.getText().toString());
            }
        }
        boolean z = false;
        int v = TextUtils.isEmpty(this.mKeyword) ? 0 : this.mKeyword.length();
        ViewUtils.showWhen(this.mRemoveIcon, v > 0);
        View view1 = this.mDefaultText;
        if(v > 0) {
            z = true;
        }
        ViewUtils.hideWhen(view1, z);
        if(this.mIsShowPredictiveList && this.mPredictiveAdapter.getCount() > 0) {
            ViewUtils.showWhen(this.mPredictiveList, true);
        }
    }
}

