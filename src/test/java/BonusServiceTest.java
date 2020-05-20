import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnregisteredAndOnLimit() {
        BonusService service = new BonusService();

        long amount = 5_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOnLimit() {
        BonusService service = new BonusService();

        long amount = 1_666_667;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndReallyOverLimitButTestUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndReallyUnderLimitButTestOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnRegisteredAndReallyUnderLimitButTestOverLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForUnRegisteredAndReallyOverLimitButTestUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected,actual);
    }
}