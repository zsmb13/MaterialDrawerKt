@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.base

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.holder.ColorHolder
import com.mikepenz.materialdrawer.holder.ImageHolder
import com.mikepenz.materialdrawer.holder.StringHolder
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
     * The icon of the drawer item, as a drawable resource.
     *
     * Non readable property. Convenience for [iconRes]. Wraps the [BaseDrawerItem.icon] property.
     */
    public var icon: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.icon = ImageHolder(value)
        }

    /**
     * The color of the drawer item's icon when it's enabled, as an argb Long.
     *
     * Non readable property. Wraps the [BaseDrawerItem.iconColor] property.
     */
    public var iconColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.iconColor = ColorHolder.fromColor(value.toInt())
        }

    /**
     * The color of the drawer item's icon when it's enabled, as a color resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.iconColor] property.
     */
    public var iconColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.iconColor = ColorHolder.fromColorRes(value)
        }

    /**
     * The icon of the drawer item, as a Drawable.
     *
     * Non readable property. Wraps the [BaseDrawerItem.icon] property.
     */
    public var iconDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.icon = ImageHolder(value)
        }

    /**
     * The icon of the drawer item, as a drawable resource.
     *
     * See [icon] as an alternative.
     *
     * Non readable property. Wraps the [BaseDrawerItem.icon] property.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    public var iconRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.icon = ImageHolder(value)
        }

    /**
     * Whether the icon of the drawer item should be tinted with the enabled/disabled/selected color. If set to false,
     * your icon will always be displayed with its default colors.
     *
     * Wraps the [BaseDrawerItem.isIconTinted] property.
     */
    public var iconTintingEnabled: Boolean
        get() = item.isIconTinted
        set(value) {
            item.isIconTinted = value
        }

    /**
     * The icon of the drawer item, as an Uri.
     *
     * Non readable property. Wraps the [BaseDrawerItem.icon] property.
     */
    public var iconUri: Uri
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.icon = ImageHolder(value)
        }

    /**
     * The icon of the drawer item, as a url String.
     *
     * Non readable property. Wraps the [BaseDrawerItem.icon] property.
     */
    public var iconUrl: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.icon = ImageHolder(value)
        }

    /**
     * The icon of the drawer item, as an IIcon.
     *
     * Non readable property. Wraps the [BaseDrawerItem.icon] property.
     */
    public var iicon: IIcon
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.icon = ImageHolder(value)
        }

    /**
     * How far the drawer item should be indented. Default value is 1.
     *
     * Wraps [BaseDrawerItem.withLevel] and [BaseDrawerItem.level].
     */
    public var level: Int
        get() = item.level
        set(value) {
            item.withLevel(value)
        }

    /**
     * The title/name of the drawer item.
     *
     * Non readable property. Wraps the [BaseDrawerItem.name] property.
     */
    public var name: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.name = StringHolder(value)
        }

    /**
     * The title/name of the drawer item, as a String resource.
     *
     * Non readable property. Wraps the [BaseDrawerItem.name] property.
     */
    public var nameRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.name = StringHolder(value)
        }

    /**
     * The icon of the drawer when it's selected, as a drawable resource.
     *
     * Non readable property. Convenience for [selectedIconRes]. Wraps the [BaseDrawerItem.selectedIcon] property.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    public var selectedIcon: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedIcon = ImageHolder(value)
        }

    /**
     * The icon of the drawer item when it's selected, as a Bitmap.
     *
     * Non readable property. Wraps the [BaseDrawerItem.selectedIcon] property.
     */
    public var selectedIconBitmap: Bitmap
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedIcon = ImageHolder(value)
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
     * Non readable property. Wraps the [BaseDrawerItem.selectedIcon] property.
     */
    public var selectedIconDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedIcon = ImageHolder(value)
        }

    /**
     * The icon of the drawer item when it's selected, as a drawable resource.
     *
     * See [selectedIcon] as an alternative.
     *
     * Non readable property. Wraps the [BaseDrawerItem.selectedIcon] property.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    public var selectedIconRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedIcon = ImageHolder(value)
        }

    /**
     * The icon of the drawer item when it's selected, as an Uri.
     *
     * Non readable property. Wraps the [BaseDrawerItem.selectedIcon] property.
     */
    public var selectedIconUri: Uri
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedIcon = ImageHolder(value)
        }

    /**
     * The icon of the drawer item when it's selected, as a url String.
     *
     * Non readable property. Wraps the [BaseDrawerItem.selectedIcon] property.
     */
    public var selectedIconUrl: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedIcon = ImageHolder(value)
        }

}
