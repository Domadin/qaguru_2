package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.student.form.StudentRegFormPage;
import pages.student.form.SubmitFormWindow;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class StudentRegFormTests {

    private final StudentRegFormPage practiceFormPage = new StudentRegFormPage();

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void openPage() {
        practiceFormPage.open();
    }

    @Test
    public void fillRequiredFields() {
        String firstName = randomAlphabetic(5),
                lastName = randomAlphabetic(10),
                gender = "Female",

                mobileNumber = randomNumeric(10),

                birthDay = "24",
                birthMonth = "September",
                birthYear = "1995";

        practiceFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .selectGender(gender)
                .setMobileNumber(mobileNumber)
                .selectBirthdayDate(birthDay, birthMonth, birthYear)
                .submit();

        new SubmitFormWindow().assertName(firstName, lastName)
                .assertMail("")
                .assertGender(gender)
                .assertMobileNumber(mobileNumber)
                .assertBirthdayDate(birthDay, birthMonth, birthYear)
                .assertSubjects("")
                .assertHobbies("")
                .assertPictureFileName("")
                .assertCurrentAddress("")
                .assertStateAndCity("");
    }

    @Test
    public void fillAllFields() {
        String firstName = randomAlphabetic(5),
                lastName = randomAlphabetic(10),

                email = "%s@%s.%s".formatted(randomAlphabetic(5), randomAlphabetic(5), randomAlphabetic(5)),
                gender = "Male",
                mobileNumber = randomNumeric(10),

                birthDay = "24",
                birthMonth = "September",
                birthYear = "1995",

                subject1 = "English",
                subject2 = "Civics",

                hobby1 = "Sports",
                hobby2 = "Reading",

                fileName = "testFile.jpg",

                currentAddress = randomAlphabetic(30),
                state = "NCR",
                city = "Delhi";

        practiceFormPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setMobileNumber(mobileNumber)
                .selectBirthdayDate(birthDay, birthMonth, birthYear)
                .selectSubject(subject1, subject2)
                .selectHobbies(hobby1, hobby2)
                .uploadPicture(fileName)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submit();

        new SubmitFormWindow().assertName(firstName, lastName)
                .assertMail(email)
                .assertGender(gender)
                .assertMobileNumber(mobileNumber)
                .assertBirthdayDate(birthDay, birthMonth, birthYear)
                .assertSubjects(subject1, subject2)
                .assertHobbies(hobby1, hobby2)
                .assertPictureFileName(fileName)
                .assertCurrentAddress(currentAddress)
                .assertStateAndCity(state, city);
    }
}
