package com.team6133.frc2018.auto.modes;

import com.team6133.frc2018.Constants;
import com.team6133.frc2018.auto.AutoModeBase;
import com.team6133.frc2018.auto.AutoModeEndedException;
import edu.wpi.first.wpilibj.DriverStation;

public class RIGHT_PreferSwitch_or_NoScore extends AutoModeBase {
    @Override
    protected void routine() throws AutoModeEndedException {
        AutoModeBase determinedAutoMode = new Option_StartRight_EndScoreSwitch();
        if (Constants.kGameSpecificMessage.length() != 3) {
            if (DriverStation.getInstance().isFMSAttached())
                Constants.kGameSpecificMessage = DriverStation.getInstance().getGameSpecificMessage();
            else
                Constants.kGameSpecificMessage = "LLLX";
        }
        if (Constants.kGameSpecificMessage.charAt(0) == 'L') {
            determinedAutoMode = new Option_StartLeft_EndLeftSwitchNoScoreMode();
            System.out.println(Constants.kGameSpecificMessage + "\t-> Starting Cross Auto Line NO SCORE");
        } else {
            System.out.println(Constants.kGameSpecificMessage + "\t-> Starting Score Right Switch");
        }
        child = determinedAutoMode;
        determinedAutoMode.run();
    }
}