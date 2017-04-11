package co.zsmb.materialdrawerkt.draweritems.base

abstract class AbstractBadgeableDrawerItemKt : BaseDescribeableDrawerItemKt() {

    private lateinit var item: com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem<*>

    protected fun setItem(item: com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    var badge: String
        get() = co.zsmb.materialdrawerkt.nonReadable()
        set(value) {
            item.withBadge(value)
        }

    var badgeRes: Int
        get() = co.zsmb.materialdrawerkt.nonReadable()
        set(value) {
            item.withBadge(value)
        }

    var badgeHolder: com.mikepenz.materialdrawer.holder.StringHolder
        get() = co.zsmb.materialdrawerkt.nonReadable()
        set(value) {
            item.withBadge(value)
        }

    var badgeStyle: com.mikepenz.materialdrawer.holder.BadgeStyle
        get() = co.zsmb.materialdrawerkt.nonReadable()
        set(value) {
            item.withBadgeStyle(value)
        }

}
