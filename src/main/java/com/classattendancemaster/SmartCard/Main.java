package com.classattendancemaster.SmartCard;

import com.classattendancemaster.Entities.Student;
import com.classattendancemaster.RESTControllers.AttendanceListController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.smartcardio.CardException;

public class Main {

    public static void main(String[] args) throws CardException {
        boolean wait = true;
        Logger LOGGER = LoggerFactory.getLogger(Main.class);
        SmartcardConnector smartcardConnector = new SmartcardConnector();

        while (wait) {
            try {
                smartcardConnector.initializeTerminal();
                if (smartcardConnector.cardTerminal.isCardPresent()) {
                    smartcardConnector.connectCard();
                    Student student = smartcardConnector.getCardUserData();

                    smartcardConnector.cardTerminal.waitForCardAbsent(100000);
                }

            } catch (Exception e) {
                LOGGER.info(e.getMessage());
                wait = false;
            }
        }
    }
}

