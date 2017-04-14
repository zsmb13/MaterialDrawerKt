package co.zsmb.materialdrawerkt.draweritems.badgeable

fun co.zsmb.materialdrawerkt.builders.BuilderBase.primaryItem(
        name: String = "",
        description: String = "",
        setup: co.zsmb.materialdrawerkt.draweritems.badgeable.PrimaryDrawerItemKt.() -> Unit = {}): com.mikepenz.materialdrawer.model.PrimaryDrawerItem {
    val item = co.zsmb.materialdrawerkt.draweritems.badgeable.PrimaryDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class PrimaryDrawerItemKt(name: String, description: String) : AbstractBadgeableDrawerItemKt() {

    private val item = com.mikepenz.materialdrawer.model.PrimaryDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

}