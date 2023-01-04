package com.valu.assignment.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.skyfishjy.library.RippleBackground
import com.valu.assignment.R
import java.util.*


object UiUtils {

    private val TAG = UiUtils::class.java.simpleName
    private var loadingDialog: Dialog? = null

    fun showShortToast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(context: Context?, message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showErrorDialog(context: Context, msg: String) {
        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            //setIcon(R.drawable.ic_hello)
            setTitle(context.getString(R.string.app_name))
            setMessage(msg)
            setPositiveButton(context.getString(R.string.STR_OK)) { d: DialogInterface?, _: Int ->
                d?.dismiss()
            }
        }.create().show()
    }

    fun showLoadingDialog(context: Context?) {
        loadingDialog = Dialog(context!!)
        loadingDialog!!.setCancelable(false)
        loadingDialog!!.setContentView(R.layout.api_loading_lottie)
        if (!loadingDialog!!.isShowing) loadingDialog!!.show()
    }

    fun hideLoadingDialog() {
        try {
            if (loadingDialog != null && loadingDialog!!.isShowing)
                loadingDialog!!.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}