package com.yuyan.inputmethod.util

import androidx.collection.SparseArrayCompat

object EnPinYinUtils {

    private val t9EnMap = SparseArrayCompat<Pair<String, Int>>(225)

    init {
        t9EnMap.append(8, "1,@" to 1)
        t9EnMap.append(9, "a,b,c" to 1)
        t9EnMap.append(10, "d,e,f" to 1)
        t9EnMap.append(11, "g,h,i" to 1)
        t9EnMap.append(12, "j,k,l" to 1)
        t9EnMap.append(13, "m,n,o" to 1)
        t9EnMap.append(14, "p,q,r,s" to 1)
        t9EnMap.append(15, "t,u,v" to 1)
        t9EnMap.append(16, "w,x,y,z" to 1)
        t9EnMap.append(156, "-,*" to 1)
        t9EnMap.append(7, "0,_" to 1)
        t9EnMap.append(56, ".,#" to 1)
    }


    fun getLettersForKeyCode(keyCode: Int): List<String>? {
        val mapping = t9EnMap[keyCode]
        return mapping?.first?.split(",") // 取出 "a,b,c" 并按逗号分隔
    }
}