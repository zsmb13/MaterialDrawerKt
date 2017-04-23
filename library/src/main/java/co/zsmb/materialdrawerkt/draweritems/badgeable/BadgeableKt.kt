package co.zsmb.materialdrawerkt.draweritems.badgeable

import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder

interface BadgeableKt {

    /**
     * The text of the displayed badge given by a StringHolder.
     *
     * Non readable property. Wraps the [com.mikepenz.materialdrawer.model.interfaces.Badgeable.withBadge] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "This property is for internal use. Use the badgeRes property or the badge method instead.")
    var badgeHolder: StringHolder

    /**
     * The text of the displayed badge given by a String resource.
     *
     * Non readable property. Wraps the [com.mikepenz.materialdrawer.model.interfaces.Badgeable.withBadge] method.
     */
    var badgeRes: Int

    /**
     * The style of the displayed badge given by a BadgeStyle.
     *
     * Non readable property. Wraps the [com.mikepenz.materialdrawer.model.interfaces.ColorfulBadgeable.withBadgeStyle]
     * method.
     */
    var badgeStyle: BadgeStyle

}
