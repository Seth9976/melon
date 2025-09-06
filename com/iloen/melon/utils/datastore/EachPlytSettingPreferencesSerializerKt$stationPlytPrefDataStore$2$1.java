package com.iloen.melon.utils.datastore;

import com.iloen.melon.EachPlytSettingPreferences;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import o2.f;
import oe.e;
import oe.i;
import we.o;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lo2/f;", "sharedPrefs", "Lcom/iloen/melon/EachPlytSettingPreferences;", "currentData", "<anonymous>", "(Lo2/f;Lcom/iloen/melon/EachPlytSettingPreferences;)Lcom/iloen/melon/EachPlytSettingPreferences;"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.datastore.EachPlytSettingPreferencesSerializerKt$stationPlytPrefDataStore$2$1", f = "EachPlytSettingPreferencesSerializer.kt", l = {}, m = "invokeSuspend")
final class EachPlytSettingPreferencesSerializerKt.stationPlytPrefDataStore.2.1 extends i implements o {
    public f r;
    public EachPlytSettingPreferences w;

    @Override  // we.o
    public Object invoke(Object object0, Object object1, Object object2) {
        return this.invoke(((f)object0), ((EachPlytSettingPreferences)object1), ((Continuation)object2));
    }

    public final Object invoke(f f0, EachPlytSettingPreferences eachPlytSettingPreferences0, Continuation continuation0) {
        EachPlytSettingPreferencesSerializerKt.stationPlytPrefDataStore.2.1 eachPlytSettingPreferencesSerializerKt$stationPlytPrefDataStore$2$10 = new EachPlytSettingPreferencesSerializerKt.stationPlytPrefDataStore.2.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        eachPlytSettingPreferencesSerializerKt$stationPlytPrefDataStore$2$10.r = f0;
        eachPlytSettingPreferencesSerializerKt$stationPlytPrefDataStore$2$10.w = eachPlytSettingPreferences0;
        return eachPlytSettingPreferencesSerializerKt$stationPlytPrefDataStore$2$10.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        f f0 = this.r;
        EachPlytSettingPreferences eachPlytSettingPreferences0 = this.w;
        n.D(object0);
        LogU.Companion.d("SharedPreferencesMigration", "radioPlytPrefDataStore migration");
        return EachPlytSettingPreferencesSerializerKt.a(f0, eachPlytSettingPreferences0, "radioPlytPrefDataStore");
    }
}

