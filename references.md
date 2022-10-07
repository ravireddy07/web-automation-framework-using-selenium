# Documentation

## Uses of Annotation

- <b> Parameters </b>

  ```sh
  @Parameters({"parameter1", "parameter2", "parameter3"})
  @BeforeMethod 
  public void beforeMethod(@Optional String parameter1, String parameter2, String parameter3) {
    String test = parameter1 + parameter2 + parameter3;
  }
  ```

## Type of Waits

- <b> Implicit Wait</b>
   
   The Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount of time before it throws a “No Such Element Exception”
  ```sh
  # Here it will wait for 10seconds, The by-default poll-time is 0.5sec
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    ```

- <b> Explicit Wait</b>

  Explicit wait would be defined to particular web element. It will wait for single web element. For example if one of the web element takes more time than implicit wait then instead of changing implicit wait time it is better to define explicit wait.
    ```shell
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
    ```

- <b> Fluent Wait</b>

  Fluent wait is similar to explicit wait the difference is in fluent wait we can define polling time. And we can ignore the exception.
    ```shell
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(50, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    ```



## Useful Commands

- `export BROWSER_GRID_URL=https://zalenium.auzmor.com/wd/hub
mvn test -DBROWSER_GRID_URL=$BROWSER_GRID_URL -Dtest=com.auz.lms.testcase.insights.admin.CoursesInsights#validateAccurateValuesOfCourse`
