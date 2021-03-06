package com.github;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {
    /*$("h1 div")
    он найдет первый div внутри h1 любого уровня
    $("h1").$("div")
    он найдет первый div внутри h1 первого уровня*/
    @Test
    void h1DivVsH1Div() {
        open("https://onlinecontract.ru/");
        $(".div h2");
        $(".div").$("h1");
    }
    @Test
    void BrowserCommandExamples() {
        open("https://github.com/");//Откройте страницу
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();//Ввести Selenide
        $$("ul.repo-list li").first().$("a").click(); //кликнуть на первый элемент
        $("h1").shouldHave(text("selenide / selenide"));//проверить текст selenide 16
        $("#wiki-tab").click();//Перейдите в раздел Wiki проекта
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(By.linkText("SoftAssertions")).shouldBe(visible).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");//открыть
        $("#column-a").dragAndDropTo("#column-b");//Перенесите прямоугольник А на место В
        $("#column-a").shouldHave(text("B"));//Проверьте, что прямоугольники действительно поменялись
        $("#column-b").shouldHave(text("A"));
    }

}

