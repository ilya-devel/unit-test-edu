package seminars.first._Homework.Calculator;


public class Calculator extends seminars.first.Calculator.Calculator {
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        if (purchaseAmount < 0) {
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }
        if (discountAmount < 0 || discountAmount > 100) {
            throw new ArithmeticException("Размер скидки не может быть ниже 0 или выше 100");
        }
        return purchaseAmount * (((double) 100 - discountAmount) / 100); // Метод должен возвращать сумму покупки со скидкой
    }
}
