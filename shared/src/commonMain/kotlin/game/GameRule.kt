package game

interface GameRule {
    fun decideWhoWin(card1: Card, card2: Card): Int
}