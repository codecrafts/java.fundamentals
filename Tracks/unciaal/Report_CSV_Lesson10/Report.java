import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.TreeMap;

public class Report implements ObserverCSV {
    private String _textCSV_;
    //private ObserverCSVDataSource _dataSource_;
    private String _dataSource_;
    private String _delimiter_ = ";";

    @Override
    public void update(String textCSV) {
        this._textCSV_= textCSV;
        System.out.println(textCSV);
        Test.answer = "OK";
    }


   /* public class Calculation {
        private ArrayList<String> _transactionLog_;
        private final String _data_ = "Дата";
        private final String _сategory_ = "Категория";
        private final String _Summ_ = "Сумма";
        private int _indexData_;
        private int _indexCategory_ = 0;
        private int _indexSumm_;
        private ArrayList _outputInformation_ = new ArrayList();

        private Period _month_ = Period.ofMonths(8);
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        public Calculation(String textCSV) {
            this._transactionLog_ = new ArrayList<String>(Arrays.asList(textCSV.split("/n")));
        }

        public int getPositionField (ArrayList<String> rows, String sampleFild){
            String str = rows.get(0);
            ArrayList<String> strNameField = new ArrayList(Arrays.asList(str.split(_delimiter_)));
            String fildColumn;
            for(int i = 0; i < strNameField.size(); i++){
                fildColumn = strNameField.get(i);
                if(fildColumn.equals(sampleFild))return i;
            }
            return -1;
        }
        public void getReportData (){
            _indexData_ = getPositionField(_transactionLog_,_data_);
            _indexCategory_ = getPositionField(_transactionLog_,_сategory_);
            _indexSumm_ = getPositionField(_transactionLog_,_Summ_);
            TreeMap<String, Double> sortedReport = new TreeMap<>();
            Date currentDate;
            String currentCategory;
            double currentSumm;
            double mapSummValue;
            String dataInPeriod;
                for (int i = 1; i < _transactionLog_.size(); i++) {
                    String str = _transactionLog_.get(i);
                    ArrayList<String> transaction = new ArrayList(Arrays.asList(str.split(_delimiter_)));
                    currentDate = (Date) formatData.parse(transaction.get(_indexData_));
                    currentCategory = transaction.get(_indexCategory_);
                    currentSumm = Double.parseDouble(transaction.get(_indexSumm_));
                    if (_month_.equals(currentDate)){
                        dataInPeriod = (currentDate.toString() + "-" + currentCategory);
                        if (sortedReport.containsKey(dataInPeriod)){
                            mapSummValue = sortedReport.get(dataInPeriod) + currentSumm;
                            sortedReport.put(dataInPeriod,mapSummValue);
                        } else sortedReport.put(dataInPeriod,currentSumm);

                    }

                }

            }


        }*/

}
