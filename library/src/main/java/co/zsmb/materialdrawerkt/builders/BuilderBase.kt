package co.zsmb.materialdrawerkt.builders

import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

abstract class BuilderBase {

    internal abstract fun attachItem(item: IDrawerItem<*, *>)

    internal abstract fun attachHeader(header: AccountHeader)

}
