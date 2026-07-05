import java.util.Stack;
import java.util.Scanner;

public class browsing_history_using_stack {
    public static void main(String[] args) {
        Stack<String> browsingHistory = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Browsing History Manager =====");
        System.out.println("Commands: 'visit <url>', 'back', 'history', 'quit'\n");
        
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting...");
                break;
            } 
            else if (input.equalsIgnoreCase("history")) {
                if (browsingHistory.isEmpty()) {
                    System.out.println("No browsing history yet.\n");
                } else {
                    System.out.println("Current Browsing History: " + browsingHistory + "\n");
                }
            } 
            else if (input.equalsIgnoreCase("back")) {
                if (browsingHistory.isEmpty()) {
                    System.out.println("No history to go back to.\n");
                } else {
                    String lastVisited = browsingHistory.pop();
                    System.out.println("Going back from: " + lastVisited);
                    if (!browsingHistory.isEmpty()) {
                        System.out.println("Now at: " + browsingHistory.peek());
                    } else {
                        System.out.println("No more pages in history.\n");
                    }
                }
            } 
            else if (input.toLowerCase().startsWith("visit ")) {
                String url = input.substring(6).trim();
                if (!url.isEmpty()) {
                    browsingHistory.push(url);
                    System.out.println("Visited: " + url + "\n");
                } else {
                    System.out.println("Please provide a URL.\n");
                }
            } 
            else {
                System.out.println("Invalid command. Try 'visit <url>', 'back', 'history', or 'quit'.\n");
            }
        }
        
        scanner.close();
    }
}
