package com.yuyan.imemodule.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.emoji2.widget.EmojiTextView
import androidx.recyclerview.widget.RecyclerView
import com.yuyan.imemodule.R
import com.yuyan.imemodule.data.theme.ThemeManager.activeTheme
import com.yuyan.imemodule.utils.StringUtils.sbc2dbcCase

/**
 * 拼音选择
 */
class PinYinAdapter(context: Context?, private val mDatas: Array<String>) :
    RecyclerView.Adapter<PinYinAdapter.SymbolTypeHolder>() {
    var select: Int = -1
        private set
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val textColor: Int = activeTheme.keyTextColor

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymbolTypeHolder {
        val view = inflater.inflate(R.layout.item_pin_yin, parent, false)
        return SymbolTypeHolder(view)
    }

    override fun onBindViewHolder(holder: SymbolTypeHolder, position: Int) {
        holder.tvSymbolType.text = sbc2dbcCase(mDatas[position])
        holder.tvSymbolType.setTextColor(if(select == position) activeTheme.accentKeyBackgroundColor else activeTheme.keyTextColor)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    fun updateAddSelect() {
        if (select < mDatas.size - 1) {
            select++
            notifyChanged()
        }
    }

    fun updateMinSelect() {
        if (select > 0) {
            select--
            notifyChanged()
        }
    }

    fun updateRestSelect() {
        select = -1
        notifyChanged()
    }

    fun isCurrentKeySelectPinyin(): Boolean{
        return select >= 0 && mDatas.isNotEmpty()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun notifyChanged() {
        notifyDataSetChanged()
    }

    inner class SymbolTypeHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvSymbolType: EmojiTextView = view.findViewById(android.R.id.text1)
        init {
            tvSymbolType = view.findViewById(android.R.id.text1)
            tvSymbolType.setTextColor(textColor)
        }
    }
}
