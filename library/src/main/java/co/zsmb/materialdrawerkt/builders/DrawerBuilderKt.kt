package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import co.zsmb.materialdrawerkt.draweritems.DividerDrawerItemKt
import co.zsmb.materialdrawerkt.draweritems.PrimaryDrawerItemKt
import co.zsmb.materialdrawerkt.draweritems.SecondaryDrawerItemKt
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

class DrawerBuilderKt(val activity: Activity) {

    private val builder = DrawerBuilder()

    init {
        builder.withActivity(activity)
    }

    internal fun build(): Drawer = builder.build()

    fun accountHeader(setup: AccountHeaderBuilderKt.() -> Unit = {}): AccountHeader {
        val header = AccountHeaderBuilderKt(activity)
        header.setup()
        return header.build().apply { builder.withAccountHeader(this) }
    }

    fun primaryItem(name: String = "", description: String = "", setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
        val item = PrimaryDrawerItemKt(name, description)
        item.setup()
        return item.build().apply { builder.addDrawerItems(this) }
    }

    fun secondaryItem(name: String = "", description: String = "",
                      setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
        val item = SecondaryDrawerItemKt(name, description)
        item.setup()
        return item.build().apply { builder.addDrawerItems(this) }
    }

    fun divider(setup: DividerDrawerItemKt.() -> Unit = {}): DividerDrawerItem {
        val item = DividerDrawerItemKt()
        item.setup()
        return item.build().apply { builder.addDrawerItems(this) }
    }

}

