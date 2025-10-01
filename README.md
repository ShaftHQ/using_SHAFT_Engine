# Practical Automation Template: Using SHAFT_Engine

*A powerful, ready-to-use template for starting your end-to-end test automation with SHAFT_Engine.*

<a href="https://github.com/ShaftHQ/using_SHAFT_Engine/actions"><img src="https://img.shields.io/github/actions/workflow/status/ShaftHQ/using_SHAFT_Engine/e2etests.yml?branch=main&logo=github&label=Tests" alt="Build Status"></a>
<a href="https://github.com/ShaftHQ/SHAFT_ENGINE"><img src="https://img.shields.io/github/v/release/ShaftHQ/SHAFT_ENGINE?logo=selenium&label=SHAFT%20Engine&color=blue" alt="SHAFT Engine"></a>
<a href="https://github.com/ShaftHQ/SHAFT_Engine"><img src="https://img.shields.io/github/stars/ShaftHQ/SHAFT_Engine?logo=github&label=Stars" alt="GitHub Stars"></a>

---

## Table of Contents
- [🚀 Project Overview and Motivation](#-project-overview-and-motivation)
- [⚡ Getting Started (Prerequisites and Dependencies)](#-getting-started-prerequisites-and-dependencies)
- [📁 Project Structure Breakdown (Critical Requirement)](#-project-structure-breakdown-critical-requirement)
- [🎯 Usage and Running Tests](#-usage-and-running-tests)
- [📸 Visual Demonstration (The Viral Component)](#-visual-demonstration-the-viral-component)
- [🆘 Support and Documentation](#-support-and-documentation)
- [🤝 Contributing and License](#-contributing-and-license)

---

## 🚀 Project Overview and Motivation

This repository is a **production-ready starter kit** for SHAFT_Engine users, eliminating setup overhead and providing hands-on experience with core features—including **Web**, **Mobile**, **API**, and **Database** testing. SHAFT_Engine empowers engineers to write highly readable code, benefit from built-in reporting and logging, and leverage a unified API across multiple testing technologies.

**Why Choose SHAFT_Engine?**
- 🔧 **Unified API** for Web, Mobile, API, and Database testing
- 📊 **Built-in reporting** with Allure integration and detailed logs
- 📖 **Highly readable** and maintainable test code
- ⚡ **Zero configuration** - works out of the box
- 🌐 **Cross-browser** support with Selenium Grid integration
- 📈 **CI/CD ready** with GitHub Actions workflow included

**Real-World Impact:**
- Reduce test automation setup time from days to minutes
- Write maintainable tests that serve as living documentation
- Scale across multiple browsers and environments effortlessly

---

## ⚡ Getting Started (Prerequisites and Dependencies)

### Prerequisites
- **Java Development Kit (JDK) 21+** (recommended JDK 24 for latest features)
- **Apache Maven 3.6.3+** 
- Modern IDE (e.g., IntelliJ IDEA, Eclipse, VS Code with Java extensions)
- **Docker** (optional, for Selenium Grid testing)

### Quick Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ShaftHQ/using_SHAFT_Engine.git
   cd using_SHAFT_Engine
   ```

2. **Build the project:**
   ```bash
   mvn clean compile
   ```

3. **Install dependencies:**
   ```bash
   mvn clean install -DskipTests
   ```

4. **Verify installation:**
   ```bash
   mvn test -Dtest=TestClass#navigateToDuckDuckGoAndAssertBrowserTitleIsDisplayedCorrectly
   ```

### IDE Setup (IntelliJ IDEA Recommended)
1. Import the project as a Maven project
2. Ensure the Project SDK is set to JDK 21+

---

## 📁 Project Structure Breakdown

```text
using_SHAFT_Engine/
├── 📄 pom.xml                                    # Maven build configuration
├── 📁 src/
│   ├── 📁 main/
│   │   └── 📁 resources/
│   │       └── 📁 properties/                    # 🔧 Configuration hub
│   │           ├── 📄 custom.properties          # Custom configurations
│   │           ├── 📄 log4j2.properties          # Logging configuration
│   │           ├── 📄 TestNG.properties          # TestNG runner settings
│   │           ├── 📄 cucumber.properties        # Cucumber integration
│   │           ├── 📄 reportportal.properties    # ReportPortal integration
│   │           └── 📁 default/                   # Default configuration fallbacks
│   └── 📁 test/
│       ├── 📁 java/
│       │   └── 📁 testPackage/
│       │       └── 📄 TestClass.java            # 🧪 Sample test implementation
│       └── 📁 resources/
│           ├── 📁 testDataFiles/                # 📊 Test data storage
│           │   └── 📄 simpleJSON.json          # JSON test data
│           └── 📁 META-INF/
│               └── 📁 services/                 # Service configurations for listeners
├── 📁 .github/
│   └── 📁 workflows/
│       └── 📄 e2etests.yml                     # 🚀 CI/CD pipeline configuration
└── 📁 target/                                   # 📈 Generated reports and artifacts
    ├── 📁 logs/                                # Detailed execution logs
    ├── 📁 surefire-reports/                   # TestNG/JUnit reports
    └── 📄 allure-report/                      # Rich HTML reports
```

### Key Components Explained

| Component | Purpose | Impact |
|-----------|---------|---------|
| **`pom.xml`** | Dependencies, plugins, and build profiles | Central project configuration |
| **`TestClass.java`** | Sample web automation tests using SHAFT_Engine API | Living documentation of framework capabilities |
| **`properties/`** | Runtime configurations for different environments | Zero-code environment switching |
| **`testDataFiles/`** | External test data (JSON, CSV, Excel) | Data-driven testing support |
| **`e2etests.yml`** | Multi-browser CI/CD pipeline | Automated testing across Chrome, Firefox, Edge |

---

## 🎯 Usage and Running Tests

### Sample Test Code Walkthrough

Here's the actual test code included in this template:

```java
package testPackage;

import com.shaft.driver.SHAFT;
import com.shaft.gui.internal.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

public class TestClass {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    String targetUrl = "https://duckduckgo.com/";

    // SHAFT's fluent locator API - more readable than traditional By locators
    By logo = By.xpath("//div[contains(@class,'container_fullWidth__1H_L8')]//img");
    By searchBox = Locator.hasAnyTagName().hasAttribute("name", "q").build();
    By firstSearchResult = Locator.hasTagName("article").isFirst().build();

    @Test
    public void navigateToDuckDuckGoAndAssertBrowserTitleIsDisplayedCorrectly() {
        // Fluent API with built-in reporting and error handling
        driver.browser().navigateToURL(targetUrl)
                .and().assertThat().title().contains(testData.getTestData("expectedTitle"));
    }

    @Test
    public void navigateToDuckDuckGoAndAssertLogoIsDisplayedCorrectly() {
        // Visual regression testing built-in
        driver.browser().navigateToURL(targetUrl)
                .and().element().assertThat(logo).matchesReferenceImage();
    }

    @Test
    public void searchForQueryAndAssert() {
        // Data-driven testing with JSON files
        driver.browser().navigateToURL(targetUrl)
                .and().element().type(searchBox, testData.getTestData("searchQuery") + Keys.ENTER)
                .and().assertThat(firstSearchResult).text()
                .doesNotEqual(testData.getTestData("unexpectedInFirstResult"));
    }

    @BeforeClass
    public void beforeClass() {
        // Load test data from JSON file
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        // Create new driver instance for each test
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    public void afterMethod() {
        // Automatic cleanup
        driver.quit();
    }
}
```

### Running Tests - Multiple Options

#### 1. **Basic Test Execution**
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=TestClass

# Run specific test method
mvn test -Dtest=TestClass#navigateToDuckDuckGoAndAssertBrowserTitleIsDisplayedCorrectly
```

#### 2. **Multi-Browser Testing (Local)**
```bash
# Chrome (default)
mvn test -DtargetBrowserName=chrome

# Firefox
mvn test -DtargetBrowserName=firefox

# Microsoft Edge
mvn test -DtargetBrowserName=edge

# Headless execution
mvn test -DheadlessExecution=true
```

#### 3. **Selenium Grid / Docker Integration**
```bash
# Download and start Selenium Grid
curl -o docker-compose.yml https://raw.githubusercontent.com/SeleniumHQ/docker-selenium/trunk/docker-compose-v3.yml
docker compose up --scale chrome=2 --scale firefox=2 -d

# Run tests against Grid
mvn test -DexecutionAddress=localhost:4444 -DtargetBrowserName=chrome
```

#### 4. **Advanced Configuration Options**
```bash
# Parallel execution with custom threads
mvn test -DsetParallel=METHODS -DsetParallelMode=DYNAMIC -DthreadCount=3

# Generate Allure reports
mvn test -DgenerateAllureReportArchive=true

# Retry failed tests
mvn test -DretryMaximumNumberOfAttempts=2

# Custom test data environment
mvn test -DtestDataFolderPath=src/test/resources/testDataFiles/
```

### Test Data Management

The template includes a JSON-based test data system:

```json
{
  "searchQuery": "SHAFT_Engine",
  "expectedTitle": "DuckDuckGo", 
  "unexpectedInFirstResult": "Nope"
}
```

**Accessing test data in your tests:**
```java
// In @BeforeClass
testData = new SHAFT.TestData.JSON("simpleJSON.json");

// In test methods
String query = testData.getTestData("searchQuery");
```

---

## 📸 Visual Demonstration

### 🎬 Live Test Execution Demo

> **Coming Soon:** Dynamic GIF showing a complete test run from execution to final HTML report generation.

### 📊 Rich HTML Reports

SHAFT_Engine generates comprehensive reports automatically:

- **Allure Reports**: Interactive HTML reports with step-by-step screenshots
- **TestNG Reports**: Detailed execution summaries
- **Custom Logs**: Structured logging with different levels
- **Screenshots**: Automatic capture on failures and assertions

### 🔄 CI/CD Pipeline Visualization

The included GitHub Actions workflow provides:
- ✅ **Multi-browser testing** (Chrome, Firefox, Edge)
- 🐳 **Dockerized Selenium Grid**
- 📈 **Automatic report generation and archiving**
- 🔄 **Parallel execution across browser matrix**
- 📊 **Test summaries and artifact uploads**

---

## 🆘 Support and Documentation

### Official Resources
- 📚 **[SHAFT_Engine Documentation](https://shafthq.github.io/)** - Complete API reference and guides
- 🐛 **[Report Issues](https://github.com/ShaftHQ/SHAFT_Engine/issues)** - Bug reports and feature requests
- 💬 **[Discussions](https://github.com/ShaftHQ/SHAFT_ENGINE/discussions)** - Community support and Q&A
- 📖 **[Wiki](https://github.com/ShaftHQ/SHAFT_ENGINE/wiki)** - Advanced tutorials and best practices

### Quick Support Guide

**Before Opening an Issue:**
1. Check existing [issues](https://github.com/ShaftHQ/SHAFT_Engine/issues)
2. Review the [documentation](https://shafthq.github.io/)
3. Try the [troubleshooting guide](https://shafthq.github.io/troubleshooting/)

**When Opening an Issue, Include:**
- SHAFT_Engine version (`mvn dependency:tree | grep SHAFT`)
- Java version (`java -version`)
- Operating System and Browser versions
- Complete error stack trace
- Minimal reproducible test case

### Learning Path
1. **Start Here**: Run the sample tests in this template
2. **Next**: Explore the [Getting Started Guide](https://shafthq.github.io/getting-started/)
3. **Advanced**: Check out [Best Practices](https://shafthq.github.io/best-practices/)
4. **Expert**: Contribute to the [SHAFT_Engine Core](https://github.com/ShaftHQ/SHAFT_ENGINE)

---

## 🤝 Contributing and License

### How to Contribute

We welcome contributions from the community! Here's how you can help:

#### 🌟 **Ways to Contribute**
- 🐛 **Report Bugs**: Found something broken? [Open an issue](https://github.com/ShaftHQ/SHAFT_Engine/issues/new)
- 💡 **Suggest Features**: Have ideas for improvements? [Start a discussion](https://github.com/ShaftHQ/SHAFT_ENGINE/discussions)
- 📝 **Improve Documentation**: Fix typos, add examples, or write guides
- 🧪 **Add Tests**: Expand the test coverage with new examples
- 🔧 **Code Contributions**: Implement new features or fix bugs

#### 🚀 **Quick Contribution Guide**
1. **Fork** this repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

#### 📋 **Contribution Guidelines**
- Follow existing code style and conventions
- Add tests for new functionality
- Update documentation for any API changes
- Ensure all tests pass before submitting
- Write clear commit messages

### 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](https://github.com/ShaftHQ/SHAFT_Engine/blob/main/LICENSE) file for details.

```
MIT License - Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files...
```

### 🙏 Acknowledgments

- **[SHAFT_Engine Team](https://github.com/ShaftHQ)** for creating this amazing framework
- **Contributors** who help improve this template
- **Community members** who provide feedback and support

---

<div align="center">

**Ready to revolutionize your test automation?**

[⭐ Star this repository](https://github.com/ShaftHQ/SHAFT_Engine/stargazers) • [🍴 Fork and customize](https://github.com/ShaftHQ/SHAFT_Engine/fork) • [📖 Read the docs](https://shafthq.github.io/)

**Built with ❤️ by the SHAFT_Engine community**

</div>
