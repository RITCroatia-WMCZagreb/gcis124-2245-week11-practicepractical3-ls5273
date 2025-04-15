/*
@ASSESSME.USERID: ls5273
@ASSESSME.AUTHOR: Lana Sorak
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.ANALYZE: YES
*/

import java.awt.SystemTray;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Temperature {

    public interface TemperatureScale {
        double convert(double temperature);
    }

    //Normal implementation
    class Convert implements TemperatureScale {

        @Override
        public double convert(double temperature) {
            return 2.2;
        }
        
    }

    /**
     * Part A
     * Create and return an anonymous class of type TemperatureScale that
     * converts a temperature given in Fahrenheit to Celsius
     * C = (F - 32) / 1.8
     * @return
     */
    public static TemperatureScale createF2C() {
        TemperatureScale f2C = new TemperatureScale() {
            @Override
            public double convert(double temperature) {
                return (temperature - 32) * 1.8;
            }
        };

        return f2C;
    }

    /**
     * Part B
     * Create and return an lambda of type TempConv that
     * converts a temperature given in Celsius to Fahrenheit
     * F = (C * 1.8) + 32
     * @return
     */
    public static TemperatureScale createC2F() {

        TemperatureScale c2F = new TemperatureScale() {
            @Override
            public double convert(double temperature) {
                return (temperature * 1.8) + 32;
            }
        };

        return c2F;
    }

    public static void main(String[] args) {
        
        TemperatureScale c2F = createC2F();
        TemperatureScale f2C = createF2C();

        List<Double> temps = Arrays.asList(0.0, 32.0, 12.3, 45.6, -12.0);

        List<Double> celsiusTemps = new ArrayList<>();
        List<Double> fahrenheitTemps = new ArrayList<>();


        // Part C
        // For each temperature in temps
            // 1. Use c2F variable to convert the temperature to Fahrenheit and
            //    store result in fahrenheitTemps
            // 2. Use f2C variable to convert the temperature to Celsius and
            //    store result in celciusTemps
       
        for(double number : temps) {
            double f = c2F.convert(number);
            fahrenheitTemps.add(f);

            double c = f2C.convert(number);
            celsiusTemps.add(c);
        }


        // Part D
        // Using stream(), filter(), and forEach(), print on a separate line all
        // elements of fahrenheitTemps that are *above* feezing (32F)

        System.out.println("Fahrenheit:");
        fahrenheitTemps.stream().filter(e -> e>32).forEach(e -> System.out.println(e));
       
      
        // Part E
        // Using streams(), filter(), and forEach(), print on a separate line all
        // elements of celsiusTemps that are *below* freezing (0C)

        System.out.println("\nCelsius:");
        celsiusTemps.stream().filter(e -> e<0).forEach(e -> System.out.println(e));
      
        
    }
    
}
