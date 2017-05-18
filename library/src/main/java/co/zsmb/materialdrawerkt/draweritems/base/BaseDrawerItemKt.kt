package co.zsmb.materialdrawerkt.draweritems.base

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.model.BaseDrawerItem

abstract class BaseDrawerItemKt : AbstractDrawerItemKt() {

    /* Builder basics */

    private lateinit var item: BaseDrawerItem<*, *>

    protected fun setItem(item: BaseDrawerItem<*, *>) {
        super.setItem(item)
        this.item = item
    }

    /* BaseDrawerItem methods */

    /**
     * The color of the drawer item's icon when it's disabled, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withDisabledIconColor] method.
     */
    var disabledIconColor: Long
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
    var disabledIconColorRes: Int
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
    var disabledTextColor: Long
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
    var disabledTextColorRes: Int
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
    var icon: Int
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
    var iconColor: Long
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
    var iconColorRes: Int
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
    var iconDrawable: Drawable
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
    var iconRes: Int
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
    var iconTintingEnabled: Boolean
        get() = item.isIconTinted
        set(value) {
            item.withIconTintingEnabled(value)
        }

    /**
     * The icon of the drawer item, as an IIcon.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withIcon] method.
     */
    var iicon: IIcon
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
    var level: Int
        get() = item.level
        set(value) {
            item.withLevel(value)
        }

    /**
     * The title/name of the drawer item.
     *
     * Non readable property. Wraps the [BaseDrawerItem.withName] method.
     */
    var name: String
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
    var nameRes: Int
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
    var selectedColor: Long
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
    var selectedColorRes: Int
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
    var selectedIcon: Int
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
    var selectedIconColor: Long
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
    var selectedIconColorRes: Int
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
    var selectedIconDrawable: Drawable
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
    var selectedIconRes: Int
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
    var selectedTextColor: Long
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
    var selectedTextColorRes: Int
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
    var textColor: Long
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
    var textColorRes: Int
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
    var typeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
