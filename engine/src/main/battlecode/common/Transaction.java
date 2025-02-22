package battlecode.common;

public class Transaction implements Comparable<Transaction> {

    /**
     * The cost of the transaction.
     */
    private final int cost;

    /**
     * The message of the transaction.
     */
    private final int[] message;

    /**
     * The serialized message of the transaction.
     */
    private final String serializedMessage;

    public Transaction(int cost, int[] message) {
        this.cost = cost;
        this.message = message;

        // Serialize the message
        String[] stringMessageArray = new String[message.length];
        for (int i = 0; i < message.length; i++) {
            stringMessageArray[i] = Integer.toString(message[i]);
        }
        this.serializedMessage = String.join("_", stringMessageArray);
    }

    // *********************************
    // ***** GETTER METHODS ************
    // *********************************

    public int getCost()
    {
        return this.cost;
    }

    public int[] getMessage()
    {
        return this.message.clone();
    }

    public String getSerializedMessage()
    {
        return this.serializedMessage;
    }


    /**
     * Transactions with higher cost have higher priority.
     */
    @Override
    public int compareTo(Transaction other) {
        return other.cost - this.cost;
    }
}
