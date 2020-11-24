package pages.practice.form;

import com.codeborne.selenide.Selenide;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeFormPage {

    public PracticeFormPage open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setMobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
        return this;
    }

    public PracticeFormPage selectBirthdayDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day").findBy(text(day)).click();
        return this;
    }

    public PracticeFormPage setBirthdayDate(String date) {
        $("#dateOfBirthInput").setValue(date).pressEnter();
        return this;
    }

    public PracticeFormPage selectSubject(String... subjects) {
        for (String subject : subjects) {
            $("#subjectsInput").setValue(subject);
            $(".subjects-auto-complete__menu").$(byText(subject)).click();
        }
        return this;
    }

    public PracticeFormPage selectHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            $(byText(hobby)).click();
        }
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + fileName));
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    //TODO Попросить добавить id попапа
    public PracticeFormPage selectState(String state) {
        $("#state").scrollTo().click();
        $$("[id^=\"react-select-3-option\"]").findBy(text(state)).click();
        return this;
    }

    public PracticeFormPage setState(String state) {
        $("#state").setValue(state).pressEnter();
        return this;
    }

    //TODO Попросить добавить id попапа
    public PracticeFormPage selectCity(String city) {
        $("#city").click();
        $$("div[id^=\"react-select-4-option\"]").findBy(text(city)).click();
        return this;
    }

    public PracticeFormPage setCity(String city) {
        $("#city").setValue(city).pressEnter();
        return this;
    }

    public PracticeFormPage submit() {
        $("#submit").click();
        return this;
    }
}
