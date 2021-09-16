package com.kevin.easyaudiorecord.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.util.SparseArray
import android.view.View.OnLongClickListener
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * author : Android 轮子哥
 * github : https://github.com/getActivity/AndroidProject
 * time   : 2018/10/18
 * desc   : RecyclerView 适配器基类
 */
abstract class BaseAdapter<VH : BaseAdapter<VH>.ViewHolder?>(
    /** 上下文对象  */
    private val mContext: Context
) : RecyclerView.Adapter<VH>(), ResourcesAction {
    /**
     * 获取RecyclerView 对象，需要在setAdapter之后绑定
     */
    /** RecyclerView 对象  */
    var recyclerView: RecyclerView? = null
        private set

    /** 条目点击监听器  */
    private var mItemClickListener: OnItemClickListener? = null

    /** 条目长按监听器  */
    private var mItemLongClickListener: OnItemLongClickListener? = null

    /** 条目子 View 点击监听器  */
    private var mChildClickListeners: SparseArray<OnChildClickListener>? = null

    /** 条目子 View 长按监听器  */
    private var mChildLongClickListeners: SparseArray<OnChildLongClickListener>? = null

    /** ViewHolder 位置偏移值  */
    private var mPositionOffset = 0
    override fun onBindViewHolder(holder: VH, position: Int) {
        // 根据 ViewHolder 绑定的位置和传入的位置进行对比
        // 一般情况下这两个位置值是相等的，但是有一种特殊的情况
        // 在外层添加头部 View 的情况下，这两个位置值是不对等的
        if (holder != null) {
            mPositionOffset = position - holder.adapterPosition
        }
        holder?.onBindView(position)
    }

    override fun getContext(): Context {
        return mContext
    }

    /**
     * 条目 ViewHolder，需要子类 ViewHolder 继承
     */
    abstract inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, OnLongClickListener {
        constructor(@LayoutRes id: Int) : this(
            LayoutInflater.from(context).inflate(id, recyclerView, false)
        )

        /**
         * 数据绑定回调
         */
        abstract fun onBindView(position: Int)// 这里解释一下为什么用 getLayoutPosition 而不用 getAdapterPosition
        // 如果是使用 getAdapterPosition 会导致一个问题，那就是快速点击删除条目的时候会出现 -1 的情况，因为这个 ViewHolder 已经解绑了
        // 而使用 getLayoutPosition 则不会出现位置为 -1 的情况，因为解绑之后在布局中不会立马消失，所以不用担心在动画执行中获取位置有异常的情况
        /**
         * 获取 ViewHolder 位置
         */
        private val viewHolderPosition: Int
            get() =// 这里解释一下为什么用 getLayoutPosition 而不用 getAdapterPosition
            // 如果是使用 getAdapterPosition 会导致一个问题，那就是快速点击删除条目的时候会出现 -1 的情况，因为这个 ViewHolder 已经解绑了
                // 而使用 getLayoutPosition 则不会出现位置为 -1 的情况，因为解绑之后在布局中不会立马消失，所以不用担心在动画执行中获取位置有异常的情况
                layoutPosition + mPositionOffset

        /**
         * [View.OnClickListener]
         */
        override fun onClick(view: View) {
            val position = viewHolderPosition
            if (position < 0 || position >= itemCount) {
                return
            }
            if (view === itemView) {
                if (mItemClickListener != null) {
                    mItemClickListener!!.onItemClick(recyclerView, view, position)
                }
                return
            }
            if (mChildClickListeners != null) {
                val listener = mChildClickListeners!![view.id]
                listener?.onChildClick(recyclerView, view, position)
            }
        }

        /**
         * [View.OnLongClickListener]
         */
        override fun onLongClick(view: View): Boolean {
            val position = viewHolderPosition
            if (position < 0 || position >= itemCount) {
                return false
            }
            if (view === itemView) {
                return if (mItemLongClickListener != null) {
                    mItemLongClickListener!!.onItemLongClick(recyclerView, view, position)
                } else false
            }
            if (mChildLongClickListeners != null) {
                val listener = mChildLongClickListeners!![view.id]
                if (listener != null) {
                    return listener.onChildLongClick(recyclerView, view, position)
                }
            }
            return false
        }

        val itemView: View
            get() = itemView

        private fun <V : View?> findViewById(@IdRes id: Int): V {
            return itemView.findViewById(id)
        }

        init {

            // 设置条目的点击和长按事件
            if (mItemClickListener != null) {
                itemView.setOnClickListener(this)
            }
            if (mItemLongClickListener != null) {
                itemView.setOnLongClickListener(this)
            }

            // 设置条目子 View 点击事件
            if (mChildClickListeners != null) {
                for (i in 0 until mChildClickListeners!!.size()) {
                    val childView: View = findViewById(
                        mChildClickListeners!!.keyAt(i)
                    )
                    childView.setOnClickListener(this)
                }
            }

            // 设置条目子 View 长按事件
            if (mChildLongClickListeners != null) {
                for (i in 0 until mChildLongClickListeners!!.size()) {
                    val childView: View = findViewById(
                        mChildLongClickListeners!!.keyAt(i)
                    )
                    childView.setOnLongClickListener(this)
                }
            }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
        // 判断当前的布局管理器是否为空，如果为空则设置默认的布局管理器
        if (recyclerView.layoutManager == null) {
            val layoutManager: RecyclerView.LayoutManager = generateDefaultLayoutManager(mContext)
            recyclerView.layoutManager = layoutManager
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = null
    }

    /**
     * 生成默认的布局摆放器
     */
    private fun generateDefaultLayoutManager(context: Context?): RecyclerView.LayoutManager {
        return LinearLayoutManager(context)
    }

    /**
     * 设置 RecyclerView 条目点击监听
     */
    fun setOnItemClickListener(listener: OnItemClickListener?) {
        checkRecyclerViewState()
        mItemClickListener = listener
    }

    /**
     * 设置 RecyclerView 条目子 View 点击监听
     */
    fun setOnChildClickListener(@IdRes id: Int, listener: OnChildClickListener) {
        checkRecyclerViewState()
        if (mChildClickListeners == null) {
            mChildClickListeners = SparseArray()
        }
        mChildClickListeners!!.put(id, listener)
    }

    /**
     * 设置RecyclerView条目长按监听
     */
    fun setOnItemLongClickListener(listener: OnItemLongClickListener?) {
        checkRecyclerViewState()
        mItemLongClickListener = listener
    }

    /**
     * 设置 RecyclerView 条目子 View 长按监听
     */
    fun setOnChildLongClickListener(@IdRes id: Int, listener: OnChildLongClickListener) {
        checkRecyclerViewState()
        if (mChildLongClickListeners == null) {
            mChildLongClickListeners = SparseArray()
        }
        mChildLongClickListeners!!.put(id, listener)
    }

    private fun checkRecyclerViewState() {
        check(recyclerView == null) {
            // 必须在 RecyclerView.setAdapter() 之前设置监听
            "are you ok?"
        }
    }

    /**
     * RecyclerView 条目点击监听类
     */
    interface OnItemClickListener {
        /**
         * 当 RecyclerView 某个条目被点击时回调
         *
         * @param recyclerView      RecyclerView 对象
         * @param itemView          被点击的条目对象
         * @param position          被点击的条目位置
         */
        fun onItemClick(recyclerView: RecyclerView?, itemView: View?, position: Int)
    }

    /**
     * RecyclerView 条目长按监听类
     */
    interface OnItemLongClickListener {
        /**
         * 当 RecyclerView 某个条目被长按时回调
         *
         * @param recyclerView      RecyclerView 对象
         * @param itemView          被点击的条目对象
         * @param position          被点击的条目位置
         * @return                  是否拦截事件
         */
        fun onItemLongClick(recyclerView: RecyclerView?, itemView: View?, position: Int): Boolean
    }

    /**
     * RecyclerView 条目子 View 点击监听类
     */
    interface OnChildClickListener {
        /**
         * 当 RecyclerView 某个条目 子 View 被点击时回调
         *
         * @param recyclerView      RecyclerView 对象
         * @param childView         被点击的条目子 View
         * @param position          被点击的条目位置
         */
        fun onChildClick(recyclerView: RecyclerView?, childView: View?, position: Int)
    }

    /**
     * RecyclerView 条目子 View 长按监听类
     */
    interface OnChildLongClickListener {
        /**
         * 当 RecyclerView 某个条目子 View 被长按时回调
         *
         * @param recyclerView      RecyclerView 对象
         * @param childView         被点击的条目子 View
         * @param position          被点击的条目位置
         */
        fun onChildLongClick(recyclerView: RecyclerView?, childView: View?, position: Int): Boolean
    }

//    init {
//        if (mContext == null) {
//            throw IllegalArgumentException("are you ok?")
//        }
//    }
}