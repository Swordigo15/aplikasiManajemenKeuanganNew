package com.example.keuangan

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterResponse {
    @SerializedName("data")
    @Expose
    var data : User? = null

    class User{
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
}