package MisthyxLabs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.Duration;

import static MisthyxLabs.Main.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTests {

   @ParameterizedTest
   @CsvFileSource (resources = "/isLeapArguments.csv")
   public void isLeapTest(int year, boolean expected) {
      assertEquals(expected, isLeap(year));
   }

   @ParameterizedTest
   @CsvFileSource (resources = "/actualDaysArgs.csv")
   public void determineActualDaysTest (int year, int daysExpected) {
      assertEquals(daysExpected, determineActualDays(year));
   }

   @ParameterizedTest
   @CsvSource (value = {"366, 666"})
   public void gameOverTest(int actualDays, int score) {
      assertTimeout(Duration.ofMinutes(1), () -> Main.gameOver(actualDays, score));
   }
}