package definition;

import implementation.Implementation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinition {
    public static int count=0;
    @Given("user opens the Notepad application")
    public void openApplication() {
        try {
            Implementation.openApplication();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to open the Notepad application.");
        }
    }

    @When("user creates five text notes")
    public void createTextNotes() {
        Implementation.openTextArea();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("user change the color of each note")
    public void changeNoteColors() {
        Implementation.changeTheColor();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("user print the creation time of each note")
    public void printCreationTimes() {
        Implementation.printNotesCreationTime();
    }

    @When("user change the first day of the week")
    public void changeFirstDayOfWeek() {
        Implementation.changeTheDayOfWeek();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user search for the text note Text3")
    public void searchForTextNote() {
        Implementation.searchThirdTextNote();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("user verify the search result")
    public void verifySearchResult() {
        Implementation.verifyTheSearchResult();
    }

    @When("user delete text notes 2 and 4")
    public void deleteTextNotes() {
        Implementation.deleteTextNotes();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("user verifies the deleted notes")
    public void verifyTheDeletedNotes() {
        Implementation.verifyDeletedNotes();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user archive the first text note")
    public void archiveFirstTextNote() {
        Implementation.archiveFirstTextNote();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user verify the archived note")
    public void verifyArchivedNote() {
        Implementation.verifyArchivedNotes();
        try {
            Implementation.screenshot("Screenshot" +count++ +".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
