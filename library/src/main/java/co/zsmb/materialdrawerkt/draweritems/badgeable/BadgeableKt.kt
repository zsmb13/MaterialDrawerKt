package co.zsmb.materialdrawerkt.draweritems.badgeable

import com.mikepenz.materialdrawer.holder.BadgeStyle

interface BadgeableKt {

    /**
     * The text of the displayed badge given by a String resource.
     *
     * Wraps the withBadge function. Non readable property.
     */
    var badgeRes: Int

    /**
     * The style of the displayed badge given by a BadgeStyle.
     *
     * Wraps the withBadgeStyle function. Non readable property.
     */
    var badgeStyle: BadgeStyle

}
