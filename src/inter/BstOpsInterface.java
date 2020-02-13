package inter;

import java.util.List;

/*
 * API that the tests expect the candidate's BST implementation to support.
 * Candidates:  You should NOT make any changes to this API, or your Coding Test will not be a success.
 */

public interface BstOpsInterface {

	/*
	 * init the Bst with an input array
	 *
	 * @return          void
	 */

	void init(int[] values);

	/*
	 * Clear the Bst
	 *
	 * @return          void
	 */

	void clear();

	/*
	 * search the Bst for a specific value & return a list of index positions where the value occurs in the original
	 * array that was used to construct the Bst
	 *
	 * @return          list of index positions where value occurred in original array.
	 *                  Can be empty list if value not found in BST
	 */

	List<Integer> search(int value);

	/*
	 * Returns values in the nodes of the Bst - any (random, in-order, post-order or pre-order) order is OK
	 *
	 * @return          list of values (potentially empty) stored in BST
	 *
	 */

	List<Integer> getBstValues();


	/*
	 * Returns the values in the nodes of the Bst using In Order Traversal specifically.
	 * As an example of InOrder,  if a Parent A has 2 children, B (left) and C(right),  InOrder traversal would
	 * return the list B, A, C in that order.
	 *
	 * @return          list of values (potentially empty) stored in BST traversed in InOrder
	 *
	 */

	List<Integer> getBstValuesInOrder();
}
