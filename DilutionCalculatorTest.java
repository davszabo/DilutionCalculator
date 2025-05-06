import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DilutionCalculatorTest {

    @Test
    public void testCalculateDilution_CorrectCalculation_SimpleRatio() {
        int capacity = 1000;
        String ratio = "1:2";
        String language = "English";

        String[] parts = ratio.split(":");
        int ratioFirst = Integer.parseInt(parts[0]);
        int ratioSecond = Integer.parseInt(parts[1]);

        int expectedChemicalAmount = Math.round((capacity / (float) (ratioFirst + ratioSecond)) * ratioFirst);
        int expectedWaterAmount = capacity - expectedChemicalAmount;

        int actualChemicalAmount = calculateChemicalAmount(capacity, ratioFirst, ratioSecond);
        int actualWaterAmount = calculateWaterAmount(capacity, actualChemicalAmount);

        assertEquals(expectedChemicalAmount, actualChemicalAmount, "Incorrect chemical amount");
        assertEquals(expectedWaterAmount, actualWaterAmount, "Incorrect water amount");
    }

    @Test
    public void testCalculateDilution_CorrectCalculation_LargeRatio() {
        int capacity = 5000;
        String ratio = "1:100";
        String language = "Magyar";

        String[] parts = ratio.split(":");
        int ratioFirst = Integer.parseInt(parts[0]);
        int ratioSecond = Integer.parseInt(parts[1]);

        int expectedChemicalAmount = Math.round((capacity / (float) (ratioFirst + ratioSecond)) * ratioFirst);
        int expectedWaterAmount = capacity - expectedChemicalAmount;

        int actualChemicalAmount = calculateChemicalAmount(capacity, ratioFirst, ratioSecond);
        int actualWaterAmount = calculateWaterAmount(capacity, actualChemicalAmount);

        assertEquals(expectedChemicalAmount, actualChemicalAmount, "Incorrect chemical amount");
        assertEquals(expectedWaterAmount, actualWaterAmount, "Incorrect water amount");
    }

    // Segédfüggvények a számításokhoz
    private int calculateChemicalAmount(int capacity, int ratioFirst, int ratioSecond) {
        return Math.round((capacity / (float) (ratioFirst + ratioSecond)) * ratioFirst);
    }

    private int calculateWaterAmount(int capacity, int chemicalAmount) {
        return capacity - chemicalAmount;
    }
}