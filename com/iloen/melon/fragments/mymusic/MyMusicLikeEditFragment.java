package com.iloen.melon.fragments.mymusic;

import B9.a;
import B9.l;
import B9.w;
import F8.B;
import F8.o;
import U4.x;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListAlbumReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListArtistPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListDjPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListMvReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListPlaylistReq;
import com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListSongReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListAlbumRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListAlbumRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListArtistPlaylistRes.RESPONSE.ARTISTPLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListArtistPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListDjPlaylistRes.RESPONSE.DJPLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListDjPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListMvRes.RESPONSE.MVLIST;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListMvRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListPlaylistRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListPlaylistRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListSongRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListSongRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListSongRes;
import com.iloen.melon.net.v5x.request.MyMusicLikeUpdateListTagReq;
import com.iloen.melon.net.v5x.response.CastInfoBase;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.iloen.melon.net.v5x.response.LikeListTagBaseRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v5x.response.MyMusicLikeUpdateListTagRes;
import com.iloen.melon.net.v6x.request.MyMusicDeleteMultiLikeReq.Params;
import com.iloen.melon.net.v6x.request.MyMusicDeleteMultiLikeReq;
import com.iloen.melon.net.v6x.request.MyMusicLikeUpdateListCastReq;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes.RESPONSE.CASTLIST;
import com.iloen.melon.net.v6x.response.MyMusicDeleteMultiLikeRes;
import com.iloen.melon.net.v6x.response.MyMusicLikeUpdateListCastRes;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl;
import com.iloen.melon.viewholders.PlaylistNewHolderImpl;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.popup.b;
import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import v9.h;
import v9.i;
import v9.m;
import va.e0;

public class MyMusicLikeEditFragment extends MetaContentBaseFragment {
    class LikeAdapter extends p {
        private static final int VIEW_TYPE_ALBUM = 2;
        private static final int VIEW_TYPE_CAST = 7;
        private static final int VIEW_TYPE_DJ_PLAYLIST = 4;
        private static final int VIEW_TYPE_MV = 6;
        private static final int VIEW_TYPE_PLAYLIST = 3;
        private static final int VIEW_TYPE_SONG = 1;
        private static final int VIEW_TYPE_TAG = 5;
        private static final int VIEW_TYPE_UNKNOWN = -1;

