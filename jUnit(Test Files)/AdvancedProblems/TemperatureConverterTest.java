package com.day5.JUnit.AdvancedProblems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    // Test the conversion from Celsius to Fahrenheit
    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), "0°C should be 32°F");
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), "100°C should be 212°F");
        assertEquals(98.6, converter.celsiusToFahrenheit(37.0), 0.1, "37°C should be approximately 98.6°F");
    }

    // Test the conversion from Fahrenheit to Celsius
    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), "32°F should be 0°C");
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), "212°F should be 100°C");
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.1, "98.6°F should be approximately 37°C");
    }
}
