package com.iloen.melon.utils;

import P4.a;
import Tf.o;
import Tf.v;
import U4.x;
import a1.M;
import a1.c;
import a1.d;
import a1.g;
import android.content.Context;
import android.database.DatabaseUtils;
import android.text.TextUtils;
import android.util.Base64;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.log.LogU;
import e.k;
import e1.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import je.p;
import je.u;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001D\n\u0002\u0010\u001E\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00C7\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001A\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u00022\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u000F\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\t\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u00022\b\u0010\u0011\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u000E\u001A\u00020\t\u00A2\u0006\u0004\b\u0012\u0010\fJ\u0015\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u0013\u00A2\u0006\u0004\b\u000F\u0010\u0015J\u0015\u0010\u0016\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0005J!\u0010\u0019\u001A\u0004\u0018\u00010\u00022\b\u0010\u0017\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001A\u00020\t\u00A2\u0006\u0004\b\u0019\u0010\fJ!\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00022\b\u0010\u001B\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00020\u00132\b\u0010\u001A\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u001F\u0010 J\u0015\u0010\"\u001A\u00020\u00022\u0006\u0010!\u001A\u00020\u0013\u00A2\u0006\u0004\b\"\u0010\u0015J\u0015\u0010#\u001A\u00020\u00022\u0006\u0010!\u001A\u00020\u0013\u00A2\u0006\u0004\b#\u0010\u0015J\u0015\u0010%\u001A\u00020\u00022\u0006\u0010$\u001A\u00020\u0013\u00A2\u0006\u0004\b%\u0010\u0015J\u0015\u0010&\u001A\u00020\u00022\u0006\u0010!\u001A\u00020\u0013\u00A2\u0006\u0004\b&\u0010\u0015J\u0015\u0010\'\u001A\u00020\u00022\u0006\u0010!\u001A\u00020\u0013\u00A2\u0006\u0004\b\'\u0010\u0015J\u0015\u0010)\u001A\u00020\u00022\u0006\u0010(\u001A\u00020\u0002\u00A2\u0006\u0004\b)\u0010\u0005J\'\u0010,\u001A\u0004\u0018\u00010\u00022\u0016\u0010+\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020*\"\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b,\u0010-J-\u00102\u001A\u0004\u0018\u0001012\b\u0010.\u001A\u0004\u0018\u00010\u00022\b\u0010/\u001A\u0004\u0018\u00010\u00022\b\u00100\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b2\u00103J\u0015\u00105\u001A\u00020\u00022\u0006\u00104\u001A\u00020\u0002\u00A2\u0006\u0004\b5\u0010\u0005J\u0015\u00106\u001A\u00020\u00022\u0006\u00104\u001A\u00020\u0002\u00A2\u0006\u0004\b6\u0010\u0005J\u0017\u00107\u001A\u00020\u00022\b\u00104\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b7\u0010\u0005J\u0017\u00108\u001A\u00020\u00022\b\u00104\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b8\u0010\u0005J\'\u0010;\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u00022\u0006\u00109\u001A\u00020\t2\u0006\u0010:\u001A\u00020\t\u00A2\u0006\u0004\b;\u0010<J5\u0010B\u001A\u00020\u00022\b\u0010>\u001A\u0004\u0018\u00010=2\u0014\u0010@\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010?2\u0006\u0010A\u001A\u00020\t\u00A2\u0006\u0004\bB\u0010CJ+\u0010B\u001A\u00020\u00022\b\u0010>\u001A\u0004\u0018\u00010=2\b\u0010D\u001A\u0004\u0018\u00010\u00022\u0006\u0010A\u001A\u00020\tH\u0007\u00A2\u0006\u0004\bB\u0010EJ\u0015\u0010F\u001A\u00020\u00022\u0006\u0010$\u001A\u00020\u0013\u00A2\u0006\u0004\bF\u0010\u0015J\u0015\u0010G\u001A\u00020\u00022\u0006\u0010!\u001A\u00020\u0013\u00A2\u0006\u0004\bG\u0010\u0015J%\u0010N\u001A\u00020K2\u0006\u00104\u001A\u00020\u00022\u0006\u0010I\u001A\u00020H2\u0006\u0010J\u001A\u00020H\u00A2\u0006\u0004\bL\u0010MJ#\u0010Q\u001A\b\u0012\u0004\u0012\u00020\u00020P2\u0006\u00104\u001A\u00020\u00022\u0006\u0010O\u001A\u00020\t\u00A2\u0006\u0004\bQ\u0010RJ7\u0010U\u001A\b\u0012\u0004\u0012\u00020\u00020P2\u0006\u00104\u001A\u00020\u00022\u0006\u00109\u001A\u00020\t2\b\b\u0002\u0010S\u001A\u00020\t2\b\b\u0002\u0010T\u001A\u00020\u001C\u00A2\u0006\u0004\bU\u0010VJ\u0019\u0010X\u001A\u00020\u00022\b\u0010W\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bX\u0010\u0005J)\u0010\\\u001A\u00020\u00022\b\u0010Y\u001A\u0004\u0018\u00010\u00022\u0006\u0010Z\u001A\u00020\u00022\u0006\u0010[\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\\\u0010]J#\u0010\\\u001A\u00020\u00022\b\u0010Y\u001A\u0004\u0018\u00010\u00022\b\u0010Z\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\\\u0010^J\u0019\u0010_\u001A\u00020\t2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b_\u0010`J\u0019\u0010a\u001A\u00020\u00022\b\u0010\r\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\ba\u0010\u0005J\u0017\u0010a\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\tH\u0007\u00A2\u0006\u0004\ba\u0010bJ!\u0010c\u001A\u00020\u00022\b\u0010\r\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u000E\u001A\u00020\tH\u0007\u00A2\u0006\u0004\bc\u0010\fJ\u001F\u0010c\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\tH\u0007\u00A2\u0006\u0004\bc\u0010\u0010J!\u0010d\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u00022\u0006\u0010\n\u001A\u00020\tH\u0007\u00A2\u0006\u0004\bd\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\tH\u0007\u00A2\u0006\u0004\b\u000F\u0010bJ\u0019\u0010e\u001A\u00020\u00022\b\u0010\r\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\be\u0010\u0005J\u0019\u0010f\u001A\u00020\u001C2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bf\u0010gJ\u0019\u0010h\u001A\u00020\u00022\b\u00104\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bh\u0010\u0005J1\u0010l\u001A\u00020\u00022\u0010\u0010i\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010*2\u0006\u0010j\u001A\u00020\u001C2\u0006\u0010k\u001A\u00020\u001CH\u0007\u00A2\u0006\u0004\bl\u0010mJ1\u0010l\u001A\u00020\u00022\u0010\u0010o\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010n2\u0006\u0010j\u001A\u00020\u001C2\u0006\u0010k\u001A\u00020\u001CH\u0007\u00A2\u0006\u0004\bl\u0010pJ!\u0010q\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020P2\b\u00104\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bq\u0010rJ\u001B\u0010s\u001A\u0004\u0018\u00010\u00022\b\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bs\u0010\u0005J\u0017\u0010t\u001A\u00020\u001C2\u0006\u0010\u001A\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\bt\u0010gJ\u0019\u0010u\u001A\u00020\u00022\b\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bu\u0010\u0005J#\u0010w\u001A\u00020\u001C2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00022\b\u0010v\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bw\u0010\u001EJ#\u0010z\u001A\u00020\u001C2\b\u0010x\u001A\u0004\u0018\u00010\u00022\b\u0010y\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\bz\u0010\u001EJ\u0019\u0010{\u001A\u00020\u00132\b\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b{\u0010 J\u0019\u0010}\u001A\u00020|2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b}\u0010~J\u0019\u0010\u007F\u001A\u00020\t2\b\u00104\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u007F\u0010`J5\u0010\u0083\u0001\u001A\u00020\u00022!\u0010\u0082\u0001\u001A\u001C\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0080\u0001j\r\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\u0081\u0001H\u0007\u00A2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001E\u0010\u0086\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u0085\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u0086\u0001\u0010\u0005J\u001B\u0010\u0087\u0001\u001A\u00020\u001C2\b\u00104\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u0087\u0001\u0010gJ0\u0010\u008A\u0001\u001A\u00020\u00022\b\u0010\u001A\u001A\u0004\u0018\u00010\u00022\u0007\u0010\u0088\u0001\u001A\u00020\t2\t\u0010\u0089\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0006\b\u008A\u0001\u0010\u008B\u0001J\u001F\u0010\u008D\u0001\u001A\u0004\u0018\u00010\u00012\t\u0010\u008C\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J \u0010\u0091\u0001\u001A\u0004\u0018\u00010\u00022\n\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u0001H\u0007\u00A2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001B\u0010\u0093\u0001\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0005\b\u0093\u0001\u0010\u0005J4\u0010\u0096\u0001\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020?2\t\u0010\u0094\u0001\u001A\u0004\u0018\u00010\u00022\t\u0010\u0095\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J5\u0010\u0096\u0001\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020?2\n\u0010\u0094\u0001\u001A\u0005\u0018\u00010\u0098\u00012\t\u0010\u0095\u0001\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0006\b\u0096\u0001\u0010\u0099\u0001J!\u0010;\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u00022\u0006\u00109\u001A\u00020\tH\u0007\u00A2\u0006\u0004\b;\u0010\fJ\u001C\u0010\u009B\u0001\u001A\u0004\u0018\u00010\u00022\u0007\u0010\u009A\u0001\u001A\u00020\u0002H\u0007\u00A2\u0006\u0005\b\u009B\u0001\u0010\u0005R\u0017\u0010\u009C\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u009C\u0001\u0010\u009D\u0001R\u0017\u0010\u009E\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u009E\u0001\u0010\u009D\u0001R\u0017\u0010\u009F\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u009F\u0001\u0010\u009D\u0001R\u0017\u0010\u00A0\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A0\u0001\u0010\u009D\u0001R\u0017\u0010\u00A1\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A1\u0001\u0010\u009D\u0001R\u0017\u0010\u00A2\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A2\u0001\u0010\u009D\u0001R\u0017\u0010\u00A3\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A3\u0001\u0010\u009D\u0001R\u0017\u0010\u00A4\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A4\u0001\u0010\u009D\u0001R\u0017\u0010\u00A5\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A5\u0001\u0010\u009D\u0001R\u0017\u0010\u00A6\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A6\u0001\u0010\u009D\u0001R\u0017\u0010\u00A7\u0001\u001A\u00020\u00138\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00A7\u0001\u0010\u00A8\u0001\u00A8\u0006\u00A9\u0001"}, d2 = {"Lcom/iloen/melon/utils/StringUtils;", "", "", "title", "getTitle", "(Ljava/lang/String;)Ljava/lang/String;", "melonId", "getDisplayId", "input", "", "maxCount", "getCountStringWithoutPlus", "(Ljava/lang/String;I)Ljava/lang/String;", "count", "maxNumber", "getFormattedStringNumber", "(II)Ljava/lang/String;", "countStr", "getFormattedStringNumberWithoutPlus", "", "number", "(J)Ljava/lang/String;", "getImageCountString", "inputStr", "maxDPLength", "ellipsize", "str", "v", "", "contains", "(Ljava/lang/String;Ljava/lang/String;)Z", "getInt", "(Ljava/lang/String;)J", "timeMs", "formatPlayerTime", "formatPlayerDurationTime", "timeSec", "formatPlayerTimeForSec", "formatDlnaPlayerDurationTime", "formatPlaylistTime", "date", "convertIssueDateToDday", "", "texts", "findFirstNonEmptyText", "([Ljava/lang/String;)Ljava/lang/String;", "source", "onAfterText", "onBeforeText", "", "getTextInBetween", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;", "text", "fromTextToHtml", "deleteHtmlTagInText", "getBoldText", "getBoldTextWithTag", "maxLength", "cutCount", "getTrimmed", "(Ljava/lang/String;II)Ljava/lang/String;", "Landroid/content/Context;", "context", "", "artistMap", "maxArtistLength", "getArtistFormat", "(Landroid/content/Context;Ljava/util/Map;I)Ljava/lang/String;", "artists", "(Landroid/content/Context;Ljava/lang/String;I)Ljava/lang/String;", "getTimeContentDescriptionForSec", "getTimeContentDescription", "Ly0/s;", "pointColor", "defaultColor", "La1/g;", "getAnnotatedString-WkMS-hQ", "(Ljava/lang/String;JJ)La1/g;", "getAnnotatedString", "lineCount", "", "splitTextIntoBalancedLines", "(Ljava/lang/String;I)Ljava/util/List;", "maxLines", "splitByWords", "splitTextByMaxLengthAndLines", "(Ljava/lang/String;IIZ)Ljava/util/List;", "titleValue", "getTitleForDCF", "memberKey", "nickname", "fbName", "getFriendDisplayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getNumberFromString", "(Ljava/lang/String;)I", "getCountFormattedString", "(I)Ljava/lang/String;", "getCountString", "getCountStringWithoutPlusComma", "getSongCountString", "isEmptyOrZero", "(Ljava/lang/String;)Z", "getNotNullString", "strArray", "sqlEscape", "addBlank", "parseToCsv", "([Ljava/lang/String;ZZ)Ljava/lang/String;", "", "values", "(Ljava/util/Collection;ZZ)Ljava/lang/String;", "tokenizeCsv", "(Ljava/lang/String;)Ljava/util/List;", "trim", "isPhoneNumber", "getOnlyNumberForPhoneNumber", "suffix", "endsWithIgnoreCase", "a", "b", "equals", "getLong", "", "getFloat", "(Ljava/lang/String;)F", "getByteSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayList", "convertToCommaSeparatedText", "(Ljava/util/ArrayList;)Ljava/lang/String;", "phoneNumber", "getNonVisibleCenterPhoneNumber", "hasEmoji", "len", "addStr", "lpad", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;", "src", "fromString", "(Ljava/lang/String;)Ljava/lang/Object;", "Ljava/io/Serializable;", "o", "toString", "(Ljava/io/Serializable;)Ljava/lang/String;", "getEncodeUTF8", "artistIds", "artistNames", "makeArtistMap", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "Lcom/iloen/melon/types/StringIds;", "(Lcom/iloen/melon/types/StringIds;Ljava/lang/String;)Ljava/util/Map;", "path", "replacePathString", "MAX_NUMBER_9_2", "I", "MAX_NUMBER_9_3", "MAX_NUMBER_9_4", "MAX_NUMBER_9_5", "MAX_NUMBER_9_6", "MAX_NUMBER_9_7", "MAX_NUMBER_9_8", "MAX_NUMBER_9_9", "FRIEND_COUNT_LIMIT_1", "FRIEND_COUNT_LIMIT_2", "CONVERT_DATE_TO_DAY", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StringUtils {
    public static final int $stable = 0;
    public static final long CONVERT_DATE_TO_DAY = 86400000L;
    public static final int FRIEND_COUNT_LIMIT_1 = 10000;
    public static final int FRIEND_COUNT_LIMIT_2 = 10000000;
    @NotNull
    public static final StringUtils INSTANCE = null;
    public static final int MAX_NUMBER_9_2 = 99;
    public static final int MAX_NUMBER_9_3 = 999;
    public static final int MAX_NUMBER_9_4 = 0x270F;
    public static final int MAX_NUMBER_9_5 = 0x1869F;
    public static final int MAX_NUMBER_9_6 = 0xF423F;
    public static final int MAX_NUMBER_9_7 = 0x98967F;
    public static final int MAX_NUMBER_9_8 = 0x5F5E0FF;
    public static final int MAX_NUMBER_9_9 = 0x3B9AC9FF;
    public static final StringBuilder a;
    public static final Formatter b;

    static {
        StringUtils.INSTANCE = new StringUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
        StringBuilder stringBuilder0 = new StringBuilder();
        StringUtils.a = stringBuilder0;
        StringUtils.b = new Formatter(stringBuilder0, Locale.getDefault());
        StringUtils.$stable = 8;
    }

    public final boolean contains(@Nullable String s, @Nullable String s1) {
        return s == null || s.length() == 0 || s1 == null || s1.length() == 0 ? false : o.v0(s, s1, false);
    }

    @NotNull
    public final String convertIssueDateToDday(@NotNull String s) {
        q.g(s, "date");
        String s1 = s.substring(0, 4);
        q.f(s1, "substring(...)");
        String s2 = s.substring(4, 6);
        q.f(s2, "substring(...)");
        String s3 = s.substring(6, 8);
        q.f(s3, "substring(...)");
        try {
            Calendar calendar0 = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Integer.parseInt(s1), Integer.parseInt(s2) - 1, Integer.parseInt(s3));
            long v = calendar0.getTimeInMillis();
            return String.valueOf(calendar1.getTimeInMillis() / 86400000L - v / 86400000L + 1L);
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return "";
        }
    }

    @NotNull
    public static final String convertToCommaSeparatedText(@Nullable ArrayList arrayList0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(arrayList0 != null && arrayList0.size() > 0) {
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                stringBuilder0.append(((String)object0));
                stringBuilder0.append(",");
            }
            stringBuilder0.setLength((stringBuilder0.length() <= 0 ? 0 : stringBuilder0.length() - 1));
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public final String deleteHtmlTagInText(@NotNull String s) {
        q.g(s, "text");
        if(!TextUtils.isEmpty(s)) {
            Pattern pattern0 = Pattern.compile("<b>");
            q.f(pattern0, "compile(...)");
            String s1 = pattern0.matcher(s).replaceAll("");
            q.f(s1, "replaceAll(...)");
            Pattern pattern1 = Pattern.compile("</b>");
            q.f(pattern1, "compile(...)");
            String s2 = pattern1.matcher(s1).replaceAll("");
            q.f(s2, "replaceAll(...)");
            Pattern pattern2 = Pattern.compile("<br>");
            q.f(pattern2, "compile(...)");
            String s3 = pattern2.matcher(s2).replaceAll("\\n");
            q.f(s3, "replaceAll(...)");
            return s3;
        }
        return "";
    }

    @Nullable
    public final String ellipsize(@Nullable String s, int v) [...] // 潜在的解密器

    public static final boolean endsWithIgnoreCase(@Nullable String s, @Nullable String s1) {
        if(s != null && s1 != null) {
            if(v.i0(s, s1, false)) {
                return true;
            }
            if(s.length() >= s1.length()) {
                String s2 = Y.j("getDefault(...)", s, "toLowerCase(...)");
                Locale locale0 = Locale.getDefault();
                q.f(locale0, "getDefault(...)");
                String s3 = s1.toLowerCase(locale0);
                q.f(s3, "toLowerCase(...)");
                return v.i0(s2, s3, false);
            }
        }
        return false;
    }

    public static final boolean equals(@Nullable String s, @Nullable String s1) {
        return ClassUtils.equals(s, s1);
    }

    @Nullable
    public final String findFirstNonEmptyText(@NotNull String[] arr_s) {
        q.g(arr_s, "texts");
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(!TextUtils.isEmpty(s)) {
                return s;
            }
        }
        return null;
    }

    @NotNull
    public final String formatDlnaPlayerDurationTime(long v) {
        long v1 = (long)Math.max(v / 1000L, 1.0);
        long v2 = Long.compare(v, a.a) < 0 ? 0L : v1 / 60L % 60L;
        long v3 = v < a.b ? 0L : v1 / 3600L;
        StringUtils.a.setLength(0);
        Formatter formatter0 = StringUtils.b;
        if(Long.compare(v3, 0L) > 0) {
            String s = formatter0.format("%02d:%02d:%02d", v3, v2, ((long)(v1 % 60L))).toString();
            q.d(s);
            return s;
        }
        String s1 = formatter0.format("00:%02d:%02d", v2, ((long)(v1 % 60L))).toString();
        q.d(s1);
        return s1;
    }

    @NotNull
    public final String formatPlayerDurationTime(long v) {
        return this.formatPlayerTime(((long)Math.max(v, 1000.0)));
    }

    @NotNull
    public final String formatPlayerTime(long v) {
        long v1 = v / 1000L % 60L;
        long v2 = Long.compare(v, a.a) < 0 ? 0L : v / 1000L / 60L % 60L;
        long v3 = v < a.b ? 0L : v / 1000L / 3600L;
        StringUtils.a.setLength(0);
        Formatter formatter0 = StringUtils.b;
        if(Long.compare(v3, 0L) > 0) {
            String s = formatter0.format("%d:%02d:%02d", v3, v2, v1).toString();
            q.d(s);
            return s;
        }
        String s1 = formatter0.format("%d:%02d", v2, v1).toString();
        q.d(s1);
        return s1;
    }

    @NotNull
    public final String formatPlayerTimeForSec(long v) {
        long v1 = Long.compare(v, 60L) < 0 ? 0L : v / 60L % 60L;
        long v2 = v < a.c ? 0L : v / 3600L;
        StringUtils.a.setLength(0);
        Formatter formatter0 = StringUtils.b;
        if(Long.compare(v2, 0L) > 0) {
            String s = formatter0.format("%d:%02d:%02d", v2, v1, ((long)(v % 60L))).toString();
            q.d(s);
            return s;
        }
        String s1 = formatter0.format("%02d:%02d", v1, ((long)(v % 60L))).toString();
        q.d(s1);
        return s1;
    }

    @NotNull
    public final String formatPlaylistTime(long v) {
        long v1 = (long)Math.max(v / 1000L, 1.0);
        long v2 = Long.compare(v, a.a) < 0 ? 0L : v1 / 60L % 60L;
        long v3 = v < a.b ? 0L : v1 / 3600L;
        Y.a(MelonAppBase.Companion);
        if(Long.compare(v3, 999L) > 0) {
            q.f("999시간 59+", "getString(...)");
            return "999시간 59+";
        }
        if(v3 > 0L) {
            q.f("%1$d시간 %2$d분", "getString(...)");
            return String.format("%1$d시간 %2$d분", Arrays.copyOf(new Object[]{v3, v2}, 2));
        }
        q.f("%1$d분", "getString(...)");
        return String.format("%1$d분", Arrays.copyOf(new Object[]{v2}, 1));
    }

    @Nullable
    public static final Object fromString(@Nullable String s) {
        try {
            ObjectInputStream objectInputStream0 = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(s, 0)));
            Object object0 = objectInputStream0.readObject();
            objectInputStream0.close();
            return object0;
        }
        catch(StreamCorruptedException streamCorruptedException0) {
            streamCorruptedException0.printStackTrace();
            return null;
        }
        catch(OptionalDataException optionalDataException0) {
            optionalDataException0.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException classNotFoundException0) {
            classNotFoundException0.printStackTrace();
            return null;
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
            return null;
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            illegalArgumentException0.printStackTrace();
            return null;
        }
    }

    @NotNull
    public final String fromTextToHtml(@NotNull String s) {
        q.g(s, "text");
        if(!TextUtils.isEmpty(s)) {
            Pattern pattern0 = Pattern.compile("\\n");
            q.f(pattern0, "compile(...)");
            String s1 = pattern0.matcher(s).replaceAll("<br>");
            q.f(s1, "replaceAll(...)");
            return s1;
        }
        return "";
    }

    @NotNull
    public final g getAnnotatedString-WkMS-hQ(@NotNull String s, long v, long v1) {
        q.g(s, "text");
        List list0 = k.z(s);
        int v3 = 0;
        while(v3 < 4) {
            String s1 = new String[]{"<b>", "<color>", "</b>", "</color>"}[v3];
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                StringUtils.INSTANCE.getClass();
                Iterable iterable0 = o.R0(((String)object0), new String[]{s1}, 0, 6);
                ArrayList arrayList1 = new ArrayList();
                for(Object object1: iterable0) {
                    u.U(arrayList1, k.A(new String[]{((String)object1), s1}));
                }
                Iterable iterable1 = p.g0(1, arrayList1);
                ArrayList arrayList2 = new ArrayList();
                for(Object object2: iterable1) {
                    if(((String)object2).length() != 0) {
                        arrayList2.add(object2);
                    }
                }
                u.U(arrayList0, arrayList2);
            }
            ++v3;
            list0 = arrayList0;
        }
        Stack stack0 = new Stack();
        d d0 = new d();
        boolean z = false;
        int v4 = 0;
        int v5 = 0;
        for(Object object3: list0) {
            String s2 = (String)object3;
            switch(s2) {
                case "</b>": 
                case "</color>": {
                    if(z) {
                        continue;
                    }
                    String s3 = v.p0(s2, "/", "");
                    if(s3.equals("<color>")) {
                        --v4;
                    }
                    if(s3.equals("<b>")) {
                        --v5;
                    }
                    if(stack0.isEmpty() || !q.b(stack0.peek(), s3)) {
                        z = true;
                    }
                    stack0.pop();
                    continue;
                }
                case "<b>": 
                case "<color>": {
                    if(z) {
                        continue;
                    }
                    if(s2.equals("<color>")) {
                        ++v4;
                    }
                    if(s2.equals("<b>")) {
                        ++v5;
                    }
                    break;
                }
                default: {
                    int v6 = d0.g(new M((v4 <= 0 ? v1 : v), 0L, (v5 <= 0 ? y.f : y.i), null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFA));
                    try {
                        d0.d(s2);
                    }
                    finally {
                        d0.f(v6);
                    }
                    continue;
                }
            }
            stack0.push(s2);
        }
        g g0 = d0.h();
        if(stack0.isEmpty() && !z) {
            return g0;
        }
        StringBuilder stringBuilder0 = new StringBuilder(16);
        new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        new ArrayList();
        stringBuilder0.append(g0.b);
        String s4 = stringBuilder0.toString();
        ArrayList arrayList4 = new ArrayList(arrayList3.size());
        int v8 = arrayList3.size();
        for(int v2 = 0; v2 < v8; ++v2) {
            arrayList4.add(((c)arrayList3.get(v2)).a(stringBuilder0.length()));
        }
        return new g(s4, arrayList4);
    }

    @ie.d
    @NotNull
    public final String getArtistFormat(@Nullable Context context0, @Nullable String s, int v) {
        if(context0 != null && s != null && s.length() != 0) {
            List list0 = o.R0(s, new String[]{", "}, 0, 6);
            if(!list0.isEmpty()) {
                if(list0.size() <= v) {
                    return s;
                }
                String s1 = context0.getString(0x7F1307B5, new Object[]{p.q0(p.K0(v, list0), ", ", null, null, null, 62), ((int)(list0.size() - v))});  // string:number_of_except_one_format2 "%1$s 외 %2$d명"
                q.d(s1);
                return s1;
            }
        }
        return "";
    }

    @NotNull
    public final String getArtistFormat(@Nullable Context context0, @Nullable Map map0, int v) {
        if(context0 != null && map0 != null && !map0.isEmpty()) {
            Collection collection0 = map0.values();
            if(!collection0.isEmpty()) {
                if(collection0.size() <= v) {
                    return p.q0(collection0, ", ", null, null, null, 62);
                }
                String s = context0.getString(0x7F1307B5, new Object[]{p.q0(p.K0(v, collection0), ", ", null, null, null, 62), ((int)(collection0.size() - v))});  // string:number_of_except_one_format2 "%1$s 외 %2$d명"
                q.d(s);
                return s;
            }
        }
        return "";
    }

    @NotNull
    public final String getBoldText(@Nullable String s) {
        if(s == null) {
            return "";
        }
        try {
            if(s.length() == 0) {
                return "";
            }
            int v = o.F0(s, "<b>", 0, false, 6);
            int v1 = o.F0(s, "</b>", 0, false, 6);
            if(v != -1 && v1 != -1 && v < v1) {
                String s1 = s.substring(v + 3, v1);
                q.f(s1, "substring(...)");
                return s1;
            }
        }
        catch(Exception unused_ex) {
        }
        return s;
    }

    @NotNull
    public final String getBoldTextWithTag(@Nullable String s) {
        if(s == null) {
            return "";
        }
        try {
            if(s.length() == 0) {
                return "";
            }
            int v = o.F0(s, "<b>", 0, false, 6);
            int v1 = o.F0(s, "</b>", 0, false, 6);
            if(v != -1 && v1 != -1 && v < v1) {
                String s1 = s.substring(v, v1 + 4);
                q.f(s1, "substring(...)");
                return s1;
            }
        }
        catch(Exception unused_ex) {
        }
        return s;
    }

    public static final int getByteSize(@Nullable String s) {
        if(s != null && s.length() != 0) {
            try {
                Charset charset0 = Charset.forName("utf-8");
                q.f(charset0, "forName(...)");
                byte[] arr_b = s.getBytes(charset0);
                q.f(arr_b, "getBytes(...)");
                return arr_b.length;
            }
            catch(UnsupportedEncodingException unused_ex) {
                byte[] arr_b1 = s.getBytes(Tf.a.a);
                q.f(arr_b1, "getBytes(...)");
                return arr_b1.length;
            }
        }
        return 0;
    }

    @NotNull
    public static final String getCountFormattedString(int v) {
        return StringUtils.getCountString(String.valueOf(v), -1);
    }

    @NotNull
    public static final String getCountFormattedString(@Nullable String s) {
        return StringUtils.getCountString(s, -1);
    }

    @NotNull
    public static final String getCountString(int v, int v1) {
        try {
            return StringUtils.INSTANCE.getFormattedStringNumber(v, v1);
        }
        catch(NumberFormatException numberFormatException0) {
            LogU.Companion.e("StringUtils", "getCountString() :" + numberFormatException0);
            return "0";
        }
    }

    @NotNull
    public static final String getCountString(@Nullable String s, int v) {
        if(s != null && s.length() != 0) {
            try {
                int v1 = Integer.parseInt(s);
                return StringUtils.INSTANCE.getFormattedStringNumber(v1, v);
            }
            catch(NumberFormatException numberFormatException0) {
                LogU.Companion.e("StringUtils", "getCountString() :" + numberFormatException0);
                return "0";
            }
        }
        return "";
    }

    @NotNull
    public final String getCountStringWithoutPlus(@Nullable String s, int v) {
        String s1 = StringUtils.getCountString(s, v);
        Pattern pattern0 = Pattern.compile("\\+");
        q.f(pattern0, "compile(...)");
        q.g(s1, "input");
        String s2 = pattern0.matcher(s1).replaceAll("");
        q.f(s2, "replaceAll(...)");
        return s2;
    }

    @NotNull
    public static final String getCountStringWithoutPlusComma(@Nullable String s, int v) {
        String s1 = StringUtils.INSTANCE.getCountStringWithoutPlus(s, v);
        Pattern pattern0 = Pattern.compile(",");
        q.f(pattern0, "compile(...)");
        q.g(s1, "input");
        String s2 = pattern0.matcher(s1).replaceAll("");
        q.f(s2, "replaceAll(...)");
        return s2;
    }

    @NotNull
    public final String getDisplayId(@NotNull String s) {
        q.g(s, "melonId");
        int v = o.E0(s, '@', 0, 6);
        if(v != -1) {
            s = s.substring(0, v);
            q.f(s, "substring(...)");
        }
        return s;
    }

    @NotNull
    public static final String getEncodeUTF8(@Nullable String s) {
        if(TextUtils.isEmpty(s)) {
            return "";
        }
        try {
            String s1 = URLEncoder.encode(s, "utf-8");
            q.f(s1, "encode(...)");
            return s1;
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            unsupportedEncodingException0.printStackTrace();
            return "";
        }
    }

    public static final float getFloat(@Nullable String s) {
        if(s != null && s.length() != 0) {
            try {
                return Float.parseFloat(s);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return 0.0f;
    }

    @NotNull
    public static final String getFormattedStringNumber(int v) {
        try {
            StringBuilder stringBuilder0 = new StringBuilder();
            DecimalFormat decimalFormat0 = new DecimalFormat("#,##0");
            if(v != -1) {
                stringBuilder0.append(decimalFormat0.format(((long)v)));
                String s = stringBuilder0.toString();
                q.f(s, "toString(...)");
                return s;
            }
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            LogU.Companion.e("StringUtils", "getFormattedStringNumber() " + illegalArgumentException0);
        }
        return "0";
    }

    @NotNull
    public final String getFormattedStringNumber(int v, int v1) {
        try {
            StringBuilder stringBuilder0 = new StringBuilder();
            DecimalFormat decimalFormat0 = new DecimalFormat("#,##0");
            if(v1 == -1) {
                stringBuilder0.append(decimalFormat0.format(((long)v)));
            }
            else {
                boolean z = v > v1;
                if(z) {
                    v = v1;
                }
                stringBuilder0.append(decimalFormat0.format(((long)v)));
                if(z) {
                    stringBuilder0.append("+");
                }
            }
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            return s;
        }
        catch(IllegalArgumentException illegalArgumentException0) {
        }
        LogU.Companion.e("StringUtils", "getFormattedStringNumber() " + illegalArgumentException0);
        return "0";
    }

    @NotNull
    public final String getFormattedStringNumber(long v) {
        try {
            StringBuilder stringBuilder0 = new StringBuilder();
            DecimalFormat decimalFormat0 = new DecimalFormat("#,##0");
            if(v != -1L) {
                stringBuilder0.append(decimalFormat0.format(v));
                String s = stringBuilder0.toString();
                q.f(s, "toString(...)");
                return s;
            }
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            LogU.Companion.e("StringUtils", "getFormattedStringNumber() " + illegalArgumentException0);
        }
        return "0";
    }

    @NotNull
    public final String getFormattedStringNumberWithoutPlus(@Nullable String s, int v) {
        if(s != null && s.length() != 0) {
            try {
                int v1 = Integer.parseInt(s);
                StringBuilder stringBuilder0 = new StringBuilder();
                DecimalFormat decimalFormat0 = new DecimalFormat("#,##0");
                if(v != -1) {
                    if(v1 <= v) {
                        v = v1;
                    }
                    stringBuilder0.append(decimalFormat0.format(((long)v)));
                    String s1 = stringBuilder0.toString();
                    q.f(s1, "toString(...)");
                    return s1;
                }
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                LogU.Companion.e("StringUtils", "getFormattedStringNumberWithoutPlus() " + illegalArgumentException0);
            }
            return "0";
        }
        return "";
    }

    @NotNull
    public static final String getFriendDisplayName(@Nullable String s, @Nullable String s1) {
        if(s1 != null && s1.length() != 0) {
            return s1;
        }
        StringUtils stringUtils0 = StringUtils.INSTANCE;
        if(s == null) {
            s = "";
        }
        return stringUtils0.getDisplayId(s);
    }

    @ie.d
    @NotNull
    public static final String getFriendDisplayName(@Nullable String s, @NotNull String s1, @NotNull String s2) {
        q.g(s1, "nickname");
        q.g(s2, "fbName");
        if(TextUtils.isEmpty(s1)) {
            MelonAppBase.Companion.getClass();
            s1 = "닉네임을 변경해주세요";
            q.d("닉네임을 변경해주세요");
        }
        return TextUtils.isEmpty(s2) ? s1 : s1 + " (" + s2 + ")";
    }

    @NotNull
    public final String getImageCountString(@NotNull String s) {
        q.g(s, "count");
        MelonAppBase.Companion.getClass();
        String s1 = StringUtils.getCountFormattedString(s) + "장";
        q.f(s1, "toString(...)");
        return s1;
    }

    public final long getInt(@Nullable String s) {
        if(s != null && s.length() != 0) {
            try {
                return (long)Integer.parseInt(s);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return 0L;
    }

    public static final long getLong(@Nullable String s) {
        if(s != null && s.length() != 0) {
            try {
                return Long.parseLong(s);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return 0L;
    }

    @Nullable
    public static final String getNonVisibleCenterPhoneNumber(@Nullable String s) {
        if(s != null && s.length() >= 8) {
            Pattern pattern0 = Pattern.compile("-");
            q.f(pattern0, "compile(...)");
            String s1 = pattern0.matcher(s).replaceAll("");
            q.f(s1, "replaceAll(...)");
            String s2 = s1.substring(0, 3);
            q.f(s2, "substring(...)");
            String s3 = s1.substring(s1.length() - 4, s1.length());
            q.f(s3, "substring(...)");
            String s4 = s1.substring(s2.length(), s1.length() - s3.length());
            q.f(s4, "substring(...)");
            int v1 = s4.length();
            StringBuilder stringBuilder0 = x.p(s2, "-");
            for(int v = 0; v < v1; ++v) {
                stringBuilder0.append("*");
            }
            return x.m(stringBuilder0, "-", s3);
        }
        return s;
    }

    @NotNull
    public static final String getNotNullString(@Nullable String s) [...] // 潜在的解密器

    public static final int getNumberFromString(@Nullable String s) {
        if(s != null && s.length() != 0) {
            try {
                return Integer.parseInt(s);
            }
            catch(NumberFormatException numberFormatException0) {
                LogU.Companion.w("StringUtils", "getNumberFromString() " + numberFormatException0);
            }
        }
        return 0;
    }

    @NotNull
    public static final String getOnlyNumberForPhoneNumber(@Nullable String s) {
        if(s != null && s.length() != 0) {
            Pattern pattern0 = Pattern.compile("[^0-9]+");
            q.f(pattern0, "compile(...)");
            q.g(s, "input");
            String s1 = pattern0.matcher(s).replaceAll("");
            q.f(s1, "replaceAll(...)");
            return s1;
        }
        return "";
    }

    @NotNull
    public static final String getSongCountString(@Nullable String s) {
        MelonAppBase.Companion.getClass();
        String s1 = StringUtils.getCountFormattedString(s) + "곡";
        q.f(s1, "toString(...)");
        return s1;
    }

    @Nullable
    public final CharSequence getTextInBetween(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(s != null) {
            q.d(s2);
            int v = o.F0(s, s2, 0, false, 6);
            if(v != -1) {
                --v;
                int v1 = -1;
                for(int v2 = 0; v2 < v; v2 = v3 + 1) {
                    q.d(s1);
                    int v3 = o.F0(s, s1, v2, false, 4);
                    if(v3 != -1 && v3 < v) {
                        v1 = v3;
                    }
                }
                return v1 >= v || v1 == -1 ? null : s.subSequence(v1, v);
            }
            return null;
        }
        return null;
    }

    @NotNull
    public final String getTimeContentDescription(long v) {
        Y.a(MelonAppBase.Companion);
        if(v / 1000L == 0L) {
            q.f("0초", "getString(...)");
            return "0초";
        }
        long v1 = v / 1000L % 60L;
        long v2 = v < a.a ? 0L : v / 1000L / 60L % 60L;
        long v3 = v < a.b ? 0L : v / 1000L / 3600L;
        StringBuilder stringBuilder0 = new StringBuilder();
        if(v3 > 0L) {
            stringBuilder0.append(v3);
            stringBuilder0.append("시간");
        }
        if(v2 > 0L) {
            stringBuilder0.append(v2);
            stringBuilder0.append("분");
        }
        if(v1 > 0L) {
            stringBuilder0.append(v1);
            stringBuilder0.append("초");
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public final String getTimeContentDescriptionForSec(long v) {
        long v1 = Long.compare(v, 60L) < 0 ? 0L : v / 60L % 60L;
        long v2 = v < a.c ? 0L : v / 3600L;
        StringBuilder stringBuilder0 = new StringBuilder();
        String s = l1.m("시간", "getString(...)", Y.a(MelonAppBase.Companion), 0x7F130B81, "getString(...)");  // string:talkback_minute "분"
        q.f("초", "getString(...)");
        if(v2 > 0L) {
            stringBuilder0.append(v2);
            stringBuilder0.append("시간");
        }
        if(v1 > 0L) {
            stringBuilder0.append(v1);
            stringBuilder0.append(s);
        }
        if(v % 60L > 0L) {
            stringBuilder0.append(v % 60L);
            stringBuilder0.append("초");
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    @NotNull
    public final String getTitle(@Nullable String s) {
        if(s == null) {
            return "";
        }
        int v = o.K0(s, ".", 0, 6);
        if(v != -1 && s.length() > v) {
            String s1 = s.substring(v);
            q.f(s1, "substring(...)");
            Locale locale0 = Locale.getDefault();
            q.f(locale0, "getDefault(...)");
            String s2 = s1.toLowerCase(locale0);
            q.f(s2, "toLowerCase(...)");
            if(".mp4".equals(s2) || ".wav".equals(s2) || ".avi".equals(s2) || ".mpeg".equals(s2) || ".mpg".equals(s2) || ".mov".equals(s2)) {
                s = s.substring(0, v);
                q.f(s, "substring(...)");
            }
        }
        return s;
    }

    @NotNull
    public static final String getTitleForDCF(@Nullable String s) [...] // 潜在的解密器

    @NotNull
    public static final String getTrimmed(@Nullable String s, int v) {
        return StringUtils.INSTANCE.getTrimmed(s, v, 1);
    }

    @NotNull
    public final String getTrimmed(@Nullable String s, int v, int v1) {
        if(s != null && s.length() != 0) {
            if(s.length() >= v) {
                String s1 = s.substring(0, v - v1);
                q.f(s1, "substring(...)");
                return s1 + "...";
            }
            return s;
        }
        return "";
    }

    public static final boolean hasEmoji(@Nullable String s) {
        if(s != null && s.length() != 0) {
            int v = s.length();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = Character.codePointAt(s, v1);
                if(0x1F000 <= v2 && 0x1F6C5 >= v2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isEmptyOrZero(@Nullable String s) {
        return s == null || s.length() == 0 || "0".equals(s);
    }

    public static final boolean isPhoneNumber(@NotNull String s) {
        q.g(s, "str");
        return s.length() > 0 && Pattern.matches("01[0-9\\-]+", s) && StringUtils.getOnlyNumberForPhoneNumber(s).length() > 9;
    }

    @NotNull
    public static final String lpad(@Nullable String s, int v, @Nullable String s1) {
        if(s == null) {
            s = "";
        }
        int v1 = s.length();
        StringBuilder stringBuilder0 = new StringBuilder(s);
        for(int v2 = 0; v2 < v - v1; ++v2) {
            stringBuilder0.insert(0, s1);
        }
        String s2 = stringBuilder0.toString();
        q.f(s2, "toString(...)");
        return s2;
    }

    // 去混淆评级： 低(40)
    @NotNull
    public static final Map makeArtistMap(@Nullable StringIds stringIds0, @Nullable String s) {
        return StringUtils.makeArtistMap("", s);
    }

    @NotNull
    public static final Map makeArtistMap(@Nullable String s, @Nullable String s1) {
        List list0;
        Map map0 = new LinkedHashMap();
        StringIds stringIds0 = StringIds.e(s);
        if(!stringIds0.isEmpty() && s1 != null && s1.length() != 0) {
            ArrayList arrayList0 = new ArrayList();
            if(o.v0(s1, ",", false)) {
                int v = s1.length();
                int v1 = 0;
                boolean z = false;
                int v2 = 0;
                while(v1 < v) {
                    int v3 = s1.charAt(v1);
                    switch(v3) {
                        case 40: {
                            z = true;
                            break;
                        }
                        case 41: {
                            if(z) {
                                z = false;
                            }
                        label_17:
                            if(v3 == 44 && !z || v1 == v - 1) {
                                if(v2 == 0) {
                                    v2 = 0;
                                }
                                try {
                                    String s2 = s1.substring(v2, (v1 == v - 1 ? v1 + 1 : v1));
                                    q.f(s2, "substring(...)");
                                    int v4 = s2.length() - 1;
                                    int v5 = 0;
                                    boolean z1 = false;
                                    while(v5 <= v4) {
                                        boolean z2 = q.h(s2.charAt((z1 ? v4 : v5)), 0x20) <= 0;
                                        if(z1) {
                                            if(!z2) {
                                                break;
                                            }
                                            --v4;
                                        }
                                        else if(z2) {
                                            ++v5;
                                        }
                                        else {
                                            z1 = true;
                                        }
                                    }
                                    arrayList0.add(s2.subSequence(v5, v4 + 1).toString());
                                }
                                catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                                    LogU.Companion.w("StringUtils", "makeArtistMap() substring:" + indexOutOfBoundsException0);
                                }
                                v2 = v1 + 1;
                                z = false;
                            }
                            break;
                        }
                        default: {
                            goto label_17;
                        }
                    }
                    ++v1;
                }
            }
            else {
                arrayList0.add(s1);
            }
            ((AbstractMap)map0).putAll(stringIds0.d(arrayList0));
            return map0;
        }
        if(s1 != null && s1.length() != 0) {
            if(stringIds0.size() > 1) {
                list0 = StringUtils.tokenizeCsv(s1);
            }
            else {
                ArrayList arrayList1 = new ArrayList();
                arrayList1.add(s1);
                list0 = arrayList1;
            }
            ((AbstractMap)map0).putAll(stringIds0.d(list0));
        }
        return map0;
    }

    @NotNull
    public static final String parseToCsv(@Nullable Collection collection0, boolean z, boolean z1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(collection0 != null && !collection0.isEmpty()) {
            for(Object object0: collection0) {
                String s = (String)object0;
                if(z) {
                    s = DatabaseUtils.sqlEscapeString(s);
                }
                stringBuilder0.append(s);
                stringBuilder0.append(",");
                if(z1) {
                    stringBuilder0.append(" ");
                }
            }
            int v = stringBuilder0.length();
            stringBuilder0.setLength((v <= 0 ? 0 : v - (z1 ? 2 : 1)));
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    @NotNull
    public static final String parseToCsv(@Nullable String[] arr_s, boolean z, boolean z1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(arr_s != null && arr_s.length > 0) {
            c2.Y y0 = q.j(arr_s);
            while(y0.hasNext()) {
                String s = (String)y0.next();
                if(z) {
                    s = DatabaseUtils.sqlEscapeString(s);
                }
                stringBuilder0.append(s);
                stringBuilder0.append(",");
                if(z1) {
                    stringBuilder0.append(" ");
                }
            }
            int v = stringBuilder0.length();
            stringBuilder0.setLength((v <= 0 ? 0 : v - (z1 ? 2 : 1)));
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }

    @Nullable
    public static final String replacePathString(@NotNull String s) {
        q.g(s, "path");
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        Pattern pattern0 = Pattern.compile("\'");
        q.f(pattern0, "compile(...)");
        String s1 = pattern0.matcher(s).replaceAll("\'\'");
        q.f(s1, "replaceAll(...)");
        return s1;
    }

    @NotNull
    public final List splitTextByMaxLengthAndLines(@NotNull String s, int v, int v1, boolean z) {
        q.g(s, "text");
        List list0 = new ArrayList();
        StringBuilder stringBuilder0 = new StringBuilder();
        if(z) {
            for(Object object0: o.R0(s, new String[]{" "}, 0, 6)) {
                String s1 = (String)object0;
                if(stringBuilder0.length() > 0 && Z.d(stringBuilder0.length(), 1, s1) > v && ((ArrayList)list0).size() < v1 - 1) {
                    String s2 = stringBuilder0.toString();
                    q.f(s2, "toString(...)");
                    ((ArrayList)list0).add(s2);
                    stringBuilder0 = new StringBuilder(s1);
                }
                else {
                    if(stringBuilder0.length() > 0) {
                        stringBuilder0.append(" ");
                    }
                    stringBuilder0.append(s1);
                }
            }
        }
        else {
            for(int v2 = 0; v2 < s.length(); ++v2) {
                int v3 = s.charAt(v2);
                if(stringBuilder0.length() < v || ((ArrayList)list0).size() >= v1 - 1) {
                    stringBuilder0.append(((char)v3));
                }
                else {
                    String s3 = stringBuilder0.toString();
                    q.f(s3, "toString(...)");
                    ((ArrayList)list0).add(s3);
                    stringBuilder0 = new StringBuilder(String.valueOf(((char)v3)));
                }
            }
        }
        String s4 = stringBuilder0.toString();
        q.f(s4, "toString(...)");
        ((ArrayList)list0).add(s4);
        return list0;
    }

    public static List splitTextByMaxLengthAndLines$default(StringUtils stringUtils0, String s, int v, int v1, boolean z, int v2, Object object0) {
        if((v2 & 4) != 0) {
            v1 = 0x7FFFFFFF;
        }
        if((v2 & 8) != 0) {
            z = true;
        }
        return stringUtils0.splitTextByMaxLengthAndLines(s, v, v1, z);
    }

    @NotNull
    public final List splitTextIntoBalancedLines(@NotNull String s, int v) {
        q.g(s, "text");
        int v1 = 0;
        List list0 = o.R0(s, new String[]{" "}, 0, 6);
        int v2 = s.length();
        List list1 = new ArrayList();
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: list0) {
            String s1 = (String)object0;
            if(Z.d(v1, 1, s1) > v2 / v && ((ArrayList)list1).size() < v - 1) {
                String s2 = stringBuilder0.toString();
                q.f(s2, "toString(...)");
                ((ArrayList)list1).add(s2);
                stringBuilder0 = new StringBuilder(s1);
                v1 = s1.length();
            }
            else {
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.append(" ");
                    ++v1;
                }
                stringBuilder0.append(s1);
                v1 += s1.length();
            }
        }
        String s3 = stringBuilder0.toString();
        q.f(s3, "toString(...)");
        ((ArrayList)list1).add(s3);
        return list1;
    }

    @Nullable
    public static final String toString(@Nullable Serializable serializable0) {
        try {
            ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
            objectOutputStream0.writeObject(serializable0);
            objectOutputStream0.close();
            return new String(Base64.encodeToString(byteArrayOutputStream0.toByteArray(), 0));
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
            return null;
        }
    }

    @NotNull
    public static final List tokenizeCsv(@Nullable String s) {
        if(s != null && s.length() != 0) {
            List list0 = new ArrayList();
            if(!o.v0(s, ",", false)) {
                ((ArrayList)list0).add(StringUtils.trim(s));
                return list0;
            }
            StringTokenizer stringTokenizer0 = new StringTokenizer(s, ",");
            while(stringTokenizer0.hasMoreElements()) {
                ((ArrayList)list0).add(StringUtils.trim(stringTokenizer0.nextToken()));
            }
            return list0;
        }
        return w.a;
    }

    @Nullable
    public static final String trim(@Nullable String s) {
        if(s != null) {
            int v = s.length() - 1;
            int v1 = 0;
            boolean z = false;
            while(v1 <= v) {
                boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
                if(z) {
                    if(!z1) {
                        break;
                    }
                    --v;
                }
                else if(z1) {
                    ++v1;
                }
                else {
                    z = true;
                }
            }
            return s.subSequence(v1, v + 1).toString();
        }
        return null;
    }
}

