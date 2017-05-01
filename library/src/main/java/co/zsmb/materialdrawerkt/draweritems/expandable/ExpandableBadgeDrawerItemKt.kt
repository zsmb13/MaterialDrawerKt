package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.draweritems.badgeable.BadgeableKt
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem

/**
 * Adds a new ExpandableBadgeDrawerItem with the given [name] and [description].
 * @return The created ExpandableBadgeDrawerItem instance
 */
fun Builder.expandableBadgeItem(name: String = "",
                                description: String? = null,
                                setup: ExpandableBadgeDrawerItemKt.() -> Unit = {}): ExpandableBadgeDrawerItem {
    val item = ExpandableBadgeDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

/**
 * Adds a new ExpandableBadgeDrawerItem with the given [nameRes] and [descriptionRes].
 * @return The created ExpandableBadgeDrawerItem instance
 */
fun Builder.expandableBadgeItem(nameRes: Int,
                                descriptionRes: Int? = null,
                                setup: ExpandableBadgeDrawerItemKt.() -> Unit = {}): ExpandableBadgeDrawerItem {
    val item = ExpandableBadgeDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class ExpandableBadgeDrawerItemKt : BaseDescribeableDrawerItemKt(), BadgeableKt {

    /* Builder basics */

    private val item = ExpandableBadgeDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

    /* ExpandableBadgeDrawerItem methods */

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
