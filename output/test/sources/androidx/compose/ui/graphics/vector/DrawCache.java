package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawCache.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#J\f\u0010$\u001a\u00020\u0016*\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\u00020\u0013X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/vector/DrawCache;", "", "()V", "cacheScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "cachedCanvas", "Landroidx/compose/ui/graphics/Canvas;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "mCachedImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMCachedImage$annotations", "getMCachedImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setMCachedImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "scopeDensity", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "drawCachedImage", "", "density", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drawCachedImage-CJJAR-o", "(JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)V", "drawInto", "target", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clear", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DrawCache {
    private Canvas cachedCanvas;
    private ImageBitmap mCachedImage;
    private Density scopeDensity;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private long size = IntSize.INSTANCE.m5383getZeroYbymL2g();
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();

    public static /* synthetic */ void getMCachedImage$annotations() {
    }

    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(ImageBitmap imageBitmap) {
        this.mCachedImage = imageBitmap;
    }

    /* renamed from: drawCachedImage-CJJAR-o, reason: not valid java name */
    public final void m3568drawCachedImageCJJARo(long size, Density density, LayoutDirection layoutDirection, Function1<? super DrawScope, Unit> block) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(block, "block");
        this.scopeDensity = density;
        this.layoutDirection = layoutDirection;
        ImageBitmap targetImage = this.mCachedImage;
        Canvas targetCanvas = this.cachedCanvas;
        if (targetImage == null || targetCanvas == null || IntSize.m5378getWidthimpl(size) > targetImage.getWidth() || IntSize.m5377getHeightimpl(size) > targetImage.getHeight()) {
            targetImage = ImageBitmapKt.m3171ImageBitmapx__hDU$default(IntSize.m5378getWidthimpl(size), IntSize.m5377getHeightimpl(size), 0, false, null, 28, null);
            targetCanvas = CanvasKt.Canvas(targetImage);
            this.mCachedImage = targetImage;
            this.cachedCanvas = targetCanvas;
        }
        this.size = size;
        CanvasDrawScope this_$iv = this.cacheScope;
        long size$iv = IntSizeKt.m5388toSizeozmzZPI(size);
        CanvasDrawScope.DrawParams drawParams = this_$iv.getDrawParams();
        Density prevDensity$iv = drawParams.getDensity();
        LayoutDirection prevLayoutDirection$iv = drawParams.getLayoutDirection();
        Canvas prevCanvas$iv = drawParams.getCanvas();
        long prevSize$iv = drawParams.getSize();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240$iv.setDensity(density);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setLayoutDirection(layoutDirection);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setCanvas(targetCanvas);
        $this$draw_yzxVdVo_u24lambda_u240$iv.m3416setSizeuvyYCjk(size$iv);
        targetCanvas.save();
        CanvasDrawScope $this$drawCachedImage_CJJAR_o_u24lambda_u240 = this_$iv;
        clear($this$drawCachedImage_CJJAR_o_u24lambda_u240);
        block.invoke($this$drawCachedImage_CJJAR_o_u24lambda_u240);
        targetCanvas.restore();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.m3416setSizeuvyYCjk(prevSize$iv);
        targetImage.prepareToDraw();
    }

    public static /* synthetic */ void drawInto$default(DrawCache drawCache, DrawScope drawScope, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            colorFilter = null;
        }
        drawCache.drawInto(drawScope, f, colorFilter);
    }

    public final void drawInto(DrawScope target, float alpha, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(target, "target");
        ImageBitmap targetImage = this.mCachedImage;
        if (!(targetImage != null)) {
            throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
        }
        DrawScope.m3476drawImageAZ2fEMs$default(target, targetImage, 0L, this.size, 0L, 0L, alpha, null, colorFilter, 0, 0, 858, null);
    }

    private final void clear(DrawScope $this$clear) {
        DrawScope.m3487drawRectnJ9OG0$default($this$clear, Color.INSTANCE.m2975getBlack0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.INSTANCE.m2866getClear0nO6VwU(), 62, null);
    }
}
