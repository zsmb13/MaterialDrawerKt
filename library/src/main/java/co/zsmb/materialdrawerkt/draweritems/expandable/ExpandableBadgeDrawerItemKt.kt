@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.BadgeableKt
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem

/**
 * Adds a new ExpandableBadgeDrawerItem with the given [name] and [description].
 * @return The created ExpandableBadgeDrawerItem instance
 */
public fun Builder.expandableBadgeItem(name: String = "",
                                       description: String? = null,
                                       setup: ExpandableBadgeDrawerItemKt.() -> Unit = {}): ExpandableBadgeDrawerItem {
    return createItem(ExpandableBadgeDrawerItemKt(), name, description, setup)
}

/**
 * Adds a new ExpandableBadgeDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ExpandableBadgeDrawerItem instance
 */
public fun Builder.expandableBadgeItem(nameRes: Int,
                                       descriptionRes: Int? = null,
                                       setup: ExpandableBadgeDrawerItemKt.() -> Unit = {}): ExpandableBadgeDrawerItem {
    return createItem(ExpandableBadgeDrawerItemKt(), nameRes, descriptionRes, setup)
}

public class ExpandableBadgeDrawerItemKt :
        BaseDescribeableDrawerItemKt<ExpandableBadgeDrawerItem>(ExpandableBadgeDrawerItem()),
        BadgeableKt {

    // Documentation inherited
    override var badgeHolder: StringHolder
        get() = item.badge
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeRes: Int
        get() = item.badge.textRes
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeStyle: BadgeStyle
        get() = item.badgeStyle
        set(value) {
            item.withBadgeStyle(value)
        }

}
