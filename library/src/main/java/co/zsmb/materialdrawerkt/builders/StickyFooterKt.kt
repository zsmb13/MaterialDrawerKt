package co.zsmb.materialdrawerkt.builders

import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class StickyFooterKt(val builder: DrawerBuilder) : BuilderBase() {

    override fun attachItem(item: IDrawerItem<*, *>) {
        builder.addStickyDrawerItems(item)
    }

    override fun attachHeader(header: AccountHeader) {
        TODO("Unsupported operation")
    }

}
