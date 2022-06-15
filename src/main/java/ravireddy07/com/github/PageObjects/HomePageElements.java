package ravireddy07.com.github.PageObjects;

import org.openqa.selenium.By;

public interface HomePageElements {
    By byTrainingDropDown = By.xpath("//div[@data-testid='filter-by-training']");
    By byCompanyDropDown = By.xpath("//div[@data-testid='filter-by-company']");
    By byAnalyticsDropDown = By.xpath("//div[@data-testid='filter-by-analytics']");
    By byHomeTab = By.xpath("//a[@data-testid='home-menu']");
    By byCoursesTab = By.xpath("//a[@data-testid='courses-menu']");
    By byPathsTab = By.xpath("//a[@data-testid='paths-menu']");
    By byEventsTab = By.xpath("//a[@data-testid='events-menu']");
    By byPeopleTab = By.xpath("//a[@data-testid='peoples-menu']");
    By byInsightsTab = By.xpath("//a[@data-testid='insights-menu']");
    By byReportsTab = By.xpath("//a[@data-testid='reports-menu']");
    By byBranchTab = By.xpath("//a[@data-testid='branches-menu']");
    By byForumTab = By.xpath("//a[@data-testid='forum-menu']");

    String signInID = "nav-link-accountList-nav-line-1";
}
