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
fun BadgeableKt.badge(text: String = "", setup: BadgeKt.() -> Unit = {}) {
    val badge = BadgeKt(text)
    badge.setup()
    this.badgeHolder = badge.holder
    this.badgeStyle = badge.style
}

@DrawerMarker
class BadgeKt(text: String) {

    internal val style = BadgeStyle()
    internal val holder = StringHolder(text)

    /**
     * The text of the badge given by a String.
     *
     * Wraps the withBadge function. Non readable property.
     */
    var text: String
        get() = nonReadable()
        set(value) {
            holder.text = value
        }

    /**
     * The text of the badge given by a String resource.
     *
     * Wraps the withBadge function. Non readable property.
     */
    var textRes: Int
        get() = nonReadable()
        set(value) {
            holder.textRes = value
        }

    /**
     * The background of the badge as a Drawable.
     *
     * Wraps the withBadgeBackground function. Non readable property.
     */
    var backgroundDrawable: Drawable
        get() = nonReadable()
        set(value) {
            style.withBadgeBackground(value)
        }

    /**
     * The color of the badge, given as a Long in argb format.
     *
     * Wraps the withColor function. Non readable property.
     */
    var color: Long
        get() = nonReadable()
        set(value) {
            style.withColor(value.toInt())
        }

    /**
     * The color of the badge, given with a color resource.
     *
     * Wraps the withColor function. Non readable property.
     */
    var colorRes: Int
        get() = nonReadable()
        set(value) {
            style.withColorRes(value)
        }

    /**
     * The color of the badge when it's tapped, given as a Long in argb format.
     *
     * Wraps the withColorPressed function. Non readable property.
     */
    var colorPressed: Long
        get() = nonReadable()
        set(value) {
            style.withColorPressed(value.toInt())
        }

    /**
     * The color of the badge when it's tapped, given with a color resource.
     *
     * Wraps the withColorPressedRes function. Non readable property.
     */
    var colorPressedRes: Int
        get() = nonReadable()
        set(value) {
            style.withColorPressedRes(value)
        }

    /**
     * The corner radius of the badge, in pixels.
     *
     * Wraps the withCorners function. Non readable property.
     */
    var cornersPx: Int
        get() = nonReadable()
        set(value) {
            style.withCorners(value)
        }

    /**
     * The corner radius of the badge, in dps.
     *
     * Wraps the withCornersDp function. Non readable property.
     */
    var cornersDp: Int
        get() = nonReadable()
        set(value) {
            style.withCornersDp(value)
        }

    /**
     * The corner radius of the badge, as a dimension resource.
     *
     * Wraps the withCornersDp function. Non readable property.
     */
    var cornersRes: Int
        get() = nonReadable()
        set(value) {
            style.javaClass.declaredFields.find { it.name == "mCorners" }?.let {
                it.isAccessible = true
                it.set(style, DimenHolder.fromResource(value))
            }
        }

    /**
     * The background of the badge as a GradientDrawable resource.
     *
     * Wraps the withGradientDrawable function. Non readable property.
     */
    var gradientDrawableRes: Int
        get() = nonReadable()
        set(value) {
            style.withGradientDrawable(value)
        }

    /**
     * The minimum width of the badge (more precisely, the badge's text), in pixels.
     *
     * Wraps the withMinWidth function. Non readable property.
     */
    var minWidthPx: Int
        get() = nonReadable()
        set(value) {
            style.withMinWidth(value)
        }

    /**
     * The minimum width of the badge (more precisely, the badge's text), in dps.
     *
     * Wraps the withMinWidth function. Non readable property.
     */
    var minWidthDp: Int
        get() = nonReadable()
        set(value) {
            style.javaClass.declaredFields.find { it.name == "mMinWidth" }?.let {
                it.isAccessible = true
                it.set(style, DimenHolder.fromDp(value))
            }
        }

    /**
     * The minimum width of the badge (more precisely, the badge's text), as a dimension resource.
     *
     * Wraps the withMinWidth function. Non readable property.
     */
    var minWidthRes: Int
        get() = nonReadable()
        set(value) {
            style.javaClass.declaredFields.find { it.name == "mMinWidth" }?.let {
                it.isAccessible = true
                it.set(style, DimenHolder.fromResource(value))
            }
        }

    /**
     * The padding of all sides of the badge, in pixels.
     *
     * Wraps the withPadding function. Non readable property.
     */
    var paddingPx: Int
        get() = nonReadable()
        set(value) {
            style.withPadding(value)
        }

