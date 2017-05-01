package co.zsmb.materialdrawerktexample.utils

import com.mikepenz.crossfader.Crossfader
import com.mikepenz.materialdrawer.interfaces.ICrossfader

class CrossfadeWrapper(private val mCrossfader: Crossfader<*>) : ICrossfader {

    override fun crossfade() = mCrossfader.crossFade()

    override fun isCrossfaded() = mCrossfader.isCrossFaded()

}
