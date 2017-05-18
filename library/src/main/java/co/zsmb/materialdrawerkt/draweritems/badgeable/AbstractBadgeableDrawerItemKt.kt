package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem

abstract class AbstractBadgeableDrawerItemKt : BaseDescribeableDrawerItemKt(), BadgeableKt {

    /* Builder basics */

    private lateinit var item: AbstractBadgeableDrawerItem<*>

    protected fun setItem(item: AbstractBadgeableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    /* AbstractBadgeableDrawerItem methods */

    // Documentation inherited
    override var badgeHolder: StringHolder
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withBadge(value)
        }

    // Documentation inherited
    override var badgeStyle: BadgeStyle
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withBadgeStyle(value)
        }

}