        public LikeAdapter(Context context0, List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof SONGLIST) {
                return 1;
            }
            if(object0 instanceof ALBUMLIST) {
                return 2;
            }
            if(object0 instanceof PLAYLISTLIST) {
                return 3;
            }
            if(object0 instanceof DJPLAYLISTLIST) {
                return 4;
            }
            if(object0 instanceof ARTISTPLAYLISTLIST) {
                return 3;
            }
            if(object0 instanceof TAGLIST) {
                return 5;
            }
            if(object0 instanceof MVLIST) {
                return 6;
            }
            return object0 instanceof CASTLIST ? 7 : -1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(String s, i i0, HttpResponse httpResponse0) {
            ArrayList arrayList0 = null;
            if(httpResponse0 instanceof MyMusicLikeUpdateListSongRes) {
                RESPONSE myMusicLikeUpdateListSongRes$RESPONSE0 = ((MyMusicLikeUpdateListSongRes)httpResponse0).response;
                if(myMusicLikeUpdateListSongRes$RESPONSE0 != null) {
                    arrayList0 = myMusicLikeUpdateListSongRes$RESPONSE0.songlist;
                }
            }
            else if(httpResponse0 instanceof MyMusicLikeUpdateListAlbumRes) {
                com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListAlbumRes.RESPONSE myMusicLikeUpdateListAlbumRes$RESPONSE0 = ((MyMusicLikeUpdateListAlbumRes)httpResponse0).response;
                if(myMusicLikeUpdateListAlbumRes$RESPONSE0 != null) {
                    arrayList0 = myMusicLikeUpdateListAlbumRes$RESPONSE0.albumlist;
                }
            }
            else if(httpResponse0 instanceof MyMusicLikeUpdateListPlaylistRes) {
                com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListPlaylistRes.RESPONSE myMusicLikeUpdateListPlaylistRes$RESPONSE0 = ((MyMusicLikeUpdateListPlaylistRes)httpResponse0).response;
                if(myMusicLikeUpdateListPlaylistRes$RESPONSE0 != null) {
                    arrayList0 = myMusicLikeUpdateListPlaylistRes$RESPONSE0.playlistlist;
                }
            }
            else if(httpResponse0 instanceof MyMusicLikeUpdateListDjPlaylistRes) {
                com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListDjPlaylistRes.RESPONSE myMusicLikeUpdateListDjPlaylistRes$RESPONSE0 = ((MyMusicLikeUpdateListDjPlaylistRes)httpResponse0).response;
                if(myMusicLikeUpdateListDjPlaylistRes$RESPONSE0 != null) {
                    arrayList0 = myMusicLikeUpdateListDjPlaylistRes$RESPONSE0.djplaylistlist;
                }
            }
            else if(httpResponse0 instanceof MyMusicLikeUpdateListArtistPlaylistRes) {
                com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListArtistPlaylistRes.RESPONSE myMusicLikeUpdateListArtistPlaylistRes$RESPONSE0 = ((MyMusicLikeUpdateListArtistPlaylistRes)httpResponse0).response;
                if(myMusicLikeUpdateListArtistPlaylistRes$RESPONSE0 != null) {
                    arrayList0 = myMusicLikeUpdateListArtistPlaylistRes$RESPONSE0.artistplaylistlist;
                }
            }
            else if(httpResponse0 instanceof MyMusicLikeUpdateListTagRes) {
                com.iloen.melon.net.v5x.response.LikeListTagBaseRes.RESPONSE likeListTagBaseRes$RESPONSE0 = ((MyMusicLikeUpdateListTagRes)httpResponse0).response;
                if(likeListTagBaseRes$RESPONSE0 != null) {
                    arrayList0 = likeListTagBaseRes$RESPONSE0.taglistList;
                }
            }
            else if(httpResponse0 instanceof MyMusicLikeUpdateListMvRes) {
                com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListMvRes.RESPONSE myMusicLikeUpdateListMvRes$RESPONSE0 = ((MyMusicLikeUpdateListMvRes)httpResponse0).response;
                if(myMusicLikeUpdateListMvRes$RESPONSE0 != null) {
                    arrayList0 = myMusicLikeUpdateListMvRes$RESPONSE0.mvlist;
                }
            }
            else if(httpResponse0 instanceof MyMusicLikeUpdateListCastRes) {
                com.iloen.melon.net.v6x.response.MyMusicCastListRes.RESPONSE myMusicCastListRes$RESPONSE0 = ((MyMusicLikeUpdateListCastRes)httpResponse0).response;
                if(myMusicCastListRes$RESPONSE0 != null) {
                    arrayList0 = myMusicCastListRes$RESPONSE0.castList;
                }
            }
            MyMusicLikeEditFragment.this.showToolbar(arrayList0 != null && !arrayList0.isEmpty());
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            switch(o00.getItemViewType()) {
                case 1: {
                    SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v1);
                    if(songInfoBase0 != null) {
                        ((SongHolder)o00).btnPlay.setVisibility(8);
                        ((SongHolder)o00).btnInfo.setVisibility(8);
                        ((SongHolder)o00).checkIv.setVisibility(0);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.1 myMusicLikeEditFragment$LikeAdapter$10 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((SongHolder)o00).itemView, myMusicLikeEditFragment$LikeAdapter$10);
                        if(this.isMarked(v1)) {
                            ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                            ((SongHolder)o00).checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                        }
                        else {
                            ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                            ((SongHolder)o00).checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        }
                        ImageView imageView0 = ((SongHolder)o00).thumbnailIv;
                        if(imageView0 != null) {
                            Glide.with(imageView0.getContext()).load(songInfoBase0.albumImg).into(((SongHolder)o00).thumbnailIv);
                        }
                        ((SongHolder)o00).titleTv.setText(songInfoBase0.songName);
                        ((SongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
                        ViewUtils.showWhen(((SongHolder)o00).list19Iv, songInfoBase0.isAdult);
                        ViewUtils.showWhen(((SongHolder)o00).listFreeIv, songInfoBase0.isFree);
                        ViewUtils.showWhen(((SongHolder)o00).listHoldbackIv, songInfoBase0.isHoldback);
                        return;
                    }
                    break;
                }
                case 2: {
                    AlbumInfoBase albumInfoBase0 = (AlbumInfoBase)this.getItem(v1);
                    if(albumInfoBase0 != null) {
                        ((AlbumHolder)o00).checkIv.setVisibility(0);
                        ((AlbumHolder)o00).btnPlayIv.setVisibility(8);
                        ((AlbumHolder)o00).arrowIv.setVisibility(8);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.2 myMusicLikeEditFragment$LikeAdapter$20 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((AlbumHolder)o00).itemView, myMusicLikeEditFragment$LikeAdapter$20);
                        if(this.isMarked(v1)) {
                            ((AlbumHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                            ((AlbumHolder)o00).checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                        }
                        else {
                            ((AlbumHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                            ((AlbumHolder)o00).checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        }
                        ImageView imageView1 = ((AlbumHolder)o00).thumbnailIv;
                        if(imageView1 != null) {
                            Glide.with(imageView1.getContext()).load(albumInfoBase0.albumImg).into(((AlbumHolder)o00).thumbnailIv);
                        }
                        ((AlbumHolder)o00).titleTv.setText(albumInfoBase0.albumName);
                        ((AlbumHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(albumInfoBase0.artistList));
                        ((AlbumHolder)o00).issueTv.setText(albumInfoBase0.issueDate);
                        ViewUtils.showWhen(((AlbumHolder)o00).ratingContainer, true);
                        ((AlbumHolder)o00).ratingView.c(albumInfoBase0.totAvrgScore);
                        ((AlbumHolder)o00).ratingText.setText(Float.toString(albumInfoBase0.totAvrgScore));
                        ((AlbumHolder)o00).ratingUserCntTv.setText(StringUtils.getCountString(albumInfoBase0.ptcPnmPrco, 0x3B9AC9FF));
                        return;
                    }
                    break;
                }
                case 3: {
                    ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v1);
                    ViewUtils.hideWhen(((PlaylistNewHolderImpl)o00).moreIv, true);
                    ViewUtils.hideWhen(((PlaylistNewHolderImpl)o00).playIv, true);
                    if(artistPlayListInfoBase0 != null) {
                        ((PlaylistNewHolderImpl)o00).bindView(artistPlayListInfoBase0, v1);
                        ((PlaylistNewHolderImpl)o00).checkIv.setVisibility(0);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.3 myMusicLikeEditFragment$LikeAdapter$30 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((PlaylistNewHolderImpl)o00).itemView, myMusicLikeEditFragment$LikeAdapter$30);
                        if(this.isMarked(v1)) {
                            ((PlaylistNewHolderImpl)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                            ((PlaylistNewHolderImpl)o00).checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                            return;
                        }
                        ((PlaylistNewHolderImpl)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        ((PlaylistNewHolderImpl)o00).checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        return;
                    }
                    break;
                }
                case 4: {
                    DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)this.getItem(v1);
                    ViewUtils.hideWhen(((DjPlaylistNewHolderImpl)o00).moreIv, true);
                    ViewUtils.hideWhen(((DjPlaylistNewHolderImpl)o00).playIv, true);
                    if(djPlayListInfoBase0 != null) {
                        ((DjPlaylistNewHolderImpl)o00).bindView(djPlayListInfoBase0, v1);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.4 myMusicLikeEditFragment$LikeAdapter$40 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((DjPlaylistNewHolderImpl)o00).itemView, myMusicLikeEditFragment$LikeAdapter$40);
                        if(this.isMarked(v1)) {
                            ((DjPlaylistNewHolderImpl)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                            ((DjPlaylistNewHolderImpl)o00).checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                        }
                        else {
                            ((DjPlaylistNewHolderImpl)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                            ((DjPlaylistNewHolderImpl)o00).checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        }
                        ((DjPlaylistNewHolderImpl)o00).checkIv.setVisibility(0);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.5 myMusicLikeEditFragment$LikeAdapter$50 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((DjPlaylistNewHolderImpl)o00).itemView, myMusicLikeEditFragment$LikeAdapter$50);
                        if(this.isMarked(v1)) {
                            ((DjPlaylistNewHolderImpl)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                            ((DjPlaylistNewHolderImpl)o00).checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                            return;
                        }
                        ((DjPlaylistNewHolderImpl)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        ((DjPlaylistNewHolderImpl)o00).checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        return;
                    }
                    break;
                }
                case 5: {
                    ImageView imageView2 = ((w)o00).b;
                    TAGLIST likeListTagBaseRes$RESPONSE$TAGLIST0 = (TAGLIST)this.getItem(v1);
                    if(likeListTagBaseRes$RESPONSE$TAGLIST0 != null) {
                        Context context0 = this.getContext();
                        imageView2.setVisibility(0);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.7 myMusicLikeEditFragment$LikeAdapter$70 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((w)o00).itemView, myMusicLikeEditFragment$LikeAdapter$70);
                        if(this.isMarked(v1)) {
                            int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                            ((w)o00).itemView.setBackgroundColor(v2);
                            imageView2.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                        }
                        else {
                            int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                            ((w)o00).itemView.setBackgroundColor(v3);
                            imageView2.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        }
                        ImageView imageView3 = ((w)o00).a;
                        if(imageView3 != null) {
                            Glide.with(context0).clear(imageView3);
                            Glide.with(context0).load(likeListTagBaseRes$RESPONSE$TAGLIST0.tagImg).into(imageView3);
                        }
                        String s = context0.getString(0x7F130773, new Object[]{likeListTagBaseRes$RESPONSE$TAGLIST0.tagName});  // string:mymusic_like_tag_title "#%1$s"
                        ((w)o00).c.setText(s);
                        String s1 = context0.getString(0x7F130772, new Object[]{StringUtils.getCountString(likeListTagBaseRes$RESPONSE$TAGLIST0.plylstCnt, 0x3B9AC9FF)});  // string:mymusic_like_tag_playlist_count "관련 플레이리스트 %1$s"
                        ((w)o00).d.setText(s1);
                        String s2 = StringUtils.getCountString(likeListTagBaseRes$RESPONSE$TAGLIST0.summcnt, 0x3B9AC9FF);
                        ((w)o00).e.setText(s2);
                        return;
                    }
                    break;
                }
                case 6: {
                    MvInfoBase mvInfoBase0 = (MvInfoBase)this.getItem(v1);
                    if(mvInfoBase0 != null) {
                        ((l)o00).checkIv.setVisibility(0);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.6 myMusicLikeEditFragment$LikeAdapter$60 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((l)o00).itemView, myMusicLikeEditFragment$LikeAdapter$60);
                        if(this.isMarked(v1)) {
                            int v4 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                            ((l)o00).itemView.setBackgroundColor(v4);
                            ((l)o00).checkIv.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                        }
                        else {
                            int v5 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                            ((l)o00).itemView.setBackgroundColor(v5);
                            ((l)o00).checkIv.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        }
                        ImageView imageView4 = ((l)o00).thumbnailIv;
                        if(imageView4 != null) {
                            Glide.with(imageView4.getContext()).load(mvInfoBase0.mvImg).into(((l)o00).thumbnailIv);
                        }
                        ((l)o00).titleTv.setText("null");
                        ((l)o00).artistTv.setText(ProtocolUtils.getArtistNames(mvInfoBase0.artistList));
                        ViewUtils.showWhen(((l)o00).issueTv, !TextUtils.isEmpty(mvInfoBase0.issueDate));
                        ((l)o00).issueTv.setText(mvInfoBase0.issueDate);
                        ((l)o00).viewCountTv.setText(StringUtils.getCountString(mvInfoBase0.viewCnt, 0x3B9AC9FF));
                        ViewUtils.setTimeForSecText(((l)o00).playtimeTv, mvInfoBase0.playTime);
                        ((l)o00).gradeIv.setVisibility(8);
                        if(!TextUtils.isEmpty(mvInfoBase0.adultGrade)) {
                            int v6 = ResourceUtils.getMvAdultGradeIcon(mvInfoBase0.adultGrade);
                            if(v6 == -1) {
                                ((l)o00).gradeIv.setVisibility(8);
                            }
                            else {
                                ((l)o00).gradeIv.setVisibility(0);
                                ((l)o00).gradeIv.setBackgroundResource(v6);
                            }
                        }
                        ViewUtils.hideWhen(((l)o00).moreIv, true);
                        return;
                    }
                    break;
                }
                case 7: {
                    ImageView imageView5 = ((a)o00).f;
                    CASTLIST myMusicCastListRes$RESPONSE$CASTLIST0 = (CASTLIST)this.getItem(v1);
                    if(myMusicCastListRes$RESPONSE$CASTLIST0 != null) {
                        imageView5.setVisibility(0);
                        Glide.with(this.getContext()).load(myMusicCastListRes$RESPONSE$CASTLIST0.castImgUrl).into(((a)o00).a);
                        ((a)o00).b.setText(myMusicCastListRes$RESPONSE$CASTLIST0.castTitle);
                        String s3 = CreatorInfoBase.getCreatorNames(this.getContext(), myMusicCastListRes$RESPONSE$CASTLIST0.creator, true);
                        ((a)o00).c.setText(s3);
                        ((a)o00).d.setText(myMusicCastListRes$RESPONSE$CASTLIST0.castDate);
                        String s4 = StringUtils.getCountFormattedString(myMusicCastListRes$RESPONSE$CASTLIST0.likeCnt);
                        ((a)o00).e.setText(s4);
                        com.iloen.melon.fragments.mymusic.MyMusicLikeEditFragment.LikeAdapter.8 myMusicLikeEditFragment$LikeAdapter$80 = new View.OnClickListener() {
                            @Override  // android.view.View$OnClickListener
                            public void onClick(View view0) {
                                MyMusicLikeEditFragment.this.onItemClick(view0, v);
                            }
                        };
                        ViewUtils.setOnClickListener(((a)o00).itemView, myMusicLikeEditFragment$LikeAdapter$80);
                        if(this.isMarked(v1)) {
                            int v7 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                            ((a)o00).itemView.setBackgroundColor(v7);
                            imageView5.setImageResource(0x7F080123);  // drawable:btn_common_check_01_s_tint
                            return;
                        }
                        int v8 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                        ((a)o00).itemView.setBackgroundColor(v8);
                        imageView5.setImageResource(0x7F080121);  // drawable:btn_common_check_01_n_tint
                        return;
                    }
                    break;
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
                }
                case 2: {
                    return new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false));  // layout:listitem_album
                }
                case 3: {
                    return new PlaylistNewHolderImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D049F, viewGroup0, false));  // layout:listitem_playlist_new
                }
                case 4: {
                    return new DjPlaylistNewHolderImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D048E, viewGroup0, false));  // layout:listitem_djplaylist_new
                }
                case 5: {
                    return new w(LayoutInflater.from(this.getContext()).inflate(0x7F0D04B5, viewGroup0, false));  // layout:listitem_tag
                }
                case 6: {
                    return new l(LayoutInflater.from(this.getContext()).inflate(0x7F0D04BB, viewGroup0, false));  // layout:listitem_video
                }
                case 7: {
                    return new a(LayoutInflater.from(this.getContext()).inflate(0x7F0D046C, viewGroup0, false));  // layout:listitem_cast
                }
                default: {
                    return null;
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void setMarked(int v, boolean z) {
            if(z && this.getMarkedCount() >= 20) {
                l0 l00 = MyMusicLikeEditFragment.this.getChildFragmentManager();
                String s = MyMusicLikeEditFragment.this.getString(0x7F130770);  // string:mymusic_like_edit "좋아요 편집"
                String s1 = MyMusicLikeEditFragment.this.getString(0x7F13009B, new Object[]{20});  // string:alert_dlg_body_delete_sel_likelist_overcount "좋아요 취소는 한번에 최대 %1$d개까지 가능합니다."
                b.a.c(l00, s, s1);
                return;
            }
            super.setMarked(v, z);
        }
    }

