package co.zsmb.materialdrawerkt.builders

import co.zsmb.materialdrawerkt.DrawerMarker
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@DrawerMarker
class StickyFooterKt(val builder: DrawerBuilder) : BuilderBase() {

    override fun attachItem(item: IDrawerItem<*, *>) {
        builder.addStickyDrawerItems(item)
    }

}
