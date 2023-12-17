package com.example.keuangan

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterRequest {

    @SerializedName("email")
    @Expose
    var email : String? = null

    @SerializedName("password")
    @Expose
    var password: String? =null

    @SerializedName("no_hp")
    @Expose
    var no_hp: String? =null
}