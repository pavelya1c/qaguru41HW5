import org.junit.jupiter.api.Test;
import pages.AllPages;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;


public class TestBoxHW5 extends TestBase {
    AllPages allPages = new AllPages();


    @Test
    public void successfulFormSubmissionWithAllFieldsTestHardForm() {

        allPages.openPage("/automation-practice-form")
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserNumber(userPhone)
                .typeUserGender(userGender)
                .setDayOfBirth(dayOfBirth, mounthOfBirth, yearOfBirth)
                .typeUserSubject(sendKey)
                .typeUserHobbies(userHobbies)
                .typeUserPicture(userPicture)
                .typeUserCurrentAddress(userCurrentAdress)
                .typeUserState(userState)
                .typeUserCity(userCity)
                .submitButtonClick()
                .checkFormFieldHardForm("Student Name", (firstName + " " + lastName))
                .checkFormFieldHardForm("Student Email", userEmail)
                .checkFormFieldHardForm("Gender", userGender)
                .checkFormFieldHardForm("Mobile", userPhone)
                .checkFormFieldHardForm("Hobbies", userHobbies)
                .checkFormFieldHardForm("Date of Birth", (dayOfBirth + " " + mounthOfBirth + "," + yearOfBirth))
                .checkFormFieldHardForm("Subjects", userSubjects)
                .checkFormFieldHardForm("Picture", userPicture)
                .checkFormFieldHardForm("Address", userCurrentAdress)
                .checkFormFieldHardForm("State and City", ((userState + " " + userCity)));


    }

    @Test
    void successfulFormSubmissionWithAllFieldsTestEasyForm() {

        allPages.openPage("/text-box")
                .typeUserName(firstName + " " + lastName)
                .typeUserEmail(userEmail)
                .typeUserCurrentAddress(userCurrentAdress)
                .typeUserPermanentAddress(userPermanentAdress)
                .submitButtonClick()
                .checkFormFieldEasyForm(firstName + " " + lastName)
                .checkFormFieldEasyForm(userEmail)
                .checkFormFieldEasyForm(userCurrentAdress)
                .checkFormFieldEasyForm(userPermanentAdress);


    }

    @Test
    public void successfulFormSubmissionWithRequiredFieldsTestHardForm() {
        open("/automation-practice-form");
        allPages.typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserNumber(userPhone)
                .typeUserGender(userGender)
                .submitButtonClick()
                .checkFormFieldHardForm("Student Name", (firstName + " " + lastName))
                .checkFormFieldHardForm("Student Email", userEmail)
                .checkFormFieldHardForm("Gender", userGender)
                .checkFormFieldHardForm("Mobile", userPhone);
    }

    @Test
    public void successfulFormSubmissionWithNoTAllFieldsTestEasyForm() {
        allPages.openPage("/text-box")
                .typeUserName(firstName + " " + lastName)
                .typeUserEmail(userEmail)
                .submitButtonClick()
                .checkFormFieldEasyForm(firstName + " " + lastName)
                .checkFormFieldEasyForm(userEmail);


    }

    //НЕГАТИВНЫЕ ТЕСТЫ

    @Test
    public void shouldShowValidationErrorsWhenAllRequiredFieldsAreEmptyTestHardForm() {
        allPages.openPage("/automation-practice-form")
                .typeUserGender(userGender)
                .submitButtonClick()
                .userFormWasValidatedHardForm();
    }

    @Test
    public void shouldShowValidationErrorsWhenFirstNameAreEmptyTestHardForm() {
        allPages.openPage("/automation-practice-form")
                .typeUserLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserNumber(userPhone)
                .typeUserGender(userGender)
                .submitButtonClick()
                .userFormWasValidatedHardForm();
    }

    @Test
    public void shouldNotDisplayResultTableWhenFormSubmissionIsInvalidTestHardForm() {
        allPages.openPage("/automation-practice-form")
                .typeUserLastName(lastName)
                .typeUserEmail(userEmail)
                .typeUserNumber(userPhone)
                .typeUserGender(userGender)
                .submitButtonClick()
                .userFormWasNotValidatedHardForm();
    }

    @Test
    public void shouldShowValidationErrorWhenInvalidEmailIsEnteredTestEasyForm() {
        allPages.openPage("/text-box")
                .typeUserEmail(userEmailNotValid)
                .submitButtonClick()
                .userFormWasValidatedEasyForm();
    }


}
