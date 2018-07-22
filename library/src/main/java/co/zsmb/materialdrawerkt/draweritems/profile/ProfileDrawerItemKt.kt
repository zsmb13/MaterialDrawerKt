@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.profile

import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import co.zsmb.materialdrawerkt.builders.AccountHeaderBuilderKt
import co.zsmb.materialdrawerkt.draweritems.base.AbstractDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

/**
 * Adds a new ProfileDrawerItem with the given [name] and [email] address.
 * @return The created ProfileDrawerItem instance
 */
public fun AccountHeaderBuilderKt.profile(
        name: String = "",
        email: String? = null,
        setup: ProfileDrawerItemKt.() -> Unit = {}): ProfileDrawerItem {
    val item = ProfileDrawerItemKt()
    item.name = name
    email?.let { item.email = it }
    item.setup()
    return item.build().apply { addItem(this) }
}

/**
 * Adds a new ProfileDrawerItem with the given [nameRes] and [emailRes] address.
 * @return The created ProfileDrawerItem instance
 */
public fun AccountHeaderBuilderKt.profile(
        nameRes: Int,
        emailRes: Int? = null,
        setup: ProfileDrawerItemKt.() -> Unit = {}): ProfileDrawerItem {
    val item = ProfileDrawerItemKt()
    item.nameRes = nameRes
    emailRes?.let { item.emailRes = it }
    item.setup()
    return item.build().apply { addItem(this) }
}

public class ProfileDrawerItemKt : AbstractDrawerItemKt<ProfileDrawerItem>(ProfileDrawerItem()) {

    /**
     * The color of the profile item's text when it's disabled, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withDisabledTextColor] method.
     */
    public var disabledTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColor(value.toInt())
        }

    /**
     * The color of the profile item's text when it's disabled, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withDisabledTextColorRes] method.
     */
    public var disabledTextColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColorRes(value)
        }

    /**
     * The email associated with the profile.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withEmail] method.
     */
    public var email: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withEmail(value)
        }

    /**
     * The email associated with the profile, as a String resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withEmail] method.
     */
    public var emailRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withEmail(value)
        }

    /**
     * The icon of the profile, as a drawable resource.
     *
     * Convenience for [iconRes]. Non readable property. Wraps the [ProfileDrawerItem.withIcon] method.
     */
    public var icon: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as a Bitmap.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] method.
     */
    public var iconBitmap: Bitmap
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as a Drawable.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] method.
     */
    public var iconDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as a drawable resource.
     *
     * See [icon] as an alternative.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] method.
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
     * The icon of the profile, as an Uri.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] method.
     */
    public var iconUri: Uri
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as a url String.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] method.
     */
    public var iconUrl: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as an IIcon.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] method.
     */
    public var iicon: IIcon
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The name of the profile.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withName] method.
     */
    public var name: CharSequence
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The name of the profile, as a String resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withName] method.
     */
    public var nameRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * Whether the name of the profile should be displayed in the profile switcher in addition to the email.
     * False by default.
     *
     * Wraps the [ProfileDrawerItem.withNameShown] and [ProfileDrawerItem.isNameShown] methods.
     */
    public var nameShown: Boolean
        get() = item.isNameShown
        set(value) {
            item.withNameShown(value)
        }

    /**
     * The color of the profile item in the profile switcher list when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedColor] method.
     */
    public var selectedColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedColor(value.toInt())
        }

    /**
     * The color of the profile item in the profile switcher list when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedColorRes] method.
     */
    public var selectedColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedColorRes(value)
        }

    /**
     * The color of the profile item's text in the profile switcher list when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedTextColor] method.
     */
    public var selectedTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColor(value.toInt())
        }

    /**
     * The color of the profile item's text in the profile switcher list when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedTextColorRes] method.
     */
    public var selectedTextColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColorRes(value)
        }

    /**
     * The color of the profile item's text in the profile switcher list, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withTextColor] method.
     */
    public var textColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the profile item's text in the profile switcher list, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withTextColorRes] method.
     */
    public var textColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the profile item's text.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withTypeface] method.
     */
    public var typeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

    //endregion

}
