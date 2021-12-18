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
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;


    opens citizen.central.citizensys to javafx.fxml, org.hibernate.orm.core;
    opens citizen.central.citizensys.payment to javafx.fxml;
    opens citizen.central.citizensys.appointment to javafx.fxml;
    opens citizen.central.citizensys.login to javafx.fxml;
    opens citizen.central.citizensys.cnic to javafx.fxml;
    opens citizen.central.citizensys.user to javafx.fxml;
    opens gov.nadra to org.hibernate.orm.core;


    exports citizen.central.citizensys;
    exports citizen.central.citizensys.user;
    exports citizen.central.citizensys.payment;
    exports citizen.central.citizensys.login;
    exports citizen.central.citizensys.appointment;
    exports citizen.central.citizensys.cnic;
    exports citizen.central.db;
    exports gov.nadra;


}