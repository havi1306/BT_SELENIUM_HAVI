package Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Browser {
    CHROME_LOCAL("chrome"), FIREFOX_LOCAL("firefox");

    private final String browser;
}
