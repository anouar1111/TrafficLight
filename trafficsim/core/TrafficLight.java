/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/

package trafficsim.core;

// line 5 "../../TrafficLight.ump"
public class TrafficLight implements EventHandler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight Attributes
  private TrafficLightManager trafficLightManager;

  //TrafficLight State Machines
  public enum Status { defaultMode, lowTraffic, moderateTraffic, highTraffic }
  public enum StatusDefaultMode { Null, northAndSouthGreen, northAndSouthYellow, northAndSouthRed, westAndEastYellow }
  public enum StatusLowTraffic { Null, northAndSouthArrow, northAndSouthGreen, northAndSouthYellow, westAndEastGreen, westAndEastYellow }
  public enum StatusModerateTraffic { Null, northGreenAndArrow, northYellow, southGreenAndArrow, southYellow, westAndEastGreen, westAndEastYellow }
  public enum StatusHighTraffic { Null, northGreenAndArrow, northYellow, southGreenAndArrow, southYellow, westGreenAndArrow, westAndEastGreen, westAndEastYellow }
  private Status status;
  private StatusDefaultMode statusDefaultMode;
  private StatusLowTraffic statusLowTraffic;
  private StatusModerateTraffic statusModerateTraffic;
  private StatusHighTraffic statusHighTraffic;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TrafficLight(TrafficLightManager aTrafficLightManager)
  {
    trafficLightManager = aTrafficLightManager;
    setStatusDefaultMode(StatusDefaultMode.Null);
    setStatusLowTraffic(StatusLowTraffic.Null);
    setStatusModerateTraffic(StatusModerateTraffic.Null);
    setStatusHighTraffic(StatusHighTraffic.Null);
    setStatus(Status.defaultMode);
    // line 11 "../../TrafficLight.ump"
    trafficLightManager.addEventHandler(this);
    // END OF UMPLE AFTER INJECTION
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTrafficLightManager(TrafficLightManager aTrafficLightManager)
  {
    boolean wasSet = false;
    trafficLightManager = aTrafficLightManager;
    wasSet = true;
    return wasSet;
  }

  public TrafficLightManager getTrafficLightManager()
  {
    return trafficLightManager;
  }

  public String getStatusFullName()
  {
    String answer = status.toString();
    if (statusDefaultMode != StatusDefaultMode.Null) { answer += "." + statusDefaultMode.toString(); }
    if (statusLowTraffic != StatusLowTraffic.Null) { answer += "." + statusLowTraffic.toString(); }
    if (statusModerateTraffic != StatusModerateTraffic.Null) { answer += "." + statusModerateTraffic.toString(); }
    if (statusHighTraffic != StatusHighTraffic.Null) { answer += "." + statusHighTraffic.toString(); }
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public StatusDefaultMode getStatusDefaultMode()
  {
    return statusDefaultMode;
  }

  public StatusLowTraffic getStatusLowTraffic()
  {
    return statusLowTraffic;
  }

  public StatusModerateTraffic getStatusModerateTraffic()
  {
    return statusModerateTraffic;
  }

  public StatusHighTraffic getStatusHighTraffic()
  {
    return statusHighTraffic;
  }

  public boolean lowTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case defaultMode:
        exitStatus();
        setStatus(Status.lowTraffic);
        wasEventProcessed = true;
        break;
      case moderateTraffic:
        exitStatus();
        setStatus(Status.lowTraffic);
        wasEventProcessed = true;
        break;
      case highTraffic:
        exitStatus();
        setStatus(Status.lowTraffic);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean moderateTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case defaultMode:
        exitStatus();
        setStatus(Status.moderateTraffic);
        wasEventProcessed = true;
        break;
      case lowTraffic:
        exitStatus();
        setStatus(Status.moderateTraffic);
        wasEventProcessed = true;
        break;
      case highTraffic:
        exitStatus();
        setStatus(Status.moderateTraffic);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean highTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case defaultMode:
        exitStatus();
        setStatus(Status.highTraffic);
        wasEventProcessed = true;
        break;
      case lowTraffic:
        exitStatus();
        setStatus(Status.highTraffic);
        wasEventProcessed = true;
        break;
      case moderateTraffic:
        exitStatus();
        setStatus(Status.highTraffic);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean defaultMode()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case lowTraffic:
        exitStatus();
        setStatus(Status.defaultMode);
        wasEventProcessed = true;
        break;
      case moderateTraffic:
        exitStatus();
        setStatus(Status.defaultMode);
        wasEventProcessed = true;
        break;
      case highTraffic:
        exitStatus();
        setStatus(Status.defaultMode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;
    
    StatusDefaultMode aStatusDefaultMode = statusDefaultMode;
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    StatusModerateTraffic aStatusModerateTraffic = statusModerateTraffic;
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusDefaultMode)
    {
      case northAndSouthGreen:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.northAndSouthYellow);
        wasEventProcessed = true;
        break;
      case northAndSouthRed:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusLowTraffic)
    {
      case northAndSouthArrow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      case northAndSouthGreen:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.northAndSouthYellow);
        wasEventProcessed = true;
        break;
      case westAndEastGreen:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusModerateTraffic)
    {
      case northGreenAndArrow:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.northYellow);
        wasEventProcessed = true;
        break;
      case southGreenAndArrow:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.southYellow);
        wasEventProcessed = true;
        break;
      case westAndEastGreen:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusHighTraffic)
    {
      case northGreenAndArrow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.northYellow);
        wasEventProcessed = true;
        break;
      case southGreenAndArrow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.southYellow);
        wasEventProcessed = true;
        break;
      case westGreenAndArrow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.westAndEastGreen);
        wasEventProcessed = true;
        break;
      case westAndEastGreen:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;
    
    StatusDefaultMode aStatusDefaultMode = statusDefaultMode;
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    StatusModerateTraffic aStatusModerateTraffic = statusModerateTraffic;
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusDefaultMode)
    {
      case northAndSouthYellow:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.northAndSouthRed);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusLowTraffic)
    {
      case northAndSouthYellow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.westAndEastGreen);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.northAndSouthArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusModerateTraffic)
    {
      case northYellow:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.southGreenAndArrow);
        wasEventProcessed = true;
        break;
      case southYellow:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.westAndEastGreen);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.northGreenAndArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusHighTraffic)
    {
      case northYellow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.southGreenAndArrow);
        wasEventProcessed = true;
        break;
      case southYellow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.westGreenAndArrow);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.northGreenAndArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStatus()
  {
    switch(status)
    {
      case defaultMode:
        exitStatusDefaultMode();
        break;
      case lowTraffic:
        exitStatusLowTraffic();
        break;
      case moderateTraffic:
        exitStatusModerateTraffic();
        break;
      case highTraffic:
        exitStatusHighTraffic();
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case defaultMode:
        if (statusDefaultMode == StatusDefaultMode.Null) { setStatusDefaultMode(StatusDefaultMode.northAndSouthGreen); }
        break;
      case lowTraffic:
        if (statusLowTraffic == StatusLowTraffic.Null) { setStatusLowTraffic(StatusLowTraffic.northAndSouthArrow); }
        break;
      case moderateTraffic:
        if (statusModerateTraffic == StatusModerateTraffic.Null) { setStatusModerateTraffic(StatusModerateTraffic.northGreenAndArrow); }
        break;
      case highTraffic:
        if (statusHighTraffic == StatusHighTraffic.Null) { setStatusHighTraffic(StatusHighTraffic.northGreenAndArrow); }
        break;
    }
  }

  private void exitStatusDefaultMode()
  {
    switch(statusDefaultMode)
    {
      case northAndSouthGreen:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
      case northAndSouthYellow:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
      case northAndSouthRed:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
      case westAndEastYellow:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
    }
  }

  private void setStatusDefaultMode(StatusDefaultMode aStatusDefaultMode)
  {
    statusDefaultMode = aStatusDefaultMode;
    if (status != Status.defaultMode && aStatusDefaultMode != StatusDefaultMode.Null) { setStatus(Status.defaultMode); }

    // entry actions and do activities
    switch(statusDefaultMode)
    {
      case northAndSouthGreen:
        // line 18 "../../TrafficLight.ump"
        trafficLightManager.northGreen();
        // line 19 "../../TrafficLight.ump"
        trafficLightManager.southGreen();
        // line 20 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 21 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        // line 26 "../../TrafficLight.ump"
        trafficLightManager.northYellow();
        // line 27 "../../TrafficLight.ump"
        trafficLightManager.southYellow();
        // line 28 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 29 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRed:
        // line 34 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 35 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 36 "../../TrafficLight.ump"
        trafficLightManager.westGreen();
        // line 37 "../../TrafficLight.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 42 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 43 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 44 "../../TrafficLight.ump"
        trafficLightManager.westYellow();
        // line 45 "../../TrafficLight.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  private void exitStatusLowTraffic()
  {
    switch(statusLowTraffic)
    {
      case northAndSouthArrow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case northAndSouthGreen:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case northAndSouthYellow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case westAndEastGreen:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case westAndEastYellow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
    }
  }

  private void setStatusLowTraffic(StatusLowTraffic aStatusLowTraffic)
  {
    statusLowTraffic = aStatusLowTraffic;
    if (status != Status.lowTraffic && aStatusLowTraffic != StatusLowTraffic.Null) { setStatus(Status.lowTraffic); }

    // entry actions and do activities
    switch(statusLowTraffic)
    {
      case northAndSouthArrow:
        // line 56 "../../TrafficLight.ump"
        trafficLightManager.northArrow();
        // line 57 "../../TrafficLight.ump"
        trafficLightManager.southArrow();
        // line 58 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 59 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthGreen:
        // line 64 "../../TrafficLight.ump"
        trafficLightManager.northGreen();
        // line 65 "../../TrafficLight.ump"
        trafficLightManager.southGreen();
        // line 66 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 67 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        // line 72 "../../TrafficLight.ump"
        trafficLightManager.northYellow();
        // line 73 "../../TrafficLight.ump"
        trafficLightManager.southYellow();
        // line 74 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 75 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreen:
        // line 80 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 81 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 82 "../../TrafficLight.ump"
        trafficLightManager.westGreen();
        // line 83 "../../TrafficLight.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 88 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 89 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 90 "../../TrafficLight.ump"
        trafficLightManager.westYellow();
        // line 91 "../../TrafficLight.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  private void exitStatusModerateTraffic()
  {
    switch(statusModerateTraffic)
    {
      case northGreenAndArrow:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case northYellow:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case southGreenAndArrow:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case southYellow:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case westAndEastGreen:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case westAndEastYellow:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
    }
  }

  private void setStatusModerateTraffic(StatusModerateTraffic aStatusModerateTraffic)
  {
    statusModerateTraffic = aStatusModerateTraffic;
    if (status != Status.moderateTraffic && aStatusModerateTraffic != StatusModerateTraffic.Null) { setStatus(Status.moderateTraffic); }

    // entry actions and do activities
    switch(statusModerateTraffic)
    {
      case northGreenAndArrow:
        // line 102 "../../TrafficLight.ump"
        trafficLightManager.northGreenAndArrow();
        // line 103 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 104 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 105 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case northYellow:
        // line 110 "../../TrafficLight.ump"
        trafficLightManager.northYellow();
        // line 111 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 112 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 113 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenAndArrow:
        // line 118 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 119 "../../TrafficLight.ump"
        trafficLightManager.southGreenAndArrow();
        // line 120 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 121 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case southYellow:
        // line 126 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 127 "../../TrafficLight.ump"
        trafficLightManager.southYellow();
        // line 128 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 129 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreen:
        // line 134 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 135 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 136 "../../TrafficLight.ump"
        trafficLightManager.westGreen();
        // line 137 "../../TrafficLight.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 142 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 143 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 144 "../../TrafficLight.ump"
        trafficLightManager.westYellow();
        // line 145 "../../TrafficLight.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  private void exitStatusHighTraffic()
  {
    switch(statusHighTraffic)
    {
      case northGreenAndArrow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case northYellow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case southGreenAndArrow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case southYellow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case westGreenAndArrow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case westAndEastGreen:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case westAndEastYellow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
    }
  }

  private void setStatusHighTraffic(StatusHighTraffic aStatusHighTraffic)
  {
    statusHighTraffic = aStatusHighTraffic;
    if (status != Status.highTraffic && aStatusHighTraffic != StatusHighTraffic.Null) { setStatus(Status.highTraffic); }

    // entry actions and do activities
    switch(statusHighTraffic)
    {
      case northGreenAndArrow:
        // line 156 "../../TrafficLight.ump"
        trafficLightManager.northGreenAndArrow();
        // line 157 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 158 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 159 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case northYellow:
        // line 164 "../../TrafficLight.ump"
        trafficLightManager.northYellow();
        // line 165 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 166 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 167 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenAndArrow:
        // line 172 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 173 "../../TrafficLight.ump"
        trafficLightManager.southGreenAndArrow();
        // line 174 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 175 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case southYellow:
        // line 180 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 181 "../../TrafficLight.ump"
        trafficLightManager.southYellow();
        // line 182 "../../TrafficLight.ump"
        trafficLightManager.westRed();
        // line 183 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case westGreenAndArrow:
        // line 189 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 190 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 191 "../../TrafficLight.ump"
        trafficLightManager.westGreenAndArrow();
        // line 192 "../../TrafficLight.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreen:
        // line 197 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 198 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 199 "../../TrafficLight.ump"
        trafficLightManager.westGreen();
        // line 200 "../../TrafficLight.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 205 "../../TrafficLight.ump"
        trafficLightManager.northRed();
        // line 206 "../../TrafficLight.ump"
        trafficLightManager.southRed();
        // line 207 "../../TrafficLight.ump"
        trafficLightManager.westYellow();
        // line 208 "../../TrafficLight.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "trafficLightManager" + "=" + (getTrafficLightManager() != null ? !getTrafficLightManager().equals(this)  ? getTrafficLightManager().toString().replaceAll("  ","    ") : "this" : "null");
  }
}