    /**
     * The padding of all sides of the badge, in dps.
     *
     * Wraps the withPadding function. Non readable property.
     */
    var paddingDp: Int
        get() = nonReadable()
        set(value) {
            paddingHorizontalDp = value
            paddingVerticalDp = value
        }

    /**
     * The padding of all sides of the badge, as a dimension resource.
     *
     * Wraps the withPadding function. Non readable property.
     */
    var paddingRes: Int
        get() = nonReadable()
        set(value) {
            paddingHorizontalRes = value
            paddingVerticalRes = value
        }

    /**
     * The padding of the left and right sides of the badge, in dps.
     *
     * Wraps the withPaddingLeftRightDp function. Non readable property.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingHorizontalDp"),
            message = "Use paddingHorizontalDp instead")
    var paddingLeftRightDp: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightDp(value)
        }

    /**
     * The padding of the left and right sides of the badge, in pixels.
     *
     * Wraps the withPaddingLeftRightPx function. Non readable property.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingHorizontalPx"),
            message = "Use paddingHorizontalPx instead")
    var paddingLeftRightPx: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightPx(value)
        }

    /**
     * The horizontal padding of the badge, in dps.
     *
     * Replacement for paddingLeftRightDp.
     *
     * Wraps the withPaddingLeftRightDp function. Non readable property.
     */
    var paddingHorizontalDp: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightDp(value)
        }

    /**
     * The horizontal padding of the badge, in pixels.
     *
     * Replacement for paddingLeftRightPx.
     *
     * Wraps the withPaddingLeftRightPx function. Non readable property.
     */
    var paddingHorizontalPx: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingLeftRightPx(value)
        }

    /**
     * The horizontal padding of the badge, as a dimension resource.
     *
     * Replacement for paddingLeftRightPx.
     *
     * Wraps the withPaddingLeftRightPx function. Non readable property.
     */
    var paddingHorizontalRes: Int
        get() = nonReadable()
        set(value) {
            style.javaClass.declaredFields.find { it.name == "mPaddingLeftRight" }?.let {
                it.isAccessible = true
                it.set(style, DimenHolder.fromResource(value))
            }
        }

    /**
     * The padding of the top and bottom of the badge, in dps.
     *
     * Wraps the withPaddingTopBottomDp function. Non readable property.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingVerticalDp"),
            message = "Use paddingVerticalDp instead")
    var paddingTopBottomDp: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomDp(value)
        }

    /**
     * The padding of the top and bottom of the badge, in pixels.
     *
     * Wraps the withPaddingTopBottomPx function. Non readable property.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("paddingVerticalPx"),
            message = "Use paddingVerticalPx instead")
    var paddingTopBottomPx: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomPx(value)
        }

    /**
     * The vertical padding of the badge, in dps.
     *
     * Replacement for paddingTopBottomDp.
     *
     * Wraps the withPaddingTopBottomDp function. Non readable property.
     */
    var paddingVerticalDp: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomDp(value)
        }

    /**
     * The vertical padding of the badge, in pixels.
     *
     * Replacement for paddingTopBottomPx.
     *
     * Wraps the withPaddingTopBottomPx function. Non readable property.
     */
    var paddingVerticalPx: Int
        get() = nonReadable()
        set(value) {
            style.withPaddingTopBottomPx(value)
        }

    /**
     * The vertical padding of the badge, as a dimension resource.
     *
     * Replacement for paddingTopBottomPx.
     *
     * Wraps the withPaddingTopBottomPx function. Non readable property.
     */
    var paddingVerticalRes: Int
        get() = nonReadable()
        set(value) {
            style.javaClass.declaredFields.find { it.name == "mPaddingTopBottom" }?.let {
                it.isAccessible = true
                it.set(style, DimenHolder.fromResource(value))
            }
        }

    /**
     * The color of the badge's text, given as an argb Long.
     *
     * Wraps the withTextColor function. Non readable property.
     */
    var textColor: Long
        get() = nonReadable()
        set(value) {
            style.withTextColor(value.toInt())
        }

    /**
     * The color of the badge's text, given as a color resource.
     *
     * Wraps the withTextColorRes function. Non readable property.
     */
    var textColorRes: Int
        get() = nonReadable()
        set(value) {
            style.withTextColorRes(value)
        }

}
