package org.blackjack.services

import org.blackjack.models._
import scala.collection.mutable.ListBuffer

object Deck {

  val deck = shuffle

  def initializeDeck: ListBuffer[Card] = for {
    suit <- ListBuffer(Heart,Spade,Club,Diamond)
    rank <- ListBuffer(Ace,King,Queen,Jack,Ten,Nine,Eight,Seven,Six,Five,Four,Three,Two)
  } yield Card(suit,rank)

  def shuffle: ListBuffer[Card] = scala.util.Random.shuffle(initializeDeck)

  def dealCard: Option[Card] = {
    if(deck.nonEmpty) {
        val card = deck.head
        deck -= card
        Some(card)
    } else
      None
  }
}
