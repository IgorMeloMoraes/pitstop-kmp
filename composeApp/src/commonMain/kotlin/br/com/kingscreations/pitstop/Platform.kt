package br.com.kingscreations.pitstop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform