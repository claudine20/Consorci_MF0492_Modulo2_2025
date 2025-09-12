package W4D2Lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalOperations {

    /**
     * Redondea un numero BigDecimal a la centesima mas cercana.
     *
     * @param number El numero BigDecimal a redondear.
     * @return Un valor double redondeado a dos decimales.
     */
    public static double roundToHundredth(BigDecimal number) {
        // Usa setScale() para redondear a 2 decimales, usando el modo de redondeo HALF_UP
        // (redondea hacia arriba si el decimal es 5 o mas).
        BigDecimal rounded = number.setScale(2, RoundingMode.HALF_UP);
        // Convierte el BigDecimal redondeado a un double.
        return rounded.doubleValue();
    }

    /**
     * Invierte el signo de un numero BigDecimal y lo redondea a la decima mas cercana.
     *
     * @param number El numero BigDecimal a modificar.
     * @return Un valor double con el signo invertido y redondeado a un decimal.
     */
    public static double reverseSignAndRoundToTenth(BigDecimal number) {
        // Usa negate() para invertir el signo del numero.
        BigDecimal negated = number.negate();
        // Usa setScale() para redondear a 1 decimal, usando el modo de redondeo HALF_UP.
        BigDecimal rounded = negated.setScale(1, RoundingMode.HALF_UP);
        // Convierte el resultado a un double.
        return rounded.doubleValue();
    }
}
