import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AikidoPracticeTrackerTest {
    AikidoPracticeTracker tracker = new AikidoPracticeTracker();

    @BeforeEach
    void setUp() {
        tracker.clearSessions();
    }

    @Test
    void addPracticeSession() {
        tracker.addPracticeSession("2024-02-01", 90);
        assertEquals(90, tracker.getTotalPracticeTime());
    }

    @Test
    void viewTotalPracticeTime() {
        tracker.addPracticeSession("2024-02-01", 90);
        tracker.addPracticeSession("2024-02-02", 60);
        assertEquals(150, tracker.getTotalPracticeTime());
    }

    @Test
    void checkGraduationEligibility() {
        tracker.addPracticeSession("2025-02-01", 30);
        tracker.addPracticeSession("2025-02-02", 60);
        assertFalse(tracker.checkGraduationEligibility());
    }
}