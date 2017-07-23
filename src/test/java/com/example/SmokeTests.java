package com.example;


import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SmokeTests {

    @BeforeClass(alwaysRun = true)
    public static void startClass(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
    }


    @Test
    public void simpleTest(){
        open("/");
        $(byLinkText("Login")).click();
        $(byId("auth_user_email")).shouldBe(visible).setValue("savva.genchevskiy@gmail.com");
        $(byId("auth_user_password")).setValue("19021992qa");
        $("input[value^='Login']").click();
        $(".flash").shouldBe(visible);
        $(byLinkText("Logout")).shouldBe(visible);
    }




}
