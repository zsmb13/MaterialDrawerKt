package co.zsmb.materialdrawerkt

import android.app.Activity
import co.zsmb.materialdrawerkt.builders.DrawerBuilderKt
import com.mikepenz.materialdrawer.Drawer

fun Activity.drawer(setup: DrawerBuilderKt.() -> Unit = {}): Drawer {
    val builder = DrawerBuilderKt(this)
    builder.setup()
    return builder.build()
}
