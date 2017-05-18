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
fun AccountHeaderBuilderKt.profile(
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
fun AccountHeaderBuilderKt.profile(
        nameRes: Int,
        emailRes: Int? = null,
        setup: ProfileDrawerItemKt.() -> Unit = {}): ProfileDrawerItem {
    val item = ProfileDrawerItemKt()
    item.nameRes = nameRes
    emailRes?.let { item.emailRes = it }
    item.setup()
    return item.build().apply { addItem(this) }
}


class ProfileDrawerItemKt : AbstractDrawerItemKt() {

    /* Builder basics */

    private val item = ProfileDrawerItem()

    internal fun build() = item

    init {
        super.setItem(item)
    }

    /* ProfileDrawerItem methods */

    /**
     * The color of the profile item's text when it's disabled, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withDisabledTextColor] method.
     */
    var disabledTextColor: Long
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
    var disabledTextColorRes: Int
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
    var email: String
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
    var emailRes: Int
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
    var icon: Int
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
    var iconBitmap: Bitmap
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
    var iconDrawable: Drawable
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
    var iconRes: Int
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
    var iconUri: Uri
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
    var iconUrl: String
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
    var iicon: IIcon
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
    var name: String
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
    var nameRes: Int
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
    var nameShown: Boolean
        get() = item.isNameShown
        set(value) {
            item.withNameShown(value)
        }

    /**
     * The color of the profile item in the profile switcher list when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedColor] method.
     */
    var selectedColor: Long
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
    var selectedColorRes: Int
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
    var selectedTextColor: Long
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
    var selectedTextColorRes: Int
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
    var textColor: Long
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
    var textColorRes: Int
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
    var typeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
