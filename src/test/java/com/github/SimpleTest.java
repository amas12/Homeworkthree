package com.github;

import com.codeborne.selenide.*;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.*;
import java.time.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {
        /*$("h1 div")
        он найдет первый div внутри h1 любого уровня
        $("h1").$("div")
        он найдет первый div внутри h1 первого уровня*/

    @Test

    void browser_command_examples() {

        open("https://github.com/");//Откройте страницу
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();//Ввести Selenide
        $$("ul.repo-list li").first().$("a").click(); //кликнуть на первый элемент
        $("h1").shouldHave(text("selenide / selenide"));//проверить текст selenide
        $("#wiki-tab").click();//Перейдите в раздел Wiki проекта
        $(".Layout-main").$(byText("Soft assertions")).click();//Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        sleep(9000);
        $$("ol[start=\"3\"]").find(visible).scrollTo().shouldHave(text("Using JUnit5 extend test class:"));//Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        sleep(8000);
    }
    @Test
            void dragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");//открыть
        sleep(3000);
        $("#column-a").dragAndDropTo("#column-b");//Перенесите прямоугольник А на место В
        $("#column-a").shouldHave(text("B"));//Проверьте, что прямоугольники действительно поменялись
        $("#column-b").shouldHave(text("A"));
        sleep(5000);
    }

}

