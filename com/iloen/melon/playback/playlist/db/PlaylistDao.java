package com.iloen.melon.playback.playlist.db;

import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/PlaylistDao;", "Lcom/iloen/melon/playback/playlist/db/MusicPlaylistDao;", "Lcom/iloen/melon/playback/playlist/db/EduPlaylistDao;", "Lcom/iloen/melon/playback/playlist/db/SmartPlaylistDao;", "Lcom/iloen/melon/playback/playlist/db/MixUpPlaylistDao;", "Lcom/iloen/melon/playback/playlist/db/MixUpWaitingBackDao;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface PlaylistDao extends EduPlaylistDao, MixUpPlaylistDao, MixUpWaitingBackDao, MusicPlaylistDao, SmartPlaylistDao {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object clearAndInsert(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.clearAndInsert(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object clearAndInsertEduInTransaction(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.clearAndInsertEduInTransaction(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object clearAndInsertMixUpEntities(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.clearAndInsertMixUpEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object clearAndInsertMusicInTransaction(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.clearAndInsertMusicInTransaction(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object clearAndInsertSmartEntities(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.clearAndInsertSmartEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertEdusAndUpdateOrderInTransaction(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteAndInsertEdusAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertMusicsAndUpdateOrderInTransaction(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteAndInsertMusicsAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteEduList(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteEduList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteMixUpEntities(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteMixUpEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteMusicList(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteMusicList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteSmartEntities(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.deleteSmartEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertEdusAndUpdateOrderInTransaction(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.insertEdusAndUpdateOrderInTransaction(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertMixUpEntitiesAndUpdateOrder(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.insertMixUpEntitiesAndUpdateOrder(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertMusicsAndUpdateOrderInTransaction(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.insertMusicsAndUpdateOrderInTransaction(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertSmartEntitiesAndUpdateOrder(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.insertSmartEntitiesAndUpdateOrder(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object popTopN(@NotNull PlaylistDao playlistDao0, int v, @NotNull Continuation continuation0) {
            return playlistDao0.super.popTopN(v, continuation0);
        }

        @Deprecated
        @Nullable
        public static Object updateDisPlayOrderEduList(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.updateDisPlayOrderEduList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object updateDisPlayOrderMusicList(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.updateDisPlayOrderMusicList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object updateOrdersMixUp(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.updateOrdersMixUp(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object updateOrdersSmart(@NotNull PlaylistDao playlistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = playlistDao0.super.updateOrdersSmart(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }
    }

}

