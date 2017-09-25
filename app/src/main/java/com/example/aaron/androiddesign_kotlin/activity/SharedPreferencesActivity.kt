package com.example.aaron.androiddesign_kotlin.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.view.View
import com.example.aaron.androiddesign_kotlin.R
import com.example.aaron.androiddesign_kotlin.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_shared_preferences.*


class SharedPreferencesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        etKey.apply {
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //检测错误输入，当输入错误时，hint会变成红色并提醒
                    //检查实际是否匹配，由自己实现
                    if (p0.toString().length > 10) {
                        error = "长度不能大于10"
                    }
                    return
                }

            })
        }
        btnSave.setOnClickListener {
            if (etKey?.length() == 0 || etValue?.length() == 0) {
                etKey.error = "请输入KEY和VALUE，不允许为空!"
                return@setOnClickListener
            }
            SharedPreferencesUtils(this).setString(etKey?.text.toString(), etValue?.text.toString())
//            Toast.makeText(this,"保存KEY、VALUE值成功！",Toast.LENGTH_LONG).show()
            Snackbar.make(window.decorView, "保存KEY、VALUE值成功！", Snackbar.LENGTH_LONG).apply {
                show()
                setAction("关闭", View.OnClickListener {
                    this.dismiss()
                })
            }
        }

        btnGet.apply {
            setOnClickListener {
                val editable = SpannableStringBuilder(SharedPreferencesUtils(this@SharedPreferencesActivity).getString(etKey.text.toString(), ""))
                etValue.text = editable
            }
        }

        btnReset.setOnClickListener {
            etKey.text = SpannableStringBuilder("")
            etValue.text = SpannableStringBuilder("")
        }
    }
}
