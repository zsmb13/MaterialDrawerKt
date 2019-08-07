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
            item.isNameShown = value
        }

    //endregion

}
