package com.infinite.massiveprojectmobilezwh

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
        @SerializedName("refresh_token")
        @Expose
        var refresh_token : String? = null

        @SerializedName("access_token")
        @Expose
        var access_token : String? = null

        @SerializedName("user")
        @Expose
        var user: User? = null

        @SerializedName("message")
        @Expose
        var message: String? = null

        class User {

                @SerializedName("name")
                @Expose
                var name : String? = null

                @SerializedName("uuid")
                @Expose
                var uuid : String? = null

                @SerializedName("email")
                @Expose
                var email : String? = null

                @SerializedName("role")
                @Expose
                var role : String? = null

                @SerializedName("points")
                @Expose
                var points : String? = null

        }
    }
