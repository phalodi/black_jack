package org.blackjack.services

import org.blackjack.models._
import scala.collection.mutable.ListBuffer

class Deck {

  val deck = new ListBuffer[Card]

  def initializeDeck = for {
    suit <- List(Heart,Spade,Club,Diamond)
    rank <- List(Ace,King,Queen,Jack,Ten,Nine,Eight,Seven,Six,Five,Four,Three,Two)
  } yield deck :+ Card(suit,rank)

  def shuffle = scala.util.Random.shuffle(initializeDeck)
}
