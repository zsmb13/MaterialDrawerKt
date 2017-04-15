package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem

abstract class AbstractBadgeableDrawerItemKt : BaseDescribeableDrawerItemKt(), BadgeableKt {

    private lateinit var item: AbstractBadgeableDrawerItem<*>

    protected fun setItem(item: AbstractBadgeableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    // Documentation inherited
    override var badgeRes: Int
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeHolder: StringHolder
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeStyle: BadgeStyle
        get() = nonReadable()
        set(value) {
            item.withBadgeStyle(value)
        }

}
