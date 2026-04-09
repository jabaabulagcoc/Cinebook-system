import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    // users
    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<String> emails = new ArrayList<>();
    static ArrayList<String> roles = new ArrayList<>();
    static ArrayList<Double> balances = new ArrayList<>();
    static ArrayList<ArrayList<String>> allTickets = new ArrayList<>();

    // movies
    static ArrayList<String> movieTitles = new ArrayList<>();
    static ArrayList<String> movieGenres = new ArrayList<>();
    static ArrayList<String> movieDescs = new ArrayList<>();
    static ArrayList<Integer> movieDurations = new ArrayList<>();
    static ArrayList<Integer> movieYears = new ArrayList<>();
    static ArrayList<Double> moviePrices = new ArrayList<>();

    // logged in user index, -1 means no one is logged in
    static int loggedInIndex = -1;

    public static void main(String[] args) {

        // add default users
        usernames.add("admin");
        passwords.add("Admin1234");
        emails.add("admin@cinebook.com");
        roles.add("ADMIN");
        balances.add(0.0);
        allTickets.add(new ArrayList<>());

        usernames.add("john.doe");
        passwords.add("JohnPass1");
        emails.add("john@gmail.com");
        roles.add("USER");
        balances.add(500.0);
        allTickets.add(new ArrayList<>());

        usernames.add("maria");
        passwords.add("Maria2025");
        emails.add("maria@yahoo.com");
        roles.add("USER");
        balances.add(300.0);
        allTickets.add(new ArrayList<>());

        // add default movies
        movieTitles.add("Oppenheimer");
        movieGenres.add("Biography / Drama");
        movieDescs.add("The story of J. Robert Oppenheimer and the atomic bomb.");
        movieDurations.add(180);
        movieYears.add(2023);
        moviePrices.add(380.00);

        movieTitles.add("Dune: Part Two");
        movieGenres.add("Sci-Fi / Adventure");
        movieDescs.add("Paul Atreides unites with the Fremen of Arrakis to seek revenge.");
        movieDurations.add(166);
        movieYears.add(2024);
        moviePrices.add(420.00);

        movieTitles.add("The Dark Knight");
        movieGenres.add("Action / Crime");
        movieDescs.add("Batman faces the Joker who plunges Gotham City into chaos.");
        movieDurations.add(152);
        movieYears.add(2008);
        moviePrices.add(300.00);

        movieTitles.add("Interstellar");
        movieGenres.add("Sci-Fi / Drama");
        movieDescs.add("Explorers travel through a wormhole to save humanity.");
        movieDurations.add(169);
        movieYears.add(2014);
        moviePrices.add(320.00);

        movieTitles.add("Spider-Man: No Way Home");
        movieGenres.add("Action / Superhero");
        movieDescs.add("Peter Parker asks Doctor Strange for help and unleashes multiverse villains.");
        movieDurations.add(148);
        movieYears.add(2021);
        moviePrices.add(350.00);

        movieTitles.add("Everything Everywhere All at Once");
        movieGenres.add("Comedy / Sci-Fi");
        movieDescs.add("A Chinese immigrant explores alternate universes to save existence.");
        movieDurations.add(139);
        movieYears.add(2022);
        moviePrices.add(280.00);

        movieTitles.add("Avengers: Endgame");
        movieGenres.add("Action / Superhero");
        movieDescs.add("The Avengers assemble to reverse Thanos's snap and restore the universe.");
        movieDurations.add(181);
        movieYears.add(2019);
        moviePrices.add(370.00);

        movieTitles.add("Parasite");
        movieGenres.add("Thriller / Drama");
        movieDescs.add("Greed and class discrimination threaten two families in Korea.");
        movieDurations.add(132);
        movieYears.add(2019);
        moviePrices.add(260.00);

        System.out.println("==================================================");
        System.out.println("  Welcome to CineBook!");
        System.out.println("  Your cinema booking system.");
        System.out.println("==================================================");

        while (true) {
            if (loggedInIndex == -1) {
                showGuestMenu();
            } else if (roles.get(loggedInIndex).equals("ADMIN")) {
                showAdminMenu();
            } else {
                showUserMenu();
            }
        }
    }

    static void showGuestMenu() {
        System.out.println("\n==================================================");
        System.out.println("  GUEST MENU");
        System.out.println("==================================================");
        System.out.println("  1. Login");
        System.out.println("  2. Register");
        System.out.println("  3. Exit");
        System.out.println("==================================================");
        System.out.print("  Choose: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            loginUser();
        } else if (choice.equals("2")) {
            registerUser();
        } else if (choice.equals("3")) {
            System.out.println("  Goodbye!");
            System.exit(0);
        } else {
            System.out.println("  Invalid option. Try again.");
        }
    }

    static void showUserMenu() {
        System.out.println("\n==================================================");
        System.out.println("  USER MENU - " + usernames.get(loggedInIndex));
        System.out.println("  Wallet: P" + balances.get(loggedInIndex));
        System.out.println("==================================================");
        System.out.println("  1. Browse & Watch Movies");
        System.out.println("  2. My Tickets");
        System.out.println("  3. Top Up Wallet");
        System.out.println("  4. Profile");
        System.out.println("  5. Logout");
        System.out.println("==================================================");
        System.out.print("  Choose: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            browseMovies();
        } else if (choice.equals("2")) {
            viewMyTickets();
        } else if (choice.equals("3")) {
            topUpWallet();
        } else if (choice.equals("4")) {
            viewProfile();
        } else if (choice.equals("5")) {
            System.out.println("  Logging out...");
            loggedInIndex = -1;
        } else {
            System.out.println("  Invalid option.");
        }
    }

    static void showAdminMenu() {
        System.out.println("\n==================================================");
        System.out.println("  ADMIN MENU - " + usernames.get(loggedInIndex));
        System.out.println("==================================================");
        System.out.println("  1. Manage Movies");
        System.out.println("  2. View All Users");
        System.out.println("  3. Profile");
        System.out.println("  4. Logout");
        System.out.println("==================================================");
        System.out.print("  Choose: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            manageMovies();
        } else if (choice.equals("2")) {
            viewAllUsers();
        } else if (choice.equals("3")) {
            viewProfile();
        } else if (choice.equals("4")) {
            System.out.println("  Logging out...");
            loggedInIndex = -1;
        } else {
            System.out.println("  Invalid option.");
        }
    }

    static void loginUser() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  LOGIN");
        System.out.println("--------------------------------------------------");
        System.out.print("  Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("  Password: ");
        String password = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                loggedInIndex = i;
                found = true;
                System.out.println("  Welcome back, " + username + "! Role: " + roles.get(i));
                break;
            }
        }

        if (found == false) {
            System.out.println("  Invalid username or password.");
        }
    }

    static void registerUser() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  REGISTER");
        System.out.println("--------------------------------------------------");

        System.out.print("  Username: ");
        String username = scanner.nextLine().trim();

        if (username.equals("")) {
            System.out.println("  Username cannot be empty.");
            return;
        }

        // check if username already exists
        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username)) {
                System.out.println("  Username is already taken.");
                return;
            }
        }

        System.out.print("  Password: ");
        String password = scanner.nextLine();

        if (password.length() < 8) {
            System.out.println("  Password must be at least 8 characters.");
            return;
        }

        // check for uppercase
        boolean hasUpper = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpper = true;
                break;
            }
        }
        if (hasUpper == false) {
            System.out.println("  Password must have at least one uppercase letter.");
            return;
        }

        // check for digit
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }
        if (hasDigit == false) {
            System.out.println("  Password must have at least one number.");
            return;
        }

        System.out.print("  Email: ");
        String email = scanner.nextLine().trim();

        // basic email check
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("  Invalid email address.");
            return;
        }

        usernames.add(username);
        passwords.add(password);
        emails.add(email);
        roles.add("USER");
        balances.add(0.0);
        allTickets.add(new ArrayList<>());

        System.out.println("  Account created successfully! You can now login.");
    }

    static void browseMovies() {
        if (movieTitles.size() == 0) {
            System.out.println("  No movies available right now.");
            return;
        }

        while (true) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("  NOW SHOWING");
            System.out.println("--------------------------------------------------");
            for (int i = 0; i < movieTitles.size(); i++) {
                System.out.println("  [" + (i + 1) + "] " + movieTitles.get(i) + " (" + movieYears.get(i) + ")");
                System.out.println("      Genre: " + movieGenres.get(i) + " | " + movieDurations.get(i) + " min | P" + moviePrices.get(i));
            }
            System.out.println("  [0] Back");
            System.out.print("  Select a movie: ");
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                return;
            }

            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("  Please enter a number.");
                continue;
            }

            if (choice < 1 || choice > movieTitles.size()) {
                System.out.println("  Invalid selection.");
                continue;
            }

            int idx = choice - 1;
            System.out.println("\n--------------------------------------------------");
            System.out.println("  " + movieTitles.get(idx) + " (" + movieYears.get(idx) + ")");
            System.out.println("--------------------------------------------------");
            System.out.println("  Genre      : " + movieGenres.get(idx));
            System.out.println("  Duration   : " + movieDurations.get(idx) + " minutes");
            System.out.println("  Description: " + movieDescs.get(idx));
            System.out.println("  Ticket     : P" + moviePrices.get(idx));
            System.out.println("--------------------------------------------------");
            System.out.println("  1. Buy Ticket");
            System.out.println("  2. Back");
            System.out.print("  Choose: ");
            String option = scanner.nextLine().trim();

            if (option.equals("1")) {
                buyTicket(idx);
            } else if (option.equals("2")) {
                // go back to movie list
            } else {
                System.out.println("  Invalid option.");
            }
        }
    }

    static void buyTicket(int movieIndex) {
        double ticketPrice = moviePrices.get(movieIndex);
        double serviceFee = ticketPrice * 0.05;
        // round to 2 decimal places
        serviceFee = Math.round(serviceFee * 100.0) / 100.0;
        double total = ticketPrice + serviceFee;

        System.out.println("\n--------------------------------------------------");
        System.out.println("  CHECKOUT");
        System.out.println("--------------------------------------------------");
        System.out.println("  Movie       : " + movieTitles.get(movieIndex));
        System.out.println("  Ticket price: P" + ticketPrice);
        System.out.println("  Service fee : P" + serviceFee + " (5%)");
        System.out.println("  TOTAL       : P" + total);
        System.out.println("--------------------------------------------------");
        System.out.println("  Your balance: P" + balances.get(loggedInIndex));

        if (balances.get(loggedInIndex) < total) {
            double needed = total - balances.get(loggedInIndex);
            System.out.println("  Not enough balance. You need P" + needed + " more.");
            System.out.println("  Go to Top Up Wallet from the main menu.");
            return;
        }

        System.out.println("  Balance after payment: P" + (balances.get(loggedInIndex) - total));
        System.out.print("  Confirm payment? (y/n): ");
        String confirm = scanner.nextLine().trim();

        if (!confirm.equalsIgnoreCase("y")) {
            System.out.println("  Payment cancelled.");
            return;
        }

        // deduct balance
        double newBalance = balances.get(loggedInIndex) - total;
        newBalance = Math.round(newBalance * 100.0) / 100.0;
        balances.set(loggedInIndex, newBalance);

        // generate booking code
        String bookingCode = generateBookingCode();

        // save ticket as a string: "bookingCode|movieTitle|totalPaid|date"
        String ticketInfo = bookingCode + "|" + movieTitles.get(movieIndex) + "|" + total + "|" + new Date().toString();
        allTickets.get(loggedInIndex).add(ticketInfo);

        System.out.println("\n  Ticket purchased successfully!");
        System.out.println("  Booking Code: " + bookingCode);
        System.out.println("  Movie: " + movieTitles.get(movieIndex));
        System.out.println("  Total Paid: P" + total);
        printAsciiQR(bookingCode);
    }

    static void topUpWallet() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  TOP UP WALLET");
        System.out.println("--------------------------------------------------");
        System.out.println("  Current balance: P" + balances.get(loggedInIndex));
        System.out.print("  Enter amount to add: P");
        String input = scanner.nextLine().trim();

        // check if it's all digits
        boolean isNumber = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isNumber = false;
                break;
            }
        }

        if (isNumber == false || input.equals("")) {
            System.out.println("  Invalid amount. Please enter whole numbers only.");
            return;
        }

        double amount = Double.parseDouble(input);

        if (amount <= 0) {
            System.out.println("  Amount must be greater than zero.");
            return;
        }

        balances.set(loggedInIndex, balances.get(loggedInIndex) + amount);
        System.out.println("  P" + amount + " added to your wallet!");
        System.out.println("  New balance: P" + balances.get(loggedInIndex));
    }

    static void viewMyTickets() {
        ArrayList<String> myTickets = allTickets.get(loggedInIndex);
        System.out.println("\n--------------------------------------------------");
        System.out.println("  MY TICKETS");
        System.out.println("--------------------------------------------------");

        if (myTickets.size() == 0) {
            System.out.println("  You have no tickets yet.");
            return;
        }

        for (int i = 0; i < myTickets.size(); i++) {
            String[] parts = myTickets.get(i).split("\\|");
            System.out.println("  [" + (i + 1) + "] " + parts[1] + " - P" + parts[2] + " - Code: " + parts[0]);
        }

        System.out.print("  Enter ticket number to view QR (or 0 to go back): ");
        String input = scanner.nextLine().trim();

        if (input.equals("0")) {
            return;
        }

        int choice = -1;
        try {
            choice = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("  Please enter a valid number.");
            return;
        }

        if (choice < 1 || choice > myTickets.size()) {
            System.out.println("  Invalid selection.");
            return;
        }

        String[] parts = myTickets.get(choice - 1).split("\\|");
        System.out.println("\n  Booking Code : " + parts[0]);
        System.out.println("  Movie        : " + parts[1]);
        System.out.println("  Total Paid   : P" + parts[2]);
        System.out.println("  Date         : " + parts[3]);
        printAsciiQR(parts[0]);
    }

    static void viewProfile() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  PROFILE");
        System.out.println("--------------------------------------------------");
        System.out.println("  Username : " + usernames.get(loggedInIndex));
        System.out.println("  Email    : " + emails.get(loggedInIndex));
        System.out.println("  Role     : " + roles.get(loggedInIndex));
        System.out.println("  Balance  : P" + balances.get(loggedInIndex));
        System.out.println("  Tickets  : " + allTickets.get(loggedInIndex).size());
        System.out.println("--------------------------------------------------");
    }

    static void viewAllUsers() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  ALL USERS");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < usernames.size(); i++) {
            System.out.println("  " + usernames.get(i) + " | " + emails.get(i) + " | " + roles.get(i) + " | P" + balances.get(i));
        }
        System.out.println("--------------------------------------------------");
    }

    static void manageMovies() {
        while (true) {
            System.out.println("\n--------------------------------------------------");
            System.out.println("  MANAGE MOVIES");
            System.out.println("--------------------------------------------------");
            System.out.println("  1. List All Movies");
            System.out.println("  2. Add New Movie");
            System.out.println("  3. Delete Movie");
            System.out.println("  4. Back");
            System.out.println("--------------------------------------------------");
            System.out.print("  Choose: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                listAllMovies();
            } else if (choice.equals("2")) {
                addMovie();
            } else if (choice.equals("3")) {
                deleteMovie();
            } else if (choice.equals("4")) {
                return;
            } else {
                System.out.println("  Invalid option.");
            }
        }
    }

    static void listAllMovies() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("  ALL MOVIES");
        System.out.println("--------------------------------------------------");
        if (movieTitles.size() == 0) {
            System.out.println("  No movies added yet.");
            return;
        }
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println("  [" + (i + 1) + "] " + movieTitles.get(i) + " (" + movieYears.get(i) + ") - " + movieDurations.get(i) + " min - P" + moviePrices.get(i));
        }
    }

    static void addMovie() {
        System.out.println("\n  ADD MOVIE");
        System.out.println("--------------------------------------------------");
        System.out.print("  Title       : ");
        String title = scanner.nextLine().trim();

        System.out.print("  Genre       : ");
        String genre = scanner.nextLine().trim();

        System.out.print("  Description : ");
        String desc = scanner.nextLine().trim();

        System.out.print("  Duration (min): ");
        int duration = 0;
        try {
            duration = Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("  Invalid duration.");
            return;
        }

        System.out.print("  Year        : ");
        int year = 0;
        try {
            year = Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("  Invalid year.");
            return;
        }

        System.out.print("  Price (P)   : ");
        double price = 0;
        try {
            price = Double.parseDouble(scanner.nextLine().trim());
        } catch (Exception e) {
            System.out.println("  Invalid price.");
            return;
        }

        movieTitles.add(title);
        movieGenres.add(genre);
        movieDescs.add(desc);
        movieDurations.add(duration);
        movieYears.add(year);
        moviePrices.add(price);

        System.out.println("  Movie '" + title + "' added successfully!");
    }

    static void deleteMovie() {
        listAllMovies();
        System.out.print("\n  Enter the title of the movie to delete: ");
        String title = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < movieTitles.size(); i++) {
            if (movieTitles.get(i).equals(title)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            System.out.println("  Movie not found.");
            return;
        }

        movieTitles.remove(foundIndex);
        movieGenres.remove(foundIndex);
        movieDescs.remove(foundIndex);
        movieDurations.remove(foundIndex);
        movieYears.remove(foundIndex);
        moviePrices.remove(foundIndex);

        System.out.println("  Movie deleted.");
    }

    static String generateBookingCode() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String code = "CB-";
        Random rng = new Random();
        for (int i = 0; i < 6; i++) {
            int randomIndex = rng.nextInt(letters.length());
            code = code + letters.charAt(randomIndex);
        }
        return code;
    }

    static void printAsciiQR(String code) {
        int SIZE = 13;
        boolean[][] grid = new boolean[SIZE][SIZE];

        int seed = 7;
        for (int i = 0; i < code.length(); i++) {
            seed = seed * 31 + code.charAt(i);
        }

        Random rng = new Random(seed);
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                grid[r][c] = rng.nextBoolean();
            }
        }

        // draw corners like a real QR code
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = (r == 0 || r == 2 || c == 0 || c == 2) || (r == 1 && c == 1);
            }
        }
        for (int r = 0; r < 3; r++) {
            for (int c = SIZE - 3; c < SIZE; c++) {
                int lc = c - (SIZE - 3);
                grid[r][c] = (r == 0 || r == 2 || lc == 0 || lc == 2) || (r == 1 && lc == 1);
            }
        }
        for (int r = SIZE - 3; r < SIZE; r++) {
            for (int c = 0; c < 3; c++) {
                int lr = r - (SIZE - 3);
                grid[r][c] = (lr == 0 || lr == 2 || c == 0 || c == 2) || (lr == 1 && c == 1);
            }
        }

        System.out.println("--------------------------------------------------");
        for (int r = 0; r < SIZE; r++) {
            System.out.print("  ");
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c]) {
                    System.out.print("##");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }
}
