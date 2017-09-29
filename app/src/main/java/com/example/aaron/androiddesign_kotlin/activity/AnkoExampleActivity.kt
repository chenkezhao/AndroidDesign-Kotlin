package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import com.example.aaron.androiddesign_kotlin.R
import kotlinx.android.synthetic.main.activity_anko_example.*
import org.jetbrains.anko.*
import java.util.*

/**\
 * https://github.com/Kotlin/anko/wiki/Anko-Commons-%E2%80%93-Dialogs
 * https://github.com/Kotlin/anko/wiki/Anko-SQLite
 */
class AnkoExampleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko_example)


        btnToast.apply {
            setOnClickListener {
                toast("anko吐司")
                alert("这个是个短的吐司啊", "我是alert dialogs") {
                    yesButton { toast("很好！") }
                    noButton {}
                }.show()
            }
            setOnLongClickListener {
                longToast("长时间anko吐司")
                alert {
                    customView = layoutInflater.inflate(R.layout.alert_custom_view, null)
//                    yesButton { toast("自定义View，很好！") }
//                    noButton {}
                }.show()
                true
            }
        }

        btnSelectors.apply {
            setOnClickListener {
                val countries = listOf("Russia", "USA", "Japan", "Australia")
                selector("Where are you from?", countries, { dialogInterface, i ->
                    toast("So you're living in ${countries[i]}, right?")
                })
            }
        }

        var pro = 0
        btnPro.apply {
            setOnClickListener {
                /*val dialog = */progressDialog(message = "请耐心等待…", title = "同步数据").apply {
                setCancelable(false)//不能手动取消进度
                max = 100
                Timer().schedule(object : TimerTask() {
                    override fun run() {
                        pro++
                        progress = pro
                        if (progress == max) {
                            dismiss()
                            pro = 0
                            cancel()
                        }
                    }
                }, 0, 100)
            }
            }
        }
    }
}
