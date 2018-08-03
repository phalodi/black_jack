package org.blackjack.services

import org.blackjack.models._

class Deck {


  def initializeDeck = for {
    suit <- List(Heart,Spade,Club,Diamond)
    rank <- List(Ace,King,Queen,Jack,Ten,Nine,Eight,Seven,Six,Five,Four,Three,Two)
  } yield new Card(suit,rank)

  def shuffle = ???
}
