# 🚀 Автоматизация тестирования сайта EFREMOV | Ювелирный интернет-магазин

---
![Company Logo](icons/about-logo.svg)

---

> EFREMOV – тёплый бренд
> похожий на друга, который понимает твои чувства и желания. Он дарит нежные подарки, поднимает настроение, делает жизнь
> добрее и счастливее. С ним ты выглядишь современной и уверенной в себе. Семья — это наше сокровище. Любая женщина —
> драгоценная его составляющая. EFREMOV бережно относится к предпочтениям женщин и дарит каждой чудесные мгновения.
> Украшения EFREMOV созданы с любовью для тебя!

---

Автотесты разработаны для сайта [EFREMOV](https://efremov.gold/)


---

## Проект включает в себя:

- **UI-тесты** с использованием Selenium и Selenide.
- Интеграцию с **Allure** для создания подробных отчетов.
- Настройку CI/CD через **Jenkins**.
- Поддержку нескольких тестовых фреймворков: **JUnit 5** и **TestNG**.

---

## 🛠 Технологии и инструменты

[![Gradle](/icons/Gradle.png)](https://gradle.org/)
[![IntelliJ IDEA](/icons/Intelij_IDEA.png)](https://www.jetbrains.com/idea/)
[![Selenide](/icons/Selenide.png)](https://selenide.org/)
[![Selenoid](/icons/Selenoid.png)](https://selenide.org/)
[![JUnit5](/icons/JUnit5.png)](https://junit.org/junit5/)
[![Jenkins](/icons/Jenkins.png)](https://www.jenkins.io/)
[![Allure Report](/icons/Allure_Report.png)](https://qameta.io/)
[![Telegram](/icons/Telegram.png)](https://web.telegram.org/a/)

- **Язык программирования**: Java
- **Тестирование UI**: Selenium, Selenide
- **Фреймворки для тестирования**: JUnit 5, TestNG
- **Система сборки**: Gradle
- **Отчеты**: Allure
- **CI/CD**: Jenkins

📊 Охват тестирования

### 🌐 UI-тесты

- [x] Проверка главной странице
- [x] Проверка поиска товара
- [x] Проверка страниц колец, браслетов
- [x] Проверка добавления товара в корзину
- [x] Проверка каталога
- [x] Проверка работы сортировки и фильтрации

### 🔌 API-тесты

- [x] Проверка получения токенов для cooke
- [x] Проверка авторизации с не валидными данными
- [x] Проверка добавления/удаления товара из корзины
- [x] Проверка добавления/удаления товара из избранного
- [x] Проверка списка товара "Колец"

---

## 🌟 Пример  отчета в Telegram:

![This is an image](/icons/Screenshot_1.png)
---

## 🌟 Пример Allure-отчета:

[Allure-отчет](https://jenkins.autotests.cloud/job/EfremovGoldTest/23/allure/#)

![This is an image](/icons/allure.png)

## 🌟 Запуск тестов Jenkins:

[Jenkins](https://jenkins.autotests.cloud/job/EfremovGoldTest/)

![This is an image](/icons/dj.png)

## 🌟 Интеграция с Allure TestOps

[Allure TestOps](https://allure.autotests.cloud/launch/45894/?treeId=0)
![This is an image](/icons/ops.png)

# 📸 Для каждого теста сохранится скриншот и видео с результатом:

## 🌟 Видео прогона одного из автотестов:

![animation.gif](/icons/video1.gif)

## 🌟 Скриншот UI  одного из автотестов:

![This is an image](/icons/срин.png)

## 🌟 Скриншот API  одного из автотестов:

![This is an image](/icons/apitest.png)

### 🚀 Команды для запуска сборки из терминала:

```
clean test -Denv=remote -DisRemote=true 
clean api -Denv=remote -DisRemote=true 
clean web -Denv=remote -DisRemote=true

```

### Локальный запуск

```
gradle clean test -Denv=local
```

**Сборка на удаленном Selenoid с параметрами, которые указаны в Jenkins, как для всего проекта, так и для API и WEB
можно собрать с параметрами:**

* <code>BROWSER</code> – браузер для выполнения тестов
* <code>BROWSER_SIZE</code> – размер окна браузера
* <code>BROWSER_VERSION</code> – версия браузера (в зависимости от выбранного браузера)
* <code>SELENOID_HOST</code> – адрес удаленного сервера для запуска тестов

---