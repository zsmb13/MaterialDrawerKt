package co.zsmb.materialdrawerktexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.zsmb.materialdrawerkt.builders.accountHeader
import co.zsmb.materialdrawerkt.drawer
import co.zsmb.materialdrawerkt.draweritems.divider
import co.zsmb.materialdrawerkt.draweritems.primaryItem
import co.zsmb.materialdrawerkt.draweritems.secondaryItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        drawer {
            accountHeader {
                background = R.color.primary
                profile("Mike Penz", "mikepenz@gmail.com") {
                    icon = R.mipmap.ic_launcher_round
                }
                profile("Sally", "sally@sally.com") {
                    icon = R.mipmap.ic_launcher
                }
                profile("Jimmy", "jimmy@jimmy.com") {
                    icon = R.mipmap.ic_launcher
                }
            }
            primaryItem("Primary 1", "Primary 1 description") {
                icon = R.drawable.ic_heart
                iconTintingEnabled = true
            }
            primaryItem("Primary 2", "Primary 2 description") {
                icon = R.drawable.ic_heart
                iconTintingEnabled = true
            }
            primaryItem("Primary 3", "Primary 3 description") {
                icon = R.drawable.ic_heart
                iconTintingEnabled = true
            }
            divider()
            secondaryItem("Secondary 1", "Secondary 1 description") {
                icon = R.drawable.ic_heart
                iconTintingEnabled = true
            }
            secondaryItem("Secondary 2", "Secondary 2 description") {
                icon = R.drawable.ic_heart
                iconTintingEnabled = true
            }
            secondaryItem("Secondary 3", "Secondary 3 description") {
                icon = R.drawable.ic_heart
                iconTintingEnabled = true
            }
            divider()
        }
    }

}
