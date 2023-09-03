package com.uoa.hbfea.utility

class TokenGenerator {
    companion object{
        fun generateRandomString(length: Int): String {
            val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
            return (1..length)
                .map { charset.random() }
                .joinToString("")
        }
    }

}