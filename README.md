# Task 3: Web-application: #
### Use frameworks and dependencies: ###

---
![Linkedin-url](https://img.shields.io/badge/Java-_11-red)

![Linkedin-url](https://img.shields.io/badge/Maven-version_4.0.0-blue)
![Linkedin-url](https://img.shields.io/badge/Allure-version_2.15-blue)
![Linkedin-url](https://img.shields.io/badge/JUnit_4-version_4.13.2-blue)
![Linkedin-url](https://img.shields.io/badge/Selenide-version_5.23.2-blue)
![Linkedin-url](https://img.shields.io/badge/RestAssured-version_4.4.0-blue)
![Linkedin-url](https://img.shields.io/badge/Lombok-version_1.18.28-blue)

---
### *Нужно протестировать программу, которая помогает заказать бургер в [Stellar Burgers](https://stellarburgers.nomoreparties.site/)*
**Что нужно сделать:** Опиши элементы, которые будешь использовать в тестах, с помощью Page Object.
Протестируй функциональность в **Google Chrome и Яндекс.Браузере**:
1. **Регистрация:** src/test/RegistrationWebTest
* Успешную регистрацию.
* Ошибку для некорректного пароля. Минимальный пароль — шесть символов.
2. **Вход:** src/test/LoginWebTest
* вход по кнопке «Войти в аккаунт» на главной,
* вход через кнопку «Личный кабинет»,
* вход через кнопку в форме регистрации,
* вход через кнопку в форме восстановления пароля.
3. **Переход в личный кабинет :** src/test/TransitionTest
* Проверь переход по клику на «Личный кабинет»,
4. **Переход из личного кабинета в конструктор:** src/test/
* Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
5. **Выход из аккаунта:** src/test/ExitTest
* Проверь выход по кнопке «Выйти» в личном кабинете.
6. **Раздел «Конструктор»** src/test/ConstructorSectionTest
* Проверь, что работают переходы к разделам:
  * «Булки»,
  * «Соусы»,
  * «Начинки».

---
###### Над проектом работал [Andrey Vorobev](https://github.com/AndreyJVM)