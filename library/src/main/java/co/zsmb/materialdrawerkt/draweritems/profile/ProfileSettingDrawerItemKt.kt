package co.zsmb.materialdrawerkt.draweritems.profile

import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.net.Uri
import co.zsmb.materialdrawerkt.builders.AccountHeaderBuilderKt
import co.zsmb.materialdrawerkt.draweritems.base.AbstractDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem

/**
 * Adds a new ProfileSettingDrawerItem with the given [name] and [description].
 * @return The created ProfileSettingDrawerItem instance
 */
fun AccountHeaderBuilderKt.profileSetting(
        name: String = "",
        description: String? = null,
        setup: ProfileSettingDrawerItemKt.() -> Unit = {}): ProfileSettingDrawerItem {
    val item = ProfileSettingDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { addItem(this) }
}

/**
 * Adds a new ProfileSettingDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ProfileSettingDrawerItem instance
 */
fun AccountHeaderBuilderKt.profileSetting(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: ProfileSettingDrawerItemKt.() -> Unit = {}): ProfileSettingDrawerItem {
    val item = ProfileSettingDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { addItem(this) }
}

class ProfileSettingDrawerItemKt : AbstractDrawerItemKt() {

    /* Builder basics */

    private val item = ProfileSettingDrawerItem()

    internal fun build() = item

    init {
        super.setItem(item)
    }

    /* ProfileSettingDrawerItem methods */

    /**
     * The description of the profile setting item.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withDescription] method.
     */
    var description: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The description of the profile setting item, as a String resource.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withDescription] method.
     */
    var descriptionRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withDescription(value)
        }

    /**
     * The color of the profile setting item's description, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withDescriptionTextColor] method.
     */
    var descriptionTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
            replaceWith = ReplaceWith("description"),
            message = "Only here for discoverability. Use the description property instead")
    var email: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * The icon of the profile setting, as a url String.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withIcon] method.
     */
    var iconUrl: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withIcon(value)
        }

    /**
     * Whether the icon of the profile setting item should be tinted with the enabled/disabled/selected color. If set to
     * false, your icon will always be displayed with its default colors.
     * Default value is false.
     *
     * Wraps the [ProfileSettingDrawerItem.withIconTinted] and [ProfileSettingDrawerItem.isIconTinted] methods.
     */
    var iconTinted: Boolean
        get() = item.isIconTinted
        set(value) {
            item.withIconTinted(value)
        }

    /**
     * The name of the profile setting.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withName] method.
     */
    var name: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The name of the profile setting, as a String resource.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withName] method.
     */
    var nameRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withName(value)
        }

    /**
     * The color of the profile setting item in the profile switcher list when it's selected, as an argb Long.
     *
     * Non readable property. Wraps the [ProfileSettingDrawerItem.withSelectedColor] method.
     */
    var selectedColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
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
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withTypeface(value)
        }

}
