package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormFieldEasyFormComponent;
import pages.components.FormFieldHardFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AllPages {

    CalendarComponent calendarComponent = new CalendarComponent();
    FormFieldHardFormComponent formFieldHardFormComponent = new FormFieldHardFormComponent();
    FormFieldEasyFormComponent formFieldEasyFormComponent = new FormFieldEasyFormComponent();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement subjectInput = $(".subjects-auto-complete__input");
    private final SelenideElement hobbiesInput = $("#hobbiesWrapper");
    private final SelenideElement pictureInput = $("#uploadPicture");
    private final SelenideElement currentAdressInput = $("#currentAddress");
    private final SelenideElement stateInput = $(".col-md-4.col-sm-12");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement userFormTable = $("#userForm");


    public AllPages openPage(String value) {
        open(value);
        return this;
    }

    public AllPages typeUserFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AllPages typeUserLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AllPages typeUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public AllPages typeUserNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public AllPages submitButtonClick() {
        submitButton.click();
        return this;
    }

    public AllPages typeUserGender(String value) {
        genderInput.shouldBe(visible)
                .$(byText(value)).click();
        return this;
    }

    public AllPages typeUserSubject(String value) {
        subjectInput.shouldBe(visible)
                .setValue(value)
                .pressEnter();
        return this;
    }


    public AllPages typeUserHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public AllPages typeUserPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public AllPages typeUserCurrentAddress(String value) {
        currentAdressInput.setValue(value);
        return this;
    }

    public AllPages typeUserState(String value) {
        stateInput.click();
        $(byText(value)).click();
        return this;
    }

    public AllPages typeUserCity(String value) {
        cityInput.click();
        $(byText(value)).click();
        return this;
    }

    public AllPages setDayOfBirth(String day, String mounth, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, mounth, year);
        return this;
    }

    public AllPages typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public AllPages typeUserPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }


    public AllPages userFormWasValidatedHardForm() {
        userFormTable.shouldHave(cssClass("was-validated"));
        return this;
    }

    public AllPages userFormWasNotValidatedHardForm() {
        userFormTable.shouldNotHave(cssClass("table-dark"));
        return this;
    }

    public AllPages userFormWasValidatedEasyForm() {
        emailInput.shouldHave(cssClass("field-error"))
                .shouldHave(cssClass("form-control"));
        return this;
    }

    public AllPages checkFormFieldHardForm(String key, String value) {
        formFieldHardFormComponent.FormFieldHardForm(key, value);
        return this;
    }

    public AllPages checkFormFieldEasyForm(String value) {
        formFieldEasyFormComponent.FormFieldEasyForm(value);
        return this;
    }


}
