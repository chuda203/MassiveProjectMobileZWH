package com.infinite.massiveprojectmobilezwh

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("name")
    @Expose
    var name : String? = null

    @SerializedName("email")
    @Expose
    var email : String? = null

    @SerializedName("password")
    @Expose
    var password : String? = null
}