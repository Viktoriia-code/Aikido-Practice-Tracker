import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PracticeSession {
    LocalDate date;
    int duration; // in minutes

    public PracticeSession(LocalDate date, int duration) {
        this.date = date;
        this.duration = duration;
    }
}

public class AikidoPracticeTracker {
    private static List<PracticeSession> sessions = new ArrayList<>();
    private static LocalDate startDate = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Aikido Practice Tracker =====");
            System.out.println("1. Add Practice Session");
            System.out.println("2. View Total Practice Time");
            System.out.println("3. Check Graduation Eligibility");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter practice date (YYYY-MM-DD): ");
                    String dateInput = scanner.nextLine();

                    System.out.print("Enter practice duration in minutes: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    addPracticeSession(dateInput, duration);
                    break;
                case 2:
                    System.out.println("Total practice time: " + getTotalPracticeTime() + " minutes");
                    break;
                case 3:
                    if (checkGraduationEligibility()) {
                        System.out.println("You are eligible for graduation!");
                    } else {
                        System.out.println("You are not eligible for graduation yet.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void addPracticeSession(String dateStr, int duration) {
        LocalDate date = LocalDate.parse(dateStr);
        if (startDate == null) {
            startDate = date;
        }
        sessions.add(new PracticeSession(date, duration));
    }

    public static int getTotalPracticeTime() {
        return sessions.stream().mapToInt(session -> session.duration).sum();
    }

    public static boolean checkGraduationEligibility() {
        if (sessions.isEmpty()) {
            return false;
        }
        System.out.println(getTotalPracticeTime());

        int sessionCount = sessions.size();
        long monthsPassed = ChronoUnit.MONTHS.between(startDate, LocalDate.now());

        return sessionCount >= 100 || monthsPassed >= 6;
    }

    public static void clearSessions() {
        sessions.clear();
        startDate = null;
    }
}
