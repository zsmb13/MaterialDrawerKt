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
     * Wraps the [BaseDrawerItem.withDisabledIconColor] method. Non readable property.
     */
    var disabledIconColor: Long
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's disabled, as a color resource.
     *
     * Wraps the [BaseDrawerItem.withDisabledIconColorRes] method. Non readable property.
     */
    var disabledIconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColorRes(value)
        }

    /**
     * The color of the drawer item's text when it's disabled, as an argb Long.
     *
     * Wraps the [BaseDrawerItem.withDisabledTextColor] method. Non readable property.
     */
    var disabledTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text when it's disabled, as a color resource.
     *
     * Wraps the [BaseDrawerItem.withDisabledTextColorRes] method. Non readable property.
     */
    var disabledTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColorRes(value)
        }

    /**
     * The icon of the drawer item, as a drawable resource.
     *
     * Convenience for `iconRes`. Wraps the [BaseDrawerItem.withIcon] method. Non readable property.
     */
    var icon: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, as a drawable resource.
     *
     * Wraps the [BaseDrawerItem.withIcon] method. Non readable property.
     */
    var iconRes: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, as a Drawable.
     *
     * Wraps the [BaseDrawerItem.withIcon] method. Non readable property.
     */
    var iconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, as an IIcon.
     *
     * Wraps the [BaseDrawerItem.withIcon] method. Non readable property.
     */
    var iicon: IIcon
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The color of the drawer item's icon when it's enabled, as an argb Long.
     *
     * Wraps the [BaseDrawerItem.withIconColor] method. Non readable property.
     */
    var iconColor: Long
        get() = nonReadable()
        set(value) {
            item.withIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's enabled, as a color resource.
     *
     * Wraps the [BaseDrawerItem.withIconColorRes] method. Non readable property.
     */
    var iconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withIconColorRes(value)
        }

    /**
     * Whether the icon of the drawer item should be tinted with the enabled/disabled/selected color. If set to false,
     * your icon will always be displayed with its default colors.
     *
     * Wraps the [BaseDrawerItem.withIconTintingEnabled] method. Non readable property.
     */
    var iconTintingEnabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withIconTintingEnabled(value)
        }

    /**
     * How far the drawer item should be indented. Default value is 1.
     *
     * Wraps the [BaseDrawerItem.withLevel] method. Non readable property.
     */
    var level: Int
        get() = nonReadable()
        set(value) {
            item.withLevel(value)
        }

    /**
     * The title/name of the drawer item.
     *
     * Wraps the [BaseDrawerItem.withName] method. Non readable property.
     */
    var name: String
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The title/name of the drawer item, as a String resource.
     *
     * Wraps the [BaseDrawerItem.withName] method. Non readable property.
     */
    var nameRes: Int
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The color of the drawer item when it's selected, as an argb Long.
     *
     * Wraps the [BaseDrawerItem.withSelectedColor] method. Non readable property.
     */
    var selectedColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedColor(value.toInt())
        }

    /**
     * The color of the drawer item when it's selected, as a color resource.
     *
     * Wraps the [BaseDrawerItem.withSelectedColorRes] method. Non readable property.
     */
    var selectedColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedColorRes(value)
        }

    /**
     * The icon of the drawer when it's selected, as a drawable resource.
     *
     * Convenience for `selectedIconRes`. Wraps the [BaseDrawerItem.withSelectedIcon] method. Non readable property.
     */
    var selectedIcon: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The icon of the drawer item when it's selected, as a drawable resource.
     *
     * Wraps the [BaseDrawerItem.withSelectedIcon] method. Non readable property.
     */
    var selectedIconRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The icon of the drawer item when it's selected, as a Drawable.
     *
     * Wraps the [BaseDrawerItem.withSelectedIcon] method. Non readable property.
     */
    var selectedIconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The color of the drawer item's icon when it's selected, as an argb Long.
     *
     * Wraps the [BaseDrawerItem.withSelectedIconColor] method. Non readable property.
     */
    var selectedIconColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's selected, as a color resource.
     *
     * Wraps the [BaseDrawerItem.withSelectedIconColorRes] method. Non readable property.
     */
    var selectedIconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColorRes(value)
        }

    /**
     * The color of the drawer item's text when it's selected, as an argb Long.
     *
     * Wraps the [BaseDrawerItem.withSelectedTextColor] method. Non readable property.
     */
    var selectedTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text when it's selected, as a color resource.
     *
     * Wraps the [BaseDrawerItem.withSelectedTextColorRes] method. Non readable property.
     */
    var selectedTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColorRes(value)
        }

    /**
     * The color of the drawer item's text, as an argb Long.
     *
     * Wraps the [BaseDrawerItem.withTextColor] method. Non readable property.
     */
    var textColor: Long
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text, as a color resource.
     *
     * Wraps the [BaseDrawerItem.withTextColorRes] method. Non readable property.
     */
    var textColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the drawer item's text.
     *
     * Wraps the [BaseDrawerItem.withTypeface] method. Non readable property.
     */
    var typeface: Typeface
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
