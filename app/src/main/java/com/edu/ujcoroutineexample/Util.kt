package com.edu.ujcoroutineexample

import android.content.Context
import android.widget.Toast

/**
 * Project Name: KotlinCoroutineExample
 * Created by Umesh Jangid
 * on 21,October,2019
 * @ NIC Ltd
 */


//Show Toast
fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
