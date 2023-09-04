package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By skip=By.id("com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip");
    public static By add=By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn1");
    public static By textButton=By.xpath("//*[@text='Text']");
    public static By addText=By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_note");
    public static By tickButton=By.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn");
    public static By backButton=By.id("com.socialnmobile.dictapps.notepad.color.note:id/back_btn");
    public static By textNotes=By.id("com.socialnmobile.dictapps.notepad.color.note:id/background");
    public static By colorOption=By.xpath("//android.widget.LinearLayout[@content-desc=\"Color\"]/android.widget.ImageView");

    public static By timeOfNotesCreated=By.id("com.socialnmobile.dictapps.notepad.color.note:id/date");
    public static By menuBar=By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn3");
    public static By settings=By.xpath("//*[@text='Settings']");
    public static By day=By.xpath("//*[@text='Monday']");
    public static By verifyMonday=By.xpath("//*[@text='Monday']");
    public static By searchButton=By.id("com.socialnmobile.dictapps.notepad.color.note:id/main_btn2");
    public static By searchArea=By.id("com.socialnmobile.dictapps.notepad.color.note:id/edit_search");
    public static By searchedNote=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/b.k.a.a/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]");
    public static By goBack=By.id("com.socialnmobile.dictapps.notepad.color.note:id/search_back");
    public static By textNote4=By.xpath("//*[@text='Text4']");
    public static By textNote2=By.xpath("//*[@text='Text2']");
    public static By deleteOption=By.xpath("//*[@text='Delete']");
    public static By confirmOption=By.id("android:id/button1");
    public static By textNote1=By.xpath("//*[@text='Text1']");
    public static By archiveOption=By.xpath("//*[@text='Archive']");
    public static By navMenu=By.id("com.socialnmobile.dictapps.notepad.color.note:id/icon_nav");
    public static By trash=By.xpath("//*[@text='Trash Can']");
    public static By archive=By.xpath("//*[@text='Archive']");
}
