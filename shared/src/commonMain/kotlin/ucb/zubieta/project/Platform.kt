package ucb.zubieta.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform