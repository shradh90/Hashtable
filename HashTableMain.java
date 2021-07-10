public class HashTableMain {
    public static void main(String[] args) {
        HashtableImpl<String, Integer> hashImpl = new HashtableImpl();
        String message = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately into paranoid avoidable situations";

        //String to String[] conversion.
        //Split the words when a white space comes up.
        //Convert all the words in lowercase
        String[] messageArray = message.toLowerCase().split(" ");

        //Iterate within the array
        for(String word: messageArray) {
            //Search for the word in the hashtable
            Integer value =  hashImpl.get(word);
            //If not found, frequency of the word remains 1
            if( value == null)
                value = 1;
            else
                //If found, frequency of the word increases by 1
                value = value + 1;
            hashImpl.add(word , value);
        }
        //Display the hashtable
        System.out.println(hashImpl);

        //Remove "avoidable" from the hashtable
        hashImpl.remove("avoidable");

        //Display the hashtable
        System.out.println(hashImpl);
    }

}
