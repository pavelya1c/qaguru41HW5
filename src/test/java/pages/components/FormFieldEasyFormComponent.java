package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;


public class FormFieldEasyFormComponent {
    public void FormFieldEasyForm(String value) {
        $("#output").shouldHave(Condition.text(value));

    }
}
