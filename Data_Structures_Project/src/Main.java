import java.util.*;

public class Main {
    public static void main(String[] args) {

        // PART 1: Sorting Arrays
        /*
        US states and their capital will be stored in a 2D array in order by state name
        Bubble sort will be used to rearrange the array in order by capital name
        The user will then be able to enter as many capitals as they can and a total correct count will be displayed
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("--American State Capitals-- by Brandon McCormack");
        System.out.println();
        System.out.println("Press spacebar to display all US states and their capitals:");
        System.out.print(">");

        // Pause until user presses spacebar
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals(" ")) {
                System.out.println("Displaying all US states and their capitals...");
                break;
            } else {
                System.out.println("Press spacebar to continue:");
                System.out.print(">");
            }
        }
        String[][] stateCapitals = {
                {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
                {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"},
        };

        // Call the method to print the array (method is outside the main method)
        printArray(stateCapitals);
        System.out.println();
        System.out.println("Here are the US states and their capitals arranged by state and stored in a 2D array.");
        System.out.println();
        System.out.println("Next the list will be arranged by capitals using a bubble sort");
        System.out.println("Press spacebar to continue:");
        System.out.print(">");

        // Pause until the user types spacebar
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equals(" ")) {
                break;
            }else {
                System.out.println("Press spacebar to continue:");
                System.out.print(">");
            }
        }

        // Call the bubble sort method to sort by capital
        bubbleSort(stateCapitals);

        // Print the sorted array to ensure effectiveness
        printArray(stateCapitals);

        System.out.println();
        System.out.println("Here is the list arranged by capital name. Now let's test your knowledge!");
        System.out.println("Please enter as many state capitals as you can");
        System.out.println("When you are finished, type \"end\" and I will be counting your correct answers");

        // Sub array of capitals is defined to be searched
        String[] capitals = stateCapitals[1];
        int correctCount = 0;

        // Loop until the user enters "end"
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("end")) {
                break;
            }

            // Use for loop to search for a match in the row of capitals
            for (String capital : capitals) {
                if (capital.equalsIgnoreCase(userInput)) {
                    correctCount += 1;
                    System.out.println("Correct, " + userInput + " is a US capital!");
                    System.out.println("Total correct count = " + correctCount);
                    break;
                }
            }
        }

        // PART 2: Sorting & Searching HashMap
        /*
        Data from the 2D array will be converted to a HashMap and sorted by the TreeMap class
        The key-value pairs will be stored in a binary search tree
        The user will then be able to enter a state and it's corresponding capital will be displayed
         */

        // Create a Hashmap to store the array
        HashMap<String, String> hashCapitals = new HashMap<String, String>();

        // Iterate over the array to store each element to the HashMap
        for (int i = 0; i < stateCapitals[0].length; i++) {
            hashCapitals.put(stateCapitals[0][i], stateCapitals[1][i]);
        }

        // Call the print HashMap Method
        printHashMap(hashCapitals);
        System.out.println();
        System.out.println("Here is the list once again, but this time it is stored in a HashMap!");
        System.out.println();
        System.out.println("Now enter a state name and I will tell you it's capital:");
        System.out.println("When you are finished, type \"end\" to terminate the program");

        // Store the HashMap in a binary search tree using the TreeMap class
        TreeMap<String, String> treeMapCapitals = new TreeMap<>(hashCapitals);

        // Search the TreeMap by displaying the capital of a user input state name
        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("end"))
                break;
            // Search the binary search tree for a state name and display it's capital
            if (treeMapCapitals.containsKey(userInput)) {
                System.out.println("The capital of " + userInput + " is: " + treeMapCapitals.get(userInput));
            } else
                System.out.println("Sorry I don't recognize that state");
        }
    }
    public static void printArray(String[][] array) {
        // Display the contents of the array using a for loop
        for (int i = 0; i < array[0].length; i++) {
            String state = array[0][i];
            String capital = array[1][i];
            System.out.println("State: " + state + " -&- Capital: " + capital);
        }
    }
    public static void bubbleSort(String[][] array) {
        int columns = array[0].length;
        String tempCity;
        String tempState;
        // Outer loop iterates through each column
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns - 1; j++){
                // Compare each capital to the next entry using the "compareTo" Java method
                if (array[1][j].compareTo(array[1][j + 1]) > 0) {
                    // If needed, swap the capitals keeping them in the second row
                    tempCity = array[1][j];
                    array[1][j] = array[1][j + 1];
                    array[1][j + 1] = tempCity;

                    // Swap the states in the first row to keep their match with the capital
                    tempState = array[0][j];
                    array[0][j] = array[0][j + 1];
                    array[0][j + 1] = tempState;
                }
            }
        }
    }
    public static void printHashMap(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {

            String state = entry.getKey();
            String capital = entry.getValue();
            System.out.println("State: " + state + " -&- Capital: " + capital);
        }
    }
}