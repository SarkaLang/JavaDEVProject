package serviceTest; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParkingServiceTest {

    @Test
    void testCalculatePrice() {
        // Příklad jednoduché logiky výpočtu ceny
        int pricePerDay = 100;  // Cena za den
        int numberOfDays = 5;   // Počet dní

        int totalPrice = pricePerDay * numberOfDays;

        assertEquals(500, totalPrice, "Cena by měla být 500");
    }
}
