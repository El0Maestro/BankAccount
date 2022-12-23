package guiMVC.model;

public class Text {
    final String close = "ZAMKNIJ";
    final String back = "WRÓÆ";

    public String getFilePresentation() {
        return filePresentation;
    }

    final String filePresentation = "Prezentacja odczytanych danych";

    public String getClose() {
        return close;
    }

    public String getBack() {
        return back;
    }

    public String getChoose() {
        return choose;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public String getFileScreen() {
        return fileScreen;
    }

    public String getReadData() {
        return readData;
    }

    public String getShowData() {
        return showData;
    }

    final String choose = "WYBIERZ";
    final String bankAcc = "Bank Account Binder";
    final String fileScreen = "File choose screen";
    final String readData = "1.ODCZYTAJ DANE";
    final String showData = "2.WYŒWIETL DANE";

}
