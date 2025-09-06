package com.iloen.melon.utils.datastore.common;

import com.iloen.melon.utils.cipher.SimpleCrypto;
import d5.n;
import d5.w;
import d8.d;
import ie.H;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import l2.b;
import l2.c0;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001A\u00028\u00002\u0006\u0010\b\u001A\u00020\u0007H¦@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00028\u0000H¦@¢\u0006\u0004\b\f\u0010\rR\u001D\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;", "T", "", "<init>", "()V", "createDefaultValue", "()Ljava/lang/Object;", "", "byteArray", "byteArrayToValue", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "valueToByteArray", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ll2/c0;", "a", "Ll2/c0;", "getSerializer", "()Ll2/c0;", "serializer", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MelonEncryptedDatastoreSerializer {
    public static final int $stable = 8;
    public final com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer.serializer.1 a;

    public MelonEncryptedDatastoreSerializer() {
        this.a = new c0() {
            public final MelonEncryptedDatastoreSerializer a;

            {
                this.a = melonEncryptedDatastoreSerializer0;
            }

            @Override  // l2.c0
            public Object getDefaultValue() {
                return this.a.createDefaultValue();
            }

            @Override  // l2.c0
            public Object readFrom(InputStream inputStream0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer.serializer.1.readFrom.1 melonEncryptedDatastoreSerializer$serializer$1$readFrom$10;
                if(continuation0 instanceof com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer.serializer.1.readFrom.1) {
                    melonEncryptedDatastoreSerializer$serializer$1$readFrom$10 = (com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer.serializer.1.readFrom.1)continuation0;
                    int v = melonEncryptedDatastoreSerializer$serializer$1$readFrom$10.B;
                    if((v & 0x80000000) == 0) {
                        melonEncryptedDatastoreSerializer$serializer$1$readFrom$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            public int B;
                            public Object r;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.r = object0;
                                this.B |= 0x80000000;
                                return continuation0.readFrom(null, this);
                            }
                        };
                    }
                    else {
                        melonEncryptedDatastoreSerializer$serializer$1$readFrom$10.B = v ^ 0x80000000;
                    }
                }
                else {
                    melonEncryptedDatastoreSerializer$serializer$1$readFrom$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        public int B;
                        public Object r;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.r = object0;
                            this.B |= 0x80000000;
                            return continuation0.readFrom(null, this);
                        }
                    };
                }
                Object object0 = melonEncryptedDatastoreSerializer$serializer$1$readFrom$10.r;
                a a0 = a.a;
                switch(melonEncryptedDatastoreSerializer$serializer$1$readFrom$10.B) {
                    case 0: {
                        n.D(object0);
                        try {
                            byte[] arr_b = SimpleCrypto.decrypt(w.N(inputStream0));
                            q.d(arr_b);
                            melonEncryptedDatastoreSerializer$serializer$1$readFrom$10.B = 1;
                            Object object1 = this.a.byteArrayToValue(arr_b, melonEncryptedDatastoreSerializer$serializer$1$readFrom$10);
                            return object1 == a0 ? a0 : object1;
                        label_21:
                            n.D(object0);
                            return object0;
                        }
                        catch(Exception exception0) {
                            a7.c.a().c(exception0);
                            throw new b("Cannot read proto.", exception0);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                        }
                    }
                    case 1: {
                        goto label_21;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }

            @Override  // l2.c0
            public Object writeTo(Object object0, OutputStream outputStream0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer.serializer.1.writeTo.1 melonEncryptedDatastoreSerializer$serializer$1$writeTo$10;
                if(continuation0 instanceof com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer.serializer.1.writeTo.1) {
                    melonEncryptedDatastoreSerializer$serializer$1$writeTo$10 = (com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer.serializer.1.writeTo.1)continuation0;
                    int v = melonEncryptedDatastoreSerializer$serializer$1$writeTo$10.D;
                    if((v & 0x80000000) == 0) {
                        melonEncryptedDatastoreSerializer$serializer$1$writeTo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            public int D;
                            public OutputStream r;
                            public Object w;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.w = object0;
                                this.D |= 0x80000000;
                                return continuation0.writeTo(null, null, this);
                            }
                        };
                    }
                    else {
                        melonEncryptedDatastoreSerializer$serializer$1$writeTo$10.D = v ^ 0x80000000;
                    }
                }
                else {
                    melonEncryptedDatastoreSerializer$serializer$1$writeTo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        public int D;
                        public OutputStream r;
                        public Object w;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.w = object0;
                            this.D |= 0x80000000;
                            return continuation0.writeTo(null, null, this);
                        }
                    };
                }
                Object object1 = melonEncryptedDatastoreSerializer$serializer$1$writeTo$10.w;
                a a0 = a.a;
                switch(melonEncryptedDatastoreSerializer$serializer$1$writeTo$10.D) {
                    case 0: {
                        n.D(object1);
                        melonEncryptedDatastoreSerializer$serializer$1$writeTo$10.r = outputStream0;
                        melonEncryptedDatastoreSerializer$serializer$1$writeTo$10.D = 1;
                        object1 = this.a.valueToByteArray(object0, melonEncryptedDatastoreSerializer$serializer$1$writeTo$10);
                        if(object1 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        outputStream0 = melonEncryptedDatastoreSerializer$serializer$1$writeTo$10.r;
                        n.D(object1);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                byte[] arr_b = SimpleCrypto.encrypt(((byte[])object1));
                try {
                    outputStream0.write(arr_b);
                }
                catch(Throwable throwable0) {
                    d.l(outputStream0, throwable0);
                    throw throwable0;
                }
                outputStream0.close();
                return H.a;
            }
        };
    }

    @Nullable
    public abstract Object byteArrayToValue(@NotNull byte[] arg1, @NotNull Continuation arg2);

    public abstract Object createDefaultValue();

    @NotNull
    public final c0 getSerializer() {
        return this.a;
    }

    @Nullable
    public abstract Object valueToByteArray(Object arg1, @NotNull Continuation arg2);
}

