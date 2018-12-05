package com.codecool.battleofcards.card.comparator;

import com.codecool.battleofcards.card.Card;
import java.util.Comparator;

/**
* This class is used to compare Card objects by given attribute nuber.
*/
public class CardComparator implements Comparator<Card> {
    private final int ATTRIBUTE_NUMBER;

    /**
     * Constructor of CardComparator.
     * <p>Recives attributeNumber.
     * @param  attributeNumber number of attribute of Card object.
     */
    public CardComparator(int attributeNumber) {
        this.ATTRIBUTE_NUMBER = attributeNumber;
    }

    /**
     * Compares cardAttribute of Card object.
     * @param  card      card to compare
     * @param  otherCard to compare with
     * @return           1 if card > other, -1 if card < other , 0 if equals
     */
    @Override
    public int compare(Card card, Card otherCard) {
        if (card.getAttributeValue(this.ATTRIBUTE_NUMBER) > otherCard.getAttributeValue(this.ATTRIBUTE_NUMBER)) {
            return 1;
        } else if (card.getAttributeValue(this.ATTRIBUTE_NUMBER) < otherCard.getAttributeValue(this.ATTRIBUTE_NUMBER)) {
            return -1;
        } else {
            return 0;
        }
    }
}
