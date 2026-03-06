package lab5;

public class Statistics {

    // OVERLOADING METHODS 

    public static double mean(double a, double b) {
        return (a + b) / 2;
    }

    public static double mean(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public static double mean(double a, double b, double c, double d) {
        return (a + b + c + d) / 4;
    }

    public static double mean(double a, double b, double c, double d, double e) {
        return (a + b + c + d + e) / 5;
    }

    //  MEAN 

    public static double mean(double... nums) {
        double sum = 0;
        for (double n : nums) {
            sum += n;
        }
        return sum / nums.length;
    }

    //  DEVIATION

    public static double stdDev(double... nums) {

        double mean = mean(nums);
        double sum = 0;

        for (double n : nums) {
            sum += Math.pow(n - mean, 2);
        }

        return Math.sqrt(sum / nums.length);
    }
} 
