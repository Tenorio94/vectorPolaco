package com.vector_polaco;

/**
 * Created by Tenorio94 on 11/2/2016.
 */
public class VariableObject {

    public String sVariableName;
    public String sFeedback;
    public String sVariableType;
    public Boolean bIsConstant;

    public VariableObject(String sName, String sType, boolean bConstant) {
        sVariableName = sName;
        sVariableType = sType;
        bIsConstant = bConstant;
        sFeedback = "";
    }


    public void VariableObject(){
        sVariableName = "";
        sVariableType = "";
        bIsConstant = true;
        sFeedback = "";
    }
}
