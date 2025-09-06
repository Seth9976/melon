package com.iloen.melon.playback;

import Cb.i;
import E9.w;
import O8.d;
import android.text.TextUtils;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k9.b;
import k9.c;
import k9.e;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x8.f;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 )2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u0011H\u0002¢\u0006\u0004\b\u001D\u0010\u001EJ\u001A\u0010 \u001A\u00020\u00032\b\u0010\u001F\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b \u0010!J\u001D\u0010$\u001A\u00020\u00172\u0006\u0010\"\u001A\u00020\u00172\u0006\u0010#\u001A\u00020\u0017¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001A\u0004\b\'\u0010(¨\u0006+"}, d2 = {"Lcom/iloen/melon/playback/TaskValidatePremiumContents;", "Lx8/f;", "Ljava/lang/Void;", "Lie/H;", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(Lcom/iloen/melon/playback/Playable;)V", "", "imageUrl", "getImageETag", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/iloen/melon/premium/PremiumContentsEntity;", "entity", "updateContentImages", "(Lcom/iloen/melon/premium/PremiumContentsEntity;)V", "albumId", "Lcom/iloen/melon/playback/TaskValidatePremiumContents$ContentsInfo;", "findPremiumContents", "(Lcom/iloen/melon/premium/PremiumContentsEntity;Ljava/lang/String;)Lcom/iloen/melon/playback/TaskValidatePremiumContents$ContentsInfo;", "contents", "preparePremiumContents", "(Lcom/iloen/melon/playback/TaskValidatePremiumContents$ContentsInfo;Lcom/iloen/melon/playback/Playable;)Lcom/iloen/melon/playback/TaskValidatePremiumContents$ContentsInfo;", "Ljava/io/File;", "target", "downloadImage", "(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;", "previousContents", "updateContents", "updatePremiumContents", "(Lcom/iloen/melon/playback/TaskValidatePremiumContents$ContentsInfo;Lcom/iloen/melon/playback/TaskValidatePremiumContents$ContentsInfo;)V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "src", "des", "changeFile", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "()Lcom/iloen/melon/playback/Playable;", "Companion", "ContentsInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TaskValidatePremiumContents extends f {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/playback/TaskValidatePremiumContents$Companion;", "", "<init>", "()V", "Lcom/iloen/melon/playback/Playable;", "playable", "Lie/H;", "startValidation", "(Lcom/iloen/melon/playback/Playable;)V", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void startValidation(@Nullable Playable playable0) {
            if(playable0 == null) {
                return;
            }
            LogU.Companion.i("TaskValidatePremiumContents", "startValidation() - ");
            new TaskValidatePremiumContents(playable0).execute(null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/playback/TaskValidatePremiumContents$ContentsInfo;", "", "<init>", "()V", "imageFile", "Ljava/io/File;", "getImageFile", "()Ljava/io/File;", "setImageFile", "(Ljava/io/File;)V", "thumbnailFile", "getThumbnailFile", "setThumbnailFile", "entityList", "", "Lcom/iloen/melon/premium/PremiumContentsEntity;", "getEntityList", "()Ljava/util/List;", "setEntityList", "(Ljava/util/List;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ContentsInfo {
        public List entityList;
        public File imageFile;
        public File thumbnailFile;

        @NotNull
        public final List getEntityList() {
            List list0 = this.entityList;
            if(list0 != null) {
                return list0;
            }
            q.m("entityList");
            throw null;
        }

        @NotNull
        public final File getImageFile() {
            File file0 = this.imageFile;
            if(file0 != null) {
                return file0;
            }
            q.m("imageFile");
            throw null;
        }

        @NotNull
        public final File getThumbnailFile() {
            File file0 = this.thumbnailFile;
            if(file0 != null) {
                return file0;
            }
            q.m("thumbnailFile");
            throw null;
        }

        public final void setEntityList(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.entityList = list0;
        }

        public final void setImageFile(@NotNull File file0) {
            q.g(file0, "<set-?>");
            this.imageFile = file0;
        }

        public final void setThumbnailFile(@NotNull File file0) {
            q.g(file0, "<set-?>");
            this.thumbnailFile = file0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TaskValidatePremiumContents";
    @NotNull
    private final Playable playable;

    static {
        TaskValidatePremiumContents.Companion = new Companion(null);
        TaskValidatePremiumContents.$stable = 8;
    }

    public TaskValidatePremiumContents(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        super();
        this.playable = playable0;
    }

    @Override  // x8.f
    public Object backgroundWork(Object object0, Continuation continuation0) {
        return this.backgroundWork(((Void)object0), continuation0);
    }

    // 去混淆评级： 低(37)
    @Nullable
    public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
        PremiumContentsEntity premiumContentsEntity0 = e.b("", this.playable.getCtype().getValue());
        if(premiumContentsEntity0 != null && !TextUtils.isEmpty(premiumContentsEntity0.l)) {
            this.updateContentImages(premiumContentsEntity0);
        }
        return H.a;
    }

    @NotNull
    public final File changeFile(@NotNull File file0, @NotNull File file1) {
        q.g(file0, "src");
        q.g(file1, "des");
        File file2 = new File(i.i(file0) + "_tmp");
        if(file1.exists() && !file1.renameTo(file2)) {
            throw new IOException("changeFile() - Failed to change file.");
        }
        if(file0.exists() && !file0.renameTo(file1)) {
            throw new IOException("changeFile() - Failed to change file.");
        }
        return file2;
    }

    private final String downloadImage(File file0, String s) {
        LogU.Companion.i("TaskValidatePremiumContents", "downloadImage()");
        if(TextUtils.isEmpty(s)) {
            return "";
        }
        String s1 = i.i(file0);
        String s2 = d.b(new O8.f(null).a, s, s1);
        if(TextUtils.isEmpty(s2)) {
            if(file0.exists()) {
                file0.delete();
            }
            throw new IOException("downloadImage() - Failed to download image.");
        }
        q.d(s2);
        return s2;
    }

    private final ContentsInfo findPremiumContents(PremiumContentsEntity premiumContentsEntity0, String s) {
        LogU.Companion.i("TaskValidatePremiumContents", "findPremiumContents()");
        ContentsInfo taskValidatePremiumContents$ContentsInfo0 = new ContentsInfo();
        File file0 = k9.i.b(s);
        q.f(file0, "getImageFile(...)");
        taskValidatePremiumContents$ContentsInfo0.setImageFile(file0);
        File file1 = k9.i.b((s + "-thumbnail"));
        q.f(file1, "getThumbnailFile(...)");
        taskValidatePremiumContents$ContentsInfo0.setThumbnailFile(file1);
        String s1 = premiumContentsEntity0.l;
        if(TextUtils.isEmpty(s1)) {
            taskValidatePremiumContents$ContentsInfo0.setEntityList(new ArrayList());
            List list0 = taskValidatePremiumContents$ContentsInfo0.getEntityList();
            q.e(list0, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.premium.PremiumContentsEntity>");
            ((ArrayList)list0).add(premiumContentsEntity0);
            return taskValidatePremiumContents$ContentsInfo0;
        }
        List list1 = (List)w.N(((androidx.room.H)b.a.f().a), true, false, new com.iloen.melon.playback.playlist.db.d(s1, 16));
        q.f(list1, "getItemList(...)");
        taskValidatePremiumContents$ContentsInfo0.setEntityList(list1);
        return taskValidatePremiumContents$ContentsInfo0;
    }

    private final String getImageETag(String s) [...] // 潜在的解密器

    @NotNull
    public final Playable getPlayable() {
        return this.playable;
    }

    private final ContentsInfo preparePremiumContents(ContentsInfo taskValidatePremiumContents$ContentsInfo0, Playable playable0) {
        LogU.Companion.i("TaskValidatePremiumContents", "preparePremiumContents()");
        ContentsInfo taskValidatePremiumContents$ContentsInfo1 = new ContentsInfo();
        taskValidatePremiumContents$ContentsInfo1.setThumbnailFile(new File(i.i(taskValidatePremiumContents$ContentsInfo0.getThumbnailFile()) + ".tmp"));
        File file0 = taskValidatePremiumContents$ContentsInfo1.getThumbnailFile();
        q.f("", "getAlbumImgThumb(...)");
        this.downloadImage(file0, "");
        taskValidatePremiumContents$ContentsInfo1.setImageFile(new File(i.i(taskValidatePremiumContents$ContentsInfo0.getImageFile()) + ".tmp"));
        File file1 = taskValidatePremiumContents$ContentsInfo1.getImageFile();
        q.f("", "getAlbumImg(...)");
        String s = this.downloadImage(file1, "");
        if(!TextUtils.isEmpty(s)) {
            boolean z = taskValidatePremiumContents$ContentsInfo1.getImageFile().exists();
            boolean z1 = taskValidatePremiumContents$ContentsInfo1.getThumbnailFile().exists();
            if(!z || !z1) {
                if(z) {
                    taskValidatePremiumContents$ContentsInfo1.getImageFile().delete();
                }
                if(z1) {
                    taskValidatePremiumContents$ContentsInfo1.getThumbnailFile().delete();
                }
                throw new IllegalStateException("preparePremiumContents() - Failed to download contents.");
            }
        }
        taskValidatePremiumContents$ContentsInfo1.setEntityList(new ArrayList());
        for(Object object0: taskValidatePremiumContents$ContentsInfo0.getEntityList()) {
            PremiumContentsEntity premiumContentsEntity0 = c.b(((PremiumContentsEntity)object0));
            if(premiumContentsEntity0 != null) {
                if(TextUtils.isEmpty(s)) {
                    premiumContentsEntity0.k = "";
                    premiumContentsEntity0.l = "";
                }
                premiumContentsEntity0.m = s;
                List list0 = taskValidatePremiumContents$ContentsInfo1.getEntityList();
                q.e(list0, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.premium.PremiumContentsEntity>");
                ((ArrayList)list0).add(premiumContentsEntity0);
            }
        }
        return taskValidatePremiumContents$ContentsInfo1;
    }

    public static final void startValidation(@Nullable Playable playable0) {
        TaskValidatePremiumContents.Companion.startValidation(playable0);
    }

    private final void updateContentImages(PremiumContentsEntity premiumContentsEntity0) {
        LogU.Companion.i("TaskValidatePremiumContents", "updateContentImages() - ");
        synchronized(TaskValidatePremiumContents.class) {
            q.f("", "getAlbumid(...)");
            ContentsInfo taskValidatePremiumContents$ContentsInfo0 = this.findPremiumContents(premiumContentsEntity0, "");
            ContentsInfo taskValidatePremiumContents$ContentsInfo1 = null;
            try {
                taskValidatePremiumContents$ContentsInfo1 = this.preparePremiumContents(taskValidatePremiumContents$ContentsInfo0, this.playable);
                this.updatePremiumContents(taskValidatePremiumContents$ContentsInfo0, taskValidatePremiumContents$ContentsInfo1);
            }
            catch(Exception unused_ex) {
                if(taskValidatePremiumContents$ContentsInfo1 != null) {
                    e.f(taskValidatePremiumContents$ContentsInfo0.getEntityList());
                }
            }
        }
    }

    private final void updatePremiumContents(ContentsInfo taskValidatePremiumContents$ContentsInfo0, ContentsInfo taskValidatePremiumContents$ContentsInfo1) {
        File file2;
        File file1;
        File file0;
        LogU.Companion.i("TaskValidatePremiumContents", "updatePremiumContents()");
        if(!e.f(taskValidatePremiumContents$ContentsInfo1.getEntityList())) {
            throw new IOException("updatePremiumContents() - Failed to update db.");
        }
        try {
            file0 = null;
            file1 = this.changeFile(taskValidatePremiumContents$ContentsInfo1.getImageFile(), taskValidatePremiumContents$ContentsInfo0.getImageFile());
        }
        catch(Exception unused_ex) {
            file2 = null;
            goto label_15;
        }
        try {
            file0 = this.changeFile(taskValidatePremiumContents$ContentsInfo1.getThumbnailFile(), taskValidatePremiumContents$ContentsInfo0.getThumbnailFile());
            if(file1.exists()) {
                file1.delete();
            }
            if(file0.exists()) {
                file0.delete();
                return;
            }
            return;
        }
        catch(Exception unused_ex) {
            file2 = file0;
            file0 = file1;
        }
    label_15:
        if(file0 != null && file0.exists()) {
            file0.renameTo(taskValidatePremiumContents$ContentsInfo0.getImageFile());
        }
        if(file2 != null && file2.exists()) {
            file2.renameTo(taskValidatePremiumContents$ContentsInfo0.getThumbnailFile());
        }
    }
}

