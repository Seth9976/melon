package okio.internal;

import U4.x;
import java.io.EOFException;
import je.n;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.-SegmentedByteString;
import okio.Buffer.UnsafeCursor;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0016\n\u0002\b\u0006\u001A7\u0010\t\u001A\u00020\b2\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0002H\u0000\u00A2\u0006\u0004\b\t\u0010\n\u001A\u001B\u0010\u000F\u001A\u00020\u000E*\u00020\u000B2\u0006\u0010\r\u001A\u00020\fH\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010\u001AA\u0010\u0015\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0011*\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\f2\u001A\u0010\u0014\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0013H\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0015\u0010\u0016\u001A%\u0010\u001A\u001A\u00020\u0002*\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u00172\b\b\u0002\u0010\u0019\u001A\u00020\bH\u0000\u00A2\u0006\u0004\b\u001A\u0010\u001B\u001A,\u0010\u001F\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\u001F\u0010 \u001A\u0014\u0010!\u001A\u00020\f*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b!\u0010\"\u001A\u0014\u0010$\u001A\u00020#*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b$\u0010%\u001A\u0014\u0010\'\u001A\u00020&*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b\'\u0010(\u001A\u0014\u0010)\u001A\u00020\u0002*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b)\u0010*\u001A\u0014\u0010+\u001A\u00020\f*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b+\u0010\"\u001A\u001C\u0010-\u001A\u00020#*\u00020\u000B2\u0006\u0010,\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b-\u0010.\u001A\u0014\u00100\u001A\u00020/*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b0\u00101\u001A\u001C\u00102\u001A\u00020/*\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b2\u00103\u001A0\u00106\u001A\u00020\u000B*\u00020\u000B2\u0006\u00105\u001A\u0002042\b\b\u0002\u0010\u001D\u001A\u00020\u00022\b\b\u0002\u0010\u001E\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\b6\u00107\u001A\u001C\u00109\u001A\u00020\u000B*\u00020\u000B2\u0006\u00108\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b9\u0010:\u001A\u0017\u0010;\u001A\u00020\u00022\u0006\u00108\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b;\u0010<\u001A\u001C\u0010=\u001A\u00020\u000B*\u00020\u000B2\u0006\u00108\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b=\u0010:\u001A\u001C\u0010?\u001A\u00020\u0000*\u00020\u000B2\u0006\u0010>\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\b?\u0010@\u001A\u001C\u00106\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010A\u001A\u00020\u0004H\u0080\b\u00A2\u0006\u0004\b6\u0010B\u001A,\u00106\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010A\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\b6\u0010C\u001A\u0014\u0010D\u001A\u00020\u0004*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\bD\u0010E\u001A\u001C\u0010D\u001A\u00020\u0004*\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bD\u0010F\u001A\u001C\u0010H\u001A\u00020\u0002*\u00020\u000B2\u0006\u0010G\u001A\u00020\u0004H\u0080\b\u00A2\u0006\u0004\bH\u0010I\u001A\u001C\u0010J\u001A\u00020/*\u00020\u000B2\u0006\u0010G\u001A\u00020\u0004H\u0080\b\u00A2\u0006\u0004\bJ\u0010K\u001A,\u0010H\u001A\u00020\u0002*\u00020\u000B2\u0006\u0010G\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\bH\u0010L\u001A\u0014\u0010M\u001A\u00020\f*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\bM\u0010\"\u001A\u0014\u0010N\u001A\u00020\f*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\bN\u0010\"\u001A\u0014\u0010O\u001A\u000204*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\bO\u0010P\u001A\u001C\u0010O\u001A\u000204*\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bO\u0010Q\u001A\u001C\u0010R\u001A\u00020\u0002*\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u0017H\u0080\b\u00A2\u0006\u0004\bR\u0010S\u001A$\u0010J\u001A\u00020/*\u00020\u000B2\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bJ\u0010T\u001A\u001C\u0010V\u001A\u00020\f*\u00020\u000B2\u0006\u0010G\u001A\u00020UH\u0080\b\u00A2\u0006\u0004\bV\u0010W\u001A\u001C\u0010X\u001A\u00020\u000E*\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bX\u0010\u0010\u001A\u0016\u0010Y\u001A\u0004\u0018\u00010\u000E*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\bY\u0010Z\u001A\u001C\u0010\\\u001A\u00020\u000E*\u00020\u000B2\u0006\u0010[\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\\\u0010\u0010\u001A\u0014\u0010]\u001A\u00020\u0002*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b]\u0010*\u001A,\u0010a\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010^\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020\u00022\u0006\u0010`\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\ba\u0010b\u001A\u001C\u0010d\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010c\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\bd\u0010e\u001A\u001C\u0010g\u001A\u00020\f*\u00020\u000B2\u0006\u0010A\u001A\u00020fH\u0080\b\u00A2\u0006\u0004\bg\u0010h\u001A$\u00106\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010A\u001A\u00020f2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b6\u0010i\u001A\u001C\u0010k\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010j\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\bk\u0010e\u001A\u001C\u0010m\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010l\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\bm\u0010e\u001A\u001C\u0010o\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010n\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\bo\u0010e\u001A\u001C\u0010p\u001A\u00020\u000B*\u00020\u000B2\u0006\u00108\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bp\u0010:\u001A$\u00106\u001A\u00020/*\u00020\u000B2\u0006\u0010A\u001A\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b6\u0010T\u001A$\u0010H\u001A\u00020\f*\u00020\u000B2\u0006\u0010G\u001A\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bH\u0010q\u001A,\u0010s\u001A\u00020\f*\u00020\u000B2\u0006\u0010j\u001A\u00020#2\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010r\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bs\u0010t\u001AA\u0010s\u001A\u00020\f*\u00020\u000B2\u0006\u0010\u0005\u001A\u0002042\u0006\u0010\u0012\u001A\u00020\f2\b\b\u0002\u0010r\u001A\u00020\f2\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u001E\u001A\u00020\u0002H\u0000\u00A2\u0006\u0004\bs\u0010u\u001A$\u0010w\u001A\u00020\f*\u00020\u000B2\u0006\u0010v\u001A\u0002042\u0006\u0010\u0012\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\bw\u0010x\u001A4\u0010y\u001A\u00020\b*\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u0005\u001A\u0002042\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0004\by\u0010z\u001A\u001E\u0010}\u001A\u00020\b*\u00020\u000B2\b\u0010|\u001A\u0004\u0018\u00010{H\u0080\b\u00A2\u0006\u0004\b}\u0010~\u001A\u0014\u0010\u007F\u001A\u00020\u0002*\u00020\u000BH\u0080\b\u00A2\u0006\u0004\b\u007F\u0010*\u001A\u0017\u0010\u0080\u0001\u001A\u00020\u000B*\u00020\u000BH\u0080\b\u00A2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\u001A\u0016\u0010\u0082\u0001\u001A\u000204*\u00020\u000BH\u0080\b\u00A2\u0006\u0005\b\u0082\u0001\u0010P\u001A\u001F\u0010\u0082\u0001\u001A\u000204*\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001A!\u0010\u0086\u0001\u001A\u00030\u0084\u0001*\u00020\u000B2\b\u0010\u0085\u0001\u001A\u00030\u0084\u0001H\u0000\u00A2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001\u001A!\u0010\u0088\u0001\u001A\u00030\u0084\u0001*\u00020\u000B2\b\u0010\u0085\u0001\u001A\u00030\u0084\u0001H\u0000\u00A2\u0006\u0006\b\u0088\u0001\u0010\u0087\u0001\u001A\u0018\u0010\u0089\u0001\u001A\u00020\u0002*\u00030\u0084\u0001H\u0080\b\u00A2\u0006\u0006\b\u0089\u0001\u0010\u008A\u0001\u001A \u0010\u008B\u0001\u001A\u00020\u0002*\u00030\u0084\u00012\u0006\u0010\u001D\u001A\u00020\fH\u0080\b\u00A2\u0006\u0006\b\u008B\u0001\u0010\u008C\u0001\u001A!\u0010\u008E\u0001\u001A\u00020\f*\u00030\u0084\u00012\u0007\u0010\u008D\u0001\u001A\u00020\fH\u0080\b\u00A2\u0006\u0006\b\u008E\u0001\u0010\u008F\u0001\u001A!\u0010\u0091\u0001\u001A\u00020\f*\u00030\u0084\u00012\u0007\u0010\u0090\u0001\u001A\u00020\u0002H\u0080\b\u00A2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001\u001A\u0018\u0010\u0093\u0001\u001A\u00020/*\u00030\u0084\u0001H\u0080\b\u00A2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u001F\u0010\u0095\u0001\u001A\u00020\u00048\u0000X\u0080\u0004\u00A2\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001A\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0017\u0010\u0099\u0001\u001A\u00020\u00028\u0000X\u0080T\u00A2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009A\u0001\"\u0018\u0010\u009C\u0001\u001A\u00030\u009B\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u009C\u0001\u0010\u009D\u0001\"\u0017\u0010\u009E\u0001\u001A\u00020\f8\u0000X\u0080T\u00A2\u0006\b\n\u0006\b\u009E\u0001\u0010\u009F\u0001\"\u0017\u0010\u00A0\u0001\u001A\u00020\f8\u0000X\u0080T\u00A2\u0006\b\n\u0006\b\u00A0\u0001\u0010\u009F\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u0006\u00A1\u0001"}, d2 = {"Lokio/Segment;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "rangeEquals", "(Lokio/Segment;I[BII)Z", "Lokio/Buffer;", "", "newline", "", "readUtf8Line", "(Lokio/Buffer;J)Ljava/lang/String;", "T", "fromIndex", "Lkotlin/Function2;", "lambda", "seek", "(Lokio/Buffer;JLwe/n;)Ljava/lang/Object;", "Lokio/Options;", "options", "selectTruncated", "selectPrefix", "(Lokio/Buffer;Lokio/Options;Z)I", "out", "offset", "byteCount", "commonCopyTo", "(Lokio/Buffer;Lokio/Buffer;JJ)Lokio/Buffer;", "commonCompleteSegmentByteCount", "(Lokio/Buffer;)J", "", "commonReadByte", "(Lokio/Buffer;)B", "", "commonReadShort", "(Lokio/Buffer;)S", "commonReadInt", "(Lokio/Buffer;)I", "commonReadLong", "pos", "commonGet", "(Lokio/Buffer;J)B", "Lie/H;", "commonClear", "(Lokio/Buffer;)V", "commonSkip", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "commonWrite", "(Lokio/Buffer;Lokio/ByteString;II)Lokio/Buffer;", "v", "commonWriteDecimalLong", "(Lokio/Buffer;J)Lokio/Buffer;", "countDigitsIn", "(J)I", "commonWriteHexadecimalUnsignedLong", "minimumCapacity", "commonWritableSegment", "(Lokio/Buffer;I)Lokio/Segment;", "source", "(Lokio/Buffer;[B)Lokio/Buffer;", "(Lokio/Buffer;[BII)Lokio/Buffer;", "commonReadByteArray", "(Lokio/Buffer;)[B", "(Lokio/Buffer;J)[B", "sink", "commonRead", "(Lokio/Buffer;[B)I", "commonReadFully", "(Lokio/Buffer;[B)V", "(Lokio/Buffer;[BII)I", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "(Lokio/Buffer;)Lokio/ByteString;", "(Lokio/Buffer;J)Lokio/ByteString;", "commonSelect", "(Lokio/Buffer;Lokio/Options;)I", "(Lokio/Buffer;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/Buffer;Lokio/Sink;)J", "commonReadUtf8", "commonReadUtf8Line", "(Lokio/Buffer;)Ljava/lang/String;", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "string", "beginIndex", "endIndex", "commonWriteUtf8", "(Lokio/Buffer;Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "commonWriteUtf8CodePoint", "(Lokio/Buffer;I)Lokio/Buffer;", "Lokio/Source;", "commonWriteAll", "(Lokio/Buffer;Lokio/Source;)J", "(Lokio/Buffer;Lokio/Source;J)Lokio/Buffer;", "b", "commonWriteByte", "s", "commonWriteShort", "i", "commonWriteInt", "commonWriteLong", "(Lokio/Buffer;Lokio/Buffer;J)J", "toIndex", "commonIndexOf", "(Lokio/Buffer;BJJ)J", "(Lokio/Buffer;Lokio/ByteString;JJII)J", "targetBytes", "commonIndexOfElement", "(Lokio/Buffer;Lokio/ByteString;J)J", "commonRangeEquals", "(Lokio/Buffer;JLokio/ByteString;II)Z", "", "other", "commonEquals", "(Lokio/Buffer;Ljava/lang/Object;)Z", "commonHashCode", "commonCopy", "(Lokio/Buffer;)Lokio/Buffer;", "commonSnapshot", "(Lokio/Buffer;I)Lokio/ByteString;", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "commonReadUnsafe", "(Lokio/Buffer;Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "commonReadAndWriteUnsafe", "commonNext", "(Lokio/Buffer$UnsafeCursor;)I", "commonSeek", "(Lokio/Buffer$UnsafeCursor;J)I", "newSize", "commonResizeBuffer", "(Lokio/Buffer$UnsafeCursor;J)J", "minByteCount", "commonExpandBuffer", "(Lokio/Buffer$UnsafeCursor;I)J", "commonClose", "(Lokio/Buffer$UnsafeCursor;)V", "HEX_DIGIT_BYTES", "[B", "getHEX_DIGIT_BYTES", "()[B", "SEGMENTING_THRESHOLD", "I", "", "DigitCountToLargestValue", "[J", "OVERFLOW_ZONE", "J", "OVERFLOW_DIGIT_START", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -Buffer {
    @NotNull
    private static final long[] DigitCountToLargestValue = null;
    @NotNull
    private static final byte[] HEX_DIGIT_BYTES = null;
    public static final long OVERFLOW_DIGIT_START = -7L;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 0x1000;

    static {
        -Buffer.HEX_DIGIT_BYTES = new byte[]{0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        -Buffer.DigitCountToLargestValue = new long[]{-1L, 9L, 99L, 999L, 0x270FL, 0x1869FL, 0xF423FL, 0x98967FL, 0x5F5E0FFL, 0x3B9AC9FFL, 0x2540BE3FFL, 0x174876E7FFL, 0xE8D4A50FFFL, 0x9184E729FFFL, 0x5AF3107A3FFFL, 0x38D7EA4C67FFFL, 0x2386F26FC0FFFFL, 0x16345785D89FFFFL, 0xDE0B6B3A763FFFFL, 0x7FFFFFFFFFFFFFFFL};
    }

    public static final void commonClear(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        buffer0.skip(buffer0.size());
    }

    public static final void commonClose(@NotNull UnsafeCursor buffer$UnsafeCursor0) {
        q.g(buffer$UnsafeCursor0, "<this>");
        if(buffer$UnsafeCursor0.buffer == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        buffer$UnsafeCursor0.buffer = null;
        buffer$UnsafeCursor0.setSegment$okio(null);
        buffer$UnsafeCursor0.offset = -1L;
        buffer$UnsafeCursor0.data = null;
        buffer$UnsafeCursor0.start = -1;
        buffer$UnsafeCursor0.end = -1;
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        long v = buffer0.size();
        if(v == 0L) {
            return 0L;
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        Segment segment1 = segment0.prev;
        q.d(segment1);
        return segment1.limit >= 0x2000 || !segment1.owner ? v : v - ((long)(segment1.limit - segment1.pos));
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        Buffer buffer1 = new Buffer();
        if(buffer0.size() == 0L) {
            return buffer1;
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        Segment segment1 = segment0.sharedCopy();
        buffer1.head = segment1;
        segment1.prev = segment1;
        segment1.next = segment1;
        for(Segment segment2 = segment0.next; segment2 != segment0; segment2 = segment2.next) {
            Segment segment3 = segment1.prev;
            q.d(segment3);
            q.d(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer1.setSize$okio(buffer0.size());
        return buffer1;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer buffer0, @NotNull Buffer buffer1, long v, long v1) {
        q.g(buffer0, "<this>");
        q.g(buffer1, "out");
        long v2 = v;
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), v2, v1);
        if(v1 != 0L) {
            buffer1.setSize$okio(buffer1.size() + v1);
            Segment segment0;
            for(segment0 = buffer0.head; true; segment0 = segment0.next) {
                q.d(segment0);
                int v3 = segment0.limit;
                int v4 = segment0.pos;
                if(v2 < ((long)(v3 - v4))) {
                    break;
                }
                v2 -= (long)(v3 - v4);
            }
            Segment segment1 = segment0;
            long v5 = v1;
            while(v5 > 0L) {
                q.d(segment1);
                Segment segment2 = segment1.sharedCopy();
                int v6 = segment2.pos + ((int)v2);
                segment2.pos = v6;
                segment2.limit = Math.min(v6 + ((int)v5), segment2.limit);
                Segment segment3 = buffer1.head;
                if(segment3 == null) {
                    segment2.prev = segment2;
                    segment2.next = segment2;
                    buffer1.head = segment2;
                }
                else {
                    q.d(segment3);
                    Segment segment4 = segment3.prev;
                    q.d(segment4);
                    segment4.push(segment2);
                }
                v5 -= (long)(segment2.limit - segment2.pos);
                segment1 = segment1.next;
                v2 = 0L;
            }
        }
        return buffer0;
    }

    public static final boolean commonEquals(@NotNull Buffer buffer0, @Nullable Object object0) {
        q.g(buffer0, "<this>");
        if(buffer0 == object0) {
            return true;
        }
        if(!(object0 instanceof Buffer)) {
            return false;
        }
        if(buffer0.size() != ((Buffer)object0).size()) {
            return false;
        }
        if(buffer0.size() == 0L) {
            return true;
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        Segment segment1 = ((Buffer)object0).head;
        q.d(segment1);
        int v = segment0.pos;
        int v1 = segment1.pos;
        for(long v2 = 0L; v2 < buffer0.size(); v2 += v3) {
            long v3 = (long)Math.min(segment0.limit - v, segment1.limit - v1);
            long v4 = 0L;
            while(v4 < v3) {
                if(segment0.data[v] != segment1.data[v1]) {
                    return false;
                }
                ++v4;
                ++v;
                ++v1;
            }
            if(v == segment0.limit) {
                segment0 = segment0.next;
                q.d(segment0);
                v = segment0.pos;
            }
            if(v1 == segment1.limit) {
                segment1 = segment1.next;
                q.d(segment1);
                v1 = segment1.pos;
            }
        }
        return true;
    }

    public static final long commonExpandBuffer(@NotNull UnsafeCursor buffer$UnsafeCursor0, int v) {
        q.g(buffer$UnsafeCursor0, "<this>");
        if(v <= 0) {
            throw new IllegalArgumentException(("minByteCount <= 0: " + v).toString());
        }
        if(v > 0x2000) {
            throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + v).toString());
        }
        Buffer buffer0 = buffer$UnsafeCursor0.buffer;
        if(buffer0 == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if(!buffer$UnsafeCursor0.readWrite) {
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
        }
        long v1 = buffer0.size();
        Segment segment0 = buffer0.writableSegment$okio(v);
        int v2 = 0x2000 - segment0.limit;
        segment0.limit = 0x2000;
        buffer0.setSize$okio(v1 + ((long)v2));
        buffer$UnsafeCursor0.setSegment$okio(segment0);
        buffer$UnsafeCursor0.offset = v1;
        buffer$UnsafeCursor0.data = segment0.data;
        buffer$UnsafeCursor0.start = 0x2000 - v2;
        buffer$UnsafeCursor0.end = 0x2000;
        return (long)v2;
    }

    public static final byte commonGet(@NotNull Buffer buffer0, long v) {
        int v3;
        q.g(buffer0, "<this>");
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), v, 1L);
        Segment segment0 = buffer0.head;
        if(segment0 != null) {
            if(buffer0.size() - v < v) {
                long v1;
                for(v1 = buffer0.size(); v1 > v; v1 -= (long)(segment0.limit - segment0.pos)) {
                    segment0 = segment0.prev;
                    q.d(segment0);
                }
                return segment0.data[((int)(((long)segment0.pos) + v - v1))];
            }
            long v2;
            for(v2 = 0L; true; v2 = v4) {
                v3 = segment0.pos;
                long v4 = ((long)(segment0.limit - v3)) + v2;
                if(v4 > v) {
                    break;
                }
                segment0 = segment0.next;
                q.d(segment0);
            }
            return segment0.data[((int)(((long)v3) + v - v2))];
        }
        q.d(null);
        throw null;
    }

    public static final int commonHashCode(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        Segment segment0 = buffer0.head;
        if(segment0 == null) {
            return 0;
        }
        int v = 1;
        do {
            int v1 = segment0.pos;
            int v2 = segment0.limit;
            while(v1 < v2) {
                v = v * 0x1F + segment0.data[v1];
                ++v1;
            }
            segment0 = segment0.next;
            q.d(segment0);
        }
        while(segment0 != buffer0.head);
        return v;
    }

    public static final long commonIndexOf(@NotNull Buffer buffer0, byte b, long v, long v1) {
        int v4;
        q.g(buffer0, "<this>");
        long v2 = 0L;
        if(0L > v || v > v1) {
            throw new IllegalArgumentException(("size=" + buffer0.size() + " fromIndex=" + v + " toIndex=" + v1).toString());
        }
        if(v1 > buffer0.size()) {
            v1 = buffer0.size();
        }
        if(Long.compare(v, v1) == 0) {
            return -1L;
        }
        Segment segment0 = buffer0.head;
        if(segment0 == null) {
            return -1L;
        }
        if(buffer0.size() - v < v) {
            for(v2 = buffer0.size(); v2 > v; v2 -= (long)(segment0.limit - segment0.pos)) {
                segment0 = segment0.prev;
                q.d(segment0);
            }
            while(v2 < v1) {
                byte[] arr_b = segment0.data;
                int v3 = (int)Math.min(segment0.limit, ((long)segment0.pos) + v1 - v2);
                for(v4 = (int)(((long)segment0.pos) + v - v2); v4 < v3; ++v4) {
                    if(arr_b[v4] == b) {
                        return ((long)(v4 - segment0.pos)) + v2;
                    }
                }
                v2 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v = v2;
            }
            return -1L;
        }
        long v5;
        while((v5 = ((long)(segment0.limit - segment0.pos)) + v2) <= v) {
            segment0 = segment0.next;
            q.d(segment0);
            v2 = v5;
        }
        while(v2 < v1) {
            byte[] arr_b1 = segment0.data;
            int v6 = (int)Math.min(segment0.limit, ((long)segment0.pos) + v1 - v2);
            v4 = (int)(((long)segment0.pos) + v - v2);
            while(v4 < v6) {
                if(arr_b1[v4] != b) {
                    ++v4;
                    continue;
                }
                return ((long)(v4 - segment0.pos)) + v2;
            }
            v2 += (long)(segment0.limit - segment0.pos);
            segment0 = segment0.next;
            q.d(segment0);
            v = v2;
        }
        return -1L;
    }

    public static final long commonIndexOf(@NotNull Buffer buffer0, @NotNull ByteString byteString0, long v, long v1, int v2, int v3) {
        int v8;
        long v4 = 0L;
        q.g(buffer0, "<this>");
        q.g(byteString0, "bytes");
        -SegmentedByteString.checkOffsetAndCount(byteString0.size(), v2, v3);
        if(v3 <= 0) {
            throw new IllegalArgumentException("byteCount == 0");
        }
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "fromIndex < 0: ").toString());
        }
        if(v <= v1) {
            if(v1 > buffer0.size()) {
                v1 = buffer0.size();
            }
            if(Long.compare(v, v1) == 0) {
                return -1L;
            }
            Segment segment0 = buffer0.head;
            if(segment0 == null) {
                return -1L;
            }
            if(Long.compare(buffer0.size() - v, v) < 0) {
                for(v4 = buffer0.size(); v4 > v; v4 -= (long)(segment0.limit - segment0.pos)) {
                    segment0 = segment0.prev;
                    q.d(segment0);
                }
                byte[] arr_b = byteString0.internalArray$okio();
                int v5 = arr_b[v2];
                long v6 = Math.min(v1, buffer0.size() - ((long)v3) + 1L);
                while(v4 < v6) {
                    byte[] arr_b1 = segment0.data;
                    int v7 = (int)Math.min(segment0.limit, ((long)segment0.pos) + v6 - v4);
                    for(v8 = (int)(((long)segment0.pos) + v - v4); v8 < v7; ++v8) {
                        if(arr_b1[v8] == v5 && -Buffer.rangeEquals(segment0, v8 + 1, arr_b, v2 + 1, v3)) {
                            return ((long)(v8 - segment0.pos)) + v4;
                        }
                    }
                    v4 += (long)(segment0.limit - segment0.pos);
                    segment0 = segment0.next;
                    q.d(segment0);
                    v = v4;
                }
                return -1L;
            }
            long v9;
            while((v9 = ((long)(segment0.limit - segment0.pos)) + v4) <= v) {
                segment0 = segment0.next;
                q.d(segment0);
                v4 = v9;
            }
            byte[] arr_b2 = byteString0.internalArray$okio();
            int v10 = arr_b2[v2];
            long v11 = Math.min(v1, buffer0.size() - ((long)v3) + 1L);
            while(v4 < v11) {
                byte[] arr_b3 = segment0.data;
                int v12 = (int)Math.min(segment0.limit, ((long)segment0.pos) + v11 - v4);
                v8 = (int)(((long)segment0.pos) + v - v4);
                while(v8 < v12) {
                    if(arr_b3[v8] != v10 || !-Buffer.rangeEquals(segment0, v8 + 1, arr_b2, v2 + 1, v3)) {
                        ++v8;
                        continue;
                    }
                    return ((long)(v8 - segment0.pos)) + v4;
                }
                v4 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v = v4;
            }
            return -1L;
        }
        StringBuilder stringBuilder0 = Y.o(v, "fromIndex > toIndex: ", " > ");
        stringBuilder0.append(v1);
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    public static long commonIndexOf$default(Buffer buffer0, ByteString byteString0, long v, long v1, int v2, int v3, int v4, Object object0) {
        if((v4 & 4) != 0) {
            v1 = 0x7FFFFFFFFFFFFFFFL;
        }
        int v5 = (v4 & 8) == 0 ? v2 : 0;
        return (v4 & 16) == 0 ? -Buffer.commonIndexOf(buffer0, byteString0, v, v1, v5, v3) : -Buffer.commonIndexOf(buffer0, byteString0, v, v1, v5, byteString0.size());
    }

    public static final long commonIndexOfElement(@NotNull Buffer buffer0, @NotNull ByteString byteString0, long v) {
        int v4;
        q.g(buffer0, "<this>");
        q.g(byteString0, "targetBytes");
        long v1 = 0L;
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "fromIndex < 0: ").toString());
        }
        Segment segment0 = buffer0.head;
        if(segment0 == null) {
            return -1L;
        }
        if(Long.compare(buffer0.size() - v, v) < 0) {
            for(v1 = buffer0.size(); v1 > v; v1 -= (long)(segment0.limit - segment0.pos)) {
                segment0 = segment0.prev;
                q.d(segment0);
            }
            if(byteString0.size() == 2) {
                int v2 = byteString0.getByte(0);
                int v3 = byteString0.getByte(1);
                while(v1 < buffer0.size()) {
                    byte[] arr_b = segment0.data;
                    v4 = (int)(((long)segment0.pos) + v - v1);
                    int v5 = segment0.limit;
                    while(v4 < v5) {
                        int v6 = arr_b[v4];
                        if(v6 == v2 || v6 == v3) {
                            return ((long)(v4 - segment0.pos)) + v1;
                        }
                        ++v4;
                    }
                    v1 += (long)(segment0.limit - segment0.pos);
                    segment0 = segment0.next;
                    q.d(segment0);
                    v = v1;
                }
                return -1L;
            }
            byte[] arr_b1 = byteString0.internalArray$okio();
            while(v1 < buffer0.size()) {
                byte[] arr_b2 = segment0.data;
                v4 = (int)(((long)segment0.pos) + v - v1);
                int v7 = segment0.limit;
                while(v4 < v7) {
                    int v8 = arr_b2[v4];
                    for(int v9 = 0; v9 < arr_b1.length; ++v9) {
                        if(v8 == arr_b1[v9]) {
                            return ((long)(v4 - segment0.pos)) + v1;
                        }
                    }
                    ++v4;
                }
                v1 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v = v1;
            }
            return -1L;
        }
        long v10;
        while((v10 = ((long)(segment0.limit - segment0.pos)) + v1) <= v) {
            segment0 = segment0.next;
            q.d(segment0);
            v1 = v10;
        }
        if(byteString0.size() == 2) {
            int v11 = byteString0.getByte(0);
            int v12 = byteString0.getByte(1);
            while(v1 < buffer0.size()) {
                byte[] arr_b3 = segment0.data;
                v4 = (int)(((long)segment0.pos) + v - v1);
                int v13 = segment0.limit;
                while(v4 < v13) {
                    int v14 = arr_b3[v4];
                    if(v14 != v11 && v14 != v12) {
                        ++v4;
                        continue;
                    }
                    return ((long)(v4 - segment0.pos)) + v1;
                }
                v1 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v = v1;
            }
            return -1L;
        }
        byte[] arr_b4 = byteString0.internalArray$okio();
        while(v1 < buffer0.size()) {
            byte[] arr_b5 = segment0.data;
            v4 = (int)(((long)segment0.pos) + v - v1);
            int v15 = segment0.limit;
            while(v4 < v15) {
                int v16 = arr_b5[v4];
                int v17 = 0;
                while(v17 < arr_b4.length) {
                    if(v16 != arr_b4[v17]) {
                        ++v17;
                        continue;
                    }
                    return ((long)(v4 - segment0.pos)) + v1;
                }
                ++v4;
            }
            v1 += (long)(segment0.limit - segment0.pos);
            segment0 = segment0.next;
            q.d(segment0);
            v = v1;
        }
        return -1L;
    }

    public static final int commonNext(@NotNull UnsafeCursor buffer$UnsafeCursor0) {
        q.g(buffer$UnsafeCursor0, "<this>");
        long v = buffer$UnsafeCursor0.offset;
        Buffer buffer0 = buffer$UnsafeCursor0.buffer;
        q.d(buffer0);
        if(v == buffer0.size()) {
            throw new IllegalStateException("no more bytes");
        }
        return buffer$UnsafeCursor0.offset == -1L ? buffer$UnsafeCursor0.seek(0L) : buffer$UnsafeCursor0.seek(buffer$UnsafeCursor0.offset + ((long)(buffer$UnsafeCursor0.end - buffer$UnsafeCursor0.start)));
    }

    public static final boolean commonRangeEquals(@NotNull Buffer buffer0, long v, @NotNull ByteString byteString0, int v1, int v2) {
        q.g(buffer0, "<this>");
        q.g(byteString0, "bytes");
        if(v2 < 0) {
            return false;
        }
        if(v >= 0L && ((long)v2) + v <= buffer0.size() && v1 >= 0 && v1 + v2 <= byteString0.size()) {
            return v2 == 0 ? true : -Buffer.commonIndexOf(buffer0, byteString0, v, v + 1L, v1, v2) != -1L;
        }
        return false;
    }

    public static final int commonRead(@NotNull Buffer buffer0, @NotNull byte[] arr_b) {
        q.g(buffer0, "<this>");
        q.g(arr_b, "sink");
        return buffer0.read(arr_b, 0, arr_b.length);
    }

    public static final int commonRead(@NotNull Buffer buffer0, @NotNull byte[] arr_b, int v, int v1) {
        q.g(buffer0, "<this>");
        q.g(arr_b, "sink");
        -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v1);
        Segment segment0 = buffer0.head;
        if(segment0 == null) {
            return -1;
        }
        int v2 = Math.min(v1, segment0.limit - segment0.pos);
        n.T(segment0.data, v, segment0.pos, arr_b, segment0.pos + v2);
        segment0.pos += v2;
        buffer0.setSize$okio(buffer0.size() - ((long)v2));
        if(segment0.pos == segment0.limit) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
        return v2;
    }

    public static final long commonRead(@NotNull Buffer buffer0, @NotNull Buffer buffer1, long v) {
        q.g(buffer0, "<this>");
        q.g(buffer1, "sink");
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(buffer0.size() == 0L) {
            return -1L;
        }
        if(v > buffer0.size()) {
            v = buffer0.size();
        }
        buffer1.write(buffer0, v);
        return v;
    }

    public static final long commonReadAll(@NotNull Buffer buffer0, @NotNull Sink sink0) {
        q.g(buffer0, "<this>");
        q.g(sink0, "sink");
        long v = buffer0.size();
        if(v > 0L) {
            sink0.write(buffer0, v);
        }
        return v;
    }

    @NotNull
    public static final UnsafeCursor commonReadAndWriteUnsafe(@NotNull Buffer buffer0, @NotNull UnsafeCursor buffer$UnsafeCursor0) {
        q.g(buffer0, "<this>");
        q.g(buffer$UnsafeCursor0, "unsafeCursor");
        UnsafeCursor buffer$UnsafeCursor1 = -SegmentedByteString.resolveDefaultParameter(buffer$UnsafeCursor0);
        if(buffer$UnsafeCursor1.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        buffer$UnsafeCursor1.buffer = buffer0;
        buffer$UnsafeCursor1.readWrite = true;
        return buffer$UnsafeCursor1;
    }

    public static final byte commonReadByte(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        if(buffer0.size() == 0L) {
            throw new EOFException();
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        int v = segment0.limit;
        int v1 = segment0.pos + 1;
        byte b = segment0.data[segment0.pos];
        buffer0.setSize$okio(buffer0.size() - 1L);
        if(v1 == v) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return b;
        }
        segment0.pos = v1;
        return b;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        return buffer0.readByteArray(buffer0.size());
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "<this>");
        if(v < 0L || v > 0x7FFFFFFFL) {
            throw new IllegalArgumentException(e.a(v, "byteCount: ").toString());
        }
        if(buffer0.size() < v) {
            throw new EOFException();
        }
        byte[] arr_b = new byte[((int)v)];
        buffer0.readFully(arr_b);
        return arr_b;
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        return buffer0.readByteString(buffer0.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "<this>");
        if(v < 0L || v > 0x7FFFFFFFL) {
            throw new IllegalArgumentException(e.a(v, "byteCount: ").toString());
        }
        if(buffer0.size() < v) {
            throw new EOFException();
        }
        if(v >= 0x1000L) {
            ByteString byteString0 = buffer0.snapshot(((int)v));
            buffer0.skip(v);
            return byteString0;
        }
        return new ByteString(buffer0.readByteArray(v));
    }

    public static final long commonReadDecimalLong(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        if(buffer0.size() == 0L) {
            throw new EOFException();
        }
        int v = 0;
        boolean z = false;
        long v1 = 0L;
        long v2 = -7L;
        boolean z1 = false;
        do {
            Segment segment0 = buffer0.head;
            q.d(segment0);
            byte[] arr_b = segment0.data;
            int v3 = segment0.pos;
            int v4 = segment0.limit;
            while(v3 < v4) {
                int v5 = arr_b[v3];
                if(v5 >= 0x30 && v5 <= 57) {
                    int v6 = Long.compare(v1, -922337203685477580L);
                    if(v6 >= 0 && (v6 != 0 || ((long)(0x30 - v5)) >= v2)) {
                        v1 = v1 * 10L + ((long)(0x30 - v5));
                        ++v3;
                        ++v;
                        continue;
                    }
                    Buffer buffer1 = new Buffer().writeDecimalLong(v1).writeByte(v5);
                    if(!z) {
                        buffer1.readByte();
                    }
                    throw new NumberFormatException("Number too large: ");
                }
                else if(v5 == 45 && v == 0) {
                    --v2;
                    z = true;
                }
                else {
                    goto label_29;
                }
                ++v3;
                ++v;
                continue;
            label_29:
                z1 = true;
                if(true) {
                    break;
                }
            }
            if(v3 == v4) {
                buffer0.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
            else {
                segment0.pos = v3;
            }
        }
        while(!z1 && buffer0.head != null);
        buffer0.setSize$okio(buffer0.size() - ((long)v));
        if(v < (z ? 2 : 1)) {
            if(buffer0.size() == 0L) {
                throw new EOFException();
            }
            StringBuilder stringBuilder0 = x.p((z ? "Expected a digit" : "Expected a digit or \'-\'"), " but was 0x");
            stringBuilder0.append(-SegmentedByteString.toHexString(buffer0.getByte(0L)));
            throw new NumberFormatException(stringBuilder0.toString());
        }
        return z ? v1 : -v1;
    }

    public static final void commonReadFully(@NotNull Buffer buffer0, @NotNull Buffer buffer1, long v) {
        q.g(buffer0, "<this>");
        q.g(buffer1, "sink");
        if(buffer0.size() >= v) {
            buffer1.write(buffer0, v);
            return;
        }
        buffer1.write(buffer0, buffer0.size());
        throw new EOFException();
    }

    public static final void commonReadFully(@NotNull Buffer buffer0, @NotNull byte[] arr_b) {
        q.g(buffer0, "<this>");
        q.g(arr_b, "sink");
        for(int v = 0; v < arr_b.length; v += v1) {
            int v1 = buffer0.read(arr_b, v, arr_b.length - v);
            if(v1 == -1) {
                throw new EOFException();
            }
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull Buffer buffer0) {
        int v5;
        q.g(buffer0, "<this>");
        if(buffer0.size() == 0L) {
            throw new EOFException();
        }
        int v = 0;
        boolean z = false;
        long v1 = 0L;
        do {
            Segment segment0 = buffer0.head;
            q.d(segment0);
            byte[] arr_b = segment0.data;
            int v2 = segment0.pos;
            int v3 = segment0.limit;
            while(v2 < v3) {
                int v4 = arr_b[v2];
                if(v4 >= 0x30 && v4 <= 57) {
                    v5 = v4 - 0x30;
                }
                else if(v4 >= 97 && v4 <= 102) {
                    v5 = v4 - 87;
                }
                else if(v4 < 65 || v4 > 70) {
                    goto label_26;
                }
                else {
                    v5 = v4 - 55;
                }
                if((0xF000000000000000L & v1) != 0L) {
                    throw new NumberFormatException("Number too large: ");
                }
                v1 = v1 << 4 | ((long)v5);
                ++v2;
                ++v;
                continue;
            label_26:
                if(v == 0) {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + -SegmentedByteString.toHexString(((byte)v4)));
                }
                z = true;
                break;
            }
            if(v2 == v3) {
                buffer0.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
            else {
                segment0.pos = v2;
            }
        }
        while(!z && buffer0.head != null);
        buffer0.setSize$okio(buffer0.size() - ((long)v));
        return v1;
    }

    public static final int commonReadInt(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        if(buffer0.size() < 4L) {
            throw new EOFException();
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        int v = segment0.pos;
        int v1 = segment0.limit;
        if(((long)(v1 - v)) < 4L) {
            int v2 = buffer0.readByte();
            int v3 = buffer0.readByte();
            int v4 = buffer0.readByte();
            return buffer0.readByte() & 0xFF | ((v2 & 0xFF) << 24 | (v3 & 0xFF) << 16 | (v4 & 0xFF) << 8);
        }
        int v5 = segment0.data[v + 3] & 0xFF | ((segment0.data[v + 1] & 0xFF) << 16 | (segment0.data[v] & 0xFF) << 24 | (segment0.data[v + 2] & 0xFF) << 8);
        buffer0.setSize$okio(buffer0.size() - 4L);
        if(v + 4 == v1) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return v5;
        }
        segment0.pos = v + 4;
        return v5;
    }

    public static final long commonReadLong(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        if(buffer0.size() < 8L) {
            throw new EOFException();
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        int v = segment0.pos;
        int v1 = segment0.limit;
        if(Long.compare(v1 - v, 8L) < 0) {
            return (((long)buffer0.readInt()) & 0xFFFFFFFFL) << 0x20 | 0xFFFFFFFFL & ((long)buffer0.readInt());
        }
        long v2 = (((long)segment0.data[v]) & 0xFFL) << 56 | (((long)segment0.data[v + 1]) & 0xFFL) << 0x30 | (((long)segment0.data[v + 2]) & 0xFFL) << 40 | (((long)segment0.data[v + 3]) & 0xFFL) << 0x20 | (((long)segment0.data[v + 4]) & 0xFFL) << 24 | (((long)segment0.data[v + 5]) & 0xFFL) << 16 | (((long)segment0.data[v + 6]) & 0xFFL) << 8 | ((long)segment0.data[v + 7]) & 0xFFL;
        buffer0.setSize$okio(buffer0.size() - 8L);
        if(v + 8 == v1) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return v2;
        }
        segment0.pos = v + 8;
        return v2;
    }

    public static final short commonReadShort(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        if(buffer0.size() < 2L) {
            throw new EOFException();
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        int v = segment0.pos;
        int v1 = segment0.limit;
        if(v1 - v < 2) {
            int v2 = buffer0.readByte();
            return (short)(buffer0.readByte() & 0xFF | (v2 & 0xFF) << 8);
        }
        int v3 = segment0.data[v + 1] & 0xFF | (segment0.data[v] & 0xFF) << 8;
        buffer0.setSize$okio(buffer0.size() - 2L);
        if(v + 2 == v1) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return (short)v3;
        }
        segment0.pos = v + 2;
        return (short)v3;
    }

    @NotNull
    public static final UnsafeCursor commonReadUnsafe(@NotNull Buffer buffer0, @NotNull UnsafeCursor buffer$UnsafeCursor0) {
        q.g(buffer0, "<this>");
        q.g(buffer$UnsafeCursor0, "unsafeCursor");
        UnsafeCursor buffer$UnsafeCursor1 = -SegmentedByteString.resolveDefaultParameter(buffer$UnsafeCursor0);
        if(buffer$UnsafeCursor1.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        buffer$UnsafeCursor1.buffer = buffer0;
        buffer$UnsafeCursor1.readWrite = false;
        return buffer$UnsafeCursor1;
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "<this>");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0 || v > 0x7FFFFFFFL) {
            throw new IllegalArgumentException(e.a(v, "byteCount: ").toString());
        }
        if(buffer0.size() < v) {
            throw new EOFException();
        }
        if(v1 == 0) {
            return "";
        }
        Segment segment0 = buffer0.head;
        q.d(segment0);
        int v2 = segment0.pos;
        if(((long)v2) + v > ((long)segment0.limit)) {
            return _Utf8Kt.commonToUtf8String$default(buffer0.readByteArray(v), 0, 0, 3, null);
        }
        String s = _Utf8Kt.commonToUtf8String(segment0.data, v2, v2 + ((int)v));
        segment0.pos += (int)v;
        buffer0.setSize$okio(buffer0.size() - v);
        if(segment0.pos == segment0.limit) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
        return s;
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer buffer0) {
        int v4;
        int v3;
        int v2;
        q.g(buffer0, "<this>");
        if(buffer0.size() == 0L) {
            throw new EOFException();
        }
        int v = buffer0.getByte(0L);
        int v1 = 1;
        if((v & 0x80) == 0) {
            v2 = v & 0x7F;
            v3 = 0;
            v4 = 1;
            goto label_23;
        }
        if((v & 0xE0) == 0xC0) {
            v2 = v & 0x1F;
            v4 = 2;
            v3 = 0x80;
            goto label_23;
        }
        boolean z = false;
        if((v & 0xF0) == 0xE0) {
            z = true;
            v2 = v & 15;
            v4 = 3;
            v3 = 0x800;
        }
        else if((v & 0xF8) == 0xF0) {
            z = true;
            v2 = v & 7;
            v4 = 4;
            v3 = 0x10000;
        }
        if(z) {
        label_23:
            if(buffer0.size() >= ((long)v4)) {
                while(v1 < v4) {
                    int v5 = buffer0.getByte(((long)v1));
                    if((v5 & 0xC0) == 0x80) {
                        v2 = v2 << 6 | v5 & 0x3F;
                        ++v1;
                        continue;
                    }
                    buffer0.skip(((long)v1));
                    return 0xFFFD;
                }
                buffer0.skip(((long)v4));
                if(v2 > 0x10FFFF) {
                    return 0xFFFD;
                }
                if(0xD800 <= v2 && v2 < 0xE000) {
                    return 0xFFFD;
                }
                return v2 >= v3 ? v2 : 0xFFFD;
            }
            StringBuilder stringBuilder0 = x.n(v4, "size < ", ": ");
            stringBuilder0.append(buffer0.size());
            stringBuilder0.append(" (to read code point prefixed 0x");
            stringBuilder0.append(-SegmentedByteString.toHexString(((byte)v)));
            stringBuilder0.append(')');
            throw new EOFException(stringBuilder0.toString());
        }
        buffer0.skip(1L);
        return 0xFFFD;
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        long v = buffer0.indexOf(10);
        if(v != -1L) {
            return -Buffer.readUtf8Line(buffer0, v);
        }
        return buffer0.size() == 0L ? null : buffer0.readUtf8(buffer0.size());
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer buffer0, long v) {
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        q.g(buffer0, "<this>");
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "limit < 0: ").toString());
        }
        if(Long.compare(v, 0x7FFFFFFFFFFFFFFFL) != 0) {
            v1 = v + 1L;
        }
        long v2 = buffer0.indexOf(10, 0L, v1);
        if(v2 != -1L) {
            return -Buffer.readUtf8Line(buffer0, v2);
        }
        if(v1 < buffer0.size() && buffer0.getByte(v1 - 1L) == 13 && buffer0.getByte(v1) == 10) {
            return -Buffer.readUtf8Line(buffer0, v1);
        }
        Buffer buffer1 = new Buffer();
        buffer0.copyTo(buffer1, 0L, Math.min(0x20L, buffer0.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer0.size(), v) + " content=" + buffer1.readByteString().hex() + '…');
    }

    public static final long commonResizeBuffer(@NotNull UnsafeCursor buffer$UnsafeCursor0, long v) {
        q.g(buffer$UnsafeCursor0, "<this>");
        Buffer buffer0 = buffer$UnsafeCursor0.buffer;
        if(buffer0 == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if(!buffer$UnsafeCursor0.readWrite) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long v1 = buffer0.size();
        if(Long.compare(v, v1) <= 0) {
            if(v < 0L) {
                throw new IllegalArgumentException(e.a(v, "newSize < 0: ").toString());
            }
            long v2 = v1 - v;
            while(v2 > 0L) {
                Segment segment0 = buffer0.head;
                q.d(segment0);
                Segment segment1 = segment0.prev;
                q.d(segment1);
                int v3 = segment1.limit;
                long v4 = (long)(v3 - segment1.pos);
                if(v4 <= v2) {
                    buffer0.head = segment1.pop();
                    SegmentPool.recycle(segment1);
                    v2 -= v4;
                }
                else {
                    segment1.limit = v3 - ((int)v2);
                    if(true) {
                        break;
                    }
                }
            }
            buffer$UnsafeCursor0.setSegment$okio(null);
            buffer$UnsafeCursor0.offset = v;
            buffer$UnsafeCursor0.data = null;
            buffer$UnsafeCursor0.start = -1;
            buffer$UnsafeCursor0.end = -1;
        }
        else {
            long v5 = v - v1;
            boolean z = true;
            while(v5 > 0L) {
                Segment segment2 = buffer0.writableSegment$okio(1);
                int v6 = (int)Math.min(v5, 0x2000 - segment2.limit);
                segment2.limit += v6;
                v5 -= (long)v6;
                if(z) {
                    buffer$UnsafeCursor0.setSegment$okio(segment2);
                    buffer$UnsafeCursor0.offset = v1;
                    buffer$UnsafeCursor0.data = segment2.data;
                    buffer$UnsafeCursor0.start = segment2.limit - v6;
                    buffer$UnsafeCursor0.end = segment2.limit;
                    z = false;
                }
            }
        }
        buffer0.setSize$okio(v);
        return v1;
    }

    public static final int commonSeek(@NotNull UnsafeCursor buffer$UnsafeCursor0, long v) {
        Segment segment2;
        q.g(buffer$UnsafeCursor0, "<this>");
        Buffer buffer0 = buffer$UnsafeCursor0.buffer;
        if(buffer0 == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        int v1 = Long.compare(v, -1L);
        if(v1 >= 0 && v <= buffer0.size()) {
            if(v1 != 0 && v != buffer0.size()) {
                long v2 = buffer0.size();
                Segment segment0 = buffer0.head;
                long v3 = 0L;
                if(buffer$UnsafeCursor0.getSegment$okio() == null) {
                    segment2 = segment0;
                }
                else {
                    long v4 = buffer$UnsafeCursor0.offset;
                    int v5 = buffer$UnsafeCursor0.start;
                    Segment segment1 = buffer$UnsafeCursor0.getSegment$okio();
                    q.d(segment1);
                    long v6 = v4 - ((long)(v5 - segment1.pos));
                    if(v6 > v) {
                        segment2 = segment0;
                        segment0 = buffer$UnsafeCursor0.getSegment$okio();
                        v2 = v6;
                    }
                    else {
                        segment2 = buffer$UnsafeCursor0.getSegment$okio();
                        v3 = v6;
                    }
                }
                if(v2 - v > v - v3) {
                    while(true) {
                        q.d(segment2);
                        int v7 = segment2.limit;
                        int v8 = segment2.pos;
                        if(v < ((long)(v7 - v8)) + v3) {
                            break;
                        }
                        v3 += (long)(v7 - v8);
                        segment2 = segment2.next;
                    }
                }
                else {
                    while(v2 > v) {
                        q.d(segment0);
                        segment0 = segment0.prev;
                        q.d(segment0);
                        v2 -= (long)(segment0.limit - segment0.pos);
                    }
                    v3 = v2;
                    segment2 = segment0;
                }
                if(buffer$UnsafeCursor0.readWrite) {
                    q.d(segment2);
                    if(segment2.shared) {
                        Segment segment3 = segment2.unsharedCopy();
                        if(buffer0.head == segment2) {
                            buffer0.head = segment3;
                        }
                        segment2 = segment2.push(segment3);
                        Segment segment4 = segment2.prev;
                        q.d(segment4);
                        segment4.pop();
                    }
                }
                buffer$UnsafeCursor0.setSegment$okio(segment2);
                buffer$UnsafeCursor0.offset = v;
                q.d(segment2);
                buffer$UnsafeCursor0.data = segment2.data;
                int v9 = segment2.pos + ((int)(v - v3));
                buffer$UnsafeCursor0.start = v9;
                buffer$UnsafeCursor0.end = segment2.limit;
                return segment2.limit - v9;
            }
            buffer$UnsafeCursor0.setSegment$okio(null);
            buffer$UnsafeCursor0.offset = v;
            buffer$UnsafeCursor0.data = null;
            buffer$UnsafeCursor0.start = -1;
            buffer$UnsafeCursor0.end = -1;
            return -1;
        }
        StringBuilder stringBuilder0 = Y.o(v, "offset=", " > size=");
        stringBuilder0.append(buffer0.size());
        throw new ArrayIndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static final int commonSelect(@NotNull Buffer buffer0, @NotNull Options options0) {
        q.g(buffer0, "<this>");
        q.g(options0, "options");
        int v = -Buffer.selectPrefix$default(buffer0, options0, false, 2, null);
        if(v == -1) {
            return -1;
        }
        buffer0.skip(((long)options0.getByteStrings$okio()[v].size()));
        return v;
    }

    public static final void commonSkip(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "<this>");
        while(v > 0L) {
            Segment segment0 = buffer0.head;
            if(segment0 == null) {
                throw new EOFException();
            }
            int v1 = (int)Math.min(v, segment0.limit - segment0.pos);
            buffer0.setSize$okio(buffer0.size() - ((long)v1));
            v -= (long)v1;
            int v2 = segment0.pos + v1;
            segment0.pos = v2;
            if(v2 == segment0.limit) {
                buffer0.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer0) {
        q.g(buffer0, "<this>");
        if(buffer0.size() > 0x7FFFFFFFL) {
            throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer0.size()).toString());
        }
        return buffer0.snapshot(((int)buffer0.size()));
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer0, int v) {
        q.g(buffer0, "<this>");
        if(v == 0) {
            return ByteString.EMPTY;
        }
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
        Segment segment0 = buffer0.head;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v) {
            q.d(segment0);
            int v4 = segment0.limit;
            int v5 = segment0.pos;
            if(v4 == v5) {
                throw new AssertionError("s.limit == s.pos");
            }
            v2 += v4 - v5;
            ++v3;
            segment0 = segment0.next;
        }
        byte[][] arr2_b = new byte[v3][];
        int[] arr_v = new int[v3 * 2];
        Segment segment1 = buffer0.head;
        int v6 = 0;
        while(v1 < v) {
            q.d(segment1);
            arr2_b[v6] = segment1.data;
            v1 += segment1.limit - segment1.pos;
            arr_v[v6] = Math.min(v1, v);
            arr_v[v6 + v3] = segment1.pos;
            segment1.shared = true;
            ++v6;
            segment1 = segment1.next;
        }
        return new SegmentedByteString(arr2_b, arr_v);
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer buffer0, int v) {
        q.g(buffer0, "<this>");
        if(v < 1 || v > 0x2000) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment0 = buffer0.head;
        if(segment0 == null) {
            Segment segment1 = SegmentPool.take();
            buffer0.head = segment1;
            segment1.prev = segment1;
            segment1.next = segment1;
            return segment1;
        }
        q.d(segment0);
        Segment segment2 = segment0.prev;
        q.d(segment2);
        return segment2.limit + v > 0x2000 || !segment2.owner ? segment2.push(SegmentPool.take()) : segment2;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer0, @NotNull ByteString byteString0, int v, int v1) {
        q.g(buffer0, "<this>");
        q.g(byteString0, "byteString");
        byteString0.write$okio(buffer0, v, v1);
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer0, @NotNull Source source0, long v) {
        q.g(buffer0, "<this>");
        q.g(source0, "source");
        while(v > 0L) {
            long v1 = source0.read(buffer0, v);
            if(v1 == -1L) {
                throw new EOFException();
            }
            v -= v1;
        }
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer0, @NotNull byte[] arr_b) {
        q.g(buffer0, "<this>");
        q.g(arr_b, "source");
        return buffer0.write(arr_b, 0, arr_b.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer0, @NotNull byte[] arr_b, int v, int v1) {
        q.g(buffer0, "<this>");
        q.g(arr_b, "source");
        -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v1);
        int v2 = v1 + v;
        while(v < v2) {
            Segment segment0 = buffer0.writableSegment$okio(1);
            int v3 = Math.min(v2 - v, 0x2000 - segment0.limit);
            int v4 = v + v3;
            n.T(arr_b, segment0.limit, v, segment0.data, v4);
            segment0.limit += v3;
            v = v4;
        }
        buffer0.setSize$okio(buffer0.size() + ((long)v1));
        return buffer0;
    }

    public static final void commonWrite(@NotNull Buffer buffer0, @NotNull Buffer buffer1, long v) {
        Segment segment3;
        q.g(buffer0, "<this>");
        q.g(buffer1, "source");
        if(buffer1 == buffer0) {
            throw new IllegalArgumentException("source == this");
        }
        -SegmentedByteString.checkOffsetAndCount(buffer1.size(), 0L, v);
        while(v > 0L) {
            Segment segment0 = buffer1.head;
            q.d(segment0);
            int v1 = segment0.limit;
            Segment segment1 = buffer1.head;
            q.d(segment1);
            if(v < ((long)(v1 - segment1.pos))) {
                Segment segment2 = buffer0.head;
                if(segment2 == null) {
                    segment3 = null;
                }
                else {
                    q.d(segment2);
                    segment3 = segment2.prev;
                }
                if(segment3 != null && segment3.owner && ((long)segment3.limit) + v - ((long)(segment3.shared ? 0 : segment3.pos)) <= 0x2000L) {
                    Segment segment4 = buffer1.head;
                    q.d(segment4);
                    segment4.writeTo(segment3, ((int)v));
                    buffer1.setSize$okio(buffer1.size() - v);
                    buffer0.setSize$okio(buffer0.size() + v);
                    return;
                }
                Segment segment5 = buffer1.head;
                q.d(segment5);
                buffer1.head = segment5.split(((int)v));
            }
            Segment segment6 = buffer1.head;
            q.d(segment6);
            long v2 = (long)(segment6.limit - segment6.pos);
            buffer1.head = segment6.pop();
            Segment segment7 = buffer0.head;
            if(segment7 == null) {
                buffer0.head = segment6;
                segment6.prev = segment6;
                segment6.next = segment6;
            }
            else {
                q.d(segment7);
                Segment segment8 = segment7.prev;
                q.d(segment8);
                segment8.push(segment6).compact();
            }
            buffer1.setSize$okio(buffer1.size() - v2);
            buffer0.setSize$okio(buffer0.size() + v2);
            v -= v2;
        }
    }

    public static Buffer commonWrite$default(Buffer buffer0, ByteString byteString0, int v, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v = 0;
        }
        if((v2 & 4) != 0) {
            v1 = byteString0.size();
        }
        q.g(buffer0, "<this>");
        q.g(byteString0, "byteString");
        byteString0.write$okio(buffer0, v, v1);
        return buffer0;
    }

    public static final long commonWriteAll(@NotNull Buffer buffer0, @NotNull Source source0) {
        q.g(buffer0, "<this>");
        q.g(source0, "source");
        long v = 0L;
        long v1;
        while((v1 = source0.read(buffer0, 0x2000L)) != -1L) {
            v += v1;
        }
        return v;
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer buffer0, int v) {
        q.g(buffer0, "<this>");
        Segment segment0 = buffer0.writableSegment$okio(1);
        int v1 = segment0.limit;
        segment0.limit = v1 + 1;
        segment0.data[v1] = (byte)v;
        buffer0.setSize$okio(buffer0.size() + 1L);
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer buffer0, long v) {
        boolean z;
        q.g(buffer0, "<this>");
        int v1 = Long.compare(v, 0L);
        if(v1 == 0) {
            return buffer0.writeByte(0x30);
        }
        if(v1 < 0) {
            v = -v;
            if(v < 0L) {
                return buffer0.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        else {
            z = false;
        }
        int v2 = -Buffer.countDigitsIn(v);
        if(z) {
            ++v2;
        }
        Segment segment0 = buffer0.writableSegment$okio(v2);
        byte[] arr_b = segment0.data;
        int v3 = segment0.limit + v2;
        while(v != 0L) {
            --v3;
            arr_b[v3] = new byte[]{0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102}[((int)(v % 10L))];
            v /= 10L;
        }
        if(z) {
            arr_b[v3 - 1] = 45;
        }
        segment0.limit += v2;
        buffer0.setSize$okio(buffer0.size() + ((long)v2));
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "<this>");
        if(v == 0L) {
            return buffer0.writeByte(0x30);
        }
        long v1 = v >>> 1 | v;
        long v2 = v1 | v1 >>> 2;
        long v3 = v2 | v2 >>> 4;
        long v4 = v3 | v3 >>> 8;
        long v5 = v4 | v4 >>> 16;
        long v6 = v5 | v5 >>> 0x20;
        long v7 = v6 - (v6 >>> 1 & 0x5555555555555555L);
        long v8 = (v7 >>> 2 & 0x3333333333333333L) + (v7 & 0x3333333333333333L);
        long v9 = (v8 >>> 4) + v8 & 0xF0F0F0F0F0F0F0FL;
        long v10 = v9 + (v9 >>> 8);
        long v11 = v10 + (v10 >>> 16);
        int v12 = (int)(((v11 & 0x3FL) + (v11 >>> 0x20 & 0x3FL) + 3L) / 4L);
        Segment segment0 = buffer0.writableSegment$okio(v12);
        byte[] arr_b = segment0.data;
        int v13 = segment0.limit;
        for(int v14 = v13 + v12 - 1; v14 >= v13; --v14) {
            arr_b[v14] = new byte[]{0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102}[((int)(15L & v))];
            v >>>= 4;
        }
        segment0.limit += v12;
        buffer0.setSize$okio(buffer0.size() + ((long)v12));
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer buffer0, int v) {
        q.g(buffer0, "<this>");
        Segment segment0 = buffer0.writableSegment$okio(4);
        int v1 = segment0.limit;
        segment0.data[v1] = (byte)(v >>> 24 & 0xFF);
        segment0.data[v1 + 1] = (byte)(v >>> 16 & 0xFF);
        segment0.data[v1 + 2] = (byte)(v >>> 8 & 0xFF);
        segment0.data[v1 + 3] = (byte)(v & 0xFF);
        segment0.limit = v1 + 4;
        buffer0.setSize$okio(buffer0.size() + 4L);
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "<this>");
        Segment segment0 = buffer0.writableSegment$okio(8);
        int v1 = segment0.limit;
        segment0.data[v1] = (byte)(((int)(v >>> 56 & 0xFFL)));
        segment0.data[v1 + 1] = (byte)(((int)(v >>> 0x30 & 0xFFL)));
        segment0.data[v1 + 2] = (byte)(((int)(v >>> 40 & 0xFFL)));
        segment0.data[v1 + 3] = (byte)(((int)(v >>> 0x20 & 0xFFL)));
        segment0.data[v1 + 4] = (byte)(((int)(v >>> 24 & 0xFFL)));
        segment0.data[v1 + 5] = (byte)(((int)(v >>> 16 & 0xFFL)));
        segment0.data[v1 + 6] = (byte)(((int)(v >>> 8 & 0xFFL)));
        segment0.data[v1 + 7] = (byte)(((int)(v & 0xFFL)));
        segment0.limit = v1 + 8;
        buffer0.setSize$okio(buffer0.size() + 8L);
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer buffer0, int v) {
        q.g(buffer0, "<this>");
        Segment segment0 = buffer0.writableSegment$okio(2);
        int v1 = segment0.limit;
        segment0.data[v1] = (byte)(v >>> 8 & 0xFF);
        segment0.data[v1 + 1] = (byte)(v & 0xFF);
        segment0.limit = v1 + 2;
        buffer0.setSize$okio(buffer0.size() + 2L);
        return buffer0;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer buffer0, @NotNull String s, int v, int v1) {
        q.g(buffer0, "<this>");
        q.g(s, "string");
        if(v < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + v).toString());
        }
        if(v1 < v) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + v1 + " < " + v).toString());
        }
        if(v1 <= s.length()) {
            while(v < v1) {
                int v2 = s.charAt(v);
                if(v2 < 0x80) {
                    Segment segment0 = buffer0.writableSegment$okio(1);
                    byte[] arr_b = segment0.data;
                    int v3 = segment0.limit - v;
                    int v4 = Math.min(v1, 0x2000 - v3);
                    int v5 = v + 1;
                    arr_b[v + v3] = (byte)v2;
                    while(true) {
                        v = v5;
                        if(v >= v4) {
                            break;
                        }
                        int v6 = s.charAt(v);
                        if(v6 >= 0x80) {
                            break;
                        }
                        v5 = v + 1;
                        arr_b[v + v3] = (byte)v6;
                    }
                    int v7 = v3 + v - segment0.limit;
                    segment0.limit += v7;
                    buffer0.setSize$okio(buffer0.size() + ((long)v7));
                }
                else {
                    if(v2 < 0x800) {
                        Segment segment1 = buffer0.writableSegment$okio(2);
                        int v8 = segment1.limit;
                        segment1.data[v8] = (byte)(v2 >> 6 | 0xC0);
                        segment1.data[v8 + 1] = (byte)(v2 & 0x3F | 0x80);
                        segment1.limit = v8 + 2;
                        buffer0.setSize$okio(buffer0.size() + 2L);
                    }
                    else if(v2 < 0xD800 || v2 > 0xDFFF) {
                        Segment segment3 = buffer0.writableSegment$okio(3);
                        int v12 = segment3.limit;
                        segment3.data[v12] = (byte)(v2 >> 12 | 0xE0);
                        segment3.data[v12 + 1] = (byte)(0x3F & v2 >> 6 | 0x80);
                        segment3.data[v12 + 2] = (byte)(v2 & 0x3F | 0x80);
                        segment3.limit = v12 + 3;
                        buffer0.setSize$okio(buffer0.size() + 3L);
                    }
                    else {
                        int v9 = v + 1 >= v1 ? 0 : s.charAt(v + 1);
                        if(v2 > 0xDBFF || 0xDC00 > v9 || v9 >= 0xE000) {
                            buffer0.writeByte(0x3F);
                            ++v;
                        }
                        else {
                            int v10 = ((v2 & 0x3FF) << 10 | v9 & 0x3FF) + 0x10000;
                            Segment segment2 = buffer0.writableSegment$okio(4);
                            int v11 = segment2.limit;
                            segment2.data[v11] = (byte)(v10 >> 18 | 0xF0);
                            segment2.data[v11 + 1] = (byte)(v10 >> 12 & 0x3F | 0x80);
                            segment2.data[v11 + 2] = (byte)(v10 >> 6 & 0x3F | 0x80);
                            segment2.data[v11 + 3] = (byte)(v10 & 0x3F | 0x80);
                            segment2.limit = v11 + 4;
                            buffer0.setSize$okio(buffer0.size() + 4L);
                            v += 2;
                        }
                        continue;
                    }
                    ++v;
                }
            }
            return buffer0;
        }
        StringBuilder stringBuilder0 = x.n(v1, "endIndex > string.length: ", " > ");
        stringBuilder0.append(s.length());
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer buffer0, int v) {
        q.g(buffer0, "<this>");
        if(v < 0x80) {
            buffer0.writeByte(v);
            return buffer0;
        }
        if(v < 0x800) {
            Segment segment0 = buffer0.writableSegment$okio(2);
            int v1 = segment0.limit;
            segment0.data[v1] = (byte)(v >> 6 | 0xC0);
            segment0.data[v1 + 1] = (byte)(v & 0x3F | 0x80);
            segment0.limit = v1 + 2;
            buffer0.setSize$okio(buffer0.size() + 2L);
            return buffer0;
        }
        if(0xD800 <= v && v < 0xE000) {
            buffer0.writeByte(0x3F);
            return buffer0;
        }
        if(v < 0x10000) {
            Segment segment1 = buffer0.writableSegment$okio(3);
            int v2 = segment1.limit;
            segment1.data[v2] = (byte)(v >> 12 | 0xE0);
            segment1.data[v2 + 1] = (byte)(v >> 6 & 0x3F | 0x80);
            segment1.data[v2 + 2] = (byte)(v & 0x3F | 0x80);
            segment1.limit = v2 + 3;
            buffer0.setSize$okio(buffer0.size() + 3L);
            return buffer0;
        }
        if(v > 0x10FFFF) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + -SegmentedByteString.toHexString(v));
        }
        Segment segment2 = buffer0.writableSegment$okio(4);
        int v3 = segment2.limit;
        segment2.data[v3] = (byte)(v >> 18 | 0xF0);
        segment2.data[v3 + 1] = (byte)(v >> 12 & 0x3F | 0x80);
        segment2.data[v3 + 2] = (byte)(v >> 6 & 0x3F | 0x80);
        segment2.data[v3 + 3] = (byte)(v & 0x3F | 0x80);
        segment2.limit = v3 + 4;
        buffer0.setSize$okio(buffer0.size() + 4L);
        return buffer0;
    }

    private static final int countDigitsIn(long v) {
        int v1 = (0x40 - Long.numberOfLeadingZeros(v)) * 10 >>> 5;
        return v <= -Buffer.DigitCountToLargestValue[v1] ? v1 : v1 + 1;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() [...] // 潜在的解密器

    public static final boolean rangeEquals(@NotNull Segment segment0, int v, @NotNull byte[] arr_b, int v1, int v2) {
        q.g(segment0, "segment");
        q.g(arr_b, "bytes");
        int v3 = segment0.limit;
        byte[] arr_b1 = segment0.data;
        while(v1 < v2) {
            if(v == v3) {
                segment0 = segment0.next;
                q.d(segment0);
                arr_b1 = segment0.data;
                v = segment0.pos;
                v3 = segment0.limit;
            }
            if(arr_b1[v] != arr_b[v1]) {
                return false;
            }
            ++v;
            ++v1;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "<this>");
        if(Long.compare(v, 0L) > 0 && buffer0.getByte(v - 1L) == 13) {
            String s = buffer0.readUtf8(v - 1L);
            buffer0.skip(2L);
            return s;
        }
        String s1 = buffer0.readUtf8(v);
        buffer0.skip(1L);
        return s1;
    }

    public static final Object seek(@NotNull Buffer buffer0, long v, @NotNull we.n n0) {
        q.g(buffer0, "<this>");
        q.g(n0, "lambda");
        Segment segment0 = buffer0.head;
        if(segment0 == null) {
            return n0.invoke(null, -1L);
        }
        if(buffer0.size() - v < v) {
            long v1;
            for(v1 = buffer0.size(); v1 > v; v1 -= (long)(segment0.limit - segment0.pos)) {
                segment0 = segment0.prev;
                q.d(segment0);
            }
            return n0.invoke(segment0, v1);
        }
        long v2 = 0L;
        long v3;
        while((v3 = ((long)(segment0.limit - segment0.pos)) + v2) <= v) {
            segment0 = segment0.next;
            q.d(segment0);
            v2 = v3;
        }
        return n0.invoke(segment0, v2);
    }

    public static final int selectPrefix(@NotNull Buffer buffer0, @NotNull Options options0, boolean z) {
        int v11;
        int v10;
        Segment segment3;
        int v9;
        int v8;
        q.g(buffer0, "<this>");
        q.g(options0, "options");
        Segment segment0 = buffer0.head;
        if(segment0 == null) {
            return z ? -2 : -1;
        }
        byte[] arr_b = segment0.data;
        int v = segment0.pos;
        int v1 = segment0.limit;
        int[] arr_v = options0.getTrie$okio();
        Segment segment1 = segment0;
        int v2 = -1;
        int v3 = 0;
    alab1:
        while(true) {
            int v4 = arr_v[v3];
            int v5 = v3 + 2;
            int v6 = arr_v[v3 + 1];
            if(v6 != -1) {
                v2 = v6;
            }
            if(segment1 == null) {
                break;
            }
            if(v4 < 0) {
                int v7 = v5 - v4;
                while((arr_b[v] & 0xFF) == arr_v[v5]) {
                    boolean z1 = v5 + 1 == v7;
                    if(v + 1 == v1) {
                        q.d(segment1);
                        Segment segment2 = segment1.next;
                        q.d(segment2);
                        v8 = segment2.pos;
                        byte[] arr_b1 = segment2.data;
                        v9 = segment2.limit;
                        if(segment2 == segment0) {
                            if(!z1) {
                                break alab1;
                            }
                            arr_b = arr_b1;
                            segment3 = null;
                        }
                        else {
                            segment3 = segment2;
                            arr_b = arr_b1;
                        }
                    }
                    else {
                        segment3 = segment1;
                        v9 = v1;
                        v8 = v + 1;
                    }
                    if(z1) {
                        v10 = arr_v[v5 + 1];
                        v11 = v8;
                        v1 = v9;
                        segment1 = segment3;
                        goto label_69;
                    }
                    v = v8;
                    v1 = v9;
                    segment1 = segment3;
                    ++v5;
                }
                return v2;
            }
            else {
                v11 = v + 1;
                int v12 = arr_b[v] & 0xFF;
                int v13 = v5 + v4;
                while(true) {
                    if(v5 == v13) {
                        return v2;
                    }
                    if(v12 == arr_v[v5]) {
                        break;
                    }
                    ++v5;
                }
                v10 = arr_v[v5 + v4];
                if(v11 == v1) {
                    segment1 = segment1.next;
                    q.d(segment1);
                    v11 = segment1.pos;
                    arr_b = segment1.data;
                    v1 = segment1.limit;
                    if(segment1 == segment0) {
                        segment1 = null;
                    }
                }
            }
        label_69:
            if(v10 >= 0) {
                return v10;
            }
            v3 = -v10;
            v = v11;
        }
        return z ? -2 : v2;
    }

    public static int selectPrefix$default(Buffer buffer0, Options options0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return -Buffer.selectPrefix(buffer0, options0, z);
    }
}

