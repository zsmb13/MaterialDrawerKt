package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.draweritems.ProfileDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder

fun DrawerBuilderKt.accountHeader(setup: AccountHeaderBuilderKt.() -> Unit = {}): AccountHeader {
    val header = AccountHeaderBuilderKt(activity)
    header.setup()
    return header.build().apply { attachHeader(this) }
}

@DrawerMarker
class AccountHeaderBuilderKt(activity: Activity) {

    private val builder = AccountHeaderBuilder().withActivity(activity)

    var background: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderBackground(value)
        }

    fun profile(name: String = "", email: String = "", setup: ProfileDrawerItemKt.() -> Unit = {}) {
        val item = ProfileDrawerItemKt(name, email)
        item.setup()
        builder.addProfiles(item.build())
    }

    internal fun build(): AccountHeader = builder.build()

}
