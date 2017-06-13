package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.interfaces.IProfile

/**
 * Adds an [AccountHeader] to the drawer.
 * @return The created [AccountHeader] instance
 */
fun DrawerBuilderKt.accountHeader(setup: AccountHeaderBuilderKt.() -> Unit = {}): AccountHeader {
    val header = AccountHeaderBuilderKt(activity)
    header.setup()
    return header.build().apply { attachHeader(this) }
}

@DrawerMarker
class AccountHeaderBuilderKt(activity: Activity) {

    /* Builder basics */

    val builder: AccountHeaderBuilder = AccountHeaderBuilder().withActivity(activity)

    internal fun build(): AccountHeader {
        if (onProfileImageListener.isInitialized) {
            builder.withOnAccountHeaderProfileImageListener(onProfileImageListener)
        }

        return builder.build()
    }

    internal fun addItem(profile: IProfile<*>) = builder.addProfiles(profile)

    /* Listener helper */

    private val onProfileImageListener = object : AccountHeader.OnAccountHeaderProfileImageListener {
        var isInitialized = false

        var onClick: ((view: View, profile: IProfile<*>, current: Boolean) -> Boolean)? = null
            set(value) {
                isInitialized = true
                field = value
            }

        override fun onProfileImageClick(view: View, profile: IProfile<*>, current: Boolean): Boolean {
            return onClick?.invoke(view, profile, current) ?: false
        }

        var onLongClick: ((view: View, profile: IProfile<*>, current: Boolean) -> Boolean)? = null
            set(value) {
                isInitialized = true
                field = value
            }

        override fun onProfileImageLongClick(view: View, profile: IProfile<*>, current: Boolean): Boolean {
            return onLongClick?.invoke(view, profile, current) ?: false
        }
    }

    /* AccountHeaderBuilder methods */

