package co.zsmb.materialdrawerktexample.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import co.zsmb.materialdrawerktexample.R
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import kotlinx.android.synthetic.main.fragment_simple_sample.view.*

class DrawerFragment : Fragment() {

    private lateinit var result: Drawer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_simple_sample, container, false)

        result = drawer {
            savedInstance = savedInstanceState
            rootView = view.root
            displayBelowStatusBar = false

            primaryItem(R.string.drawer_item_home) { iicon = FontAwesome.Icon.faw_home }
            primaryItem(R.string.drawer_item_free_play) { iicon = FontAwesome.Icon.faw_gamepad }
            primaryItem(R.string.drawer_item_custom) { iicon = FontAwesome.Icon.faw_eye }
            sectionHeader(R.string.drawer_item_section_header)
            secondaryItem(R.string.drawer_item_settings) { iicon = FontAwesome.Icon.faw_cog }
            secondaryItem(R.string.drawer_item_help) { iicon = FontAwesome.Icon.faw_question }
            secondaryItem(R.string.drawer_item_open_source) { iicon = FontAwesome.Icon.faw_github }
            secondaryItem(R.string.drawer_item_contact) { iicon = FontAwesome.Icon.faw_bullhorn }
        }

        view.title.text = arguments?.getString(KEY_TITLE)

        result.drawerLayout.fitsSystemWindows = false
        result.slider.fitsSystemWindows = false

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        result.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    companion object {
        private const val KEY_TITLE = "title"

        fun newInstance(title: String) =
                DrawerFragment().apply {
                    val args = Bundle()
                    args.putString(KEY_TITLE, title)
                    arguments = args
                }
    }

}
