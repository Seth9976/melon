package com.kakao.sdk.template.model;

import De.d;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0006\u0003\u0004\u0005\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/kakao/sdk/template/model/DefaultTemplate;", "", "Companion", "Lcom/kakao/sdk/template/model/CalendarTemplate;", "Lcom/kakao/sdk/template/model/CommerceTemplate;", "Lcom/kakao/sdk/template/model/FeedTemplate;", "Lcom/kakao/sdk/template/model/ListTemplate;", "Lcom/kakao/sdk/template/model/LocationTemplate;", "Lcom/kakao/sdk/template/model/TextTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public interface DefaultTemplate {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/template/model/DefaultTemplate$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "template_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final KSerializer serializer() {
            return new SealedClassSerializer("com.kakao.sdk.template.model.DefaultTemplate", I.a.b(DefaultTemplate.class), new d[]{I.a.b(CalendarTemplate.class), I.a.b(CommerceTemplate.class), I.a.b(FeedTemplate.class), I.a.b(ListTemplate.class), I.a.b(LocationTemplate.class), I.a.b(TextTemplate.class)}, new KSerializer[]{.serializer.INSTANCE, com.kakao.sdk.template.model.CommerceTemplate..serializer.INSTANCE, com.kakao.sdk.template.model.FeedTemplate..serializer.INSTANCE, com.kakao.sdk.template.model.ListTemplate..serializer.INSTANCE, com.kakao.sdk.template.model.LocationTemplate..serializer.INSTANCE, com.kakao.sdk.template.model.TextTemplate..serializer.INSTANCE}, new Annotation[0]);
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        DefaultTemplate.Companion = Companion.$$INSTANCE;
    }
}

