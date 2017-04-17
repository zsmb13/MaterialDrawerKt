package co.zsmb.materialdrawerkt.draweritems.expandable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.badgeable.BadgeableKt
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem

/**
 * Adds a new ExpandableBadgeDrawerItem with the given [name] and [description].
 * @return The created ExpandableBadgeDrawerItem instance
 */
fun BuilderBase.expandableBadgeItem(name: String = "",
                                    description: String = "",
                                    setup: ExpandableBadgeDrawerItemKt.() -> Unit = {}): ExpandableBadgeDrawerItem {
    val item = ExpandableBadgeDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class ExpandableBadgeDrawerItemKt(name: String, description: String) : BaseDescribeableDrawerItemKt(), BadgeableKt {

    private val item = ExpandableBadgeDrawerItem()
            .withName(name)
            .withDescription(description)

    init {
        super.setItem(item)
    }

    internal fun build() = item

    // Documentation inherited
    override var badgeRes: Int
        get() = item.badge.textRes
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeHolder: StringHolder
        get() = item.badge
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
