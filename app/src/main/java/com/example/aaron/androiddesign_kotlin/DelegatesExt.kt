package com.example.aaron.androiddesign_kotlin

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * 1.
 * 它只能被赋值一次，如果第二次赋值，它就会抛异常
 * ReadOnlyProperty 和 ReadWriteProperty 。具体取决于我们被委托的对象是 val 还是 var
 */
private class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("是我啊NotNullSingleValueVar，not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else throw IllegalStateException("是我啊NotNullSingleValueVar，already initialized ")
    }
}


/**
 * 2.
 * 现在你可以创建一个对象，然后添加函数使用你的委托：
 * Created by aaron on 2017/9/29.
 */
object DelegatesExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}