package org.blackjack

import org.blackjack.services.{Deck, Hand}

object BlackJack extends App {

  val heart = "\u2764"
  val diamond = "\u2764"
  val spade = "\u2764"
  val club = "\u2764"

  startPlaying

  def startPlaying = {
    var dealerHand = new Hand
    var playerHand = new Hand
    var continueGame = true
    val deck = Deck.deck

    println("Let's start the game. Are you in? say yes...PLEASE")

    val wouldYouStart = scala.io.StdIn.readLine()

    if(wouldYouStart.toLowerCase.startsWith("y")){
      Deck.dealCard.map(dealerHand.addCardToHand(_))
      Deck.dealCard.map(playerHand.addCardToHand(_))
    }

    while(continueGame || playerHand.handValue > playerHand.winningValue) {

      println("Player cards: " + showPlayerCards + "\n" + "Dealer cards: " + showDealerCards)


      println("Hit or stand? (h, s)")
      val hitOrStand = scala.io.StdIn.readLine()


      if(hitOrStand == "h" || hitOrStand == "H"){
        println(Console.MAGENTA + "Another card coming your way" + Console.RESET)


        Deck.dealCard.map(playerHand.addCardToHand(_))

        if(playerHand.bustHand){
          println(Console.RED + "BUSTEDDD!!" + Console.RESET)
          continueGame = false
        }

        if(playerHand.isBlackJack){
          println(Console.GREEN + "BLACK JACKKK!!!!!" + Console.RESET)
          continueGame = false
        }

      }else{
        while(dealerHand.handValue <18){

          println(Console.MAGENTA + "Dealer card: " + Console.RESET)

          Thread.sleep(1000)

          Deck.dealCard.map(dealerHand.addCardToHand(_))

          println("Player cards: " + showPlayerCards + "\n" + "Dealer cards: " + showDealerCards)

        }
        continueGame = false
        println(Console.MAGENTA + "Let's see how you did" + Console.RESET)


        println("Player cards: " + showPlayerCards + "\n" + "Dealer cards: " + showDealerCards)

        whoWon
      }
    }

    def whoWon = {
      if(dealerHand.bustHand) println(Console.GREEN + "You win!...this time!" + Console.RESET)
      else if(playerHand.handValue > dealerHand.handValue) println(Console.GREEN + "You got lucky this time." + Console.RESET)
      else println(Console.RED + "Dealer wins!...this time!" + Console.RESET)
    }

    def showPlayerCards = {
      playerHand.hand.map(_.rank.getClass.getSimpleName) mkString(", ")
    }

    def showDealerCards = {
      dealerHand.hand.map(_.rank.getClass.getSimpleName) mkString(", ")
    }


  }

}
