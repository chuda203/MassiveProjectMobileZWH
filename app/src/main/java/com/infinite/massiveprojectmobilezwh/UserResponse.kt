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

        class User {

                @SerializedName("name")
                @Expose
                var name : String? = null
        }
    }
