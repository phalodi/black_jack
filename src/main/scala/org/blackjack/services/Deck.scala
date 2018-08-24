package org.blackjack.services

import org.blackjack.models._
import scala.collection.mutable.ListBuffer

class Deck {

  val deck = new ListBuffer[Card]

  def initializeDeck: List[ListBuffer[Card]] = for {
    suit <- List(Heart,Spade,Club,Diamond)
    rank <- List(Ace,King,Queen,Jack,Ten,Nine,Eight,Seven,Six,Five,Four,Three,Two)
  } yield deck :+ Card(suit,rank)

  def shuffle: List[ListBuffer[Card]] = scala.util.Random.shuffle(initializeDeck)

  def dealCard: Option[Card] = {
    if(deck.nonEmpty) {
        val card = deck.head
        deck -= card
        Some(card)
    } else
      None
  }
}