    /**
     * By default, the small profile icons in the header show the most recently used profiles, the leftmost being the
     * last one used before the current one. If this setting is enabled, the small profile icons will still display the
     * most recently used profiles, but instead of being ordered by the time they were last used, they will stay in one
     * position as long as possible.
     * Default value is false.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withAlternativeProfileHeaderSwitching] method.
     */
    var alternativeSwitching: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withAlternativeProfileHeaderSwitching(value)
        }

    /**
     * The background of the header, as a drawable resource.
     *
     * Convenience for [backgroundRes]. Non readable property. Wraps the [AccountHeaderBuilder.withHeaderBackground]
     * method.
     */
    var background: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderBackground(value)
        }

    /**
     * The background of the header, as a Drawable.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withHeaderBackground] method.
     */
    var backgroundDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderBackground(value)
        }

    /**
     * The background of the header, as a drawable resource.
     *
     * See [background] as an alternative.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withHeaderBackground] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            replaceWith = ReplaceWith("background"),
            message = "Alternatives are available, check the documentation.")
    var backgroundRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderBackground(value)
        }

    /**
     * Defines the way the background drawable will scale.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withHeaderBackgroundScaleType] method.
     */
    var backgroundScaleType: ImageView.ScaleType
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderBackgroundScaleType(value)
        }

    /**
     * Whether the drawer should be closed when a profile item is clicked.
     * Default value is true.
     *
     * See [closeOnClick] as an alternative.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withCloseDrawerOnProfileListClick] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var closeDrawerOnProfileListClick: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withCloseDrawerOnProfileListClick(value)
        }

    /**
     * Whether to close the profile selection list after a profile in it has been selected.
     * Default value is true.
     *
     * Convenience for [resetDrawerOnProfileListClick]. Non readable property. Wraps the
     * [AccountHeaderBuilder.withResetDrawerOnProfileListClick] method.
     */
    var closeListAfterSelection: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withResetDrawerOnProfileListClick(value)
        }

    /**
     * Whether the drawer should be closed when a profile item is clicked.
     * Default value is true.
     *
     * Convenience for [closeDrawerOnProfileListClick]. Non readable property. Wraps the
     * [AccountHeaderBuilder.withCloseDrawerOnProfileListClick] method.
     */
    var closeOnClick: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withCloseDrawerOnProfileListClick(value)
        }

    /**
     * Whether to use a smaller, compact style drawer.
     * Default value is false.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withCompactStyle] method.
     */
    var compactStyle: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withCompactStyle(value)
        }

    /**
     * Whether the current profile should be hidden from the profile selection list.
     * Default value is false.
     *
     * Convenience for [currentProfileHiddenInList]. Non readable property. Wraps the
     * [AccountHeaderBuilder.withCurrentProfileHiddenInList] method.
     */
    var currentHidden: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withCurrentProfileHiddenInList(value)
        }

    /**
     * Whether the current profile should be hidden from the profile selection list.
     * Default value is false.
     *
     * See [currentHidden] as an alternative.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withCurrentProfileHiddenInList] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var currentProfileHiddenInList: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withCurrentProfileHiddenInList(value)
        }

    /**
     * A completely custom View for the header.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withAccountHeader] method.
     */
    var customView: View
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withAccountHeader(value)
        }

    /**
     * A completely custom view for the header, as a layout resource.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withAccountHeader] method.
     */
    var customViewRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withAccountHeader(value)
        }

    /**
     * The delay (in milliseconds) for the drawer close operation after a click. This is a small trick to improve
     * performance and prevent lag if you open a new Activity after a drawer item was selected. Set to -1 to disable
     * this behavior entirely.
     * The default value is 100.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withOnProfileClickDrawerCloseDelay] method.
     */
    var delayOnDrawerClose: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withOnProfileClickDrawerCloseDelay(value)
        }

    /**
     * Whether there should be a divider below the header.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withDividerBelowHeader] method.
     */
    var dividerBelow: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDividerBelowHeader(value)
        }

    /**
     * The drawer this header belongs to. Not recommended since it will be automatically set to the right drawer anyway.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withDrawer] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Setting this manually is not recommended.")
    var drawer: Drawer
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawer(value)
        }

    /**
     * The typeface used for displaying the email of the currently selected profile.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withEmailTypeface] method.
     */
    var emailTypeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withEmailTypeface(value)
        }

    /**
     * The height of the header, in dps.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withHeightDp] method.
     */
    var heightDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeightDp(value)
        }

    /**
     * The height of the header, in pixels.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withHeightPx] method.
     */
    var heightPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeightPx(value)
        }

    /**
     * The height of the header, as a dimension resource.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withHeightRes] method.
     */
    var heightRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeightRes(value)
        }

    /**
     * The typeface used for displaying the name of the currently selected profile.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withNameTypeface] method.
     */
    var nameTypeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withNameTypeface(value)
        }

    /**
     * Adds an event [handler] to the header that's called when one of the profile items in the list is long clicked.
     * The handler should return true if the event has been completely handled.
     *
     * Wraps the [AccountHeaderBuilder.withOnAccountHeaderItemLongClickListener] method.
     *
     * @param view The View that was clicked
     * @param profile The profile that was clicked
     * @param current Whether the clicked profile is the currently selected one
     */
    fun onItemLongClick(handler: (view: View, profile: IProfile<*>, current: Boolean) -> Boolean) {
        builder.withOnAccountHeaderItemLongClickListener(handler)
    }

    /**
     * If set to true, hides the small profile images. If you want to hide all profile images, see the
     * [profileImagesVisible] property.
     * Default value is false.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withOnlyMainProfileImageVisible] method.
     */
    var onlyMainProfileImageVisible: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withOnlyMainProfileImageVisible(value)
        }

    /**
     * If set to true, hides the profile image of the selected user. If you want to hide all profile images, see the
     * [profileImagesVisible] property.
     * Default value is false.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withOnlySmallProfileImagesVisible] method.
     */
    var onlySmallProfileImagesVisible: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withOnlySmallProfileImagesVisible(value)
        }

    /**
     * Adds an event [handler] to the header that's called when one of the profile items in the list is selected.
     * The handler should return true if the event has been completely handled.
     *
     * Wraps the [AccountHeaderBuilder.withOnAccountHeaderListener] method.
     *
     * @param view The View that was clicked
     * @param profile The profile that was clicked
     * @param current Whether the clicked profile is the currently selected one
     */
    fun onProfileChanged(handler: (view: View, profile: IProfile<*>, current: Boolean) -> Boolean) {
        builder.withOnAccountHeaderListener(handler)
    }

    /**
     * Adds an event [handler] to the header that's called when one of the profile images is clicked.
     * The handler should return true if the event has been completely handled.
     *
     * Wraps the [AccountHeaderBuilder.withOnAccountHeaderProfileImageListener] method.
     *
     * @param view The View that was clicked
     * @param profile The profile that was clicked
     * @param current Whether the clicked profile is the currently selected one
     */
    fun onProfileImageClick(handler: (view: View, profile: IProfile<*>, current: Boolean) -> Boolean) {
        onProfileImageListener.onClick = handler
    }

    /**
     * Adds an event [handler] to the header that's called when one of the profile images is long clicked.
     * The handler should return true if the event has been completely handled.
     *
     * Wraps the [AccountHeaderBuilder.withOnAccountHeaderProfileImageListener] method.
     *
     * @param view The View that was clicked
     * @param profile The profile that was clicked
     * @param current Whether the clicked profile is the currently selected one
     */
    fun onProfileImageLongClick(handler: (view: View, profile: IProfile<*>, current: Boolean) -> Boolean) {
        onProfileImageListener.onLongClick = handler
    }

    /**
     * Adds an event [handler] to the header that's called when the header is clicked somewhere that toggles opening
     * and closing the list view (anywhere other than the profile icons).
     * The handler should return true if the event has been completely handled.
     *
     * Wraps the [AccountHeaderBuilder.withOnAccountHeaderSelectionViewClickListener] method.
     *
     * @param view The View containing the header
     * @param profile The currently selected profile
     */
    fun onSelectionViewClick(handler: (view: View, profile: IProfile<*>) -> Boolean) {
        builder.withOnAccountHeaderSelectionViewClickListener(handler)
    }

    /**
     * Whether to include padding below the header.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withPaddingBelowHeader] method.
     */
    var paddingBelow: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withPaddingBelowHeader(value)
        }

    /**
     * Whether the profile images can be clicked to change profiles.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withProfileImagesClickable] method.
     */
    var profileImagesClickable: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withProfileImagesClickable(value)
        }

    /**
     * Whether any of the profile images (large and small) are visible. If you only want to hide only some profile
     * images, see the [onlyMainProfileImageVisible] and [onlySmallProfileImagesVisible] properties.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withProfileImagesVisible] method.
     */
    var profileImagesVisible: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withProfileImagesVisible(value)
        }

    /**
     * Whether to close the profile selection list after a profile in it has been selected.
     * Default value is true.
     *
     * See [closeListAfterSelection] as an alternative.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withResetDrawerOnProfileListClick] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var resetDrawerOnProfileListClick: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withResetDrawerOnProfileListClick(value)
        }


    /**
     * The bundle to restore state from after a configuration change.
     *
     * Remember to store the AccountHeader instance and call its
     * [saveInstanceState][com.mikepenz.materialdrawer.AccountHeader.saveInstanceState] method in the Activity's
     * [onSaveInstanceState][Activity.onSaveInstanceState] method, before calling super, to store the current state of
     * the header. Note that this has to be done in addition to doing it for the Drawer.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withSavedInstance] method.
     */
    var savedInstance: Bundle?
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSavedInstance(value)
        }

    /**
     * Overrides the currently selected user's name display.
     * Default value is the user's name.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withSelectionFirstLine] method.
     */
    var selectionFirstLine: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectionFirstLine(value)
        }

    /**
     * Whether to display the currently selected user's name.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withSelectionFirstLineShown] method.
     */
    var selectionFirstLineShown: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectionFirstLineShown(value)
        }

    /**
     * Whether the profile selection list can be opened.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withSelectionListEnabled] method.
     */
    var selectionListEnabled: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectionListEnabled(value)
        }

    /**
     * Whether the profile selection list can be opened if there is only one profile in the header.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withSelectionListEnabledForSingleProfile] method.
     */
    var selectionListEnabledForSingleProfile: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectionListEnabledForSingleProfile(value)
        }

    /**
     * Overrides the currently selected user's email display.
     * Default value is the user's email.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withSelectionSecondLine] method.
     */
    var selectionSecondLine: String
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectionSecondLine(value)
        }

    /**
     * Whether to display the currently selected user's email.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withSelectionSecondLineShown] method.
     */
    var selectionSecondLineShown: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectionSecondLineShown(value)
        }

    /**
     * The color of the currently selected user's name, email, and the list's toggle arrow, as an argb Long.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withTextColor] method.
     */
    var textColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTextColor(value.toInt())
        }

    /**
     * The color of the currently selected user's name, email, and the list's toggle arrow, as a color resource.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withTextColorRes] method.
     */
    var textColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTextColorRes(value)
        }

    /**
     * Whether to display three small profile images instead of the default two.
     * Default value is false.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withThreeSmallProfileImages] method.
     */
    var threeSmallProfileImages: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withThreeSmallProfileImages(value)
        }

    /**
     * This should be enabled if you're using a translucent status bar.
     * Default value is true.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withTranslucentStatusBar] method.
     */
    var translucentStatusBar: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTranslucentStatusBar(value)
        }

    /**
     * The typeface used for displaying the name and email of the currently selected profile. This is overriden by the
     * [nameTypeface] and [emailTypeface] properties if they are set.
     *
     * Non readable property. Wraps the [AccountHeaderBuilder.withTypeface] method.
     */
    var typeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTypeface(value)
        }

}
