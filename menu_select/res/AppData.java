package res;

public class AppData {
    private int currentPage = 0;
    private boolean isAtHome = true;
    private boolean isAppOn = false;

    public boolean isAppOn() {
        return isAppOn;
    }

    public void setAppOn(boolean isAppOn) {
        this.isAppOn = isAppOn;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isAtHome() {
        return isAtHome;
    }

    public void setAtHome(boolean isAtHome) {
        this.isAtHome = isAtHome;
    }

}