@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.base

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.model.BaseDrawerItem

public abstract class BaseDrawerItemKt<out T : BaseDrawerItem<*, *>>(item: T) : AbstractDrawerItemKt<T>(item) {

    /**
     * The color of the drawer item's icon when it's disabled, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withDisabledIconColor] method.
     */
    public var disabledIconColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's disabled, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withDisabledIconColorRes] method.
     */
    public var disabledIconColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColorRes(value)
        }

    /**
     * The color of the drawer item's text when it's disabled, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withDisabledTextColor] method.
     */
    public var disabledTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text when it's disabled, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withDisabledTextColorRes] method.
     */
    public var disabledTextColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColorRes(value)
        }

    /**
     * The icon of the drawer item, as a drawable resource.
     *
     * Non readable property. Convenience for [iconRes]. Wraps the [BaseDrawerItem.withIcon] method.
     */
    public var icon: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The color of the drawer item's icon when it's enabled, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withIconColor] method.
     */
    public var iconColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's enabled, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withIconColorRes] method.
     */
    public var iconColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIconColorRes(value)
        }

    /**
     * The icon of the drawer item, as a Drawable.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withIcon] method.
     */
    public var iconDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, as a drawable resource.
     *
     * See [icon] as an alternative.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withIcon] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    public var iconRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * Whether the icon of the drawer item should be tinted with the enabled/disabled/selected color. If set to false,
     * your icon will always be displayed with its default colors.
     *
     * Wraps the [BaseDrawerItem.withIconTintingEnabled] and [BaseDrawerItem.isIconTinted] methods.
     */
    public var iconTintingEnabled: Boolean
        get() = item.isIconTinted
        set(value) {
            item.withIconTintingEnabled(value)
        }

    /**
     * The icon of the drawer item, as an IIcon.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withIcon] method.
     */
    public var iicon: IIcon
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * How far the drawer item should be indented. Default value is 1.
     *
     * Wraps the [BaseDrawerItem.withLevel] and [BaseDrawerItem.getLevel] methods.
     */
    public var level: Int
        get() = item.level
        set(value) {
            item.withLevel(value)
        }

    /**
     * The title/name of the drawer item.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withName] method.
     */
    public var name: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The title/name of the drawer item, as a String resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withName] method.
     */
    public var nameRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The color of the drawer item when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedColor] method.
     */
    public var selectedColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedColor(value.toInt())
        }

    /**
     * The color of the drawer item when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedColorRes] method.
     */
    public var selectedColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedColorRes(value)
        }

    /**
     * The icon of the drawer when it's selected, as a drawable resource.
     *
     * Non readable property. Convenience for [selectedIconRes]. Wraps the [BaseDrawerItem.withSelectedIcon] method.
     */
    public var selectedIcon: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The color of the drawer item's icon when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedIconColor] method.
     */
    public var selectedIconColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedIconColorRes] method.
     */
    public var selectedIconColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColorRes(value)
        }

    /**
     * The icon of the drawer item when it's selected, as a Drawable.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedIcon] method.
     */
    public var selectedIconDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The icon of the drawer item when it's selected, as a drawable resource.
     *
     * See [selectedIcon] as an alternative.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedIcon] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    public var selectedIconRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The color of the drawer item's text when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedTextColor] method.
     */
    public var selectedTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withSelectedTextColorRes] method.
     */
    public var selectedTextColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColorRes(value)
        }

    /**
     * The color of the drawer item's text, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withTextColor] method.
     */
    public var textColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withTextColorRes] method.
     */
    public var textColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the drawer item's text.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withTypeface] method.
     */
    public var typeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
