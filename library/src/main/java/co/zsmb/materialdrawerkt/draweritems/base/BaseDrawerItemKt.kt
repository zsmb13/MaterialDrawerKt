package co.zsmb.materialdrawerkt.draweritems.base

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.holder.ImageHolder
import com.mikepenz.materialdrawer.model.BaseDrawerItem

abstract class BaseDrawerItemKt : AbstractDrawerItemKt() {

    private lateinit var item: BaseDrawerItem<*, *>

    protected fun setItem(item: BaseDrawerItem<*, *>) {
        super.setItem(item)
        this.item = item
    }

    /**
     * The color of the drawer item's icon when it's disabled, given as an argb Long.
     *
     * Wraps the withDisabledIconColor function. Non readable property.
     */
    var disabledIconColor: Long
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's disabled, given as a color resource.
     *
     * Wraps the withDisabledIconColorRes function. Non readable property.
     */
    var disabledIconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledIconColorRes(value)
        }

    /**
     * The color of the drawer item's text when it's disabled, given as an argb Long.
     *
     * Wraps the withDisabledTextColor function. Non readable property.
     */
    var disabledTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text when it's disabled, given as a color resource.
     *
     * Wraps the withDisabledTextColorRes function. Non readable property.
     */
    var disabledTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColorRes(value)
        }

    /**
     * The icon of the drawer item, given as a drawable resource.
     *
     * Convenience for the `iconRes` property. Wraps the withIcon function. Non readable property.
     */
    var icon: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, given as a drawable resource.
     *
     * Wraps the withIcon function. Non readable property.
     */
    var iconRes: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, given as a Drawable.
     *
     * Wraps the withIcon function. Non readable property.
     */
    var iconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, given as an IIcon.
     *
     * Wraps the withIcon function. Non readable property.
     */
    var iicon: IIcon
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the drawer item, given as an ImageHolder.
     *
     * Wraps the withIcon function. Non readable property.
     */
    var iconImage: ImageHolder
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The color of the drawer item's icon when it's enabled, given as an argb Long.
     *
     * Wraps the withIconColor function. Non readable property.
     */
    var iconColor: Long
        get() = nonReadable()
        set(value) {
            item.withIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's enabled, given as a color resource.
     *
     * Wraps the withIconColorRes function. Non readable property.
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
     * Wraps the withIconTintingEnabled function. Non readable property.
     */
    var iconTintingEnabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withIconTintingEnabled(value)
        }

    /**
     * How far the drawer item should be indented. Default value is 1.
     *
     * Wraps the withLevel function. Non readable property.
     */
    var level: Int
        get() = nonReadable()
        set(value) {
            item.withLevel(value)
        }

    /**
     * The title/name of the drawer item.
     *
     * Wraps the withName function. Non readable property.
     */
    var name: String
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The title/name of the drawer item, given as a String resource.
     *
     * Wraps the withName function. Non readable property.
     */
    var nameRes: Int
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The color of the drawer item when it's selected, given as an argb Long.
     *
     * Wraps the withSelectedColor function. Non readable property.
     */
    var selectedColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedColor(value.toInt())
        }

    /**
     * The color of the drawer item when it's selected, given as a color resource.
     *
     * Wraps the withSelectedColorRes function. Non readable property.
     */
    var selectedColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedColorRes(value)
        }

    /**
     * The icon of the drawer when it's selected, given as a drawable resource.
     *
     * Convenience for the `selectedIconRes` property. Wraps the withSelectedIcon function. Non readable property.
     */
    var selectedIcon: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The icon of the drawer item when it's selected, given as a drawable resource.
     *
     * Wraps the withSelectedIcon function. Non readable property.
     */
    var selectedIconRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The icon of the drawer item when it's selected, given as a Drawable.
     *
     * Wraps the withSelectedIcon function. Non readable property.
     */
    var selectedIconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withSelectedIcon(value)
        }

    /**
     * The color of the drawer item's icon when it's selected, given as an argb Long.
     *
     * Wraps the withSelectedIconColor function. Non readable property.
     */
    var selectedIconColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's selected, given as a color resource.
     *
     * Wraps the withSelectedIconColorRes function. Non readable property.
     */
    var selectedIconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedIconColorRes(value)
        }

    /**
     * The color of the drawer item's text when it's selected, given as an argb Long.
     *
     * Wraps the withSelectedTextColor function. Non readable property.
     */
    var selectedTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text when it's selected, given as a color resource.
     *
     * Wraps the withSelectedTextColorRes function. Non readable property.
     */
    var selectedTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColorRes(value)
        }

    /**
     * The color of the drawer item's text, given as an argb Long.
     *
     * Wraps the withTextColor function. Non readable property.
     */
    var textColor: Long
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the drawer item's text, given as a color resource.
     *
     * Wraps the withTextColorRes function. Non readable property.
     */
    var textColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the drawer item's text.
     *
     * Wraps the withTypeface function. Non readable property.
     */
    var typeface: Typeface
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