    private static final String ARG_CACHE_KEY = "argCacheKey";
    private static final String ARG_FILTER_TYPE = "argFilterType";
    private static final String ARG_MENU_SEQ = "argMenuSeq";
    private static final String ARG_ORDER_TYPE = "argOrderType";
    private static final String TAG = "MyMusicLikeEditFragment";
    private ArrayList mDeleteItemList;
    private String mFilterType;
    private String mLikeCacheKey;
    private String mMenuSeq;
    private String mOrderBy;

    public MyMusicLikeEditFragment() {
        this.mFilterType = "";
        this.mMenuSeq = "";
        this.mOrderBy = "";
        this.mLikeCacheKey = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.findViewById(0x7F0A0BC6)), 501);  // id:toolbar_layout
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        j0 j00 = new LikeAdapter(this, context0, null);
        ((j)j00).setEditMode(true);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(1);
        return j00;
    }

    private void deleteRequest() {
        String s1;
        ArrayList arrayList0 = this.mDeleteItemList;
        if(arrayList0 == null) {
            this.mDeleteItemList = new ArrayList();
        }
        else {
            arrayList0.clear();
        }
        int v = 0;
        m m0 = this.getMarkedList(false);
        if(m0 != null) {
            ArrayList arrayList1 = m0.d;
            if(!m0.a) {
                LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
                String s = "";
                if(arrayList1 != null && arrayList1.size() > 0) {
                    this.mDeleteItemList.addAll(arrayList1);
                    while(v < this.mDeleteItemList.size()) {
                        if("song".equals(this.mFilterType)) {
                            SongInfoBase songInfoBase0 = (SongInfoBase)myMusicLikeEditFragment$LikeAdapter0.getItem(((int)(((Integer)this.mDeleteItemList.get(v)))));
                            if(v == this.mDeleteItemList.size() - 1) {
                                StringBuilder stringBuilder0 = Y.p(s);
                                stringBuilder0.append(songInfoBase0.songId);
                                s1 = stringBuilder0.toString();
                            }
                            else {
                                s1 = x.m(Y.p(s), songInfoBase0.songId, ",");
                            }
                            goto label_77;
                        }
                        else if("album".equals(this.mFilterType)) {
                            AlbumInfoBase albumInfoBase0 = (AlbumInfoBase)myMusicLikeEditFragment$LikeAdapter0.getItem(((int)(((Integer)this.mDeleteItemList.get(v)))));
                            if(v == this.mDeleteItemList.size() - 1) {
                                StringBuilder stringBuilder1 = Y.p(s);
                                stringBuilder1.append(albumInfoBase0.albumId);
                                s1 = stringBuilder1.toString();
                            }
                            else {
                                s1 = x.m(Y.p(s), albumInfoBase0.albumId, ",");
                            }
                            goto label_77;
                        }
                        else if("playlist".equals(this.mFilterType) || "artist_playlist".equals(this.mFilterType)) {
                            ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)myMusicLikeEditFragment$LikeAdapter0.getItem(((int)(((Integer)this.mDeleteItemList.get(v)))));
                            if(v == this.mDeleteItemList.size() - 1) {
                                StringBuilder stringBuilder6 = Y.p(s);
                                stringBuilder6.append(artistPlayListInfoBase0.plylstseq);
                                s1 = stringBuilder6.toString();
                            }
                            else {
                                s1 = x.m(Y.p(s), artistPlayListInfoBase0.plylstseq, ",");
                            }
                        label_77:
                            s = s1;
                        }
                        else if("dj_playlist".equals(this.mFilterType)) {
                            DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)myMusicLikeEditFragment$LikeAdapter0.getItem(((int)(((Integer)this.mDeleteItemList.get(v)))));
                            if(v == this.mDeleteItemList.size() - 1) {
                                StringBuilder stringBuilder2 = Y.p(s);
                                stringBuilder2.append(djPlayListInfoBase0.plylstseq);
                                s1 = stringBuilder2.toString();
                            }
                            else {
                                s1 = x.m(Y.p(s), djPlayListInfoBase0.plylstseq, ",");
                            }
                            goto label_77;
                        }
                        else if("tag".equals(this.mFilterType)) {
                            TAGLIST likeListTagBaseRes$RESPONSE$TAGLIST0 = (TAGLIST)myMusicLikeEditFragment$LikeAdapter0.getItem(((int)(((Integer)this.mDeleteItemList.get(v)))));
                            if(v == this.mDeleteItemList.size() - 1) {
                                StringBuilder stringBuilder3 = Y.p(s);
                                stringBuilder3.append(likeListTagBaseRes$RESPONSE$TAGLIST0.tagSeq);
                                s1 = stringBuilder3.toString();
                            }
                            else {
                                s1 = x.m(Y.p(s), likeListTagBaseRes$RESPONSE$TAGLIST0.tagSeq, ",");
                            }
                            goto label_77;
                        }
                        else if("mv".equals(this.mFilterType)) {
                            MvInfoBase mvInfoBase0 = (MvInfoBase)myMusicLikeEditFragment$LikeAdapter0.getItem(((int)(((Integer)this.mDeleteItemList.get(v)))));
                            if(v == this.mDeleteItemList.size() - 1) {
                                StringBuilder stringBuilder4 = Y.p(s);
                                stringBuilder4.append(mvInfoBase0.mvId);
                                s1 = stringBuilder4.toString();
                            }
                            else {
                                s1 = x.m(Y.p(s), mvInfoBase0.mvId, ",");
                            }
                            goto label_77;
                        }
                        else if("cast".equals(this.mFilterType)) {
                            CastInfoBase castInfoBase0 = (CastInfoBase)myMusicLikeEditFragment$LikeAdapter0.getItem(((int)(((Integer)this.mDeleteItemList.get(v)))));
                            if(v == this.mDeleteItemList.size() - 1) {
                                StringBuilder stringBuilder5 = Y.p(s);
                                stringBuilder5.append(castInfoBase0.castSeq);
                                s1 = stringBuilder5.toString();
                            }
                            else {
                                s1 = x.m(Y.p(s), castInfoBase0.castSeq, ",");
                            }
                            goto label_77;
                        }
                        ++v;
                    }
                }
                Params myMusicDeleteMultiLikeReq$Params0 = new Params();
                if("song".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10001";
                }
                else if("album".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10002";
                }
                else if("playlist".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10005";
                }
                else if("dj_playlist".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10009";
                }
                else if("artist_playlist".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10016";
                }
                else if("tag".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10030";
                }
                else if("mv".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10003";
                }
                else if("cast".equals(this.mFilterType)) {
                    myMusicDeleteMultiLikeReq$Params0.contsTypeCode = "N10082";
                }
                myMusicDeleteMultiLikeReq$Params0.contentsIds = s;
                myMusicDeleteMultiLikeReq$Params0.menuId = myMusicLikeEditFragment$LikeAdapter0.getMenuId();
                RequestBuilder.newInstance(new MyMusicDeleteMultiLikeReq(this.getContext(), myMusicDeleteMultiLikeReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
                    public void onResponse(MyMusicDeleteMultiLikeRes myMusicDeleteMultiLikeRes0) {
                        if(MyMusicLikeEditFragment.this.isFragmentValid() && myMusicDeleteMultiLikeRes0.isSuccessful()) {
                            TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y0.toString());
                            myMusicLikeEditFragment$LikeAdapter0.setUnmarkedAll();
                            MyMusicLikeEditFragment.this.updateToolBar(true);
                            for(int v = MyMusicLikeEditFragment.f0(MyMusicLikeEditFragment.this).size() - 1; v >= 0; --v) {
                                int v1 = (int)(((Integer)MyMusicLikeEditFragment.f0(MyMusicLikeEditFragment.this).get(v)));
                                myMusicLikeEditFragment$LikeAdapter0.remove(v1);
                            }
                            if(MyMusicLikeEditFragment.this.getItemCount() <= 0) {
                                MyMusicLikeEditFragment.this.startFetch("all data delete");
                            }
                        }
                    }

                    @Override  // com.android.volley.Response$Listener
                    public void onResponse(Object object0) {
                        this.onResponse(((MyMusicDeleteMultiLikeRes)object0));
                    }
                }).errorListener(new ErrorListener() {
                    @Override  // com.android.volley.Response$ErrorListener
                    public void onErrorResponse(VolleyError volleyError0) {
                        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                    }
                }).request();
            }
        }
    }

    public static ArrayList f0(MyMusicLikeEditFragment myMusicLikeEditFragment0) {
        return myMusicLikeEditFragment0.mDeleteItemList;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.T.toString();
    }

    private H lambda$onToolBarClick$1() {
        this.deleteRequest();
        return null;
    }

    private void lambda$requestLikeCast$0(i i0, MyMusicLikeUpdateListCastRes myMusicLikeUpdateListCastRes0) {
        if(!this.prepareFetchComplete(myMusicLikeUpdateListCastRes0)) {
            this.showToolbar(false);
            return;
        }
        this.performFetchComplete(i0, myMusicLikeUpdateListCastRes0);
    }

    public static MyMusicLikeEditFragment newInstance(String s, String s1, String s2) {
        return MyMusicLikeEditFragment.newInstance(s, "", s1, s2);
    }

    public static MyMusicLikeEditFragment newInstance(String s, String s1, String s2, String s3) {
        MyMusicLikeEditFragment myMusicLikeEditFragment0 = new MyMusicLikeEditFragment();
        Bundle bundle0 = Y.c("argFilterType", s, "argMenuSeq", s1);
        bundle0.putString("argOrderType", s2);
        bundle0.putString("argCacheKey", s3);
        myMusicLikeEditFragment0.setArguments(bundle0);
        return myMusicLikeEditFragment0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        TimeExpiredCache.getInstance().remove(this.mLikeCacheKey);
        return super.onBackPressed();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView0.setAdapter(this.mAdapter);
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0565, viewGroup0, false);  // layout:mymusic_like_edit
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onEditButtonClick(boolean z, boolean z1) {
        this.performBackPress();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        if(i.b.equals(i0)) {
            myMusicLikeEditFragment$LikeAdapter0.clear();
        }
        if("song".equals(this.mFilterType)) {
            this.requestLikeSong(i0);
            return true;
        }
        if("album".equals(this.mFilterType)) {
            this.requestLikeAlbum(i0);
            return true;
        }
        if("playlist".equals(this.mFilterType)) {
            this.requestLikePlaylist(i0);
            return true;
        }
        if("dj_playlist".equals(this.mFilterType)) {
            this.requestLikeDjPlaylist(i0);
            return true;
        }
        if("artist_playlist".equals(this.mFilterType)) {
            this.requestLikeArtistPlaylist(i0);
            return true;
        }
        if("tag".equals(this.mFilterType)) {
            this.requestLikeTag(i0);
            return true;
        }
        if("mv".equals(this.mFilterType)) {
            this.requestLikeMv(i0);
            return true;
        }
        if("cast".equals(this.mFilterType)) {
            this.requestLikeCast(i0);
        }
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
        this.mFilterType = bundle0.getString("argFilterType");
        this.mMenuSeq = bundle0.getString("argMenuSeq");
        this.mOrderBy = bundle0.getString("argOrderType");
        this.mLikeCacheKey = bundle0.getString("argCacheKey");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putString("argFilterType", this.mFilterType);
            bundle0.putString("argMenuSeq", this.mMenuSeq);
            bundle0.putString("argOrderType", this.mOrderBy);
            bundle0.putString("argCacheKey", this.mLikeCacheKey);
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(ToolBarItem toolBar$ToolBarItem0, int v) {
        if(11 == v) {
            if(!this.isLoginUser()) {
                ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
                return;
            }
            if(((LikeAdapter)this.mAdapter) != null) {
                int v1 = this.getMarkedList(false).d.size();
                String s = "";
                if(v1 <= 0) {
                    if("song".equals(this.mFilterType)) {
                        s = this.getString(0x7F1300A4);  // string:alert_dlg_body_delete_song_select_content "곡을 선택해 주세요."
                    }
                    else if("album".equals(this.mFilterType)) {
                        s = this.getString(0x7F13007E);  // string:alert_dlg_body_delete_album_select_content "앨범을 선택해 주세요."
                    }
                    else if("playlist".equals(this.mFilterType)) {
                        s = this.getString(0x7F130091);  // string:alert_dlg_body_delete_playlist_select_content "플레이리스트를 선택해 주세요."
                    }
                    else if("dj_playlist".equals(this.mFilterType)) {
                        s = this.getString(0x7F130082);  // string:alert_dlg_body_delete_djplaylist_select_content "DJ플레이리스트를 선택해 주세요."
                    }
                    else if("artist_playlist".equals(this.mFilterType)) {
                        s = this.getString(0x7F130080);  // string:alert_dlg_body_delete_artistplaylist_select_content "아티스트 플레이리스트를 선택해 주세요."
                    }
                    else if("tag".equals(this.mFilterType)) {
                        s = this.getString(0x7F1300A5);  // string:alert_dlg_body_delete_tag_select_content "태그를 선택해 주세요."
                    }
                    else if("mv".equals(this.mFilterType)) {
                        s = this.getString(0x7F13008B);  // string:alert_dlg_body_delete_mv_select_content "비디오를 선택해 주세요."
                    }
                    else if("cast".equals(this.mFilterType)) {
                        s = this.getString(0x7F130081);  // string:alert_dlg_body_delete_cast_select_content "스테이션을 선택해 주세요."
                    }
                    l0 l00 = this.getChildFragmentManager();
                    String s1 = this.getString(0x7F130770);  // string:mymusic_like_edit "좋아요 편집"
                    b.a.c(l00, s1, s);
                    return;
                }
                if("song".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F13009E), v1);  // string:alert_dlg_body_delete_sel_likesong_content_toolbar "%1$d곡을 좋아요 취소하시겠습니까?"
                }
                else if("album".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F130097), v1);  // string:alert_dlg_body_delete_sel_likealbum_content_toolbar "앨범 %1$d개를 좋아요 취소하시겠습니까?"
                }
                else if("playlist".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F13009D), v1);  // string:alert_dlg_body_delete_sel_likeplaylist_content_toolbar "플레이리스트 %1$d개를 좋아요 
                                                                        // 취소하시겠습니까?"
                }
                else if("dj_playlist".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F13009A), v1);  // string:alert_dlg_body_delete_sel_likedjplaylist_content_toolbar "DJ플레이리스트 %1$d개를 
                                                                        // 좋아요 취소하시겠습니까?"
                }
                else if("artist_playlist".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F130098), v1);  // string:alert_dlg_body_delete_sel_likeartistplaylist_content_toolbar "아티스트 플레이리스트 
                                                                        // %1$d개를 좋아요 취소하시겠습니까?"
                }
                else if("tag".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F13009F), v1);  // string:alert_dlg_body_delete_sel_liketag_content_toolbar "태그 %1$d개를 좋아요 취소하시겠습니까?"
                }
                else if("mv".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F13009C), v1);  // string:alert_dlg_body_delete_sel_likemv_content_toolbar "비디오 %1$d개를 좋아요 취소하시겠습니까?"
                }
                else if("cast".equals(this.mFilterType)) {
                    s = String.format(this.getString(0x7F130099), v1);  // string:alert_dlg_body_delete_sel_likecast_content_toolbar "스테이션 %1$d개를 좋아요 취소하시겠습니까?"
                }
                b.v(this.getChildFragmentManager(), this.getString(0x7F130770), s, false, null, null, new k(this, 2), null);  // string:mymusic_like_edit "좋아요 편집"
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = (TitleBar)view0.findViewById(0x7F0A0BAD);  // id:titlebar
        F8.p p0 = new F8.p(1);
        B b0 = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.c = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MyMusicLikeEditFragment.this.performBackPress();
                TimeExpiredCache.getInstance().remove(MyMusicLikeEditFragment.this.mLikeCacheKey);
            }
        };
        o[] arr_o = {p0, new F8.m(2, false), b0};
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
        titleBar0.setTitle(this.getString(0x7F130770));  // string:mymusic_like_edit "좋아요 편집"
        titleBar0.f(true);
    }

    private void requestLikeAlbum(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v4x.request.LikeListAlbumBaseReq.Params likeListAlbumBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListAlbumBaseReq.Params();
        likeListAlbumBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        likeListAlbumBaseReq$Params0.pageSize = 100;
        likeListAlbumBaseReq$Params0.orderBy = this.mOrderBy;
        likeListAlbumBaseReq$Params0.targetMemberKey = u.v(((e0)va.o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeUpdateListAlbumReq(this.getContext(), likeListAlbumBaseReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeUpdateListAlbumRes myMusicLikeUpdateListAlbumRes0) {
                if(!MyMusicLikeEditFragment.this.prepareFetchComplete(myMusicLikeUpdateListAlbumRes0)) {
                    MyMusicLikeEditFragment.this.showToolbar(false);
                    return;
                }
                MyMusicLikeEditFragment.this.performFetchComplete(i0, myMusicLikeUpdateListAlbumRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeUpdateListAlbumRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private void requestLikeArtistPlaylist(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v4x.request.LikeListArtistPlaylistBaseReq.Params likeListArtistPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListArtistPlaylistBaseReq.Params();
        likeListArtistPlaylistBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        likeListArtistPlaylistBaseReq$Params0.pageSize = 100;
        likeListArtistPlaylistBaseReq$Params0.orderBy = this.mOrderBy;
        likeListArtistPlaylistBaseReq$Params0.targetMemberKey = u.v(((e0)va.o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeUpdateListArtistPlaylistReq(this.getContext(), likeListArtistPlaylistBaseReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeUpdateListArtistPlaylistRes myMusicLikeUpdateListArtistPlaylistRes0) {
                if(!MyMusicLikeEditFragment.this.prepareFetchComplete(myMusicLikeUpdateListArtistPlaylistRes0)) {
                    MyMusicLikeEditFragment.this.showToolbar(false);
                    return;
                }
                MyMusicLikeEditFragment.this.performFetchComplete(i0, myMusicLikeUpdateListArtistPlaylistRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeUpdateListArtistPlaylistRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private void requestLikeCast(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v6x.request.MyMusicLikeListCastBaseReq.Params myMusicLikeListCastBaseReq$Params0 = new com.iloen.melon.net.v6x.request.MyMusicLikeListCastBaseReq.Params();
        myMusicLikeListCastBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        myMusicLikeListCastBaseReq$Params0.pageSize = 100;
        myMusicLikeListCastBaseReq$Params0.orderBy = this.mOrderBy;
        RequestBuilder.newInstance(new MyMusicLikeUpdateListCastReq(this.getContext(), myMusicLikeListCastBaseReq$Params0)).tag("MyMusicLikeEditFragment").listener(new g(this, i0, 14)).errorListener(this.mResponseErrorListener).request();
    }

    private void requestLikeDjPlaylist(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v4x.request.LikeListDjPlaylistBaseReq.Params likeListDjPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListDjPlaylistBaseReq.Params();
        likeListDjPlaylistBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        likeListDjPlaylistBaseReq$Params0.pageSize = 100;
        likeListDjPlaylistBaseReq$Params0.orderBy = this.mOrderBy;
        likeListDjPlaylistBaseReq$Params0.targetMemberKey = u.v(((e0)va.o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeUpdateListDjPlaylistReq(this.getContext(), likeListDjPlaylistBaseReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeUpdateListDjPlaylistRes myMusicLikeUpdateListDjPlaylistRes0) {
                if(!MyMusicLikeEditFragment.this.prepareFetchComplete(myMusicLikeUpdateListDjPlaylistRes0)) {
                    MyMusicLikeEditFragment.this.showToolbar(false);
                    return;
                }
                MyMusicLikeEditFragment.this.performFetchComplete(i0, myMusicLikeUpdateListDjPlaylistRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeUpdateListDjPlaylistRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private void requestLikeMv(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListMvReq.Params myMusicLikeUpdateListMvReq$Params0 = new com.iloen.melon.net.v4x.request.MyMusicLikeUpdateListMvReq.Params();
        myMusicLikeUpdateListMvReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        myMusicLikeUpdateListMvReq$Params0.pageSize = 100;
        myMusicLikeUpdateListMvReq$Params0.menuSeq = this.mMenuSeq;
        myMusicLikeUpdateListMvReq$Params0.orderBy = this.mOrderBy;
        myMusicLikeUpdateListMvReq$Params0.targetMemberKey = u.v(((e0)va.o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeUpdateListMvReq(this.getContext(), myMusicLikeUpdateListMvReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeUpdateListMvRes myMusicLikeUpdateListMvRes0) {
                if(!MyMusicLikeEditFragment.this.prepareFetchComplete(myMusicLikeUpdateListMvRes0)) {
                    MyMusicLikeEditFragment.this.showToolbar(false);
                    return;
                }
                MyMusicLikeEditFragment.this.performFetchComplete(i0, myMusicLikeUpdateListMvRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeUpdateListMvRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private void requestLikePlaylist(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params likeListPlaylistBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListPlaylistBaseReq.Params();
        likeListPlaylistBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        likeListPlaylistBaseReq$Params0.pageSize = 100;
        likeListPlaylistBaseReq$Params0.orderBy = this.mOrderBy;
        likeListPlaylistBaseReq$Params0.targetMemberKey = u.v(((e0)va.o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeUpdateListPlaylistReq(this.getContext(), likeListPlaylistBaseReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeUpdateListPlaylistRes myMusicLikeUpdateListPlaylistRes0) {
                if(!MyMusicLikeEditFragment.this.prepareFetchComplete(myMusicLikeUpdateListPlaylistRes0)) {
                    MyMusicLikeEditFragment.this.showToolbar(false);
                    return;
                }
                MyMusicLikeEditFragment.this.performFetchComplete(i0, myMusicLikeUpdateListPlaylistRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeUpdateListPlaylistRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private void requestLikeSong(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params likeListSongBaseReq$Params0 = new com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params();
        likeListSongBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        likeListSongBaseReq$Params0.pageSize = 100;
        likeListSongBaseReq$Params0.orderBy = this.mOrderBy;
        likeListSongBaseReq$Params0.targetMemberKey = u.v(((e0)va.o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeUpdateListSongReq(this.getContext(), likeListSongBaseReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeUpdateListSongRes myMusicLikeUpdateListSongRes0) {
                if(!MyMusicLikeEditFragment.this.prepareFetchComplete(myMusicLikeUpdateListSongRes0)) {
                    MyMusicLikeEditFragment.this.showToolbar(false);
                    return;
                }
                MyMusicLikeEditFragment.this.performFetchComplete(i0, myMusicLikeUpdateListSongRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeUpdateListSongRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    private void requestLikeTag(i i0) {
        LikeAdapter myMusicLikeEditFragment$LikeAdapter0 = (LikeAdapter)this.mAdapter;
        com.iloen.melon.net.v5x.request.LikeListTagBaseReq.Params likeListTagBaseReq$Params0 = new com.iloen.melon.net.v5x.request.LikeListTagBaseReq.Params();
        likeListTagBaseReq$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicLikeEditFragment$LikeAdapter0.getCount() + 1;
        likeListTagBaseReq$Params0.pageSize = 100;
        likeListTagBaseReq$Params0.orderBy = this.mOrderBy;
        likeListTagBaseReq$Params0.targetMemberKey = u.v(((e0)va.o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeUpdateListTagReq(this.getContext(), likeListTagBaseReq$Params0)).tag("MyMusicLikeEditFragment").listener(new Listener() {
            public void onResponse(MyMusicLikeUpdateListTagRes myMusicLikeUpdateListTagRes0) {
                if(!MyMusicLikeEditFragment.this.prepareFetchComplete(myMusicLikeUpdateListTagRes0)) {
                    MyMusicLikeEditFragment.this.showToolbar(false);
                    return;
                }
                MyMusicLikeEditFragment.this.performFetchComplete(i0, myMusicLikeUpdateListTagRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MyMusicLikeUpdateListTagRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private void showToolbar(boolean z) {
        ToolBar toolBar0 = this.mToolBar;
        if(toolBar0 != null) {
            if(z) {
                this.showToolBar();
                this.mToolBar.i(true);
                return;
            }
            toolBar0.i(false);
            this.hideToolBar();
        }
    }
}

