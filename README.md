# A Template for using [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE)
<img src="https://github.com/ShaftHQ/SHAFT_ENGINE/raw/master/src/main/resources/images/shaft.png" alt="SHAFT_ENGINE" style="display:block; margin-left:auto; margin-right:auto;"/>

<a id="quick-start-guide"></a>
## I. Quick Start Guide 🏃
### Step 1: Setting up your project
- Click the blue button above that says "Use this template" > "Create a new repository"
- From your new repository click the blue button that says "<> Code" > "Open with GitHub Desktop"
- From your GitHub Desktop click the button that says "Open in JetBrains IntelliJ Idea Community Edition"
- Due to a known issue with IntelliJ you need to edit your run configuration templates before running your tests by following these steps:
  - Open 'Edit Run/Debug Configurations' dialog > Edit Configurations... > Edit configuration templates...
  - Select <b>TestNG</b> > Listeners > and add these listeners one by one:
    <br/>`com.shaft.tools.listeners.AlterSuiteListener`, `com.shaft.tools.listeners.SuiteListener`, `com.shaft.tools.listeners.InvokedMethodListener`
  - Select <b>Cucumber Java</b> > Program Arguments > and add this argument:
  <br/>`--plugin com.shaft.tools.listeners.CucumberFeatureListener`
  - After saving the changes, remember to delete any old test runs you may have triggered by mistake before adding the needed config.

### Step 2: Running some Tests
- Navigate to the module that you want to play with. For example ```GUI_Web```
- Navigate to any test class. For example ```src/test/java/TestPackage/TestClass.java```
- Press the green play button next to the class name to run the entire class, or next to a test method to run only that method.
- Test execution will begin, and you'll see the browser opening and the test running.
- The Test execution report will open automatically in your default web browser after the test run is completed.

<img src="https://github.com/allure-framework/allure2/raw/master/.github/allure-report-gif.gif" alt="Allure Report" style="display:block; margin-left:auto; margin-right:auto;"/>

