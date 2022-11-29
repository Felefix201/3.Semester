package hw8;



public class PathCoverage {


    public static String intToRoman(int n) {

        /**
         * 2 * Konvertiert eine Dezimalzahl in eine römische Zahl.
         * 3 * Es werden nur Tausender- und Hunderteranteile berücksichtigt.
         * 4
         */
            String romanNumber = "";

            if (n < 0) {
                romanNumber = "Keine römische Zahl";

            } else {
                int thousands = n / 1000;
                n %= 1000;

                for (int i = 0; i < thousands; i++) {
                    romanNumber += "M";

                }

                if (n >= 900) {
                    romanNumber += "CM";

                } else if (n >= 500) {
                    romanNumber += "D";

                    int hundreds = (n - 500) / 100;
                    for (int i = 0; i < hundreds; i++) {
                        romanNumber += "C";

                    }

                } else if (n >= 400) {
                    romanNumber += "CD";

                } else if (n >= 100) {
                    int hundreds = n / 100;
                    for (int i = 0; i < hundreds; i++) {
                        romanNumber += "C";

                    }

                }


            }
            return romanNumber;

        }
    }

