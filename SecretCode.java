package bullscows;

public class SecretCode {
    StringBuilder code;

    public SecretCode() {
        code = new StringBuilder();
    }

    public StringBuilder generateCode(int symbolsQuantity) {
        if (symbolsQuantity < 11) {
            if (code.length() == 0) {
                code.append(String.valueOf((int) (1 + Math.random() * 9)));
            } else {
                int digit2 = (int) (Math.random() * 10);
                if (!checkByUniqueness(String.valueOf(digit2))) {
                    code.append(digit2);
                }
            }
        } else {
            if (code.length() == 0) {
                int randomNumber = (int) (1 + Math.random() * symbolsQuantity);
                char firstCodeCharacter = randomNumber < 10 ? (char) (randomNumber + 48) : (char) (randomNumber - 10 + 97);
                code.append(firstCodeCharacter);
            } else {
                int randomNumber = (int) (Math.random() * symbolsQuantity);
                char nextCodeCharacter = randomNumber < 10 ? (char) (randomNumber + 48) : (char) (randomNumber - 10 + 97);
                if (!checkByUniqueness(String.valueOf(nextCodeCharacter))) {
                    code.append(nextCodeCharacter);
                }
            }
        }

        return code;
    }

    public boolean checkByUniqueness(String digit) {
        for (int i = 0; i < code.length(); i++) {
            if (String.valueOf(code.charAt(i)).equals(digit))
                return true;
        }
        return false;
    }

    public String generateStars(int codeLength) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < codeLength; i++) {
            stars.append('*');
        }
        return String.valueOf(stars);
    }

    public String generateRange(int symbolQuantity) {
        return "(0-9, a-" + (char)(97 + symbolQuantity - 11) + ").";
    }

    public void generateMessage(int codeLength, int symbolsQuantity) {
        if (symbolsQuantity < 11) {
            System.out.printf("The secret is prepared: %s (0-9).\n", generateStars(codeLength));
        } else {
            System.out.printf("The secret is prepared: %s %s.\n", generateStars(codeLength), generateRange(symbolsQuantity));
        }
    }

    public void checkParameters(int codeLength, int symbolQuantity) {
        if (codeLength < symbolQuantity) {
            System.out.printf(
                    "Error: it's not possible to generate a code with a length of %d with %d unique symbols."
                    , codeLength, symbolQuantity);
        }
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
