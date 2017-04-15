package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem

abstract class AbstractBadgeableDrawerItemKt : BaseDescribeableDrawerItemKt() {

    private lateinit var item: AbstractBadgeableDrawerItem<*>

    protected fun setItem(item: AbstractBadgeableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    var badge: String
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    var badgeRes: Int
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    var badgeHolder: StringHolder
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    var badgeStyle: BadgeStyle
        get() = nonReadable()
        set(value) {
            item.withBadgeStyle(value)
        }

}
