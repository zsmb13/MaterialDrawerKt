package co.zsmb.materialdrawerktexample.customitems.customprimary

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.createItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.AbstractBadgeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable

fun Builder.customPrimaryItem(
        name: String = "",
        description: String? = null,
        setup: CustomPrimaryDrawerItemKt.() -> Unit = {}): CustomPrimaryDrawerItem {
    return createItem(CustomPrimaryDrawerItemKt(), name, description, setup)
}

fun Builder.customPrimaryItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: CustomPrimaryDrawerItemKt.() -> Unit = {}): CustomPrimaryDrawerItem {
    return createItem(CustomPrimaryDrawerItemKt(), nameRes, descriptionRes, setup)
}

class CustomPrimaryDrawerItemKt : AbstractBadgeableDrawerItemKt<CustomPrimaryDrawerItem>(CustomPrimaryDrawerItem()) {

    // Props and methods

    var backgroundColor: Int
        get() = nonReadable()
        set(value) {
            item.withBackgroundColor(value)
        }

    var backgroundRes: Int
        get() = nonReadable()
        set(value) {
            item.withBackgroundRes(value)
        }

}
