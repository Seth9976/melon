package com.kakao.sdk.user.model;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer.DefaultImpls;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b=\b\u0087\b\u0018\u0000 \u0099\u00012\u00020\u0001:\u0004\u009A\u0001\u0099\u0001B\u00B3\u0002\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u0012\b\u0010\u0018\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A\u0012\b\u0010\u001C\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u001D\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u001E\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u001F\u001A\u0004\u0018\u00010\t\u0012\b\u0010 \u001A\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001A\u0004\u0018\u00010\u001A\u0012\b\u0010\"\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001A\u0004\u0018\u00010\t\u0012\b\u0010$\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b&\u0010\'B\u00F7\u0002\b\u0017\u0012\u0006\u0010)\u001A\u00020(\u0012\n\b\u0001\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\r\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000F\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0011\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0012\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0014\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0018\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0019\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A\u0012\n\b\u0001\u0010\u001C\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u001D\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001E\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u001F\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010 \u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010!\u001A\u0004\u0018\u00010\u001A\u0012\n\b\u0001\u0010\"\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010#\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010$\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010%\u001A\u0004\u0018\u00010\u0002\u0012\b\u0010+\u001A\u0004\u0018\u00010*\u00A2\u0006\u0004\b&\u0010,J\u0012\u0010-\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b-\u0010.J\u0012\u0010/\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b/\u0010.J\u0012\u00100\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b0\u0010.J\u0012\u00101\u001A\u0004\u0018\u00010\u0006H\u00C6\u0003\u00A2\u0006\u0004\b1\u00102J\u0012\u00103\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b3\u0010.J\u0012\u00104\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b4\u00105J\u0012\u00106\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b6\u0010.J\u0012\u00107\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b7\u0010.J\u0012\u00108\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b8\u0010.J\u0012\u00109\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b9\u00105J\u0012\u0010:\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b:\u0010.J\u0012\u0010;\u001A\u0004\u0018\u00010\u0010H\u00C6\u0003\u00A2\u0006\u0004\b;\u0010<J\u0012\u0010=\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b=\u0010.J\u0012\u0010>\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b>\u00105J\u0012\u0010?\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b?\u0010.J\u0012\u0010@\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b@\u00105J\u0012\u0010A\u001A\u0004\u0018\u00010\u0016H\u00C6\u0003\u00A2\u0006\u0004\bA\u0010BJ\u0012\u0010C\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bC\u0010.J\u0012\u0010D\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bD\u0010.J\u0012\u0010E\u001A\u0004\u0018\u00010\u001AH\u00C6\u0003\u00A2\u0006\u0004\bE\u0010FJ\u0012\u0010G\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bG\u0010.J\u0012\u0010H\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\bH\u00105J\u0012\u0010I\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bI\u0010.J\u0012\u0010J\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\bJ\u00105J\u0012\u0010K\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bK\u0010.J\u0012\u0010L\u001A\u0004\u0018\u00010\u001AH\u00C6\u0003\u00A2\u0006\u0004\bL\u0010FJ\u0012\u0010M\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bM\u0010.J\u0012\u0010N\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\bN\u00105J\u0012\u0010O\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bO\u0010.J\u0012\u0010P\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\bP\u0010.J\u00F8\u0002\u0010Q\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\u001A2\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u0002H\u00C6\u0001\u00A2\u0006\u0004\bQ\u0010RJ\u0010\u0010S\u001A\u00020\tH\u00D6\u0001\u00A2\u0006\u0004\bS\u00105J\u0010\u0010T\u001A\u00020(H\u00D6\u0001\u00A2\u0006\u0004\bT\u0010UJ\u001A\u0010W\u001A\u00020\u00022\b\u0010V\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\bW\u0010XJ(\u0010_\u001A\u00020^2\u0006\u0010Y\u001A\u00020\u00002\u0006\u0010[\u001A\u00020Z2\u0006\u0010]\u001A\u00020\\H\u00C7\u0001\u00A2\u0006\u0004\b_\u0010`R\"\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0003\u0010a\u0012\u0004\bc\u0010d\u001A\u0004\bb\u0010.R\"\u0010\u0004\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0004\u0010a\u0012\u0004\bf\u0010d\u001A\u0004\be\u0010.R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0005\u0010a\u0012\u0004\bh\u0010d\u001A\u0004\bg\u0010.R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010i\u001A\u0004\bj\u00102R\"\u0010\b\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\b\u0010a\u0012\u0004\bl\u0010d\u001A\u0004\bk\u0010.R\u0019\u0010\n\u001A\u0004\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010m\u001A\u0004\bn\u00105R\"\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000B\u0010a\u0012\u0004\bp\u0010d\u001A\u0004\bo\u0010.R\"\u0010\f\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\f\u0010a\u0012\u0004\bq\u0010d\u001A\u0004\b\f\u0010.R\"\u0010\r\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\r\u0010a\u0012\u0004\br\u0010d\u001A\u0004\b\r\u0010.R\u0019\u0010\u000E\u001A\u0004\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010m\u001A\u0004\bs\u00105R\"\u0010\u000F\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u000F\u0010a\u0012\u0004\bu\u0010d\u001A\u0004\bt\u0010.R\"\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0011\u0010v\u0012\u0004\bx\u0010d\u001A\u0004\bw\u0010<R\"\u0010\u0012\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0012\u0010a\u0012\u0004\bz\u0010d\u001A\u0004\by\u0010.R\u0019\u0010\u0013\u001A\u0004\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b\u0013\u0010m\u001A\u0004\b{\u00105R\"\u0010\u0014\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0014\u0010a\u0012\u0004\b}\u0010d\u001A\u0004\b|\u0010.R\u0019\u0010\u0015\u001A\u0004\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b\u0015\u0010m\u001A\u0004\b~\u00105R$\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b\u0017\u0010\u007F\u0012\u0005\b\u0081\u0001\u0010d\u001A\u0005\b\u0080\u0001\u0010BR#\u0010\u0018\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0013\n\u0004\b\u0018\u0010a\u0012\u0005\b\u0082\u0001\u0010d\u001A\u0004\b\u0018\u0010.R$\u0010\u0019\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b\u0019\u0010a\u0012\u0005\b\u0084\u0001\u0010d\u001A\u0005\b\u0083\u0001\u0010.R\u001B\u0010\u001B\u001A\u0004\u0018\u00010\u001A8\u0006\u00A2\u0006\u000E\n\u0005\b\u001B\u0010\u0085\u0001\u001A\u0005\b\u0086\u0001\u0010FR$\u0010\u001C\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b\u001C\u0010a\u0012\u0005\b\u0088\u0001\u0010d\u001A\u0005\b\u0087\u0001\u0010.R$\u0010\u001D\u001A\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b\u001D\u0010m\u0012\u0005\b\u008A\u0001\u0010d\u001A\u0005\b\u0089\u0001\u00105R$\u0010\u001E\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b\u001E\u0010a\u0012\u0005\b\u008C\u0001\u0010d\u001A\u0005\b\u008B\u0001\u0010.R$\u0010\u001F\u001A\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b\u001F\u0010m\u0012\u0005\b\u008E\u0001\u0010d\u001A\u0005\b\u008D\u0001\u00105R$\u0010 \u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b \u0010a\u0012\u0005\b\u0090\u0001\u0010d\u001A\u0005\b\u008F\u0001\u0010.R%\u0010!\u001A\u0004\u0018\u00010\u001A8\u0006X\u0087\u0004\u00A2\u0006\u0015\n\u0005\b!\u0010\u0085\u0001\u0012\u0005\b\u0092\u0001\u0010d\u001A\u0005\b\u0091\u0001\u0010FR$\u0010\"\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b\"\u0010a\u0012\u0005\b\u0094\u0001\u0010d\u001A\u0005\b\u0093\u0001\u0010.R$\u0010#\u001A\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00A2\u0006\u0014\n\u0004\b#\u0010m\u0012\u0005\b\u0096\u0001\u0010d\u001A\u0005\b\u0095\u0001\u00105R#\u0010$\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0013\n\u0004\b$\u0010a\u0012\u0005\b\u0097\u0001\u0010d\u001A\u0004\b$\u0010.R#\u0010%\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0013\n\u0004\b%\u0010a\u0012\u0005\b\u0098\u0001\u0010d\u001A\u0004\b%\u0010.\u00A8\u0006\u009B\u0001"}, d2 = {"Lcom/kakao/sdk/user/model/Account;", "", "", "profileNeedsAgreement", "profileNicknameNeedsAgreement", "profileImageNeedsAgreement", "Lcom/kakao/sdk/user/model/Profile;", "profile", "nameNeedsAgreement", "", "name", "emailNeedsAgreement", "isEmailValid", "isEmailVerified", "email", "ageRangeNeedsAgreement", "Lcom/kakao/sdk/user/model/AgeRange;", "ageRange", "birthyearNeedsAgreement", "birthyear", "birthdayNeedsAgreement", "birthday", "Lcom/kakao/sdk/user/model/BirthdayType;", "birthdayType", "isLeapMonth", "genderNeedsAgreement", "Lcom/kakao/sdk/user/model/Gender;", "gender", "legalNameNeedsAgreement", "legalName", "legalBirthDateNeedsAgreement", "legalBirthDate", "legalGenderNeedsAgreement", "legalGender", "phoneNumberNeedsAgreement", "phoneNumber", "isKoreanNeedsAgreement", "isKorean", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Profile;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/AgeRange;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/kakao/sdk/user/model/BirthdayType;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Profile;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/AgeRange;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/kakao/sdk/user/model/BirthdayType;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/Boolean;", "component2", "component3", "component4", "()Lcom/kakao/sdk/user/model/Profile;", "component5", "component6", "()Ljava/lang/String;", "component7", "component8", "component9", "component10", "component11", "component12", "()Lcom/kakao/sdk/user/model/AgeRange;", "component13", "component14", "component15", "component16", "component17", "()Lcom/kakao/sdk/user/model/BirthdayType;", "component18", "component19", "component20", "()Lcom/kakao/sdk/user/model/Gender;", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Profile;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/AgeRange;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/kakao/sdk/user/model/BirthdayType;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/user/model/Gender;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/kakao/sdk/user/model/Account;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lie/H;", "write$Self", "(Lcom/kakao/sdk/user/model/Account;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Ljava/lang/Boolean;", "getProfileNeedsAgreement", "getProfileNeedsAgreement$annotations", "()V", "getProfileNicknameNeedsAgreement", "getProfileNicknameNeedsAgreement$annotations", "getProfileImageNeedsAgreement", "getProfileImageNeedsAgreement$annotations", "Lcom/kakao/sdk/user/model/Profile;", "getProfile", "getNameNeedsAgreement", "getNameNeedsAgreement$annotations", "Ljava/lang/String;", "getName", "getEmailNeedsAgreement", "getEmailNeedsAgreement$annotations", "isEmailValid$annotations", "isEmailVerified$annotations", "getEmail", "getAgeRangeNeedsAgreement", "getAgeRangeNeedsAgreement$annotations", "Lcom/kakao/sdk/user/model/AgeRange;", "getAgeRange", "getAgeRange$annotations", "getBirthyearNeedsAgreement", "getBirthyearNeedsAgreement$annotations", "getBirthyear", "getBirthdayNeedsAgreement", "getBirthdayNeedsAgreement$annotations", "getBirthday", "Lcom/kakao/sdk/user/model/BirthdayType;", "getBirthdayType", "getBirthdayType$annotations", "isLeapMonth$annotations", "getGenderNeedsAgreement", "getGenderNeedsAgreement$annotations", "Lcom/kakao/sdk/user/model/Gender;", "getGender", "getLegalNameNeedsAgreement", "getLegalNameNeedsAgreement$annotations", "getLegalName", "getLegalName$annotations", "getLegalBirthDateNeedsAgreement", "getLegalBirthDateNeedsAgreement$annotations", "getLegalBirthDate", "getLegalBirthDate$annotations", "getLegalGenderNeedsAgreement", "getLegalGenderNeedsAgreement$annotations", "getLegalGender", "getLegalGender$annotations", "getPhoneNumberNeedsAgreement", "getPhoneNumberNeedsAgreement$annotations", "getPhoneNumber", "getPhoneNumber$annotations", "isKoreanNeedsAgreement$annotations", "isKorean$annotations", "Companion", "$serializer", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable
public final class Account {
    @d
    @Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/kakao/sdk/user/model/Account.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/kakao/sdk/user/model/Account;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/kakao/sdk/user/model/Account;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lie/H;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/kakao/sdk/user/model/Account;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class .serializer implements GeneratedSerializer {
        @NotNull
        public static final .serializer INSTANCE;
        private static final PluginGeneratedSerialDescriptor descriptor;

        static {
            .serializer account$$serializer0 = new .serializer();
            .serializer.INSTANCE = account$$serializer0;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor0 = new PluginGeneratedSerialDescriptor("com.kakao.sdk.user.model.Account", account$$serializer0, 30);
            pluginGeneratedSerialDescriptor0.addElement("profile_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("profile_nickname_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("profile_image_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("profile", false);
            pluginGeneratedSerialDescriptor0.addElement("name_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("name", false);
            pluginGeneratedSerialDescriptor0.addElement("email_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("is_email_valid", false);
            pluginGeneratedSerialDescriptor0.addElement("is_email_verified", false);
            pluginGeneratedSerialDescriptor0.addElement("email", false);
            pluginGeneratedSerialDescriptor0.addElement("age_range_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("age_range", false);
            pluginGeneratedSerialDescriptor0.addElement("birthyear_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("birthyear", false);
            pluginGeneratedSerialDescriptor0.addElement("birthday_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("birthday", false);
            pluginGeneratedSerialDescriptor0.addElement("birthday_type", false);
            pluginGeneratedSerialDescriptor0.addElement("is_leap_month", false);
            pluginGeneratedSerialDescriptor0.addElement("gender_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("gender", false);
            pluginGeneratedSerialDescriptor0.addElement("legal_name_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("legal_name", false);
            pluginGeneratedSerialDescriptor0.addElement("legal_birth_date_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("legal_birth_date", false);
            pluginGeneratedSerialDescriptor0.addElement("legal_gender_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("legal_gender", false);
            pluginGeneratedSerialDescriptor0.addElement("phone_number_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("phone_number", false);
            pluginGeneratedSerialDescriptor0.addElement("is_korean_needs_agreement", false);
            pluginGeneratedSerialDescriptor0.addElement("is_korean", false);
            .serializer.descriptor = pluginGeneratedSerialDescriptor0;
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(com.kakao.sdk.user.model.Profile..serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AgeRangeSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BirthdayTypeSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GenderSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GenderSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
        }

        @NotNull
        public Account deserialize(@NotNull Decoder decoder0) {
            Object object92;
            Object object91;
            int v4;
            Object object90;
            Object object89;
            int v3;
            Object object88;
            Object object87;
            Object object86;
            Object object85;
            Object object84;
            Object object83;
            Object object82;
            Object object81;
            Object object80;
            Object object79;
            Object object78;
            Object object77;
            Object object76;
            Object object75;
            Object object74;
            Object object49;
            Object object48;
            Object object47;
            Object object46;
            Object object45;
            Object object44;
            Object object43;
            Object object42;
            Object object41;
            Object object40;
            Object object39;
            int v;
            Object object38;
            Object object37;
            Object object36;
            Object object35;
            Object object34;
            Object object32;
            Object object29;
            Object object24;
            Object object23;
            Object object22;
            Object object21;
            Object object18;
            Object object17;
            Object object15;
            Object object12;
            Object object11;
            Object object10;
            Object object1;
            q.g(decoder0, "decoder");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeDecoder compositeDecoder0 = decoder0.beginStructure(serialDescriptor0);
            Object object0 = null;
            if(compositeDecoder0.decodeSequentially()) {
                object1 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, BooleanSerializer.INSTANCE, null);
                Object object2 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, BooleanSerializer.INSTANCE, null);
                Object object3 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, BooleanSerializer.INSTANCE, null);
                Object object4 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, com.kakao.sdk.user.model.Profile..serializer.INSTANCE, null);
                Object object5 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, BooleanSerializer.INSTANCE, null);
                Object object6 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, null);
                Object object7 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, null);
                Object object8 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, BooleanSerializer.INSTANCE, null);
                Object object9 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 8, BooleanSerializer.INSTANCE, null);
                object10 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 9, StringSerializer.INSTANCE, null);
                object11 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 10, BooleanSerializer.INSTANCE, null);
                object12 = object4;
                Object object13 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 11, AgeRangeSerializer.INSTANCE, null);
                Object object14 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 12, BooleanSerializer.INSTANCE, null);
                object15 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 13, StringSerializer.INSTANCE, null);
                Object object16 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 14, BooleanSerializer.INSTANCE, null);
                object17 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 15, StringSerializer.INSTANCE, null);
                object18 = object14;
                Object object19 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 16, BirthdayTypeSerializer.INSTANCE, null);
                Object object20 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 17, BooleanSerializer.INSTANCE, null);
                object21 = object19;
                object22 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 18, BooleanSerializer.INSTANCE, null);
                object23 = object20;
                object24 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 19, GenderSerializer.INSTANCE, null);
                Object object25 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 20, BooleanSerializer.INSTANCE, null);
                Object object26 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 21, StringSerializer.INSTANCE, null);
                Object object27 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 22, BooleanSerializer.INSTANCE, null);
                Object object28 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 23, StringSerializer.INSTANCE, null);
                object29 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 24, BooleanSerializer.INSTANCE, null);
                Object object30 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 25, GenderSerializer.INSTANCE, null);
                Object object31 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 26, BooleanSerializer.INSTANCE, null);
                object32 = object30;
                Object object33 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 27, StringSerializer.INSTANCE, null);
                object34 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 28, BooleanSerializer.INSTANCE, null);
                object35 = object33;
                object36 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 29, BooleanSerializer.INSTANCE, null);
                object0 = object31;
                object37 = object16;
                object38 = object13;
                v = 0x3FFFFFFF;
                object39 = object8;
                object40 = object7;
                object41 = object6;
                object42 = object26;
                object43 = object27;
                object44 = object5;
                object45 = object2;
                object46 = object25;
                object47 = object3;
                object48 = object9;
                object49 = object28;
            }
            else {
                int v1 = 0;
                Object object50 = null;
                Object object51 = null;
                Object object52 = null;
                Object object53 = null;
                object49 = null;
                Object object54 = null;
                Object object55 = null;
                Object object56 = null;
                object34 = null;
                Object object57 = null;
                Object object58 = null;
                object43 = null;
                object42 = null;
                Object object59 = null;
                Object object60 = null;
                Object object61 = null;
                Object object62 = null;
                Object object63 = null;
                Object object64 = null;
                Object object65 = null;
                Object object66 = null;
                Object object67 = null;
                Object object68 = null;
                Object object69 = null;
                Object object70 = null;
                Object object71 = null;
                Object object72 = null;
                object37 = null;
                Object object73 = null;
                boolean z = true;
                while(z) {
                    int v2 = compositeDecoder0.decodeElementIndex(serialDescriptor0);
                    switch(v2) {
                        case -1: {
                            object74 = object50;
                            object75 = object54;
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            v3 = v1;
                            object89 = object73;
                            object90 = object55;
                            z = false;
                            v4 = v3;
                            object54 = object75;
                            object55 = object90;
                            break;
                        }
                        case 0: {
                            object74 = object50;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object76 = object60;
                            object59 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 0, BooleanSerializer.INSTANCE, object59);
                            v4 = v1 | 1;
                            break;
                        }
                        case 1: {
                            object74 = object50;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object77 = object61;
                            v4 = v1 | 2;
                            object76 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 1, BooleanSerializer.INSTANCE, object60);
                            break;
                        }
                        case 2: {
                            object74 = object50;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object78 = object62;
                            object77 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 2, BooleanSerializer.INSTANCE, object61);
                            object76 = object60;
                            v4 = v1 | 4;
                            break;
                        }
                        case 3: {
                            object74 = object50;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object79 = object63;
                            v4 = v1 | 8;
                            object78 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 3, com.kakao.sdk.user.model.Profile..serializer.INSTANCE, object62);
                            object76 = object60;
                            object77 = object61;
                            break;
                        }
                        case 4: {
                            object74 = object50;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object80 = object64;
                            object79 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 4, BooleanSerializer.INSTANCE, object63);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            v4 = v1 | 16;
                            break;
                        }
                        case 5: {
                            object74 = object50;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object81 = object65;
                            v4 = v1 | 0x20;
                            object80 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, object64);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            break;
                        }
                        case 6: {
                            object74 = object50;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object82 = object66;
                            object81 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, object65);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            v4 = v1 | 0x40;
                            break;
                        }
                        case 7: {
                            object74 = object50;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object83 = object67;
                            v4 = v1 | 0x80;
                            object82 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 7, BooleanSerializer.INSTANCE, object66);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            break;
                        }
                        case 8: {
                            object74 = object50;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object84 = object68;
                            object83 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 8, BooleanSerializer.INSTANCE, object67);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            v4 = v1 | 0x100;
                            break;
                        }
                        case 9: {
                            object74 = object50;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object85 = object69;
                            v4 = v1 | 0x200;
                            object84 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 9, StringSerializer.INSTANCE, object68);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            break;
                        }
                        case 10: {
                            object74 = object50;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object86 = object70;
                            object85 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 10, BooleanSerializer.INSTANCE, object69);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            v4 = v1 | 0x400;
                            break;
                        }
                        case 11: {
                            object74 = object50;
                            object88 = object72;
                            object89 = object73;
                            object87 = object71;
                            v4 = v1 | 0x800;
                            object86 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 11, AgeRangeSerializer.INSTANCE, object70);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            break;
                        }
                        case 12: {
                            object74 = object50;
                            object89 = object73;
                            object88 = object72;
                            object87 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 12, BooleanSerializer.INSTANCE, object71);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            v4 = v1 | 0x1000;
                            break;
                        }
                        case 13: {
                            object74 = object50;
                            object89 = object73;
                            v4 = v1 | 0x2000;
                            object88 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 13, StringSerializer.INSTANCE, object72);
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            break;
                        }
                        case 14: {
                            object74 = object50;
                            object91 = object51;
                            object75 = object54;
                            object90 = object55;
                            object89 = object73;
                            v3 = v1 | 0x4000;
                            object37 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 14, BooleanSerializer.INSTANCE, object37);
                            goto label_365;
                        }
                        case 15: {
                            object74 = object50;
                            object91 = object51;
                            object75 = object54;
                            object90 = object55;
                            v3 = v1 | 0x8000;
                            object89 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 15, StringSerializer.INSTANCE, object73);
                        label_365:
                            object51 = object91;
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            v4 = v3;
                            object54 = object75;
                            object55 = object90;
                            break;
                        }
                        case 16: {
                            object74 = object50;
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            v4 = v1 | 0x10000;
                            object55 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 16, BirthdayTypeSerializer.INSTANCE, object55);
                            break;
                        }
                        case 17: {
                            object74 = object50;
                            object54 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 17, BooleanSerializer.INSTANCE, object54);
                            v4 = v1 | 0x20000;
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            break;
                        }
                        case 18: {
                            object92 = object54;
                            object52 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 18, BooleanSerializer.INSTANCE, object52);
                            object74 = object50;
                            v4 = v1 | 0x40000;
                            goto label_477;
                        }
                        case 19: {
                            object92 = object54;
                            object53 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 19, GenderSerializer.INSTANCE, object53);
                            object74 = object50;
                            v4 = v1 | 0x80000;
                            goto label_477;
                        }
                        case 20: {
                            object92 = object54;
                            object51 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 20, BooleanSerializer.INSTANCE, object51);
                            object74 = object50;
                            v4 = v1 | 0x100000;
                            goto label_477;
                        }
                        case 21: {
                            object92 = object54;
                            object74 = object50;
                            object42 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 21, StringSerializer.INSTANCE, object42);
                            v4 = v1 | 0x200000;
                            goto label_477;
                        }
                        case 22: {
                            object92 = object54;
                            object74 = object50;
                            object43 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 22, BooleanSerializer.INSTANCE, object43);
                            v4 = v1 | 0x400000;
                            goto label_477;
                        }
                        case 23: {
                            object92 = object54;
                            object49 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 23, StringSerializer.INSTANCE, object49);
                            object74 = object50;
                            v4 = v1 | 0x800000;
                            goto label_477;
                        }
                        case 24: {
                            object92 = object54;
                            object74 = object50;
                            object58 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 24, BooleanSerializer.INSTANCE, object58);
                            v4 = v1 | 0x1000000;
                            goto label_477;
                        }
                        case 25: {
                            object92 = object54;
                            object74 = object50;
                            object57 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 25, GenderSerializer.INSTANCE, object57);
                            v4 = v1 | 0x2000000;
                            goto label_477;
                        }
                        case 26: {
                            object92 = object54;
                            object74 = object50;
                            object0 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 26, BooleanSerializer.INSTANCE, object0);
                            v4 = v1 | 0x4000000;
                            goto label_477;
                        }
                        case 27: {
                            object92 = object54;
                            object74 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 27, StringSerializer.INSTANCE, object50);
                            v4 = v1 | 0x8000000;
                            goto label_477;
                        }
                        case 28: {
                            object92 = object54;
                            object74 = object50;
                            object34 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 28, BooleanSerializer.INSTANCE, object34);
                            v4 = v1 | 0x10000000;
                            goto label_477;
                        }
                        case 29: {
                            object92 = object54;
                            object74 = object50;
                            object56 = compositeDecoder0.decodeNullableSerializableElement(serialDescriptor0, 29, BooleanSerializer.INSTANCE, object56);
                            v4 = v1 | 0x20000000;
                        label_477:
                            object76 = object60;
                            object77 = object61;
                            object78 = object62;
                            object79 = object63;
                            object80 = object64;
                            object81 = object65;
                            object82 = object66;
                            object83 = object67;
                            object84 = object68;
                            object85 = object69;
                            object86 = object70;
                            object87 = object71;
                            object88 = object72;
                            object89 = object73;
                            object54 = object92;
                            break;
                        }
                        default: {
                            throw new UnknownFieldException(v2);
                        }
                    }
                    object50 = object74;
                    v1 = v4;
                    object73 = object89;
                    object72 = object88;
                    object71 = object87;
                    object60 = object76;
                    object61 = object77;
                    object62 = object78;
                    object63 = object79;
                    object64 = object80;
                    object65 = object81;
                    object66 = object82;
                    object67 = object83;
                    object68 = object84;
                    object69 = object85;
                    object70 = object86;
                }
                object45 = object60;
                object44 = object63;
                object38 = object70;
                object18 = object71;
                object24 = object53;
                object36 = object56;
                object46 = object51;
                object22 = object52;
                object15 = object72;
                object41 = object64;
                object40 = object65;
                object1 = object59;
                v = v1;
                object23 = object54;
                object29 = object58;
                object47 = object61;
                object12 = object62;
                object48 = object67;
                object10 = object68;
                object35 = object50;
                object21 = object55;
                object17 = object73;
                object39 = object66;
                object32 = object57;
                object11 = object69;
            }
            compositeDecoder0.endStructure(serialDescriptor0);
            return new Account(v, ((Boolean)object1), ((Boolean)object45), ((Boolean)object47), ((Profile)object12), ((Boolean)object44), ((String)object41), ((Boolean)object40), ((Boolean)object39), ((Boolean)object48), ((String)object10), ((Boolean)object11), ((AgeRange)object38), ((Boolean)object18), ((String)object15), ((Boolean)object37), ((String)object17), ((BirthdayType)object21), ((Boolean)object23), ((Boolean)object22), ((Gender)object24), ((Boolean)object46), ((String)object42), ((Boolean)object43), ((String)object49), ((Boolean)object29), ((Gender)object32), ((Boolean)object0), ((String)object35), ((Boolean)object34), ((Boolean)object36), null);
        }

        @Override  // kotlinx.serialization.DeserializationStrategy
        public Object deserialize(Decoder decoder0) {
            return this.deserialize(decoder0);
        }

        @Override  // kotlinx.serialization.KSerializer
        @NotNull
        public SerialDescriptor getDescriptor() {
            return .serializer.descriptor;
        }

        public void serialize(@NotNull Encoder encoder0, @NotNull Account account0) {
            q.g(encoder0, "encoder");
            q.g(account0, "value");
            SerialDescriptor serialDescriptor0 = this.getDescriptor();
            CompositeEncoder compositeEncoder0 = encoder0.beginStructure(serialDescriptor0);
            Account.write$Self(account0, compositeEncoder0, serialDescriptor0);
            compositeEncoder0.endStructure(serialDescriptor0);
        }

        @Override  // kotlinx.serialization.SerializationStrategy
        public void serialize(Encoder encoder0, Object object0) {
            this.serialize(encoder0, ((Account)object0));
        }

        @Override  // kotlinx.serialization.internal.GeneratedSerializer
        @NotNull
        public KSerializer[] typeParametersSerializers() {
            return DefaultImpls.typeParametersSerializers(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/Account$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/Account;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KSerializer serializer() {
            return .serializer.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private final AgeRange ageRange;
    @Nullable
    private final Boolean ageRangeNeedsAgreement;
    @Nullable
    private final String birthday;
    @Nullable
    private final Boolean birthdayNeedsAgreement;
    @Nullable
    private final BirthdayType birthdayType;
    @Nullable
    private final String birthyear;
    @Nullable
    private final Boolean birthyearNeedsAgreement;
    @Nullable
    private final String email;
    @Nullable
    private final Boolean emailNeedsAgreement;
    @Nullable
    private final Gender gender;
    @Nullable
    private final Boolean genderNeedsAgreement;
    @Nullable
    private final Boolean isEmailValid;
    @Nullable
    private final Boolean isEmailVerified;
    @Nullable
    private final Boolean isKorean;
    @Nullable
    private final Boolean isKoreanNeedsAgreement;
    @Nullable
    private final Boolean isLeapMonth;
    @Nullable
    private final String legalBirthDate;
    @Nullable
    private final Boolean legalBirthDateNeedsAgreement;
    @Nullable
    private final Gender legalGender;
    @Nullable
    private final Boolean legalGenderNeedsAgreement;
    @Nullable
    private final String legalName;
    @Nullable
    private final Boolean legalNameNeedsAgreement;
    @Nullable
    private final String name;
    @Nullable
    private final Boolean nameNeedsAgreement;
    @Nullable
    private final String phoneNumber;
    @Nullable
    private final Boolean phoneNumberNeedsAgreement;
    @Nullable
    private final Profile profile;
    @Nullable
    private final Boolean profileImageNeedsAgreement;
    @Nullable
    private final Boolean profileNeedsAgreement;
    @Nullable
    private final Boolean profileNicknameNeedsAgreement;

    static {
        Account.Companion = new Companion(null);
    }

    @d
    public Account(int v, @SerialName("profile_needs_agreement") Boolean boolean0, @SerialName("profile_nickname_needs_agreement") Boolean boolean1, @SerialName("profile_image_needs_agreement") Boolean boolean2, Profile profile0, @SerialName("name_needs_agreement") Boolean boolean3, String s, @SerialName("email_needs_agreement") Boolean boolean4, @SerialName("is_email_valid") Boolean boolean5, @SerialName("is_email_verified") Boolean boolean6, String s1, @SerialName("age_range_needs_agreement") Boolean boolean7, @SerialName("age_range") AgeRange ageRange0, @SerialName("birthyear_needs_agreement") Boolean boolean8, String s2, @SerialName("birthday_needs_agreement") Boolean boolean9, String s3, @SerialName("birthday_type") BirthdayType birthdayType0, @SerialName("is_leap_month") Boolean boolean10, @SerialName("gender_needs_agreement") Boolean boolean11, Gender gender0, @SerialName("legal_name_needs_agreement") Boolean boolean12, @SerialName("legal_name") String s4, @SerialName("legal_birth_date_needs_agreement") Boolean boolean13, @SerialName("legal_birth_date") String s5, @SerialName("legal_gender_needs_agreement") Boolean boolean14, @SerialName("legal_gender") Gender gender1, @SerialName("phone_number_needs_agreement") Boolean boolean15, @SerialName("phone_number") String s6, @SerialName("is_korean_needs_agreement") Boolean boolean16, @SerialName("is_korean") Boolean boolean17, SerializationConstructorMarker serializationConstructorMarker0) {
        if(0x3FFFFFFF != (v & 0x3FFFFFFF)) {
            PluginExceptionsKt.throwMissingFieldException(v, 0x3FFFFFFF, .serializer.INSTANCE.getDescriptor());
        }
        super();
        this.profileNeedsAgreement = boolean0;
        this.profileNicknameNeedsAgreement = boolean1;
        this.profileImageNeedsAgreement = boolean2;
        this.profile = profile0;
        this.nameNeedsAgreement = boolean3;
        this.name = s;
        this.emailNeedsAgreement = boolean4;
        this.isEmailValid = boolean5;
        this.isEmailVerified = boolean6;
        this.email = s1;
        this.ageRangeNeedsAgreement = boolean7;
        this.ageRange = ageRange0;
        this.birthyearNeedsAgreement = boolean8;
        this.birthyear = s2;
        this.birthdayNeedsAgreement = boolean9;
        this.birthday = s3;
        this.birthdayType = birthdayType0;
        this.isLeapMonth = boolean10;
        this.genderNeedsAgreement = boolean11;
        this.gender = gender0;
        this.legalNameNeedsAgreement = boolean12;
        this.legalName = s4;
        this.legalBirthDateNeedsAgreement = boolean13;
        this.legalBirthDate = s5;
        this.legalGenderNeedsAgreement = boolean14;
        this.legalGender = gender1;
        this.phoneNumberNeedsAgreement = boolean15;
        this.phoneNumber = s6;
        this.isKoreanNeedsAgreement = boolean16;
        this.isKorean = boolean17;
    }

    public Account(@Nullable Boolean boolean0, @Nullable Boolean boolean1, @Nullable Boolean boolean2, @Nullable Profile profile0, @Nullable Boolean boolean3, @Nullable String s, @Nullable Boolean boolean4, @Nullable Boolean boolean5, @Nullable Boolean boolean6, @Nullable String s1, @Nullable Boolean boolean7, @Nullable AgeRange ageRange0, @Nullable Boolean boolean8, @Nullable String s2, @Nullable Boolean boolean9, @Nullable String s3, @Nullable BirthdayType birthdayType0, @Nullable Boolean boolean10, @Nullable Boolean boolean11, @Nullable Gender gender0, @Nullable Boolean boolean12, @Nullable String s4, @Nullable Boolean boolean13, @Nullable String s5, @Nullable Boolean boolean14, @Nullable Gender gender1, @Nullable Boolean boolean15, @Nullable String s6, @Nullable Boolean boolean16, @Nullable Boolean boolean17) {
        this.profileNeedsAgreement = boolean0;
        this.profileNicknameNeedsAgreement = boolean1;
        this.profileImageNeedsAgreement = boolean2;
        this.profile = profile0;
        this.nameNeedsAgreement = boolean3;
        this.name = s;
        this.emailNeedsAgreement = boolean4;
        this.isEmailValid = boolean5;
        this.isEmailVerified = boolean6;
        this.email = s1;
        this.ageRangeNeedsAgreement = boolean7;
        this.ageRange = ageRange0;
        this.birthyearNeedsAgreement = boolean8;
        this.birthyear = s2;
        this.birthdayNeedsAgreement = boolean9;
        this.birthday = s3;
        this.birthdayType = birthdayType0;
        this.isLeapMonth = boolean10;
        this.genderNeedsAgreement = boolean11;
        this.gender = gender0;
        this.legalNameNeedsAgreement = boolean12;
        this.legalName = s4;
        this.legalBirthDateNeedsAgreement = boolean13;
        this.legalBirthDate = s5;
        this.legalGenderNeedsAgreement = boolean14;
        this.legalGender = gender1;
        this.phoneNumberNeedsAgreement = boolean15;
        this.phoneNumber = s6;
        this.isKoreanNeedsAgreement = boolean16;
        this.isKorean = boolean17;
    }

    @Nullable
    public final Boolean component1() {
        return this.profileNeedsAgreement;
    }

    @Nullable
    public final String component10() {
        return this.email;
    }

    @Nullable
    public final Boolean component11() {
        return this.ageRangeNeedsAgreement;
    }

    @Nullable
    public final AgeRange component12() {
        return this.ageRange;
    }

    @Nullable
    public final Boolean component13() {
        return this.birthyearNeedsAgreement;
    }

    @Nullable
    public final String component14() {
        return this.birthyear;
    }

    @Nullable
    public final Boolean component15() {
        return this.birthdayNeedsAgreement;
    }

    @Nullable
    public final String component16() {
        return this.birthday;
    }

    @Nullable
    public final BirthdayType component17() {
        return this.birthdayType;
    }

    @Nullable
    public final Boolean component18() {
        return this.isLeapMonth;
    }

    @Nullable
    public final Boolean component19() {
        return this.genderNeedsAgreement;
    }

    @Nullable
    public final Boolean component2() {
        return this.profileNicknameNeedsAgreement;
    }

    @Nullable
    public final Gender component20() {
        return this.gender;
    }

    @Nullable
    public final Boolean component21() {
        return this.legalNameNeedsAgreement;
    }

    @Nullable
    public final String component22() {
        return this.legalName;
    }

    @Nullable
    public final Boolean component23() {
        return this.legalBirthDateNeedsAgreement;
    }

    @Nullable
    public final String component24() {
        return this.legalBirthDate;
    }

    @Nullable
    public final Boolean component25() {
        return this.legalGenderNeedsAgreement;
    }

    @Nullable
    public final Gender component26() {
        return this.legalGender;
    }

    @Nullable
    public final Boolean component27() {
        return this.phoneNumberNeedsAgreement;
    }

    @Nullable
    public final String component28() {
        return this.phoneNumber;
    }

    @Nullable
    public final Boolean component29() {
        return this.isKoreanNeedsAgreement;
    }

    @Nullable
    public final Boolean component3() {
        return this.profileImageNeedsAgreement;
    }

    @Nullable
    public final Boolean component30() {
        return this.isKorean;
    }

    @Nullable
    public final Profile component4() {
        return this.profile;
    }

    @Nullable
    public final Boolean component5() {
        return this.nameNeedsAgreement;
    }

    @Nullable
    public final String component6() {
        return this.name;
    }

    @Nullable
    public final Boolean component7() {
        return this.emailNeedsAgreement;
    }

    @Nullable
    public final Boolean component8() {
        return this.isEmailValid;
    }

    @Nullable
    public final Boolean component9() {
        return this.isEmailVerified;
    }

    @NotNull
    public final Account copy(@Nullable Boolean boolean0, @Nullable Boolean boolean1, @Nullable Boolean boolean2, @Nullable Profile profile0, @Nullable Boolean boolean3, @Nullable String s, @Nullable Boolean boolean4, @Nullable Boolean boolean5, @Nullable Boolean boolean6, @Nullable String s1, @Nullable Boolean boolean7, @Nullable AgeRange ageRange0, @Nullable Boolean boolean8, @Nullable String s2, @Nullable Boolean boolean9, @Nullable String s3, @Nullable BirthdayType birthdayType0, @Nullable Boolean boolean10, @Nullable Boolean boolean11, @Nullable Gender gender0, @Nullable Boolean boolean12, @Nullable String s4, @Nullable Boolean boolean13, @Nullable String s5, @Nullable Boolean boolean14, @Nullable Gender gender1, @Nullable Boolean boolean15, @Nullable String s6, @Nullable Boolean boolean16, @Nullable Boolean boolean17) {
        return new Account(boolean0, boolean1, boolean2, profile0, boolean3, s, boolean4, boolean5, boolean6, s1, boolean7, ageRange0, boolean8, s2, boolean9, s3, birthdayType0, boolean10, boolean11, gender0, boolean12, s4, boolean13, s5, boolean14, gender1, boolean15, s6, boolean16, boolean17);
    }

    public static Account copy$default(Account account0, Boolean boolean0, Boolean boolean1, Boolean boolean2, Profile profile0, Boolean boolean3, String s, Boolean boolean4, Boolean boolean5, Boolean boolean6, String s1, Boolean boolean7, AgeRange ageRange0, Boolean boolean8, String s2, Boolean boolean9, String s3, BirthdayType birthdayType0, Boolean boolean10, Boolean boolean11, Gender gender0, Boolean boolean12, String s4, Boolean boolean13, String s5, Boolean boolean14, Gender gender1, Boolean boolean15, String s6, Boolean boolean16, Boolean boolean17, int v, Object object0) {
        Boolean boolean18 = (v & 1) == 0 ? boolean0 : account0.profileNeedsAgreement;
        Boolean boolean19 = (v & 2) == 0 ? boolean1 : account0.profileNicknameNeedsAgreement;
        Boolean boolean20 = (v & 4) == 0 ? boolean2 : account0.profileImageNeedsAgreement;
        Profile profile1 = (v & 8) == 0 ? profile0 : account0.profile;
        Boolean boolean21 = (v & 16) == 0 ? boolean3 : account0.nameNeedsAgreement;
        String s7 = (v & 0x20) == 0 ? s : account0.name;
        Boolean boolean22 = (v & 0x40) == 0 ? boolean4 : account0.emailNeedsAgreement;
        Boolean boolean23 = (v & 0x80) == 0 ? boolean5 : account0.isEmailValid;
        Boolean boolean24 = (v & 0x100) == 0 ? boolean6 : account0.isEmailVerified;
        String s8 = (v & 0x200) == 0 ? s1 : account0.email;
        Boolean boolean25 = (v & 0x400) == 0 ? boolean7 : account0.ageRangeNeedsAgreement;
        AgeRange ageRange1 = (v & 0x800) == 0 ? ageRange0 : account0.ageRange;
        Boolean boolean26 = (v & 0x1000) == 0 ? boolean8 : account0.birthyearNeedsAgreement;
        String s9 = (v & 0x2000) == 0 ? s2 : account0.birthyear;
        Boolean boolean27 = (v & 0x4000) == 0 ? boolean9 : account0.birthdayNeedsAgreement;
        String s10 = (v & 0x8000) == 0 ? s3 : account0.birthday;
        BirthdayType birthdayType1 = (v & 0x10000) == 0 ? birthdayType0 : account0.birthdayType;
        Boolean boolean28 = (v & 0x20000) == 0 ? boolean10 : account0.isLeapMonth;
        Boolean boolean29 = (v & 0x40000) == 0 ? boolean11 : account0.genderNeedsAgreement;
        Gender gender2 = (v & 0x80000) == 0 ? gender0 : account0.gender;
        Boolean boolean30 = (v & 0x100000) == 0 ? boolean12 : account0.legalNameNeedsAgreement;
        String s11 = (v & 0x200000) == 0 ? s4 : account0.legalName;
        Boolean boolean31 = (v & 0x400000) == 0 ? boolean13 : account0.legalBirthDateNeedsAgreement;
        String s12 = (v & 0x800000) == 0 ? s5 : account0.legalBirthDate;
        Boolean boolean32 = (v & 0x1000000) == 0 ? boolean14 : account0.legalGenderNeedsAgreement;
        Gender gender3 = (v & 0x2000000) == 0 ? gender1 : account0.legalGender;
        Boolean boolean33 = (v & 0x4000000) == 0 ? boolean15 : account0.phoneNumberNeedsAgreement;
        String s13 = (v & 0x8000000) == 0 ? s6 : account0.phoneNumber;
        Boolean boolean34 = (v & 0x10000000) == 0 ? boolean16 : account0.isKoreanNeedsAgreement;
        return (v & 0x20000000) == 0 ? account0.copy(boolean18, boolean19, boolean20, profile1, boolean21, s7, boolean22, boolean23, boolean24, s8, boolean25, ageRange1, boolean26, s9, boolean27, s10, birthdayType1, boolean28, boolean29, gender2, boolean30, s11, boolean31, s12, boolean32, gender3, boolean33, s13, boolean34, boolean17) : account0.copy(boolean18, boolean19, boolean20, profile1, boolean21, s7, boolean22, boolean23, boolean24, s8, boolean25, ageRange1, boolean26, s9, boolean27, s10, birthdayType1, boolean28, boolean29, gender2, boolean30, s11, boolean31, s12, boolean32, gender3, boolean33, s13, boolean34, account0.isKorean);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Account)) {
            return false;
        }
        Account account0 = (Account)object0;
        if(!q.b(this.profileNeedsAgreement, account0.profileNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.profileNicknameNeedsAgreement, account0.profileNicknameNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.profileImageNeedsAgreement, account0.profileImageNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.profile, account0.profile)) {
            return false;
        }
        if(!q.b(this.nameNeedsAgreement, account0.nameNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.name, account0.name)) {
            return false;
        }
        if(!q.b(this.emailNeedsAgreement, account0.emailNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.isEmailValid, account0.isEmailValid)) {
            return false;
        }
        if(!q.b(this.isEmailVerified, account0.isEmailVerified)) {
            return false;
        }
        if(!q.b(this.email, account0.email)) {
            return false;
        }
        if(!q.b(this.ageRangeNeedsAgreement, account0.ageRangeNeedsAgreement)) {
            return false;
        }
        if(this.ageRange != account0.ageRange) {
            return false;
        }
        if(!q.b(this.birthyearNeedsAgreement, account0.birthyearNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.birthyear, account0.birthyear)) {
            return false;
        }
        if(!q.b(this.birthdayNeedsAgreement, account0.birthdayNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.birthday, account0.birthday)) {
            return false;
        }
        if(this.birthdayType != account0.birthdayType) {
            return false;
        }
        if(!q.b(this.isLeapMonth, account0.isLeapMonth)) {
            return false;
        }
        if(!q.b(this.genderNeedsAgreement, account0.genderNeedsAgreement)) {
            return false;
        }
        if(this.gender != account0.gender) {
            return false;
        }
        if(!q.b(this.legalNameNeedsAgreement, account0.legalNameNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.legalName, account0.legalName)) {
            return false;
        }
        if(!q.b(this.legalBirthDateNeedsAgreement, account0.legalBirthDateNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.legalBirthDate, account0.legalBirthDate)) {
            return false;
        }
        if(!q.b(this.legalGenderNeedsAgreement, account0.legalGenderNeedsAgreement)) {
            return false;
        }
        if(this.legalGender != account0.legalGender) {
            return false;
        }
        if(!q.b(this.phoneNumberNeedsAgreement, account0.phoneNumberNeedsAgreement)) {
            return false;
        }
        if(!q.b(this.phoneNumber, account0.phoneNumber)) {
            return false;
        }
        return q.b(this.isKoreanNeedsAgreement, account0.isKoreanNeedsAgreement) ? q.b(this.isKorean, account0.isKorean) : false;
    }

    @Nullable
    public final AgeRange getAgeRange() {
        return this.ageRange;
    }

    @SerialName("age_range")
    public static void getAgeRange$annotations() {
    }

    @Nullable
    public final Boolean getAgeRangeNeedsAgreement() {
        return this.ageRangeNeedsAgreement;
    }

    @SerialName("age_range_needs_agreement")
    public static void getAgeRangeNeedsAgreement$annotations() {
    }

    @Nullable
    public final String getBirthday() {
        return this.birthday;
    }

    @Nullable
    public final Boolean getBirthdayNeedsAgreement() {
        return this.birthdayNeedsAgreement;
    }

    @SerialName("birthday_needs_agreement")
    public static void getBirthdayNeedsAgreement$annotations() {
    }

    @Nullable
    public final BirthdayType getBirthdayType() {
        return this.birthdayType;
    }

    @SerialName("birthday_type")
    public static void getBirthdayType$annotations() {
    }

    @Nullable
    public final String getBirthyear() {
        return this.birthyear;
    }

    @Nullable
    public final Boolean getBirthyearNeedsAgreement() {
        return this.birthyearNeedsAgreement;
    }

    @SerialName("birthyear_needs_agreement")
    public static void getBirthyearNeedsAgreement$annotations() {
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final Boolean getEmailNeedsAgreement() {
        return this.emailNeedsAgreement;
    }

    @SerialName("email_needs_agreement")
    public static void getEmailNeedsAgreement$annotations() {
    }

    @Nullable
    public final Gender getGender() {
        return this.gender;
    }

    @Nullable
    public final Boolean getGenderNeedsAgreement() {
        return this.genderNeedsAgreement;
    }

    @SerialName("gender_needs_agreement")
    public static void getGenderNeedsAgreement$annotations() {
    }

    @Nullable
    public final String getLegalBirthDate() {
        return this.legalBirthDate;
    }

    @SerialName("legal_birth_date")
    public static void getLegalBirthDate$annotations() {
    }

    @Nullable
    public final Boolean getLegalBirthDateNeedsAgreement() {
        return this.legalBirthDateNeedsAgreement;
    }

    @SerialName("legal_birth_date_needs_agreement")
    public static void getLegalBirthDateNeedsAgreement$annotations() {
    }

    @Nullable
    public final Gender getLegalGender() {
        return this.legalGender;
    }

    @SerialName("legal_gender")
    public static void getLegalGender$annotations() {
    }

    @Nullable
    public final Boolean getLegalGenderNeedsAgreement() {
        return this.legalGenderNeedsAgreement;
    }

    @SerialName("legal_gender_needs_agreement")
    public static void getLegalGenderNeedsAgreement$annotations() {
    }

    @Nullable
    public final String getLegalName() {
        return this.legalName;
    }

    @SerialName("legal_name")
    public static void getLegalName$annotations() {
    }

    @Nullable
    public final Boolean getLegalNameNeedsAgreement() {
        return this.legalNameNeedsAgreement;
    }

    @SerialName("legal_name_needs_agreement")
    public static void getLegalNameNeedsAgreement$annotations() {
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Boolean getNameNeedsAgreement() {
        return this.nameNeedsAgreement;
    }

    @SerialName("name_needs_agreement")
    public static void getNameNeedsAgreement$annotations() {
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @SerialName("phone_number")
    public static void getPhoneNumber$annotations() {
    }

    @Nullable
    public final Boolean getPhoneNumberNeedsAgreement() {
        return this.phoneNumberNeedsAgreement;
    }

    @SerialName("phone_number_needs_agreement")
    public static void getPhoneNumberNeedsAgreement$annotations() {
    }

    @Nullable
    public final Profile getProfile() {
        return this.profile;
    }

    @Nullable
    public final Boolean getProfileImageNeedsAgreement() {
        return this.profileImageNeedsAgreement;
    }

    @SerialName("profile_image_needs_agreement")
    public static void getProfileImageNeedsAgreement$annotations() {
    }

    @Nullable
    public final Boolean getProfileNeedsAgreement() {
        return this.profileNeedsAgreement;
    }

    @SerialName("profile_needs_agreement")
    public static void getProfileNeedsAgreement$annotations() {
    }

    @Nullable
    public final Boolean getProfileNicknameNeedsAgreement() {
        return this.profileNicknameNeedsAgreement;
    }

    @SerialName("profile_nickname_needs_agreement")
    public static void getProfileNicknameNeedsAgreement$annotations() {
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.profileNeedsAgreement == null ? 0 : this.profileNeedsAgreement.hashCode();
        int v2 = this.profileNicknameNeedsAgreement == null ? 0 : this.profileNicknameNeedsAgreement.hashCode();
        int v3 = this.profileImageNeedsAgreement == null ? 0 : this.profileImageNeedsAgreement.hashCode();
        int v4 = this.profile == null ? 0 : this.profile.hashCode();
        int v5 = this.nameNeedsAgreement == null ? 0 : this.nameNeedsAgreement.hashCode();
        int v6 = this.name == null ? 0 : this.name.hashCode();
        int v7 = this.emailNeedsAgreement == null ? 0 : this.emailNeedsAgreement.hashCode();
        int v8 = this.isEmailValid == null ? 0 : this.isEmailValid.hashCode();
        int v9 = this.isEmailVerified == null ? 0 : this.isEmailVerified.hashCode();
        int v10 = this.email == null ? 0 : this.email.hashCode();
        int v11 = this.ageRangeNeedsAgreement == null ? 0 : this.ageRangeNeedsAgreement.hashCode();
        int v12 = this.ageRange == null ? 0 : this.ageRange.hashCode();
        int v13 = this.birthyearNeedsAgreement == null ? 0 : this.birthyearNeedsAgreement.hashCode();
        int v14 = this.birthyear == null ? 0 : this.birthyear.hashCode();
        int v15 = this.birthdayNeedsAgreement == null ? 0 : this.birthdayNeedsAgreement.hashCode();
        int v16 = this.birthday == null ? 0 : this.birthday.hashCode();
        int v17 = this.birthdayType == null ? 0 : this.birthdayType.hashCode();
        int v18 = this.isLeapMonth == null ? 0 : this.isLeapMonth.hashCode();
        int v19 = this.genderNeedsAgreement == null ? 0 : this.genderNeedsAgreement.hashCode();
        int v20 = this.gender == null ? 0 : this.gender.hashCode();
        int v21 = this.legalNameNeedsAgreement == null ? 0 : this.legalNameNeedsAgreement.hashCode();
        int v22 = this.legalName == null ? 0 : this.legalName.hashCode();
        int v23 = this.legalBirthDateNeedsAgreement == null ? 0 : this.legalBirthDateNeedsAgreement.hashCode();
        int v24 = this.legalBirthDate == null ? 0 : this.legalBirthDate.hashCode();
        int v25 = this.legalGenderNeedsAgreement == null ? 0 : this.legalGenderNeedsAgreement.hashCode();
        int v26 = this.legalGender == null ? 0 : this.legalGender.hashCode();
        int v27 = this.phoneNumberNeedsAgreement == null ? 0 : this.phoneNumberNeedsAgreement.hashCode();
        int v28 = this.phoneNumber == null ? 0 : this.phoneNumber.hashCode();
        int v29 = this.isKoreanNeedsAgreement == null ? 0 : this.isKoreanNeedsAgreement.hashCode();
        Boolean boolean0 = this.isKorean;
        if(boolean0 != null) {
            v = boolean0.hashCode();
        }
        return ((((((((((((((((((((((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v12) * 0x1F + v13) * 0x1F + v14) * 0x1F + v15) * 0x1F + v16) * 0x1F + v17) * 0x1F + v18) * 0x1F + v19) * 0x1F + v20) * 0x1F + v21) * 0x1F + v22) * 0x1F + v23) * 0x1F + v24) * 0x1F + v25) * 0x1F + v26) * 0x1F + v27) * 0x1F + v28) * 0x1F + v29) * 0x1F + v;
    }

    @Nullable
    public final Boolean isEmailValid() {
        return this.isEmailValid;
    }

    @SerialName("is_email_valid")
    public static void isEmailValid$annotations() {
    }

    @Nullable
    public final Boolean isEmailVerified() {
        return this.isEmailVerified;
    }

    @SerialName("is_email_verified")
    public static void isEmailVerified$annotations() {
    }

    @Nullable
    public final Boolean isKorean() {
        return this.isKorean;
    }

    @SerialName("is_korean")
    public static void isKorean$annotations() {
    }

    @Nullable
    public final Boolean isKoreanNeedsAgreement() {
        return this.isKoreanNeedsAgreement;
    }

    @SerialName("is_korean_needs_agreement")
    public static void isKoreanNeedsAgreement$annotations() {
    }

    @Nullable
    public final Boolean isLeapMonth() {
        return this.isLeapMonth;
    }

    @SerialName("is_leap_month")
    public static void isLeapMonth$annotations() {
    }

    @Override
    @NotNull
    public String toString() {
        return "Account(profileNeedsAgreement=" + this.profileNeedsAgreement + ", profileNicknameNeedsAgreement=" + this.profileNicknameNeedsAgreement + ", profileImageNeedsAgreement=" + this.profileImageNeedsAgreement + ", profile=" + this.profile + ", nameNeedsAgreement=" + this.nameNeedsAgreement + ", name=" + this.name + ", emailNeedsAgreement=" + this.emailNeedsAgreement + ", isEmailValid=" + this.isEmailValid + ", isEmailVerified=" + this.isEmailVerified + ", email=" + this.email + ", ageRangeNeedsAgreement=" + this.ageRangeNeedsAgreement + ", ageRange=" + this.ageRange + ", birthyearNeedsAgreement=" + this.birthyearNeedsAgreement + ", birthyear=" + this.birthyear + ", birthdayNeedsAgreement=" + this.birthdayNeedsAgreement + ", birthday=" + this.birthday + ", birthdayType=" + this.birthdayType + ", isLeapMonth=" + this.isLeapMonth + ", genderNeedsAgreement=" + this.genderNeedsAgreement + ", gender=" + this.gender + ", legalNameNeedsAgreement=" + this.legalNameNeedsAgreement + ", legalName=" + this.legalName + ", legalBirthDateNeedsAgreement=" + this.legalBirthDateNeedsAgreement + ", legalBirthDate=" + this.legalBirthDate + ", legalGenderNeedsAgreement=" + this.legalGenderNeedsAgreement + ", legalGender=" + this.legalGender + ", phoneNumberNeedsAgreement=" + this.phoneNumberNeedsAgreement + ", phoneNumber=" + this.phoneNumber + ", isKoreanNeedsAgreement=" + this.isKoreanNeedsAgreement + ", isKorean=" + this.isKorean + ")";
    }

    public static final void write$Self(@NotNull Account account0, @NotNull CompositeEncoder compositeEncoder0, @NotNull SerialDescriptor serialDescriptor0) {
        q.g(account0, "self");
        q.g(compositeEncoder0, "output");
        q.g(serialDescriptor0, "serialDesc");
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 0, BooleanSerializer.INSTANCE, account0.profileNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 1, BooleanSerializer.INSTANCE, account0.profileNicknameNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 2, BooleanSerializer.INSTANCE, account0.profileImageNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 3, com.kakao.sdk.user.model.Profile..serializer.INSTANCE, account0.profile);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 4, BooleanSerializer.INSTANCE, account0.nameNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 5, StringSerializer.INSTANCE, account0.name);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 6, BooleanSerializer.INSTANCE, account0.emailNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 7, BooleanSerializer.INSTANCE, account0.isEmailValid);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 8, BooleanSerializer.INSTANCE, account0.isEmailVerified);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 9, StringSerializer.INSTANCE, account0.email);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 10, BooleanSerializer.INSTANCE, account0.ageRangeNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 11, AgeRangeSerializer.INSTANCE, account0.ageRange);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 12, BooleanSerializer.INSTANCE, account0.birthyearNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 13, StringSerializer.INSTANCE, account0.birthyear);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 14, BooleanSerializer.INSTANCE, account0.birthdayNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 15, StringSerializer.INSTANCE, account0.birthday);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 16, BirthdayTypeSerializer.INSTANCE, account0.birthdayType);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 17, BooleanSerializer.INSTANCE, account0.isLeapMonth);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 18, BooleanSerializer.INSTANCE, account0.genderNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 19, GenderSerializer.INSTANCE, account0.gender);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 20, BooleanSerializer.INSTANCE, account0.legalNameNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 21, StringSerializer.INSTANCE, account0.legalName);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 22, BooleanSerializer.INSTANCE, account0.legalBirthDateNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 23, StringSerializer.INSTANCE, account0.legalBirthDate);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 24, BooleanSerializer.INSTANCE, account0.legalGenderNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 25, GenderSerializer.INSTANCE, account0.legalGender);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 26, BooleanSerializer.INSTANCE, account0.phoneNumberNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 27, StringSerializer.INSTANCE, account0.phoneNumber);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 28, BooleanSerializer.INSTANCE, account0.isKoreanNeedsAgreement);
        compositeEncoder0.encodeNullableSerializableElement(serialDescriptor0, 29, BooleanSerializer.INSTANCE, account0.isKorean);
    }
}