## II. What's next?
### Configuration and User Guide
- Change the target browser, operating system, timeouts, and other configurations using the ⚙️ [Configuration Manager](https://ShaftHQ.github.io/SHAFT_ENGINE/).
- Learn more about using SHAFT_Engine from the 👤 [User Guide](https://ShaftHQ.github.io/SHAFT_Engine_Docusaurus/) and 📚 [Javadocs](https://ShaftHQ.github.io/SHAFT_ENGINE/apidocs/index.html).
- Make sure to <b>Star</b> ⭐ [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE) to get notified when new releases are pushed out.
- After upgrading your Engine it is sometimes recommended to delete the properties folder ```src\main\resources\properties``` and allow SHAFT to regenerate the defaults by running any test method.

### CI/CD & DevOps
- This template comes preloaded with some Selenium grid 4 powered CI/CD pipelines to get you started!
- Navigate to "Actions" and then select "Desktop Browser Tests" from the side menu
- Click "Run workflow" and confirm your choice.
- You will notice that the pipeline has started building, and you can download the execution reports once the execution is completed.

<img src="https://github.githubassets.com/images/modules/site/actions/pr-checks-final.png" alt="GitHub Actions" style="display:block; margin-left:auto; margin-right:auto;"/>


## III. Who else is using SHAFT? [^4]
<img height="50" title="_VOIS (Vodafone Intelligent Solution)" alt="_VOIS (Vodafone Intelligent Solution)" src="https://www.vodafone.com/_next/image?url=https%3A%2F%2Fcontent.vodafone.com%2Fsites%2Fdefault%2Ffiles%2Finline-images%2FgN08grNr8s9vipkhltm4sWWezExdQg5LwJrGY2Ma2ojTjCnvi2.png&w=1600&q=100" href="https://www.vodafone.com/careers/professional-career-areas/shared-services">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="GET Group Holdings" alt="GET Group Holdings" src="https://www.getgroup.com/wp-content/themes/get-group-holdings/assets/images/logo-high-res-2.png" href="https://www.getgroup.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="MOMRA (Saudi Arabia's Ministry of Municipal and Rural Affairs)" alt="MOMRA (Saudi Arabia's Ministry of Municipal and Rural Affairs)" src="https://momrah.gov.sa/themes/custom/momrah/assets/images/mh-logo-full.png" href="https://momra.gov.sa/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Vodafone (Egypt)" alt="Vodafone (Egypt)" src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Vodafone_icon.svg/239px-Vodafone_icon.svg.png" href="https://www.vodafone.com.eg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Solutions by STC" alt="Solutions by STC" src="https://solutions.com.sa/wp-content/uploads/2019/11/logo.svg" href="https://solutions.com.sa/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="GIZA Systems" alt="GIZA Systems" src="https://gizasystems.com/wp-content/themes/twentyfourteen-child/images/logo.png" href="https://gizasystems.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Euronet" alt="Euronet" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Euronet_Worldwide_logo.svg/1920px-Euronet_Worldwide_logo.svg.png" href="https://www.euronetworldwide.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Terkwaz Business Solutions" alt="Terkwaz Business Solutions" src="https://images.wuzzuf-data.net/files/company_logo/Terkwaz-Solutions-Jordan-35434-1578830823.png" href="https://www.terkwaz.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Incorta" alt="Incorta" src="https://media-exp1.licdn.com/dms/image/C560BAQHUWHhKl0xrCA/company-logo_200_200/0/1660913597037?e=2147483647&v=beta&t=CiDPUEvlIBqztN5gCre-pQ5f7M-03_02IQgJtL18wG8" href="https://www.incorta.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="BayanTech" alt="BayanTech" src="https://bayan-tech.com/wp-content/uploads/2020/01/Bayan-Logo-2.png" href="https://bayan-tech.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Adam.ai" alt="Adam.ai" src="https://images.prismic.io/adamdotai/8e6625b0-e32b-4bee-b1b8-ebdc1d30cbfe_full-logo.svg?ixlib=gatsbyFP&auto=compress%2Cformat&fit=max&q=50" href="https://adam.ai/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="ACT Global Soft" alt="ACT Global Soft" src="https://www.act.eg/wp-content/uploads/2021/01/3.png" href="https://www.act.eg/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="elmenus" alt="elmenus" src="https://assets-global.website-files.com/625d19c77d49d0aa53047be3/625d19c77d49d0142c047d36_615c77e71175c38163bca403_elmenus.png" href="https://www.elmenus.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="IDEMIA" alt="IDEMIA" src="https://wikiimg.tojsiabtv.com/wikipedia/commons/thumb/2/2e/IDEMIA_Logo.jpg/1280px-IDEMIA_Logo.jpg" href="https://www.idemia.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="iHorizons" alt="iHorizons" src="https://www.ihorizons.com/sites/all/themes/ihorizons_theme/imgs/logo.png" href="https://www.ihorizons.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Robusta" alt="Robusta" src="https://images.wuzzuf-data.net/files/company_logo/Robusta-Egypt-7927.png" href="https://robustastudio.com/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img height="50" title="Paymob Solutions" alt="Paymob Solutions" src="https://www.paymob.com/images/paymobLogo.png" href="https://www.paymob.com/">

[^4]: Company names are collected via anonymous surveys and provided freely by engineers who claimed to be using SHAFT_Engine within these companies.

<a id="support-and-contributions"></a>
## IV. For Support & Contributions 👥
- Join us via Slack & Facebook
  <br/><a href="https://join.slack.com/t/automatest-workspace/shared_invite/zt-oii5i2gg-0ZGnih_Y34NjK7QqDn01Dw" target="_blank"><img src="https://a.slack-edge.com/80588/marketing/img/icons/icon_slack_hash_colored.png" alt="automatest-workspace" width="50" height="50"/></a>  <a href="https://www.facebook.com/groups/Automatest" target="_blank"><img src="https://facebookbrand.com/wp-content/uploads/2019/04/f_logo_RGB-Hex-Blue_512.png" alt="Automatest" width="50" height="50"/></a>
- And feel free to create PRs directly. [This lovely tutorial](https://dev.to/genicsblog/how-to-create-a-pull-request-in-github-correctly-20np) will help.

### Stop Reinventing the wheel! Start using SHAFT!
