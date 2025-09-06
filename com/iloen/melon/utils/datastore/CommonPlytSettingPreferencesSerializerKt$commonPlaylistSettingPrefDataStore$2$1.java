package com.iloen.melon.utils.datastore;

import com.iloen.melon.CommonPlytSettingPreferences;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import o2.f;
import oe.e;
import oe.i;
import we.o;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lo2/f;", "sharedPrefs", "Lcom/iloen/melon/CommonPlytSettingPreferences;", "currentData", "<anonymous>", "(Lo2/f;Lcom/iloen/melon/CommonPlytSettingPreferences;)Lcom/iloen/melon/CommonPlytSettingPreferences;"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.datastore.CommonPlytSettingPreferencesSerializerKt$commonPlaylistSettingPrefDataStore$2$1", f = "CommonPlytSettingPreferencesSerializer.kt", l = {}, m = "invokeSuspend")
final class CommonPlytSettingPreferencesSerializerKt.commonPlaylistSettingPrefDataStore.2.1 extends i implements o {
    public f r;
    public CommonPlytSettingPreferences w;

    @Override  // we.o
    public Object invoke(Object object0, Object object1, Object object2) {
        return this.invoke(((f)object0), ((CommonPlytSettingPreferences)object1), ((Continuation)object2));
    }

    public final Object invoke(f f0, CommonPlytSettingPreferences commonPlytSettingPreferences0, Continuation continuation0) {
        CommonPlytSettingPreferencesSerializerKt.commonPlaylistSettingPrefDataStore.2.1 commonPlytSettingPreferencesSerializerKt$commonPlaylistSettingPrefDataStore$2$10 = new CommonPlytSettingPreferencesSerializerKt.commonPlaylistSettingPrefDataStore.2.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        commonPlytSettingPreferencesSerializerKt$commonPlaylistSettingPrefDataStore$2$10.r = f0;
        commonPlytSettingPreferencesSerializerKt$commonPlaylistSettingPrefDataStore$2$10.w = commonPlytSettingPreferences0;
        return commonPlytSettingPreferencesSerializerKt$commonPlaylistSettingPrefDataStore$2$10.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        f f0 = this.r;
        CommonPlytSettingPreferences commonPlytSettingPreferences0 = this.w;
        n.D(object0);
        return CommonPlytSettingPreferencesSerializerKt.access$handleDbPlaylistMigration(f0, commonPlytSettingPreferences0, "commonPlytSettingPrefDataStore");
    }
}

