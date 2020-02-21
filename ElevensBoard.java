package javaapplication1;
import java.util.List;
import java.util.ArrayList;


/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
                boolean isLegal = false; //assuming the selected cards is not legal
                //First we check if there is pair(two) of cards or group of 3 cards
               
                if(selectedCards.size() == 2)
                {
                    //if there is 2 cards then when we check if their sum equal to 11 or not

                    if(this.cardAt(selectedCards.get(0)).pointValue()  + this.cardAt(selectedCards.get(1)).pointValue() == 11)
                    {
                        isLegal = true;
                    }
                   
                } 
                if(selectedCards.size() == 3)
                {
                    //if there is 3 cards then they all should be non-face, whose values
                    //in POINT_VALUE is 0 
                    //if they all are 0 then their sum should also be zero
                    //if sum is zero then it is legal else not
                    if(this.cardAt(selectedCards.get(0)).pointValue() + this.cardAt(selectedCards.get(1)).pointValue() + this.cardAt(selectedCards.get(2)).pointValue() == 0)
                    {
                        isLegal = true;
                    }
                }
            return isLegal;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
                //Here we check 9 cards of board (cards can be less than 9 at the end of winning game) whether they have
                //2 non-face cards or 3 jack,queen,king
                //if they have then anotherPlayIsPossible return true
                //else false
                List<Integer> cardsOnBoard = new ArrayList<Integer>(); //this contain the POINT_VALUE of cards present on board
                //then we check by passing it in containsPairSum11 and containsJQK 
                //to check if another play is possible or not
                for(int i=0; i<this.size(); i++)
                {
                    //this.size is board size
                    cardsOnBoard.add(this.cardAt(i).pointValue());
                }
                if(containsPairSum11(cardsOnBoard) == true || containsJQK(cardsOnBoard) == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
                boolean containPair = false; //asuming it does not contain pair 
                for(int i=0; i<selectedCards.size() && !containPair; i++)
                {
                    for(int j=0; j<selectedCards.size() && !containPair; j++)
                    {
                        if(selectedCards.get(i) + selectedCards.get(j) == 11)
                        {
                            containPair = true;
                        }
                    }
                }
                return containPair;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
                //Here we check if kist contains 3 cards with 0 POINT_VALUE i.e Jack,Queen,King
                //If they have 3 then they contain JQK else not
                int JQK = 0;
                for(int i=0; i<selectedCards.size(); i++)
                {
                    if(selectedCards.get(i) == 0)
                    {
                        JQK = JQK + 1;
                    }
                }
                if(JQK == 3)
                {
                    return true;
                }
                else
                {
                    return false;
                }
          
	}
}
