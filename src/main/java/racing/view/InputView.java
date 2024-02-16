package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String ENTER_TRY_COUNT = "시도할 횟수는 몇회인가요?";
    private static final String ENTER_NAMES = "경주할 자동차 이름을 입력하세요(이름을 쉼표(,)를 기준으로 구분).";

    private final Scanner scanner = new Scanner(System.in);

    public String readNames() {
        System.out.println(ENTER_NAMES);
        return readLine();
    }

    public int readTryCount() {
        System.out.println(ENTER_TRY_COUNT);
        return readInt();
    }

    private String readLine() {
        String input = scanner.nextLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 null이거나 비어 있습니다.");
        }
        return input;
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }
}
