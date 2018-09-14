package org.blackjack.services

import org.blackjack.models.{Ace, Card}

import scala.collection.mutable.ListBuffer

class Hand {

  val winningValue= 21

  val hand = new ListBuffer[Card]

  def hasACE(): Boolean ={
    hand.contains(Ace)
  }

  //
  def handValue: Int = {
    hand.foldLeft(0)(_ + _.rank.value)
  }

  def specialHandValue: Int = {
    if(hasACE())
      handValue + 10
    handValue
  }

  def addCardToHand(card: Card): ListBuffer[Card] = {
    hand += card
  }

  def isBlackJack: Boolean = {
    (specialHandValue == winningValue) || (handValue == winningValue)
  }

  def bustHand: Boolean = {
    handValue > winningValue
  }
}
