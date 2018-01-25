@file:Suppress("RedundantVisibilityModifier")

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
public fun BadgeableKt.badge(text: String = "", setup: BadgeKt.() -> Unit = {}) {
    val badge = BadgeKt(text)
    badge.setup()
    this.badgeHolder = badge.holder
    this.badgeStyle = badge.style
}

@DrawerMarker
public class BadgeKt(text: String) {

    //region Builder basics

    internal val style = BadgeStyle()
    internal var holder = StringHolder(text)

    //endregion

    //region BadgeStyle methods

    /**
     * The background of the badge as a Drawable.
     *
     * Non readable property. Wraps the [BadgeStyle.withBadgeBackground] method.
     */
    public var backgroundDrawable: Drawable
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
    public var color: Long
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
    public var colorPressed: Long
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
    public var colorPressedRes: Int
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
    public var colorRes: Int
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
    public var cornersDp: Int
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
    public var cornersPx: Int
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
    public var cornersRes: Int
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
    public var gradientDrawableRes: Int
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
    public var minWidthDp: Int
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
    public var minWidthPx: Int
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
    public var minWidthRes: Int
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
    public var paddingDp: Int
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
    public var paddingHorizontalDp: Int
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
    public var paddingHorizontalPx: Int
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
    public var paddingHorizontalRes: Int
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
    public var paddingLeftRightDp: Int
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
    public var paddingLeftRightPx: Int
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
    public var paddingPx: Int
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
    public var paddingRes: Int
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
    public var paddingTopBottomDp: Int
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
    public var paddingTopBottomPx: Int
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
    public var paddingVerticalDp: Int
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
    public var paddingVerticalPx: Int
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
    public var paddingVerticalRes: Int
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
    public var text: String
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
    public var textColor: Long
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
    public var textColorRes: Int
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
    public var textRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            holder.textRes = value
        }

    //endregion

}
