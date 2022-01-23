package bullscows;

public class Grade {
    String numbers;

    public  Grade(String num) {
       numbers = num;
    }

    public String getNum() {
        return numbers;
    }

    public void setNum(String num) {
        numbers = num;
    }

    public int checkTheAmountOfCows(String secretCode) {
        int cows = 0;
        for (int i = 0; i < numbers.length(); i++) {
            for (int j = 0; j < secretCode.length(); j++) {
                if (numbers.charAt(i) == secretCode.charAt(j) && i != j) {
                    cows++;
                }
            }
        }
        return cows;
    }

    public int checkTheAmountOfBulls(String secretCode) {
        int bulls = 0;
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            }
        }
        return bulls;
    }

    public String printCow (int cows) {
        if (cows == 1) {
            return "cow";
        } else {
            return "cows";
        }

    }
    public String printBull(int bulls) {
        if (bulls == 1) {
            return "bull";
        } else {
            return "bulls";
        }
    }
}
