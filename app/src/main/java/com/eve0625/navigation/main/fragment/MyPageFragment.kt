package com.eve0625.navigation.main.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import com.eve0625.navigation.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {

    private lateinit var mBinding: FragmentMypageBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = FragmentMypageBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.collapsingToolbar.viewTreeObserver.addOnGlobalLayoutListener(
            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    //1번만 실행하고 remove
                    mBinding.collapsingToolbar.viewTreeObserver.removeOnGlobalLayoutListener(this)

                    //툴바 하단까지 스크롤 됐을때 scrim
                    val toolbarRec = Rect()
                    mBinding.toolbar.getGlobalVisibleRect(toolbarRec)
                    mBinding.collapsingToolbar.scrimVisibleHeightTrigger = toolbarRec.bottom + 1
                    mBinding.collapsingToolbar.scrimAnimationDuration = 200
                }
            }
        )
    }

}
