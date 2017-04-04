package co.zsmb.materialdrawerktexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.zsmb.materialdrawerkt.DrawerBuilderKt
import co.zsmb.materialdrawerkt.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer()
    }

}
