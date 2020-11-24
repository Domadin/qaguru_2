package pages.practice.form;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmitFormWindow {

    private void verifyRowValue(String key, String value) {
        $(".modal-content").$(byText(key)).sibling(0).shouldHave(exactText(value));
    }

    public SubmitFormWindow assertName(String firstName, String lastName) {
        verifyRowValue("Student Name", "%s %s".formatted(firstName, lastName));
        return this;
    }

    public SubmitFormWindow assertMail(String mail) {
        verifyRowValue("Student Email", mail);
        return this;
    }

    public SubmitFormWindow assertGender(String gender) {
        verifyRowValue("Gender", gender);
        return this;
    }

    public SubmitFormWindow assertMobileNumber(String phoneNumber) {
        verifyRowValue("Mobile", phoneNumber);
        return this;
    }

    public SubmitFormWindow assertBirthdayDate(String day, String month, String year) {
        verifyRowValue("Date of Birth", "%s %s,%s".formatted(day, month, year));
        return this;
    }

    public SubmitFormWindow assertSubjects(String... subjects) {
        verifyRowValue("Subjects", String.join(", ", subjects));
        return this;
    }

    public SubmitFormWindow assertHobbies(String... hobbies) {
        verifyRowValue("Hobbies", String.join(", ", hobbies));
        return this;
    }

    public SubmitFormWindow assertPictureFileName(String fileName) {
        verifyRowValue("Picture", fileName);
        return this;
    }

    public SubmitFormWindow assertCurrentAddress(String address) {
        verifyRowValue("Address", address);
        return this;
    }

    public SubmitFormWindow assertStateAndCity(String state, String city) {
        verifyRowValue("State and City", "%s %s".formatted(state, city));
        return this;
    }
}
