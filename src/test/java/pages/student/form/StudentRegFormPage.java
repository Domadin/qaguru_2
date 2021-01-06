package pages.student.form;

import com.codeborne.selenide.Selenide;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StudentRegFormPage {

    public StudentRegFormPage open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public StudentRegFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public StudentRegFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public StudentRegFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public StudentRegFormPage selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public StudentRegFormPage setMobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
        return this;
    }

    public StudentRegFormPage selectBirthdayDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day").findBy(text(day)).click();
        return this;
    }

    public StudentRegFormPage selectSubject(String... subjects) {
        for (String subject : subjects) {
            $("#subjectsInput").setValue(subject);
            $(".subjects-auto-complete__menu").$(byText(subject)).click();
        }
        return this;
    }

    public StudentRegFormPage selectHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            $("#hobbiesWrapper").$(byText(hobby)).click();
        }
        return this;
    }

    public StudentRegFormPage uploadPicture(String fileName) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + fileName));
        return this;
    }

    public StudentRegFormPage setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public StudentRegFormPage selectState(String state) {
        $("#state").scrollTo().click();
        $("#state").$(byText(state)).click();
        return this;
    }

    public StudentRegFormPage selectCity(String city) {
        $("#city").scrollTo().click();
        $("#city").$(byText(city)).click();
        return this;
    }

    public StudentRegFormPage submit() {
        $("#submit").click();
        return this;
    }
}
