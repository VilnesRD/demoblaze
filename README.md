# Проект по автоматизации тестирования сайта T1-Консалтинг

## :page_with_curl:	Содержание

> :heavy_check_mark: [Технологии и инструменты](#technologist-технологии-и-инструменты)
>
> :heavy_check_mark: [Реализованы проверки](#bookmark_tabs-реализованы-проверки)
>
> :heavy_check_mark: [Запуск тестов из терминала](#computer-Запуск-тестов-из-терминала)
>
> :heavy_check_mark: [Запуск тестов в Jenkins](#-запуск-тестов-в-jenkins)
>
> :heavy_check_mark: [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-allure-report)
> 
> :heavy_check_mark: [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
> 
> :heavy_check_mark: [Интеграция с Jira](#-интеграция-с-jira)
>
> :heavy_check_mark: [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
>
> :heavy_check_mark: [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)

## :technologist: Технологии и инструменты

<p  align="center"

<code><img width="5%" title="IntelliJ IDEA" src="media/icons/Idea.svg"></code>
<code><img width="5%" title="Java" src="media/icons/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="media/icons/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="media/icons/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="media/icons/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="media/icons/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="media/icons/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="media/icons/Allure.svg"></code>
<code><img width="5%" title="Allure TestOps" src="media/icons/Allure_TO.svg"></code>
<code><img width="5%" title="Jenkins" src="media/icons/Jenkins.svg"></code>
<code><img width="5%" title="Jira" src="media/icons/Java.svg"></code>
<code><img width="5%" title="Telegram" src="media/icons/Telegram.svg"></code>
</p>

> *В данном проекте автотесты написаны на <code><strong>*Java*</strong></code> с использованием фреймворка <code><strong>*Selenide*</strong></code> для UI-тестов.*
>
>*Для сборки проекта используется <code><strong>*Gradle*</strong></code>.*
>
>*<code><strong>*JUnit 5*</strong></code> используется как фреймворк для модульного тестирования.*
>
>*Запуск тестов выполняется из <code><strong>*Jenkins*</strong></code>.*
>
>*<code><strong>*Allure Report, Allure TestOps, Telegram Bot*</strong></code> используются для визуализации результатов тестирования.*


## :bookmark_tabs: Реализованы проверки

### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UI

> -[x] *Проверка добавления товара в корзину с оформлением заказа*
>- [x] *Проверка удаления добавленного товара из корзины*
>- [x] *Проверка логина с корректными данными пользователя*
>- [x] *Проверка логина с не корректными данными пользователя*
>- [x] *Проверка создания нового пользователя*
>- [x] *Проверка отправки сообщения через форму*


## :computer: Запуск тестов из терминала 

### Локальный запуск тестов

```bash
gradle clean test -Denv=local
```

### Удаленный запуск тестов

```bash
gradle clean test 
${TASK}
"-Denv=remote"
```

## <img width="4%" title="Jenkins" src="media/icons/Jenkins.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/demoblaze/)

*Для запуска сборки необходимо указать значения параметров и нажать кнопку <code><strong>*Собрать*</strong></code>.*

<p align="center">
  <img src="media/screen/StartJK(2).png" alt="job" width="800">
</p>

*После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок <img width="2%" title="Allure Report" src="media/icons/Allure.svg"><code><strong>*Allure
Report*</strong></code>, кликнув по которому, откроется страница с сформированным html-отчетом.*

<p align="center">
  <img src="media/icons/Allure.svg" alt="job" width="1000">
</p>

## <img width="4%" title="Allure Report" src="media/icons/Allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/demoblaze/)

### :pushpin: Общая информация

*Главная страница Allure-отчета содержит следующие информационные блоки:*

> - [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)

<p align="center">
  <img src="media/screen/AllureReport(1).png" alt="Allure Report" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/20267)

### :pushpin: Основной дашборд

<p align="center">
  <img src="media/screen/AllureCloud.png" alt="dashboards" width="900">
</p>

### :pushpin: Тест-кейсы

<p align="center">
  <img src="media/screen/AllureCase.png" alt="test cases" width="900">
</p>

## <img width="4%" title="Telegram" src="media/icons/Telegram.svg"> Уведомления в Telegram с использованием бота

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="media/screen/TgResults.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

> К каждому тесту в отчете прилагается видео.
<p align="center">
  <img title="Selenoid Video" src="media/gif/VideoTest.gif">
</p>
