package pages.components;

import testdata.TestData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static testdata.TestData.*;

public class CalendarComponent {
    public void setDate(String day, String mounth, String year) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(mounth);
        $(".react-datepicker__month").$(byText(day)).doubleClick();
    }
}
