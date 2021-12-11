module citizen.central.citizensys {
    requires javafx.controls;
    requires javafx.fxml;


    opens citizen.central.citizensys to javafx.fxml;
    exports citizen.central.citizensys;
}