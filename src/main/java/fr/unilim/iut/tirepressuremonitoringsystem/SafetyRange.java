package fr.unilim.iut.tirepressuremonitoringsystem;

public class SafetyRange {
    private final double lowThreshold = 17;
    private final double highThreshold = 21;

    private boolean pressionSuperieurALowerPressureThreshold(double psiPressureValue) {
        return psiPressureValue > highThreshold;
    }

    private boolean pressionInferieureALowerPressureThreshold(double psiPressureValue) {
        return psiPressureValue < lowThreshold;
    }

    boolean isNotSafe(double psiPressureValue) {
        return pressionInferieureALowerPressureThreshold(psiPressureValue) || pressionSuperieurALowerPressureThreshold(psiPressureValue);
    }
}
