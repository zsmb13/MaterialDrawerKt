package co.zsmb.materialdrawerkt.draweritems

import android.graphics.drawable.Drawable
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.draweritems.badgeable.BadgeableKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.DimenHolder
import com.mikepenz.materialdrawer.holder.StringHolder

/**
 * Adds a badge with the given [text].
 */
@Suppress("DEPRECATION")
fun BadgeableKt.badge(text: String = "", setup: BadgeKt.() -> Unit = {}) {
    val badge = BadgeKt(text)
    badge.setup()
    this.badgeHolder = badge.holder
    this.badgeStyle = badge.style
}

@DrawerMarker
class BadgeKt(text: String) {

    /* Builder basics */

    internal val style = BadgeStyle()
    internal var holder = StringHolder(text)

    /* BadgeStyle methods */

    /**
     * The background of the badge as a Drawable.
     *
     * Non readable property. Wraps the [BadgeStyle.withBadgeBackground] method.
     */
    var backgroundDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withBadgeBackground(value)
        }

    /**
     * The color of the badge, as an argb Long.
     *
     * Non readable property. Wraps the [BadgeStyle.withColor] method.
     */
    var color: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withColor(value.toInt())
        }

    /**
     * The color of the badge when it's tapped, as an argb Long.
     *
     * Non readable property. Wraps the [BadgeStyle.withColorPressed] method.
     */
    var colorPressed: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withColorPressed(value.toInt())
        }

    /**
     * The color of the badge when it's tapped, as a a color resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withColorPressedRes] method.
     */
    var colorPressedRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withColorPressedRes(value)
        }

    /**
     * The color of the badge, as a color resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withColor] method.
     */
    var colorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withColorRes(value)
        }

    /**
     * The corner radius of the badge, in dps.
     *
     * Non readable property. Wraps the [BadgeStyle.withCornersDp] method.
     */
    var cornersDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withCornersDp(value)
        }

    /**
     * The corner radius of the badge, in pixels.
     *
     * Non readable property. Wraps the [BadgeStyle.withCorners] method.
     */
    var cornersPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withCorners(value)
        }

    /**
     * The corner radius of the badge, as a dimension resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withCorners] method.
     */
    var cornersRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withCorners(DimenHolder.fromResource(value))
        }

    /**
     * The background of the badge as a GradientDrawable resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withGradientDrawable] method.
     */
    var gradientDrawableRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withGradientDrawable(value)
        }

    /**
     * The minimum width of the badge (more precisely, the badge's text), in dps.
     *
     * Non readable property. Wraps the [BadgeStyle.withMinWidth] method.
     */
    var minWidthDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withMinWidth(DimenHolder.fromDp(value))
        }

    /**
     * The minimum width of the badge (more precisely, the badge's text), in pixels.
     *
     * Non readable property. Wraps the [BadgeStyle.withMinWidth] method.
     */
    var minWidthPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withMinWidth(value)
        }

    /**
     * The minimum width of the badge (more precisely, the badge's text), as a dimension resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withMinWidth] method.
     */
    var minWidthRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withMinWidth(DimenHolder.fromResource(value))
        }

    /**
     * The padding of all sides of the badge, in dps.
     *
     * Non readable property. Wraps the [BadgeStyle.withPadding] method.
     */
    var paddingDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            paddingHorizontalDp = value
            paddingVerticalDp = value
        }

    /**
     * The horizontal padding of the badge, in dps.
     *
     * Replacement for paddingLeftRightDp.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingLeftRightDp] method.
     */
    var paddingHorizontalDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightDp(value)
        }

    /**
     * The horizontal padding of the badge, in pixels.
     *
     * Replacement for paddingLeftRightPx.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingLeftRightPx] method.
     */
    var paddingHorizontalPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightPx(value)
        }

    /**
     * The horizontal padding of the badge, as a dimension resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingLeftRightRes] method.
     */
    var paddingHorizontalRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightRes(value)
        }

    /**
     * The padding of the left and right sides of the badge, in dps.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingLeftRightDp] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingHorizontalDp"),
            message = "Use paddingHorizontalDp instead")
    var paddingLeftRightDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightDp(value)
        }

    /**
     * The padding of the left and right sides of the badge, in pixels.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingLeftRightPx] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingHorizontalPx"),
            message = "Use paddingHorizontalPx instead")
    var paddingLeftRightPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightPx(value)
        }

    /**
     * The padding of all sides of the badge, in pixels.
     *
     * Non readable property. Wraps the [BadgeStyle.withPadding] method.
     */
    var paddingPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPadding(value)
        }

    /**
     * The padding of all sides of the badge, as a dimension resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withPadding] method.
     */
    var paddingRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            paddingHorizontalRes = value
            paddingVerticalRes = value
        }

    /**
     * The padding of the top and bottom of the badge, in dps.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingTopBottomDp] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingVerticalDp"),
            message = "Use paddingVerticalDp instead")
    var paddingTopBottomDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomDp(value)
        }

    /**
     * The padding of the top and bottom of the badge, in pixels.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingTopBottomPx] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingVerticalPx"),
            message = "Use paddingVerticalPx instead")
    var paddingTopBottomPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomPx(value)
        }

    /**
     * The vertical padding of the badge, in dps.
     *
     * Replacement for paddingTopBottomDp.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingTopBottomDp] method.
     */
    var paddingVerticalDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomDp(value)
        }

    /**
     * The vertical padding of the badge, in pixels.
     *
     * Replacement for paddingTopBottomPx.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingTopBottomPx] method.
     */
    var paddingVerticalPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomPx(value)
        }

    /**
     * The vertical padding of the badge, as a dimension resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withPaddingTopBottomRes] method.
     */
    var paddingVerticalRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomRes(value)
        }

    /**
     * The text of the badge as a String.
     *
     * Non readable property. Wraps the [com.mikepenz.materialdrawer.model.interfaces.Badgeable.withBadge] method.
     */
    var text: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            holder = StringHolder(value)
        }

    /**
     * The color of the badge's text, as an argb Long.
     *
     * Non readable property. Wraps the [BadgeStyle.withTextColor] method.
     */
    var textColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withTextColor(value.toInt())
        }

    /**
     * The color of the badge's text, as a color resource.
     *
     * Non readable property. Wraps the [BadgeStyle.withTextColorRes] method.
     */
    var textColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            style.withTextColorRes(value)
        }

    /**
     * The text of the badge as a String resource.
     *
     * Non readable property. Wraps the [com.mikepenz.materialdrawer.model.interfaces.Badgeable.withBadge] method.
     */
    var textRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            holder.textRes = value
        }

}
