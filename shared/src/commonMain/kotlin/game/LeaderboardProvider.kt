package game

interface LeaderboardProvider {
    fun getLeaderboard(): Leaderboard
}