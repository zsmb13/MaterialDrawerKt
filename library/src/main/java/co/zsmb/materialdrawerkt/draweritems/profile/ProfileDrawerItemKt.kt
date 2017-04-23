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
        email: String = "",
        setup: ProfileDrawerItemKt.() -> Unit = {}): ProfileDrawerItem {
    val item = ProfileDrawerItemKt(name, email)
    item.setup()
    return item.build().apply { addItem(this) }
}

class ProfileDrawerItemKt(name: String, email: String) : AbstractDrawerItemKt() {

    /* Builder basics */

    private val item = ProfileDrawerItem()
            .withName(name)
            .withEmail(email)

    internal fun build() = item

    /* ProfileDrawerItem methods */

    /**
     * The color of the profile item's text when it's disabled, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withDisabledTextColor] function.
     */
    var disabledTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColor(value.toInt())
        }

    /**
     * The color of the profile item's text when it's disabled, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withDisabledTextColorRes] function.
     */
    var disabledTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDisabledTextColorRes(value)
        }

    /**
     * The email associated with the profile.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withEmail] function.
     */
    var email: String
        get() = nonReadable()
        set(value) {
            item.withEmail(value)
        }

    /**
     * The icon of the profile, as a drawable resource.
     *
     * Non readable property. Convenience for `iconRes`. Wraps the [ProfileDrawerItem.withIcon] function.
     */
    var icon: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as a Bitmap.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] function.
     */
    var iconBitmap: Bitmap
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as a Drawable.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] function.
     */
    var iconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as an IIcon.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] function.
     */
    var iicon: IIcon
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as a drawable resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] function.
     */
    var iconRes: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, as an Uri.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] function.
     */
    var iconUri: Uri
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile, given by a url String.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withIcon] function.
     */
    var iconUrl: String
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The name of the profile.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withName] function.
     */
    var name: String
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * Whether the name of the profile should be displayed in the profile switcher in addition to the email.
     * False by default.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withNameShown] function.
     */
    var nameShown: Boolean
        get() = nonReadable()
        set(value) {
            item.withNameShown(value)
        }

    /**
     * The color of the profile item in the profile switcher list when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedColor] function.
     */
    var selectedColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedColor(value.toInt())
        }

    /**
     * The color of the profile item in the profile switcher list when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedColorRes] function.
     */
    var selectedColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedColorRes(value)
        }

    /**
     * The color of the profile item's text in the profile switcher list when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedTextColor] function.
     */
    var selectedTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColor(value.toInt())
        }

    /**
     * The color of the profile item's text in the profile switcher list when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withSelectedTextColorRes] function.
     */
    var selectedTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedTextColorRes(value)
        }

    /**
     *The color of the profile item's text in the profile switcher list, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withTextColor] function.
     */
    var textColor: Long
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the profile item's text in the profile switcher list, as a color resource.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withTextColorRes] function.
     */
    var textColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the profile item's text.
     *
     * Non readable property. Wraps the [ProfileDrawerItem.withTypeface] function.
     */
    var typeface: Typeface
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
