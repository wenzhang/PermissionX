package com.wenzhang.library

import androidx.fragment.app.FragmentActivity

object PermissionX {

    private const val TAG = "InvisibleFragmentN"

    fun request(
        activity: FragmentActivity,
        vararg permission: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedfragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedfragment != null) {
            existedfragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permission)
    }
}