package co.zsmb.materialdrawerkt.draweritems.profile

import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import co.zsmb.materialdrawerkt.builders.AccountHeaderBuilderKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem

/**
 * Adds a new ProfileSettingDrawerItem with the given [name] and [description].
 * @return The created ProfileSettingDrawerItem instance
 */
fun AccountHeaderBuilderKt.profileSetting(
        name: String = "",
        description: String = "",
        setup: ProfileSettingDrawerItemKt.() -> Unit = {}): ProfileSettingDrawerItem {
    val item = ProfileSettingDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { addItem(this) }
}

class ProfileSettingDrawerItemKt(name: String, description: String) {

    /* Builder basics */

    private val item = ProfileSettingDrawerItem()
            .withName(name)
            .withDescription(description)

    internal fun build() = item

    /* ProfileSettingDrawerItem methods */

    /**
     * The description of the profile setting item.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withDescription] method.
     */
    var description: String
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The description of the profile setting item, as a String resource.
     *
     * Non readable property. Uses reflection to provide similar functionality to the
     * [ProfileSettingDrawerItem.withDescription] method.
     */
    var descriptionRes: Int
        get() = nonReadable()
        set(value) {
            item.javaClass.declaredFields.find { it.name == "description" }?.let {
                it.isAccessible = true
                it.set(item, StringHolder(value))
            }
        }

    /**
     * The color of the profile setting item's description, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withDescriptionTextColor] method.
     */
    var descriptionTextColor: Long
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColor(value.toInt())
        }

    /**
     * The color of the profile setting item's description, as a color resource.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withDescriptionTextColor] method.
     */
    var descriptionTextColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withDescriptionTextColorRes(value)
        }

    /**
     * The description of the profile setting.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withEmail] method.
     */
    @Deprecated(level = DeprecationLevel.ERROR,
            message = "Only here for discoverability. Use the description property instead",
            replaceWith = ReplaceWith("description"))
    var email: String
        get() = nonReadable()
        set(value) {
            item.withEmail(value)
        }

    /**
     * The icon of the profile setting, as a drawable resource.
     *
     * Convenience for [iconRes]. Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    var icon: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile setting, as a Bitmap.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    var iconBitmap: Bitmap
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The color of the profile setting item's icon, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIconColor] method.
     */
    var iconColor: Long
        get() = nonReadable()
        set(value) {
            item.withIconColor(value.toInt())
        }

    /**
     * The color of the profile setting item's icon, as a color resource.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIconColor] method.
     */
    var iconColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withIconColorRes(value)
        }

    /**
     * The icon of the profile setting, as a Drawable.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    var iconDrawable: Drawable
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile setting, as a drawable resource.
     *
     * See [icon] as an alternative.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var iconRes: Int
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile setting, as an Uri.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    var iconUri: Uri
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile setting, given by a url String.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    var iconUrl: String
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile setting, as an IIcon.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    var iicon: IIcon
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * Whether the icon of the profile setting item should be tinted with the enabled/disabled/selected color. If set to
     * false, your icon will always be displayed with its default colors.
     * Default value is false.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIconTinted] method.
     */
    var iconTinted: Boolean
        get() = nonReadable()
        set(value) {
            item.withIconTinted(value)
        }

    /**
     * The name of the profile setting.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withName] method.
     */
    var name: String
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The name of the profile setting, as a String resource.
     *
     * Non readable property. Uses reflection to provide similar functionality to the
     * [ProfileSettingDrawerItem.withName] method.
     */
    var nameRes: Int
        get() = nonReadable()
        set(value) {
            item.javaClass.declaredFields.find { it.name == "name" }?.let {
                it.isAccessible = true
                it.set(item, StringHolder(value))
            }
        }

    /**
     * The color of the profile setting item in the profile switcher list when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withSelectedColor] method.
     */
    var selectedColor: Long
        get() = nonReadable()
        set(value) {
            item.withSelectedColor(value.toInt())
        }

    /**
     * The color of the profile setting item in the profile switcher list when it's selected, as a color resource.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withSelectedColorRes] method.
     */
    var selectedColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withSelectedColorRes(value)
        }

    /**
     *The color of the profile setting item's text in the profile switcher list, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withTextColor] method.
     */
    var textColor: Long
        get() = nonReadable()
        set(value) {
            item.withTextColor(value.toInt())
        }

    /**
     * The color of the profile setting item's text in the profile switcher list, as a color resource.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withTextColorRes] method.
     */
    var textColorRes: Int
        get() = nonReadable()
        set(value) {
            item.withTextColorRes(value)
        }

    /**
     * The typeface to use for the profile setting item's text.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withTypeface] method.
     */
    var typeface: Typeface
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
