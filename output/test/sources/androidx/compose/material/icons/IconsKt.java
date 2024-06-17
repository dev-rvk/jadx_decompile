package androidx.compose.material.icons;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Icons.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\u001aT\u0010\f\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\t¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"MaterialIconDimension", "", "getMaterialIconDimension$annotations", "()V", "materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", HintConstants.AUTOFILL_HINT_NAME, "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "materialPath", "fillAlpha", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }

    public static final ImageVector materialIcon(String name, Function1<? super ImageVector.Builder, ImageVector.Builder> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        return block.invoke(new ImageVector.Builder(name, Dp.m5218constructorimpl(24.0f), Dp.m5218constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null)).build();
    }

    /* renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1263materialPathYwgOQQI$default(ImageVector.Builder materialPath, float fillAlpha, float strokeAlpha, int pathFillType, Function1 pathBuilder, int i, Object obj) {
        ImageVector.Builder m3574addPathoIyEayM;
        float fillAlpha2 = (i & 1) != 0 ? 1.0f : fillAlpha;
        float strokeAlpha2 = (i & 2) != 0 ? 1.0f : strokeAlpha;
        int pathFillType2 = (i & 4) != 0 ? VectorKt.getDefaultFillType() : pathFillType;
        Intrinsics.checkNotNullParameter(materialPath, "$this$materialPath");
        Intrinsics.checkNotNullParameter(pathBuilder, "pathBuilder");
        Brush fill$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv = new PathBuilder();
        pathBuilder.invoke($this$PathData_u24lambda_u240$iv$iv);
        m3574addPathoIyEayM = materialPath.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv, (r30 & 16) != 0 ? 1.0f : fillAlpha2, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : strokeAlpha2, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        return m3574addPathoIyEayM;
    }

    /* renamed from: materialPath-YwgOQQI, reason: not valid java name */
    public static final ImageVector.Builder m1262materialPathYwgOQQI(ImageVector.Builder materialPath, float fillAlpha, float strokeAlpha, int pathFillType, Function1<? super PathBuilder, Unit> pathBuilder) {
        ImageVector.Builder m3574addPathoIyEayM;
        Intrinsics.checkNotNullParameter(materialPath, "$this$materialPath");
        Intrinsics.checkNotNullParameter(pathBuilder, "pathBuilder");
        Brush fill$iv = new SolidColor(Color.INSTANCE.m2975getBlack0d7_KjU(), null);
        int strokeLineCap$iv = StrokeCap.INSTANCE.m3295getButtKaPHkGw();
        int strokeLineJoin$iv = StrokeJoin.INSTANCE.m3305getBevelLxFBmk8();
        PathBuilder $this$PathData_u24lambda_u240$iv$iv = new PathBuilder();
        pathBuilder.invoke($this$PathData_u24lambda_u240$iv$iv);
        m3574addPathoIyEayM = materialPath.m3574addPathoIyEayM($this$PathData_u24lambda_u240$iv$iv.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : pathFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : fill$iv, (r30 & 16) != 0 ? 1.0f : fillAlpha, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : strokeAlpha, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : strokeLineCap$iv, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : strokeLineJoin$iv, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & 4096) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        return m3574addPathoIyEayM;
    }
}
