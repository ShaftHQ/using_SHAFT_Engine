# GitHub Actions Workflows

This directory contains automated workflows for the repository.

## Available Workflows

### 1. End-to-End Testing (`e2etests.yml`)

**Purpose:** Runs automated tests across multiple browsers

**Triggers:**
- Push to `main` branch
- Manual trigger via workflow_dispatch

**Features:**
- Multi-browser testing (Chrome, Firefox, Edge)
- Dockerized Selenium Grid
- Parallel execution
- Automatic report generation and archiving

### 2. Template Synchronization (`sync-template.yml`)

**Purpose:** Automatically synchronizes files from the template repository to keep them up to date

**Triggers:**
- Schedule: Weekly on Mondays at 00:00 UTC
- Manual trigger via workflow_dispatch

**Features:**
- Downloads files from [testng-archetype template](https://github.com/ShaftHQ/testng-archetype/tree/main/src/test/resources/projects/should-generate-project/reference)
- Only updates files that exist in both repositories
- Creates a pull request with changes automatically
- Labels PR with "automated" and "template-sync"
- Skips PR creation if no changes detected

**Files Synchronized:**
- `pom.xml` - Maven configuration
- `.gitignore` - Git ignore rules
- `src/test/java/testPackage/TestClass.java` - Sample test class
- `src/test/resources/testDataFiles/simpleJSON.json` - Test data
- `src/test/resources/META-INF/services/*` - Listener configurations
- `src/main/resources/properties/*` - Configuration properties

**How to Use:**
1. **Automatic:** The workflow runs every Monday automatically
2. **Manual:** Go to Actions tab → Sync Template Files → Run workflow
3. **Review:** When changes are detected, a PR will be created automatically
4. **Merge:** Review and merge the PR to apply the template updates

**Important Notes:**
- The workflow only updates files that also exist in the template
- Custom modifications in your repository may be overwritten
- Always review changes before merging
- If you have custom modifications, you may need to manually adjust files after merging

## Workflow Maintenance

If you need to modify the workflows:
1. Edit the respective `.yml` file
2. Test changes using the `workflow_dispatch` trigger
3. Validate workflow syntax using tools like `actionlint` or `yamllint`
4. Commit and push changes

## Troubleshooting

### Template Sync Issues

If the template sync workflow fails:
1. Check the workflow run logs in the Actions tab
2. Verify the template repository URL is accessible
3. Ensure all referenced files exist in the template
4. Check for network issues or API rate limits

### Test Workflow Issues

If the test workflow fails:
1. Check if tests pass locally
2. Review the Selenium Grid logs
3. Verify Docker is running correctly
4. Check browser compatibility
