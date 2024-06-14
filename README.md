## Tests web-application: 

![Linkedin-url](https://img.shields.io/badge/Java-_11-red) ![Linkedin-url](https://img.shields.io/badge/Maven-version_4.0.0-blue)
![Linkedin-url](https://img.shields.io/badge/Allure-version_2.15-blue)
![Linkedin-url](https://img.shields.io/badge/JUnit_4-version_4.13.2-blue)
![Linkedin-url](https://img.shields.io/badge/Selenide-version_5.23.2-blue)
![Linkedin-url](https://img.shields.io/badge/RestAssured-version_4.4.0-blue)
![Linkedin-url](https://img.shields.io/badge/Lombok-version_1.18.28-blue)

---

### *We need to test a program that helps you order a burger in [Stellar Burgers](https://stellarburgers.nomoreparties.site/)*

**Task:** Describe the elements you will use in tests using Page Object.
Test the functionality in **Google Chrome and Yandex Browser**:
---

1. **Registration:** `src/test/RegistrationWebTest.java`
* successful registration.
* error for incorrect password. The minimum password is 6 characters.
---

2. **Sing in:** `src/test/LoginWebTest.java`
* login using the `Sing in` button on the main page,
* login through the personal account button,
* login via the button in the registration form,
* login via the button in the password recovery form.
---

3. **Go to your personal account :** `src/test/TransitionTest.java`
* Check the transition by clicking on “Personal Account”
---

4. **Transition from your personal account to the designer:** `src/test/`
* Check the transition by clicking on “Constructor” and on the Stellar Burgers logo.
---

5. **Logout:** `src/test/ExitTest.java`
* Check the exit using the “Logout” button in your personal account.
---

6. **Section "Constructor"** `src/test/ConstructorSectionTest.java`
* check that transitions to sections work
  * «Rolls»,
  * «Sauces»,
  * «Fillings».
---
### Contacts:

<a href="mailto:Andrey.Vorobev.AQA@gmail.com" title="Email"><img alt="Email" src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" height="28" align="center"/></a>
<a href="https://t.me/andreyjqa" title="Email"><img alt="Telegram" src="https://img.shields.io/badge/Telegram-blue?style=for-the-badge&logo=telegram&logoColor=white" height="28" align="center"/></a>
