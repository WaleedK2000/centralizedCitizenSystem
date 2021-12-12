module citizen.central.citizensys {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.boxicons;
    requires org.kordamp.ikonli.carbonicons;



    opens citizen.central.citizensys to javafx.fxml;
    opens citizen.central.citizensys.payment to javafx.fxml;
    exports citizen.central.citizensys;
    exports citizen.central.citizensys.payment;

}