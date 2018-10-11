public class ObserverCSVDataSource implements ObservableCSV {
    private String _textData_;
    private ObserverCSV _report_ = new Report();

    public void setTextData(String textData) {
        this._textData_ = textData;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        _report_.update(_textData_);

    }

}
